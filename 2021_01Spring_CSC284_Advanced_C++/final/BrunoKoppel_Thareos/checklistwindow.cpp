#include "checklistwindow.h"
#include "ui_checklistwindow.h"
#include "thewidgetitem.h"

bool Verbose = true;

QString operator^(QString taskList, QString newSegment) {
   return taskList + newSegment;
}

CheckListWindow::CheckListWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::CheckListWindow){
    ui->setupUi(this);
    ui->errorAnnouncerLabel->setText("");
    ui->addTaskButton->setEnabled(false);
    ui->deleteTaskButton->setEnabled(false);
    ui->goToUserProfileButton->setEnabled(false);
    ui->taskDateTimeEdit->setDateTime(QDateTime::currentDateTime());
    setIfUserLoggedOut(false);
    taskData.append("");
    taskData.append("");
    taskData.append("");
}

CheckListWindow::~CheckListWindow(){
    delete ui;
}



// Setters and Getters!!

void CheckListWindow::setUserLoggedIn(User newUser){
    this->userLoggedIn = newUser;
    ui->userGreeting->setText("Logged in as " + userLoggedIn.getUserName());
    setIfUserLoggedOut(false);
}

void CheckListWindow::setLastUserLoggedIn(QString lastUser){
    std::string path = QCoreApplication::applicationDirPath().toStdString() + QString("/TD-LastUserLoggedIn.txt").toStdString();
    std::remove(path.c_str());
    std::ofstream outputFile(path, std::ios::out | std::ios::binary | std::ios::trunc);
    bool didDataGotWritten = false;
    if (Verbose){
        qDebug() << QString::fromStdString(path);
        qDebug() << "lastUser: " << lastUser;
    }

    if (!outputFile.fail()){
        std::string objectPrintout = lastUser.toStdString();
        if (Verbose){
            qDebug() << "File Found, Writing to file";
            qDebug() << QString::fromStdString(objectPrintout) << ", Size = " << objectPrintout.length();
        }

        if (lastUser != ""){
            outputFile << objectPrintout.c_str();
            if (Verbose){
                qDebug() << "Data Written";
            }
        }

        outputFile.close();
    } else {
        if (Verbose){
            qDebug() << "File Not Found";
        }
    }
}

void CheckListWindow::setIfUserLoggedOut(bool condition){
    this->didUserLoggedOut = condition;
}

void CheckListWindow::setNewTaskContents(QString contents){
    this->newTaskContents = contents;
}

void CheckListWindow::setnewDateTimeContents(QDateTime contents){
    this->newDateTimeContents = contents;
}


User CheckListWindow::getUserLoggedIn(){
    return this->userLoggedIn;
}

QString CheckListWindow::getLastUserLoggedIn(){
    return this->getLastUserLoggedIn();
}

QString CheckListWindow::getNewTaskContents(){
    return this->newTaskContents;
}

QDateTime CheckListWindow::getNewDateTimeContents(){
    return this->newDateTimeContents;
}

bool CheckListWindow::getIfUserLoggedOut(){
    return this->didUserLoggedOut;
}



// Methods!!

void CheckListWindow::loadAllTasksIntoUIFromUser(QString usernameOnScreen){
    taskData[0] = "";
    taskData[1] = "";
    taskData[2] = "";

    QString path = QCoreApplication::applicationDirPath() + QString("/TD-UsersTaskData.txt");
    QFile inputFile(path);
    if(Verbose){
        qDebug() << path;
    }

    bool isErrorOnPassword = true;

    if (inputFile.open(QIODevice::ReadOnly)){
        if (Verbose){
            qDebug() << "File Found, Reading File Contents...";
            qDebug() << "User logged in = " << usernameOnScreen;
        }

        QTextStream in(&inputFile);

        int i = 0;
        while (!in.atEnd()){
            QString line = in.readLine();

            if (Verbose){
                qDebug() << "Line => " << line;
            }

            QRegExp rx("[//]");
            QStringList list = line.split(rx, QString::SkipEmptyParts);

            if (Verbose){
                qDebug() << "Data received for task: ---- Creating Task";
                qDebug() << list.at(0) << ", " << list.at(1) << ", " << list.at(2) << ", " << list.at(3);
            }

            if (usernameOnScreen == list.at(3)){
                i++;
                taskData[0] = taskData[0] ^ (list.at(0) + "     " + list.at(1) + "\n");
                taskData[1] = taskData[1] ^ (list.at(2) + "\n");
                taskData[2] = taskData[2] ^ (list.at(3) + "\n");
            }


            if (Verbose){
                qDebug() << "task from list just added";
            }
        }

        ui->taskNameList->setText(taskData[0]);
        ui->taskDateList->setText(taskData[1]);
        ui->taskOwnerList->setText(taskData[2]);

        if (Verbose){
            qDebug() << "Reach end of file reading";
        }

        inputFile.close();
    } else {
        if (Verbose){
            qDebug() << "File Not Found";
        }
    }
}

void CheckListWindow::loadAllTasksFromAllUsers(User userLoggedIn){
    QList<User> allUsers = admin.getAllUsersFromLoginDataFile();
    taskData[0] = "";
    taskData[1] = "";
    taskData[2] = "";

    QString path = QCoreApplication::applicationDirPath() + QString("/TD-UsersTaskData.txt");
    QFile inputFile(path);
    if(Verbose){
        qDebug() << path;
    }

    bool isErrorOnPassword = true;

    if (inputFile.open(QIODevice::ReadOnly)){
        if (Verbose){
            qDebug() << "File Found, Reading File Contents...";
            qDebug() << "User logged in = " << userLoggedIn.getUserName();
        }

        QTextStream in(&inputFile);

        int i = 0;
        while (!in.atEnd()){
            QString line = in.readLine();

            //            if (Verbose){
            //                qDebug() << "Line => " << line;
            //            }

            QRegExp rx("[//]");
            QStringList list = line.split(rx, QString::SkipEmptyParts);

            //            if (Verbose){
            //                qDebug() << "Data received for task: ---- Creating Task";
            //                qDebug() << list.at(0) << ", " << list.at(1) << ", " << list.at(2) << ", " << list.at(3);
            //            }

            int userClass = 0;
            for (int i = 0; i < allUsers.size(); i++){
                if (allUsers[i].getUserName() == list.at(3)){
                    userClass = allUsers[i].getUserClass();
                }
            }

            if (userLoggedIn.getUserClass() >= userClass){
                i++;
                taskData[0] = taskData[0] ^ (list.at(0) + "     " + list.at(1) + "\n");
                taskData[1] = taskData[1] ^ (list.at(2) + "\n");
                taskData[2] = taskData[2] ^ (list.at(3) + "\n");
            }


            if (Verbose){
                qDebug() << "task from list just added";
            }
        }

        ui->taskNameList->setText(taskData[0]);
        ui->taskDateList->setText(taskData[1]);
        ui->taskOwnerList->setText(taskData[2]);

        if (Verbose){
            qDebug() << "Reach end of file reading";
        }

        inputFile.close();
    } else {
        if (Verbose){
            qDebug() << "File Not Found";
        }
    }
}

void CheckListWindow::setNewAdmin(User newAdmin){
    this->admin = newAdmin;
}


// Slots!!

void CheckListWindow::on_addTaskButton_clicked(){
    QString taskName = ui->commandInputEdit->text();
    QString taskDueDateTime = ui->taskDateTimeEdit->dateTime().toString();

    ui->commandInputEdit->setText("");
    ui->taskDateTimeEdit->setDateTime(QDateTime::currentDateTime());

    QString newFileContent = "";
    QString pathToRead = QCoreApplication::applicationDirPath() + QString("/TD-UsersTaskData.txt");
    QFile inputFile(pathToRead);

    int i = 0;
    if(Verbose){
        qDebug() << pathToRead;
    }

    if (inputFile.open(QIODevice::ReadOnly)){
        if (Verbose){
            qDebug() << "File Found, Reading File Contents...";
            qDebug() << "User logged in = " << getUserLoggedIn().getUserName();
        }

        QTextStream in(&inputFile);


        while (!in.atEnd()){
            QString line = in.readLine();

            if (Verbose){
                qDebug() << "Line => " << line;
            }

            QRegExp rx("[//]");
            QStringList list = line.split(rx, QString::SkipEmptyParts);

            if (Verbose){
                qDebug() << "Data received for task deletion:";
                qDebug() << list.at(0) << ", " << list.at(1) << ", " << list.at(2) << ", " << list.at(3);
            }

            if (getUserLoggedIn().getUserName() != list.at(3)){
                newFileContent = newFileContent + line + "\n";
            } else {
                i = list.at(0).toInt();
                newFileContent = newFileContent + line + "\n";
            }
        }

        if (Verbose){
            qDebug() << "Reach end of file reading";
        }

        inputFile.close();
    } else {
        if (Verbose){
            qDebug() << "File Not Found";
        }
    }



    std::string pathToWrite = QCoreApplication::applicationDirPath().toStdString() + QString("/TD-UsersTaskData.txt").toStdString();
    std::remove(pathToWrite.c_str());
    std::ofstream outputFile(pathToWrite, std::ios::out | std::ios::binary | std::ios::trunc);

    QString output = QString::number(i + 1) + "//" + taskName + "//" + taskDueDateTime + "//" + getUserLoggedIn().getUserName();
    newFileContent = newFileContent + output;
    if (!outputFile.fail()){
        if (Verbose){
            qDebug() << "File Found, Writing to file";
            qDebug() << newFileContent << ", Size = " << newFileContent.length();
        }

        outputFile << newFileContent.toStdString().c_str();
        if (Verbose){
            qDebug() << "Data Written";
        }

        outputFile.close();
    } else {
        if (Verbose){
            qDebug() << "File Not Found";
        }
    }

    ui->commandInputEdit->setText("");
    loadAllTasksIntoUIFromUser(userLoggedIn.getUserName());
}

void CheckListWindow::on_taskDateTimeEdit_dateTimeChanged(const QDateTime &dateTime){
    newDateTimeContents = dateTime;
    if (newTaskContents != ""){
        ui->addTaskButton->setEnabled(true);
    }
}

void CheckListWindow::on_actionLog_Out_triggered(){
    this->setLastUserLoggedIn("");
    this->setIfUserLoggedOut(true);
    this->close();
}

void CheckListWindow::on_deleteTaskButton_clicked(){
    int taskNumber = ui->commandInputEdit->text().toInt();

    QString message = "Task not found!";
    QString newFileContent = "";
    QString pathToRead = QCoreApplication::applicationDirPath() + QString("/TD-UsersTaskData.txt");
    QFile inputFile(pathToRead);
    if(Verbose){
        qDebug() << pathToRead;
    }

    if (inputFile.open(QIODevice::ReadOnly)){
        if (Verbose){
            qDebug() << "File Found, Reading File Contents...";
            qDebug() << "User logged in = " << getUserLoggedIn().getUserName();
        }

        QTextStream in(&inputFile);

        int i = 0;
        while (!in.atEnd()){
            QString line = in.readLine();

            if (Verbose){
                qDebug() << "Line => " << line;
            }

            QRegExp rx("[//]");
            QStringList list = line.split(rx, QString::SkipEmptyParts);

            if (Verbose){
                qDebug() << "Data received for task deletion:";
                qDebug() << list.at(0) << ", " << list.at(1) << ", " << list.at(2) << ", " << list.at(3);
            }

            if (getUserLoggedIn().getUserName() != list.at(3)){
                qDebug() << "leaving line alone";
                newFileContent = newFileContent + line + "\n";
            } else {
                qDebug() << taskNumber << " " << i << " " << list.at(0);
                if (taskNumber != list.at(0).toInt()){
                    i++;
                    newFileContent = newFileContent + QString::number(i) + "//" + list.at(1) + "//" + list.at(2) + "//" + list.at(3) + "\n";
                } else {
                    message = "";
                }
            }
        }

        if (Verbose){
            qDebug() << "Reach end of file reading";
        }

        inputFile.close();
    } else {
        if (Verbose){
            qDebug() << "File Not Found";
        }
    }



    std::string pathToWrite = QCoreApplication::applicationDirPath().toStdString() + QString("/TD-UsersTaskData.txt").toStdString();
    std::remove(pathToWrite.c_str());
    std::ofstream outputFile(pathToWrite, std::ios::out | std::ios::binary | std::ios::trunc);
    bool didDataGotWritten = false;

    if (!outputFile.fail()){
        if (Verbose){
            qDebug() << "File Found, Writing to file";
            qDebug() << newFileContent << ", Size = " << newFileContent.length();
        }

        outputFile << newFileContent.toStdString().c_str();
        if (Verbose){
            qDebug() << "Data Written";
        }

        outputFile.close();
    } else {
        if (Verbose){
            qDebug() << "File Not Found";
        }
    }


    ui->errorAnnouncerLabel->setText(message);
    ui->commandInputEdit->setText("");
    loadAllTasksIntoUIFromUser(userLoggedIn.getUserName());
}

void CheckListWindow::on_commandInputEdit_textChanged(const QString &arg1){
    newTaskContents = arg1;
    if (newDateTimeContents.toString() != ""){
        ui->addTaskButton->setEnabled(true);
    }

    if (arg1 != ""){
        ui->deleteTaskButton->setEnabled(true);
        ui->goToUserProfileButton->setEnabled(true);
    }
}

void CheckListWindow::on_goToUserProfileButton_clicked()
{
    userProfileRendered = ui->commandInputEdit->text();
    User askedUser = admin.getUserFromLoginDataFile(userProfileRendered, "");
    if (askedUser.getErrorDescription() == ""){
        if (askedUser.getUserClass() > userLoggedIn.getUserClass()){
            ui->errorAnnouncerLabel->setText("You do not have access to this user's data");
        } else {
            loadAllTasksIntoUIFromUser(askedUser.getUserName());
        }
    } else {
        ui->errorAnnouncerLabel->setText(askedUser.getErrorDescription());
    }
}


void CheckListWindow::on_goToCompanyLevel_clicked(){
    loadAllTasksFromAllUsers(userLoggedIn);
}

void CheckListWindow::on_goToUserProfileButton_2_clicked(){
    loadAllTasksIntoUIFromUser(userLoggedIn.getUserName());
}


