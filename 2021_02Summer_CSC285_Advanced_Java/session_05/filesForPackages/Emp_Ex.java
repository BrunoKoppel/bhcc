//import com.jhaley.pk1.*;
import com.jhaley.pk1.Emprec;
//this class declares and object of type Emprec
class Emp_Ex {
	public static void main(String args[]) {
		Emprec employee = new Emprec();
		double employee_gross_pay;
	
	// lets assign values to the employees instance variables
		employee.name = "Mary Smith";
		employee.hours = 40;
		employee.rate = 15.25;
	
	//lets compute the gross salary for this employee
		employee_gross_pay = (employee.hours * employee.rate);
	
	//now lets print the output for this employee
		System.out.print(" The gross salary for " + employee.name);
		System.out.printf(" is %.2f \n",employee_gross_pay);
		System.out.printf("   Calling the method the answer is %.2f \n", employee.calc_gross_pay());
	
	}//main
}//Emp_Ex