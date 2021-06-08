//
//  Mortgage.hpp
//  Lab13_1
//
//  Created by Bruno Koppel on 11/2/19.
//  Copyright © 2019 Bruno Koppel. All rights reserved.
//

#ifndef Mortgage_hpp
#define Mortgage_hpp

#include <stdio.h>
#include <string>

using namespace std;

class Mortgage
{
    private:
        double loanAmount;
        double annualInterestRate;
        double monthlyInterestRate;
        int totalYearsToRepay;
        int numberOfPayments;
        double currentBalance;
        double interest;
        double contrib_to_principle;
    public:
        Mortgage();
        Mortgage(int, double, int);
        ~Mortgage();
        string outputPaymentSchedule();
        string LoanSummarytoString();
        void GeneralInformation() const;
        int getNumberOfPayments();
        double getMonthlyInterestRate();
        double getTerm();
        double getMonthlyPayment();
        int getLoanAmount();
        double getAnnualInterestRate();
        int getTotalYearsToRepay();
        double computeTotalPayBack();
        double getInterest();
        void calculatePaymentSchedule();
        double TDC(double a);
};

#endif /* Mortgage_hpp */
