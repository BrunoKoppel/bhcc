//Glen CIT-285 Final Project

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;

import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.RandomAccessFile;
import java.io.*;

public class WriteUserRecord extends Application{
    
    //create fields
    private TextField idField, nameField, wageField, avgHoursField, foodBudgetField, expensesField;
    
	private ToggleGroup hourlyOptions;
	private HBox hourlyBox;
	
	private Spinner percentRentSpinner;
	
	//create buttons
	private RadioButton yesOption, noOption;
	
    private Button done, next;
    
    private RandomAccessFile outputFile;
    private UserRecord record;

    //override start()
    public void start(Stage primaryStage){
        
        record = new UserRecord();//create a new record
        
        //open a file
        try{
          
            outputFile = new RandomAccessFile("userRecord.dat", "rw"); //rw means read and write
            
        }catch(IOException er){
            System.err.println("error opening file: " + er.toString());
            System.exit(1);
        }
        
        
        //create a pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        
        pane.setHgap(5);//set horizontal spacing
        pane.setVgap(10);//set vertical spacing
        
        //set border padding
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        //create form
        pane.add(new Label("Id: "), 0, 0); //over, down
        idField = new TextField();
        pane.add(idField, 1, 0); //positions input field to the right of label
        
        pane.add(new Label("Name: "), 0, 1);
        nameField = new TextField();
        pane.add(nameField, 1, 1);
        
        pane.add(new Label("Hourly Worker: "), 0, 2);
        
		hourlyOptions = new ToggleGroup(); //create a group for radio buttons
		
		yesOption = new RadioButton("Yes");
		yesOption.setToggleGroup(hourlyOptions);
		yesOption.setSelected(true);//sets default option to "yes"
        //pane.add(yesOption, 1, 2); //add yes button to group and add to scene
		
		noOption = new RadioButton("No");
		noOption.setToggleGroup(hourlyOptions);
        //pane.add(noOption, 2, 2);//add no button to group and add to scene
		
		hourlyBox = new HBox(20.0, yesOption, noOption);
		pane.add(hourlyBox, 1, 2);//add radio buttons to the scene
        
        pane.add(new Label("Wage/Salary: "), 0, 3);
        wageField = new TextField();
        pane.add(wageField, 1, 3);
        
        pane.add(new Label("Average Hours Worked Per Week: "), 0, 4);
        avgHoursField = new TextField();
        pane.add(avgHoursField, 1, 4);
        
        pane.add(new Label("Rent (Percent of Income): "), 0, 5);
        percentRentSpinner = new Spinner(10.0, 50.0, 30.0, 5.0); //Spinner(double minValue, double maxValue, double startValue, double stepValue)
        pane.add(percentRentSpinner, 1, 5);
        
        pane.add(new Label("Food Budget: "), 0, 6);
        foodBudgetField = new TextField();
        pane.add(foodBudgetField, 1, 6);
        
        pane.add(new Label("Other Expenses: "), 0, 7);
        expensesField = new TextField();
        pane.add(expensesField, 1, 7);
        
        next = new Button("Next");
        next.setMaxWidth(Double.MAX_VALUE);
        NextButton handler1 = new NextButton();//create handler
        next.setOnAction(handler1); //register handler
        pane.add(next, 0, 8);
        GridPane.setHalignment(next, HPos.LEFT);
        
        done = new Button("Done");
        done.setMaxWidth(Double.MAX_VALUE);
        DoneButton handler2 = new DoneButton(); //create handler
        done.setOnAction(handler2);//register handler
        pane.add(done, 1, 8);
        GridPane.setHalignment(done, HPos.RIGHT);
        
        Scene scene = new Scene(pane);
    
        primaryStage.setTitle("Glen CIT-285 Final - Write Record");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }//end start
    
    
    void addRecord(){
        
        //create "stunt" variables
        int tempId = 0;
		char tempHourly;
        double tempWage, tempAvgHours, tempPercentRent, tempFoodBudget, tempExpenses;
    
        if(!idField.getText().equals("")){//user must input an id
        
            try{
                tempId = Integer.parseInt(idField.getText());
                if(tempId >= 1){
                    record.setId(tempId); //set user id
                }
                
            }catch(NumberFormatException nfe){
                
                System.err.println("Id number must be entered as an Integer");
            }
            
            record.setName(nameField.getText());//set user name         
            
			if (hourlyOptions.getSelectedToggle() == yesOption){
				tempHourly = 'Y';
			} else {
				tempHourly = 'N';
			}
			record.setHourly(tempHourly);// set user hourly status
            
            try{
                tempWage = new Double(wageField.getText());
                record.setWage(tempWage);//set wage/salary
                
            }catch(NumberFormatException nfe){
                System.err.println("Number must be entered as Double");
            }
            
            try{
                tempAvgHours = new Double(avgHoursField.getText());
                record.setAvgHours(tempAvgHours);// set average hours
            
            }catch(NumberFormatException nfe){
                System.err.println("Number must be entered as a Double");
            }
            
			tempPercentRent = new Double(percentRentSpinner.getValue().toString());
			
			record.setPercentRent(tempPercentRent);//set rent percentage
			
            try{
                tempFoodBudget = new Double(foodBudgetField.getText());
                record.setFoodBudget(tempFoodBudget);// set food budget
                
            }catch(NumberFormatException nfe){
                System.err.println("Number must be entered as a Double");
            }
            
            
            try{
                tempExpenses = new Double(expensesField.getText());
                record.setExpenses(tempExpenses);// set expenses 
                
            }catch(NumberFormatException nfe){
                System.err.println("Number must be entered as a Double");
            }
            
            //write information to a file
            try{
                outputFile.seek((long)(tempId-1) * record.size());//set pointer
                record.write(outputFile);
                
            }catch(IOException er){
                System.err.println("Error during write to a file: " + er.toString());
                System.exit(1);
            }
            
        }//end if statement
        
        //reset fields
        idField.setText("");
        nameField.setText("");
        yesOption.setSelected(true);
        wageField.setText("");
        avgHoursField.setText("");
        percentRentSpinner.setValueFactory(new DoubleSpinnerValueFactory(10.0, 50.0, 30.0, 5.0));
        foodBudgetField.setText("");
        expensesField.setText("");
    
    }//end addRecord
    
    class NextButton implements EventHandler<ActionEvent>{
        
        public void handle(ActionEvent e){
            
            addRecord();
        }
    }//end NextButton
    
    class DoneButton implements EventHandler<ActionEvent>{
        
        public void handle(ActionEvent e){
            try{
                
                outputFile.close(); //close a file
                
            }catch(IOException er){
                
                System.err.println("File not closed properly: " + er.toString());
                System.exit(1);
            }
            
            System.exit(0);
        }
    }//end DoneButton


    public static void main(String[] args){
        launch(args);
    }

}//end WriteUserRecord











