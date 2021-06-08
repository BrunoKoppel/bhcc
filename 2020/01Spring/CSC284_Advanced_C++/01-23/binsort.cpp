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

void bsearch (int [], int, int);

int main()
{
	int i, arr[SIZE] = { 45, 12, 34, 56, 78, -100,
						 82, 31,  8, 90, 21,   11
						 };
						 
	system("cls");
	for (i =0; i < SIZE; i++)
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
		high = n -1;
		
		while ( low <= high)
		{
			mid = (low + high) / 2;
			if (temp < arr [mid])
				high = mid -1;
			else if (temp > arr[mid])
				low = mid + 1;
		}
		for (i = n; i > low; i--)
			arr[i] = arr[i -1];
		arr[low] = temp;
	}
		for ( i= 0; i <= n; i++)
			cout << arr[i] << " ";
		cout << "\n";
	}
}
