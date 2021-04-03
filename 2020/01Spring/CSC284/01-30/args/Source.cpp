/* 
This little program will show you how to pass a command-line
argument to a constructor.

Written by Arland J.Richmond

Date Written: 4 February, 2002
*/

#include <iostream>
using std::cout;
using std::endl;

#include <cstdlib>
#include <conio.h>

class Args
{
	char* argument;
public:
	Args(char* myArg)
	{
		argument = myArg;
	}
	void showIt()
	{
		cout << "the command-line argument is " << argument << endl;
	}
};

int main(int argc, char** argv)
{
	cout << argc << endl;
	if (argc < 2)
	{
		cout << "Invalid number of command-line arguments!\n";
		cout << "\nHit a key...";
		_getch();
		return 1;
	}

	cout << "main print out: " << argv[0] << endl;
	cout << "main print out: " << argv[1] << endl;
	cout << "main print out: " << argv[2] << endl;

	Args myArgs(*(argv));
	myArgs.showIt();
	cout << "\nHit a key...";
	_getch();

	return 0;
}