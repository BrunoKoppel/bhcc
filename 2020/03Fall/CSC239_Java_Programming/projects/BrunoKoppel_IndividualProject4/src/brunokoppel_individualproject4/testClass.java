/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;

/**
 * Test Class
 * @author brunokoppel
 */
public class testClass {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Air dragon = new Air("Dragon",true ,"Cave mountains" ,false);
    Air bird = new Air("Bird",true ,"Trees" ,true);
    Air butterfly = new Air("Butterfly",true ,"Flowers" ,false);
    Air pterodactyl = new Air("Pterodactyl",true ,"Cave mountains" ,false);
    
    Land lizard = new Land("Lizard",true , "desert", 20);
    Land cat = new Land("Cat",true , "forests or human houses", 40);
    Land human = new Land("Human",true , "earth's land, with plenty of food and water", 170);
    Land tree = new Land("Tree",false , "desert", 500);
    
    Sea whale = new Sea("Whale",true , "white", 2000);
    Sea fish = new Sea("Fish",true , "yellow and blue", 20);
    Sea shark = new Sea("Shark",true , "gray", 500);
    Sea coral = new Sea("Coral",false , "red, green, yellow, and many other", 2000);
    
    Hiker kat = new Hiker("Kat", 500);
    Diver tai = new Diver("Tai", 100);
    
    // Kat's sightings of all the animals above.
    System.out.println(kat.recordSighting(dragon));
    System.out.println(kat.recordSighting(bird));
    System.out.println(kat.recordSighting(butterfly));
    System.out.println(kat.recordSighting(pterodactyl));
    
    System.out.println(kat.recordSighting(lizard));
    System.out.println(kat.recordSighting(cat));
    System.out.println(kat.recordSighting(human));
    System.out.println(kat.recordSighting(tree));
    
    System.out.println(kat.recordSighting(whale));
    System.out.println(kat.recordSighting(fish));
    System.out.println(kat.recordSighting(shark));
    System.out.println(kat.recordSighting(coral));
    
    // Tai's sightings of all the animals above.
    System.out.println(tai.recordSighting(dragon));
    System.out.println(tai.recordSighting(bird));
    System.out.println(tai.recordSighting(butterfly));
    System.out.println(tai.recordSighting(pterodactyl));
    
    System.out.println(tai.recordSighting(lizard));
    System.out.println(tai.recordSighting(cat));
    System.out.println(tai.recordSighting(human));
    System.out.println(tai.recordSighting(tree));
    
    System.out.println(tai.recordSighting(whale));
    System.out.println(tai.recordSighting(fish));
    System.out.println(tai.recordSighting(shark));
    System.out.println(tai.recordSighting(coral));
  }
}
