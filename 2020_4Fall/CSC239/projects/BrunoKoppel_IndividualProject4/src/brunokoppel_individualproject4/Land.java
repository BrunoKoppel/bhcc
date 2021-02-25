/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;

/**
 * Land Class defines objects that live on the land.
 * @author brunokoppel
 */
public class Land extends LivingThing {
  private String habitat;
  private double height;
  
  /**
   * Default constructor for the living things that live on the land.
   */
  Land(){
    super("", false);
    setHabitat("");
    setLength(0);
  }
  
  /**
   * Constructor for the living things that live in land.
   * @param newName inherited from the super class.
   * @param isMobile inherited from the super class.
   * @param habitat String that indicates the habitat of the living thing.
   * @param height Double valuable that indicates the height of the object.
   */
  Land(String newName, boolean isMobile, String habitat, double height){
    super(newName, isMobile);
    setHabitat(habitat);
    setLength(height);
  }
  
  /**
   * Set Method that sets the habitat for a living thing.
   * @param newHabitat String that explains the habitat of the living thing.
   */
  public void setHabitat(String newHabitat){
    this.habitat = newHabitat;
  }
  
  /**
   * Set Method that sets the length, for a living thing.
   * @param newHeight Double value that shows how tall is the living thing.
   */
  public void setLength(double newHeight){
    this.height = newHeight;
  }
  
  /**
   * Get Method for the habitat
   * @return String value containing the habitat of the living thing.
   */
  public String getHabitat(){
    return this.habitat;
  }
  
  /**
   * Get Method for the height.
   * @return Double value for the height of the living thing.
   */
  public double getHeight(){
    return this.height;
  }
  
  /**
   * Returns a String for the print out when the object is photographed.
   * @return String indicating the event of a photograph.
   */
  @Override
  public String toString(){
    return (super.toString() + ", it lives in a habitat of " + getHabitat() + " and it's got a height of: " + getHeight() + " centimeters");
  }
}
