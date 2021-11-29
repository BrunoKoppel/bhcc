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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.RandomAccessFile;
import java.io.*;

import java.text.DecimalFormat;

public class ReadUserRecord extends Application{
    
    //create fields
    private TextField idField, nameField, wageField, avgHoursField, foodBudgetField, expensesField, ammountRentField, grossPayField, netPayField, budgetField;
    
	private ToggleGroup hourlyOptions;
	private HBox hourlyBox;
	
	private Spinner percentRentSpinner;
	
	//create buttons
	private RadioButton yesOption, noOption;
	
    private Button done, next;
    
    private RandomAccessFile inputFile;
    private UserRecord record;
	private User user;

    //override start()
    public void start(Stage primaryStage){
        
        record = new UserRecord();//create a new record
        
        //open a file
        try{
          
            inputFile = new RandomAccessFile("userRecord.dat", "rw"); //rw means read and write
            
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
		idField.setEditable(false);
		idField.setBackground(new Background(new BackgroundFill(Color.color(0.75,0.5,0,0.25), null, null)));
        pane.add(idField, 1, 0); //positions input field to the right of label
        
        pane.add(new Label("Name: "), 0, 1);
        nameField = new TextField();
		nameField.setEditable(false);
		nameField.setBackground(new Background(new BackgroundFill(Color.color(0.75,0.5,0,0.25), null, null)));
        pane.add(nameField, 1, 1);
        
        pane.add(new Label("Hourly Worker: "), 0, 2);
        
		hourlyOptions = new ToggleGroup(); //create a group for radio buttons
		
		yesOption = new RadioButton("Yes");
		yesOption.setToggleGroup(hourlyOptions);
		yesOption.setSelected(true);//sets default option to "yes"
		//yesOption.setDisabled(true);
        //pane.add(yesOption, 1, 2); //add yes button to group and add to scene
		
		noOption = new RadioButton("No");
		//noOption.setDisabled(true);
		noOption.setToggleGroup(hourlyOptions);
        //pane.add(noOption, 2, 2);//add no button to group and add to scene
		
		hourlyBox = new HBox(20.0, yesOption, noOption);
		pane.add(hourlyBox, 1, 2);//add radio buttons to the scene
        
        pane.add(new Label("Wage/Salary: "), 0, 3);
        wageField = new TextField();
		wageField.setEditable(false);
		wageField.setBackground(new Background(new BackgroundFill(Color.color(0,0.75,0,0.25), null, null)));
        pane.add(wageField, 1, 3);
        
        pane.add(new Label("Average Hours Worked Per Week: "), 0, 4);
        avgHoursField = new TextField();
		avgHoursField.setEditable(false);
		avgHoursField.setBackground(new Background(new BackgroundFill(Color.color(0.75,0.5,0,0.25), null, null)));
        pane.add(avgHoursField, 1, 4);
        
        pane.add(new Label("Rent (Percent of Income): "), 0, 5);
        percentRentSpinner = new Spinner(10.0, 50.0, 30.0, 5.0); //Spinner(double minValue, double maxValue, double startValue, double stepValue)
        //percentRentSpinner.setBackground(new Background(new BackgroundFill(Color.color(0.75,0.5,0,0.25), null, null)));
		//percentRentSpinner.setDisabled(true);
		pane.add(percentRentSpinner, 1, 5);
		
		pane.add(new Label("Rent (Monthly Budget): "), 0, 6);
        ammountRentField = new TextField();
		ammountRentField.setEditable(false);
		ammountRentField.setBackground(new Background(new BackgroundFill(Color.color(0.75,0,0,0.25), null, null)));
        pane.add(ammountRentField, 1, 6);
        
        pane.add(new Label("Food Budget: "), 0, 7);
        foodBudgetField = new TextField();
		foodBudgetField.setEditable(false);
		foodBudgetField.setBackground(new Background(new BackgroundFill(Color.color(0.75,0,0,0.25), null, null)));
        pane.add(foodBudgetField, 1, 7);
        
        pane.add(new Label("Other Expenses: "), 0, 8);
        expensesField = new TextField();
		expensesField.setEditable(false);
		expensesField.setBackground(new Background(new BackgroundFill(Color.color(0.75,0,0,0.25), null, null)));
        pane.add(expensesField, 1, 8);
		
        pane.add(new Label("Gross Income: "), 0, 9);
        grossPayField = new TextField();
		grossPayField.setEditable(false);
		grossPayField.setBackground(new Background(new BackgroundFill(Color.color(0,0.75,0,0.25), null, null)));
        pane.add(grossPayField, 1, 9);
		
        pane.add(new Label("Net Income: "), 0, 10);
        netPayField = new TextField();
		netPayField.setEditable(false);
		netPayField.setBackground(new Background(new BackgroundFill(Color.color(0,0.75,0,0.25), null, null)));
        pane.add(netPayField, 1, 10);
		
        pane.add(new Label("Income After Expenses and Taxes: "), 0, 11);
        budgetField = new TextField();
		budgetField.setEditable(false);
		budgetField.setBackground(new Background(new BackgroundFill(Color.color(0,0.75,0,0.25), null, null)));
        pane.add(budgetField, 1, 11);
        
        next = new Button("Next");
        next.setMaxWidth(Double.MAX_VALUE);
        NextButton handler1 = new NextButton();//create handler
        next.setOnAction(handler1); //register handler
        pane.add(next, 0, 12);
        GridPane.setHalignment(next, HPos.LEFT);
        
        done = new Button("Done");
        done.setMaxWidth(Double.MAX_VALUE);
        DoneButton handler2 = new DoneButton(); //create handler
        done.setOnAction(handler2);//register handler
        pane.add(done, 1, 12);
        GridPane.setHalignment(done, HPos.RIGHT);
        
        Scene scene = new Scene(pane);
    
        primaryStage.setTitle("Glen CIT-285 Final - Read Record");
        primaryStage.setWidth(400);
        primaryStage.setHeight(550);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }//end start
    
    
    void readRecord(){
		
        DecimalFormat twoDigits = new DecimalFormat( "0.00" );
        DecimalFormat dollars = new DecimalFormat( "$.00" );
        
        //create "stunt" variables
        int tempId = 0;
		String tempName;
		char tempHourly;
        double tempWage, tempAvgHours, tempPercentRent, tempFoodBudget, tempExpenses;
    
		try{
			do{
				record.read(inputFile);
				
				tempId = record.getId();
				tempName = record.getName();
				tempHourly = record.getHourly();
				tempWage = record.getWage();
				tempAvgHours = record.getAvgHours();
				tempPercentRent = record.getPercentRent();
				tempFoodBudget = record.getFoodBudget();
				tempExpenses = record.getExpenses();
				
				user = new User(tempId, tempName, tempHourly, tempWage, tempAvgHours, tempPercentRent, tempFoodBudget, tempExpenses);
			}while(record.getId() == 0);
			
			System.out.println(user.toString());
			
			idField.setText(String.valueOf(tempId));
			nameField.setText(String.valueOf(tempName));
			
			if (tempHourly == 'Y'){
				yesOption.setSelected(true);
			}else{
				noOption.setSelected(true);
			}
			
			wageField.setText(String.valueOf(dollars.format(tempWage)));
			avgHoursField.setText(String.valueOf(twoDigits.format(tempAvgHours)));
			percentRentSpinner.setValueFactory(new DoubleSpinnerValueFactory(10.0, 50.0, tempPercentRent, 5.0));
			ammountRentField.setText(String.valueOf(dollars.format(user.calc_rent(user.calc_net_pay(user.calc_gross_pay(tempHourly, tempWage, tempAvgHours)), tempPercentRent))));
			foodBudgetField.setText(String.valueOf(dollars.format(tempFoodBudget)));
			expensesField.setText(String.valueOf(dollars.format(tempExpenses)));
			grossPayField.setText(String.valueOf(dollars.format(user.calc_gross_pay(tempHourly, tempWage, tempAvgHours))));
			netPayField.setText(String.valueOf(dollars.format(user.calc_net_pay(user.calc_gross_pay(tempHourly, tempWage, tempAvgHours)))));
			budgetField.setText(String.valueOf(dollars.format(user.calc_budget(user.calc_net_pay(user.calc_gross_pay(tempHourly, tempWage, tempAvgHours)), tempPercentRent, tempFoodBudget, tempExpenses))));
			
		}catch(EOFException er){
            closeFile();
        
        }catch(IOException er){
            System.err.println( "Error during read from file: " + er.toString() );
            System.exit( 1 );
        }
		
    }//end readRecord
	
	void closeFile(){
        try{
            
            inputFile.close(); //close a file
            
        }catch(IOException er){
            
            System.err.println("File not closed properly: " + er.toString());
            System.exit(1);
        }
        
        System.exit(0);
    }//end closeFile
    
    class NextButton implements EventHandler<ActionEvent>{
        
        public void handle(ActionEvent e){
            
            readRecord();
        }
    }//end NextButton
    
    class DoneButton implements EventHandler<ActionEvent>{
        
        public void handle(ActionEvent e){
			
			closeFile();
        }
    }//end DoneButton


    public static void main(String[] args){
        
		launch(args);
    }

}//end WriteUserRecord











