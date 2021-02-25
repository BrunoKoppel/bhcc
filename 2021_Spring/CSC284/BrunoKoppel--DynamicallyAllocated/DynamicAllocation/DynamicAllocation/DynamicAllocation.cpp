// DynamicAllocation.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
#include <exception>
#include <time.h>
#include <iomanip>

double makeArray(const int max, const int min, const int size);
int randBetween(int min, int max);
double division(double a, int b);


int main()
{
	float sum = 0;
	float average = 0;
	double arrayOfDoubles[2000];
	std::setprecision(9);
	std::fixed;
	for (int iteration = 0; iteration < 2000; iteration++) {
		arrayOfDoubles[iteration] = makeArray(-5, 5, 10000);
		sum = sum + arrayOfDoubles[iteration];
		average = sum / (static_cast<double>(iteration) + 1.00);
		std::cout << "Sum = " << sum << "\t, Average = " << average << std::endl;
	}
}

double makeArray( const int min, const int max, const int size) {
	int* arrayOfIntegers = new int[size] ;
	double result = 0;
	for (int index = 0; index < size; index++) {
		if (index == 0) {
			result = arrayOfIntegers[index] = randBetween(min, max);
		}
		if (index > 0 && index < (size - 1)) {
			try {
				result = division(result, arrayOfIntegers[index]);
			}
			catch (std::string error) {
				//std::cout << error << std::endl;
			}
			
		}
	}
	return result;
}

int randBetween(int min, int max) {
	unsigned long seed;
	srand((unsigned)time(NULL));
	return (rand() % (max - min)) - min;
}

double division(double a, int b) {
	if (b == 0) {
		throw "Division by zero condition!";
	}
	return (a / b);
}