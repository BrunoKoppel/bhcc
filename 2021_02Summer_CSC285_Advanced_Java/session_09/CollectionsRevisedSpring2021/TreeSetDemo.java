
// Demonstrate TreeSet.
import java.util.*;

// Compare last whole words in two strings.
class TComp implements Comparator {
  public int compare(Object a, Object b) {
    
    String aStr, bStr;

    aStr = (String) a;
    bStr = (String) b;

      return bStr.compareTo(aStr); //Descending order!!!
   
  }

  // no need to override equals
}
class TreeSetDemo {
  public static void main(String args[]) {
    // Create a tree set
    TreeSet ts = new TreeSet(new TComp());
    
    // Add elements to the tree set
    ts.add("C");
    ts.add("A");
    ts.add("B");
    ts.add("E");
    ts.add("F");
    ts.add("D");
	//ts.remove("D");

    System.out.println(ts);
  }
}













