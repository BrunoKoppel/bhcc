#ifndef GRADEDACTIVITY_H
#define GRADEDACTIVITY_H
#include <iostream>
#include <iomanip>
using namespace std;

// GradedActivity class declaration

class GradedActivity
{
private:
	double score;   // To hold the numeric score
public:
	// Default constructor
	GradedActivity()
	{
		score = 0.0;
		cout << "GradedActivity: default constructor" << endl;
	}

	// Constructor
	GradedActivity(double s)
	{
		score = s;
		cout << "GradedActivity constructor: score=" << score << endl;
	}

	// Destructor
	~GradedActivity() {
		cout << "GradedActivity destructor" << endl;
	}

	// Mutator function
	void setScore(double s)
	{
		score = s;
	}

	// Accessor functions
	double getScore() const
	{
		return score;
	}

	char getLetterGrade() const;
};
#endif 