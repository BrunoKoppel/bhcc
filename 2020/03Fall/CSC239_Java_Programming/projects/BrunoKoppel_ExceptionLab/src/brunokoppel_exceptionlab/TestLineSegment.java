/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_exceptionlab;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author brunokoppel
 */
public class TestLineSegment {
  public static File outputFileForLineSegmentsInfo = new File("BrunolineSegments.txt"); 
  
  public static void main(String [] args){
    Point origin = new Point(0,0);
    Point fiveY = new Point(0,5);
    Point fiveX = new Point(5,0);
    Point endXY = new Point(5,5);

    LineSegment lineOne = new LineSegment(origin, endXY);
    LineSegment lineTwo = new LineSegment(fiveY, fiveX);
    
    String buffer = calculateBufferOutput(lineOne, lineTwo);
    
    fiveY.translate(2, 0);
    endXY.translate(2, 0);
       
    LineSegment lineThree = new LineSegment(origin, fiveY);
    LineSegment lineFour = new LineSegment(fiveX, endXY);
    
    buffer += calculateBufferOutput(lineThree, lineFour);
    
    fiveX.translate(0, 3);
    endXY.translate(0, 1);
    
    LineSegment lineFive = new LineSegment(origin, fiveX);    
    LineSegment lineSix = new LineSegment(fiveY, endXY);
    
    buffer += calculateBufferOutput(lineFive, lineSix);
        
    try {
      writeDataToFile(buffer);
      readDataFromFile();
    } catch (Exception ex){
      System.out.print(ex);
    }
  }
  
  public static void writeDataToFile(String buffer) throws java.io.IOException{
    PrintWriter outputFile = new PrintWriter(outputFileForLineSegmentsInfo);
    if (outputFileForLineSegmentsInfo.exists()){
      System.out.println("File Already Exists, Overwriting content...");
    }
    
    //      System.out.print(buffer);
    
    outputFile.print(buffer);
    outputFile.close();
    

  }
  
  public static void readDataFromFile(){
    try (Scanner inputFile = new Scanner(outputFileForLineSegmentsInfo)){
      while (inputFile.hasNextLine()){
        System.out.println(inputFile.nextLine());
      }
    } catch (Exception ex){
      System.out.print(ex);
    }
  }
  
  public static String calculateBufferOutput(LineSegment one, LineSegment two){
    return ("\n\nDistance of first line segment: " + one.distance() + "\n" +
      "Distance of second line segment: " + two.distance() + "\n" +
      "Slope of first line segment: " + one.slope() + "\n" +
      "Slope of second line segment: " + two.slope() + "\n" +
      "Intersection of the first line and second line segments: " + one.intersectsAt(two).toString() + "\n" +
      "Are the first and second line segments perpendicular? " + one.isPerpendicular(two) + "\n");
  }
}
