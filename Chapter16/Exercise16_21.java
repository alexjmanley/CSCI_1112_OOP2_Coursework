package exercise1621;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField; 
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame; 
import javafx.scene.media.Media; 
import javafx.scene.media.MediaPlayer; 
import javafx.scene.media.MediaView; 

public class Exercise16_21 extends Application {

	public void start(Stage primaryStage) {
		// Make Text Field
		TextField seconds = new TextField();
		seconds.setFont(Font.font("Times", 20));
		seconds.setAlignment(Pos.CENTER);
		
		// create Time line 
		Timeline countdown = new Timeline(
				new KeyFrame( Duration.millis(1000), e -> {
					seconds.setText((Integer.parseInt(seconds.getText()) - 1) + "");
				}));
		seconds.setOnAction(e -> {
			if (countdown.getStatus() == Animation.Status.RUNNING) {
				countdown.stop();
			}
			countdown.setCycleCount(Integer.parseInt(seconds.getText()));
			countdown.play();
		});
		
		// add media 
		final String MEDIA_URL = 
				"https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
		Media media = new Media(MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaview = new MediaView(mediaPlayer);
		countdown.setOnFinished(e -> mediaPlayer.play());
		
		// Pane for the project 
		BorderPane pane = new BorderPane(); 
		pane.setCenter(seconds);
		pane.setTop(new Label("Enter Seconds: "));
		
		// set the Stage 
		Scene scene = new Scene(pane, 200, 200); 
		primaryStage.setTitle("It's the Final Countdown");
		primaryStage.setScene(scene);
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

