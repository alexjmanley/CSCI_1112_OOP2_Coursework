package finalproject;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 
import javafx.scene.layout.*;

public class Final_Project extends Application{
	//List of variables 
	double weight = 0.0;
	TextField tfweight = new TextField(); 
	double goalWeight = 0.0;
	TextField tfgoalWeight = new TextField(); 
	String gender = "Male";
	TextField tfgender = new TextField(); 
	double height = 0.0;
	TextField tfheight = new TextField(); 
	int age = 0; 
	TextField tfage = new TextField(); 
	double calories = calculateCalories(weight, gender, height, age);
	int weeksToGoal = 0; 
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// make text field 
		
		
		//Make pane 
		GridPane pane = new GridPane(); 
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("Enter Weight in kg: "), 0,0);
		pane.add(tfweight, 1, 0);
		pane.add(new Label("Enter Goal Weight in kg: "), 0, 1);
		pane.add(tfgoalWeight, 1, 1);
		pane.add(new Label("Enter your Gender: "), 0, 2);
		pane.add(tfgender, 1, 2);
		pane.add(new Label("Enter your height in cm: "), 0, 3);
		pane.add(tfheight, 1, 3);
		pane.add(new Label("Enter your age in years: "), 0, 4);
		pane.add(tfage, 1, 4);
		
		// create scene and set stage. 
		Scene scene = new Scene(pane, 320, 350); 
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

}