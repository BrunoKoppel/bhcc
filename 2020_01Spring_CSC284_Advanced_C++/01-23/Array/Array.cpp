// Array.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
/* This program shows you how to sort an array
 * then prints it forward and backwards
 *
 * Written by A. Richmond
 *
 * Date Written: 27 October, 2008
 */


#include <iostream>

using std::cout;
using std::endl;
#include <conio.h>

int main()
{
	const int SIZEOFINT = 4;
	int array[] = { 3,10,4,2,5,  12,14,0,77,33 };
	int temp;

	cout << "|DEBBUGING| - The size of the array is: " << sizeof(array) << endl;
	cout << "|DEBBUGING| - The opperation is equal to: " << sizeof(array) / SIZEOFINT - 1 << endl;
	cout << "|DEBBUGING| - The opperation is equal to: " << sizeof(array) / SIZEOFINT << endl;

	for (int x = 0; x < sizeof(array) / SIZEOFINT - 1; x++)
		for (int y = x + 1; y < sizeof(array) / SIZEOFINT; y++)
			if (array[x] > array[y])
			{
				temp = array[x];
				array[x] = array[y];
				array[y] = temp;
			}

	for (int x = 0; x < sizeof(array) / SIZEOFINT; x++)

		cout << array[x] << " ";

	cout << endl;
	for (int x = sizeof(array) / SIZEOFINT - 1; x >= 0; x--)

		cout << array[x] << " ";
	cout << endl;
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
