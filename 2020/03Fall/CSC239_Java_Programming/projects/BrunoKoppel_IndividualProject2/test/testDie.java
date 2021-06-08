/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import individualproject2brunokoppel.Die;

/**
 *
 * @author brunokoppel
 */
public class testDie {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Die one = new Die(4);
        System.out.println("1: " + one.toString()); 
        Die two = new Die(5);
        System.out.println("2: " + two.toString()); 
        Die the = new Die(6);
        System.out.println("3: " + the.toString()); 
        Die fou = new Die(7);
        System.out.println("4: " + fou.toString()); 
        Die fiv = new Die(8);
        System.out.println("5: " + fiv.toString()); 
        Die six = new Die(9);
        System.out.println("6: " + six.toString()); 
        Die sev = new Die(10);
        System.out.println("7: " + sev.toString()); 
        Die eig = new Die(12);
        System.out.println("8: " + eig.toString()); 
        Die nin = new Die(13);
        System.out.println("9: " + nin.toString()); 
        Die ten = new Die(14);
        System.out.println("10: " + ten.toString()); 
    }
}
