// ASM.cpp : This file contains the 'main' function. Program execution begins and ends there.
// This Program demonstrates how to include assembler in your code
//
// Written by A. Richmond
//
// Date Written: 4 May, 2009
//
// 

#include <iostream>

using std::cout;
using std::endl;

#include <iomanip>

using std::setw;

#include <cstdlib>
#include <conio.h>

int main()
{
    long number = 0;
    int x = 0;
    int y = 10;
    int z = 0;
    register int i = 0;
    char letter;

    __asm {
        mov eax, 10
        mov x, eax
        mov ebx, [y]
        mov ecx, ebx
        mov z, ecx
        add z, 10
        mov dl, 'A' + 10
        mov letter, dl
        mov number, 32767 * 2
    }

    for (i = 1; i <= 100; i++)
    {
        cout << setw(4) << i;
        if (i % 10 == 0)
            cout << endl;
    }

    cout << endl;

    cout << "x = " << x << " " << " z = " << z << endl;
    cout << "letter = " << letter << endl;
    cout << "number = " << number << endl;
    cout << "Press a key...";
    _getch();
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
