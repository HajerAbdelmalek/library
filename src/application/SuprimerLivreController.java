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

public class SuprimerLivreController {
	@FXML
	private TextField Num;

	@FXML
	private Button bafficher;

	@FXML
	private Button bquitter;

	@FXML
	private Button bsupprimer;

	@FXML
	private Label sup;

	@FXML
	void Suprimer_livre(ActionEvent event) throws Exception {
		try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			String NumLivre = Num.getText();
			int NumLivre1 = Integer.parseInt(NumLivre);
			PreparedStatement stmt = d.prepareStatement("DELETE FROM livres WHERE NumLivre = ?");
			stmt.setInt(1, NumLivre1);
			int res = stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	@FXML
	void afficher_livre(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/ListeLivre.fxml"));
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
