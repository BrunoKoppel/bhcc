//Glen CIT-285 Final Project

public interface UserInterface{
    
    //Constants (tax, week and month intervals)
    public double TAX_RATE = 0.1925;
	
    public int WEEKS = 52;
	public int MONTHS = 12;
    
	//methods to be implemented by User object
    public double calc_gross_pay(char hourly, double avgHours, double wage);
    
    public double calc_net_pay(double grossPay);
    
    public double calc_budget(double netPay, double percentRent, double foodBudget, double expenses);
	
	public double calc_rent(double netPay, double percentRent);
}
