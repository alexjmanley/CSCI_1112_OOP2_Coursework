
import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.stage.Stage; 
import javafx.scene.Scene; 
import javafx.scene.control.Label; 
import javafx.scene.layout.BorderPane; 

public class Exercise14_28 extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		
		ClockPane clock = new ClockPane(); 
		clock.setWidth(50);
		clock.setHeight(50);
		clock.setCurrentTime();
		String timeString = clock.getHour() + ":" + clock.getMinute()
		 + ":" + clock.getSecond(); 
		clock.setSecondHandVisible(false);
		Label lblCurrentTime = new Label(timeString); 
		
		BorderPane pane = new BorderPane(); 
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		
		Scene scene = new Scene(pane, 250, 250); 
		arg0.setTitle("DisplayClock");
		arg0.setScene(scene);
		arg0.show(); 
		
	}
	public static void main(String[] args) { 
      Application.launch(args); 
    }
}
