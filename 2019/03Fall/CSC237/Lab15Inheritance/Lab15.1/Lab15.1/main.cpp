//
//  main.cpp
//  Lab15.1
//
//  Created by Bruno Koppel on 11/17/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//
#include "Employee.h"
#include "ProductionWorker.hpp"
#include <iostream>
#include <sstream>

char getCharFromUserInput(string prompt);
string getStringFromUserInput(string prompt);
int getIntegerFromUserInput(string prompt);
double getDoubleFromUserInput(string prompt);
string printHelpMenu();
void clearCin();

int main() {
    bool machineState = true;
    ProductionWorker *eptr;
    char command;
    while (machineState)
    {
        command = getCharFromUserInput("Enter a command (or 'h' for help): ");
        clearCin();
        
        if (command == 'h')
        {
            cout << printHelpMenu();
        }
        else if (command == 'c')
        {
            string name = getStringFromUserInput("Enter name of new employee: ");
            string date = getStringFromUserInput("Enter hire date of new employee: ");
            int shift = getIntegerFromUserInput("Enter shift for new employee (1=day, 2=night): ");
            int payRate = getDoubleFromUserInput("Enter hourly pay rate for new employee: ");
            eptr = new ProductionWorker(name, date, shift, payRate);
        }
        else if (command == 'p')
        {
            eptr->printWorkerData();
        }
        else if (command == 'q')
        {
            cout << "Exiting loop" << endl;
            machineState = false;
        }
        else
        {
            cout << "You entered a wrong command, try again (enter h for a list of supported commands)" << endl;
        }
    }
    cout << "Exiting program... Goodbye my friend!" << endl;
    system("pause");
    return 0;
}

string getStringFromUserInput(string prompt)
{
    string line;
    cout << prompt;
    getline(cin, line);
    return line;
}

char getCharFromUserInput(string prompt)
{
    char letter;
    cout << prompt;
    cin >> letter;
    return letter;
}

int getIntegerFromUserInput(string prompt)
{
    int number;
    cout << prompt;
    cin >> number;
    return number;
}

double getDoubleFromUserInput(string prompt)
{
    double number;
    cout << prompt;
    cin >> number;
    return number;
}

string printHelpMenu()
{
    stringstream menu;
    menu << "Supported commands:" << endl;
    menu << "\t\tc\t\t\tcreate a new ProductionWorker object." << endl;
    menu << "\t\th\t\t\tprint help text." << endl;
    menu << "\t\tp\t\t\tprint ProductionWorker information." << endl;
    menu << "\t\tq\t\t\tquit (end the program)." << endl;
    return menu.str();
}

void clearCin()
{
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}
