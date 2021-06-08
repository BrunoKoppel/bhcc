/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;

/**
 * Diver is a sub class of explorer
 * @author brunokoppel
 */
public class Diver extends Explorer {
  private int minutesUnderWater;
  
  /**
   * Default Constructor
   */
  public Diver(){
    super("");
    setMinutesUnderWater(0);
  }
  
  /**
   * Constructor for a Diver
   * @param name String name that is given to a Diver object
   * @param minutesUnderWater int value that represents the amount of minutes the diver has been under water
   */
  public Diver(String name, int minutesUnderWater){
    super(name);
    setMinutesUnderWater(minutesUnderWater);
  }
  
  /**
   * Set method for the minutes under water that the diver has been.
   * @param newMinutesUnderWater int number indicating the amount of minutes under water.
   */
  public void setMinutesUnderWater(int newMinutesUnderWater){
    this.minutesUnderWater = newMinutesUnderWater;
  }
  
  /**
   * Get method for the minutes the diver has been under water.
   * @return int value that represents the amount of minutes the diver has been under water.
   */
  public int getMinutesUnderWater(){
    return this.minutesUnderWater;
  }
  
  /**
   * Method specific to the Diver class. Returns a Boolean that indicates if the diver can photograph a living thing or not.
   * @param lt living thing object.
   * @return a true value if the living thing object is from the Sea, false if it's not from the sea.
   */
  public boolean isDiverAbleToPhotographLivingThing(LivingThing lt){
    if (!(lt instanceof Sea)){
      return false;
    } 
    return true;
  }
  
  /**
   * Method that records a sighting of a living thing. 
   * @param lt living thing object.
   * @return String that gets print out for the photograph event.
   */
  @Override
  public String recordSighting(LivingThing lt){
    if (!isDiverAbleToPhotographLivingThing(lt)){
      return ("\n" + this.getName() + " is a diver can't photograph a " + lt.getName() + " because is not a sea creature.");
    }
    return ("\n" + this.getName() + " at " + getMinutesUnderWater() + " minutes under water just photographed a:\n" + lt.toString());
  }
}
