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
    private TextArea txtAreaLog;

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
    	long start = System.nanoTime();
    	
    	String sel = txtResult.getSelectedText();
    	if (this.elenco.cancella(sel)) {
    		txtResult.extendSelection(txtResult.getSelection().getEnd() + 1);
    		txtResult.replaceSelection("");
    	}
    	
    	long end = System.nanoTime();
    	txtAreaLog.appendText("cancella: " + Long.toString(end - start) + "ns\n");
    	
    }
    
    @FXML
    void doInsert(ActionEvent event) {
    	long start = System.nanoTime();
    	
    	String add = txtParola.getText();
    	if (add.length() == 0) {
    		return;
    	} else {
    		elenco.addParola(add);
    		txtResult.setText("");
    		for (String s: elenco.getElenco()) {
	    		txtResult.setText(txtResult.getText() + s + "\n");
	    		txtParola.setText("");
    		}
    	}
    	
    	long end = System.nanoTime();
    	txtAreaLog.appendText("inserimento: " + Long.toString(end - start) + "ns\n");


    }

    @FXML
    void doReset(ActionEvent event) {
    	long start = System.nanoTime();
 
    	txtResult.setText("");
    	elenco.reset();
    	
    	long end = System.nanoTime();
    	txtAreaLog.appendText("reset: " + Long.toString(end - start) + "ns\n");

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaLog != null : "fx:id=\"txtAreaLog\" was not injected: check your FXML file 'Scene.fxml'.";
        
        txtResult.setEditable(false);
        elenco = new Parole() ;
    }
}
