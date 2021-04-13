#include "task.h"
#include "ui_task.h"

Task::Task(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Task){
    ui->setupUi(this);
    qDebug() << "Empty Task Generated";
}

//Task::Task(QWidget *parent, QString new_content, QDateTime new_dueDateTime) :
//    QWidget(parent),
//    ui(new Ui::Task){
//    ui->setupUi(this);
//    this->content = new_content;
//    qDebug() << "Content from the Task Creation => " << getContent();
//    this->dueDateTime = new_dueDateTime;
//    qDebug() << "Due Date from the Task Creation => " << getDueDateTime();
//    setInformationInUI(content, dueDateTime);
//}

Task::~Task()
{
    delete ui;
}

void Task::setInformationInUI(QString new_content, QDateTime new_dueDateTime){
    ui->checkBox->setText(new_content);
    ui->dueDateTimeBox->setDateTime(new_dueDateTime);
}

void Task::setContent(QString new_content){
    this->content = new_content;
}

void Task::setDueDateTime(QDateTime new_dueDateTime){
    this->dueDateTime = new_dueDateTime;
}


QString Task::getContent(){
    return this->content;
}

QString Task::getDueDateTime(){
    return this->dueDateTime.toString();
}
