#include "Mortgage.hpp"
#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>

using namespace std;

void clearCin();
void HelpMenuPrintOut();
int getLoanAmount();
double getAnnualInterestRate();
int getTotalYearsToRepay();
string getName(string prompt);
void printOutSchedulePaymentMenu(Mortgage &mortgage, fstream &outFile, string outputName);

int main()
{
    fstream outFile;
    char command = ' ';
    bool runState = true;
    cout << "Choose a command: (h command for the help meny)" << endl;
    cin >> command;
    while (runState == true)
    {
        clearCin();
        if (command == 'N' or  command =='n')
        {
            cout << "Goodbye my friend!" << endl;
            runState = false;
        }
        else if  (command == 'Y' or  command =='y')
        {
            string outputName = getName("Enter output file name: ");
            Mortgage mortgage(getLoanAmount(), getAnnualInterestRate(), getTotalYearsToRepay());
            printOutSchedulePaymentMenu(mortgage, outFile, outputName);
            cout << "\n\nDo you wish to process another loan? (press h for a list of commands): ";
            cin >> command;
            
        }
        else if (command == 'H' or command == 'h')
        {
            HelpMenuPrintOut();
            cout << "\n\nEnter a command (press h for a list of commands): ";
            cin >> command;
        }
        else
        {
            cout << "\n\nEnter the right command (press h for a list of commands): ";
            cin >> command;
        }
    };
    return 0;
}

string getName(string prompt)
{
    string name;
    cout << prompt;
    getline(cin, name);
    return name;
}

void clearCin()
{
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

void printOutSchedulePaymentMenu(Mortgage &mortgage, fstream &outFile, string outputName)
{
    outFile.open(outputName, ios::out);
    
    cout << mortgage.LoanSummarytoString() << endl;
    outFile << mortgage.LoanSummarytoString() << endl;
    
    cout << setw(5) << "Pmt#" << setw(18) << "Payment Amount"
    << setw(18) << "Interest" << setw(22) << "Contrib to principle"
    << setw(18) << "Remaining balance" << endl;
    outFile << setw(5) << "Pmt#" << setw(18) << "Payment Amount"
    << setw(18) << "Interest" << setw(22) << "Contrib to principle"
    << setw(18) << "Remaining balance" << endl;
    
    for (int i = 1; i <= mortgage.getNumberOfPayments(); i++)
    {
        mortgage.calculatePaymentSchedule();
        cout << setw(5) << i << mortgage.outputPaymentSchedule() << endl;
        outFile << setw(5) << i << mortgage.outputPaymentSchedule() << endl;
    }
    
    outFile.close();
}

void HelpMenuPrintOut()
{
    cout << "\n\nHelp Menu Print Out:" << endl;
    cout << "Y/y = process another loan" << endl;
    cout << "N/n = Stop processing loans" << endl;
    cout << "H/h = Help Menu Program" << endl;
}

int getLoanAmount()
{
    int a;
    cout << "Enter the amount of the Loan: ";
    cin >> a;
    return a;
}

double getAnnualInterestRate()
{
    double b;
    cout << "Enter the annual interest rate in decimal form (example 0.075): ";
    cin >> b;
    return b;
}

int getTotalYearsToRepay()
{
    int c;
    cout << "Enter the length of the loan in years: ";
    cin >> c;
    return c;
}
