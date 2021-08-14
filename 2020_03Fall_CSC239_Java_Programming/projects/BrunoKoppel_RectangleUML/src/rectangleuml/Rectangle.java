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
public class Rectangle {
    
    public int figureNumber;
    private double width;
    private double height;
    private double area;
    private double perimeter;
    public static int numberOfFigures;
    
    Rectangle(){
       numberOfFigures++;
       figureNumber = numberOfFigures;
       setHeight(0.0);
       setWidth(0.0);
       setArea();
       setPerimeter();
    }
    
    Rectangle(double height, double width){
       numberOfFigures++;
       figureNumber = numberOfFigures;
       setHeight(height);
       setWidth(width);
       setArea();
       setPerimeter();
    }
    
    
    
    private void setWidth(double value){
        width = value;
    }
    
    private void setHeight(double value){
        height = value;
    }
    
    private void setArea(){
        area = getWidth() * getHeight();
    }
    
    private void setPerimeter(){
        perimeter = 2 * (getWidth() + getHeight());
    }
    
    private double getWidth(){
        return width;
    }
    
    private double getHeight(){
        return height;
    }
    
    private double getArea(){
        return area;
    }
    
    private double getPerimeter(){
        return perimeter;
    }
    
    public void printInformation(){
        System.out.printf("\nRectangle #%d of %d figures:\n\tHeight: %.2f\n\tWidth: %.2f\n\tArea: %.2f\n\tPerimeter: %.2f\n", figureNumber, numberOfFigures, getHeight(), getWidth(), getArea(), getPerimeter());
    }
}
