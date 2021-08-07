
import java.rmi.*;
import java.text.*;

public class AddClient {
  public static void main(String args[]) {
    try {
      String addServerURL = "rmi://" + args[0] + "/AddServer";
      AddServerIntf addServerIntf = (AddServerIntf)Naming.lookup(addServerURL);
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
	  
	    System.out.println("The first number is: " + args[1]);
      double d1 = Double.valueOf(args[1]).doubleValue();

      System.out.println("The second number is: " + args[2]);
      double d2 = Double.valueOf(args[2]).doubleValue();

      System.out.println("The third number is: " + args[3]);
      int d3 = Integer.parseInt(args[3]);      
	    
      System.out.println("The sum is: " + addServerIntf.add(d1, d2));

      System.out.println("The difference is: " + addServerIntf.subtract(d1, d2));
	    
      System.out.println("The product is: " + addServerIntf.multiply(d1, d2));
	 
	    System.out.println("The division is: " + addServerIntf.divide(d1, d2));
	   
	    System.out.println("The modulus is: " + addServerIntf.mod(d1, d2));

      System.out.println("Your monthly mortgage payment is " + fmt.format(addServerIntf.mortgage(d1, d2, d3)));

      System.out.println("Your Future Value is " + fmt.format(addServerIntf.futureValue(d1, d2, d3)));
    }
    catch(Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}