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
    if (text == "t"){
//        QFile inputFile;
//        QAudioOutput* audio;
//        inputFile.setFileName("/tmp/test.raw");
//        inputFile.open(QIODevice::ReadOnly);

//        QAudioFormat format;
//        // Set up the format, eg.
//        format.setFrequency(7600);
//        format.setChannels(1);
//        format.setSampleSize(6);
//        format.setCodec("audio/pcm");
//        format.setByteOrder(QAudioFormat::LittleEndian);
//        format.setSampleType(QAudioFormat::UnSignedInt);

//        QAudioDeviceInfo info(QAudioDeviceInfo::defaultOutputDevice());
//        if (!info.isFormatSupported(format)) {
//            qWarning()<<"raw audio format not supported by backend, cannot play audio.";
//            return;
//        }

//        audio = new QAudioOutput(format, this);

//        connect(audio,SIGNAL(stateChanged(QAudio::State)),SLOT(finishedPlaying(QAudio::State)));
//        audio->start(&inputFile);

        qDebug() << QUrl("https://assets.drumsgone.com/demos/drums_original.mp3");
        qDebug() << appPath;
//        QSound *test = new QSound(appPath + QString("/sounds/kick.wav"), nullptr);
//        test->play();

        QMediaPlayer *player = new QMediaPlayer;
        player->setMedia(QUrl("https://assets.drumsgone.com/demos/drums_original.mp3"));
        player->setVolume(50);
        player->play();

    }

    if (text == "j")
        playHiHat();

    if (text == "f")
        playKick();

    if (text == "d")
        playSnare();

}

void MainWindow::playHiHat(){
//    player->setVolume(50);
//    QMediaPlayer *hiHatPlayer = new QMediaPlayer;
//    hiHatPlayer->setMedia(QUrl::fromLocalFile("/sounds/kick.wav"));
//    hiHatPlayer->play();
}

void MainWindow::playSnare(){

}

void MainWindow::playKick(){

}

MainWindow::~MainWindow()
{
    delete ui;
}

