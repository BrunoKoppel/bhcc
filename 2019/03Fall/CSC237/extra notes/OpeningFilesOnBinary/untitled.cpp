#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main()
{
	ifstream inFile;
	ofstream outFile;
	string FileContents[10];
	int i = 0;
	
	inFile.open("a.txt", ios:: binary);
	
	while (getline(inFile, FileContents[i]))
	{
		i++;
	}
	
	inFile.close();
	
	outFile.open("testFromTest.txt");
	
	for (int j = 0; j < i; j++)
	{
		cout << FileContents[i] << endl;
		outFile << FileContents[i] << endl;
	}
	
	outFile.close();
	
	return 0;
}
