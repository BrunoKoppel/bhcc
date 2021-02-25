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
public class Dice {
    public static boolean VERBOSE = false;
    /**
     * Maximum Amount of dices for any game.
     */
    public static int MAXDICE = 10;
    
    /**
     * number of dices in the object.
     */
    public int numDice;
    
    /**
     * Array of dices that make up the dices.
     */
    public Die[] dice;
    
    /**
     * Value that store the sum of the latest roll just done.
     */
    public int latestSum;
    
    /**
     * Array storing the numbers just rolled.
     */
    public int[] currentRoll;
    
    /**
     * Array that stores the amount of numbers for a certain type of pair.
     */
    public int[] intPairsToNumber;
    
    // Constructors
    
    /**
     * Default Constructor.
     */
    public Dice(){
        setNumberOfDices(0);
        setNumberOfSides(0);
    }
    
    /**
     * Initiates a new dice.
     * @param numDice number of dices given by the user.
     * @param numSides number of sides given by the user.
     */
    public Dice(int numDice, int numSides){
        setNumberOfDices(numDice);
        setNumberOfSides(numSides);
    }
    
    
    // Setters
    
    /**
     * Set method for the number of dices.
     * @param numDice number of dices given by the user.
     */
    public void setNumberOfDices(int numDice) {
        if (numDice < 1 ){
            this.numDice = 1;
        } else if (numDice > MAXDICE) {
            this.numDice = MAXDICE;
        } else {
            this.numDice = numDice;
        }
        
        dice = new Die[numDice];
        currentRoll = new int[numDice];
    }
    
    /**
     * Set method for the number of sides.
     * @param numberOfSides number of sides given by the user.
     */
    public void setNumberOfSides(int numberOfSides) {
        if (numberOfSides < 2) {
            numberOfSides = 2;
        } else if (numberOfSides > 25) {
            numberOfSides = 25;
        } else {
            numberOfSides = numberOfSides;
        }
        
        dice = new Die[getNumberOfDices()];
        currentRoll = new int[getNumberOfDices()];
        
        for (int index = 0; index < getNumberOfDices(); index++){
            dice[index] = new Die(numberOfSides);
        }
        
        intPairsToNumber = new int[numberOfSides];
    }
    
    /**
     * Set method for the number of sides.
     * @param numDice number of dices given by the user.
     * @param numberOfSides number of sides given by the user. 
     */
    public void setNumberOfSides(int numDice, int numberOfSides) {
        dice = new Die[numDice];
        currentRoll = new int[numDice];
        for (int index = 0; index < numDice; index++){
            dice[index] = new Die(numberOfSides);
        }
    }
    
    /**
     * This sets the array that contains the pairs, triples found in the array.
     * @param num of index in the array.
     * @param amountOfNumber amount of numbers found with that same number in the roll.
     */
    public void setIntPairsToNumber(int num, int amountOfNumber){
        if (VERBOSE){
            System.out.printf("\nThere are %d numbers equal to %d", amountOfNumber, num);
        }
        intPairsToNumber[num - 1] = amountOfNumber;
    }
    
    /**
     * Method used to set the LatestSum value;
     * @param newLatestSum new value to assign to the latest sum.
     */
    public void setLatestSum(int newLatestSum) {
        this.latestSum = newLatestSum;
    }
    
    /**
     * Method used for testing in the testDice.
     * @param arr array of integers that get assigned to the current Roll.
     */
    public void setTestValueCurrentRoll(int [] arr) {
        this.currentRoll = arr;
    }
    
    // Getters
    
    /**
     * get method for the number of sides.
     * @return the number of sides of the first element of the die class initiated.
     */
    public int getNumberOfSides() {
        return dice[0].getNumberOfSides();
    }
    
    /**
     * Get method for the number of dices
     * @return the number of dices created in the instance.
     */
    public int getNumberOfDices() {
        return this.numDice;
    }
    
    /**
     * Get method for the max number of dices that are allowed in the class.
     * @return the max number of dices allowed
     */
    public int getMaxNumberOfDices() {
        return MAXDICE;
    }
    
    /**
     * Method used to get the LatestSum value.
     */
    public int getLatestSum() {
        return this.latestSum;
    }
    
    // Operation exclusive methods
    
    /**
     * Roll Method, makes the dice instance rolls each single die and return the array of these.
     * @return array of integers with the roll values.
     */
    public int[] roll(){
        for (int index = 0; index < getNumberOfDices(); index++) {
            this.currentRoll[index] = dice[index].roll();
        }
        return currentRoll;
    }
    
    /**
     * Sum Method, calculates the sum of the latest roll with the array generated from the roll method.
     * @return 
     */
    public int sum(){
        setLatestSum(0);
        for (int index = 0; index < getNumberOfDices(); index++) {
            if (VERBOSE){
                System.out.printf("\nCurrent Sum: %d ", getLatestSum());
            }
            setLatestSum(getLatestSum() + currentRoll[index]) ;
            if (VERBOSE){
                System.out.printf("\nNew Sum: %d ", getLatestSum());
            }
        }
        return this.latestSum;
    }
    
    /**
     * nSpecial Method, returns an integer for the amount of times a value repeats in the array.
     * @param num number that we are looking for the array.
     * @return the number of instances that the element repeats.
     */
    public int nSpecial(int num){
        int amountOfNumber = 0;
        for (int index = 0; index < getNumberOfDices(); index++) {
            if (this.currentRoll[index] == num){
                amountOfNumber++;
            }
        }
        setIntPairsToNumber(num, amountOfNumber);
        return amountOfNumber;
    }
    
    /**
     * isRollStraight Method, checks if the roll got, is a straight throw.
     * @return returns true if it is, false if it's not.
     */
    public boolean isRollStraight(){
        int consecutiveCountOfStraights = 0;
        int[] list = this.currentRoll;
        for (int indexX = 0; indexX < getNumberOfDices(); indexX++) {
            for (int indexY = indexX + 1; indexY < getNumberOfDices(); indexY++) {
                if (list[indexX] < list[indexY]){
                    int temp = list[indexX];
                    list[indexX] = list[indexY];
                    list[indexY] = temp;
                }
            }
        }
        
        for (int index = 0; index < (getNumberOfDices() - 1); index++){
            if (list[index] ==  (list[index + 1] + 1)){
                consecutiveCountOfStraights++;
            }
        }
        return (consecutiveCountOfStraights == (getNumberOfDices() - 1));
    }
    
    /**
     * prints the information of the Dice (Used for testing purposes mainly)
     * @return information about the Dice.
     */
    public String toString() {
        String diceInfo = getNumberOfDices() + "Dice(s) with " + getNumberOfSides() + " sides";
        return diceInfo;
    }
}
