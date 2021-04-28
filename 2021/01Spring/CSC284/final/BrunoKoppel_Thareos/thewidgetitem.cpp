#include "thewidgetitem.h"
#include "ui_thewidgetitem.h"

TheWidgetItem::TheWidgetItem(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::TheWidgetItem){
    ui->setupUi(this);
}

TheWidgetItem::~TheWidgetItem(){
    delete ui;
}

void TheWidgetItem::setContent(QString new_Contents){
    qDebug() << "Value received at setContent " << new_Contents;
    this->contents = new_Contents;
    if (this->contents != ""){
        ui->checkBoxLabel->setText(this->contents);
    }
}

void TheWidgetItem::setDueDateTime(QDateTime new_dueDateTime){
    this->dueDateTime = new_dueDateTime;
    ui->DateLabel->setText(this->dueDateTime.toString());
}

QString TheWidgetItem::getContent(){
    return this->contents;
}

QString TheWidgetItem::getDueDateTime_QStringFormat(){
    return this->dueDateTime.toString();
}

QDateTime TheWidgetItem::getDueDateTime_QDateTimeFormat(){
    return this->dueDateTime;
}
