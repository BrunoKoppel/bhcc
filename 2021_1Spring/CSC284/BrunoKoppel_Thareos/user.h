#ifndef USER_H
#define USER_H

#include <QString>
#include <QRegExp>
#include <QDebug>

class User
{
public:
    User();
    User(QString newUsername, QString newPassword, int newUserClass, bool isAdminSwitch);

    User generateUserFromLoginData(QString lineFromFile);
    void debugUser();

    void setUserName(QString newUsername);
    void setPassWord(QString newPassword);
    void setUserClass(int newUserClass);
    void setIsAdmin(bool isAdminSwitch);

    QString getUserName();
    QString getPassWord();
    int getUserClass();
    bool getIsAdmin();


private:
    QString username;
    QString password;
    int userClass;
    bool isAdmin;
};

#endif // USER_H
