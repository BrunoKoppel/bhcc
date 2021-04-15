#include "thewidgetitem.h"
#include "ui_thewidgetitem.h"

TheWidgetItem::TheWidgetItem(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::TheWidgetItem){
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

TheWidgetItem::~TheWidgetItem()
{
    delete ui;
}

void TheWidgetItem::setInformationInUI(QString new_content, QDateTime new_dueDateTime){
    ui->checkBox->setText(new_content);
    ui->dueDateTimeBox->setDateTime(new_dueDateTime);
}

void TheWidgetItem::setContent(QString new_content){
    this->content = new_content;
}

void TheWidgetItem::setDueDateTime(QDateTime new_dueDateTime){
    this->dueDateTime = new_dueDateTime;
}


QString TheWidgetItem::getContent(){
    return this->content;
}

QString TheWidgetItem::getDueDateTime(){
    return this->dueDateTime.toString();
}
