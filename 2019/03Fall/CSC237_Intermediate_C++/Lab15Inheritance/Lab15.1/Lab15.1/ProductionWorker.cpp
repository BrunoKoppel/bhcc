//
//  ProductionWorker.cpp
//  Lab15.1
//
//  Created by Bruno Koppel on 11/17/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include "ProductionWorker.hpp"
#include <iostream>
#include <string>

using namespace std;

void ProductionWorker::setShift(int s)
{
    shift = s;
}

void ProductionWorker::setPayRate(double r)
{
    payRate = r;
}

int ProductionWorker::getShiftNumber() const
{
    return shift;
}

string ProductionWorker::getShiftName() const
{
    if (shift == 1)
    {
        return "Day";
    }
    else if (shift == 2)
    {
        return "Night";
    }
    else
    {
        return "ERROR: Shift not defined";
    }
}

double ProductionWorker::getPayRate() const
{
    return payRate;
}

void ProductionWorker::printWorkerData() const
{
    cout << "Name: " << getEmployeeName() << endl;
    cout << "Employee number: " << getEmployeeNumber() << endl;
    cout << "Hire date: " << getHireDate() << endl;
    cout << "Shift: " << getShiftName() << endl;
    cout << "Shift Number: " << getShiftNumber() << endl;
    cout << "Pay rate: " << getPayRate() << endl;
}

void ProductionWorker::displayInfo(ProductionWorker e)
{
    
}
