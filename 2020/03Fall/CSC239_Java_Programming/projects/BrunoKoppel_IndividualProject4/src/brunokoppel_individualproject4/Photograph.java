/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_individualproject4;

/**
 * Interface that holds the static interaction across all Explorer objects.
 * @author brunokoppel
 */
public interface Photograph {
  /**
   * Method that prints out the result of recording a sighting by a explorer on a living thing.
   * @param lt living thing object.
   * @return String with the print out of the event.
   */
  public abstract String recordSighting(LivingThing lt);
}
