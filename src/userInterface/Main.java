package userInterface;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Pacman.fxml"));
			Scene scene = new Scene(root,600,400);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Catch the Pac-Man");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
