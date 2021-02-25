/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brunokoppel_javafxshapehw;

import javafx.application.Application;
import static javafx.geometry.HPos.CENTER;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author brunokoppel
 */
public class BrunoKoppel_JavaFXShapeHw extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        
        root.getRowConstraints().add(new RowConstraints(150));
        root.getRowConstraints().add(new RowConstraints(150));
        root.getRowConstraints().add(new RowConstraints(150));
        
        root.getColumnConstraints().add(new ColumnConstraints(300));
        
        StackPane holder = new StackPane();
        Canvas canvas = new Canvas(300,  450);

        holder.getChildren().add(canvas);
        holder.setStyle("-fx-background-color: LightGray");
        holder.getChildren().add(root);
        
        Scene scene = new Scene(holder, 300, 450);
        
        // Rectangle
        Color shapeFill1 = new Color(getRandomNumeber(), getRandomNumeber(), getRandomNumeber(), 0.3);
        Color shapeStroke1 = shapeFill1.deriveColor(1.0, 1.0, 1.0, 1.0);
        
        Polygon rectangle = new Polygon(0.0, 0.0, 80.0, 0.0, 80.0, 50.0, 0.0, 50.0);
        rectangle.setFill(shapeFill1);
        rectangle.setStrokeWidth(5.0);
        rectangle.setStroke(shapeStroke1);
        GridPane.setHalignment(rectangle, CENTER);
        
        // Circle
        Color shapeFill2 = new Color(getRandomNumeber(), getRandomNumeber(), getRandomNumeber(), 0.3);
        Color shapeStroke2 = shapeFill2.deriveColor(1.0, 1.0, 1.0, 1.0);
        
        Circle circle = new Circle(50.0,50.0,25.0);
        circle.setFill(shapeFill2);
        circle.setStrokeWidth(5.0);
        circle.setStroke(shapeStroke2);
        GridPane.setHalignment(circle, CENTER);
        
        // Triangle
        Color shapeFill3 = new Color(getRandomNumeber(), getRandomNumeber(), getRandomNumeber(), 0.3);
        Color shapeStroke3 = shapeFill3.deriveColor(1.0, 1.0, 1.0, 1.0);
        
        Polygon triangle = new Polygon(0.0, 0.0, 80.0, 0.0, 50.0, 50.0);
        triangle.setFill(shapeFill3);
        triangle.setStrokeWidth(5.0);
        triangle.setStroke(shapeStroke3);
        GridPane.setHalignment(triangle, CENTER);
        
        
        root.add(rectangle, 0, 0);
        root.add(circle, 0, 1);
        root.add(triangle, 0, 2);
        
        primaryStage.setTitle("JavaFX Homework");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static float doubleToFloatConverter(Double number){
        return number.floatValue();
    }
    
    public static float getRandomNumeber(){
        return doubleToFloatConverter(Math.random());
    }
    
}
