//
//  main.cpp
//  Project3
//
//  Created by Bruno Koppel on 11/23/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <fstream>
#include <iomanip>

#include "InventoryItem.h"

using namespace std;






/*
********************************************
*                                          *
* Here are the prototypes of our functions *
*                                          *
********************************************
*/


// Clearing cin to avoid errors with the input buffer

void clearCin();



// Functions that ask the user for input

string getStringFromUserInput(string prompt);
double getDoubleFromUserInput(string prompt);
int getIntFromUserInput(string prompt);
char getCharFromUserInput(string prompt);



// File input handling

int inputItemsFromFile(InventoryItem cart[], fstream& fileManagement, int index);
void splitLine (InventoryItem cart[], string line, int index);



// Functions that run with specific commands

string printHelpMenu();
int getEmptyIndex(InventoryItem cart[]);
void addNewInventoryItem(InventoryItem cart[]);
void printListOfItems(InventoryItem cart[], int totalOfIndexes);
void removePartFromItem(InventoryItem cart[], int totalOfIndexes);
void addPartToItem(InventoryItem cart[], int totalOfIndexes);

// File output handling

void outputContentsToFile(InventoryItem cart[], fstream& fileManagement,int totalOfIndexes);





/*
************************
*                      *
* Here starts our Main *
*                      *
************************
*/

int main(int argc, const char * argv[])
{
    fstream fileManagement;
    char command;
    bool machineState = true;
    InventoryItem cart[100];
    int totalOfIndexes = 0;
    
    
    while (machineState)
    {
        command = getCharFromUserInput("Enter a command (or 'h' for help): ");
        clearCin();
        
        // A COMMAND
        // This command adds parts to our list of items
        if (command == 'a')
        {
            addPartToItem(cart, totalOfIndexes);
        }
        
        // I COMMAND
        // This command adds items from a file feed through the command line
        else if (command == 'i')
        {
            int itemsLoaded = inputItemsFromFile(cart, fileManagement, totalOfIndexes);
            cout << itemsLoaded << " items have been loaded into the shopping cart." << endl;
            totalOfIndexes += itemsLoaded;
        }
        
        // P COMMAND
        // This is our command to print the current items in the list
        else if (command == 'p')
        {
            printListOfItems(cart, totalOfIndexes);
        }
        
        // N COMMAND
        // This is our command to Add new items to our list
        else if (command == 'n')
        {
            addNewInventoryItem(cart);
            totalOfIndexes++;
        }
        
        // O COMMAND
        // This is our command to Output the list contents to a file
        else if (command == 'o')
        {
            outputContentsToFile(cart, fileManagement, totalOfIndexes);
        }
        
        // R COMMAND
        // This is our command to Remove parts from an item in our list
        else if (command == 'r')
        {
            removePartFromItem(cart,totalOfIndexes);
            
        }
        
        // H COMMAND
        // This is our command to print a list of supported commands for our program
        else if (command == 'h')
        {
            cout << printHelpMenu();
        }
        
        // Q COMMAND
        // This is our command to Quit our program when we are done using it.
        else if (command == 'q')
        {
            cout << "Exiting loop" << endl;
            machineState = false;
            system("pause");
        }
        
        // ELSE COMMAND
        // In case the user inputs a command not supported
        else
        {
            cout << "You entered a wrong command, try again (enter h for a list of supported commands)" << endl;
        }
    }
    return 0;
}


//clearCin Definition

void clearCin()
{
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}





/*
*******************************************************************************
*                                                                             *
* PRINT HELP MENU FUNCTION RETURNS A STRING CONTAINING THE SUPPORTED COMMANDS *
*                                                                             *
*******************************************************************************
*/

string printHelpMenu()
{
    stringstream menu;
    menu << "Supported commands:" << endl;
    menu << "\t\ta\t\t\tAdd parts: increase the units value for an existing inventory item." << endl;
    menu << "\t\th\t\t\tprint Help text." << endl;
    menu << "\t\ti\t\t\tInput inventory data from a file." << endl;
    menu << "\t\tp\t\t\tPrint inventory list." << endl;
    menu << "\t\tn\t\t\tcreate a New inventory Item." << endl;
    menu << "\t\to\t\t\tOutput inventory data to a file." << endl;
    menu << "\t\tq\t\t\tquit (end the program)." << endl;
    menu << "\t\tr\t\t\tRemove parts: reduce the units value for an existing inventory item." << endl;
    return menu.str();
}






/*
*****************************************************************************************
*                                                                                       *
* THE NEXT FOUR FUNCTIONS ARE USER INPUTS THAT PROMPT THE USER AND TAKE INPUT FROM THEM *
*                                                                                       *
*****************************************************************************************
*/

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

double getDoubleFromUserInput(string prompt)
{
    double num;
    cout << prompt;
    cin >> num;
    return num;
}

int getIntFromUserInput(string prompt)
{
    int num;
    cout << prompt;
    cin >> num;
    return num;
}





/*
*********************************************************************************************************************
*                                                                                                                   *
* THE inputItemsFromFile prompts the user for a file name that opens the file in where we have items for the list   *
* This function calls the splitLine function which will handle each line taken from the file                        *
*                                                                                                                   *
*********************************************************************************************************************
*/

int inputItemsFromFile(InventoryItem cart[], fstream& fileManagement, int index)
{
    string filename = getStringFromUserInput("Enter name of input file: ");
    fileManagement.open(filename, ios::in);
    
    // inputBuffer is where we store each line taken from the file.
    string inputBuffer;
    
    // we keep a count on each line read from the file.
    int numberOfLines = 0;
    if (!fileManagement)
    {
        cout << "File inputting failure! FILE HAS NOT BEEN FOUND!" << endl;
    }
    else
    {
        // here the getline retrieves each line from the file
        while (getline(fileManagement,inputBuffer))
        {
            // splitline function call
            splitLine(cart, inputBuffer, index);
            numberOfLines++;
            index++;
        }
    }
    fileManagement.close();
    return numberOfLines;
}





/*
******************************************************
*                                                    *
* THE splitLine handles the line taken from the file *
*                                                    *
******************************************************
*/

void splitLine (InventoryItem cart[], string inputBuffer, int index)
{
    
    // delimeter pos will store the position at where we find the pipe delimeter
    size_t delimeterPos = inputBuffer.find('|');
    
    // line updates with the string that is after the delimeter pos so we don't take in the number of the item in the file
    string line = inputBuffer.substr(delimeterPos + 1);
    
    // we get the delimeter pos for the next pipe delimeter that denotes the end of the current line saved
    delimeterPos = line.find('|');
    
    // the string in line is the description of the item which we assign to a variable named description
    string description = line.substr(0,delimeterPos);
    
    // we update line again with what's left after the pipe delimeter
    line = line.substr(delimeterPos + 1);
    
    // we run the delimeter to find where the cost number ends
    delimeterPos = line.find('|');
    
    // now we can save the number found in the line which we transform from string to double
    double cost = stod (line.substr(0, delimeterPos));
    
    // lastly we take whatever is left from the line
    line = line.substr(delimeterPos + 1);
    
    // and save this into parts.
    int parts = stoi(line);
    
    // with these three variables we create a new item at the index position passed by the inputItemsFromFile function
    cart[index] = InventoryItem(description, cost, parts);
}





/*
************************************************************************************************
*                                                                                              *
* This Function will find the last empty spot to store the new item created with the N command *
*                                                                                              *
************************************************************************************************
*/

int getEmptyIndex(InventoryItem cart[])
{
    bool freeIndexDetected = false;
    int pos = 0;
    while (freeIndexDetected != true)
    {
        string desc = cart[pos].getDescription();
        if (desc == "")
        {
            freeIndexDetected = true;
            
        }
        else
        {
            pos++;
        }
    }
    return pos;
}






/*
*********************************************************************************
*                                                                               *
* This function adds a new item to our list without having to input from a file *
*                                                                               *
*********************************************************************************
*/

void addNewInventoryItem(InventoryItem cart[])
{
    
    // calling this function will return the index that is just after the last item in our list
    int pos = getEmptyIndex(cart);
    
    // these functions will ask the user information about the new item.
    string description = getStringFromUserInput("What's the new item going to be: ");
    double cost = getDoubleFromUserInput("Enter the cost for this item: ");
    
    // this is an input validation for the cost of an item
    while (cost <= 0)
    {
        cout << "ERROR: Cost must be a positive number" << endl;
        cost = getDoubleFromUserInput("Enter the initial cost for this item: ");
    }
    
    int parts = getIntFromUserInput("Enter the initial amount of parts for this item: ");
    
    // this is an input validation for the amount of initial parts that we can assign to a new item
    while (parts <= 0 or parts >= 30)
    {
        cout << "ERROR: initial quantity must be >= zero and <= 30" << endl;
        parts = getIntFromUserInput("Enter the initial amount of parts for this item: ");
    }
    
    // if the input validation takes a valid value the program proceeds to create a new item
    cart[pos] = InventoryItem(description, cost, parts);
}





/*
***************************************************************************
*                                                                         *
* These next two functions are the remove parts and the add parts to item *
* They are very similar but both do different things                      *
*                                                                         *
***************************************************************************
*/

void removePartFromItem(InventoryItem cart[], int totalOfIndexes)
{
    // input validation for the item selected by the user
    // In case the list has no items
    if (totalOfIndexes == 0)
    {
        cout << "There are no items in the list! Load or create some items first" << endl;
    }
    
    // else if there is items it will run
    else
    {
        // Asks the user for the number of the item that we are going to modify
        int pos = getIntFromUserInput("Which item are we removing parts from?");
        
        // input validation to select the corret index to modify
        while (pos < 0 or pos >= totalOfIndexes)
          {
              
              cout << "ERROR: The part selected does not exist" << endl;
              pos = getIntFromUserInput("Which item are we removing parts from?: ");
          }
              
        // asks the user the amount of parts to remove in this case
           int newAmountOfParts = getIntFromUserInput("How many parts are we removing?");
              
        // input validation for how many units we can remove
        // this will stop the user if they are trying to remove more parts than the item already has
          if ((cart[pos].getUnits() - newAmountOfParts) < 0)
          {
              cout << "Error: You are trying to remove more items than what we have" << endl;
          }
          else
          {
              cart[pos].setUnits((cart[pos].getUnits() - newAmountOfParts));
          }
    }
}

// this is the add parts to item function
void addPartToItem(InventoryItem cart[], int totalOfIndexes)
{
    if (totalOfIndexes == 0)
    {
        cout << "There are no items in the list! Load or create some items first" << endl;
    }
    
    // else if there is items it will run
    else
    {
        int pos = getIntFromUserInput("Which item are we getting more parts?: ");


        while (pos < 0 or pos >= totalOfIndexes)
        {
            cout << "ERROR: The part selected does not exist" << endl;
            pos = getIntFromUserInput("Which item are we getting more parts?: ");
        }

        int newAmountOfParts = getIntFromUserInput("How many parts are we adding?: ");

        if ((cart[pos].getUnits() + newAmountOfParts) > 30)
        {
            cout << "Error: you can't have more than 30 items" << endl;
        }
        else
        {
            cart[pos].setUnits((cart[pos].getUnits() + newAmountOfParts));
        }
    }
}








/*
************************************************************************************
*                                                                                  *
* Lastly these next two functions are the ones that output to the console and file *
*                                                                                  *
*                                                                                  *
************************************************************************************
*/
//this is to print the list of items to the console
void printListOfItems(InventoryItem cart[], int totalOfIndexes)
{
    cout << left << setw(15) << "Item Number" << setw(40) << left << "Description"
    << setw(10) << "Cost" << setw(10) << "Quantity" << endl;
    cout << setw(15) << "-----------" << setw(40) << "-----------"
    << setw(10) << "----" << setw(10) << "--------" << endl;
    for (int i = 0; i < totalOfIndexes; i++)
    {
        cout << setw(5) << right << i << "\t\t\t" << cart[i].printDetails();
    }
}

// this one will print the items into a file with the name that the user assigns to it.
void outputContentsToFile(InventoryItem cart[], fstream& fileManagement,int totalOfIndexes)
{
    string filename = getStringFromUserInput("Enter the filename to where the list will be saved: ");
    fileManagement.open(filename, ios::out);
    
    fileManagement << left << setw(15) << "Item Number" << setw(40) << left << "Description"
    << setw(10) << "Cost" << setw(10) << "Quantity" << endl;
    fileManagement << setw(15) << "-----------" << setw(40) << "-----------"
    << setw(10) << "----" << setw(10) << "--------" << endl;
    
    int i;
    for (i = 0; i < totalOfIndexes; i++)
    {
         fileManagement << setw(5) << right << i << "\t\t" << cart[i].printDetails();
    }
    fileManagement.close();
    cout << i << " Objects written to file" << endl;
}
