/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrunokoppel3;

import javafx.geometry.Pos;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author brunokoppel
 */
public class ScoreTablePane extends Pane  {
  
  /**
   * Variable imported from the main file, representing the height of the scene.
   */
  static public int sceneHeight = IndividualProjectBrunoKoppel3.sceneHeight;
  
  /**
   * Variable imported from the main file, representing the width of the scene.
   */
  static public int sceneWidth = IndividualProjectBrunoKoppel3.sceneWidth;
  
  /**
   * Object that sits in the bottom of the screen, it was supposed to hold the text for the game.
   */
  private Polygon rectangle = new Polygon(0.0, 600.0, 400.0 , 600.0, 400.0 , 700.0, 0.0, 700.0);
  
  /**
   * Label object that represents the amount of points awarded in a row.
   */
  public Label scoreText = new Label();
  
  /**
   * Label object that represents the amount of lives left in a game.
   */
  public Label livesText = new Label();
  
  /**
   * number of the score of a round.
   */
  private int currentScore = 0;
  
  /**
   * number to the remaining lives in a game.
   */
  private int lives = 20;
  
  /**
   * number of throws missed in a row.
   */
  private int rowMisses = 0;
  
  /**
   * HBox object that keeps the Labels in a box.
   */
  HBox hbox = new HBox();
  
  /**
   * Default constructor of a ScoreTablePane object.
   */
  public ScoreTablePane() {
    rectangle.setFill(Color.LIGHTGRAY); // Set Polygon color
    scoreText.setText(String.valueOf(currentScore) + " Score");
    scoreText.setAlignment(Pos.CENTER);
    scoreText.setTextAlignment(TextAlignment.CENTER);
    scoreText.setTextFill(Color.BLACK);
    
    livesText.setText(String.valueOf(lives) + " Remaining Lives");
    livesText.setAlignment(Pos.CENTER);
    livesText.setTextAlignment(TextAlignment.CENTER);
    livesText.setTextFill(Color.BLACK);
    
    hbox.getChildren().add(scoreText);
    hbox.getChildren().add(livesText);
    hbox.setSpacing(10.0);
    
    this.getChildren().add(rectangle);
    this.getChildren().add(hbox);
  }
  
  /**
   * Increases the Score by one and updates the Score Label.
   */
  public void increaseScore(){
    currentScore++;
    scoreText.setText(String.valueOf(currentScore) + " Score");
  }
  
  /**
   * Decreases the Score by one and updates the Lives Label.
   */
  public void decreaseLives(){
    lives--;
    livesText.setText(String.valueOf(lives) + " Remaining Lives");
  }
  
  /**
   * Resets the Score number back to 0.
   */
  public void resetScore(){
    currentScore = 0;
    scoreText.setText(String.valueOf(currentScore) + " Score");
  }
  
  /**
   * Increases the number of misses in a row.
   */
  public void increaseRowMisses(){
    rowMisses++;
  }
  
  /**
   * Resets the number of misses in a row.
   */
  public void resetRowMisses(){
    rowMisses = 0;
  }
  
  /**
   * Returns the number of misses in a row.
   * @return an integer number.
   */
  public int getRowMisses(){
    return this.rowMisses;
  }
 
  /**
   * Returns the number of Scores in a round.
   * @return an integer number.
   */
  public int getScore(){
    return this.currentScore;
  }
  
  /**
   * Returns the number of Lives Remaining.
   * @return an integer number.
   */
  public int getRemainingLives(){
    return this.lives;
  }
  
  /**
   * Changes the Labels for a specific type of Scene that appears when the player loses all lives.
   * @param prompt String that is shown in the Scene.
   */
  public void setGameOverText(String prompt){
    scoreText.setText(prompt);
    scoreText.setTextFill(Color.RED);
    livesText.setText(prompt);
    livesText.setTextFill(Color.RED);
  }
}
