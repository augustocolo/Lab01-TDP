package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;

    @FXML
    void doCancella(ActionEvent event) {
    	String sel = txtResult.getSelectedText();
    	if (this.elenco.cancella(sel)) {
    		txtResult.extendSelection(txtResult.getSelection().getEnd() + 1);
    		txtResult.replaceSelection("");
    	}
    }
    
    @FXML
    void doInsert(ActionEvent event) {
    	String add = txtParola.getText();
    	if (add.length() == 0) {
    		return;
    	} else {
    		elenco.addParola(add);
    		txtResult.setText(txtResult.getText() + add + "\n");
    		txtParola.setText("");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	elenco.reset();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        
        txtResult.setEditable(false);
        elenco = new Parole() ;
    }
}
