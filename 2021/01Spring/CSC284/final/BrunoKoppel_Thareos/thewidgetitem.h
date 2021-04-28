#ifndef THEWIDGETITEM_H
#define THEWIDGETITEM_H

#include <QDebug>
#include <QWidget>
#include <QLineEdit>
#include <QPushButton>
#include <QDateTime>
#include <QProgressBar>
#include <QLabel>
#include <QString>

namespace Ui {
class TheWidgetItem;
}

class TheWidgetItem : public QWidget
{
    Q_OBJECT

public:
    explicit TheWidgetItem(QWidget *parent = 0);
    ~TheWidgetItem();
    void setContent(QString new_Contents);
    void setDueDateTime(QDateTime new_dueDateTime);
    QString getContent();
    QString getDueDateTime_QStringFormat();
    QDateTime getDueDateTime_QDateTimeFormat();

private slots:


private:
    Ui::TheWidgetItem *ui;
    QString contents;
    QDateTime dueDateTime;
};

#endif // THEWIDGETITEM_H
