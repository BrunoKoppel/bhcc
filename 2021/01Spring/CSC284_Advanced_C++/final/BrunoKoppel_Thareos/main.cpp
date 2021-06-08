#include "loginwindow.h"
#include "checklistwindow.h"
#include "user.h"
#include <QApplication>
#include <QDebug>
#include <QString>

Admin adminUser("SuperAdmin", "#Ko", 10, true);
User userLoggedIn;

QString startLogInProcess();
QString whichUserIsLoggedIn();


int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
//    bool MachineState = true;

    LoginWindow login;

    login.setAdminUser(adminUser);
    userLoggedIn = login.getUserLoggedIn();
    if (userLoggedIn.getUserName() == ""){
        login.exec();
        userLoggedIn = login.getUserLoggedIn();
        login.~LoginWindow();
    }

    if (userLoggedIn.getUserName() == ""){
        return 1;
    }

    qDebug() << userLoggedIn.getUserName() << " just logged in!";

    CheckListWindow app;
    app.setUserLoggedIn(userLoggedIn);
    app.setNewAdmin(adminUser);
    app.show();
    app.loadAllTasksIntoUIFromUser(userLoggedIn.getUserName());
    if (app.getIfUserLoggedOut()){
        login.exec();
    }


//    while(MachineState){
//        LoginWindow login;

//        login.setAdminUser(adminUser);
//        userLoggedIn = login.userLoggedIn;
//        if (userLoggedIn == ""){
//            login.exec();
//            userLoggedIn = login.userLoggedIn;
//            login.~LoginWindow();
//        }

//        if (userLoggedIn == ""){
//            return 1;
//        }

//        qDebug() << userLoggedIn << " just logged in!";
//        CheckListWindow app;
//        app.setUserLoggedIn(userLoggedIn);
//        app.show();
//    }

    return a.exec();
}
