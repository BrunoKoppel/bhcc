#include "user.h"

User::User()
{
    username = "";
    password = "";
    userClass = 0;
    isAdmin = false;
}

User::User(QString newUsername, QString newPassword, int newUserClass, bool isAdminSwitch)
{
    this->username = newUsername;
    this->password = newPassword;
    this->userClass = newUserClass;
    this->isAdmin = isAdminSwitch;
}

User User::generateUserFromLoginData(QString lineFromFile){
    QRegExp rx("[,]");// match a comma
    QStringList list = lineFromFile.split(rx, QString::SkipEmptyParts);
    User newUser(list.at(0),list.at(1),list.at(2).toInt(),list.at(3).toInt());
    newUser.debugUser();
    return newUser;
}

void User::setUserName(QString newUsername){
    this->username = newUsername;
}

void User::setPassWord(QString newPassword){
    this->password = newPassword;
}
void User::setUserClass(int newUserClass){
    this->userClass = newUserClass;
}
void User::setIsAdmin(bool isAdminSwitch){
    this->isAdmin = isAdminSwitch;
}

QString User::getUserName(){
    return username;
}

QString User::getPassWord(){
    return password;
}

int User::getUserClass(){
    return userClass;
}

bool User::getIsAdmin(){
    return isAdmin;
}

void User::debugUser(){
    qDebug() << this->getUserName();
    qDebug() << this->getPassWord();
    qDebug() << this->getUserClass();
    qDebug() << this->getIsAdmin();
}
