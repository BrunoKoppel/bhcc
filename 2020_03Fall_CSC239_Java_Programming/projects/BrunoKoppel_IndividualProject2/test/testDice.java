/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import individualproject2brunokoppel.Dice;

/**
 *
 * @author brunokoppel
 */
public class testDice {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int counter = 0;
        int numberOfDices = 5;
        int numberOfSides = 6;
        
        while(counter < 10){
            Dice testOne = new Dice(numberOfDices, numberOfSides);
            System.out.println("\nNumber of Dices: " + numberOfDices + " and Number of Sides: " + numberOfSides);
            System.out.println("Number of Dices: " + testOne.getNumberOfDices());
            System.out.println("Number of Sides: " + testOne.getNumberOfSides());
            int [] arr = testOne.roll();
            System.out.print("[");
            for (int i = 0; i < arr.length; i++){
                System.out.print(" " + arr[i]);
            }
            System.out.print("]");
            
            counter++;
        }

        int [] arr = {1,2,1,2,6};
        Dice testTwo = new Dice(numberOfDices, numberOfSides);
        testTwo.setTestValueCurrentRoll(arr);
        for (int i = 0; i < 5; i++){
            System.out.println(testTwo.currentRoll[i]);
        }
        
        System.out.println(testTwo.isRollStraight());
    }
}
