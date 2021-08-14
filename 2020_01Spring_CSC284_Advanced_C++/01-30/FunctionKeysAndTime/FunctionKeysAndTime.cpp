// TimeDate_and_FunctionKeys.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
// This program illustrates how to code
// time, date and function keys
//
// Written by A.Richmond
// Date: 15 November, 2002

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>

using std::cout;
using std::endl;
using std::flush;

#include <conio.h>
#include <ctime>
#include <cstdlib>

int main()
{
    unsigned char key, key2;

    struct tm* date_time;
    time_t timer;
    time(&timer);
    date_time = localtime(&timer);
    system("cls");

    cout << "The present date and time is: " << asctime(date_time);

    cout << "\nPress a function key(CR to end): ";

    while ((key = _getch()) != '\r')
        if (key == 0)
        {
            key2 = _getch();
            switch (key2)
            {
            case 59:
                cout << "\nFunction key 1\n"; break;
            case 60:
                cout << "\nFunction key 2\n"; break;
            case 61:
                cout << "\nFunction key 3\n"; break;
            case 62:
                cout << "\nFunction key 4\n"; break;
            case 63:
                cout << "\nFunction key 5\n"; break;
            case 64:
                cout << "\nFunction key 6\n"; break;
            case 65:
                cout << "\nFunction key 7\n"; break;
            case 66:
                cout << "\nFunction key 8\n"; break;
            case 67:
                cout << "\nFunction key 9\n"; break;
            case 68:
                cout << "\nFunction key 10\n"; break;

            }
        }

        else
        {
            if (key == 133)
                cout << "\nFunction key 11\n";

            if (key == 134)
            {
                cout << flush;
                cout << "\nFunction key 12\n";
                cout << "\nPress a key to continue...";
                cout << "\nFinished with F12... Press CR ";
            }

        }
    return 0;
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