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

public class ModifierLivreController {
	ObservableList<Livre> data = FXCollections.observableArrayList();

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private TableColumn<Livre, String> titre;

    @FXML
    private Label id2;

    @FXML
    private TableColumn<Livre, Integer> num;

    @FXML
    private TableColumn<Livre, String> categ;

    @FXML
    private TableView<Livre> tabmodif;

    @FXML
    private TextField id;

    @FXML
    private Label lab;

    @FXML
    private TableColumn<Livre, Integer> etat;

    @FXML
    private Button b1;

    @FXML
    private TableColumn<Livre, String> auteur;
    @FXML
    private Label lab1;

    @FXML
    private Label lab2;
    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private TextField t3;
    @FXML
    private TextField t4;

    @FXML
    void Modifier_livre(ActionEvent event) throws Exception {
    	try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			String NumLivre = id.getText();
			String TitreLivre = t1.getText();
			String AuteurLivre = t2.getText();
			String EtatLivre = t3.getText();
			String CategorieLivre = t4.getText();
			int NumLivre1 = Integer.parseInt(NumLivre);
			int EtatLivre1 = Integer.parseInt(EtatLivre);
			PreparedStatement stmt = d.prepareStatement("UPDATE livres SET Titre=?,Auteur=?,Etat=?,Categorie=? WHERE NumLivre =?");
			stmt.setString(1,TitreLivre);
			stmt.setString(2, AuteurLivre);
			stmt.setInt(3, EtatLivre1);
			stmt.setString(4,CategorieLivre);
			stmt.setInt(5,NumLivre1);
			int res = stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
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

    @FXML
    void afficher(ActionEvent event) throws Exception {
    	try {
			Data cnx = new Data();
			Connection d = cnx.getConnection();
			data.clear();
			data=FXCollections.observableArrayList();
		    ResultSet rst =d.createStatement().executeQuery("SELECT * FROM livres");
		    while(rst.next()) {
		    data.add(new Livre(rst.getInt("NumLivre"),rst.getString("Titre"),rst.getString("Auteur"),rst.getInt("Etat"),rst.getString("Categorie")));}
		    num.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("NumLivre"));
		    titre.setCellValueFactory(new PropertyValueFactory<Livre,String>("Titre")); 
		    auteur.setCellValueFactory(new PropertyValueFactory<Livre,String>("Auteur")); 
		    etat.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("Etat"));
		    categ.setCellValueFactory(new PropertyValueFactory<Livre,String>("Categorie")); 
            tabmodif.setItems(null);
            tabmodif.setItems(data);
		} catch (ClassNotFoundException | SQLException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}

    }

}
