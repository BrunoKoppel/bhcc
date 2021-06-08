#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>

#include <QtMultimedia/QAudio>
#include <QtMultimedia/QAudioOutput>
#include <QtMultimedia/QSound>
#include <QtMultimedia/QMediaPlayer>
#include <QUrl>
#include <QDir>
#include <QKeyEvent>
#include <QDebug>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    bool eventFilter(QObject *object, QEvent *event);
    QString appPath;
    ~MainWindow();

private:
    Ui::MainWindow *ui;
    void keyPressEvent(QKeyEvent *event);

private slots:
    void on_kickDrumButton_clicked();

    void on_snareButton_clicked();

    void on_hiHatButton_clicked();
};
#endif // MAINWINDOW_H
