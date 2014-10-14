package TEST_AREA;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import _BASIC_MODEL.BASIC_FUSEKI_CONNECT;
import _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS.NoPagesDirException;
import _GLOBAL.currLANG;

/** Controler-Plugin for  the Fuseki GUI **/
public class controler {

	private BASIC_FUSEKI_CONNECT model;
	private currLANG currLang;
	private view view;
	private String DEFAULT_DATASET = "/ds";
	private String DEFAULT_PAGEDIR = "./fuseki_api/pages";
	private String DEFAULT_LOGPROPPATH = "./fuseki_api/log4j.properties";
	private String DATASET;
	private String PAGEDIR;
	private String LOGPROPPATH;
	// just fpr the ErrorMsg dialog
	private JFrame errorFrame = new JFrame();
	
	public controler(){
		this.DATASET = DEFAULT_DATASET;
		this.LOGPROPPATH = DEFAULT_LOGPROPPATH;
		this.PAGEDIR = DEFAULT_PAGEDIR;
		
		this.currLang = new currLANG();
		this.model = createNewModel();
		this.view = new view(this);
	}
	
	public void start(){
		view.showView();
	}
	
	public currLANG getLang(){
		return this.currLang;
	}
	
	private BASIC_FUSEKI_CONNECT createNewModel(){
		try {
			return new BASIC_FUSEKI_CONNECT(DATASET, PAGEDIR, LOGPROPPATH);
		} catch (NoPagesDirException e) {
			JOptionPane.showMessageDialog(errorFrame, currLang.getCurrLang().ERROR_NOPAGEDIR);
			return null;
		}
	}
}
