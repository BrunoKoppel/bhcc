/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Line;

/**
 *
 * @author brunokoppel
 */
public class Line {
    int amountOfLines = 0;
    
    private int lineID;
    private void setLineID(int value){
        lineID = value;
    }
    public int getLineID(){
        return lineID;
    }

    private double width = 0;
    private String color = "none";

    private double firstPointXValue = 0;
    private double firstPointYValue = 0;
    private double secondPointXValue = 0;
    private double secondPointYValue = 0;

    public Line(){
        setLineID(amountOfLines);
        System.out.println("Line " + getLineID() + " created");
        getLineCoordinates(getLineID());
        amountOfLines++;
    }   
    public Line(double firstPointXValue, double firstPointYValue, double secondPointXValue, double secondPointYValue){
        setLineID(amountOfLines);
        System.out.println("Line " + getLineID() + " created");
        setFirstPointXValue(firstPointXValue);
        setFirstPointYValue(firstPointYValue);
        setSecondPointXValue(secondPointXValue);
        setSecondPointYValue(secondPointYValue);
        getLineCoordinates(getLineID());
        amountOfLines++;
    }

    public void getLineCoordinates(int lineID){
        System.out.println("\tX value is at " + getFirstPointXValue() + " and " + getFirstPointYValue() );
        System.out.println("\tY value is at " + getSecondPointXValue() + " and " + getSecondPointYValue() );
    }

    private void setFirstPointXValue( double value ){
        firstPointXValue = value;
    }
    private void setFirstPointYValue( double value ){
        firstPointYValue = value;
    }
    private void setSecondPointXValue( double value ){
        secondPointXValue = value;
    }
    private void setSecondPointYValue( double value ){
        secondPointYValue = value;
    }

    private double getFirstPointXValue(){
        return firstPointXValue;
    }
    private double getFirstPointYValue(){
        return firstPointYValue;
    }
    private double getSecondPointXValue(){
        return secondPointXValue;
    }
    private double getSecondPointYValue(){
        return secondPointYValue;
    }
    
    public static void main(String[] args){
    Line zero = new Line(1.0,2.0,3.0,4.0);
    Line one = new Line(1.0,2.0,3.0,4.0);

    }
    
}
