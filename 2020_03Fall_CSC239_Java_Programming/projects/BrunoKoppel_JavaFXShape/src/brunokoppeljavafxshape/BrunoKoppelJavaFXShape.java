/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppeljavafxshape;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.*;



/**
 *
 * @author brunokoppel
 */
public class BrunoKoppelJavaFXShape extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Polygon poly = new Polygon();
        poly.getPoints().addAll(new Double[]{
            0.0, 0.0,
            50.0, 200.0,
            350.0, 200.0,
            300.0, 0.0,
        });
        poly.setStroke(Color.GREEN);
        poly.setFill(Color.LIGHTGREEN);
        
        Text name = new Text(30.0, 100.0, "BRUNO KOPPEL");
        name.setTextAlignment(TextAlignment.JUSTIFY);
        name.setFont(new Font(20));
        name.setY(20.0);
        
        
        StackPane root = new StackPane();
        GridPane grid = new GridPane();
        StackPane rootPane = new StackPane();
        grid.getChildren().add(name);
        root.getChildren().add(poly);
        rootPane.getChildren().addAll(grid,root);
        Scene scene = new Scene(rootPane, 500, 500);
        
        primaryStage.setTitle("BRUNO KOPPEL");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
