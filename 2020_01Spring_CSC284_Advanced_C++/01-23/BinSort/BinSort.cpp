// BinSort.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

/* Program uses insertion sort with binary search
 *
 * Written by Arland J. Richmond
 *
 * Date Written: January 12, 1999
 */

#include <iostream>
using std::cout;

#include <cstdlib> // This is the C Standard Library



const int SIZE = 12;

void bsearch(int[], int, int);

int main()
{
	int i, arr[SIZE] = { 45, 12, 34, 56, 78, -100,
						 82, 31,  8, 90, 21,   11
						};

	system("cls");
	for (i = 0; i < SIZE; i++)
		bsearch(arr, arr[i], i);
	cout << "\nPress a key...";
	system("pause > NUL");
	return 0;
}


void bsearch(int arr[], int temp, int n)
{
	int low, high, mid, i = 0;
	if (n == 0)
		arr[i] = temp;
	else
	{
		low = 0;
		high = n - 1;

		while (low <= high)
		{
			mid = (low + high) / 2;
			if (temp < arr[mid])
				high = mid - 1;
			else if (temp > arr[mid])
				low = mid + 1;
		}
		for (i = n; i > low; i--)
			arr[i] = arr[i - 1];
		arr[low] = temp;
	}

	cout << "\nIteration #" << n + 1 << ": " << std::endl;

	for (i = 0; i <= n; i++)
		cout << arr[i] << " ";
	cout << "\n";
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
