#include "loginwindow.h"
#include "ui_loginwindow.h"

bool isUserNameFieldPopulated = false;
bool isPassWordFieldPopulated = false;

LoginWindow::LoginWindow(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::LoginWindow){
    ui->setupUi(this);
    ui->LoginButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
}

LoginWindow::~LoginWindow(){
    delete ui;
}

void LoginWindow::setAdminUser(User newAdmin){
    adminUser = newAdmin;
};

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

void LoginWindow::on_LoginButton_clicked(){
    User newUser = readAccountFromDataFile(ui->usernameLineEdit->text(), ui->passwordLineEdit->text());
    userLoggedIn = newUser.getUserName();
    if (userLoggedIn != ""){
        this->close();
    } else {

    }
}



/*
ReadAccountFromDataFile

This function takes the username and password as parameters from the app and logs the user into the app
*/

User LoginWindow::readAccountFromDataFile(QString username, QString password){
    QString path = QCoreApplication::applicationDirPath() + QString("/loginData.txt");
    QFile inputFile(path);
    qDebug() << path;
    qDebug() << "Parameters input by User:";
    qDebug() << username;
    qDebug() << password;

    if (inputFile.open(QIODevice::ReadOnly)){
       qDebug() << "File Found, Reading File Contents";
       QTextStream in(&inputFile);
       while (!in.atEnd()){
           QString line = in.readLine();
           qDebug() << "file contents: \t\t" << line;
           User newUser = generateUserFromLoginData(line);
           if (newUser.getUserName() == username && newUser.getPassWord() == password){
               qDebug() << "user is the same as credentials entered";
               return newUser;
           }
       }

       qDebug() << "No User Found";
       inputFile.close();
    } else {
       qDebug() << "File Not Found";
    }
    return User();
}

User LoginWindow::generateUserFromLoginData(QString lineFromFile){
    QRegExp rx("[,]");
    QStringList list = lineFromFile.split(rx, QString::SkipEmptyParts);
    qDebug() << "Data received for user:";
    qDebug() << list.at(0) << ", " << list.at(1) << ", " << list.at(2).toInt() << ", " << list.at(3).toInt() ;

    User newUser(list.at(0),list.at(1),list.at(2).toInt(),list.at(3).toInt());
    qDebug() << "User just created";
    return newUser;
}
