
package Chapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * testClass to test the chapter Class created on the Chapter Package.
 * @author brunokoppel
 */
public class testChapter {

    /**
     * Generating a few Chapters using the Class just created
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Chapter intro = new Chapter("Introduction to Learning", 5);
        Chapter one = new Chapter("Learning online from home", 14);
        Chapter two = new Chapter("What online learning is good at", 19);
        Chapter third = new Chapter("What online learning is missing", 15);
        Chapter four = new Chapter("Strategies to make the most", 14);
    }
}
