// CIT237:  "Process Text" sample program 
//

#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
using namespace std;

//  Global Constants:
const int SUCCESS = 0;	// return code for SUCCESS
const int FAILURE = 1;  // return code for FAILURE

//  Function Prototypes:
void processFile();

int main()
{
	processFile();
	system("pause");
	exit(SUCCESS);

}  // (end function 'main')


/*=============================================================================
*	Function:	processFile  -	 read and process file
*
*  Inputs:    none
*
*  Outputs:   file contents to console (with line numbers and string length).
*             Return value:    none.
*
*  Desciption: Prompt user for input filename.
*              Display line number, length and the actual text, 
*              for each line in the input file.
*
*---------------------------------------------------------------------------*/
void processFile()
{
	string inputText = "";
	int inputLineLength = 0;
	string inputFileName;
	ifstream inputFile;

	// Input file:  prompt for filename, open file for input.
	cout << "Enter name of input file: ";
	cin >> inputFileName;
	inputFile.open(inputFileName.c_str());

	// Check for file open error.
	if (inputFile.fail())
	{
		cout << "(line " << __LINE__ << ") Error opening file:  "
			<< inputFileName << endl;
		system("pause");
		exit(FAILURE);     // exit with error status.
	}

	int lineNumber = 0;
	while (getline(inputFile, inputText)) // (getline returns FALSE at end of file)
	{
		lineNumber++;
		inputLineLength = inputText.length();
		cout << right << setw(2) << lineNumber << " (length=" << setw(2) << inputLineLength;
		cout << "): " << left << setw(50) << inputText << endl;
	}

	inputFile.close();
}
