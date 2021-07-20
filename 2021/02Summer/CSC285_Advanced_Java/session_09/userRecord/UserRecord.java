//Glen CIT-285 Final Project

import java.io.*;
import java.io.RandomAccessFile;

public class UserRecord{

    //create variables
	private int id;
	
	private String name;
	
	private char hourly;
	
	private double wage;
	private double avgHours;
	private double percentRent;
	private double foodBudget;
	private double expenses;
    
    //default constructor
    public UserRecord(){
		
		id = 0;
        name = "";
        hourly = ' ';
        wage = 0.0;
        avgHours = 0.0;
        percentRent = 0.0;
        foodBudget = 0.0;
        expenses = 0.0;
		
    }
    
    //write to a file
    public void write(RandomAccessFile file) throws IOException{
        
		//catch arguments
		RandomAccessFile tempFile = file;
		
		//write to the file
        tempFile.writeInt(id);// 4 bytes
        
        StringBuffer buffer; //using string buffer beacuse it is multithreaded 
        if(name != null){
            buffer = new StringBuffer(name);
        }else{
            buffer = new StringBuffer(12);
        }
        buffer.setLength(12); //using a set length so the byte size is known
        tempFile.writeChars(buffer.toString()); //write string as sequense of characters (12*2 = 24 bytes)
        
        tempFile.writeChar(hourly);// 2 bytes
		
        tempFile.writeDouble(wage);// 8 bytes
        tempFile.writeDouble(avgHours);// 8 bytes
        tempFile.writeDouble(percentRent);// 8 bytes
		tempFile.writeDouble(foodBudget);// 8 bytes
		tempFile.writeDouble(expenses);// 8 bytes
    }//end write (4 + 24 + 2 + 8 + 8 + 8 + 8 + 8) = 70 bytes
    
    //read from a file
    public void read(RandomAccessFile file) throws IOException{
		
		//catch arguments
		RandomAccessFile tempFile = file;
	
        id = tempFile.readInt();
        
        char[] charArray = new char[12];
        for(int i=0; i < charArray.length; i++){
            charArray[i] = tempFile.readChar();
        }
        name = new String(charArray); //retrieves and writes to string next 12 chars from file
        
        hourly = tempFile.readChar();
		
        wage = tempFile.readDouble();
        avgHours = tempFile.readDouble();
        percentRent = tempFile.readDouble();
        foodBudget = tempFile.readDouble();
        expenses = tempFile.readDouble();
    }//end read
    
    //getters and setters
    public int getId(){
        
        return this.id;
    }
	
	public void setId(int id){
        
        this.id = id;
    }
    
    public String getName(){
        
        return this.name;
    }
	
	public void setName(String name){
        
        this.name = name;
    }

    public char getHourly(){
        
        return this.hourly;
    }
	
	public void setHourly(char hourly){
        
        this.hourly = hourly;
    }

    public double getWage(){
        
        return this.wage;
    }
	
	public void setWage(double wage){
        
        this.wage = wage;
    }
	
    public double getAvgHours(){
        
        return this.avgHours;
    }
	
	public void setAvgHours(double avgHours){
        
        this.avgHours = avgHours;
    }
	
	public double getPercentRent(){
        
        return this.percentRent;
    }
	
	public void setPercentRent(double percentRent){
        
        this.percentRent = percentRent;
    }
	
    public double getFoodBudget(){
        
        return this.foodBudget;
    }
	
	public void setFoodBudget(double foodBudget){
        
        this.foodBudget = foodBudget;
    }

    public double getExpenses(){
        
        return this.expenses;
    }
	
	public void setExpenses(double expenses){
        
        this.expenses = expenses;
    }

    //returns size in bytes of record
    public static int size(){
    
        return 70; //(4 + 24 + 2 + 8 + 8 + 8 + 8 + 8) = 70 bytes
    }
    
    
}


























