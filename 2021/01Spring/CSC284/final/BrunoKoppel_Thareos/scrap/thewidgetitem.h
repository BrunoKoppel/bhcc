#ifndef TASK_H
#define TASK_H

#include <QWidget>
#include <QString>
#include <QDateTime>
#include <QDebug>

namespace Ui {
class TheWidgetItem;
}

class TheWidgetItem : public QWidget
{
    Q_OBJECT

public:
    TheWidgetItem(QWidget *parent = nullptr);
//    TheWidgetItem(QWidget *parent = nullptr, QString new_content = "", QDateTime new_dueDateTime = QDateTime::currentDateTime());
    QString printInformation();
    QString getContent();
    QString getDueDateTime();
    void setContent(QString new_content);
    void setDueDateTime(QDateTime new_dueDateTime);
    ~TheWidgetItem();

private:
    Ui::TheWidgetItem *ui;
    QString content;
    QDateTime dueDateTime;
    void setInformationInUI(QString new_content, QDateTime new_dueDateTime);
};

#endif // TASK_H
