#include "mainwindow.h"
#include "./ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    this->installEventFilter(this);
    appPath = QCoreApplication::applicationDirPath();
}

bool MainWindow::eventFilter(QObject *object, QEvent *event)
{
    if (object == this && event->type() == QEvent::KeyPress) {
        QKeyEvent *keyEvent = static_cast<QKeyEvent *>(event);
        if (keyEvent->key() == Qt::Key_W) {
            return true;
        } else {
            return false;
        }
    }
    return false;
}

void MainWindow::keyPressEvent(QKeyEvent *event)
{
    QString text = event->text();

    if (text == "j"){
        on_hiHatButton_clicked();
    }

    if (text == "f"){
        on_snareButton_clicked();
    }

    if (text == "d"){
        on_kickDrumButton_clicked();
    }
}

void MainWindow::on_kickDrumButton_clicked(){
    QSound *kick = new QSound(appPath + QString("/sounds/kick.wav"), nullptr);
    kick->play();
    qDebug() << appPath + QString("/sounds/kick.wav");
}

void MainWindow::on_snareButton_clicked(){
    QSound *snare = new QSound(appPath + QString("/sounds/snare.wav"), nullptr);
    snare->play();
    qDebug() << appPath + QString("/sounds/snare.wav");
}

void MainWindow::on_hiHatButton_clicked(){
    QSound *hihat = new QSound(appPath + QString("/sounds/hihat.wav"), nullptr);
    hihat->play();
    qDebug() << appPath + QString("/sounds/hihat.wav");
}

MainWindow::~MainWindow()
{
    delete ui;
}

