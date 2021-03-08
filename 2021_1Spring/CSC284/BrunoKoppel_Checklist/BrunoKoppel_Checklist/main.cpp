
#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QWidgets>


int main(int argc, char *argv[])
{
#if defined(Q_OS_WIN)
    QCoreApplication::setAttribute(Qt::AA_EnableHighDpiScaling);
#endif

    QGuiApplication app(argc, argv);

    QQmlApplicationEngine engine;
    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));
    if (engine.rootObjects().isEmpty())
        return -1;

    QWidget* wdg = new QWidget(this);
    QPushButton* train_button = new QPushButton(wdg);
    train_button->setText(tr("something"));
    setCentralWidget(wdg);

    return app.exec();
}
