package finalproject;

import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 
import javafx.scene.layout.*;
import java.text.DecimalFormat; 

public class Final_Project extends Application{
	//List of text fields
	TextField tfweight = new TextField(); 
	TextField tfgoalWeight = new TextField(); 
	TextField tfgender = new TextField(); 
	TextField tfheight = new TextField();  
	TextField tfage = new TextField();  
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Make 1st pane 
		GridPane pane = new GridPane(); 
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("Enter Weight in kg: "), 0,0);
		pane.add(tfweight, 1, 0);
		pane.add(new Label("Enter Goal Weight in kg: "), 0, 1);
		pane.add(tfgoalWeight, 1, 1);
		pane.add(new Label("Enter your Gender ex. Male: "), 0, 2);
		pane.add(tfgender, 1, 2);
		pane.add(new Label("Enter your height in cm: "), 0, 3);
		pane.add(tfheight, 1, 3);
		pane.add(new Label("Enter your age in years: "), 0, 4);
		pane.add(tfage, 1, 4);
		Button next = new Button("Next");
		pane.add(next, 1, 5);
		
		//setOnAction for Next Button 
		next.setOnAction(e -> {
		Scene scene = new Scene(variablesPane(), 320, 250); 
		primaryStage.setScene(scene);
		});
		
		// create scene and set stage. 
		Scene scene = new Scene(pane, 320, 250); 
		primaryStage.setTitle("MyJavaFX"); 
		primaryStage.setScene(scene);
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}
	// added Calculate calories method 
	public static double calculateCalories(double weight, String gender, double height, int age) {
		double calories = 0; 
		if (gender.equalsIgnoreCase("Female"))
			calories = (447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)) * 1.55;
		else 
			calories = (88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)) * 1.55;
		return calories;
	}
	//add variables method 
	public Pane variablesPane() {
		//Add variables from original 
				double weight = Double.parseDouble(tfweight.getText());
				double goalWeight = Double.parseDouble(tfgoalWeight.getText());
				String gender = tfgender.getText(); 
				double height = Double.parseDouble(tfheight.getText());
				int age = Integer.parseInt(tfage.getText());
				double calories = calculateCalories(weight, gender, height, age);
				int weeksToGoal = 0; 
					if (weight > goalWeight) {
						calories = calories - 500;
						while (weight > goalWeight) {
							weight = weight - 0.5;
							weeksToGoal++;
						}
					} else if (weight < goalWeight) {
						calories = calories + 500; 
						while (weight < goalWeight) {
							weight = weight + 0.5; 
							weeksToGoal++; 
						}
					}
		//Add Pane
				DecimalFormat df = new DecimalFormat(".");
				Pane pane = new Pane(); 
				Label label = new Label("Your calorie suggestion is \n" + df.format(calories) + " calories daily.\n"
						+ "You will be at your goal weight after " + weeksToGoal + " weeks \n"
						+ "Your protien suggestion is \n" + df.format((calories * 0.25) / 4) + " grams daily");
				label.setLayoutY(60);
				label.setLayoutX(50);
				pane.getChildren().add(label);
				return pane; 
	}

}
