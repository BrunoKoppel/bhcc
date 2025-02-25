// Specification file for the GradedActivity class
#ifndef GRADEDACTIVITY_H
#define GRADEDACTIVITY_H
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

// GradedActivity class declaration

class GradedActivity
{
protected:
   char letter;            // To hold the letter grade
   double score;           // To hold the numeric score
   void determineGrade();  // Determines the letter grade
public:
   // Default constructor
   GradedActivity()
      { letter = ' '; score = 0.0; }

   // Mutator function
   void setScore(double s) 
      { 
	   cout << "              GradedAcivity::setScore: s=" << s << endl;
	   score = s;
        determineGrade();}
   
   // Accessor functions
   double getScore() const
      { return score; }
   
   char getLetterGrade() const
      { return letter; }
};

#endif