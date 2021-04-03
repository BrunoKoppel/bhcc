/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject2brunokoppel;

/**
 *
 * @author brunokoppel
 */
public class PairSixSidedDice extends Dice {
    
    /**
     * Default constructor
     */
    public PairSixSidedDice(){
        super(2, 6);
    }
    
    /**
     * Creates an instance of a pair of six sided dices, this method is never run.
     * @param numDice number of dices
     * @param numSides number of sides in the array.
     */
    public PairSixSidedDice(int numDice, int numSides){
        super(numDice, numSides);
    }
    
    /**
     * isSnakeEyes Method to check if the values are a snake eye throw
     * @return true if both dices are 1, false if they are not.
     */
    public boolean isSnakeEyes() {
        return isDoubles() && currentRoll[0] == 1;

    }
    
    /**
     * isDoubles Method to check if both dices are the same.
     * @return true if both dices are the same number, false if not.
     */
    public boolean isDoubles() {
        return currentRoll[0] == currentRoll[1];
    }
    
    /**
     * isSixes Method to check if both dices are the same and if they are both six.
     * @return true if both dices are six, false if they are not.
     */
    public boolean isSixes() {
         return isDoubles() && currentRoll[0] == 6;
    }
    
    /**
     * prints the information of the PairSixSidedDice (Used for testing purposes mainly)
     * @return information about the PairSixSidedDice.
     */
    public String toString() {
        String pairInfo = this.getNumberOfDices() + "Dices with " + this.getNumberOfSides() + " sides.";
        return pairInfo;
    }

}
