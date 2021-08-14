// PassByReference.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Program to illustrate passing by reference/value in C++
//
// Written by Arland J. Richmond
//
// Date Written September 25th, 1998

#include <iostream>
using namespace std;

#include <cstdlib>

void passByValue(int, int);
void passByReference(int&, int&);
void passbySimulatedReference(int*, int*);

int main()
{
    int value = 4;
    int* referenceToValue = &value;
    int& refToValue = value;

    value = value * 2;

    cout << "value: " << value << endl;
    cout << "referenceToValue: " << referenceToValue << endl;
    cout << "*referenceToValue: " << *referenceToValue << endl;
    cout << "refToValue: " << refToValue << endl;

    *referenceToValue = *referenceToValue * 2;

    cout << "value: " << value << endl;
    cout << "refToValue: " << refToValue << endl;
    cout << "referenceToValue: " << referenceToValue << endl;
    cout << "*referenceToValue: " << *referenceToValue << endl;

    return 0;


    int x = 2, y = 3;
    system("cls");

    passByValue(x, y);
    cout << "The new values of x and y (outside the function) are " << x << " and " << y << "\n";

    passByReference(x, y);
    cout << "The new values of x and y (after pass by ref) are " << x << " and " << y << "\n";

    passbySimulatedReference(&x, &y);
    cout << "The new values of x and y (after pass by sim ref) are " << x << " and " << y << "\n";

    cout << "The final values of x and y are " << x << " and " << y << "\n";
    cout << "\nPress a key to end...";
    system("pause > NUL");

    return 0;
}

void passByValue(int x, int y)
{
    x = x * 2;
    y = 2 * y;
    cout << "The new values of x and y (inside the function) are " << x << " and " << y << "\n";
}

void passByReference(int &x, int &y)
{
    x = x * 2;
    y = 2 * y;
}

void passbySimulatedReference(int *pointerToX, int *pointerToY)
{
    cout << pointerToX << " * " << pointerToY << "\n";
    *pointerToX = *pointerToX * 2;
    //cout << *x << " * " << *y << "\n";
    *pointerToY = 2 * *pointerToY;
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
