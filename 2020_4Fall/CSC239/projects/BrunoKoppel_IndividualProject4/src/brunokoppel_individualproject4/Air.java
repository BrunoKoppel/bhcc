/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;

/**
 * Air is a subclass of living thing for animal that fly in the air.
 * @author brunokoppel
 */
public class Air extends LivingThing {
  private String habitat;
  private boolean feathered;
  
  /**
   * Default Constructor.
   */
  public Air(){
    super("", false);
    setHabitat("");
    setFeathered(false);
  }
  
  /**
   * Constructor for a object that lives in the Air.
   * @param newName String value for the name of the Air object.
   * @param isMobile Boolean that indicates if the object can move or not.
   * @param habitat String variable that indicates the habitat of the living thing.
   * @param isFeathered Boolean that indicates whether the living thing has feathers or not.
   */
  public Air(String newName, boolean isMobile, String habitat, boolean isFeathered){
    super(newName, isMobile);
    setHabitat(habitat);
    setFeathered(feathered);
  }
  
  /**
   * Set Method for the habitat.
   * @param newHabitat String value that gets passed as the new Habitat for the Air living Thing.
   */
  public void setHabitat(String newHabitat){
    this.habitat = newHabitat;
  }
  
  /**
   * Set method for whether the object has feather or if it doesn't have feathers.
   * @param isFeathered Boolean that gets passed, indicated true, if it has feathers, or false if it doesn't.
   */
  public void setFeathered(boolean isFeathered){
    this.feathered = isFeathered;
  }
  
  /**
   * Get Method for the habitat for the object
   * @return String variable that describes the habitat of the Air living thing.
   */
  public String getHabitat(){
    return this.habitat;
  }
  
  /**
   * Get method for the Boolean of the feathers.
   * @return true of false, whether the object has feathers or not.
   */
  public boolean isFeathered(){
    return this.feathered;
  }
  
  /**
   * Method that prints a statement when the object is photographed.
   * @return String print out for the even of a photograph.
   */
  @Override
  public String toString(){
    String feathered;
    if(this.isFeathered() ){
      feathered = "it is a feathered animal";
    } else {
      feathered = "it isn't a feathered animal";
    }
    
    return (super.toString() + ", it lives in a habitat of " + getHabitat() + " and " + feathered);
  }
}
