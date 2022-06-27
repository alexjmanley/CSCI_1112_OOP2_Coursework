import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.BorderPane; 

public class Exersice15_Listeners extends Application{
	@Override
	public void start(Stage primaryStage) {
		BallPane ball = new BallPane(); 
		
		Button left = new Button("Left");
		left.setOnAction(e -> ball.Left());
		Button right = new Button("Right");
		right.setOnAction(e -> ball.Right());
		Button up = new Button("Up");
		up.setOnAction(e -> ball.UP());
		Button down = new Button("Down");
		down.setOnAction( e -> ball.Down());
		
		HBox buttons = new HBox(left, right, up, down);
		buttons.setAlignment(Pos.TOP_CENTER);
		buttons.setPadding(new Insets(25, 25, 25, 25));
		buttons.setSpacing(10);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ball);
		pane.setTop(buttons);
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Moving Ball");
		primaryStage.setScene(scene);
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

