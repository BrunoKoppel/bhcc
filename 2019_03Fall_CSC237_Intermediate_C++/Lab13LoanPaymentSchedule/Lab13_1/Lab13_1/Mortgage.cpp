//
//  Mortgage.cpp
//  Lab13_1
//
//  Created by Bruno Koppel on 11/2/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#include "Mortgage.hpp"

#include <math.h>
#include <iostream>
#include <iomanip>
#include <sstream>

using namespace std;

Mortgage::Mortgage(int a, double b, int c)
{
    loanAmount = a;
    annualInterestRate = b;
    totalYearsToRepay = c;
    currentBalance = a;
}

Mortgage::~Mortgage()
{
    cout << "Object has been deleted." << endl;
}

double Mortgage::TDC(double a)
{
    int b = a * 100;
    double c = b / 100.00;
    return c;
}

void Mortgage::calculatePaymentSchedule()
{
    interest = getMonthlyInterestRate() * currentBalance;
    //interest = TDC(interest);
    contrib_to_principle = getMonthlyPayment() - interest;
    //contrib_to_principle = TDC(contrib_to_principle);
    currentBalance = currentBalance - contrib_to_principle;
    //currentBalance = TDC(currentBalance);
}

string Mortgage::outputPaymentSchedule()
{
    stringstream stream2;
    stream2 << setw(18) << setprecision(2) << fixed << getMonthlyPayment();
    stream2 << setw(18) << setprecision(2) << fixed << interest;
    stream2 << setw(22) << setprecision(2) << fixed << contrib_to_principle;
    stream2 << setw(18) << setprecision(2) << fixed << currentBalance;
    return stream2.str();
}

string Mortgage::LoanSummarytoString()
{
    stringstream stream1;
    stream1 << "\n\nLoan Amount: $" << setprecision(2) << fixed << loanAmount << endl;
    stream1 << "Annual Interest Rate: " << setprecision(5) << fixed << annualInterestRate << endl;
    stream1 << "Years to repay: " << setprecision(2) << fixed << totalYearsToRepay << endl;
    stream1 << "Monthly Payment: $" << setprecision(2) << fixed << getMonthlyPayment() << endl;
    stream1 << "Total Pay Back: $" << setprecision(2) << fixed << computeTotalPayBack() << endl;
    return stream1.str();
}

double Mortgage::computeTotalPayBack()
{
    return getMonthlyPayment() * getNumberOfPayments();
}

int Mortgage::getNumberOfPayments()
{
    return totalYearsToRepay * 12;
}

double Mortgage::getMonthlyInterestRate()
{
    return annualInterestRate / 12;
}

double Mortgage::getTerm()
{
    return pow((1 + getMonthlyInterestRate()),getNumberOfPayments());
}

double Mortgage::getMonthlyPayment()
{
    return (loanAmount * getMonthlyInterestRate() * getTerm()) / (getTerm() - 1);
}

double Mortgage::getInterest()
{
    return getMonthlyInterestRate() * currentBalance;
}

