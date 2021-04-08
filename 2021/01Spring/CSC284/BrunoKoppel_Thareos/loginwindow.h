#ifndef LOGINWINDOW_H
#define LOGINWINDOW_H

#include <QDialog>
#include <QString>

namespace Ui {
class LoginWindow;
}

class LoginWindow : public QDialog
{
    Q_OBJECT

public:
    explicit LoginWindow(QWidget *parent = nullptr);
    QString userLoggedIn;
    ~LoginWindow();

private slots:
    void on_lineEdit_2_textChanged(const QString &arg1);

private:
    Ui::LoginWindow *ui;
};

#endif // LOGINWINDOW_H
