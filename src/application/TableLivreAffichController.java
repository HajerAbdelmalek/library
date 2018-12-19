package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Data;
import application.Livre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableLivreAffichController implements Initializable {
	
	ObservableList<Livre> data = FXCollections.observableArrayList();

    @FXML
    private Button b2;

    @FXML
    private Button b1;

    @FXML
    private TableColumn<Livre, Integer> number;

    @FXML
    private TableColumn<Livre, Integer> avail;

    @FXML
    private TableColumn<Livre, String> author;

    @FXML
    private TableColumn<Livre, String> categ;

    @FXML
    private TableColumn<Livre, String> title;
    @FXML
    private TableView<Livre> TabLivre;

    @FXML
   void afficher(ActionEvent event) throws Exception {
    	try {

			//Statement stmt;
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			data.clear();
			//stmt = d.createStatement();
			data=FXCollections.observableArrayList();
		    ResultSet rst =d.createStatement().executeQuery("SELECT * FROM livres");
		    while(rst.next()) {
		    data.add(new Livre(rst.getInt("NumLivre"),rst.getString("Titre"),rst.getString("Auteur"),rst.getInt("Etat"),rst.getString("Categorie")));
		    }
		    
		    number.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("NumLivre"));
		    title.setCellValueFactory(new PropertyValueFactory<Livre,String>("Titre")); 
		    author.setCellValueFactory(new PropertyValueFactory<Livre,String>("Auteur")); 
		    avail.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("Etat"));
		    categ.setCellValueFactory(new PropertyValueFactory<Livre,String>("Categorie")); 
		   
		   
            TabLivre.setItems(null);
            TabLivre.setItems(data);

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
    
@Override
public void initialize(URL url, ResourceBundle rb) {
 
}
}

