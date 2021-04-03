#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int getLowest(int numbers[],int totalNumbers)
{
	int Lowest;
	Lowest = numbers[0];
	for (int i = 1; i < totalNumbers; i++)
	{
		if (Lowest > numbers[i])
		{
			Lowest = numbers[i];
		}
	}
	return Lowest;
}

int getHighest(int numbers[],int totalNumbers)
{
	int Highest;
	Highest = numbers[0];
	for (int i = 1; i < totalNumbers; i++)
	{
		if (Highest < numbers[i])
		{
			Highest = numbers[i];
		}
	}
	return Highest;
}

int getSum(int numbers[],int totalNumbers)
{
	int sum = 0;
	for (int i = 0; i < totalNumbers; i++)
	{
		sum += numbers[i];
	}
	return sum;
}

float getAverage(int numbers[],int totalNumbers, int totalSum)
{
	return ((totalSum + 0.0) / (totalNumbers)); 
}

void clear_cin()
{
	cin.clear();
	cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

string getFileNameFromUser(string prompt)
{
	string name;
	do
	{
		cout << prompt;
		cin >> name;
		if (cin.good())
		{
			break;
		}
		else
		{
			cout << "The input is not a string, try again!" << endl;
			clear_cin();
		}
	} while (true);
	return name;
}

int ReadingFile(int numbers[], int ARRAY_SIZE, ifstream& inputFile, string fileName)
{
	inputFile.open(fileName);
	cout << "Reading data from the file..." << endl;
	int i = 0;
	while (inputFile >> numbers[i])
	{
		i++;
	}
	return i;
}

void DisplayNumbers(int numbers[], int ARRAY_SIZE)
{
	for (int i = 0; i < ARRAY_SIZE; i++)
	{
		cout << numbers[i] << endl;
	}
}

void printResults(int numbers[],int totalNumbers,int finalLowest,int finalHighest,int totalSum,float finalAverage)
{
	cout << totalNumbers << " numbers read from input file." << endl;
	cout << "The highest value is " << finalHighest << endl;
	cout << "The lowest value is " << finalLowest << endl;
	cout << "The sum of the numbers is " << totalSum << endl;
	cout << "The average of the numbers is " << finalAverage << endl;
	system("pause"); 
}

int main()
{
	ifstream inputFile;
	int totalNumbers = 0;
	float finalAverage = 0.0;
	const int ARRAY_SIZE = 12;
	int numbers[ARRAY_SIZE];
	int totalSum = 0;
	int finalLowest = 0;
	int finalHighest = 0;
	string fileName;

	fileName = getFileNameFromUser("Enter name of input file: ");
	
	totalNumbers = ReadingFile(numbers, ARRAY_SIZE, inputFile, fileName);
	
	//DisplayNumbers(numbers, ARRAY_SIZE);
	
	totalSum = getSum(numbers, totalNumbers);
	
	finalAverage = getAverage(numbers, totalNumbers, totalSum);
	
	finalLowest = getLowest(numbers, totalNumbers);
	
	finalHighest = getHighest(numbers, totalNumbers);
	
	printResults(numbers, totalNumbers, finalLowest, finalHighest, totalSum, finalAverage);
	
	return 0;
}
