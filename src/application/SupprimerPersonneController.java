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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SupprimerPersonneController {

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Label l1;

    @FXML
    private TextField t1;

    @FXML
    private Button b1;

    @FXML
    void supprimer_personne(ActionEvent event) throws Exception {
    	try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			String NumPersonne = t1.getText();
			int NumPersonne1 = Integer.parseInt(NumPersonne);
			PreparedStatement stmt = d.prepareStatement("DELETE FROM personne WHERE NumPersonne = ?");
			stmt.setInt(1, NumPersonne1);
			int res = stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
    }

    @FXML
    void afficher_personne(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/ListePersonne.fxml"));
		Scene scene = new Scene(root, 800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
    }

    @FXML
    void quitter(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/menu1.fxml"));
		Scene scene = new Scene(root, 800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();


    }

}
