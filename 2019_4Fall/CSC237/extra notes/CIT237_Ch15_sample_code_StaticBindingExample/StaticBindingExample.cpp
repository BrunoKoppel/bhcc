// This program demonstrates a class that redefines
// a base class function.
// (Adapted from sample program 15-7 in the textbook.)
#include <iostream>
#include <iomanip>
#include <string>
#include "CurvedActivity.h"
using namespace std;

// Function prototype
bool confirmYN(string promptText);
void processGrade(int, GradedActivity* , double );

int main() {
	double numericScore;  // To hold the numeric score
	double percentage;    // To hold curve percentage
	cout << fixed << setprecision(2);
	// Define a CurvedActivity object.
	CurvedActivity curvedExam;
	CurvedActivity directlyProcessed;
	GradedActivity gradedActivityExam;
	do {
		// Get the unadjusted score.
		cout << "Enter the student's raw numeric score: ";
		cin >> numericScore;
		cin.ignore(10, '\n');
		// Get the curve percentage.
		cout << "Enter the adjustment factor for this student (as a fraction): ";
		cin >> percentage;
		cin.ignore(10, '\n');
		// Send the values to the curvedExam object.
		curvedExam.setPercentage(percentage);
		processGrade(__LINE__,&curvedExam, numericScore);
		cout << "curvedExam: raw score= " << curvedExam.getRawScore();
		cout << " score= " << curvedExam.getScore();
		cout << " letter grade= " << curvedExam.getLetterGrade() << endl << endl;
				
		// Send the values to the gradedActivity object.
		processGrade(__LINE__,&gradedActivityExam, numericScore);
		cout << "gradedActivityExam:         ";
		cout << " score= " << gradedActivityExam.getScore();
		cout << " letter grade= " << gradedActivityExam.getLetterGrade() << endl << endl;

		
		
		directlyProcessed.setPercentage(percentage);
		directlyProcessed.setScore(numericScore);
		cout << "directlyProcessed: raw score= " << directlyProcessed.getRawScore();
		cout << " score= " << directlyProcessed.getScore();
		cout << " letter grade= " << directlyProcessed.getLetterGrade() << endl << endl;

		



	} while (confirmYN(" Run again? "));

	system("pause");
	return 0;
} // end main

/* Function: processGrade
*/
void processGrade(int callerLinenumber, GradedActivity* activityPtr, double numericScore){
	cout << "processGrade(" << callerLinenumber << "): numericScore = " << numericScore << endl;
	activityPtr->setScore(numericScore);
	cout << "processGrade("<<callerLinenumber<<"):  letter grade = " << activityPtr->getLetterGrade()<<endl<<endl;
}
/*=============================================================================
*	Function:	confirmYN  -	Ask user to confirm
*
*  Inputs:   prompt string for user
*
*  Outputs:
*      returns true or false.
*
*  Desciption:
*      Ask the user to confirm their intention.
*      Check response for yes or no.
*
*---------------------------------------------------------------------------*/
bool confirmYN(string promptText)
{
	string inputString;
	bool confirmationValue = false;
	bool inputIsOK = false;

	do
	{
		// input from user 
		cout << promptText;
		getline(cin, inputString);

		if (inputString == "y" || inputString == "Y")
		{
			confirmationValue = true;
			inputIsOK = true;
		}
		else if (inputString == "n" || inputString == "N")
		{
			confirmationValue = false;
			inputIsOK = true;
		}
		else
		{
			cout << "Invalid input:  " << inputString << ".  Please input y or n." << endl;
		}
	} while (inputIsOK == false);
	return confirmationValue;

} // (end function 'confirmYN')
