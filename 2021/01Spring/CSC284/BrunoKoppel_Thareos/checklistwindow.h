#ifndef CHECKLISTWINDOW_H
#define CHECKLISTWINDOW_H

#include <QMainWindow>
#include "user.h"

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


private:
    Ui::CheckListWindow *ui;
};

#endif // CHECKLISTWINDOW_H
