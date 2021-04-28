#include "CreateNewAccountWindow.h"
#include "ui_CreateNewAccountWindow.h"

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
    QString path = QCoreApplication::applicationDirPath() + QString("/loginData.txt");
    QFile inputFile(path);
    qDebug() << path;
    qDebug() << "Parameters input by User:";
    qDebug() << username;
    qDebug() << password;
    qDebug() << passwordRepeat;

    if (inputFile.open(QIODevice::WriteOnly | QIODevice::Append)){
       qDebug() << "File Found, Writing to file";
       if (password == passwordRepeat){
            User newUser = User(username, password);
            inputFile.Append();
       } else {
           ui->ErrorLabel->setText("Password is incorrect");
       }

       qDebug() << "Reached end of file writing";
       inputFile.close();
    } else {
       qDebug() << "File Not Found";

    }
}
