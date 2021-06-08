/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;

/**
 * Abstract Class that defines a explorer. It implements the photograph interface.
 * @author brunokoppel
 */
public abstract class Explorer implements Photograph {
  private String name;
  
  /**
   * Default Constructor
   */
  Explorer(){
    setName("");
  }
  
  /**
   * Constructor for the Explorer
   * @param newName String value for the name of the explorer
   */
  Explorer(String newName){
    setName(newName);
  }
  
  /**
   * Set Method for the name of the explorer
   * @param newName New String value for the name of the explorer
   */
  public void setName(String newName){
    this.name = newName;
  }
  
 /**
  * Get Method for the name of the Explorer
  * @return 
  */
  public String getName(){
    return this.name;
  }
  
  /**
   * Returns a String symbolizing the print out of a photograph event.
   * @param lt Living thing object that gets passed
   * @return String That symbolizes the print out of a photograph event.
   */
  public String recordSighting(LivingThing lt){
    return (this.getName() + " just photographed a " + lt.toString());
  }
}
