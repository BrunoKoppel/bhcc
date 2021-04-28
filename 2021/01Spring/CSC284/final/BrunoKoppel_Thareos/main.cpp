#include "loginwindow.h"
#include "checklistwindow.h"
#include "user.h"
#include <QApplication>
#include <QDebug>
#include <QString>

User adminUser("SuperAdmin", "#Ko", 10, true);
QString userLoggedIn = "";

QString startLogInProcess();
QString whichUserIsLoggedIn();


int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    userLoggedIn = startLogInProcess();

    if (userLoggedIn == ""){
        return 1;
    }

    qDebug() << userLoggedIn << " just logged in!";
    CheckListWindow app;
    app.setUserLoggedIn(userLoggedIn);
    app.show();
    return a.exec();
}

QString startLogInProcess(){
    LoginWindow login;
    login.setAdminUser(adminUser);
    login.setModal(true);
    login.exec();
    return login.userLoggedIn;
}
