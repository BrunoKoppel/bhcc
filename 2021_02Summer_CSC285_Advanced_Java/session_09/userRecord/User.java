//Glen CIT-285 Final Project

import java.text.DecimalFormat;

public class User implements UserInterface{
    
    //create variables
	private int id;
	
	private String name;
	
	private char hourly;
	
	private double wage;
	private double avgHours;
	private double percentRent;
	private double foodBudget;
	private double expenses;

    
    //constructor
    public User(int id, String name, char hourly, double wage, double avgHours, double percentRent, double foodBudget, double expenses){
       
		//"this" is a reference to the object
		this.id = id;
        this.name = name;
        this.hourly = hourly;
        this.wage = wage;
        this.avgHours = avgHours;
        this.percentRent = percentRent;
        this.foodBudget = foodBudget;
        this.expenses = expenses;
		
    }
    
    //interface method implementation
    public double calc_gross_pay(char hourly, double wage, double avgHours){
		
		//catch arguments
        char tempHourly = hourly;
		double tempWage = wage;
		double tempAvgHours = avgHours;
		
		//calculate gross monthly income
		double grossPay;
		
		if (tempHourly == 'y' || tempHourly == 'Y'){
			grossPay = (((tempWage * tempAvgHours) * this.WEEKS) / this.MONTHS);
		} else{
			grossPay = (tempWage / this.MONTHS);
		}
        
		return (grossPay);
        
    }//end calc_gross_pay
    
    //interface method implementation
    public double calc_net_pay(double grossPay){
        
		//catch arguments
        double tempGrossPay = grossPay;
		
		double taxMod = (1.0 - this.TAX_RATE);
        
        return (tempGrossPay * taxMod);
        
        
    }//end calc_net_pay
    
    
    //interface method implementation
    public double calc_budget(double netPay, double percentRent, double foodBudget, double expenses){
		
		//catch arguments
		double tempNetPay = netPay;
		double tempPercentRent = percentRent;
		double tempFoodBudget = foodBudget;
		double tempExpenses = expenses;
		
		//calculate budget
		double budget = tempNetPay; //budget starts with net income
		
		budget = (budget - (budget * (tempPercentRent / 100))); //take rent off the top
		
		budget -= (tempFoodBudget + tempExpenses); //then subtract other expenses
		
        return (budget);
        
    }//end calc_budget
	
	//interface method implementation
    public double calc_rent(double netPay, double percentRent){
		
		//catch arguments
		double tempNetPay = netPay;
		double tempPercentRent = percentRent;
		
		//calculate rent
		double rent = (tempNetPay * (tempPercentRent / 100)); //returns monthly budget for rent
		
        return (rent);
        
    }//end calc_rent
    
    public  String toString()
    {
        DecimalFormat twoDigits = new DecimalFormat( "0.00" );
        DecimalFormat dollars = new DecimalFormat( "$.00" );
        
        return(
			"\n Id: " + Integer.toString(this.id) +
			"\n Name: " + this.name +
			"\n Hourly Worker: " + this.hourly +
			"\n Wage/Salary: " + dollars.format(this.wage) +
			"\n Average Hours Per Week: " + twoDigits.format(this.avgHours) +
			"\n Rent (Percent of Income): " + Double.toString(this.percentRent) + "%" +
			"\n Rent (Monthly Budget): " + dollars.format(calc_rent(calc_net_pay(calc_gross_pay(this.hourly, this.wage, this.avgHours)), this.percentRent)) + 
			"\n Food Budget: " + dollars.format(this.foodBudget) +
			"\n Other Expenses: " + dollars.format(this.expenses) +
			"\n Gross Income: " + dollars.format(calc_gross_pay(this.hourly, this.wage, this.avgHours)) +
			"\n Net Income: " + dollars.format(calc_net_pay(calc_gross_pay(this.hourly, this.wage, this.avgHours))) +
			"\n Budget: " + dollars.format(calc_budget(calc_net_pay(calc_gross_pay(this.hourly, this.wage, this.avgHours)), this.percentRent, this.foodBudget, this.expenses)));
        
        
    }//end toString

}