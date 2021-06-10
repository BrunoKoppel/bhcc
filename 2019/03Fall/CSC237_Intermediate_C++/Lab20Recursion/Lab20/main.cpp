//
//  main.cpp
//  Lab20Recursion
//
//  Created by Bruno Koppel on 11/25/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//
#include "IntList.hpp"
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

string printHelpMenu();
char getCharFromUserInput(string prompt);
int getIntFromUserInput(string prompt);
void clearCin();

int main(int argc, const char * argv[]) {
    
    bool machineState = true;
    IntList arrengment;
    
    while (machineState)
    {
        char command = getCharFromUserInput("Enter a command (press h for a list of valid commands): ");
        clearCin();
        
        if (command == 'a')
        {
            int number = getIntFromUserInput("Enter number to append to the list");
            arrengment.appendNode(number);
        }
        else if (command == 'd')
        {
            int number = getIntFromUserInput("Enter number to delete from the list");
            arrengment.deleteNode(number);
        }
        else if (command == 'i')
        {
            int number = getIntFromUserInput("Enter number to insert to the list");
            arrengment.insertNode(number);
        }
        else if (command == 'r')
        {
            arrengment.printListRecursively();
        }
        else if (command == 'b')
        {
            arrengment.printListBackwards();
        }
        else if (command == 'c')
        {
            int totalOfNodes = arrengment.countNodesRecursively();
            cout << dec << ",\tCount = " << totalOfNodes << endl;
        }
        else if (command == 't')
        {
            int sumOfNodes = arrengment.calculateTotalSumOfNodes();
            cout << dec << ",\tTotal = " << sumOfNodes << endl;
        }
        else if (command == 'p')
        {
            arrengment.displayList();
        }
        else if (command == 'h')
        {
            cout << printHelpMenu() << endl;
        }
        else if (command == 'q')
        {
            cout << "System exiting" << endl;
            machineState = false;
        }
        
        else
        {
            cout << "You have entered a command that does no action... press h for a list of valid commands" << endl;
        }
    }
    return 0;
}

string printHelpMenu()
{
    stringstream helpText;
    helpText << "\ta:\t\tAPPEND a new node at the end of the list" << endl;
    helpText << "\td:\t\tDELETE a node from the list" << endl;
    helpText << "\ti:\t\tINSERT a node into the list, maintaining the sorted order." << endl;
    helpText << "\tr:\t\tRECURSIVELY print the contents of the list." << endl;
    helpText << "\tb:\t\tRecursively print the contents of the list BACKWARDS" << endl;
    helpText << "\tc:\t\tUse recursion to COUNT the number of nodes in the list." << endl;
    helpText << "\tt:\t\tUse recursion to calculate the TOTAL of the value fields for all nodes in the list" << endl;
    helpText << "\tp:\t\tPRINT the contents of the list on the console." << endl;
    helpText << "\th:\t\tPRINTS this menu." << endl;
    helpText << "\tq:\t\tQUITS this program." << endl;
    
    return helpText.str();
}

char getCharFromUserInput(string prompt)
{
    char letter;
    cout << prompt << endl;
    cin >> letter;
    return letter;
}

int getIntFromUserInput(string prompt)
{
    int number;
    cout << prompt << endl;
    cin >> number;
    return number;
}

void clearCin()
{
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(),'\n');
}