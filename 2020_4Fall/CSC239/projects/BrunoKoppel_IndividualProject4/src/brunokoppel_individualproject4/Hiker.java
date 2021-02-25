/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;

/**
 * Hiker Class is a subclass of Explorer.
 * @author brunokoppel
 */
public class Hiker extends Explorer {
  private int maxAltitude;
  
  /**
   * Constructor for a Hiker.
   * @param name inherited from the super class.
   * @param maxAltitude int value for the maximum altitude at which the hiker is.
   */
  public Hiker(String name, int maxAltitude){
    super(name);
    setMaxAltitude(maxAltitude);
  }
  
  /**
   * Sets the Altitude of the hiker
   * @param newMaxAltitude int value that represents the height at which the hiker is.
   */
  public void setMaxAltitude(int newMaxAltitude){
    this.maxAltitude = newMaxAltitude;
  }
  
  /**
   * Get method for the altitude of the hiker.
   * @return Int value that represents the Altitude of the hiker.
   */
  public int getMaxAltitude(){
    return this.maxAltitude;
  }
  
  /**
   * Returns a string that gets print out in the event of a record sighting.
   * @param lt living thing object passed.
   * @return String print out.
   */
  @Override
  public String recordSighting(LivingThing lt){
    return ("\n" + this.getName() + " at " + getMaxAltitude() + " meters above just photographed a:\n" + lt.toString());
  }
}
