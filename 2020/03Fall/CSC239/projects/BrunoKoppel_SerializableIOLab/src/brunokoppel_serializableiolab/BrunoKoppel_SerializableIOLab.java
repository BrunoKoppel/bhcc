/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_serializableiolab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author brunokoppel
 */
public class BrunoKoppel_SerializableIOLab {

  /**
   * @param args the command line arguments 
   */
  public static void main(String[] args) throws ClassNotFoundException, IOException {
    Person one = new Person("Flintstone" ,"Fred" ,200 , 98.6);
    Person two = new Person("Rubble" ,"Barney" ,150 , 95.5);
    
    try ( 
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("objectOutput.dat", true)
          );
        ){
      output.writeObject(one);
      output.writeObject(two);
    } catch (IOException ex){
      System.out.println("@1 " + ex);
    }
    
    try (
        ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("objectOutput.dat"));
            ){
      Person fred = (Person)(input.readObject());
      Person barney = (Person)(input.readObject());
      System.out.println(fred.toString());
      System.out.println(barney.toString());
      
    } catch (Exception ex){
      System.out.println("@2 " + ex);
    }
  }
}
