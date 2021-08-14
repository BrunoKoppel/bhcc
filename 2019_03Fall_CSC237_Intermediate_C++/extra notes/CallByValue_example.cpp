// CIT237:  "Call-by-Value" example program 
//

#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
using namespace std;

						//  Function Prototypes:
int sum(int, int);
int otherFunction(int, int);

int main()
{
	int first, second, result, otherResult;

	cout << "Enter two integer values: ";
	cin >> first;
	cin >> second;

	result = sum(first, first  );
	cout << "main: first=" << first 
		 << ", second=" << second 
		 << ", result=" << result << endl;


	otherResult = otherFunction(first, second);
	cout << "main: first=" << first 
		 << ", second=" << second 
		 << ", otherResult=" << otherResult << endl<<endl;

	system("pause");
	exit(0);

}  // (end function 'main')

// Function:  sum
int sum(int number1, int number2) {
	int localVariable;
	localVariable = number1 + number2;
	cout << "sum: number1=" << number1
		<< ", number2=" << number2
		<< ", localVariable=" << localVariable << endl;
	return localVariable;
} // (end function 'sum')

// Function:  otherFunction
int otherFunction(int number1, int number2) {
	number1 = number1 + number2;
	cout << "otherFunction: number1=" << number1
		<< ", number2=" << number2 << endl;
	return number1;
	
} // (end function 'otherFunction')
