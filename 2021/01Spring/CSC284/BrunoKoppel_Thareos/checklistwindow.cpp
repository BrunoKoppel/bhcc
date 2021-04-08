#include "checklistwindow.h"
#include "ui_checklistwindow.h"

CheckListWindow::CheckListWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::CheckListWindow)
{
    ui->setupUi(this);

}

CheckListWindow::~CheckListWindow()
{
    delete ui;
}

void CheckListWindow::setUserLoggedIn(QString name){
    ui->label->setText(name);
}
