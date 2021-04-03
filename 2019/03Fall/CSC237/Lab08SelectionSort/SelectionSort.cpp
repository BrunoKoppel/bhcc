#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

void clear_cin()
{
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

string getFileNameFromUser(string prompt)
{
    string name;
    do
    {
        cout << prompt;
        cin >> name;
        if (cin.good())
        {
            break;
        }
        else
        {
            cout << "The input is not a string, try again!" << endl;
            clear_cin();
        }
    } while (true);
    return name;
}

int ReadFile(ifstream& infile, ifstream& inputFile, string fileName, string presidents[])
{
    int i = 0;
    infile.open(fileName);
    if (!infile)
    {
      cout << "File open failure!";
    }
    else
    {
        inputFile.open(fileName);
        while(getline(inputFile, presidents[i]))
        {
            i++;
        }
    }
    return i;
}

void SwapMechanism(int& i, int& j, string presidents[], int numberOfPresidents)
{
    presidents[49] = presidents[i];
    presidents[i] = "";
    presidents[i] = presidents[j];
    presidents[j] = "";
    presidents[j] = presidents[49];
    presidents[49] = "";
    cout << "Swap " << "[" << setw(2) << j << "] " << setw(30) << presidents[j] << " With " << "[" << setw(2) << i << "] " << setw(30) << presidents[i] << endl;
}

void Swap(string presidents[], int numberOfPresidents)
{
    for (int i = 0; i < numberOfPresidents; i++)
    {
        for (int j = i + 1; j < numberOfPresidents; j++)
        {
            //cout << presidents[i] << " vs " << presidents[j] << endl;
            //cout << static_cast<int>(presidents[i][0]) << " vs " << static_cast<int>(presidents[j][0]) << endl << endl;
            int k = 0;
            if (static_cast<int>(presidents[i][k]) > static_cast<int>(presidents[j][k]))
            {
                SwapMechanism(i, j, presidents, numberOfPresidents);
            }
            else if (static_cast<int>(presidents[i][k]) == static_cast<int>(presidents[j][k]))
            {
                k++;
                if (static_cast<int>(presidents[i][k]) > static_cast<int>(presidents[j][k]))
                {
                    SwapMechanism(i, j, presidents, numberOfPresidents);
                }
                else if (static_cast<int>(presidents[i][k]) == static_cast<int>(presidents[j][k]))
                {
                    k++;
                    if (static_cast<int>(presidents[i][k]) > static_cast<int>(presidents[j][k]))
                    {
                        SwapMechanism(i, j, presidents, numberOfPresidents);
                    }
                    else if (static_cast<int>(presidents[i][k]) == static_cast<int>(presidents[j][k]))
                    {
                        k++;
                        if (static_cast<int>(presidents[i][k]) > static_cast<int>(presidents[j][k]))
                        {
                            SwapMechanism(i, j, presidents, numberOfPresidents);
                        }
                    }
                }
            
            }
        }
    }
}

int main()
{
    ifstream infile;
    ofstream outputFile;
    ifstream inputFile;
    string fileName;
    string presidents[50];
    int numberOfPresidents = 0;
    
    fileName = getFileNameFromUser("Enter the name for the file containing the list: ");
    
    numberOfPresidents = ReadFile(infile, inputFile, fileName, presidents);
    
    if (numberOfPresidents > 0)
    {
        cout << numberOfPresidents << "Lines of text from from input file." << endl;
        cout << "Here are the unsorted names:" << endl;
        cout << "---------------------------" << endl;
        for (int i = 0; i < numberOfPresidents; i++)
        {
            cout << "[" << setw(2) << i << "] " ;
            cout << presidents[i] << endl;
        }
        
        cout << endl;
        Swap(presidents, numberOfPresidents);
        
        cout << "\nHere are the names sorted:" << endl;
        cout << "---------------------------" << endl;
        for (int i = 0; i < numberOfPresidents; i++)
        {
            cout << "[" << setw(2) << i << "] " ;
            cout << presidents[i] << endl;
        }
    }
    else
    {
        cout << "THE FILE DID NOT LOAD. RUN YOUR PROGRAM AGAIN." << endl;
    }
}
