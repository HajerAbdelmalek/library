package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {

		   
		 
		        DatePicker datePicker = new DatePicker();
		        datePicker.setValue(LocalDate.of(2016, 7, 25));
		        datePicker.setShowWeekNumbers(true);
		        
		        // Converter
		        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
		            DateTimeFormatter dateFormatter =
		                      DateTimeFormatter.ofPattern("dd-MM-yyyy");
		            
		            @Override
		            public String toString(LocalDate date) {
		                if (date != null) {
		                    return dateFormatter.format(date);
		                } else {
		                    return "";
		                }
		            }
		            @Override
		            public LocalDate fromString(String string) {
		                if (string != null && !string.isEmpty()) {
		                    return LocalDate.parse(string, dateFormatter);
		                } else {
		                    return null;
		                }
		            }
		        };   
		        datePicker.setConverter(converter);
		        datePicker.setPromptText("dd-MM-yyyy");
			// BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("/application/I1.fxml"));
			Scene scene = new Scene(root, 800, 600);
			//scene.getStylesheets().add(getClass().getResource("/application.fxml").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

	public static void main(String[] args) {
		launch(args);
	}
}