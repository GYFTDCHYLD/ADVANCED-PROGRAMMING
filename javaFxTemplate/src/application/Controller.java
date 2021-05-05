package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {
	@FXML
    private Label server_status;

    @FXML
    private Label database_name;

    @FXML
    private Label host;

    @FXML
    private Label user;

    @FXML
    private Label database_status;
    
    @FXML
    private Button server_btn;
  

    @FXML
    void startServer(ActionEvent event) {
    	server_status.setStyle("-fx-background-color: green; -fx-background-radius: 90;");
    	server_btn.setDisable(true);
    	database_status.setStyle("-fx-background-color: green; -fx-background-radius: 90;");
    }
}