/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_measurementconverter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author brunokoppel
 */
public class BrunoKoppel_MeasurementConverter extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label feetLabel = new Label("Feet");
        TextField feetField = new TextField ();
        feetField.setMaxWidth(50.0);
        Label inchesLabel = new Label("Inches");
        TextField inchesField = new TextField ();
        inchesField.setMaxWidth(50.0);
        HBox imperialHb = new HBox(10.0);
        imperialHb.getChildren().addAll(feetLabel, feetField, inchesLabel, inchesField);
        imperialHb.setSpacing(10);
        
        
        Label metersLabel = new Label("Meters");
        TextField metersField = new TextField ();
        metersField.setMaxWidth(70.0);
        HBox metersHb = new HBox(10.0);
        metersHb.getChildren().addAll(metersLabel, metersField);
        metersHb.setSpacing(10);
        
        
        Button convertBtn = new Button();
        convertBtn.setText("Convert");
        convertBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!metersField.getText().equals("")){
                    double meters = Double.parseDouble(metersField.getText());
                    double feet = (int)convertMetersToFeet(meters);
                    double inches = convertFeetToInches(convertMetersToFeet(meters)-feet);
                    metersField.setText("");
                    
                    feetField.setText(String.valueOf(feet));
                    inchesField.setText(String.valueOf(inches));
                    
                } else if (!feetField.getText().equals("")) {
                    double feet = Double.parseDouble(feetField.getText());
                    double meters = convertFeetToMeters(feet);
                    feetField.setText("");
                    
                    if (!inchesField.getText().equals("")){
                        double inches = Double.parseDouble(inchesField.getText());
                        meters += convertInchesToMeters(inches);
                        inchesField.setText("");
                    }
                    metersField.setText(String.valueOf(meters));
                    
                } else if (!inchesField.getText().equals("")) {
                    double inches = Double.parseDouble(inchesField.getText());
                    inchesField.setText("");
                    if (inches > 12){
                        double feet = (int)convertInchesToFeet(inches);
                        inches = inches - convertFeetToInches(feet);
                        feetField.setText(String.valueOf(feet));
                        inchesField.setText(String.valueOf(inches));
                    } else {
                        double meters = convertInchesToMeters(inches);
                        metersField.setText(String.valueOf(meters));
                    }
                }
            }
        });
        
        GridPane root = new GridPane();
        
        root.getColumnConstraints().add(new ColumnConstraints(300));
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));
        
        root.getRowConstraints().add(new RowConstraints(50));
        
        root.add(imperialHb, 0, 0);
        
        root.add(convertBtn, 1, 0);
        
        root.add(metersHb, 2, 0);
        
        Scene scene = new Scene(root, 550, 50);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static double convertMetersToFeet(double meters){
        return (meters * (3.28));
    }
    
    public static double convertFeetToInches(double feet){
        return feet * 12;
    }
    
    public static double convertInchesToFeet(double inches){
        return inches / 12;
    }
    
    public static double convertInchesToMeters(double inches){
        return inches * 0.0254;
    }
    
    public static double convertFeetToMeters(double feet){
        return feet * 0.3048;
    }
}
