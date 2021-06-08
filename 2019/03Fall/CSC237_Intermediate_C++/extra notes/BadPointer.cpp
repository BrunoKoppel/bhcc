#include <iostream>
#include <string>
using namespace std;
//   CIT-237:            Demonstration of WHY a function should never 
//                       return a pointer to a local variable. 

// Function Prototypes
int product ();
int *badSumPtr(int param1, int param2);
int *dynamicSumPtr(int param1, int param2);

int main()
{
	int number1 = 4;
	int number2 = 5;
	int *resultPtr;

	resultPtr = badSumPtr(number1, number2);
	cout << "FIRST resultPtr=" << resultPtr 
		<< ", result value is " << *resultPtr << endl<< endl;
	cout << "product returned " << product() << endl<<endl;
	cout << "SECOND resultPtr=" << resultPtr 
		<< ", result value is " << *resultPtr << endl;

	system("pause");
//_______________________________________________________
	cout << "______________________________________________" << endl;

	resultPtr = dynamicSumPtr(number1, number2);
	cout << "THIRD resultPtr=" << resultPtr 
		<< ", result value is " << *resultPtr << endl<< endl;
	cout << "product returned " << product() << endl<<endl;
	cout << "FOURTH resultPtr=" << resultPtr 
		<< ", result value is " << *resultPtr << endl;

	system("pause");
} // (end main)

// Simple function which uses local variables
int product ()
{
	int data1 = 5;
	int data2 = 8;
	int outputValue;
	outputValue = data1 * data2;
	cout << "&data1=" << &data1 << ", ";
	cout << "&data2=" << &data2 << ", ";
	cout << "&outputValue=" << &outputValue << endl;
	return outputValue;
}

// Function which returns a pointer to a local variable (BAD idea).
int *badSumPtr(int param1, int param2)
{
	int sum;
	sum = param1 + param2;
	cout << "Address of sum variable = " << &sum << " Value of sum variable = " << sum << endl;
	return &sum;
}

// Function which returns a pointer to dynamically allocated variable.
int *dynamicSumPtr(int param1, int param2)   
{
	int *sumPtr;
	sumPtr = new int;
	*sumPtr = param1 + param2;
	cout << "sumPtr = " << sumPtr << " Value that sumPtr points to = " << *sumPtr << endl;
	return sumPtr;
}     