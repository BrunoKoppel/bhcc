#ifndef CHECKLISTWINDOW_H
#define CHECKLISTWINDOW_H

#include <QMainWindow>
#include <QGroupBox>
#include <QScrollArea>
#include <QList>
#include "user.h"
#include "task.h"

namespace Ui {
class CheckListWindow;
}

class CheckListWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit CheckListWindow(QWidget *parent = nullptr);
    void setUserLoggedIn(QString name);
    ~CheckListWindow();


private slots:
    void on_addTaskButton_clicked();

    void on_taskContentLineEdit_textChanged(const QString &arg1);

    void on_taskDateTimeEdit_dateTimeChanged(const QDateTime &dateTime);

private:
    Ui::CheckListWindow *ui;
    QString addTaskContents;
    QDateTime addDateTimeContents;
    QList<Task> taskList;
};

#endif // CHECKLISTWINDOW_H
