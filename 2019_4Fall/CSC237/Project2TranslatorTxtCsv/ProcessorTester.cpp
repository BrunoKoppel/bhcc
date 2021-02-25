#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>

using namespace std;

const int MAX_NUMBER_OF_LINES = 10;
const int MAX_NUMBER_OF_FIELDS = 200;

int main()
{
	
	fstream outFile;
	string inputFileName = "sample1.txt";
	string outputFileName = "testing.csv";
	string unprocessedTextLines[MAX_NUMBER_OF_LINES];
	string lineArray[MAX_NUMBER_OF_FIELDS];
	string processedTextLines[MAX_NUMBER_OF_LINES];
	
	fstream inFile;
	inFile.open(inputFileName);
	
	int numberOfLines = 0;
	while (getline(inFile, unprocessedTextLines[numberOfLines]))
	{
		numberOfLines++;
	}
	inFile.close();
	
	outFile.open(outputFileName);
	
	const string delimeter = "|";
	
	
	
	for (int i = 0; i < numberOfLines; i++)
	{
		
		for (int j = 0; j < MAX_NUMBER_OF_FIELDS; j++)
		{
			if(unprocessedTextLines[i][j] != delimeter)
			{
				processedTextLines[i][j] = unprocessedTextLines[i][j];
			}
		}
		
	}
	
	outFile.close();

	
	return 0;
}
