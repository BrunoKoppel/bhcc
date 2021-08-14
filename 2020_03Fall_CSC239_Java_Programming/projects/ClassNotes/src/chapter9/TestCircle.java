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
public class TestCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Circle one = new Circle();
        System.out.println("1");
        System.out.println("The area of circle1 is " + one.getArea());
        System.out.println("The radius of circle1 is " + one.getRadius());
        System.out.println("The perimeter of circle1 is " + one.getPerimeter());
        one.setRadius(-5.);
        System.out.println("2");
        System.out.println("The area of circle1 is " + one.getArea());
        System.out.println("The radius of circle1 is " + one.getRadius());
        System.out.println("The perimeter of circle1 is " + one.getPerimeter());
        one.setRadius(5.);
        System.out.println("3");
        System.out.println("The area of circle1 is " + one.getArea());
        System.out.println("The radius of circle1 is " + one.getRadius());
        System.out.println("The perimeter of circle1 is " + one.getPerimeter());
        Circle two = new Circle(10.);
        System.out.println("4");
        System.out.println("The area of circle1 is " + two.getArea());
        System.out.println("The radius of circle1 is " + two.getRadius());
        System.out.println("The perimeter of circle1 is " + two.getPerimeter());
    }
}
