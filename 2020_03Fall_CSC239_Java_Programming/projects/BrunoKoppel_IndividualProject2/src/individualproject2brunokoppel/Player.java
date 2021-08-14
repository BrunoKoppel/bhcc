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
public class Player {
    public static boolean VERBOSE = false;
    
    /**
     * Name of a player.
     */
    public String name;
    
    /**
     * Number of players generated so far using the class object.
     */
    public static int numberOfPlayers = 0;
    
    /**
     * Boolean that specifies if the user is a human or not.
     */
    public boolean isPlayerHuman;
    
    /**
     * Array that holds the roll done by a player on a round.
     */
    public int[] currentRoll;
    
    /**
     * Total Score for the entire game that the player has been in.
     */
    public int totalScore = 0;
    
    /**
     * Score for the round that the player has been in.
     */
    public int roundScore = 0;
    
    /**
     * Array that stores in each index, the amount of dices similar to the index.
     */
    public int[] intPairsToNumber;
    
    /**
     * Integer that stores the sum of the roll just done by the player.
     */
    public int sumOfRoll = 0;
    
    public boolean isRollStraight;
    
    
    // Constructors
    
    /**
     * Default Constructor
     */
    public Player(){
        this.numberOfPlayers++;
        setIsPlayerHuman(false);
        setName(String.valueOf(numberOfPlayers), false);
        setTotalScore(0);
    }
    
    /**
     * Initiates an instance of a player with their name. This one is used for human players.
     * @param name of the player given by the user, at creation.
     */
    public Player(String name){
        this.numberOfPlayers++;
        setIsPlayerHuman(true);
        setName(name);
        setTotalScore(0);
    }
    
    /**
     * Initiates an instance of a player that is human or computer. 
     * This one is used for computer players mostly, but also for human players. 
     * Good to initiate players fast, when no names are given.
     * @param isPlayerHuman identifies the player as a computer or player
     */
    public Player(boolean isPlayerHuman){
        this.numberOfPlayers++;
        setIsPlayerHuman(isPlayerHuman);
        setName(String.valueOf(this.numberOfPlayers), isPlayerHuman);
        setTotalScore(0);
    }
    
    /**
     * Initiates a player, mostly human players with their name and their human condition.
     * @param name of the player given by the user, at creation.
     * @param isPlayerHuman identifies the player as a computer or player
     */
    public Player(String name, boolean isPlayerHuman){
        this.numberOfPlayers++;
        setIsPlayerHuman(isPlayerHuman);
        setName(name, isPlayerHuman);
        setTotalScore(0);
    }
    
    
    
    
    
    
    // Setters
    
    /**
     * Set Method to for the name of the player (Used only for human players)
     * @param name of the player given by the user, at creation.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set Method to for the name of the player (Used only for computers)
     * @param name of the player given by the user, at creation.
     */
    public void setName(String name, boolean isPlayerHuman) {
        if (isPlayerHuman){
            this.name = "Player " + name;
        } else {
            this.name = "Computer " + name;
        }
    }
    
    /**
     * Set Method for the condition of the human
     * @param isPlayerHuman identifies the player as a computer or player
     */
    public void setIsPlayerHuman(boolean isPlayerHuman) {
        this.isPlayerHuman = isPlayerHuman;
    }
    
    /**
     * Set method for the round score of the player during a single round or re-rolls.
     * @param score given by the constructor or when assigning a new score to the player
     */
    public void setRoundScore(int score) {
        this.roundScore = score;
    }
    
    /**
     * Set method for the total score of a player in a game.
     * @param score new score value assigned to the total score.
     */
    public void setTotalScore(int score) {
        this.totalScore += score;
    }
    
    /**
     * Get method for the sum of the roll just done by the player.
     * @param newValue number that is assigned to the sum of roll. 
     */
    public void setSumOfRoll(int newValue) {
        this.sumOfRoll = newValue;
    }
    
    
    
    
    
    
    // Getters
    
    /**
     * Get method for the name of the player.
     * @return name string given to the player.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Get method for the condition of the player (Human or Computer)
     * @return true if the user is a human, false if it's not.
     */
    public boolean getIsPlayerHuman() {
        return this.isPlayerHuman;
    }
     
    /**
     * Get method for the score of a single round of a player.
     * @return integer number that represents the score of a round.
     */
    public int getRoundScore() {
        return this.roundScore;
    }
    
    /**
     * Get method for the total score in a game where the player is playing.
     * @return 
     */
    public int getTotalScore() {
        return this.totalScore;
    }
    
    /**
     * Get method for the sum of the roll just done by the player.
     * @return 
     */
    public int getSumOfRoll() {
        return this.sumOfRoll;
    }
    
    /**
     * Get method for the static value of number of players.
     * @return the number of players created so far.
     */
    public int getNumberOfPlayers(){
        return this.numberOfPlayers;
    }
    
    
    // CLASS SPECIFIC METHODS
    
    /**
     * Roll Method for a player does:
     * Prints the result of the roll just done.
     * Saves the sum, and the numbers rolled.
     * Checks for pair, triples, etc
     * Creates an array with the instances of the biggest pair to the lowest.
     * @param setOfDices 
     */
    public void roll(Dice setOfDices){
        // copying intPairs to the player
        this.intPairsToNumber = new int [setOfDices.getNumberOfSides()];
        
        System.out.println(getName() + " Rolls their dice(s)!!!");
        this.currentRoll = setOfDices.roll();
        System.out.printf("[");
        for(int index = 0; index < currentRoll.length; index++){
            if (index == currentRoll.length - 1){
                System.out.printf("%d", currentRoll[index]);
            } else {
                System.out.printf("%d,", currentRoll[index]);
            }
        }
        
        System.out.printf("]");
        setSumOfRoll(setOfDices.sum());
        searchForPairsInRoll(setOfDices);
        System.out.println("\nSum: " + getSumOfRoll());
        
        for (int index = 0; index < setOfDices.getNumberOfSides(); index++){
            this.intPairsToNumber[index] = setOfDices.intPairsToNumber[index];
            if (VERBOSE){
                System.out.printf("%d ", this.intPairsToNumber[index]);
            }
        }
        
        
        
        // check if the roll is straight and add the score if it is.
        this.isRollStraight = setOfDices.isRollStraight();
        
        if (this.isRollStraight && setOfDices.getNumberOfDices() > 1){
            compareRoundScoreAtRoll((2 + setOfDices.getNumberOfDices()));
            System.out.println("UNBELIVEABLE STRAIGHT!!");
        }
        
        // Calculate Score depending on the pairs
        
        // Print out Scores
        System.out.println("\nRound Score: " + getRoundScore());
        System.out.println("Total Score: " + getTotalScore() + "\n");
    }
    
    /**
     * Roll Method for a player does:
     * Prints the result of the roll just done.
     * Saves the sum, and the numbers rolled.
     * Checks for pairs, doubles, six, and snake eyes
     * @param setOfDices  of the instance PairSixSidedDice to process 2 dices of 6 sides
     */
    public void roll(PairSixSidedDice setOfDices) {
        // copying intPairs to the player
        this.intPairsToNumber = new int [setOfDices.getNumberOfSides()];
        
        System.out.println(IndividualProject2BrunoKoppel.ANSI_BLUE + getName() + " Rolls their dice(s)!!!" + IndividualProject2BrunoKoppel.ANSI_RESET );
        this.currentRoll = setOfDices.roll();
        System.out.printf("[");
        for(int index = 0; index < currentRoll.length; index++){
            if (index == currentRoll.length - 1){
                System.out.printf("%d", currentRoll[index]);
            } else {
                System.out.printf("%d,", currentRoll[index]);
            }
        }
        
        System.out.printf("]");
        setSumOfRoll(setOfDices.sum());
        searchForPairsInRoll(setOfDices);
        System.out.println("\nSum: " + getSumOfRoll());
        
        for (int index = 0; index < setOfDices.getNumberOfSides(); index++){
            this.intPairsToNumber[index] = setOfDices.intPairsToNumber[index];
            if (VERBOSE){
                System.out.printf("%d ", this.intPairsToNumber[index]);
            }
        }
        
        this.isRollStraight = setOfDices.isRollStraight();
        if (this.isRollStraight){
            compareRoundScoreAtRoll(1);
        }
        
        if (setOfDices.isSnakeEyes()){
            System.out.print("  Snake eyes!");
        }
        if (setOfDices.isDoubles()){
            System.out.print("  Doubles!");
        }
        if (setOfDices.isSixes()){
            System.out.print("  Sixes!");
        }
        
        // Print out Scores
        System.out.println("\nRound Score: " + getRoundScore());
        System.out.println("Total Score: " + getTotalScore());
    }
    
    /**
     * Searches for values in the roll that repeat, this values are the ones that award scores to the players.
     * Using a switch statement we make sure to assign values to a player by passing a score to the score method.
     * @param setOfDices 
     */
    public void searchForPairsInRoll(Dice setOfDices){
        for (int index = 1; index <= setOfDices.getNumberOfSides(); index++){
            switch (setOfDices.nSpecial(index)){
                case 2:
                    System.out.printf("\nPair (%d) ", index);
                    compareRoundScoreAtRoll(2);
                    break;
                case 3:
                    System.out.printf("\nTriple (%d) ", index);
                    compareRoundScoreAtRoll(4);
                    break;
                case 4:
                    System.out.printf("\nQuad (%d) ", index);
                    compareRoundScoreAtRoll(6);
                    break;
                case 5:
                    System.out.printf("\nQuint (%d) ", index);
                    compareRoundScoreAtRoll(9);
                    break;
                case 6:
                    System.out.printf("\nHexa (%d) ", index);
                    compareRoundScoreAtRoll(12);
                    break;
                case 7:
                    System.out.printf("\nHepta (%d) ", index);
                    compareRoundScoreAtRoll(15);
                    break;
                case 8:
                    System.out.printf("\nOcto (%d) ", index);
                    compareRoundScoreAtRoll(18);
                    break;
                case 9:
                    System.out.printf("\nNine (%d) ", index);
                    compareRoundScoreAtRoll(25);
                    break;
                case 10:
                    System.out.printf("\nTen Fold! (%d) ", index);
                    compareRoundScoreAtRoll(50);
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
     * Compares the Score and makes sure that new pairs found don't mess up with the score.
     * @param newValue new value coming form the roll class.
     */
    public void compareRoundScoreAtRoll(int newValue){
        if (newValue > getRoundScore()){
            setRoundScore(getRoundScore() + newValue);
        } else if (getRoundScore() >= 2 && newValue == 2) {
            setRoundScore(getRoundScore() + 1);
        } else if (getRoundScore() >= 2 && newValue == 4) {
            setRoundScore(getRoundScore() + 3);
        } else if (getRoundScore() >= 5 && newValue == 6) {
            setRoundScore(getRoundScore() + 3);
        } else if (getRoundScore() >= 8 && newValue == 9) {
            setRoundScore(getRoundScore() + 4);
        } else if (getRoundScore() >= 11 && newValue == 12) {
            setRoundScore(getRoundScore() + 6);
        } else if (getRoundScore() >= 14 && newValue == 15) {
            setRoundScore(getRoundScore() + 7);
        } else if (getRoundScore() >= 19 && newValue == 18) {
            setRoundScore(getRoundScore() + 9);
        } else if (getRoundScore() >= 24 && newValue == 25) {
            setRoundScore(getRoundScore() + 12);
        } else if (getRoundScore() >= 49 && newValue == 50) {
            setRoundScore(getRoundScore() + 25);
        }
    }
    
    /**
     * prints the information of the player (Used for testing purposes mainly)
     * @return information about the player.
     */
    public String toString(){
        String playerInfo = getName() + " is ";
        if (getIsPlayerHuman()){
            playerInfo += "Computer ";
        } else {
            playerInfo += "Human ";
        }
        playerInfo += "with a score of " + getTotalScore();
        return playerInfo;
    }
}
