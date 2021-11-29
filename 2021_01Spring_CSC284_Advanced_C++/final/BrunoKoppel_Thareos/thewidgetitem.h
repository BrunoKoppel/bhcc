#ifndef THEWIDGETITEM_H
#define THEWIDGETITEM_H

#include <QDebug>
#include <QWidget>
#include <QLineEdit>
#include <QPushButton>
#include <QDateTime>
#include <QProgressBar>
#include <QLabel>
#include <QString>
#include <QFile>
#include <QCoreApplication>
#include <fstream>

namespace Ui {
class TheWidgetItem;
}

class TheWidgetItem : public QWidget
{
    Q_OBJECT

public:
    explicit TheWidgetItem(QWidget *parent = 0);
//    TheWidgetItem(QWidget *parent = 0, QString new_Contents = "", QString new_dueDateTime = "", QString newTaskOwner = "");
    ~TheWidgetItem();
    void setContent(QString new_Contents);
    void setDueDateTime(QDateTime new_dueDateTime);
    void setTaskUserOwner(QString newTaskUserOwner);

    QString getContent();
    QString getDueDateTimeInQStringFormat();
    QString getTaskUserOwner();

    QDateTime getDueDateTimeInQDateTimeFormat();
    QString getTaskInfoInQStringFormat();

    void getAllTasksFromDataFile();
    void writeToTaskDataFile();

private slots:

    void on_checkBoxLabel_toggled(bool checked);

private:
    Ui::TheWidgetItem *ui;
    QString contents;
    QDateTime dueDateTime;
    QString taskUserOwner;
};

#endif // THEWIDGETITEM_H
