#include "mainwindow.h"
#include "./ui_mainwindow.h"
#include <QCoreApplication>
#include <QDebug>
#include <QFile>

bool isUserNameFieldPopulated = false;
bool isPassWordFieldPopulated = false;
QString path= QCoreApplication::applicationDirPath() + QString("/loginData.csv");
QFile file(path);

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    ui->appLoginButton->setEnabled(false);
    ui->appCreateAccountButton->setEnabled(false);
//    connect(ui->pushButton, SIGNAL(CLICKED()), SLOT(close()));
//    connect(ui->MainWindow::pushButton, &QPushButton::clicked, this, &QMainWindow::close);


}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_usernameLineEdit_textChanged(const QString &arg1)
{
    if (arg1 != ""){
        isUserNameFieldPopulated = true;
    } else {
        isUserNameFieldPopulated = false;
    }

    ui->appLoginButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
}

void MainWindow::on_passwordLineEdit_textChanged(const QString &arg1)
{
    if (arg1 != ""){
        isPassWordFieldPopulated = true;
    } else {
        isPassWordFieldPopulated = false;
    }

    ui->appLoginButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
    ui->appCreateAccountButton->setEnabled(isUserNameFieldPopulated && isPassWordFieldPopulated);
}

void MainWindow::on_appLoginButton_clicked()
{

}



void MainWindow::on_appCreateAccountButton_clicked()
{
    if(!file.open(QIODevice::WriteOnly)){
            file.close();
        } else {
            QTextStream out(&file);
            out << ui->usernameLineEdit->text();
            out << ui->passwordLineEdit->text();
            file.close();
        }
}


void MainWindow::on_actionExit_triggered()
{
    MainWindow::close();
}

void MainWindow::testButtonFunc()
{
    QPushButton* buttonSender = qobject_cast<QPushButton*>(sender()); // retrieve the button you have clicked
    QString buttonText = buttonSender->text(); // retrive the text from the button clicked
}
