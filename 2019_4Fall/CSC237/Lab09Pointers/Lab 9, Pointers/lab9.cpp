//
//  main.cpp
//  Lab 9, Pointers
//
//  Created by Bruno Koppel on 9/29/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int inputArraySizeValue (string prompt);
int populateIntegerArray(int *arrayPtr, int arraySize, int i);
void displayIntegerArray(int *arrayPtr, int arraySize);
int findMaximumInteger(int *arrayPtr, int arraySize);

int main(int argc, const char * argv[]) 
{
    int arraySize;
    arraySize = inputArraySizeValue("What's going to be the size of the array?: ");
    int *arrayValues = new int [arraySize];
    int biggestNumber;
    
    for (int i = 0; i < arraySize; i++)
    {
		arrayValues[i] = populateIntegerArray(arrayValues, arraySize, i);
	}
    
    displayIntegerArray(arrayValues, arraySize);
	biggestNumber = findMaximumInteger(arrayValues, arraySize);
    cout << "Maximum integer in array is: " << dec << biggestNumber << endl;
    cout << "DELETING array at arrayPtr = " << arrayValues;
    delete [] arrayValues;
    return 0;
}

int populateIntegerArray(int *arrayPtr, int arraySize, int i)
{
	int num;
	cout << "Enter value for array element " << i << ": " ;
	cin >> num;
	return num;
}

int inputArraySizeValue (string prompt)
{
	int size; 
	cout << prompt;
	cin >> size;
	return size;
}

void displayIntegerArray(int *arrayPtr, int arraySize)
{
	int *arrayElemPtr;
	for (int i = 0; i < arraySize; i++)
    {
		arrayElemPtr = &arrayPtr[i];
		cout << setfill (' ') << dec << arrayElemPtr << ":  arrayPtr[" << setw(2) << i << "] = " << setw(15) << arrayPtr[i] 
			 << "  (Hex " << setw(8) << setfill ('0') << hex << arrayPtr[i] << ")" << endl;
	}
}

int findMaximumInteger(int *arrayPtr, int arraySize)
{
	int number = arrayPtr[0];
	for (int i = 0; i < arraySize; i++)
	{
		if (number < arrayPtr[i])
		{
			number = arrayPtr[i];
		}
	}
	return number;
}
