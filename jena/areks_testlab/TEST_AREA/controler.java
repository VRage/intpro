package TEST_AREA;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import _BASIC_MODEL.BASIC_FUSEKI_CONNECT;
import _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS.NoPagesDirException;
import _GLOBAL.enEN;

public class controler {

	/** Model **/
	private BASIC_FUSEKI_CONNECT model;
	
	/** VIEW **/
	private view view;
	
	/** DEFAULTS **/
	private String DEFAULT_DATASET = "/ds";
	private String DEFAULT_PAGEDIR = "./fuseki_api/pages";
	private String DEFAULT_LOGPROPPATH = "./fuseki_api/log4j.properties";
	
	/** CUSTOM PROP **/
	private String DATASET;
	private String PAGEDIR;
	private String LOGPROPPATH;
	
	/** ERRORHANDLING **/
	JFrame frame = new JFrame();
	
	public controler(){
		this.DATASET = DEFAULT_DATASET;
		this.LOGPROPPATH = DEFAULT_LOGPROPPATH;
		this.PAGEDIR = DEFAULT_PAGEDIR;
		
		model = createNewModel();
	}
	
	private BASIC_FUSEKI_CONNECT createNewModel(){
		try {
			return new BASIC_FUSEKI_CONNECT(DATASET, PAGEDIR, LOGPROPPATH);
		} catch (NoPagesDirException e) {
			JOptionPane.showMessageDialog(frame, enEN.ERROR_NOPAGEDIR);
			return null;
		}
	}
}
