package it.cougar.main;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	private ObservableList<Articolo> articoliData = FXCollections.observableArrayList();
	private ObservableList<Ricevuta> ricevutaData = FXCollections.observableArrayList();
	
	public Main() {
		articoliData.add(new Articolo("book", 12.49f, false, true));
		articoliData.add(new Articolo("music CD", 14.99f, false, false));
		articoliData.add(new Articolo("chocolate bar", 0.85f, false, true));
		articoliData.add(new Articolo("imported box of chocolates 1", 10.00f, true, true));
		articoliData.add(new Articolo("imported box of chocolates 2", 11.25f, true, true));
		articoliData.add(new Articolo("imported bottle of perfume 1", 47.50f, true, false));
		articoliData.add(new Articolo("imported bottle of perfume 2", 27.99f, true, false));
		articoliData.add(new Articolo("bottle of perfume 3", 18.99f, false, false));
		articoliData.add(new Articolo("packet of headache pills", 9.75f, false, true));
	}
	
	public ObservableList<Articolo> getArticoliData() {
		return articoliData;
	}

	public ObservableList<Ricevuta> getRicevutaData() {
		return ricevutaData;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader x = new FXMLLoader(getClass().getResource("Main.fxml"));

			Parent root = (Parent) x.load();
			Scene scene = new Scene(root, 800, 600);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			MainController controller = x.getController();
			controller.setMainApp(this);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
