#include "mainWindow.h"
#include "ui_mainwindow.h"
#include "user.h"
#include <QCoreApplication>
#include <QDebug>
#include <QFile>

bool isUserNameFieldPopulated = false;
bool isPassWordFieldPopulated = false;
User adminUser("Admin", "123", 10, true);

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow){
    ui->setupUi(this);
    ui->appLoginButton->setEnabled(false);
    ui->appCreateAccountButton->setEnabled(false);
//    connect(ui->pushButton, SIGNAL(CLICKED()), SLOT(close()));
//    connect(ui->MainWindow::pushButton, &QPushButton::clicked, this, &QMainWindow::close);
}

MainWindow::~MainWindow(){
    delete ui;
}

void MainWindow::on_usernameLineEdit_textChanged(const QString &arg1){
    if (arg1 != ""){
        isUserNameFieldPopulated = true;
    } else {
        isUserNameFieldPopulated = false;
    }

    ui->appLoginButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
}

void MainWindow::on_passwordLineEdit_textChanged(const QString &arg1){
    if (arg1 != ""){
        isPassWordFieldPopulated = true;
    } else {
        isPassWordFieldPopulated = false;
    }

    ui->appLoginButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
    ui->appCreateAccountButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
}

void MainWindow::on_appLoginButton_clicked(){
    ReadAccountFromDataFile(ui->usernameLineEdit->text(), ui->passwordLineEdit->text());
}


void MainWindow::on_appCreateAccountButton_clicked(){
    AddAccountToDataFile(ui->usernameLineEdit->text(), ui->passwordLineEdit->text(), 0, false);
}



/*
ReadAccountFromDataFile

This function takes the username and password as parameters from the app and logs the user into the app
*/

void MainWindow::ReadAccountFromDataFile(QString username, QString password){
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
           User newUser = adminUser.generateUserFromLoginData(line);

           qDebug() << "User just created accessed from mainWindow";
           newUser.debugUser();
       }

       qDebug() << "No User Found";
       inputFile.close();
    } else {
       qDebug() << "File Not Found";
    }
}



/*
AddAccountToDataFile

Adds the username and password into the log file as a new account
*/

void MainWindow::AddAccountToDataFile(QString username, QString password, int userLevel, bool isAdmin){
    QString path = QCoreApplication::applicationDirPath() + QString("/loginData.txt");
    QFile file(path);
    int isAdminCode;
    isAdmin ? isAdminCode = 1 : isAdminCode = 0;
    qDebug() << path;
    if(!file.open(QIODevice::WriteOnly | QIODevice::Append | QIODevice::Text)){
        qDebug() << "File not created";
        file.close();
    } else {
        QTextStream out(&file);
        out << username << ",";
        out << password << ",";
        out << userLevel << ",";
        out << isAdminCode;
        out << "\n";
        qDebug() << "File Created";
        file.close();
    }
}


void MainWindow::on_actionExit_triggered(){
    MainWindow::close();
}


void MainWindow::testButtonFunc(){
    QPushButton* buttonSender = qobject_cast<QPushButton*>(sender()); // retrieve the button you have clicked
    QString buttonText = buttonSender->text(); // retrive the text from the button clicked
}
