#ifndef LOGINWINDOW_H
#define LOGINWINDOW_H

#include <QWidget>
#include <QFile>

QT_BEGIN_NAMESPACE
namespace Ui { class loginWindow; }
QT_END_NAMESPACE

class loginWindow : public QWidget
{
    Q_OBJECT

public:
    explicit loginWindow(QWidget *parent = nullptr);
    ~loginWindow();

private slots:
    void on_usernameLineEdit_textChanged(const QString &arg1);
    void on_passwordLineEdit_textChanged(const QString &arg1);

    void on_appLoginButton_clicked();
    void on_appCreateAccountButton_clicked();

    void on_actionExit_triggered();

private:
    Ui::loginWindow *ui;
    void testButtonFunc();
    void ReadAccountFromDataFile(QString username, QString password);
    void AddAccountToDataFile(QString username, QString password, int userLevel, bool isAdmin);

signals:

};

#endif // LOGINWINDOW_H
