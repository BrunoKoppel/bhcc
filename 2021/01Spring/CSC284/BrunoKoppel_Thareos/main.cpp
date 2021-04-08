#include "loginwindow.h"
#include "checklistwindow.h"
#include "user.h"
#include <QApplication>
#include <QDebug>
#include <QString>

User adminUser("SuperAdmin", "#Ko", 10, true);
QString userLoggedIn = "";

void startApplication(QString user);
QString startLogInProcess();
QString whichUserIsLoggedIn();


int main(int argc, char *argv[])
{
    QApplication a(argc, argv);

//    if (userLoggedIn == ""){
//        userLoggedIn = startLogInProcess();
//        qDebug() << "User in main is: " << userLoggedIn;
//    }

    qDebug() << "Hello from here";

//    startApplication(userLoggedIn);
    startApplication("Bruno");

    return a.exec();

}

QString startLogInProcess(){
    LoginWindow login;
    login.setAdminUser(adminUser);
    login.setModal(true);
    login.exec();
    return login.userLoggedIn;
}

void startApplication(QString user){
    qDebug() << "Starting application for user: " << user;
    CheckListWindow app;
    app.setUserLoggedIn(user);
    app.show();
}
