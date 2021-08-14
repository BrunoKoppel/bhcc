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
public class Point {
  private double x;
  private double y;
  
  Point(){
    setPoint(0,0);
    toString();
  }
  
  Point(double x, double y){
    setPoint(x,y);
    toString();
  }
  
  public void setPoint(double x, double y){
    this.x = x;
    this.y = y;
  }
  
  public double getX(){
    return this.x;
  }
  
  public double getY(){
    return this.y;
  }
  
  public void translate(double dx, double dy){
    setPoint(getX()+dx, getY()+dy);
  }
  
  @Override
  public String toString(){
    return ("\n(" + getX() + "," + getY() + ")");
  }
}
