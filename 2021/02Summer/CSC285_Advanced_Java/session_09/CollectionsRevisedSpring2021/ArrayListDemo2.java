// Demonstrate ArrayList.


import java.io.*;
import java.util.*;
import java.io.*;


 class Emprec {
 String name;
 String address;  
 double hours;
 double rate;
 char sex;
 int age;
 boolean active;  


Emprec (String name,String address,String hours,String rate,String sex,String age,String active)
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



  double calc_fed_tax(double hours,double rate)
{

  double yearly_income;

  yearly_income = hours * rate * 52;

   if (yearly_income < 30000.00) return (hours * rate *.28);

   else if ( yearly_income < 50000.00 ) return (hours * rate* .32);

   else return (hours * rate * .38);


}// calc_fed_tax


  double calc_gross_pay()
{

   return (hours * rate);

}// calc_gross_pay


  double calc_state_tax(double hours, double rate)
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




 class MyComp2 implements Comparator {
  public int compare(Object a, Object b) {
    Emprec aStr, bStr;

    aStr = (Emprec) a;
    bStr = (Emprec) b;

    
	
	return aStr.name.compareTo(bStr.name); // This is ascending order!!!!
  }

}
// A reverse comparator for strings.
 class MyComp implements Comparator {
  public int compare(Object a, Object b) {
    Emprec aStr, bStr;

    aStr = (Emprec) a;
    bStr = (Emprec) b;

	 return bStr.name.compareTo(aStr.name); // This is descending order!!!!
  }

  // no need to override equals
}

class ArrayListDemo2 {
  public static void main(String args[])
  throws IOException
  {
    // create an array list
    ArrayList <String> al = new ArrayList <String>();
    
    System.out.println("Initial size of al: " +
                       al.size());

    // add elements to the array list
    al.add("C");
    al.add("A");
    al.add("E");
    al.add("B");
    al.add("D");
    al.add("F");
    al.add(1, "A2");
	
     Collections.sort(al);
    
	System.out.println("Size of al after additions: " +
                       al.size());

    // display the array list
    System.out.println("Contents of al: " + al);

    // Remove elements from the array list al.remove("F");
    al.remove(2);

    System.out.println("Size of al after deletions: " +
                       al.size());
    System.out.println("Contents of al: " + al);
 
 // AND NOW FOR AN ARRAYLIST OF Emprec !!!!
 
 BufferedReader inData = new BufferedReader(new FileReader("data.txt"));
 
	String str_name;
    String str_address;    
    String str_hours;
    String str_rate;
    String str_sex;
    String str_age;
    String str_active;
 
 
 TreeSet <Emprec> al2 = new TreeSet <Emprec>(new MyComp());
 ArrayList <Emprec> al3 = new ArrayList <Emprec>();
	for(int i = 0;i<5;++i){  

 str_name     =  inData.readLine();


if(str_name.equalsIgnoreCase("exit")) break;

 str_address  =  inData.readLine();
 str_hours    =  inData.readLine();
 str_rate     =  inData.readLine();
 str_sex      =  inData.readLine();
 str_age      =  inData.readLine();  
 str_active   =  inData.readLine();
 
Emprec employee=new Emprec(str_name,str_address,str_hours,str_rate,str_sex,str_age,str_active);
 
  //System.out.println("Contents of the Emprec TreeSet al2 in descending order by name: " + al2);
 al2.add(employee); // TreeSet in descending order
 
  
  
//System.out.println("Contents of the Emprec TArrayList al3 in ascending order by name: " + al2);
  
 //Collections.sort(al3,new MyComp2());
 al3.add(employee); //ArrayList in ascending order!!!
 
  
}//for

System.out.println("Contents of the Emprec TreeSet al2: " + al2);
   
   Collections.sort(al3,new MyComp2());
   System.out.println("\n\n\t\tContents of the Emprec ArrayList al3: in ascending order now " + al3);
   
   Collections.sort(al3,new MyComp());
   System.out.println("\n\n\t\tContents of the Emprec ArrayList al3: in descending order now " + al3);
   
  
  //This was done in the constructor see abpve !!!!!!! line 184
  //  Line 184   TreeSet <Emprec> al2 = new TreeSet <Emprec>(new MyComp());
  System.out.println("\n\n\t\tContents of the Emprec TreeSet al2 in descending order by name : " + al2);  
   
  }
}








