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
    static ProductionWorker *createNewProductionWorker();
    
    int getShiftNumber() const;
    string getShiftName() const;
    double getPayRate() const;
    void printWorkerData() const;
    void displayInfo(ProductionWorker e);
};
#endif /* ProductionWorker_hpp */
