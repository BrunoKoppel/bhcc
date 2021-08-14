/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import individualproject2brunokoppel.Player;
/**
 *
 * @author brunokoppel
 */
public class testPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Player npc = new Player(true);
        Player playerOne = new Player(false);
        Player playerTwo = new Player(false);
        Player bruno = new Player("Bruno", true);
        System.out.println(npc.toString());
        System.out.println(playerOne.toString());
        System.out.println(playerTwo.toString());
        System.out.println(bruno.toString());
    }
}
