// MenuExample.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
// here is a good example of how to set up a menu
//
// Author: A. Richmond
//
// Date: February 4, 2009

#include <iostream>

using std::cout;
using std::cin;
using std::endl;

#include <cstdlib>
#include <conio.h>

char menu();
void DoOption1();
void DoOption2();
void DoOption3();
void DoOption4();
int main()
{
    for (;;)
    {
        char choice = menu();
        switch (choice)
        {
        case '1': DoOption1();
            break;
        case '2': DoOption2();
            break;
        case '3': DoOption3();
            break;
        case '4': DoOption4();
            break;
        default: cout << "\n\nInvalid choice--reenter" << endl;
            cout << "Hit a key...";
            _getch();
            break;
        }
    }
    return 0;
}

char menu()
{
    char choice;
    system("cls");
    cout << "***Menu***" << endl;
    cout << "(1) Choice One" << endl;
    cout << "(2) Choice Two" << endl;
    cout << "(3) Choice Three" << endl;
    cout << "(4) Choice Quit" << endl;
    cout << "Enter Your Choice: ";
    choice = _getch();
    return choice;
}

void DoOption1()
{
    cout << "\n\nYou Chose One" << endl;
    cout << "Hit a key...";
    _getch();
}

void DoOption2()
{
    cout << "\n\nYou Chose Two" << endl;
    cout << "Hit a key...";
    _getch();
}

void DoOption2()
{
    cout << "\n\nYou Chose Three" << endl;
    cout << "Hit a key...";
    _getch();
}

void DoOption2()
{
    cout << "\n\nYou Chose Four" << endl;
    cout << "Hit a key...";
    _getch();
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
