package application;


import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import exceptions.RDFFileExceptions.RDFFileNotFoundException;
import exceptions.RDFFileExceptions.RDFFileNotValidException;

public class SampleController {


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
	private demo_Model model;
	private ExtensionFilter extensionFilter;
	@FXML private Label label_ServerState;
	@FXML private Button btn_Connect;
	
	
	boolean Serverstate;
	
	public SampleController() {
		// TODO Auto-generated constructor stub
		model = new demo_Model();
		Serverstate=false;
	}
	
	@FXML private void btn_getFuseki(ActionEvent Event) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		label_ServerState.setText("Hallo");
	}
	@FXML private void btn_load_action(ActionEvent Event) throws RDFFileNotFoundException, RDFFileNotValidException, IOException{
		FileChooser FC = new FileChooser();
		Stage stage = new Stage();
		FC.setTitle("Open Resource File");
		File init = new File("./");
		FC.setInitialDirectory(init);
		File file = FC.showOpenDialog(stage);
		if(file != null)
			model.readRDFFile(file.getCanonicalPath());
	}
	@FXML private void btn_save_action(ActionEvent Event){
		
	}
	@FXML private void btn_connect_action(ActionEvent event){
		if(Serverstate){
			model.closeServer();
			Serverstate = false;
			SetView();
			
		}
		else{
			model.startServer();
			Serverstate = true;
			SetView();
		}//end ifelse
	}
	public void SetView(){
		if(Serverstate)
		{
			label_ServerState.setText("Server state: connected");
			//label_ServerState.backgroundProperty().set(Color.GREEN);
			btn_Connect.setText("Disconnect");
		}
		else
		{
			label_ServerState.setText("Server state: not connected");
			//label_ServerState.backgroundProperty().set(Color.GREEN);
			btn_Connect.setText("Connect");
		}
	}
}
