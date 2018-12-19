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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AjouterLivreController {

    @FXML
    private TextField Auteur;

    @FXML
    private Button q;

    @FXML
    private TextField Titre;

    @FXML
    private TextField Etat;

    @FXML
    private TextField Ctg;

    @FXML
    private TextField Num_id;

    @FXML
    private Button sauvgarder;

    @FXML
    void ajouter_livre1(ActionEvent event) throws Exception {
    	try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			String NumLivre = Num_id.getText();
			String TitreLivre = Titre.getText();
			String AuteurLivre = Auteur.getText();
			String EtatLivre = Etat.getText();
			String CategorieLivre = Ctg.getText();
			int NumLivre1 = Integer.parseInt(NumLivre);
			int EtatLivre1=Integer.parseInt(EtatLivre);
			
			PreparedStatement Stmt = d.prepareStatement("INSERT INTO livres VAlUES(?,?,?,?,?)");
			Stmt.setInt(1, NumLivre1);
			Stmt.setString(2, TitreLivre);
			Stmt.setString(3, AuteurLivre);
			Stmt.setInt(4, EtatLivre1);
			Stmt.setString(5, CategorieLivre);
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
