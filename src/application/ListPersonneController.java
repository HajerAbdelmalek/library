package application;

import java.io.IOException;
import java.sql.Connection;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListPersonneController {
	ObservableList<Personne> data = FXCollections.observableArrayList();

    @FXML
    private Button b2;

    @FXML
    private TableColumn<Personne, String> c3;

    @FXML
    private TableColumn<Personne, String> c4;

    @FXML
    private TableColumn<Personne, String> c5;

    @FXML
    private TableView<Personne> TabPers;

    @FXML
    private TableColumn<Personne, Integer> c1;

    @FXML
    private Button b1;

    @FXML
    private TableColumn<Personne, String> c2;

    @FXML
    void afficher_personne(ActionEvent event) throws Exception {
    	try {
    	//Statement stmt;
		Data cnx = new Data();
		Connection d = cnx.getConnection();
		data.clear();
		//stmt = d.createStatement();
		data=FXCollections.observableArrayList();
	    ResultSet rst =d.createStatement().executeQuery("SELECT * FROM Personne");
	    while(rst.next()) {
	    data.add(new Personne(rst.getInt("NumPersonne"),rst.getString("Prenom"),rst.getString("Nom"),rst.getString("Adresse"),rst.getString("Telephone")));
	    }
	    
	    c1.setCellValueFactory(new PropertyValueFactory<Personne,Integer>("NumPersonne"));
	    c2.setCellValueFactory(new PropertyValueFactory<Personne,String>("Prenom")); 
	    c3.setCellValueFactory(new PropertyValueFactory<Personne,String>("Nom")); 
	    c4.setCellValueFactory(new PropertyValueFactory<Personne,String>("Adresse"));
	    c5.setCellValueFactory(new PropertyValueFactory<Personne,String>("Telephone")); 
	   
	   
        TabPers.setItems(null);
        TabPers.setItems(data);

	} catch (ClassNotFoundException | SQLException ee) {
		// TODO Auto-generated catch block
		ee.printStackTrace();
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
