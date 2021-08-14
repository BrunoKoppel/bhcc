package LoanProgram;

import java.util.Calendar;
import java.util.Date;
    
public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date initialLoanDate;
    private java.util.Date finalLoanDate;

    /**
     * Default constructor
     */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate, number of years,
     * and loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
            double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.initialLoanDate = new Date();
        this.finalLoanDate = new Date();
        
        this.setInitialLoanDate();
        this.setFinalLoanDate();
    }

    /**
     * Return annualInterestRate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Return numberOfYears
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Return loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Set a newloanAmount
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /**
     * Find total payment
     */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /**
     * Set a newLoanDate
     */
    public void setInitialLoanDate(){
        this.initialLoanDate = Calendar.getInstance().getTime();
    }
    
    /**
     * Return loan date
     */
    public java.util.Date getInitialLoanDate() {
        return initialLoanDate;
    }
    
    /**
     * Set a newLoanDate
     */
    public void setFinalLoanDate(){
        this.finalLoanDate.setYear(this.getInitialLoanDate().getYear() + this.numberOfYears);
    }
    
    /**
     * Return loan date
     */
    public java.util.Date getFinalLoanDate() {
        return finalLoanDate;
    }
}
