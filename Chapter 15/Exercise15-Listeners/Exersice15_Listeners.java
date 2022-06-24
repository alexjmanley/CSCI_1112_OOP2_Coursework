package exercise15;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 

public class Exersice15_Listeners extends Application{
	@Override
	public void start(Stage primaryStage) {
		BallPane ball = new BallPane(); 
		Scene scene = new Scene(ball, 300, 300);
		primaryStage.setTitle("Moving Ball");
		primaryStage.setScene(scene);
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
