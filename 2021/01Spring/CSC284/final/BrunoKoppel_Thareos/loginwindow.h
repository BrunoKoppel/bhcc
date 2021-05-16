#ifndef LOGINWINDOW_H
#define LOGINWINDOW_H

#include "CreateNewAccountWindow.h"
#include "user.h"
#include <QDialog>
#include <QString>
#include <QDebug>
#include <QFile>

namespace Ui {
class LoginWindow;
}

class LoginWindow : public QDialog
{
    Q_OBJECT

public:
    explicit LoginWindow(QWidget *parent = nullptr);
    void setAdminUser(User newAdmin);
    void setLastUserLoggedIn(User lastUser);
    User getLastUserLoggedIn();
    void setUserLoggedIn(User newUserLoggedIn);
    User getUserLoggedIn();
    ~LoginWindow();

private slots:
    void on_usernameLineEdit_textChanged(const QString &arg1);
    void on_passwordLineEdit_textChanged(const QString &arg1);
    void on_createAccountButton_clicked();
    void on_LoginButton_clicked();

private:
    Ui::LoginWindow *ui;
    User adminUser;
    User userLoggedIn;
};

#endif // LOGINWINDOW_H
