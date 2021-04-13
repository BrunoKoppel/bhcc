#ifndef TASK_H
#define TASK_H

#include <QWidget>
#include <QString>
#include <QDateTime>
#include <QDebug>

namespace Ui {
class Task;
}

class Task : public QWidget
{
    Q_OBJECT

public:
    Task(QWidget *parent = nullptr);
//    Task(QWidget *parent = nullptr, QString new_content = "", QDateTime new_dueDateTime = QDateTime::currentDateTime());
    QString printInformation();
    QString getContent();
    QString getDueDateTime();
    void setContent(QString new_content);
    void setDueDateTime(QDateTime new_dueDateTime);
    ~Task();

private:
    Ui::Task *ui;
    QString content;
    QDateTime dueDateTime;
    void setInformationInUI(QString new_content, QDateTime new_dueDateTime);
};

#endif // TASK_H
