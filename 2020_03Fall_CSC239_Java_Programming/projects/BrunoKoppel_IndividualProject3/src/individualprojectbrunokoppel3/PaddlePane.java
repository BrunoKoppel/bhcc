/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrunokoppel3;

import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PaddlePane extends Pane {
  /**
   * Variable imported from the main file, representing the position of the paddle relative to the scene.
   */
  static public int paddlePosition = IndividualProjectBrunoKoppel3.sceneHeight - 200;
  
  /**
   * Variable imported from the main file, representing the width of the scene.
   */
  static public int sceneWidth = IndividualProjectBrunoKoppel3.sceneWidth;
  
  /**
   * Represents a unit of measure that is used to determine the size in which the paddle increases or decreases size.
   */
  public final double block = 50;
  
  /**
   * Represents the Width of the rectangle.
   */
  private double x = block * 2;
  
  /**
   * Represents the Height of the rectangle.
   */
  private double y = block / 10;
  
  /**
   * Rectangle object that represents the paddle object.
   */
  private Rectangle rectangle = new Rectangle(0.0, paddlePosition, x, y);
  
  /**
   * Represents the maximum position for the paddle in the right border.
   */
  public double rightBorder = (sceneWidth - rectangle.getWidth());
  
  /**
   * Represents the minimum position for the paddle in the left border.
   */
  public double leftBorder = (0.0 - (rectangle.getWidth()/2));

  /**
   * Default Constructor for the Paddle Pane.
   */
  public PaddlePane() {
    rectangle.setFill(Color.BLUE); // Set Polygon color
    getChildren().add(rectangle); // Place a Polygon into this pane
  }
  
  /**
   * Sets the position of the paddle by relocating the rectangle object.
   * @param x double number that represents the position of the mouse.
   */
  public void setX(double x){
    if((x <= rightBorder) || (x >= leftBorder)){
      rectangle.relocate(x - (this.x/2), paddlePosition);
    }
  }
  
  /**
   * Returns the X position in the X axis of the upper left corner of the rectangle.
   * @return double number of the x axis point of the upper left corner of the rectangle.
   */
  public double getX() {
    return rectangle.getX();
  }
  
  /**
   * Returns the Y position in the Y axis of the upper left corner of the rectangle.
   * @return double number of the y axis point of the upper left corner of the rectangle.
   */
  public double getY() {
    return rectangle.getY();
  }
  
  /**
   * Returns the width of the rectangle object.
   * @return double number, representing the width of the rectangle.
   */
  public double getPaddleWidth() {
    return rectangle.getWidth();
  }
  
  /**
   * Returns the height of the rectangle object.
   * @return double number, representing the height of the rectangle.
   */
  public double getPaddleHeight() {
    return rectangle.getHeight();
  }
  
  /**
   * Increases the Width of the paddle by 1/2 of the block unit.
   */
  public void increasePaddleWidth() {
    rectangle.setWidth(this.getPaddleWidth() + (this.block * 0.5));
    rightBorder = (sceneWidth - (rectangle.getWidth()/2));
    leftBorder = (0.0 - (rectangle.getWidth()/2));
  }
  
  /**
   * Decreases the Width of the paddle by 1/2 of the block unit.
   */
  public void decreasePaddleWidth() {
    rectangle.setWidth(this.getPaddleWidth() - (this.block * 0.5));
    rightBorder = (sceneWidth - rectangle.getWidth());
    leftBorder = (0.0 - (rectangle.getWidth()/2));
  }

  /**
   * Returns the Bounds object of the rectangle that represent the position of the paddle object.
   * @return a bounds object with information about the position of the rectangle within its parent Node.
   */
  public Bounds getBounds(){
    return rectangle.getBoundsInParent();
  }
}