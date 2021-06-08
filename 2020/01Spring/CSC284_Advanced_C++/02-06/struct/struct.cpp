// struct.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
using std::cout;
using std::endl;

#include<cstring>
#include <cctype>

struct names
{
    char fnames[15];
}*names[10], * temp, temp2, names2[] = { "Mary","Sally","Bob","Ted","Alice",
                                            "Sam","Ben","Jim","Betty","Tom"
                                        };

int main()
{
    for (int x = 0; x < 10; x++)
        names[x] = &names2[x];
    temp = &temp2;

    cout << "UNSORTED" << endl << endl;

    for (int x = 0; x < 10; x++)
        cout << names[x]->fnames << endl;

    for (int x = 0; x < 9; x++)
        for (int y = x + 1; y < 10; y++)
            if (_stricmp(names[x]->fnames, names[y]->fnames) > 0)
            {
                temp = names[x];
                names[x] = names[y];
                names[y] = temp;
            }
    cout << endl << "SORTED" << endl << endl;
    for (int x = 0; x < 10; x++)
        cout << _strupr(names[x]->fnames) << endl;

    cout << endl << endl;

    cout << "FIRST INITIALS" << endl << endl;

    for (int x = 0; x < 10; x++)
        cout << (char)toupper(names[x]->fnames[0]) << " for " << names[x]->fnames << endl;

    cout << endl << endl;

    cout << "LAST LETTER" << endl << endl;

    for (int x = 0; x < 10; x++)
    {
        int last = strlen(names[x]->fnames);
        cout << (char)toupper(names[x]->fnames[last - 1]) << endl;
    }

    system("pause");
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
