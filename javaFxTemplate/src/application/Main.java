package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("server.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Micro Star"); 
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {

		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
