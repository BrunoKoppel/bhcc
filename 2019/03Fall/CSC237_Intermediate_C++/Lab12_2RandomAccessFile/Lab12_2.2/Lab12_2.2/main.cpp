//
//  main.cpp
//  Lab12_2
//
//  Created by Bruno Koppel on 11/4/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <istream>
#include <iostream>
#include <sstream>
#include <string>
#include <fstream>

using namespace std;

fstream fileStream;
char *fileBuffer = new char [10000];

void clearCin();
string getName(string prompt);
int getNumberFromUserInput(string prompt);
string getStringFromUserInput(string prompt);
char getCharacter(string prompt);

string printHelpMenu();

bool openFileInMode(string &filename, ifstream& inFile, bool binaryMode, bool openFile);
bool closeFileFunction(string filename, ifstream& inFile, ofstream& outFile);

//Buffer Memory
int readFileAtUserInputIndex(ifstream& inFile, char mainBuffer[], int &readIndex, bool MBCI[]);
void outputCharacterBuffer(char currentBuffer[], char mainBuffer[], int length, int readIndex);
void transferTemporaltoMainBuffer(char temporalBuffer[], char mainBuffer[], int length, int readIndex, bool MBCI[]);

int writeFileAtUserInputIndex(char mainBuffer[], string& overwriteUserInput, bool MBCI[]);
void writeStringtoMainBuffer(char mainBuffer[], int writeIndex, string overwriteUserInput, bool MBCI[]);


//File writing
void flushOutMainBuffer(ofstream &outFile, bool binaryMode, string &filename, char mainBuffer[]);

int main()
{
   
    ifstream inFile;
    ofstream outFile;
    streampos flushPosition[10];
    
    string overwriteUserInput = "";
    string filename = "Gettysburg.txt";
    
    int indexLengths[10];
    int numberOfWrites = 0;
    int numberOfReads = 0;
    int readIndex = 0;
    
    bool MBCI[5000];
    char *mainBuffer = new char[5000];
    
    bool binaryMode = false;
    bool openFile = false;
    bool MachineState = true;
    
    for (int j = 0; j < 5000; j++)
    {
        mainBuffer[j] = NULL;
        MBCI[j] = true;
    }
    
    while (MachineState)
    {
        
        char command = getCharacter("Enter Command (or 'h' for help): ");
        clearCin();
        if (command == 'h' or command == 'H')
        {
            cout << printHelpMenu() << endl;
        }
        else if (command == 'r' or command == 'R')
        {
            if (openFile)
            {
                indexLengths[numberOfReads] = readFileAtUserInputIndex(inFile, mainBuffer, readIndex, MBCI);
                numberOfReads++;
            }
            else
            {
                cout << "FILE NOT OPEN, PRESS B/b OR T/t TO OPEN A FILE" << endl;
            }
            
        }
        else if (command == 'w' or command == 'W')
        {
            if (openFile)
            {
                flushPosition[numberOfWrites] = writeFileAtUserInputIndex(mainBuffer, overwriteUserInput, MBCI);
                numberOfWrites++;
            }
            else
            {
                 cout << "FILE NOT OPEN, PRESS B/b OR T/t TO OPEN A FILE" << endl;
            }
            
        }
        else if (command == 'b' or command == 'B')
        {
            binaryMode = true;
            openFile = openFileInMode(filename, inFile, binaryMode, openFile);
        }
        else if (command == 't' or command == 'T')
        {
            binaryMode = false;
            openFile = openFileInMode(filename, inFile, binaryMode, openFile);
        }
        else if (command == 'c' or command == 'C')
        {
            openFile = closeFileFunction(filename, inFile, outFile);
        }
        else if (command == 'p' or command == 'P')
        {
            for (int X = 0; X < 5000; X++)
            {
                
                if (mainBuffer[X] != NULL)
                {
                    cout << "#" << X << ": ";
                    if ((static_cast<int>(mainBuffer[X]) == 32) or (static_cast<int>(mainBuffer[X]) == 10) or (static_cast<int>(mainBuffer[X]) == 13))
                    {
                        cout << " " << static_cast<int>(mainBuffer[X]) << " " << endl;
                    }
                    else
                    {
                        cout << "'" << mainBuffer[X] << "'(" << static_cast<int>(mainBuffer[X]) << ") " << endl;
                    }
                }
                
            }
            
        }
        else if (command == 'f' or command == 'F')
        {
            flushOutMainBuffer(outFile, binaryMode, filename, mainBuffer);
        }
        else if (command == 'v' or command == 'V')
        {
            
        }
        else if (command == 'q' or command == 'Q')
        {
            cout << "This program is closing... Goodbye!" << endl;
            MachineState = false;
        }
        else
        {
            cout << "You entered a command that does not exists (press h for a list of supported commands)" << endl;
        }
    }
    return 0;
}

string printHelpMenu()
{
    stringstream stream;
    stream << "Supported commands:" << endl;
    stream << "\t\t b" << "\t\t open file for input AND output, in BINARY mode." << endl;
    stream << "\t\t t" << "\t\t open file for input AND output, in TEXT mode." << endl;
    stream << "\t\t r" << "\t\t random-access read." << endl;
    stream << "\t\t w" << "\t\t write(random-access write) part of input / output file." << endl;
    stream << "\t\t c" << "\t\t Close input/output file." << endl;
    stream << "\t\t f" << "\t\t Flush output buffer to the actual file." << endl;
    stream << "\t\t v" << "\t\t Verbose Mode ON/OFF." << endl;
    stream << "\t\t h" << "\t\t print this help text." << endl;
    stream << "\t\t q" << "\t\t quit (end the program)." << endl;
    return stream.str();
}

void clearCin()
{
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

int getNumberFromUserInput(string prompt)
{
    int number;
    cout << prompt;
    cin >> number;
    return number;
}

string getStringFromUserInput(string prompt)
{
    string text;
    cout << prompt;
    getline(cin, text);
    return text;
}

char getCharacter(string prompt)
{
    char letter;
    cout << prompt;
    cin >> letter;
    return letter;
}

string getName(string prompt)
{
    string name;
    cout << prompt;
    getline(cin, name);
    cout << name << endl;
    return name;
}






int readFileAtUserInputIndex(ifstream& inFile, char mainBuffer[], int &readIndex, bool MBCI[])
{
    streampos streamReadIndex = getNumberFromUserInput("Enter file offset for random-access read: ");
    
    int length = getNumberFromUserInput("Enter number of bytes to read: ");
    clearCin();
    
 
    
    //fileStream.seekg(streamReadIndex);
    
    char * temporalBuffer = new char [length];
    //fileStream.read (temporalBuffer, length);
    outputCharacterBuffer(temporalBuffer, mainBuffer, length, streamReadIndex);
    
    delete[] temporalBuffer;
    return length;
}


void outputCharacterBuffer(char currentBuffer[], char mainBuffer[], int length, int streamReadIndex)
{
    for (int i = streamReadIndex; i < streamReadIndex + length; i++)
    {
        if ((static_cast<int>(fileBuffer[i]) == 32) or (static_cast<int>(fileBuffer[i]) == 10) or (static_cast<int>(fileBuffer[i]) == 13))
        {
            cout << " " << static_cast<int>(fileBuffer[i]) << " ";
        }
        else
        {
            cout << "'" << fileBuffer[i] << " ";
        }
    }
    cout << endl;
}

void transferTemporaltoMainBuffer(char temporalBuffer[], char mainBuffer[], int length, int readIndex, bool MBCI[])
{
    for (int i = 0; i < length; i++)
    {
        if (MBCI[readIndex + i])
        {
            mainBuffer[readIndex + i] = temporalBuffer[i];
        }
    }
}






int writeFileAtUserInputIndex(char mainBuffer[], string& overwriteUserInput, bool MBCI[])
{
    int writeIndex = getNumberFromUserInput("Enter file offset for random-access write: ");
    clearCin();
    overwriteUserInput = getStringFromUserInput("Enter text to overwrite portion of file: ");
    
    
    //fileStream.seekp(writeIndex);
    //fileStream.write(overwriteUserInput.c_str(),overwriteUserInput.length());
    
    for (int i = 0; i < overwriteUserInput.length(); i++)
    {
        fileBuffer[i + writeIndex] = overwriteUserInput[i];
    }
    
    
    return writeIndex-1;
}

void writeStringtoMainBuffer(char mainBuffer[], int writeIndex, string overwriteUserInput, bool MBCI[])
{
    for (int i = 0; i < overwriteUserInput.length(); i++)
    {
        
        //cout << "'" << mainBuffer[writeIndex + i] << "' is changing to '" << overwriteUserInput[i] << "'" << endl;
       
        mainBuffer[writeIndex + i] = overwriteUserInput[i];
        MBCI[writeIndex + i] = false;
    }
}







void flushOutMainBuffer(ofstream &outFile, bool binaryMode, string &filename, char mainBuffer[])
{
    if (binaryMode)
    {
        cout << "File \"" << filename << "\" has been successfully updated (text mode)" << endl;
        outFile.open(filename, ios::out | ios::binary | ios::app);
    }
    else
    {
        cout << "File \"" << filename << "\" has been successfully updated (binary mode)" << endl;
        outFile.open(filename, ios::out | ios::app);
    }
    
    if (outFile.good())
    {
        for (int X = 0; X < 5000; X++)
           {
               
               if (mainBuffer[X] != NULL)
               {
                   streamoff Y = static_cast<streamoff>(X);
                   outFile.seekp(Y);
                   outFile.put(mainBuffer[X]);
               }
           }
    }
    else
    {
        cout << "FILE FAILED TO OPEN" << endl;
    }
   
    
}



bool openFileInMode(string &filename, ifstream& inFile, bool binaryMode, bool openFile)
{
    cout << "Enter name of input/output file: ";
    getline(cin, filename);
    if (binaryMode)
    {
        inFile.open(filename,ios::binary);
        fileStream.open(filename, ios::binary);
    }
    else
    {
        inFile.open(filename);
        fileStream.open(filename);
    }
    
    if (inFile.fail() or fileStream.fail())
    {
        cout << "ERROR: OPENING FILE, TRY AGAIN" << endl;
    }
    else if (openFile == true)
    {
        cout << "ERROR: File is already opened" << endl;
    }
    else
    {
        
        if (binaryMode)
        {
            cout << "File \"" << filename << "\" successfully opened (binary mode)" << endl;
            
        }
        else
        {
            cout << "File \"" << filename << "\" successfully opened (text mode)" << endl;
            
        }
    }
    return true;
}

bool closeFileFunction(string filename, ifstream& inFile, ofstream& outFile)
{
    inFile.close();
    outFile.close();
    return false;
}


