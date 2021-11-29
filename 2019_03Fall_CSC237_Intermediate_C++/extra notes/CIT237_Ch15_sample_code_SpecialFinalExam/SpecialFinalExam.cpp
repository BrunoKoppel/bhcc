// This program demonstrates a base class and a derived class.
#include <iostream>
#include <iomanip>
#include "FinalExam.h"
using namespace std;

int main()
{
	int questions; // Number of questions on the exam
	int missed;    // Number of questions missed by the student

	while (true) {


		// Get the number of questions on the final exam.
		cout << "Enter number of questions (or -1 to exit): ";
		cin >> questions;
		if (questions < 0) {
			break;
		}
		// Get the number of questions the student missed.
		cout << "How many questions did the student miss? ";
		cin >> missed;

		// Define a FinalExam object and initialize it with
		// the values entered.
		FinalExam test(questions, missed);

		// Display the test results.
		cout << setprecision(2);
		cout << "\nEach question counts " << test.getPointsEach()
			<< " points.\n";
		cout << "The exam score is " << test.getScore() << endl;
		cout << "The exam grade is " << test.getLetterGrade() << endl;
	}
	system("pause");
	return 0;
}