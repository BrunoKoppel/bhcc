/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_serializableiolab;

/**
 *
 * @author brunokoppel
 */

public class Person implements java.io.Serializable  {
  private String lastName;
  private String firstName;
  private int age;
  private double score;
  
  Person(){
    setLastName("");
    setFirstName("");
    setAge(0);
    setScore(0);
  }
  
  Person(Person newPerson){
    setLastName(newPerson.getLastName());
    setFirstName(newPerson.getFirstName());
    setAge(newPerson.getAge());
    setScore(newPerson.getScore());
  }
  
  Person(String newLastName, String newFirstName, int newAge, double newScore){
    setLastName(newLastName);
    setFirstName(newFirstName);
    setAge(newAge);
    setScore(newScore);
  }
  
  public void setLastName(String newLastName){
    this.lastName = newLastName;
  }
  
  public void setFirstName(String newFirstName){
    this.firstName = newFirstName; 
  }
  
  public void setAge(int newAge){
    this.age = newAge;
  }
  
  public void setScore(double newScore){
    this.score = newScore; 
  }
  
  public String getLastName(){
    return this.lastName; 
  }
  
  public String getFirstName(){
    return this.firstName; 
  }
  
  public int getAge(){
    return this.age; 
  }
  
  public double getScore(){
    return this.score; 
  }
  
  public String toString(){
    return (getFirstName() + " " + getLastName() + " is " + getAge() + 
            "years old and and has a score of " + getScore());
  }
}
