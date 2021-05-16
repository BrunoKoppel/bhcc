#include "user.h"

bool Verbose3 = true;

User::User()
{
    username = "";
    password = "";
    userClass = 0;
    isAdmin = false;
    errorDescription = "";
}

User::User(QString error)
{
    username = "";
    password = "";
    userClass = 0;
    isAdmin = false;
    errorDescription = error;
}

User::User(QString newUsername, QString newPassword, int newUserClass, bool isAdminSwitch)
{
    this->username = newUsername;
    this->password = newPassword;
    this->userClass = newUserClass;
    this->isAdmin = isAdminSwitch;
}

User::User(QString newUsername, QString newPassword)
{
    this->username = newUsername;
    this->password = newPassword;
    this->userClass = 0;
    this->isAdmin = false;
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

void User::setErrorDescription(QString newErrorDescription){
    this->errorDescription = newErrorDescription;
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

QString User::getErrorDescription(){
    return errorDescription;
}


void User::debugUser(){
    qDebug() << this->getUserName();
    qDebug() << this->getPassWord();
    qDebug() << this->getUserClass();
    qDebug() << this->getIsAdmin();
}


QString User::getUsersStringFormat_toSaveUserToFile(){
    return getUserName() + "//" + getPassWord() + "//" + QString::number(getUserClass()) + "//" + QString::number(getIsAdmin()) + "\n";
}

User User::getUserFromLoginDataFile(QString username, QString password){
    QString path = QCoreApplication::applicationDirPath() + QString("/TD-UsersLogInData.txt");
    QFile inputFile(path);
    if (Verbose3){
        qDebug() << path;
        qDebug() << "Parameters input by User:";
        qDebug() << username;
        qDebug() << password;
    }


    QString errorDescription = "";
    bool isErrorOnPassword = true;

    if (inputFile.open(QIODevice::ReadOnly)){
        if (Verbose3){
            qDebug() << "File Found, Reading File Contents...";
        }

        QTextStream in(&inputFile);

        while (!in.atEnd()){
            QString line = in.readLine();

            if(Verbose3){
                qDebug() << "Line => " << line;
            }

            User newUser = getUserFromParsedString(line);
            if (newUser.getUserName() == username){
                if (password == ""){
                    return newUser;
                } else if (newUser.getPassWord() == password){
                    return newUser;
                } else {
                    errorDescription = "Password is incorrect";
                }
            }
        }

        if (errorDescription == ""){
            errorDescription = "User not found!";
        }

        if (Verbose3) {
            qDebug() << "Reached end of user search, No User matched credentials";
        }
        inputFile.close();
    } else {
        if (Verbose3){
            qDebug() << "File Not Found";
        }
    }

    return User(errorDescription);
}


QList<User> User::getAllUsersFromLoginDataFile(){
    QString path = QCoreApplication::applicationDirPath() + QString("/TD-UsersLogInData.txt");
    QFile inputFile(path);
    if (Verbose3){
        qDebug() << path;
        qDebug() << "Parameters input by User:";
        qDebug() << username;
        qDebug() << password;
    }

    QList<User> allUsers;
    bool isErrorOnPassword = true;

    if (inputFile.open(QIODevice::ReadOnly)){
        if (Verbose3){
            qDebug() << "File Found, Reading File Contents...";
        }

        QTextStream in(&inputFile);

        while (!in.atEnd()){
            QString line = in.readLine();

            if(Verbose3){
                qDebug() << "Line => " << line;
            }

            User newUser = getUserFromParsedString(line);
            allUsers.append(newUser);
        }


        if (Verbose3) {
            qDebug() << "Reached end of user search, No User matched credentials";
        }
        inputFile.close();
    } else {
        if (Verbose3){
            qDebug() << "File Not Found";
        }
    }

    return allUsers;
}

User User::getUserFromParsedString(QString lineFromFile){
    QRegExp rx("[//]");
    QStringList list = lineFromFile.split(rx, QString::SkipEmptyParts);
    if (Verbose3){
        qDebug() << "Data received for user:";
        qDebug() << list.at(0) << ", " << list.at(1) << ", " << list.at(2).toInt() << ", " << list.at(3).toInt();
    }

    User newUser(list.at(0),list.at(1),list.at(2).toInt(),list.at(3).toInt());
    if (Verbose3){
        qDebug() << "User just created";
    }

    return newUser;
}
