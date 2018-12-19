package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ModifierPersonneController {
	ObservableList<Personne> data = FXCollections.observableArrayList();

    @FXML
    private TextField t4;

    @FXML
    private TextField t5;

    @FXML
    private TableView<Personne> Tabmodif;

    @FXML
    private TableColumn<Personne, Integer> c1;

    @FXML
    private TableColumn<Personne, String> c2;

    @FXML
    private Button b1;
    @FXML
    private Button b3;

    @FXML
    private TableColumn<Personne, String> c3;

    @FXML
    private Button b2;

    @FXML
    private TableColumn<Personne, String> c4;

    @FXML
    private TableColumn<Personne, String> c5;

    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    void modifier_personne(ActionEvent event) throws Exception {
    	try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			String NumPersonne = t1.getText();
			String Prenom = t2.getText();
			String Nom = t3.getText();
			String Adresse = t4.getText();
			String Telephone = t5.getText();
			int NumPersonne1 = Integer.parseInt(NumPersonne);
			PreparedStatement stmt = d.prepareStatement("UPDATE personne SET Prenom=?,Nom=?,Adresse=?,Telephone=? WHERE NumPersonne =?");
			stmt.setString(1,Prenom);
			stmt.setString(2, Nom);
			stmt.setString(3, Adresse);
			stmt.setString(4,Telephone);
			stmt.setInt(5,NumPersonne1);
			int res = stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}


    }

    @FXML
    void afficher_personne(ActionEvent event) throws Exception {
    	try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			data.clear();
			data=FXCollections.observableArrayList();
		    ResultSet rst =d.createStatement().executeQuery("SELECT * FROM personne");
		    while(rst.next()) {
		    data.add(new Personne(rst.getInt("NumPersonne"),rst.getString("Prenom"),rst.getString("Nom"),rst.getString("Adresse"),rst.getString("Telephone")));}
		    c1.setCellValueFactory(new PropertyValueFactory<Personne,Integer>("NumPersonne"));
		    c2.setCellValueFactory(new PropertyValueFactory<Personne,String>("Prenom")); 
		    c3.setCellValueFactory(new PropertyValueFactory<Personne,String>("Nom")); 
		    c4.setCellValueFactory(new PropertyValueFactory<Personne,String>("Adresse"));
		    c4.setCellValueFactory(new PropertyValueFactory<Personne,String>("Telephone")); 
            Tabmodif.setItems(null);
            Tabmodif.setItems(data);
		} catch (ClassNotFoundException | SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}


    }

    @FXML
    void quitter(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/Menu1.fxml"));
		Scene scene = new Scene(root,800, 600);
		Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
		window.setScene(scene);
		window.show();

    }

}
