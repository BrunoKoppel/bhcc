/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject2brunokoppel;
import java.util.Scanner;
/**
 *
 * @author brunokoppel
 */
public class IndividualProject2BrunoKoppel {
    static Scanner input = new Scanner(System.in);
    
    /**
     * Reset code for color setting in the printer.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    
    /**
     * Print Text in Red.
     */
    public static final String ANSI_RED = "\u001B[0m";
    
    /**
     * Print Text in Green.
     */
    public static final String ANSI_GREEN = "\u001B[32m";
    
    /**
     * Print Text in Blue.
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    
    /**
     * variable that is used to create an interaction with the user of the program.
     */
    public static String ENTER;
    
    /**
     * Maximum number of dices allowed for a game.
     */
    public static int MAXDICE = 10;
    
    /**
     * Win Score to determine a winner in a game, passed to the game object.
     */
    public static int winnerScore = 50;
    
    /**
     * Number of players in a game, passed to the game object.
     */
    public static int numberOfPlayers = 2;
    
    /**
     * Number of dices in a game, passed to the game object.
     */
    public static int numDice = 5;
    
    /**
     * Number of sides for each dice in a game, passed to the game object.
     */
    public static int numSide = 6;
    
    /**
     * Main Method, runs the command line that is the menu of the project.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n\nWelcome to Dices 3000!! one millenia ahead of its time!!");
        printManual();
        
        boolean machineState = true;
        
        while (machineState){
            System.out.printf("\nCURRENT GAME SETTINGS\nNumber of players: %d\nNumber of dices: %d\nSides on dices: %d\nWin conditions: first one to get %d points\n",
                    numberOfPlayers, numDice, numSide, winnerScore);
            System.out.printf("\nDiceGame~$ ");
            String userInputCommand[] = processUserInputCommand(input.nextLine());
            
            if (userInputCommand[0].equals("start")){
                processRunCommand(userInputCommand);
                
            } else if (userInputCommand[0].equals("set")){
                processSetCommand(userInputCommand);
                
            } else if (userInputCommand[0].equals("help")){
                printManual();
                
            } else if (userInputCommand[0].equals("quit")){
                machineState = false;
                
            } else {
                System.out.println("You can type \"help\" command to see what commands to use");
            }
        }
    }
    
    /**
     * Prints a Manual with the commands that are recognized by the app
     */
    public static void printManual(){
        System.out.println("The main commands are [start] and [set] ");
        printStartCommandManual();
        printSetCommandManual();
        System.out.println("\nhelp    Prints this command manual, in the case that's needed");
        System.out.println("\nstart   Prints a manual for how to use the \"start\" command");
        System.out.println("\nset     Prints a manual for how to use the \"set\" command");
        System.out.println("\nquit    Quits the program");
         
    }
    
    /**
     * Prints the manual for the set command
     */
    public static void printSetCommandManual(){
        System.out.println("\ncommand  number-flag   settings-flag            Description");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("set      [number]      [variable-to-change]     Changes settings for a game");
        System.out.println("\n  [variable-flag]     Decription:");
        System.out.println("   players             Changes number of players (2 to 4 only allowed)");
        System.out.println("   sides               Changes number of sides for a die (2 minimum)");
        System.out.println("   dices               Changes number of dices used in a game (" + MAXDICE + " maximum)");
        System.out.println("   win                 Changes the win score. (Currently set at: " + winnerScore + ")");
        System.out.println("\nList of possible commands: (Examples)");
        System.out.println(" start set 0");
        System.out.println(" start poker 3");
        System.out.println(" start pair 1");
    }
    
    /**
     * Prints the manual for the start command
     */
    public static void printStartCommandManual(){
        System.out.println("\ncommand  preset-flag         HumanPlayers-flag    Description");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("start    [preset]            [HumanPlayers]       Begins a new game");
        System.out.println("\n  [preset]      Description: (Choose between presets and playing with the current settings)");
        System.out.println("   poker         Start a game with 5 dices of 6 sides, try your luck at Poker Dices!");
        System.out.println("   pair          Start a game with only 2 dices of 6 sides, this special game has no players!... just a PairSixSidedDice");
        System.out.println("   set           Start a game with the current set of settings");
        System.out.println("\n  [HumanPlayers]       Description: (Specifies how many human players are in the total amount of players)");
        System.out.println("   0                    Start a game with no players, just computers");
        System.out.println("   1                    Start a game with one player, this can be you");
        System.out.println("   2                    Start a game with two players, this can be your friend");
        System.out.println("   3                    Start a game with three players, this can be another friend");
        System.out.println("   4                    Start a game with four players, this can be your dog or cat");
        System.out.println("\nList of possible commands: (Examples)");
        System.out.println(" set 4 players");
        System.out.println(" set 7 dices");
        System.out.println(" set -7 sides");
        System.out.println(" set 100 win");
    }
    
    /**
     * Function that checks an integer and returns a true statement if it's an integer, and false otherwise.
     * @param possibleNumber
     * @return true if we have an integer, false if we don't.
     */
    public static boolean isInteger(String possibleNumber) {
        try { 
            Integer.parseInt(possibleNumber); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Splits the string given by spaces, and returns an array of strings
     * @param command string with spaces that is our command.
     * @return array of strings that are the commands
     */
    public static String[] processUserInputCommand(String command){
        String commandArray[] = command.split(" ");
        return commandArray;
    }
    
    
    /**
     * the method that process the input command given for a set command, breaking it down element by element and doing a different option depending on the command given.
     * @param userInputCommand array with the commands given by the user.
     */
    public static void processSetCommand(String []userInputCommand){
        int arrayLength = userInputCommand.length;
        if (arrayLength > 1){
            
            if (arrayLength > 2){
                
                if (userInputCommand[2].equals("players")){
                    
                    numberOfPlayers = Integer.parseInt(userInputCommand[1]);
                    System.out.println("You have designated " + numberOfPlayers + " players.");
                    
                } else if (userInputCommand[2].equals("dices")) {
                    
                    numDice = Integer.parseInt(userInputCommand[1]);
                    System.out.println("You have given " + numDice + " dice(s) per player");
                    System.out.println("Keep in mind, values that are out of bound will be changed to make the game run, this happens at game runtime");
                    
                } else if (userInputCommand[2].equals("sides")) {
                    
                    numSide = Integer.parseInt(userInputCommand[1]);
                    System.out.println("You have magically changed the number of the sides per dice to " + numSide + " sides.");
                    System.out.println("Keep in mind, values that are out of bound will be changed to make the game run, this happens at game runtime");
                    
                } else if (userInputCommand[2].equals("win")) {
                    
                    winnerScore = Integer.parseInt(userInputCommand[1]);
                    System.out.println("You have set the win score at " + winnerScore + " points");
                    
                } else {
                    System.out.println("variable not recognized");
                }
            } else {
                System.out.println("variable not specified");
            }
        } else {
            printSetCommandManual();
        }
    }
    
    /**
     * the method that process the input command give for a start command, breaking it down element by element and doing a different option depending on the command given.
     * @param userInputCommand array with the commands given by the user.
     */
    public static void processRunCommand(String []userInputCommand){
        // Array Length is used to determine if all the commands needed were entered.
        int arrayLength = userInputCommand.length;
        
        // checking the length of the array we make sure we have all the commands needed and if not, we ask for them.
        // If by chance a wrong input is entered, the program will ignore it and return to the main array.
        if (arrayLength > 1){
            int playerChoice;
            if (arrayLength == 2){
                System.out.print("Enter how many human players are playing:");
                playerChoice = input.nextInt();
            } else {
                playerChoice = Integer.parseInt(userInputCommand[2]);
            }
            
            // here we initialize a set of dices for a classic poker game and give the set to a startGame function.
            if (userInputCommand[1].equals("poker") ){
                Dice pokerSetOfDices = new Dice(5, 6);
                runGame(playerChoice, pokerSetOfDices, "poker dices");
            } 
            
            // here we initialize a set of dices for a rad game and give the set to a startGame function.
            else if (userInputCommand[1].equals("set")){
                if (numDice == 2 && numSide == 6){
                    PairSixSidedDice setOfDices = new PairSixSidedDice(numDice, numSide);
                    runGame(playerChoice, setOfDices, "Pair Six Dices");
                } else if (numDice == 5 && numSide == 6){
                    Dice setOfDices = new Dice(numDice, numSide);
                    runGame(playerChoice, setOfDices, "poker dices");
                } else {
                    Dice setOfDices = new Dice(numDice, numSide);
                    runGame(playerChoice, setOfDices, "Custom dices!");
                }
            }
                
            // here we initialize a set of dices for a two dices of six sides game and give the set to a startGame function.
            else if (userInputCommand[1].equals("pair")) {
                PairSixSidedDice twoDices = new PairSixSidedDice(2, 6);
                runGame(playerChoice, twoDices, "Pair Six Dices");
            } else {
                System.out.print("command not recognized");
            }
        } else {
            printStartCommandManual();
        }
    }
    
    
    //FOR DICE CLASSES
    
    /**
     * Method to initiate a game and run it, the process is all handle in the game object.
     * @param numPlayers total number of human players in the game.
     * @param setOfDices instance of a set of dices used in the game.
     * @param typeOfGame String that lets the user know what game what just started.
     */
    public static void runGame(int numPlayers, Dice setOfDices, String typeOfGame){
        System.out.println("\nYou have started a game on " + typeOfGame + " mode, with " + numPlayers + " human players and " + (numberOfPlayers - numPlayers) + " non-human players for a total of " + numberOfPlayers + " players:");
        System.out.println("\nThe are " + setOfDices.getNumberOfDices() + " dices for this game, each has " + setOfDices.getNumberOfSides() + " sides ");
        Game gameInstance = new Game(numPlayers, numberOfPlayers);
        gameInstance.setWinScore(winnerScore);
        
        boolean winnerFound = false;
        while (!winnerFound){
            gameInstance.setCurrentRound(gameInstance.getCurrentRound() + 1);
            System.out.println("\nRound " + gameInstance.getCurrentRound() + "  begin!\n");
            
            for (int index = 0; index < gameInstance.getNumberOfPlayers(); index++){
                gameInstance.player[index].roll(setOfDices);
            }
            
            gameInstance.processRoundScores(setOfDices);
            gameInstance.awardPointsToRoundWinner();
            gameInstance.printRoundResultsAndBoard();
            winnerFound = gameInstance.isThereAWinner();
            
            System.out.println("\npress Enter to proceed...\n");
            ENTER = input.nextLine();
        }
    }
    
    
    //FOR PairSixSidedDice CLASS
    
    /**
     * Method to initiate a game and run it, the process is all handle in the game object.
     * @param numPlayers total number of human players in the game.
     * @param setOfDices instance of a set of PairSixDicedDice used in the game.
     * @param typeOfGame String that lets the user know what game what just started.
     */
    public static void runGame(int numPlayers, PairSixSidedDice setOfDices, String typeOfGame){
        System.out.println("\nYou have started a game on " + typeOfGame + " mode, with " + numPlayers + " human players and " + (numberOfPlayers - numPlayers) + " non-human players for a total of " + numberOfPlayers + " players:");
        System.out.println("\nThe are " + setOfDices.getNumberOfDices() + " dices for this game, each has " + setOfDices.getNumberOfSides() + " sides ");
        Game gameInstance = new Game(numPlayers, numberOfPlayers);
        gameInstance.setWinScore(winnerScore);
        
        boolean winnerFound = false;
        while (!winnerFound){
            gameInstance.setCurrentRound(gameInstance.getCurrentRound() + 1);
            System.out.println("\nRound " + gameInstance.getCurrentRound() + "  begin!");
            
            for (int index = 0; index < gameInstance.getNumberOfPlayers(); index++){
                gameInstance.player[index].roll(setOfDices);
            }
            
            gameInstance.processRoundScores(setOfDices);
            gameInstance.awardPointsToRoundWinner();
            gameInstance.printRoundResultsAndBoard();
            winnerFound = gameInstance.isThereAWinner();
            
            
            System.out.println("\npress Enter to proceed...\n");
            ENTER = input.nextLine();
        }
    }
    
    /**
     * Method to collect the name of the human playing the game.
     * @param index position of the player that is asking for the game.
     * @return the name of the player.
     */
    public static String getPlayerName(int index){
        System.out.print("What's the player " + (index + 1) + " name: ");
        String playerName = input.nextLine();
        return playerName;
    }
}
