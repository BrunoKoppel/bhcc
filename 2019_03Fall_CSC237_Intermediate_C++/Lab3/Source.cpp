// CIT237 Introductory Lab Exercise:
//
// This progam simulates the basic function of a bank account.
// (It is a variation of an example presented in the book 
//		"C++ Pocket Reference" by Kyle Loudon, copyright 2003, 
//      published by O'Reilly Media, Inc.)

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main()
{
	double balance = 0;	// Account balance.
	double amount;		// Amount to be deposited or withdrawn.
	string command;     // command from user


	//    Variables and a CONSTANT needed for the 'r' and 'i' commands:
	double annualInterestRate = 0;          // Annual interest rate (a percentage)
	double monthlyInterestRate = 0;         // Monthly interest rate (a percentage)
	double monthlyInterestCoefficient = 0;  // equals monthly interest rate / 100
	double interestThisMonth = 0;
	const int MONTHS_PER_YEAR = 12;


	while (true)
	{
		// Output the account balance
		cout << "Account Balance is $"
			<< setprecision(2) << fixed << balance
			<< endl;

		// Prompt for command input.
		cout << "Enter single-letter command (or 'h' for help): ";
		getline(cin, command);

		if (command == "d") {
			// Deposit command.
			cout << "Enter deposit amount: ";
			cin >> amount;
			cin.ignore(20, '\n');
			balance = balance + amount;
		}
		else if (command == "h") {
			// Help text.
			cout << "Supported commands: \n"
				<< "     d    Deposit.\n"
				<< "     h    print this help text.\n"
				<< "     i    calculate, add interest for one month.\n"
				<< "     q    quit (end the program).\n"
				<< "     r    set annual, monthly interest rates.\n"
				<< "     w    Withdraw.\n"
				<< endl;
		}
		else if (command == "i") {

			// Calculate interest for one month, add to balance.

			interestThisMonth = balance * monthlyInterestCoefficient;
			balance += interestThisMonth;

		}
		else if (command == "q") {

			// Quit.
			cout << "Exit." << endl;
			system("pause");
			return 0;
		}
		else if (command == "r") {

			// Enter annual interest percentage.  Calculate MONTHLY equivalent, as a coefficient.

			cout << "What's the Annual Interest Percentage going to be for the account?: " << endl;
			cin >> annualInterestRate;
			monthlyInterestRate = annualInterestRate / MONTHS_PER_YEAR;
			monthlyInterestCoefficient = monthlyInterestRate / 100;

		}
		else if (command == "w") {

			// Withdraw command.
			cout << "Enter withdrawal amount: ";
			cin >> amount;
			cin.ignore(20, '\n');
			if (amount >= balance)
			{
					cout << "You cannot withdraw more than $" << balance << ", you have been redirected to the main menu"  << endl;
			}
			else
			{
				balance -= amount;
			}
		}
		else {
			cout << "Invalid command.\n";
		}
	}  // (end 'while')

	system("pause");
	return 0;
}  // (end function 'main')
