/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;


/**
 * Sea creature extend living thing and inherits its name and mobility value.
 * @author brunokoppel
 */
public class Sea extends LivingThing {
  private String color;
  private double length;
  
  /**
   * Default constructor for a Sea creature
   */
  Sea(){
    super("", false);
    setColor(null);
    setLength(0);
  }
  
  /**
   * Constructor for a Sea creature
   * @param newName name of the creature
   * @param isMobile can the creature move or is it stationary
   * @param newColor color of the creature
   * @param newLength length of the creature
   */
  Sea(String newName, boolean isMobile, String newColor, double newLength){
    super(newName, isMobile);
    setColor(newColor);
    setLength(newLength);
  }
  /**
   * Set the color of the creature
   * @param newColor string value, representing the color.
   */
  public void setColor(String newColor){
    this.color = newColor;
  }
  
  /**
   * Sets the length of the creature
   * @param newLength double value indicating the length of the creature in centimeters
   */
  public void setLength(double newLength){
    this.length = newLength;
  }
  
  /**
   * Gets color assigned to the sea creature.
   * @return the string value of color.
   */
  public String getColor(){
    return this.color;
  }
  
  /**
   * Gets the length of the sea creature 
   * @return the double value for the length of the creature in centimeters.
   */
  public double getLength(){
    return this.length;
  }
  
  /**
   * Method that prints the result when a sea creature is photographed.
   * @return String for the print out.
   */
  @Override
  public String toString(){
    return (super.toString() + ", it has a pretty " + getColor() + " color(s) and a length of: " + getLength() + " centimeters");
  }
}
