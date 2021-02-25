/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter9;

/**
 *
 * @author brunokoppel
 */
public class Car {
    
    private int numPassangers;
    private String maker;
    private String model;
    private int year;
    private static int numCars = 0;
    private int carNumber = 0;
    
    Car(){
        setPassangers( 1 );
        setMaker( "Ghost" );
        setModel( "Busters" );
        setYear( 1999 );
        numCars++;
        setCarNumber(numCars);
        printCar();
    }
    Car(int numPas, String make, String model, int year){
        setPassangers( numPas );
        setMaker( make );
        setModel( model );
        setYear( year );
        numCars++;
        setCarNumber(numCars);
        printCar();
    }
    
    public void setPassangers(int newNumPassanger){
        numPassangers = newNumPassanger;
    } 
    public void setMaker(String newMaker){
        maker = newMaker;
    }
    public void setModel(String newModel){
        model = newModel;
    }
    public void setYear(int newYear){
        year = newYear;
    }
    
    public void setCarNumber(int numCars){
        carNumber = numCars;
    }
    
    public int getNumPassangers(){
        return numPassangers;
    }
    
    public int getCarNumber(){
        return carNumber;
    }
    
    public int getYear(){
        return year;
    }
    
    public static int getNumCars(){
        return numCars;
    }
    
    
    public String getMaker(){
        return maker;
    }
    
    public String getModel(){
        return model;
    }
    
    public void goForward(){
        System.out.println("Going Forward");
    }
    
    public void goReverse(){
        System.out.println("Going Backwards");
    }
    
    public void stop(){
        System.out.println("Stopping");
    }
    
    public void goLeft(){
        System.out.println("Going left");
    }
    
    public void goRight(){
        System.out.println("Going right");
    }
    
    public void printCar(){
        System.out.printf("Car #%d: \n\tMaker: %s\n\tModel: %s\n\tYear: %d\n\tPassanger: %d.\n\n",
                        getNumCars(), getMaker(), getModel(), getYear(), getNumPassangers());
    }
    
    public void printCarExtra(){
        System.out.printf("Car #%d of #%d: \n\tMaker: %s\n\tModel: %s\n\tYear: %d\n\tPassanger: %d.\n\n",
                        getCarNumber(), getNumCars(), getMaker(), getModel(), getYear(), getNumPassangers());
    }
}
