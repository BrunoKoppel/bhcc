/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import individualproject2brunokoppel.Game;
/**
 *
 * @author brunokoppel
 */
public class testGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Game simulation = new Game();
        System.out.println("1: " + simulation.toString());
        simulation = new Game(4,1);
        System.out.println("2: " + simulation.toString()); 
        simulation = new Game(4,2);
        System.out.println("3: " + simulation.toString()); 
        simulation = new Game(4,3);
        System.out.println("4: " + simulation.toString()); 
        simulation = new Game(4,4);
        System.out.println("5: " + simulation.toString()); 
    }
}
