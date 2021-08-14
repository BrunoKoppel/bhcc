/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;

/**
 * Living thing class that creates allows other objects to be extended from Living Thing.
 * @author brunokoppel
 */
public abstract class LivingThing{
  private String name;
  private boolean mobile;
  
  /**
   * Default constructor for the Living Thing Object
   */
  LivingThing(){
    setName("");
    setMobile(false);
  }
  
  /**
   * Constructor for the Living Thing Object
   * @param newName String variable for the name of the object
   * @param newMobile Boolean variable that represents the whether the object can move or not.
   */
  LivingThing(String newName, boolean newMobile){
    setName(newName);
    setMobile(newMobile);
  }
  
  /**
   * Sets the new name for an object
   * @param newName String variable representing the new name for the object.
   */
  public void setName(String newName){
    this.name = newName;
  }
  
  /**
   * Sets whether the object can move or not.
   * @param newMobile Boolean that indicates if the object moves or not.
   */
  public void setMobile(boolean newMobile){
    this.mobile = newMobile;
  }
 
  /**
   * Gets the name of the object
   * @return String variable that represents the name of the Living Thing
   */
  public String getName(){
    return this.name;
  }
  
  /**
   * Gets a Boolean that shows whether the object can move or not.
   * @return Boolean that indicates if the object can move or not.
   */
  public boolean isMobile(){
    return this.mobile;
  }
  
  /**
   * Returns a String print out for when the object is photographed.
   * @return String for the print out.s
   */
  @Override
  public String toString(){
    String movement;
    if(this.isMobile() ){
      movement = "can";
    } else {
      movement = "can't";
    }
    return (getName() + ", which " + movement + " move");
  }
}
