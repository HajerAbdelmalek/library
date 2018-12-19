package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Menu1Controller{

    @FXML
    private Button b10;

    @FXML
    private DatePicker date;

    @FXML
    private TextField id_livre;

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
    void rechercher_livre(ActionEvent event) {

    }

    @FXML
    void ajouter_livre(ActionEvent event) throws IOException {
    	Parent root1 = FXMLLoader.load(getClass().getResource("/application/AjouterLivre.fxml"));
		Scene scene = new Scene(root1,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();

    }

    @FXML
    void modifier_livre(ActionEvent event) {

    }

    @FXML
    void afficher_livres(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/TableLivreAffichControl.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();

    }

    @FXML
    void supprimer_livre(ActionEvent event) {

    }

    @FXML
    void supprimer_personne(ActionEvent event) {

    }

    @FXML
    void rechercher_personne(ActionEvent event) {

    }

    @FXML
    void ajouter_personne(ActionEvent event) {

    }

    @FXML
    void modifier_persone(ActionEvent event) {

    }

    @FXML
    void afficher_personne(ActionEvent event) {

    }

    @FXML
    void emprunter(ActionEvent event) {

    }

}
