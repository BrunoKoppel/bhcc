/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppeljavafxlayout;

import javafx.application.Application;
import static javafx.geometry.HPos.CENTER;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author brunokoppel
 */
public class BrunoKoppelJavaFXLayout extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setGridLinesVisible​(false);
        
        Label labName = new Label("Java FX Lab");
        GridPane.setHalignment(labName, CENTER);
        
        Label bkoName = new Label("Bruno Koppel");
        GridPane.setHalignment(bkoName, CENTER);
        
        Circle circleOne = new Circle(50.0,50.0,25.0);
        circleOne.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        circleOne.setStrokeWidth(2.0);
        circleOne.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(circleOne, CENTER);
        
        Circle circleTwo = new Circle(50.0,50.0,25.0);
        circleTwo.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        circleTwo.setStrokeWidth(2.0);
        circleTwo.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(circleTwo, CENTER);
        
        Circle circleThree = new Circle(50.0,50.0,25.0);
        circleThree.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        circleThree.setStrokeWidth(2.0);
        circleThree.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(circleThree, CENTER);
        
        Polygon squareOne = new Polygon(0.0, 0.0, 50.0, 0.0, 50.0, 50.0, 0.0, 50.0);
        squareOne.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        squareOne.setStrokeWidth(2.0);
        squareOne.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(squareOne, CENTER);
        
        Polygon squareTwo = new Polygon(0.0, 0.0, 50.0, 0.0, 50.0, 50.0, 0.0, 50.0);
        squareTwo.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        squareTwo.setStrokeWidth(2.0);
        squareTwo.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(squareTwo, CENTER);
        
        Polygon squareThree = new Polygon(0.0, 0.0, 50.0, 0.0, 50.0, 50.0, 0.0, 50.0);
        squareThree.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        squareThree.setStrokeWidth(2.0);
        squareThree.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(squareThree, CENTER);
        
        
        Ellipse ellipseOne = new Ellipse(50.0, 50.0, 25.0, 40.0);
        ellipseOne.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        ellipseOne.setStrokeWidth(2.0);
        ellipseOne.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(ellipseOne, CENTER);
        
        Ellipse ellipseTwo = new Ellipse(50.0, 50.0, 25.0, 40.0);
        ellipseTwo.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        ellipseTwo.setStrokeWidth(2.0);
        ellipseTwo.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(ellipseTwo, CENTER);
        
        Ellipse ellipseThree = new Ellipse(50.0, 50.0, 25.0, 40.0);
        ellipseThree.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        ellipseThree.setStrokeWidth(2.0);
        ellipseThree.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(ellipseThree, CENTER);
        
        Ellipse ellipseFour = new Ellipse(50.0, 50.0, 25, 40.0);
        ellipseFour.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        ellipseFour.setStrokeWidth(2.0);
        ellipseFour.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(ellipseFour, CENTER);
        
        Ellipse ellipseFive = new Ellipse(50.0, 50.0, 25.0, 40.0);
        ellipseFive.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        ellipseFive.setStrokeWidth(2.0);
        ellipseFive.setStroke(Color.color(0,0,0));
        GridPane.setHalignment(ellipseFive, CENTER);
        
        
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));
        
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(100));
        
        root.add(labName, 2, 0);
        root.add(bkoName, 2, 2);
        
        root.add(circleOne, 0, 1);
        root.add(circleTwo, 0, 2);
        root.add(circleThree, 0, 3);
        
        root.add(squareOne, 4, 1);
        root.add(squareTwo, 4, 2);
        root.add(squareThree, 4, 3);
        
        root.add(ellipseOne, 0, 4);
        root.add(ellipseTwo, 1, 4);
        root.add(ellipseThree, 2, 4);
        root.add(ellipseFour, 3, 4);
        root.add(ellipseFive, 4, 4);
        
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Java FX Lab By Bruno Koppel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void setRandomColor(Shape object){
        object.setFill(Color.color(Math.random(), Math.random(), Math.random()));
    }
    
}
