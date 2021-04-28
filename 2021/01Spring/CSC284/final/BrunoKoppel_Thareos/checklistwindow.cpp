#include "checklistwindow.h"
#include "ui_checklistwindow.h"
#include "thewidgetitem.h"


CheckListWindow::CheckListWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::CheckListWindow){
    ui->setupUi(this);
    ui->addTaskButton->setEnabled(false);
}

CheckListWindow::~CheckListWindow(){
    delete ui;
}

void CheckListWindow::setUserLoggedIn(QString name){
    ui->userGreeting->setText("Welcome, " + name);
}


void CheckListWindow::on_addTaskButton_clicked(){
    QListWidgetItem *listWidgetItem = new QListWidgetItem(ui->listWidget);

    //Adding the item to the listwidget
    ui->listWidget->addItem (listWidgetItem);

    //Creating an object of the designed widget which is to be added to the listwidget
    TheWidgetItem *theWidgetItem = new TheWidgetItem;

    qDebug() << "Task Content => " << addTaskContents;
    qDebug() << "Task Due Date Time => " << addDateTimeContents.toString();

    theWidgetItem->setContent(addTaskContents);
    theWidgetItem->setDueDateTime(addDateTimeContents);

    qDebug() << "Created new Task ";
    qDebug() << "Content -> " + theWidgetItem->getContent();
    qDebug() << "Due DateTime -> " + theWidgetItem->getDueDateTime_QStringFormat();

    //Making sure that the listWidgetItem has the same size as the TheWidgetItem
    listWidgetItem->setSizeHint (theWidgetItem->sizeHint ());

    //Finally adding the itemWidget to the list
    ui->listWidget->setItemWidget (listWidgetItem, theWidgetItem);

    ui->taskContentLineEdit->setText("");
    ui->taskDateTimeEdit->setDateTime(QDateTime::currentDateTime());
}

void CheckListWindow::on_taskContentLineEdit_textChanged(const QString &arg1){
    addTaskContents = arg1;
    if (addDateTimeContents.toString() != ""){
        ui->addTaskButton->setEnabled(true);
    }
}

void CheckListWindow::on_taskDateTimeEdit_dateTimeChanged(const QDateTime &dateTime){
    addDateTimeContents = dateTime;
    if (addTaskContents != ""){
        ui->addTaskButton->setEnabled(true);
    }
}
