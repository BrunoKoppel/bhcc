#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

string getFileNameFromUser (string prompt)
{
	string name;
	cout << prompt;
	getline(cin, name);
	return name;
}

int readFile (fstream& myFile, string inputFileName, string unprocessedTextLines[])
{
	myFile.open(inputFileName);
	int i = 0;
    if (!myFile)
    {
      cout << "File inputting failure! FILE HAS NOT BEEN FOUND!";
    }
    else
    {
        while(getline(myFile, unprocessedTextLines[i]))
        {
			i++;
        }
    }
    myFile.close();
    return i;
}

void writeFile (fstream& myFile,string outputFileName, string processedTextLines[], int numberOfLines, string unprocessedTextLines[])
{
	ofstream outputFile;
	outputFile.open(outputFileName);
    if (!outputFile)
    {
      cout << "File outputting failure! Check where the output went!";
    }
    else
    {
        for (int i = 0; i < numberOfLines; i++)
		{
			outputFile << unprocessedTextLines[i] << endl;
		}
    }
    myFile.close();
}

void processorTXTtoCSV (string unprocessedTextLines[], string processedTextLines[], int numberOfLines)
{
	const char delimeter = "|";
	for (int i = 0; i < numberOfLines; i++)
	{
		int pos = unprocessedTextLines[i].find(delimeter);
	}
	
}

void processorCSVtoTXT (string unprocessedTextLines[], string processedTextLines[])
{
	
}

void printHelpMenu()
{
	cout << "HELP MENU:" << endl;
	cout << "i: Designate the name of the file from which we are taking information. " << endl;
	cout << "o: Designate the name of the file to which we are saving the processed information. " << endl;
	cout << "p: Run the Text Processor (make sure you have assigned an input and output location on the i and o commands). " << endl;
	cout << "m: changes the processing direction from txt to csv or vice versa" << endl;
	cout << "h: Prints this help menu. " << endl;
	cout << "q: Exits this Program." << endl;
	
}

void printIt(string unprocessedTextLines[], int numberOfLines)
{
	for (int i = 0; i < numberOfLines; i++)
	{
		cout << unprocessedTextLines[i] << endl;
	}
}

void clear_cin()
{
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

int main()
{
	bool state = true;
	bool processingMode = true; // true is txt to csv, false is csv to txt.
	int numberOfLines = 0;
	string inputFileName, outputFileName;
	string unprocessedTextLines[10];
	string processedTextLines[10];
	fstream myFile;
	char command;
	
	cout << "\nWelcome to the TXT to CSV converter (press m to change to CSV to TXT)" << endl;
	while (state)
	{
		
		cout << "\nEnter a letter command to continue (press h for a list of accepted commands): ";
		cin >> command;
		clear_cin();
		if (command == 'i')
		{
			inputFileName = getFileNameFromUser("Enter the name of the file from which we are taking input: ");
			
			//printIt(unprocessedTextLines, numberOfLines);
			
		}
		else if (command == 'o')
		{
			outputFileName = getFileNameFromUser("Enter the name of the file tp which we are outputting results: ");
			
		}
		else if (command == 'p')
		{
			
			if (processingMode)
			{
				size_t inputPos = inputFileName.find(".txt");
				size_t outputPos = outputFileName.find(".csv");
				
				if (inputPos < 50 && outputPos < 50)
				{
					string inputFileExtension = inputFileName.substr(inputPos,4);
					string outputFileExtension = outputFileName.substr(outputPos,4);
					
					if ( inputFileExtension == ".txt" && outputFileExtension == ".csv" )
					{
						numberOfLines = readFile(myFile, inputFileName, unprocessedTextLines);
						cout << "TXT TO CSV  RAN!" << endl;
						//processorTXTtoCSV(unprocessedTextLines, processedTextLines, numberOfLines);
						writeFile (myFile, outputFileName, processedTextLines, numberOfLines, unprocessedTextLines);
					}
					else 
					{
						cout << "Check the extension on your input and output file names" << endl; 
					}
					
				}
				else
				{
					cout << "Check the extension on your input and output file names" << endl; 
				}
				
				
			}
			else
			{
				size_t inputPos = inputFileName.find(".csv");
				size_t outputPos = outputFileName.find(".txt");
				
				if (inputPos < 50 && outputPos < 50)
				{
					string inputFileExtension = inputFileName.substr(inputPos,4);
					string outputFileExtension = outputFileName.substr(outputPos,4);
					
					if ( inputFileExtension == ".csv" && outputFileExtension == ".txt" )
					{
						numberOfLines = readFile(myFile, inputFileName, unprocessedTextLines);
						cout << "CSV TO TXT  RAN!" << endl;
						//processorCSVtoTXT(unprocessedTextLines, processedTextLines);
						writeFile (myFile, outputFileName, processedTextLines, numberOfLines, unprocessedTextLines);
						
					}
					else 
					{
						cout << "Check the extension on your input and output file names" << endl; 
					}
				}
				else
				{
					cout << "Check the extension on your input and output file names" << endl; 
				}
			}
			
		}
		else if (command == 'm')
		{
			
			if (processingMode)
			{
				processingMode = false;
				cout << "Now you are proccessing CSV files into TXTs" << endl;
			}
			else
			{
				processingMode = true;
				cout << "Now you are proccessing TXT files into CSVs" << endl;
			}
		}
		else if (command == 'h')
		{
			printHelpMenu();
		}
		else if (command == 'q')
		{
			cout << "Exiting Program..." << endl;
			state = false;
		}
		else
		{
			cout << "You have entered the wrong command. try again..." << endl;
		}
	}
	
	return 0;
}
