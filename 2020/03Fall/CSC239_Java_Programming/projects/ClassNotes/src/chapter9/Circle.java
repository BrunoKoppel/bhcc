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
public class Circle {
    private double radius;
    
    public Circle(){
        setRadius(0);
    }
    
    public Circle(double radius){
        setRadius(radius);
    }
    
    public void setRadius (double radius){
        if (radius < 0){
            radius = 0;
        }
        this.radius = radius;
    }
    
    public double getRadius () { return radius; }
    
    public double getArea() { return radius * radius * Math.PI; }
    
    public double getPerimeter() { return 2. * radius * Math.PI; }
}