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
	TextField tfDays = new TextField(); 
	TextField tfSquatMax = new TextField(); 
	TextField tfBenchMax = new TextField(); 
	TextField tfDeadliftMax = new TextField(); 
	private Stage stage; 
	
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
		this.stage = primaryStage; 
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
		Button next = new Button("Next");
		next.setOnAction(e -> {
			Scene scene = new Scene(buildWorkoutPane(), 320, 250);
			stage.setScene(scene); 
		});
		next.setLayoutX(200);
		next.setLayoutY(150);
		pane.getChildren().add(label);
		pane.getChildren().add(next); 
		return pane; 
	}
	// add lifting questions 
	public GridPane buildWorkoutPane() {
		// Make new Pane 
		GridPane pane = new GridPane(); 
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("Enter Amount of days per \nweek you can train:"), 0, 0);
		pane.add(tfDays, 1, 0); 
		pane.add(new Label("Enter your Squat \nMax in lbs:"), 0, 1);
		pane.add(tfSquatMax, 1, 1);
		pane.add(new Label("Enter yout Bench \nMax in lbs:"), 0, 2);
		pane.add(tfBenchMax, 1, 2);
		pane.add(new Label ("Enter your Deadlift \nMax in lbs:"), 0, 3);
		pane.add(tfDeadliftMax, 1, 3);
		Button next = new Button("Next");
		next.setOnAction(e -> {
			Scene scene = new Scene(lastPane(), 320, 250); 
			stage.setScene(scene); 
		});
		pane.add(next, 1, 4);
		//return
		return pane; 
	}
	//add last Pane 
	public Pane lastPane() {
		//add variables from Text Fields 
		int[] max = new int[3];
		max[0] = Integer.parseInt(tfSquatMax.getText());
		max[1] = Integer.parseInt(tfBenchMax.getText()); 
		max[2] = Integer.parseInt(tfDeadliftMax.getText()); 
		int workoutDays = Integer.parseInt(tfDays.getText()); 
		
		DecimalFormat df = new DecimalFormat(".");
		
		Label label1 = new Label("Workout:\nBench press 2X5 at " + df.format(max[1] * .70) + " lbs\n"
			+ "Squat 2X5 at " + df.format(max[0] * .70) + "lbs\nDeadlift 2X5 at " + df.format(max[2] * .70) + " lbs");
		Label label2 = new Label("Day1:\nBench press 3X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Squat 3X5 at " + df.format(max[0] * .70) + " lbs\nDay2:\nDeadlift 3X5 at " + df.format(max[2] * .70) + " lbs");
		Label label3 = new Label("Day1:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Day2:\nSquat 4X5 at " + df.format(max[0] * .70) + " lbs\nDay3\n"
				+ "Deadlift 4X5 at " + df.format(max[2] * .70) + " lbs");
		Label label4 = new Label("Day1:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Day2:\nSquat 4X5 at " + df.format(max[0] * .70) + " lbs\nDay3\n"
				+ "Deadlift 4X5 at " + df.format(max[2] * .70) + " lbs\nDay4:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs");
		Label label5 = new Label("Day1:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Day2:\nSquat 4X5 at " + df.format(max[0] * .70) + " lbs\nDay3\n"
				+ "Deadlift 4X5 at " + df.format(max[2] * .70) + " lbs\nDay4:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Day5:\nSquat 4X5 at " + df.format(max[0] * .70) + " lbs");
		Label label6 = new Label("Day1:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Day2:\nSquat 4X5 at " + df.format(max[0] * .70) + " lbs\nDay3\n"
				+ "Deadlift 4X5 at " + df.format(max[2] * .70) + " lbs\nDay4:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Day5:\nSquat 4X5 at " + df.format(max[0] * .70) + " lbs\nDay6:\nDeadlift 4X5 at "
				+ df.format(max[2] * .70) + " lbs");
		Label label7 = new Label("Day1:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Day2:\nSquat 4X5 at " + df.format(max[0] * .70) + " lbs\nDay3\n"
				+ "Deadlift 4X5 at " + df.format(max[2] * .70) + " lbs\nDay4:\nBench press 4X5 at " + df.format(max[1] * .70) + " lbs\n"
				+ "Day5:\nSquat 4X5 at " + df.format(max[0] * .70) + " lbs\nDay6:\nDeadlift 4X5 at "
				+ df.format(max[2] * .70) + " lbs\nDay7:\nRest");
		
		// Add Pane 
		Pane pane = new Pane(); 
		switch (workoutDays) {
		case 1: label1.setLayoutY(5);label1.setLayoutX(50);pane.getChildren().add(label1);
				break; 
		case 2: label2.setLayoutY(5);label2.setLayoutX(50);pane.getChildren().add(label2);
				break; 
		case 3: label3.setLayoutY(5);label3.setLayoutX(50);pane.getChildren().add(label3);
				break; 
		case 4: label4.setLayoutY(5);label4.setLayoutX(50);pane.getChildren().add(label4);
				break; 
		case 5: label5.setLayoutY(5);label5.setLayoutX(50);pane.getChildren().add(label5);
				break; 
		case 6: label6.setLayoutY(5);label6.setLayoutX(50);pane.getChildren().add(label6);
				break; 
		case 7: label7.setLayoutY(5);label7.setLayoutX(50);pane.getChildren().add(label7);
				break; 
		}
		
		//return
		return pane; 
	}

}
