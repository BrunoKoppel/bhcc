/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter9;

/**
 *
 * @author ecmil
 */
public class TestCar {
    public static void main(String[] args) {
        System.out.println("There are " + Car.getNumCars() + " cars.");
        Car car1 = new Car();
        System.out.println("There are " + Car.getNumCars() + " cars.");
        car1.printCar();
        car1.goForward();
        car1.goReverse();
        car1.stop();
        car1.goLeft();
        car1.goRight();
        Car car2 = new Car(2, "Mazda", "Miata", 1975);
       
        System.out.println("There are " + Car.getNumCars() + " cars.");
        car1.printCar();
    }
}
