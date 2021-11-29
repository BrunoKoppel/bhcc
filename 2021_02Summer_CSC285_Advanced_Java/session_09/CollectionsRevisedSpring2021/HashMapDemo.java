

import java.util.*;

class HashMapDemo {
  public static void main(String args[]) {

    // Create a hash map
    HashMap hm = new HashMap();
    
    // Put elements to the map
    hm.put("John Doe", new Double(3434.34));
    hm.put("Tom Smith", new Double(123.22));
    hm.put("Jane Baker", new Double(1378.00));
    hm.put("Tod Hall", new Double(99.22));
    hm.put("Ralph Smith", new Double(-19.08));
 System.out.println(hm);
    // Get a set of the entries
    Set set = hm.entrySet();

    // Get an iterator
    Iterator i = set.iterator();

    // Display elements
    while(i.hasNext()) {
      Map.Entry me = (Map.Entry)i.next();
      System.out.print(me.getKey() + ": ");
      System.out.println(me.getValue());
    }
    System.out.println();

    // Deposit 1000 into John Doe's account
    double balance =  ((Double)hm.get("Jane Baker")).doubleValue();
    hm.put("Jane Baker", new Double(balance + 1000));
    System.out.println("Jane Baker new balance: " +
      hm.get("Jane Baker"));
  }
}








