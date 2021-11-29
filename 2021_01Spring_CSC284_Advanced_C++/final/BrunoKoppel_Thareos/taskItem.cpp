#include "taskItem.h"

taskItem::taskItem(){
    setTaskNumber(0);
    setTaskName("");
    setTaskDueDateTime("");
    setTaskOwner("");
}

taskItem::taskItem(int newTaskNumber, QString newTaskName, QString newTaskDueDateTime, QString newTaskOwner){
    setTaskNumber(newTaskNumber);
    setTaskName(newTaskName);
    setTaskDueDateTime(newTaskDueDateTime);
    setTaskOwner(newTaskOwner);
}

void taskItem::setTaskNumber(int newTaskNumber){
    this->taskNumber = newTaskNumber;
}

void taskItem::setTaskName(QString newTaskName){
    this->taskName = newTaskName;
}

void taskItem::setTaskDueDateTime(QString newTaskDueDateTime){
    this->taskDueDateTime = newTaskDueDateTime;
}

void taskItem::setTaskOwner(QString newTaskOwner){
    this->taskOwner = newTaskOwner;
}

int taskItem::getTaskNumber(){
    return this->taskNumber;
}

QString taskItem::getTaskName(){
    return this->taskName;
}

QString taskItem::getTaskDueDateTime(){
    return this->taskDueDateTime;
}

QString taskItem::getTaskOwner(){
    return this->taskOwner;
}


