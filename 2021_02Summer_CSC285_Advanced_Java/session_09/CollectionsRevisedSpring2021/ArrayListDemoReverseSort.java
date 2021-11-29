// Demonstrate ArrayList.

import java.util.*;
// A reverse comparator for strings.

class MyComp implements Comparator {
  public int compare(Object a, Object b) {
    String aStr, bStr;

    aStr = (String) a;
    bStr = (String) b;

    // reverse the comparison
    return bStr.compareTo(aStr); //Descending order
  }

  // no need to override equals
}
class ArrayListDemoReverseSort {
  public static void main(String args[])
 
  {
    
    ArrayList al = new ArrayList();
   
    al.add("C");
    al.add("A");
    al.add("E");
    al.add("B");
    al.add("D");
    al.add("F");
    al.add(1, "A2");
	
	System.out.println("Contents of al: " + al);
   
   Collections.sort(al,new MyComp()); //Sort Descending order
                

    // display the array list
    System.out.println("Contents of al: " + al);

   }
}








