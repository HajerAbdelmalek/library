package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AjouterPersonneController {

    @FXML
    private TextField t4;

    @FXML
    private Button b2;

    @FXML
    private TextField t5;

    @FXML
    private Label l1;

    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;

    @FXML
    private Button b1;

    @FXML
    void ajouter_personne(ActionEvent event) throws Exception {
    	try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			String NumPersonne = t1.getText();
			String Prenom =t2.getText();
			String Nom = t3.getText();
			String Adresse =t4.getText();
			String Telephone = t5.getText();
			int NumPersonne1 = Integer.parseInt(NumPersonne);
			PreparedStatement Stmt = d.prepareStatement("INSERT INTO personne VAlUES(?,?,?,?,?)");
			Stmt.setInt(1, NumPersonne1);
			Stmt.setString(2, Prenom);
			Stmt.setString(3,Nom);
			Stmt.setString(4, Adresse);
			Stmt.setString(5, Telephone);
			Stmt.executeUpdate();
			d.close();
		} catch (SQLException e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
			 Alert alert = new Alert(AlertType.WARNING);
		        alert.setTitle("Warning alert");
		        alert.setHeaderText(e.getMessage());
		        alert.setContentText("Saisir un autre id");
		        alert.showAndWait();
		}


    }

    @FXML
    void quitter(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/menu1.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();

    }

}
