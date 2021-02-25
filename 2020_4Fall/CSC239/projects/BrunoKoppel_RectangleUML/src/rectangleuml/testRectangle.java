/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleuml;

/**
 *
 * @author brunokoppel
 */
public class testRectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(2.0, 3.0);
        r2.printInformation();
        r1.printInformation();
        
        Rectangle[] groupOfRectangles = new Rectangle[5];
        
        for (int i = 0; i < 5; i++){
            groupOfRectangles[i] = new Rectangle( i + 1.0 , i + 3.0);
        }
        
        for (int i = 4; i >= 0; i--){
            groupOfRectangles[i].printInformation();
        }
        
        Rectangle r8 = new Rectangle();
        Rectangle r9 = new Rectangle(5.0, 1.0);
        r9.printInformation();
        r8.printInformation();
    }
}
