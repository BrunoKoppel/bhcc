/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_exceptionlab;

/**
 *
 * @author brunokoppel
 */
public class OutOfBoundsException extends Exception {
  private Point intersectionPoint;
  
  OutOfBoundsException(Point intersectionPoint){
    System.out.print("\nOut of Bounds Exception! Intersection point is outside of the line segment bounds");
  }
  
  public Point getPoint(){
    return this.intersectionPoint;
  }
}
