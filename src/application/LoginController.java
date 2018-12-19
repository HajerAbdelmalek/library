package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
public class LoginController {
	    @FXML
	    private PasswordField password;
	    @FXML
	    private Button bt;
	    @FXML
	    private TextField username;
	    @FXML
	    void login(ActionEvent event) throws IOException {
	    	String username1=username.getText();
	    	String Password=password.getText();
	    	if ((username1.equals("root")) && (Password.equals("root")))
	    	{
	    		Parent root = FXMLLoader.load(getClass().getResource("/application/Menu1.fxml"));
	    		Scene scene = new Scene(root, 800, 600);
	    		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    		window.setScene(scene);
	    		window.show();
	    	}
	    	
	    	else {
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Warning alert");
	        alert.setHeaderText("Mot de passe incorrecte");
	        alert.setContentText("Ressayer une autre fois");
	        alert.showAndWait();
	    		
	    	
	    }
	    }}

