#include "thewidgetitem.h"
#include "ui_thewidgetitem.h"

bool verboseTask = true;

TheWidgetItem::TheWidgetItem(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::TheWidgetItem){
    ui->setupUi(this);
}

//TheWidgetItem::TheWidgetItem(QWidget *parent, QString new_Contents, QString new_dueDateTime, QString newTaskOwner) :
//    QWidget(parent),
//    ui(new Ui::TheWidgetItem){
//    ui->setupUi(this);
//    setContent(new_Contents);
//    setDueDateTime(QDateTime::fromString(new_dueDateTime));
//    setTaskUserOwner(newTaskOwner);
//}

TheWidgetItem::~TheWidgetItem(){
    delete ui;
}


void TheWidgetItem::setContent(QString new_Contents){
    this->contents = new_Contents;
    if (this->contents != ""){
        ui->checkBoxLabel->setText(this->contents);
    }
}

void TheWidgetItem::setDueDateTime(QDateTime new_dueDateTime){
    this->dueDateTime = new_dueDateTime;
    ui->DateLabel->setText(this->dueDateTime.toString());
}

void TheWidgetItem::setTaskUserOwner(QString newTaskUserOwner){
    this->taskUserOwner = newTaskUserOwner;
};


QString TheWidgetItem::getTaskUserOwner(){
    return this->taskUserOwner;
};

QString TheWidgetItem::getContent(){
    return this->contents;
}

QString TheWidgetItem::getDueDateTimeInQStringFormat(){
    return this->dueDateTime.toString();
}

QDateTime TheWidgetItem::getDueDateTimeInQDateTimeFormat(){
    return this->dueDateTime;
}


QString TheWidgetItem::getTaskInfoInQStringFormat(){
    return (getContent() + "//" + getDueDateTimeInQStringFormat() + "//" + getTaskUserOwner()) + "\n";
}

void TheWidgetItem::getAllTasksFromDataFile(){

}

void TheWidgetItem::writeToTaskDataFile(){
    std::string path = QCoreApplication::applicationDirPath().toStdString() + QString("/TD-UsersTaskData.txt").toStdString();
    std::ofstream outputFile(path, std::ios::out | std::ios::binary | std::ios::app );
    bool didDataGotWritten = false;

    if (verboseTask){
        qDebug() << QString::fromStdString(path);
    }

    if (!outputFile.fail()){
        if (verboseTask){
            qDebug() << "File Found, Writing to file";
        }

        outputFile << this->getTaskInfoInQStringFormat().toStdString();
        outputFile.close();
    } else {
        if (verboseTask){
            qDebug() << "File Not Found";
        }
    }
}

void TheWidgetItem::on_checkBoxLabel_toggled(bool checked)
{
//    std::string path = QCoreApplication::applicationDirPath().toStdString() + QString("/TD-UsersTaskData.txt").toStdString();
//    std::ifstream outputFile(path, std::ios::in | std::ios::binary);

//    if (verboseTask){
//        qDebug() << QString::fromStdString(path);
//    }

//    if (!outputFile.fail()){
//        if (verboseTask){
//            qDebug() << "File Found, Writing to file";
//        }

//        outputFile << this->getTaskInfoInQStringFormat().toStdString();
//        outputFile.close();
//    } else {
//        if (verboseTask){
//            qDebug() << "File Not Found";
//        }
//    }

    delete this;
}


