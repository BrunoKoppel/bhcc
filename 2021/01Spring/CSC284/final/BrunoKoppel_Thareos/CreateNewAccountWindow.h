#ifndef CREATENEWACCOUNTWINDOW_H
#define CREATENEWACCOUNTWINDOW_H

#include "user.h"
#include "loginwindow.h"
#include <QDialog>

namespace Ui {
class CreateNewAccountWindow;
}

class CreateNewAccountWindow : public QDialog
{
    Q_OBJECT

public:
    explicit CreateNewAccountWindow(QWidget *parent = nullptr);
    void setAdminUser(User newAdminUser);
    ~CreateNewAccountWindow();

private slots:
    void on_usernameLineEdit_textEdited(const QString &arg1);

    void on_passwordLineEdit_textEdited(const QString &arg1);

    void on_passwordLineEdit_2_textEdited(const QString &arg1);

    void on_createAccountButton_clicked();

    void testToSetCreateAccountButtonEnable();

    void on_CancelButton_clicked();

private:
    Ui::CreateNewAccountWindow *ui;
    User adminUser;
    QString username;
    QString password;
    QString passwordRepeat;
};

#endif // CREATENEWACCOUNTWINDOW_H
