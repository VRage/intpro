package application;





import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import org.apache.commons.io.FilenameUtils;
import org.apache.http.conn.HttpHostConnectException;

import exceptions.RDFFileExceptions.RDFFileNotFoundException;
import exceptions.RDFFileExceptions.RDFFileNotValidException;
import exceptions.fuseki_exceptions.NoDatasetAccessorException;

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
	private ExtensionFilter saveExtensionFilter;
	private ExtensionFilter loadExtensionFilter;
	@FXML private Label label_ServerState;
	@FXML private Button btn_Connect;
	@FXML private javafx.scene.control.Button closeButton;
	@FXML private Button btn_load;
	@FXML private Button btn_save;
	@FXML private TextArea txtField_SendQuery;
	@FXML private Label label_GetQuery;

	
	
	boolean Serverstate;
	
	public SampleController() {
		// TODO Auto-generated constructor stub
		btn_load = new Button();
		btn_save = new Button();
		btn_Connect = new Button();
		
		label_GetQuery = new Label();
		txtField_SendQuery = new TextArea();
		
		model = new demo_Model();
		label_ServerState= new Label();
		Serverstate=false;
		saveExtensionFilter = new ExtensionFilter("Dataextensions", "*.ttl", "*.rdf", "*.nt");
		loadExtensionFilter = new ExtensionFilter("Dataextensions",  "*.ttl", "*.rdf", "*.nt", "*.owl");
		btn_save.setDisable(true);
		SetView();
	
	}
	@FXML
	private void closeButtonAction(){
	    // get a handle to the stage
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	@FXML private void btn_getFuseki(ActionEvent Event) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		label_ServerState.setText("Hallo");
	}
	@FXML private void btn_load_action(ActionEvent Event) throws RDFFileNotFoundException, RDFFileNotValidException, IOException{
		FileChooser FC = new FileChooser();
		FC.getExtensionFilters().add(loadExtensionFilter);
		FC.setSelectedExtensionFilter(loadExtensionFilter);
		Stage stage = new Stage();
		FC.setTitle("Open Resource File");
//		File init = new File("./");
//		FC.setInitialDirectory(init);
		File file = FC.showOpenDialog(stage);
		if(file != null)
			model.readRDFFile(file.getCanonicalPath());
	}
	@FXML private void btn_save_action(ActionEvent Event) throws IOException{
		FileChooser FC = new FileChooser();
		Stage stage = new Stage();
		FC.setTitle("Save Resource File");
		FC.getExtensionFilters().add(saveExtensionFilter);
		FC.setSelectedExtensionFilter(saveExtensionFilter);
		File init = new File("./");
		FC.setInitialDirectory(init);
		File file = FC.showSaveDialog(stage);
		String ending = setRDFType(FilenameUtils.getExtension(file.getCanonicalPath()));
		System.out.println(ending);
		if (file != null || ending == null){
			model.safeRDFFile(file.getCanonicalPath(), file.getName(), ending);
		}
		
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
	
	/** Hilfsmethoden **/
	private String setRDFType(String ending){
		switch(ending){
		case "ttl":
			return "TURTLE";
		case "rdf":
			return "RDF/XML";
		case "nt":
			return "N-TRIPLES";
		default:
			return "ttl";
		}//end switch
	}//end setRDFTYPE
	public void SetView(){
		if(Serverstate)
		{
			label_ServerState.setText("Server state: connected");
			label_ServerState.setTextFill(Paint.valueOf("#00AA00"));
			btn_Connect.setText("Disconnect");
			btn_save.disableProperty().set(false);
			btn_load.disableProperty().set(false);
			
		}
		else
		{
			label_ServerState.setText("Server state: not connected");
			label_ServerState.setTextFill(Paint.valueOf("#AA0000"));
			btn_Connect.setText("Connect");
			btn_save.disableProperty().set(true);
			btn_load.disableProperty().set(true);
		}
	}
	@FXML private void sendQuery(){
	
		try {
			label_GetQuery.setText(model.getQuery(txtField_SendQuery.getText()));
		} catch (HttpHostConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDatasetAccessorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	/	label_GetQuery.setText("Hallo");
		
	}
}
