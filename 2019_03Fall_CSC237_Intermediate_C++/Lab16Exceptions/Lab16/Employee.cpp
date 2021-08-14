// Implementation file for the Employee class

#include "Employee.h"
#include <string>
using namespace std;

int Employee::lastEmployeeNumberIssued=0;   // Sequential employee number

	// Default constructor
	Employee::Employee()
	{
		lastEmployeeNumberIssued++;
		employeeNumber = lastEmployeeNumberIssued;
		employeeName = "";
		hireDate = "";
	}


	// Constructor
	Employee::Employee(string aName, string aDate)
	{
		lastEmployeeNumberIssued++;
		employeeNumber = lastEmployeeNumberIssued;
		employeeName = aName;
		hireDate = aDate;
	}

	// Mutators
	void Employee::setEmployeeName(string n)
	{
		employeeName = n;
	}


	void Employee::setHireDate(string date)
	{
		hireDate = date;
	}

	// Accessors
	string Employee::getEmployeeName() const
	{
		return employeeName;
	}

	int Employee::getEmployeeNumber() const
	{
		return employeeNumber;
	}

	string Employee::getHireDate() const
	{
		return hireDate;
	}

	int Employee::getLastEmployeeNumberIssued()
	{
		return lastEmployeeNumberIssued;
	}

    void Employee::checkDate(string date)
    {
        for (int i = 0; i < 10; i++)
        {
            if ((i == 2) or (i == 5))
                {
                    if ((date[i] != '/'))
                    {
                        throw string("Error: Invalid date format. try [MM/DD/YYYY]");
                    }
                }
            else
            {
                if (!isdigit(date[i]))
                {
                    throw string("Error: Invalid date format. try [MM/DD/YYYY]");
                }
            }
        }
    }
	
