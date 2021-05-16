#include "loginwindow.h"
#include "ui_loginwindow.h"

bool Verbose1 = true;
bool isUserNameFieldPopulated = false;
bool isPassWordFieldPopulated = false;
bool errorLabelChanged = false;

LoginWindow::LoginWindow(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::LoginWindow){
    ui->setupUi(this);
    ui->LoginButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
    this->userLoggedIn = getLastUserLoggedIn();
}

LoginWindow::~LoginWindow(){
    delete ui;
}

void LoginWindow::setLastUserLoggedIn(User lastUser){
    std::string path = QCoreApplication::applicationDirPath().toStdString() + QString("/TD-LastUserLoggedIn.txt").toStdString();
    std::ofstream inputFile(path, std::ios::out | std::ios::binary | std::ios::app);

    if (Verbose1){
        qDebug() << QString::fromStdString(path);
        qDebug() << "lastUser: " << lastUser.getUserName();
    }


    if (!inputFile.fail()){
        std::string objectPrintout = lastUser.getUserName().toStdString();
        inputFile.write(objectPrintout.c_str(), objectPrintout.length());

        if (Verbose1){
            qDebug() << "File Found, Writing to file";
            qDebug() << QString::fromStdString(objectPrintout) << ", Size = " << objectPrintout.length();
            qDebug() << "Data Written";
        }

        inputFile.close();

    } else {
        if (Verbose1) {
            qDebug() << "File Not Found";
        }
    }
}

void LoginWindow::setUserLoggedIn(User newUserLoggedIn){
    this->userLoggedIn = newUserLoggedIn;
    setLastUserLoggedIn(newUserLoggedIn);
}

User LoginWindow::getUserLoggedIn(){
    return this->userLoggedIn;
}

User LoginWindow::getLastUserLoggedIn(){
    QString pathForLastUserLoggedIn = QCoreApplication::applicationDirPath() + QString("/TD-LastUserLoggedIn.txt");

    QFile inputFile(pathForLastUserLoggedIn);
    QString lastUserLoggedIn;

    if (Verbose1){
        qDebug() << pathForLastUserLoggedIn;
    }


    if (inputFile.open(QIODevice::ReadOnly)){
        if (Verbose1){
            qDebug() << "File Found, Reading File Contents...";
        }

        QTextStream in(&inputFile);

        while (!in.atEnd()){
            lastUserLoggedIn = in.readLine();
            if (Verbose1){
                qDebug() << "Line => " << lastUserLoggedIn;
            }
        }

        if (Verbose1){
            qDebug() << "Reached end of user search, No User matched credentials";
        }

        inputFile.close();
    } else {
        if (Verbose1){
            qDebug() << "File Not Found";
        }
    }

    return adminUser.getUserFromLoginDataFile(lastUserLoggedIn, "");
}

void LoginWindow::setAdminUser(User newAdmin){
    adminUser = newAdmin;
};

void LoginWindow::on_LoginButton_clicked(){
    User newUser = adminUser.getUserFromLoginDataFile(ui->usernameLineEdit->text(), ui->passwordLineEdit->text());
    if (newUser.getErrorDescription() != ""){
        ui->ErrorLabel->setText(newUser.getErrorDescription());
    }

    if (newUser.getUserName() != ""){
        setUserLoggedIn(newUser);
        this->close();
    }
}

void LoginWindow::on_createAccountButton_clicked(){
    CreateNewAccountWindow newAccountWindow;
    newAccountWindow.setAdminUser(adminUser);
    newAccountWindow.setModal(true);
    newAccountWindow.exec();
}

void LoginWindow::on_usernameLineEdit_textChanged(const QString &arg1){
    if (arg1 != ""){
        isUserNameFieldPopulated = true;
    } else {
        isUserNameFieldPopulated = false;
    }

    ui->LoginButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
}

void LoginWindow::on_passwordLineEdit_textChanged(const QString &arg1){
    if (arg1 != ""){
        isPassWordFieldPopulated = true;
    } else {
        isPassWordFieldPopulated = false;
    }

    ui->LoginButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
}



