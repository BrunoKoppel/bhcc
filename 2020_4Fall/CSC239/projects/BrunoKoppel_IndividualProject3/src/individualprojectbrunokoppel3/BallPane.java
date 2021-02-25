package individualprojectbrunokoppel3;

import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
  /**
   * Variable imported from the main file, representing the height of the scene.
   */
  static public int sceneHeight = IndividualProjectBrunoKoppel3.sceneHeight;
  
  /**
   * Variable imported from the main file, representing the width of the scene.
   */
  static public int sceneWidth = IndividualProjectBrunoKoppel3.sceneWidth;
  
  /**
   * Default radius value for the circle.
   */
  private double radius = 20;
  
  /**
   * Default length of x and y with the radius of the circle.
   */
  private double x = radius, y = radius;
  
  /**
   * Ball object used for the game, initiated with the default values of x, y, and radius.
   */
  private Circle circle = new Circle(x, y, radius);
  
  /**
   * Velocities in the units of pixels in one frame of animation, for x and y directions.
   */
  private double vx = 0.5, vy = 0.5;
  
  /**
   * Velocity in the units of pixels in one frame of animation, for in the direction where the object moves the fastest.
   */
  private double velocity = Math.sqrt((vx*vx)+(vy*vy));
  
  /**
   * Represents the distance from the right border of the screen minus the center of the circle.
   */
  public double rightBounds = sceneWidth - circle.getRadius();
  
  /**
   * Represents the distance from the left border of the screen plus the center of the circle.
   */
  public double leftBounds = circle.getRadius();
  
  /**
   * Represents the distance from the upper border of the screen plus the center of the circle.
   */
  public double upperBounds = circle.getRadius();
  
  /**
   * Represents the distance from the bottom of the screen minus the center of the circle.
   */
  public double lowerBounds = sceneHeight - circle.getRadius();

  /**
   * Default Constructor for the BallPane class, where the circle object gets loaded into.
   */
  public BallPane() {
    circle.setFill(Color.GREEN); // Set ball color
    getChildren().add(circle); // Place a ball into this pane
  }
  
  /**
   * Sets the position of the center of the circle at a point in the X axis.
   * @param number double that puts the circle's center at a new position in the x axis.
   */
  public void setX(double number) {
    circle.setCenterX(number);
  }
  
  /**
   * Sets the position of the center of the circle at a point in the Y axis.
   * @param number double that puts the circle's center at a new position in the y axis.
   */
  public void setY(double number) {
    circle.setCenterY(number);
  }
  
  /**
   * Returns the current X position of the circle.
   * @return double number that indicates the x position of the center of the circle.
   */
  public double getX() {
    return circle.getCenterX();
  }
  
  /**
   * Returns the current Y position of the circle.
   * @return double number that indicates the y position of the center of the circle.
   */
  public double getY() {
    return circle.getCenterY();
  }
  
  /**
   * Sets the velocity in the X direction.
   * @param number New velocity in the x direction.
   */
  public void setVX(double number) {
    this.vx = number;
  }
  
  /**
   * Sets the velocity in the Y direction. 
   * @param number New velocity in the y direction.
   */
  public void setVY(double number) {
    this.vy = number;
  }
  
  /**
   * Returns the velocity in the X direction.
   * @return the velocity value in the x direction.
   */
  public double getVX() {
    return this.vx;
  }
  
  /**
   * Returns the velocity in the Y direction.
   * @return the velocity value in the y direction.
   */
  public double getVY() {
    return this.vy;
  }
  
  /**
   * Sets a new radius to the circle and it updates the bounds of the Pane in which the ball bounces.
   * @param number the new radius of the object. 
   */
  public void setRadius(double number) {
    circle.setRadius(number);
    rightBounds = sceneWidth - circle.getRadius();
    leftBounds = circle.getRadius();
    upperBounds = circle.getRadius();
    lowerBounds = sceneHeight - circle.getRadius();
  }
  
  /**
   * Gets the radius of the circle.
   * @return the radius of the circle.
   */
  public double getRadius() {
    return circle.getRadius();
  }
  
  /**
   * Decreases the size of the ball by a 1/4 of the original radius, every time it gets called.
   */
  public void decreaseBallSize(){
    System.out.println("Old Radius: " + circle.getRadius());
    circle.setRadius(circle.getRadius() - (this.radius * 0.25));
    System.out.println("New Radius: " + circle.getRadius());
  }
  
  /**
   * Increases the size of the ball by a 1/4 of the original radius, every time it gets called.
   */
  public void increaseBallSize(){
    System.out.println("Old Radius: " + circle.getRadius());
    circle.setRadius(circle.getRadius() + (this.radius * 0.25));
    System.out.println("New Radius: " + circle.getRadius());
  }
  
  /**
   * Resets the ball's velocity and size.
   */
  public void reset(){
    this.vx = 0.5;
    this.vy = 0.5;
    circle.setRadius(this.radius);
    setX(circle.getRadius());
    setY(circle.getRadius());
  }
  
  /**
   * Creates a new color for the ball and assigns it to it.
   */
  public void setNewColor(){
    Color randomColor = new Color(Math.random(), Math.random(), Math.random(),1.0);
    this.circle.setFill(randomColor);
    System.out.println("New Color");
  }
  
  /**
   * Returns the bounds of the circle object in the Pane.
   * @return the Bounds object.
   */
  public Bounds getBounds(){
    return circle.getBoundsInParent();
  }
  
  /**
   * Calculates the velocity on the x axis to send the ball in a certain direction, depending on where it lands.
   */
  protected void calculateBounceBall() {
    System.out.println("Ball BOUNCE || " + "X: " + this.getX() + "Y: " + this.getY() + " dx = " + vx + " dy = " + vy + " Velocity = " + this.velocity);
    this.velocity += (this.velocity * 0.08);
    double difference = ((this.getX() - (this.getX() + 50 ) + this.radius) / (this.getX()+50+this.getRadius()) ) * 5;
    
    vx = (difference * Math.sqrt((this.velocity*this.velocity) - (vy*vy)));
    vy = (-1 * Math.sqrt( (this.velocity*this.velocity) - (vx*vx) ));
    
    System.out.println("Ball BOUNCE || " + "X: " + this.getTranslateX() + "Y: " + this.getTranslateY() + " dx = " + vx + " dy = " + vy + " Velocity = " + this.velocity);

    // Adjust ball position
    if (x < 0){
      x = 0;
    }
    
    if (y < 0){
      y = 0;
    }
      
    if (x > 600){
      x = 600;
    }
  
    if (y > 600){
      y = 600;
    }
  }
}