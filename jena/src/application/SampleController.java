package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SampleController {

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * Controller controlls GUI Elements.
	 * 
	 * To make reference on objects @FXML syntax is needed 
	 * every object is named after their type seperated with _ and additionaly an sencemaking name
	 * 
	 * actual defined types: 
	 * txtfield_input
	 * label_output
	 * btn_getFuseki
	 * btn_WriteFuseki
	 */
	@FXML private Label label_ServerState;
	
	@FXML private void btn_getFuseki(ActionEvent Event) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		label_ServerState.setText("Hallo");
	}
	
}
