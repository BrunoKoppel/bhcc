

// Demonstrate Arrays
import java.util.*;

class ArraysDemo {
  public static void main(String args[]) {

    // allocate and initialize array
    int array[] = new int[20];
    for(int i = 0; i < 20; i++)
      array[i] = -3 * i;

    // display, sort, display
    System.out.print("Original contents: ");
    display(array);
	
    Arrays.sort(array);
	
    System.out.print("Sorted: ");
    display(array);


    // fill and display
    Arrays.fill(array, 2, 6, -1); // Go to position to put -1 in position 2,3,4,5
    System.out.print("After fill(): ");
    display(array);

    // sort and display
    Arrays.sort(array);
    System.out.print("After sorting again: ");
    display(array);

    // binary search for 36
	//REMEMBER THE ARRAY MUST BE SORTED IN ASCENDING ORDER BEFORE
	// BINARY SEARCHING!!!!!
    System.out.print("The value -36 is at location ");
    int index = 
      Arrays.binarySearch(array, -36);
    System.out.println(index);
  }

//HERE IS THE DISPLAY METHOD!!!! 
 static void display(int array[]) {
    for(int i = 0; i < array.length; i++)
      System.out.print(array[i] + " ");
    
	System.out.println("");
  }
}













