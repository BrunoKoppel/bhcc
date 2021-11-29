
import java.io.*;


public class Emprec {
  public String name;
  public String address;  
 public  double hours;
 public  double rate;
 public  char sex;
 public  int age;
 public  boolean active;  





public Emprec (String name,String address,String hours,String rate,String sex,String age,String active)
{

try{
this.name=name;
this.address=address;
this.hours=Double.valueOf(hours).doubleValue();
this.rate=Double.valueOf(rate).doubleValue();
this.sex=sex.charAt(0);
this.age=Integer.parseInt(age);
this.active=Boolean.valueOf(active).booleanValue();
} 
catch(NumberFormatException errmsg)
{
  System.out.println("Invalid format"+ errmsg);
     
     this.name  = "";  
     this.hours = 0.0;
     this.rate  = 0.0;

}//catch

}//Emprec constructor !!!!



public  double calc_fed_tax(double hours,double rate)
{

  double yearly_income;

  yearly_income = hours * rate *52;

   if (yearly_income < 30000.00) return (hours * rate *.28);

   else if ( yearly_income < 50000.00 ) return (hours * rate* .32);

   else return (hours * rate * .38);


}// calc_fed_tax


public  double calc_gross_pay()
{

   return (hours * rate);

}// calc_gross_pay


public  double calc_state_tax(double hours, double rate)
{

  double state_tax;

  state_tax = hours * rate * .0561;

  return (state_tax);

}// calc_state_tax


public String toString() {
     
	  return("\n\n\n\nyour name is " + this.name +
               "\nyour address is " + this.address +
	      
               "\nyour hours are " + hours +
               "\nyour rate is " + rate +
               "\nyour sex is " + sex +
               "\nyour age is " + age +
	        
               "\nyour status is " + active +
               "\nyour gross pay is " + calc_gross_pay() +
               "\nyour state tax is " +
this.calc_state_tax(this.hours,this.rate));
   }// toString()



// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec

