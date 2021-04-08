#include "loginwindow.h"
#include "user.h"
#include <QApplication>
#include <QDebug>
#include <QString>

User adminUser("Admin", "123", 10, true);
QString userLoggedIn = "";

void startApplication(QString user);
QString startLogInProcess();
QString whichUserIsLoggedIn();


int main(int argc, char *argv[])
{
    QApplication a(argc, argv);

    if (userLoggedIn == ""){
        userLoggedIn = startLogInProcess();
    }

    startApplication(userLoggedIn);

    return a.exec();

}

QString startLogInProcess(){
    LoginWindow login;
    login.setModal(true);
    login.exec();
    return login.userLoggedIn;
}

void startApplication(QString user){

}
