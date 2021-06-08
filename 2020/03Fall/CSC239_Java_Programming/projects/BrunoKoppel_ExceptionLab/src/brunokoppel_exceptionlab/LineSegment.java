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
public class LineSegment {
  private Point start;
  private Point end;
  
  public boolean isSame(Point p1, Point p2){
    if (p1.getX() == p2.getX() 
            && p1.getY() == p1.getX()){
      return true;
    } else {
      return false;
    }
  }
  
  LineSegment(Point start, Point end){
    if (start.getX() < end.getX() || start.getX() == end.getX()){
      this.start = start;
      this.end = end;
    } else if(start.getX() > end.getX()) {
      this.start = end;
      this.end = start;
    }
  }
  
  public double distance(){
    return Math.sqrt( Math.pow(end.getY() - start.getY(), 2.0) 
            + Math.pow(end.getX() - start.getX(), 2.0) );
  }
  
  public boolean isEqual(LineSegment line){
    return ((line.getEnd().getX() == this.getEnd().getX()) 
            && (line.getEnd().getX() == this.getEnd().getX()));
  }
  
  public double slope(){
    return ((getEnd().getY() - getStart().getY())/(getEnd().getX() - getStart().getX()));
  }
  
  public double offset(){
    return (getStart().getY() - (this.slope()*getStart().getX()));
  }
  
  public boolean isParallel(LineSegment line){
    return (this.slope() == line.slope());
  }
  
  public boolean isPerpendicular(LineSegment line){
    return (line.slope()*this.slope() == -1);
  }
  
  public Point intersectsAt(LineSegment line){
    double x = ((line.offset() - this.offset())/(this.slope() - line.slope()));
    double y = ((this.slope() * x) + this.offset());
    Point intersection = new Point(x, y);
    
    try {
      if ((x < this.getStart().getX()) || (x > this.getEnd().getX()) || (x < line.getStart().getX()) || (x > line.getEnd().getX())){
        throw new OutOfBoundsException(intersection);
      } 
    } catch (OutOfBoundsException ex){
      System.out.println(ex.getPoint());
    } finally {
      return intersection;
    }
  }
  
  public Point getStart(){
    return start;
  }
  
  public Point getEnd(){
    return end;
  }
}
