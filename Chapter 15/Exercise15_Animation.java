package exercise15animation;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
  import javafx.animation.Timeline;
  import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
  import javafx.scene.layout.BorderPane;
  import javafx.scene.paint.Color;
  import javafx.scene.shape.Rectangle;
  import javafx.scene.shape.Polygon;
  import javafx.stage.Stage;
  import javafx.util.Duration;

  
  public class Exercise15_Animation extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      // Create a pane 
      BorderPane pane = new BorderPane();
      
      // Create a rectangle
      Rectangle rectangle = new Rectangle (0, 0, 25, 50);
      rectangle.setFill(Color.ORANGE);
      
      // Create a circle
      Polygon pentagon = new Polygon();
     pentagon.setFill(Color.WHITE);
  	pentagon.setStroke(Color.BLACK);
  	ObservableList<Double> list = pentagon.getPoints(); 
  	
  	final double WIDTH = 200, HEIGHT = 200; 
  	double centerX = WIDTH / 2, centerY = HEIGHT / 2; 
  	double radius = Math.min(WIDTH, HEIGHT) * 0.4;
  	
  	for (int i = 0; i < 6; i++) {
  		list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
  		list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
  	}
      // Add circle and rectangle to the pane
      pane.getChildren().add(pentagon); 
      pane.getChildren().add(rectangle); 
      
      BorderPane.setAlignment(pentagon, Pos.CENTER);
      
      // Create a path transition 
      PathTransition pt = new PathTransition();
      pt.setDuration(Duration.millis(4000));
      pt.setPath(pentagon);
      pt.setNode(rectangle);
      pt.setOrientation(
        PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
      pt.setCycleCount(Timeline.INDEFINITE);
      pt.setAutoReverse(true);
      pt.play(); // Start animation 
      
      FadeTransition ft = new FadeTransition(Duration.millis(3000), rectangle);
      ft.setFromValue(1.0);
      ft.setToValue(0.1); 
      ft.setCycleCount(Timeline.INDEFINITE);
      ft.setAutoReverse(true);
      ft.play();
      
      pentagon.setOnMousePressed(e -> pt.pause());
      pentagon.setOnMouseReleased(e -> pt.play());
      pane.setOnMousePressed(e -> ft.pause());
      pane.setOnMouseReleased(e -> ft.play());
      
      // Create a scene and place it in the stage
      Scene scene = new Scene(pane, 250, 200);
      primaryStage.setTitle("First animation"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
      
    }
  }