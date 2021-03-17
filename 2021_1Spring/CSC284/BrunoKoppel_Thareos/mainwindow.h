#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QFile>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private slots:
    void on_usernameLineEdit_textChanged(const QString &arg1);
    void on_passwordLineEdit_textChanged(const QString &arg1);


    void on_appLoginButton_clicked();
    void on_appCreateAccountButton_clicked();


    void on_actionExit_triggered();



private:
    Ui::MainWindow *ui;
    void testButtonFunc();
    void AddAccountToDataFile(QString username, QString password, int userLevel);
    void ReadAccountFromDataFile(QString username, QString password);
};
#endif // MAINWINDOW_H
