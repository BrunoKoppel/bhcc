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
public class Game {
    public static boolean VERBOSE = false;
    
    /**
     * The win Score for a specific game instance, default is 50.
     */
    public int winScore = 50;
    
    /**
     * The current round in which the game currently is.
     */
    public int currentRound = 0;
    
    /**
     * Total number of players in the game.
     */
    public int numberOfPlayers;
    
    /**
     * Number of human players in the game.
     */
    public int numberOfHumanPlayers;
    
    /**
     * Array of players playing the game.
     */
    public Player[] player;
    
    /**
     * Players that have a Round Score of zero, used for eliminating users and determining a winner.
     */
    public int playersWithZeros = 0;
    
    
    /**
     * Default Constructor
     */
    public Game(){
        Player.numberOfPlayers = 0;
        setCurrentRound(0);
        setNumberOfPlayers(0);
        setNumberOfHumanPlayers(0);
        setUpPlayers();
    }
    
    /**
     * Constructor for a game instance, where humans and total number of players are provided
     * @param numberOfHumanPlayers human players that are playing.
     * @param numberOfPlayers total number of players.
     */
    public Game(int numberOfHumanPlayers, int numberOfPlayers){
        Player.numberOfPlayers = 0;
        setCurrentRound(0);
        setNumberOfPlayers(numberOfPlayers);
        setNumberOfHumanPlayers(numberOfHumanPlayers);
        setUpPlayers();
    }
    
    
    // Setters
    
    /**
     * Set method to assign a round number to the currentRound
     * @param currentRound new round of the game
     */
    public void setCurrentRound(int currentRound){
        this.currentRound = currentRound;
    }
    
    /**
     * Set method that sets the number of players in the game
     * @param numberOfPlayers total number of players.
     */
    public void setNumberOfPlayers(int numberOfPlayers){
        if (numberOfPlayers > 4) {
            this.numberOfPlayers = 4;
        } else if (numberOfPlayers < 2) {
            this.numberOfPlayers = 2;
        } else {
            this.numberOfPlayers = numberOfPlayers;
        }
        player = new Player[this.numberOfPlayers];
    }
    
    /**
     * Set Method to assign the number of human players in a game
     * @param numberOfHumanPlayers total number of human players in a game
     */
    public void setNumberOfHumanPlayers(int numberOfHumanPlayers){
        if (numberOfHumanPlayers > getNumberOfPlayers()) {
            this.numberOfHumanPlayers = getNumberOfPlayers();
        } else if (numberOfHumanPlayers < 0) {
            this.numberOfHumanPlayers = 0;
        } else {
            this.numberOfHumanPlayers = numberOfHumanPlayers;
        }
    }
    
    /**
     * Function that initiates the player objects of the game instance, it uses the total number of players and the total number of human players.
     */
    public void setUpPlayers(){
        for(int index = 0; index < getNumberOfPlayers(); index++){
            if (index < getNumberOfHumanPlayers()){
                player[index] = new Player(IndividualProject2BrunoKoppel.getPlayerName(index));
            } else {
                player[index] = new Player(false);
            }
        }        
    }
    
    /**
     * Set method that assigns the score needed to win the game
     * @param winScore integer that has been given through the main class
     */
    public void setWinScore(int winScore){
        if (winScore > 49 && winScore < 200){
            this.winScore = winScore;
        }
    }
    
    
    // Getters
    
    /**
     * return method for current round.
     * @return the current round of the game.
     */
    public int getCurrentRound(){
        return this.currentRound;
    }
    
    /**
     * return method for number of human players
     * @return the number of human players.
     */
    public int getNumberOfHumanPlayers(){
        return this.numberOfHumanPlayers;
    }
    
    /**
     * return method for total number of players
     * @return the current round of the game.
     */
    public int getNumberOfPlayers(){
        return this.numberOfPlayers;
    }
    
    /**
     * return method for the win score of the game
     * @return the win score of the game.
     */
    public int getWinScore(){
        return this.winScore;
    }
    
    /**
     * Goes through each player and returns how many didn't score in the round.
     * @param setOfDices a set of dices generated in the main method that can be changed in sides and number of dices.
     * @return 
     */
    public int getPlayersWithScoresEqualZero(Dice setOfDices) {
        this.playersWithZeros = 0;
        int playersWithOne = 0;
        for (int index = 0; index < getNumberOfPlayers(); index++){
            if (player[index].roundScore == 0){
                this.playersWithZeros++;
            }
            
            if (player[index].roundScore == 1){
                playersWithOne++;
            }
        }
        
        if (playersWithOne == 4){
            for (int index = 0; index < getNumberOfPlayers(); index++){
                player[index].setRoundScore(0);
                this.playersWithZeros = 4;
            }
        }
        
        return this.playersWithZeros;
    }
    
    
    
    // METHODS FOR GAME MECHANICS
    
    /**
     * Method that makes sure to iterate through each player until it finds a winner.
     * First: it sets to zero, any player that score below the highest score in the round.
     * 
     * Second: it checks how many players have scores of zeros and decides to:
     *      If all players have zeros, check the sum results.
     *      Else If less than 3 players have zeros, that means two or more players have the same score, then it proceeds to eliminate however score a lesser pair.
     *          Before this step finishes it checks if there are still less than 3 players that have zeros, if this it's true, it will re-Roll for these players.
     *      Else it will say that a winner has been found, since having 3 players with zeros means only one has kept it's score.
     * 
     * 
     * @param setOfDices a set of dices generated in the main method that can be changed in sides and number of dices.
     */
    public void processRoundScores(Dice setOfDices){
        boolean isWinnerFound = false;
        int counterOfSameNumbers = 0;
        while(!isWinnerFound){
            setPlayersWithLowScoresToZero();
            this.playersWithZeros = getPlayersWithScoresEqualZero(setOfDices);
            
            if (this.playersWithZeros == getNumberOfPlayers()){
                checkSumValues(setOfDices);
            } else if (this.playersWithZeros < (getNumberOfPlayers() - 1)) {
                for (int indexX = 0; indexX < getNumberOfPlayers(); indexX++){
                    for (int indexY = indexX + 1; indexY < getNumberOfPlayers(); indexY++){
                        if ((player[indexX].roundScore == player[indexY].roundScore) && player[indexY].roundScore > 0){
                            
                            if (VERBOSE){
                                System.out.printf("\n%s --- %s",player[indexX].getName(), player[indexY].getName());
                            }
                            
                            counterOfSameNumbers = checkRollValuesOfPlayersWithEqualScore(indexX, indexY, setOfDices);  
//                            indexY = indexX = getNumberOfPlayers();
                        }
                    }
                }
                
                if (counterOfSameNumbers == setOfDices.getNumberOfSides()){
                    reRollPlayersWithEqualScore(setOfDices, true);
                }
                
            } else {
                isWinnerFound = true;
            }
        }
    }
    
    /**
     * Iterates through the array of players and checks their scores.
     * Players with scores lower than another player have their scores set to 0.
     * The idea behind it is that players with 0s get ignore, and only players with the high values remain.
     */
    public void setPlayersWithLowScoresToZero(){
            
        for (int indexX = 0; indexX < getNumberOfPlayers(); indexX++){    
            for (int indexY = 0; indexY < getNumberOfPlayers(); indexY++){
                if (player[indexX].roundScore > player[indexY].roundScore){
                    player[indexY].setRoundScore(0);
                    player[indexY].setSumOfRoll(0);
                } else if (player[indexX].roundScore < player[indexY].roundScore){
                    player[indexX].setRoundScore(0);
                    player[indexX].setSumOfRoll(0);
                }
            }
        }
    }
    
    /**
     * Checks the values of players that have landed a similar score.
     * @param playerIndexA int number representing the index used to reference to an A player
     * @param playerIndexB int number representing the index used to reference to an B player
     * @param setOfDices a set of dices generated in the main method that can be changed in sides and number of dices.
     */
    public int checkRollValuesOfPlayersWithEqualScore(int playerIndexA, int playerIndexB, Dice setOfDices){
        boolean hasPlayerBeenEliminated = false;
        int index = setOfDices.getNumberOfSides() - 1;
        int counterOfSameNumbers = 0;
        while(!hasPlayerBeenEliminated && (index >= 0)) {
            if (VERBOSE){
                System.out.printf("\nIndex %d", index);
                System.out.printf("\n%s has %d --- %s has %d",player[playerIndexA].getName(), player[playerIndexA].intPairsToNumber[index], player[playerIndexB].getName(), player[playerIndexB].intPairsToNumber[index]);
                System.out.printf("\n%d and %d", playerIndexA, playerIndexB);
            }
            
            
            if ((player[playerIndexA].intPairsToNumber[index] > player[playerIndexB].intPairsToNumber[index]) && (player[playerIndexA].intPairsToNumber[index] > 0)) {
                player[playerIndexB].setRoundScore(0);
                hasPlayerBeenEliminated = true;
            } else if ((player[playerIndexA].intPairsToNumber[index] < player[playerIndexB].intPairsToNumber[index])  && (player[playerIndexB].intPairsToNumber[index] > 0)) {
                player[playerIndexA].setRoundScore(0);
                hasPlayerBeenEliminated = true;
            } else if (player[playerIndexA].intPairsToNumber[index] == player[playerIndexB].intPairsToNumber[index]) {
                counterOfSameNumbers++;
            }
            index--;
        }
        
        
        
        return counterOfSameNumbers;
    }
    
    /**
     * Re-roll players that have the same score, players with zero values are ignore, the method looks for values above zero, since the only players with non-zero values are the ones that have the same values.
     * @param setOfDices a set of dices generated in the main method that can be changed in sides and number of dices.
     * @param doPlayersHaveNoScore a true value means that all players had 0 for their round score, and we have to re-roll players that have the same sum values. a false value means that we have to re-roll players that got the same round score.
     */
    public void reRollPlayersWithEqualScore(Dice setOfDices, boolean doPlayersHaveNoScore){
        System.out.println("\n" + IndividualProject2BrunoKoppel.ANSI_RED + "Stand Off Between:" + IndividualProject2BrunoKoppel.ANSI_RESET );
        if (doPlayersHaveNoScore){
            for (int index = 0; index < getNumberOfPlayers(); index++){
                if (player[index].getSumOfRoll() > 0){
                    System.out.println(player[index].getName() + " Re rolls");
                    player[index].setSumOfRoll(0);
                    player[index].setRoundScore(0);
                    player[index].roll(setOfDices);
                }
            }
        } else {
            for (int index = 0; index < getNumberOfPlayers(); index++){
                if (player[index].roundScore > 0){
                    System.out.println(player[index].getName() + " Re rolls");
                    player[index].setRoundScore(0);
                    player[index].setSumOfRoll(0);
                    player[index].roll(setOfDices);
                }
            }
        }
    }
    
    /**
     * Checks the sums of the player, this method only runs if no player got scores for pairs, triples, etc
     * @param setOfDices a set of dices generated in the main method that can be changed in sides and number of dices.
     */
    public void checkSumValues(Dice setOfDices) {
        for (int indexX = 0; indexX < getNumberOfPlayers(); indexX++){
                for (int indexY = indexX + 1; indexY < getNumberOfPlayers(); indexY++){
                    if (player[indexX].getSumOfRoll() > player[indexY].getSumOfRoll()){
                        player[indexY].setSumOfRoll(0);
                    } else if (player[indexX].getSumOfRoll() < player[indexY].getSumOfRoll()){
                        player[indexX].setSumOfRoll(0);
                    }
                    
                    if ((player[indexX].getSumOfRoll() == player[indexY].getSumOfRoll()) && (player[indexX].getSumOfRoll() > 0)){
                        reRollPlayersWithEqualScore(setOfDices, true);
                    }
                }
            }
        
        for (int index = 0; index < getNumberOfPlayers(); index++){
            if (player[index].getSumOfRoll() > 0){
                player[index].setRoundScore(1);
            }
        }
    }
    
    /**
     * The method that runs through all of the scores of the players and finds the one that defeated the rest of the players.
     * This player is the only one that has a score and its score gets assigned to the total score he holds.
     */
    public void awardPointsToRoundWinner() {
        for (int index = 0; index < getNumberOfPlayers(); index++){
            if (player[index].roundScore > 0){
                System.out.println(IndividualProject2BrunoKoppel.ANSI_GREEN + "\n" + player[index].getName() + " wins the round, and earns " + player[index].roundScore + " points!!!\n" + IndividualProject2BrunoKoppel.ANSI_RESET );
            }
            player[index].totalScore += player[index].roundScore;
            player[index].roundScore = 0;
        }
    }
    
    /**
     * Prints the results for the match
     */
    public void printRoundResultsAndBoard() {
        System.out.println("Score Board:");
        for (int index = 0; index < getNumberOfPlayers(); index++){
            System.out.println(player[index].getName() + " has " + player[index].totalScore + " points.");
        }
    }
    
    /**
     * checks if the is a winner in our match
     * @return true if a winner is found, false if not.
     */
    public boolean isThereAWinner(){
        for (int index = 0; index < getNumberOfPlayers(); index++){
            if (player[index].totalScore >= getWinScore()){
                System.out.println("Congratulations " + player[index].getName());
                System.out.println("You have won the match with " + player[index].totalScore + " points.");
                return true;
            }
        }
        return false;
    }
    
    /**
     * prints the information of the game (Used for testing purposes mainly)
     * @return information about the game.
     */
    public String toString(){
        String gameInfo = "Game initiated with " + getNumberOfPlayers() + " players.";
        gameInfo += "\nPlayers info:";
        for (int index = 0; index < getNumberOfPlayers(); index++){
            gameInfo += "\n" + player[index].toString();
        }
        
        return gameInfo;       
    }
}
