// ProgrammingProject-1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include "HashTable.cpp"
#include "HashTable.h"
#include <iostream>
#include <conio.h>
#include <iomanip>
#include <string>

using namespace std;

int printMainMenuAndCommandPrompt();
int printSubMenuAndCommandPrompt(int);
void processUsersChoice(int, int);
void testingUnicodeTable();

int main()
{
    bool programRunning = true;
    int firstCallCode = 0;
    int secondCallCode = 0;
    HashTable HashTable[100];

    while (programRunning)
    {
        int firstCallCode = printMainMenuAndCommandPrompt();
        if (firstCallCode == 1)
            secondCallCode = printSubMenuAndCommandPrompt(firstCallCode);
        else if (firstCallCode > 1 and firstCallCode < 16)
            secondCallCode = printSubMenuAndCommandPrompt(firstCallCode);
        else if (firstCallCode < 1 and firstCallCode > 17)
            cout << "You have entered a choice outside of the options range,\ntry again" << endl;

        processUsersChoice(firstCallCode, secondCallCode);

        //testingUnicodeTable();
        _getch();

    }
    return 0;
}

int printMainMenuAndCommandPrompt()
{
    int commandCode = 0;
    cout << ">>> Welcome to the K" << (char) 148 << "ppel Dictonary <<<\n" << endl;
    cout << "(1)  Create the word List" << endl;
    cout << "(2)  (German, French, Latin, Hebrew) to English nouns" << endl;
    cout << "(3)  (German, French, Latin, Hebrew) to English verbs" << endl;
    cout << "(4)  (German, French, Latin, Hebrew) to English prepositions" << endl;
    cout << "(5)  (German, French, Latin, Hebrew) to English adjetives" << endl;
    cout << "(6)  (German, French, Latin, Hebrew) to English adverbs" << endl;
    cout << "(7)  (German, French, Latin, Hebrew) to English cardinal numbers" << endl;
    cout << "(8)  (German, French, Latin, Hebrew) to English all" << endl;
    cout << "(9)  English to (German, French, Latin, Hebrew) nouns" << endl;
    cout << "(10) English to (German, French, Latin, Hebrew) verbs" << endl;
    cout << "(11) English to (German, French, Latin, Hebrew) prepositions" << endl;
    cout << "(12) English to (German, French, Latin, Hebrew) adjetives" << endl;
    cout << "(13) English to (German, French, Latin, Hebrew) adverbs" << endl;
    cout << "(14) English to (German, French, Latin, Hebrew) cardinal numbers" << endl;
    cout << "(15) English to (German, French, Latin, Hebrew) all" << endl;
    cout << "(16) Search for a word in one language and return other languages" << endl;
    cout << "(17) Quit\n" << endl;
    cout << "Enter your choice: ";
    cin >> commandCode;
    return commandCode;
}

int printSubMenuAndCommandPrompt(int firstCommand)
{
    int commandCode = 0;

    if (firstCommand == 1)
    {
        cout << "Do you want to load a pre-existing dictionary or create a new word?\n" << endl;
        cout << "(1) Create a new word" << endl;
        cout << "(2) Load pre-existing dictionary" << endl;

    }
    else if (firstCommand > 1 and firstCommand < 16)
    {
        cout << "From which language do you want your results\n" << endl;
        cout << "(1) German" << endl;
        cout << "(2) French" << endl;
        cout << "(3) Latin" << endl;
        cout << "(4) Hebrew" << endl;
    }
    
    cout << "Enter your choice: ";
    cin >> commandCode;
    return commandCode;
}



void processUsersChoice(int firstCallCode, int secondCallCode)
{

}

void testingUnicodeTable()
{
    int x = 0;
    for (int x = 1; x < 500; x++)
    {
        cout << setw(8);
        cout << "#" << x << ": " << (char) x ;
        if (x % 10 == 0)
        {
            cout << endl;
        }
    }
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
