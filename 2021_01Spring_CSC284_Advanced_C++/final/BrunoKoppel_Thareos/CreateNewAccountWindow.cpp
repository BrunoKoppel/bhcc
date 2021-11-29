#include "CreateNewAccountWindow.h"
#include "ui_CreateNewAccountWindow.h"

bool Verbose2 = true;

CreateNewAccountWindow::CreateNewAccountWindow(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::CreateNewAccountWindow)
{
    ui->setupUi(this);
    ui->createAccountButton->setEnabled(false);
}

CreateNewAccountWindow::~CreateNewAccountWindow()
{
    delete ui;
}

void CreateNewAccountWindow::setAdminUser(User newAdmin){
    adminUser = newAdmin;
};

void CreateNewAccountWindow::on_usernameLineEdit_textEdited(const QString &arg1)
{
    username = arg1;
    testToSetCreateAccountButtonEnable();
}

void CreateNewAccountWindow::on_passwordLineEdit_textEdited(const QString &arg1)
{
    password = arg1;
    testToSetCreateAccountButtonEnable();
}

void CreateNewAccountWindow::on_passwordLineEdit_2_textEdited(const QString &arg1)
{
    passwordRepeat = arg1;
    testToSetCreateAccountButtonEnable();
}

void CreateNewAccountWindow::testToSetCreateAccountButtonEnable(){
    if (username != "" && password != "" && passwordRepeat != ""){
        ui->createAccountButton->setEnabled(true);
    }
}

void CreateNewAccountWindow::on_createAccountButton_clicked()
{
    std::string path = QCoreApplication::applicationDirPath().toStdString() + QString("/TD-UsersLogInData.txt").toStdString();
    std::ofstream inputFile(path, std::ios::out | std::ios::binary | std::ios::app );
    bool didDataGotWritten = false;

    if (Verbose2){
        qDebug() << QString::fromStdString(path);
        qDebug() << "Parameters input by User:";
        qDebug() << "UserName: " << username;
        qDebug() << "PassWord: " << password;
        qDebug() << "PassWord: " << passwordRepeat;
    }


    if (!inputFile.fail()){
        if (Verbose2){
            qDebug() << "File Found, Writing to file";
        }

        if (password == passwordRepeat){
            User newUser = User(username, password);
            std::string objectPrintout = newUser.getUsersStringFormat_toSaveUserToFile().toStdString();
            inputFile << objectPrintout.c_str();

            if (Verbose2){
                qDebug() << QString::fromStdString(newUser.getUsersStringFormat_toSaveUserToFile().toStdString()) << ", Size = " << objectPrintout.length();
                qDebug() << "Data Written";
            }

            didDataGotWritten = true;
        } else {
            ui->ErrorLabel->setText("Password is incorrect");
        }
        inputFile.close();
    } else {
        if (Verbose2){
            qDebug() << "File Not Found";
        }
    }

    if (didDataGotWritten){
        this->close();
    }
}

void CreateNewAccountWindow::on_CancelButton_clicked()
{
    this->close();
}
