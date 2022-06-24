package exercise15;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle; 
import javafx.scene.control.Button; 
import javafx.scene.layout.HBox; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 

public class BallPane extends Pane{
	
	//first create a circle object 
	double radius = 20; 
	double x = radius, y = radius;
	Circle ball = new Circle(x, y, radius); 
	Button left = new Button("Left");
	Button right = new Button("Right"); 
	Button up = new Button("Up");
	Button down = new Button("Down");
	
	//put ball in pane 
	BallPane(){
		ball.setFill(Color.RED);
		ball.setCenterX(150);
		ball.setCenterY(175);
		getChildren().add(ball);
		getChildren().add(getHBox()); 
		
	}
	
	//create HBox for buttons 
	private HBox getHBox() {
		HBox hbox = new HBox(25);
		hbox.setPadding(new Insets(25, 25, 25, 25)); 
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		hbox.getChildren().addAll(left, right, up, down);
		return hbox;
	}
	
}
