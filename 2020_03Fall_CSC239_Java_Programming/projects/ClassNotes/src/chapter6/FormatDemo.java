package chapter6;
/**
 * Format the output
 * @param a some number
 * @param b another number
 * @author brunokoppel
 * 
 * In C++ we would create functions outside of main so they "sort of" didn't have a class they belonged to. In java, everything is within a class so it makes sense what Prof. Miller says when they are called methods instead of functions, because everything belongs to a class.
 */

public class FormatDemo { 
  public static void main(String[] args) { 
    // Display the header of the table 
    System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "Degrees", 
      "Radians", "Sine", "Cosine", "Tangent");

    // Display values for 30 degrees
    int degrees = 30;
    double radians = Math.toRadians(degrees);
    System.out.printf("%-10d%-10.4f%-10.4f%-10.4f%-10.4f\n", degrees, 
      radians, Math.sin(radians), Math.cos(radians),
      Math.tan(radians));

    // Display values for 60 degrees
    degrees = 60;
    radians = Math.toRadians(degrees);
    System.out.printf("%-10d%-10.4f%-10.4f%-10.4f%-10.4f\n", degrees, 
      radians, Math.sin(radians), Math.cos(radians), 
      Math.tan(radians));
    
    int a = 5;
    int b = 10;
    int c = a * b;
    System.out.printf("The result of %d * %d is %d\n", a, b, c);
  }
}

