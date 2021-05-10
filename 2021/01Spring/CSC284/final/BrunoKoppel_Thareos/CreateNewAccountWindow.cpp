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
    bool didDataGotWritten = false;
    qDebug() << path;
    qDebug() << "Parameters input by User:";
    qDebug() << "UserName: " << username;
    qDebug() << "PassWord: " << password;
    qDebug() << "PassWord: " << passwordRepeat;

    if (inputFile.open(QIODevice::WriteOnly | QIODevice::Append)){
       qDebug() << "File Found, Writing to file";
       if (password == passwordRepeat){
            User newUser = User(username, password);
            qDebug() << QString::fromStdString(newUser.getStringToSaveUserToFile().toStdString());
            QByteArray userData = QByteArray::fromStdString(newUser.getStringToSaveUserToFile().toStdString());
            inputFile.write(userData.constData());
            qDebug() << "Data Written";
            didDataGotWritten = true;
       } else {
           ui->ErrorLabel->setText("Password is incorrect");
       }
       inputFile.close();
    } else {
       qDebug() << "File Not Found";
    }

    if (didDataGotWritten){
        this->close();
    }
}

void CreateNewAccountWindow::on_CancelButton_clicked()
{
    this->close();
}
