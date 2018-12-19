package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController implements Initializable{

    @FXML
    private Button b10;

    @FXML
    private DatePicker date;

    @FXML
    private TextField id_livre;

    @FXML
    private TextField id_personne;

    @FXML
    private Button b11;

    @FXML
    private AnchorPane emp;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    void rechercher_livre(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/RechercherLivre.fxml"));
		Scene scene = new Scene(root, 800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
    }

    @FXML
    void ajouter_livre(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/AjouterLivre.fxml"));
		Scene scene = new Scene(root, 800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
    }

    @FXML
    void modifier_livre(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/ModifierLivre.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
    }

    @FXML
    void afficher_livres(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/ListeLivre.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
    }
    @FXML
    void supprimer_livre(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/SupprimerLivre.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();

    }

    @FXML
    void supprimer_personne(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/SupprimerPersonne.fxml"));
		Scene scene = new Scene(root, 800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
    }

    @FXML
    void rechercher_personne(ActionEvent event) {
    	

    }

    @FXML
    void ajouter_personne(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/AjouterPersonne.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();

    }

    @FXML
    void modifier_personne(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/ModifierPersonne.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
    }

    @FXML
    void afficher_personne(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/ListPersonne.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();
    }

    @FXML
    void emprunter(ActionEvent event) throws Exception {
    	try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			String NumLivre = id_livre.getText();
			String NumPersonne = id_personne.getText();
			int NumLivre1 = Integer.parseInt(NumLivre);
			int NumPersonne1 = Integer.parseInt(NumPersonne);
			
			PreparedStatement Stmt = d.prepareStatement("INSERT INTO emprunt VAlUES(?,?,?,?)");
			 /*Long millis = System.currentTimeMillis();
		       Date date = new Date(millis);
		    String date1= SimpleDateFormat("dd-MM-yyyy").format(date);*/
		    Stmt.setInt(1, NumLivre1);
			Stmt.setString(2, "12/10/2015");
			Stmt.setInt(3, NumLivre1);
			Stmt.setInt(4, NumPersonne1);
	
			Stmt.executeUpdate();
			d.close();
    	} catch (SQLException e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
			}		
    }
	@Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }
    

}
