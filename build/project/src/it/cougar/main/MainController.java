package it.cougar.main;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
	
	private Main mainApp;

	@FXML TableView<Ricevuta> tblRicevuta;
	@FXML TableView<Articolo> tblArt;
	
	@FXML TableColumn<Articolo, Float> prezzoArt;
	@FXML TableColumn<Articolo, String> nomeArt;
	
	@FXML TableColumn<Ricevuta, String> cArt;
	@FXML TableColumn<Ricevuta, Float> cPrezzo;
	
	@FXML Button btnAdd;
	@FXML TextField txtTaxIncome;
	@FXML TextField txtTotal;
	
	@FXML
	private void initialize() {
		// Inizializzo la tabella degli Articoli
		nomeArt.setCellValueFactory(new PropertyValueFactory<Articolo, String>("nome"));
		prezzoArt.setCellValueFactory(new PropertyValueFactory<Articolo, Float>("prezzo"));
		
		// Inizializzo la tabella della Ricevuta
		cArt.setCellValueFactory(new PropertyValueFactory<Ricevuta, String>("nome"));
		cPrezzo.setCellValueFactory(new PropertyValueFactory<Ricevuta, Float>("prezzo"));
	}
	
	@FXML
	private void handleAdd() {
		Articolo articoloSelezionato = tblArt.getSelectionModel().getSelectedItem();
		
		if (articoloSelezionato != null) {
			Ricevuta newRicevuta = new Ricevuta(articoloSelezionato.getNome(), articoloSelezionato.getPrezzo(), articoloSelezionato.isImported(), articoloSelezionato.isFree());
			newRicevuta.calcolaTax();
			this.mainApp.getRicevutaData().add(newRicevuta);
		}
		
		calcolaTotali();
		
	}
	
	@FXML
	private void handleClear() {
		this.mainApp.getRicevutaData().clear();
		calcolaTotali();
	}

	private void calcolaTotali() {
		
		float tax = 0.0f;
		float totale = 0.0f;
		
		for(Ricevuta x : this.mainApp.getRicevutaData()) {
			tax += x.getTax();
			totale +=x.getPrezzo();
		}
		
		DecimalFormat f = new DecimalFormat("##.00");
		txtTaxIncome.setText(f.format(tax));
		txtTotal.setText(f.format(totale));
		
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		tblArt.setItems(mainApp.getArticoliData());
		tblRicevuta.setItems(mainApp.getRicevutaData());
	}
}
