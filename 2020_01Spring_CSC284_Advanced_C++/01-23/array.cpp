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
	const int SIZEOFINT =4;
	int array[] = {3,10,4,2,5,12,14,0,77,33};
	int temp;
	
	for (int x = 0; x < sizeof(array)/SIZEOFINT - 1; x++)
		for (int y = x + 1; y < sizeof(array)/SiZEOFINT; y++)
			if (array[x] > array [y])
			{
				temp = array[x];
				array[x] = array[y];
				array[y] = temp;
			}
			
	for (int x = 0; x < sizeof(array)/SiZEOFINT; x++)
	
		cout << array[x] << " ";
		
	cout << endl;
	for (int x = sizeof(array)/SiZEOFINT - 1; x >= 0; x--)
	
		cout << array[x] << " ";
	cout << endl;
	_getch();
	return 0;
}

