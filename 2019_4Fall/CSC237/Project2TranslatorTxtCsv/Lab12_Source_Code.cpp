#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
#include <vector>

using namespace std;

struct FileText
{
	int lineNumber;
	unsigned long long fileOffset;
	int length;
	string contents;
};

void readFile(fstream& dFile, FileText& fileInUse, string& inputFileName, string& outputFileName, fstream& outFile);

string getInputFileName(string prompt);

void outPutFileProccesing(fstream& outFile, string outputFileName, FileText& fileInUse, bool& endol);


int main()
{
	string inputFileName, outputFileName;
	fstream dFile, outFile;
	FileText fileInUse;

	inputFileName = getInputFileName("Enter filename of input file: ");

	readFile(dFile, fileInUse, inputFileName, outputFileName, outFile);

	cout << "\n\nThe Output from this file processing has been saved to ---> " << outputFileName << "\n\n" << endl;
	
	system("pause");
	return 0;
}

void readFile(fstream &dFile, FileText& fileInUse, string& inputFileName, string& outputFileName, fstream& outFile)
{
	bool endol = false;

	dFile.open(inputFileName, ios::in);
	while (dFile.fail())
	{
		inputFileName = getInputFileName("The filename you entered doesn't exists\nTry again, enter the filename of input file: ");
		dFile.open(inputFileName, ios::in);
	}
	
	outputFileName = "Output from " + inputFileName;


	streampos Offset = dFile.tellg();
	fileInUse.fileOffset = Offset;
	fileInUse.lineNumber = 1;

	while (getline(dFile, fileInUse.contents))
	{
		fileInUse.length = fileInUse.contents.length();

		outPutFileProccesing(outFile, outputFileName, fileInUse, endol);

		fileInUse.contents = "";
		fileInUse.lineNumber++;
		streampos Offset = dFile.tellg();
		fileInUse.fileOffset = Offset;
	}
	if (dFile.eof())
	{
		endol = true;
		outPutFileProccesing(outFile, outputFileName, fileInUse, endol);
	}

	dFile.close();
}

string getInputFileName(string prompt)
{
	string name;
	cout << prompt;
	getline(cin, name);
	return name;
}

void outPutFileProccesing(fstream& outFile, string outputFileName, FileText& fileInUse, bool& endol)
{
	if (endol)
	{
		outFile.open(outputFileName, ios::out | ios::app);

		outFile << "\n\n output from one iteration done\n" << endl;
	}
	else
	{
		cout << fileInUse.lineNumber << " <"
			 << fileInUse.fileOffset << ","
			 << fileInUse.length << ">: "
			 << fileInUse.contents << endl;

		outFile.open(outputFileName, ios::out | ios::app);

		outFile << fileInUse.lineNumber << " <"
				<< fileInUse.fileOffset << ","
				<< fileInUse.length << ">: "
				<< fileInUse.contents << endl;
	}

	outFile.close();
}
