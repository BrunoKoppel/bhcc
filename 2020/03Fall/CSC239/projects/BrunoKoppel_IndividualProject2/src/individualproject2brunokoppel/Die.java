/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject2brunokoppel;
import java.util.Random;
/**
 *
 * @author brunokoppel
 */
public class Die {
    /**
     * Number of sides of a dice.
     */
    public int numSides;
    
    /**
     * Constructor for Die, sets up the die with a number of sides.
     * @param numSides 
     */
    public Die(int numSides) {
        setNumberOfSides(numSides);
    }
    
    
    // Setters
    
    /**
     * checks to make sure a new die has been generated with a desired range for the sides. 2 to 25.
     * @param numSides sides of the new die.
     */
    public void setNumberOfSides(int numSides){
        if (numSides < 2) {
            this.numSides = 2;
        } else if (numSides > 25) {
            this.numSides = 25;
        } else {
            this.numSides = numSides;
        }
    }
    
    
    // Getters
    
    /**
     * Gets the number of sides in the die
     * @return number of sides of a single die.
     */
    public int getNumberOfSides(){
        return this.numSides;
    }
    
    
    // Operation exclusive methods
    
    /**
     * Roll Method, creates a random number from 1 to the number of sides of the die.
     * @return int in the range of 1 to the number of sides in the die.
     */
    public int roll() {
        Random rand = new Random();
        return (int)((Math.random() * getNumberOfSides()) + 1);
    }
    
    /**
     * prints the information of the Die (Used for testing purposes mainly)
     * @return information about the Die.
     */
    public String toString() {
        String dieInfo = "Die with " + getNumberOfSides() + " sides";
        return dieInfo;
    }
}
