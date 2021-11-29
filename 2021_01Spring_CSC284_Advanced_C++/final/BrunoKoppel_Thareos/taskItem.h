#ifndef TASKITEM_H
#define TASKITEM_H

#include <QString>

class taskItem
{
public:
    taskItem();
    taskItem(int newTaskNumber, QString newTaskName, QString newTaskDueDateTime, QString newTaskOwner);

    void setTaskNumber(int newTaskNumber);
    void setTaskName(QString newTaskName);
    void setTaskDueDateTime(QString newTaskDueDateTime);
    void setTaskOwner(QString newTaskOwner);

    int getTaskNumber();
    QString getTaskName();
    QString getTaskDueDateTime();
    QString getTaskOwner();

private:
    int taskNumber;
    QString taskName;
    QString taskDueDateTime;
    QString taskOwner;
};

#endif // TASKITEM_H
