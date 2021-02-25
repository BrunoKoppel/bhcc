/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrunokoppel3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author brunokoppel
 */
public class IndividualProjectBrunoKoppel3 extends Application {
  
  /**
   * Represents the size of the stage in the y axis.
   */
  static public int sceneHeight = 700;
  
  /**
   * Represents the size of the stage in the x axis.
   */
  static public int sceneWidth = 400;
  
  /**
   * Timeline object that moves the ball.
   */
  static private Timeline animation;
  
  /**
   * Object that detects an intersection of the paddle and ball.
   */
  public boolean intersectionDetected = false;
  
  /**
   * Start method that gets called upon running the application.
   * @param primaryStage Stage object passed from main.
   */
  @Override
  public void start(Stage primaryStage) {
    /**
     * Instance of a BallPane object in the main that represents the ball object.
     */
    BallPane ballPane = new BallPane();
    
    /**
     * Instance of the PaddlePane object that represents the Paddle object.
     */
    PaddlePane paddlePane = new PaddlePane();
    
    /**
     * Instance of a ScoreTable object that represents our score tracking system.
     */
    ScoreTablePane scoreTable = new ScoreTablePane();
    
    /**
     * Group instance in which we load the ballPane, paddlePane, and scoreTable.
     */
    Group root = new Group();

    


    /**
     * Timeline instance that calls the moveBall function throughout its process.
     */
    animation = new Timeline(
      new KeyFrame(Duration.millis(10), e -> moveBall(primaryStage, paddlePane, ballPane, scoreTable)));
    
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.setRate(animation.getRate() * 2);
    animation.play(); // Start animation

    // Increase and decrease animation   
    root.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.UP) {
        increaseSpeed();
      } 
      else if (e.getCode() == KeyCode.DOWN) {
        decreaseSpeed();
      }
    });

    // Gets the position of the mouse to set the position of the paddle.
    root.setOnMouseMoved(e -> {
        paddlePane.setX(e.getX());
    });
    
    // Pauses the animation on click.
    root.setOnMousePressed(e -> {
        if (getStatus()){
          pause();
        } else {
          play();
        }
    });

    // Add the elements into the scene.
    root.getChildren().add(ballPane);
    root.getChildren().add(paddlePane);
    root.getChildren().add(scoreTable);

    // Create an scene and load it into the Stage.
    Scene game = new Scene(root, sceneWidth, sceneHeight);
    primaryStage.setTitle("Paddle-Ball for One"); // Set the stage title
    primaryStage.setScene(game); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
      launch(args);
  }
  
  /**
   * Returns the Status of the animation object so that we can pause it or play it depending on its return value.
   * @return Boolean object that is true if animation is running, or false if it's not.
   */
  public boolean getStatus() {
    String animationStatus = String.valueOf(animation.getStatus());
    if (animationStatus.equals("RUNNING")){
      return true;
    } else {
      return false;
    }
  }

  /**
   * Creates a Game Over Screen and displays it to the user.
   * @param primaryStage the Stage object in which the application runs.
   */
  public void gameOver(Stage primaryStage){
    pause();
    
    StackPane gameOverPane = new StackPane();
    ScoreTablePane gameOverTable = new ScoreTablePane();
    
    gameOverTable.setGameOverText("GAME OVER");
    gameOverPane.getChildren().add(gameOverTable);
    Scene gameOverScene = new Scene(gameOverPane, sceneWidth, sceneHeight);
    
    primaryStage.setScene(gameOverScene);
  }
  
  /**
   * Resets the ball and paddle and ball objects upon losing a round.
   * @param scoreTable object to reset the Score.
   * @param ballPane object to reset.
   */
  public void resetGame(ScoreTablePane scoreTable, BallPane ballPane){
    scoreTable.decreaseLives();
    scoreTable.resetScore();
    ballPane.reset();
  }
  
  /**
   * Main function of the animation, that handles bounces and the intersection with the paddle.
   * @param primaryStage Stage object in which the application runs.
   * @param paddlePane Paddle object used to bounce off the ball in the bottom.
   * @param ballPane Ball object that bounces off the walls and paddle.
   * @param scoreTable Score table object used to keep track of scores and lives.
   */
  public void moveBall(Stage primaryStage, PaddlePane paddlePane, BallPane ballPane, ScoreTablePane scoreTable) {
    
    // Game Over when the player loses all lives
    if (scoreTable.getRemainingLives() == 0){
      gameOver(primaryStage);
    }
    
    // Check boundaries for the walls in x direction
    if (ballPane.getX() < ballPane.leftBounds || ballPane.getX() > ballPane.rightBounds) {
      ballPane.setVX(ballPane.getVX() * -1); // Change ball move direction
    }
    
    // Check boundaries for the walls in y direction
    if (ballPane.getY() < ballPane.upperBounds ) {
      ballPane.setVY(ballPane.getVY() * -1); // Change ball move direction
    } else if (ballPane.getY() > ballPane.lowerBounds) {
      scoreTable.increaseRowMisses();
      resetGame(scoreTable, ballPane);
      if (scoreTable.getRowMisses() == 3){
        paddlePane.increasePaddleWidth();
        ballPane.increaseBallSize();
      }
    }
    
// Test function
//    paddlePane.setX(ballPane.getX());
    
    // Check if it connects to the paddle board
    if ((ballPane.getBounds().intersects(paddlePane.getBounds())) && !intersectionDetected){   
      intersectionDetected = true;
      
      // Change the velocity in the Y and X direction
      // I had a talk with you prof. Miller to change the velocity gradually instead of in an instant.
      ballPane.setVY(ballPane.getVY() * -1 * (1.1));
      ballPane.setVX(ballPane.getVX() * (1.1));

      // If there are 3 or more misses in a row, the score row misses are reset back to zero and the ball and paddle are decreased in size.
      if (scoreTable.getRowMisses() >= 3 ){
        scoreTable.resetRowMisses();
        paddlePane.decreasePaddleWidth();
        ballPane.decreaseBallSize();
      }

      // Increase the score of the table.
      scoreTable.increaseScore();

      // Round Score is analized to change the color of the ball
      if(scoreTable.getScore() % 5 == 0){
        ballPane.setNewColor();
      }

      // Round Score is analized to change the size of the ball
      if (scoreTable.getScore() % 10 == 0) {
        paddlePane.decreasePaddleWidth();
        ballPane.decreaseBallSize();
      }
    } else if ((ballPane.getBounds().intersects(paddlePane.getBounds())) && intersectionDetected){
      
    } else {
      intersectionDetected = false;
    }
    
    // Adjust ball position
    ballPane.setX(ballPane.getX() + ballPane.getVX());
    ballPane.setY(ballPane.getY() + ballPane.getVY());
  }
  
  /**
   * Sets the animation to play.
   */
  public void play() {
    animation.play();
  }

  /**
   * Sets the animation to pause.
   */
  public static void pause() {
    animation.pause();
  }

  /**
   * Increases the Speed of the animation.
   */
  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 0.1);
  }

  /**
   * Decreases the Speed of the animation.
   */
  public void decreaseSpeed() {
    animation.setRate(
      animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
  }
}
