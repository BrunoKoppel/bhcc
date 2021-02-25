// Sample program to illustrate the use of the splitLineToArray function.
//

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

						//  Global Variable:
bool verboseMode = false;

//   Constants related to file format:
const int MAX_NUMBER_OF_FIELDS = 20;
const string DEFAULT_DELIMITER = "|";

//    Global constants
const int SUCCESS = 0;
const int FAILURE = 1;

//  Function Prototypes:

void openInputFile(string & inputFileName, ifstream & inputFile);
void openOutputFile(string & outputFileName, ofstream & outputFile);
void setDelimiter(string & delimiter);


int processDataFile(ifstream& infile, ofstream& outfile, string delimiter);
int splitLineToArray(string inputText, string inputDelim, string outputFieldArray[], int maxFields);
void outputHelpMessage();
void quitProgram(int exitStatus);


int main()
{
	// Local variables for 'main' function:	
	string command;			//	command string, input by user

	ifstream inputFile;
	ofstream outputFile;
	string inputFileName;
	string outputFileName;
	

	string inputText;
	string delimiter = DEFAULT_DELIMITER;


	while (true)
	{

		// Prompt for command input.
		cout << "\nCommand: ";
		getline(cin, command);

		cout << fixed << setprecision(2);

		if (command == "")
		{
			// ignore empty command
		}
		else if (command == "CI")
		{
			inputFile.close();
			
		}
		else if (command == "CO")
		{
			outputFile.close();
		}
		else if (command == "d")
		{
			setDelimiter(delimiter);		
		}
		else if (command == "h" || command == "help")
		{
			// Output help text
			outputHelpMessage();
		}
		else if (command == "i")
		{
			openInputFile(inputFileName, inputFile);
		}
		else if (command == "o")
		{
			openOutputFile(outputFileName, outputFile);
		}
		else if (command == "p")
		{
			processDataFile(inputFile, outputFile, delimiter);
		}
		else if (command == "q" || command == "quit")
		{
			// Quit program
			quitProgram(SUCCESS);
		}
		else if (command == "v" || command == "verbose")
		{
			if (verboseMode == true)
			{
				cout << "Clearing verboseMode." << endl;
				verboseMode = false;
			}
			else
			{
				cout << "Setting verboseMode." << endl;
				verboseMode = true;
			}
		}
		else
			cout << "Invalid command:  " << command << endl;

	}  // (end 'while')
	system("pause");
	return 0;
}  // (end function 'main')

   /*=============================================================================
   *  Function:   outputHelpMessage - Output short description of commands.
   *
   *  Inputs:     none
   *
   *  Outputs:
   *      Outputs help text to the cout stream
   *
   *  Desciption:
   *		Output (to the screen) a short description of each interactive command
   *      supported by the program.
   *
   *---------------------------------------------------------------------------*/
void outputHelpMessage()
{
	// Help text.
	cout << "Supported commands: \n"
		<< "	CI		Close input file.\n"
		<< "	CO		Close output file.\n"
		<< "	d		set delimiter.\n"
		<< "	h		print this help text.\n"
		<< "	i		open file for input\n"
		<< "	o		open file for output\n"
		<< "	p		(lower case 'p') process data file.\n"
		<< "	q		quit (end the program).\n"
		<< "	v		set or clear verbose mode.\n"
		<< endl;

} // (end function 'outputHelpMessage')

  /*=============================================================================
  *	 Function:	quitProgram  -	 Exit the program, returning status from caller
  *
  *  Inputs:
  *      exitStatus =         Exit code to be returned to operating system.
  *
  *  Outputs:
  *      exits the program, passing status value from caller
  *
  *
  *  Desciption:
  *		Exit the program
  *
  *---------------------------------------------------------------------------*/
void quitProgram(int exitStatus)
{
	cout << "Exitting program with status = " << exitStatus << endl;
	system("pause");
	exit(exitStatus);

} // (end function 'quitProgram')




// ********************************************************
// The processDataFile function reads lines of text from inFile 
// splits each line into an array of strings, and 
// outputs the strings to outfile.       
// The return value is the number of lines read.
// ********************************************************
int processDataFile(ifstream& infile, ofstream& outfile, string delimiter)
{
	int lineCount = 0;
	string inputBuffer;
	string textArray[MAX_NUMBER_OF_FIELDS];
	int fieldCount = 0;

	while (getline(infile, inputBuffer)) {
	
		fieldCount = splitLineToArray(inputBuffer, delimiter, textArray, MAX_NUMBER_OF_FIELDS);
		lineCount++;
		cout <<endl<< "Line " << lineCount << " contains " << fieldCount << " fields." << endl;
		for (int i = 0; i < fieldCount; i++) {
			cout << "Line " << lineCount << ", field " << i << "= " << textArray[i] << endl;
			outfile << "Line " << lineCount << ", field " << i << "= " << textArray[i] << endl;
		}
	}
	cout << lineCount << " lines of text read from input file." << endl;
	return lineCount;
}

/*=============================================================================
*  Function: splitLineToArray - Scan through one line of text, output fields to array.
*  Inputs:
*      inputText =  string containing one line of text.
*      inputDelim = string containing the delimiter character
*                       (separates one data field from the next).
*      maxFields =  Maximum number of fields
*  Outputs:
*      returns the number of fields found.
*      outputFieldArray[] = array of strings containing output fields
*
*  Desciption:
*      Starting at the beginning of the inputText string, scan for each
*      occurrence of the inputDelimiter character/string.  The first data field begins
*      at the starting position and ends at the position before the delimiter
*      character.
*      The SECOND data field begins at the position AFTER the delimiter, and
*      extends to the position before the NEXT ocurrence of the delimiter.
*      If no delimiter is found, the the current data field extends to the
*      end of the line.
*
*---------------------------------------------------------------------------*/

int splitLineToArray(string inputText, string inputDelim,
	string outputFieldArray[], int maxFields)
{
	//	Local Variables:
	int nextFieldPosition = 0;		//	Start position of data field.
	int foundPosition;				//  Position where delimiter was found,
	int fieldCount = 0;		        //  Number of data fields found so far,
	bool endOfLine = false;			//	Flag -- end of input line detected,
	string dataField;				//  Copy of the data field.

	if (verboseMode) {
		cout << "     Enter 'splitLineToArray' function, " << endl
			<< "     inputText = (" << inputText << ")" << endl
			<< "     nextFieldPosition = " << nextFieldPosition
			<< endl;
	}
	while (!endOfLine)
	{
		foundPosition = inputText.find(inputDelim, nextFieldPosition);
		if (foundPosition == -1)
		{
			// (Here if the string 'find' function reached the end of the input string.)
			endOfLine = true;
			if (verboseMode) {
				cout << "     delimiter not found for inputText = " << inputText << endl
					<< "          (search began at position " << nextFieldPosition << ")."
					<< endl;
			}
			foundPosition = inputText.length();

			if (foundPosition > nextFieldPosition)
			{
				dataField = inputText.substr(nextFieldPosition,
					foundPosition - nextFieldPosition);
				if (verboseMode) {
					cout << "     dataField = " << dataField << endl;
				}
				fieldCount++;
			}
		}
		else
		{
			// (Here if 'inputDelim' was found in the input string.)
			// Copy the data field contents from the input string to the
			// 'dataField' local variable.
			dataField = inputText.substr(nextFieldPosition, foundPosition - nextFieldPosition);
			fieldCount++;

			// Adjust 'nextFieldPosition' as preparation for finding NEXT delimiter.
			nextFieldPosition = foundPosition + 1;
			if (verboseMode) {
				cout << "     dataField = " << dataField << ", nextFieldPosition = "
					<< nextFieldPosition << endl;
			}
		}

		if (fieldCount > 0)
		{
			if (fieldCount > maxFields)
			{
				cout << "ERROR at line __LINE__: too many input fields, fieldCount="
					<< fieldCount << endl;
			}
			else
			{
				outputFieldArray[fieldCount - 1] = dataField;
			}
		}
	} // (end while)

	if (verboseMode) {
		//	Before returning to the caller, display the 
		//    found data fields, as a debug aid:
		for (int i = 0; i < fieldCount; i++)
		{
			cout << "     outputFieldArray[" << i << "] = " << outputFieldArray[i] << endl;
		} // (end for)	
	}
	return fieldCount;
} // (end function splitLineToArray )

 

/*=============================================================================
   *  Function:    openInputFile - Open input file
   *
   *  Inputs:
   *
   *  Outputs:
   *      inputFileName     string variable to hold file name
   *      inputFile         ifstream object.
   *
   *  Desciption:
   *	  Ask the user to enter the filename.
   *      Open the file.
   *
   *---------------------------------------------------------------------------*/
void openInputFile(string & inputFileName, ifstream & inputFile) {
	cout << "Enter input filename:  ";
	getline(cin, inputFileName);
	inputFile.open(inputFileName);
	// Check for file open error.
	if (inputFile.fail())
	{
		cout << "(line " << __LINE__ << ") Error opening file:  " << inputFileName << endl;
	}
}  // (end function openInputFile)

/*=============================================================================
   *  Function:     openOutputFile - Open output file
   *
   *  Inputs:
   *
   *  Outputs:
   *      outputFileName     string variable to hold file name
   *      outputFile         ofstream object.
   *
   *  Desciption:
   *	  Ask the user to enter the filename.
   *      Open the file.
   *
   *---------------------------------------------------------------------------*/
void openOutputFile(string & outputFileName, ofstream & outputFile) {
	cout << "Enter output filename:  ";
	getline(cin, outputFileName);
	outputFile.open(outputFileName);
	// Check for file open error.
	if (outputFile.fail())
	{
		cout << "(line " << __LINE__ << ") Error opening file:  " << outputFileName << endl;
	}
}  // (end function openOutputFile)


/*=============================================================================
   *  Function:   setDelimiter - input new delimiter from console
   *
   *  Inputs:
   *
   *  Outputs:
   *      delimiter          string variable to hold field delimiter
   *
   *  Desciption:
   *	  Ask the user to enter the delimiter character / string.
   *      Pass the new delimiter to the caller.
   *
   *---------------------------------------------------------------------------*/
void setDelimiter(string & delimiter) {
	cout << "Existing delimiter = \"" << delimiter << "\".  Enter new delimiter: ";
	getline(cin, delimiter);
	cout << "New delimiter = \"" << delimiter << "\"."<<endl;
}
