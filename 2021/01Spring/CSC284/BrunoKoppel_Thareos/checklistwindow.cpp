#include "checklistwindow.h"
#include "ui_checklistwindow.h"
#include "task.h"


CheckListWindow::CheckListWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::CheckListWindow){
    ui->setupUi(this);

}

CheckListWindow::~CheckListWindow(){
    delete ui;
}

void CheckListWindow::setUserLoggedIn(QString name){
    ui->userGreeting->setText("Welcome, " + name);
}



void CheckListWindow::on_addTaskButton_clicked(){
    qDebug() << "Task Content => " << addTaskContents;
    qDebug() << "Task Due Date Time => " << addDateTimeContents.toString();
    Task newTask = new Task(ui->scrollAreaWidgetContents);
    newTask.setContent(addTaskContents);
    newTask.setDueDateTime(addDateTimeContents);

    qDebug() << "Created new Task ";
    qDebug() << "Content -> " + newTask.getContent();
    qDebug() << "Due DateTime -> " + newTask.getDueDateTime();

    ui->taskContentLineEdit->setText("");
    ui->taskDateTimeEdit->setDateTime(QDateTime::currentDateTime());

}

void CheckListWindow::on_taskContentLineEdit_textChanged(const QString &arg1)
{
    addTaskContents = arg1;
}

void CheckListWindow::on_taskDateTimeEdit_dateTimeChanged(const QDateTime &dateTime)
{
    addDateTimeContents = dateTime;
}
