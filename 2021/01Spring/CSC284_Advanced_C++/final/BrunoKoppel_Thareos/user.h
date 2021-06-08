#ifndef USER_H
#define USER_H

#include <QString>
#include <QCoreApplication>
#include <QDebug>
#include <QDialog>
#include <QString>
#include <QFile>

class User
{
private:
    QString username;
    QString password;
    int userClass;
    bool isAdmin;
    QString errorDescription;

public:
    User();
    User(QString error);
    User(QString newUsername, QString newPassword);
    User(QString newUsername, QString newPassword, int newUserClass, bool isAdminSwitch);

    void debugUser();

    void setUserName(QString newUsername);
    void setPassWord(QString newPassword);
    void setUserClass(int newUserClass);
    void setIsAdmin(bool isAdminSwitch);
    void setErrorDescription(QString newErrorDescription);

    QString getUserName();
    QString getPassWord();
    int getUserClass();
    bool getIsAdmin();
    QString getErrorDescription();

    User getUserFromParsedString(QString lineContents);
    QString getUsersStringFormat_toSaveUserToFile();
    User getUserFromLoginDataFile(QString username, QString password);
    QList<User> getAllUsersFromLoginDataFile();
};

class Admin : public User {
private:

public:
    Admin(QString newUsername, QString newPassword, int newUserClass, bool isAdminSwitch);
};

#endif // USER_H
