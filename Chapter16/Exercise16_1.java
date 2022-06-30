package exercise161;

import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.stage.Stage; 
import javafx.scene.layout.BorderPane; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox; 
import javafx.scene.paint.Color; 
import javafx.scene.control.Label; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 

public class Exercise16_1 extends Application {
	
	@Override
	public void start(Stage arg0) throws Exception {
		//Make RadioButtons put them in an HBox and ToggleGroup and put them in the pane
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbGreen = new RadioButton("Green");
		
		HBox paneForRadioButtons = new HBox(50); 
		paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
		paneForRadioButtons.setStyle("-fx-border-color: black");
		paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color: black");
		paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		
		//Make a text and set it's color to blue I changed it's font and size; 
		Text lbl = new Text("Ya Buddy Light Weight Baby");
		lbl.setFill(Color.BLUE);
		lbl.setFont(new Font("Arial", 15));
		
		Button moveLeft = new Button("<-");
		Button moveRight = new Button("->");
		HBox paneForMoveButtons = new HBox(50);
		paneForMoveButtons.setPadding(new Insets(5, 5, 5, 5));
		paneForMoveButtons.setStyle("-fx-border-color: black");
		paneForMoveButtons.setStyle("-fx-border-width: 2px; -fx-border-color: black");
		paneForMoveButtons.getChildren().addAll(moveLeft, moveRight);
		paneForMoveButtons.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane(); 
		pane.setTop(paneForRadioButtons);
		pane.setBottom(paneForMoveButtons);
		pane.setCenter(lbl);
		
		// Add SetOnAction methods to change the color of the text
		rbRed.setOnAction(e -> lbl.setFill(Color.RED));
		rbYellow.setOnAction(e -> lbl.setFill(Color.YELLOW));
		rbBlack.setOnAction(e -> lbl.setFill(Color.BLACK));
		rbOrange.setOnAction(e -> lbl.setFill(Color.ORANGE));
		rbGreen.setOnAction(e -> lbl.setFill(Color.GREEN));
		
		//setonAction for move buttons add the methods  
		moveLeft.setOnAction(e -> { 
			if (lbl.getTranslateX() - 10 < 0) return;
		lbl.setTranslateX(lbl.getTranslateX() - 10);
		});
		moveRight.setOnAction(e -> {
			if (lbl.getTranslateX() + 10 > 500) return;
		lbl.setTranslateX(lbl.getTranslateX() + 10);
		});
		
		Scene scene = new Scene(pane, 500, 300);
		arg0.setTitle("RadioButtons");
		arg0.setScene(scene);
		arg0.show(); 
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}
	
}
