#ifndef CHECKLISTWINDOW_H
#define CHECKLISTWINDOW_H

#include <QMainWindow>
#include <QDateTime>
#include <QString>
#include <QListWidget>
#include <QList>
#include <QListWidgetItem>
#include <QVector>
#include <QDebug>
#include <fstream>
#include "user.h"
#include "taskItem.h"

namespace Ui {
class CheckListWindow;
}

class CheckListWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit CheckListWindow(QWidget *parent = nullptr);
    void loadAllTasksIntoUIFromUser(QString usernameOnScreen);
    void loadAllTasksFromAllUsers(User userLoggedIn);

    void setNewAdmin(User newAdmin);
    void setUserLoggedIn(User newUser);
    void setLastUserLoggedIn(QString lastUser);
    void setIfUserLoggedOut(bool condition);
    void setNewTaskContents(QString contents);
    void setnewDateTimeContents(QDateTime contents);

    User getUserLoggedIn();
    QString getLastUserLoggedIn();
    QString getNewTaskContents();
    QDateTime getNewDateTimeContents();

    bool getIfUserLoggedOut();
    ~CheckListWindow();


private slots:
    void on_addTaskButton_clicked();
    void on_taskDateTimeEdit_dateTimeChanged(const QDateTime &dateTime);
    void on_actionLog_Out_triggered();
    void on_deleteTaskButton_clicked();

    void on_commandInputEdit_textChanged(const QString &arg1);

    void on_goToUserProfileButton_clicked();

    void on_goToCompanyLevel_clicked();

    void on_goToUserProfileButton_2_clicked();

private:
    Ui::CheckListWindow *ui;
    User admin;
    QString newTaskContents;
    QDateTime newDateTimeContents;
    bool didUserLoggedOut;
    User userLoggedIn;
    QString userProfileRendered;

    QList<QString> taskData;

    void addTaskToUiManually(bool calledFromFile);
    QString addTask(QString parent, QStringList list);
};

#endif // CHECKLISTWINDOW_H
