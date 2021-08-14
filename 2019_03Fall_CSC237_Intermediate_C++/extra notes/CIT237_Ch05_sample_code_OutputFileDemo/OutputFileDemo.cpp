// This program reads data from one file and writes different data to another file.
#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
using namespace std;

int main()
{
	ifstream inputFile;
	ofstream outputFile;
	string input_filename;
	string output_filename;
	int number;

	// Get the input filename from the user.
	cout << "Enter the input filename: ";
	cin >> input_filename;

	// Open the file.
	inputFile.open(input_filename.c_str());
	if (!inputFile) {
		{
			// Display an error message.
			cout << "Error opening the input file " << input_filename << ".\n";
			exit(-1);
		}
	}

	// Get the output filename from the user.
	cout << "Enter the output filename: ";
	cin >> output_filename;

	// Open the file.
	outputFile.open(output_filename.c_str());
	if (!outputFile) {
		{
			// Display an error message.
			cout << "Error opening the output file " << output_filename << ".\n";
			exit(-1);
		}
	}

	// Output column headings

	outputFile << setw(12) << "number" << setw(15) << "square" << setw(15) << "cube" << endl;
	outputFile << setw(12) << "______" << setw(15) << "______" << setw(15) << "____" << endl;

	// Read the numbers from the file and
	// display them.
	while (inputFile >> number)
	{

		cout << "Processing input data: " << number << endl;
		outputFile << setw(12) << number << setw(15) << number*number << setw(15) << number*number*number << endl;
	}

	// Close the files.
	inputFile.close();
	outputFile.close();

	system("pause");
	return 0;
}