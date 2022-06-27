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
	
	//put ball in pane 
	BallPane(){
		ball.setFill(Color.RED);
		ball.setCenterX(150);
		ball.setCenterY(150);
		getChildren().add(ball);
		 
		
	}

	public void Left() {
		if (ball.getCenterX() - ball.getRadius() - 10 < 0) return; 
		ball.setCenterX(ball.getCenterX() - 10);  
	}
	public void Right() {
		if (ball.getCenterX() + ball.getRadius() + 10 > getWidth()) return; 
		ball.setCenterX(ball.getCenterX() + 10);
	}
	public void Down() {
		if (ball.getCenterY() + ball.getRadius() + 10 > getHeight()) return;
		ball.setCenterY(ball.getCenterY() + 10);
	}
	public void UP() {
		if (ball.getCenterY() - ball.getRadius() - 10 < 0) return; 
		ball.setCenterY(ball.getCenterY() - 10);
	}
}
