//
//  ProductionWorker.hpp
//  Lab15.1
//
//  Created by Bruno Koppel on 11/17/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#ifndef PRODUCTIONWORKER_hpp
#define PRODUCTIONWORKER_hpp

#include <stdio.h>
#include <iostream>
#include <iomanip>
#include <string>
#include "Employee.h"

using namespace std;

class ProductionWorker : public Employee
{
private:
    int shift;
    double payRate;
    
public:
    ProductionWorker() : Employee()
    {
        shift = 0; payRate = 0.0;
    }
    
    ProductionWorker(string aName, string aDate, int aShift, double aPayRate) : Employee(aName, aDate)
    {
        shift = aShift; payRate = aPayRate;
    }
    
    void setShift(int s);
    void setPayRate(double r);
    
    
    int getShiftNumber() const;
    string getShiftName() const;
    double getPayRate() const;
    void printWorkerData() const;
    void displayInfo(ProductionWorker e);
    void invalidShift();
    void invalidPayRate();
    void testShift(int shift);
    void testPayRate(double rate);
    static string getStringFromUserInput(string prompt);
    static int getIntegerFromUserInput(string prompt);
    static double getDoubleFromUserInput(string prompt);
    
    static ProductionWorker *createNewProductionWorker()
    {
        string name = getStringFromUserInput("Enter name of new employee: ");
        string date = getStringFromUserInput("Enter hire date of new employee (MM/DD/YYYY format): ");
        int shift = getIntegerFromUserInput("Enter shift for new employee (1=day, 2=night): ");
        double payRate = getDoubleFromUserInput("Enter hourly pay rate for new employee: ");
        
        ProductionWorker *person;
        
        person = new ProductionWorker(name, date, shift, payRate);
        
        person->checkDate(date);
        person->testShift(shift);
        person->testPayRate(payRate);
        
        return person;
    }
    
};
#endif /* ProductionWorker_hpp */
