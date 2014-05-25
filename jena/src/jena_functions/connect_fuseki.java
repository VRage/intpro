package jena_functions;
import org.apache.jena.fuseki.FusekiCmd;
/**
 * This class builds a connection to the Fuseki-Server. The URL to the main-page of the Fuseki-Server is 
 * "localohost:3030". Open a browser, type in the URL and go to the "Control Panel". Select DS as dataset. This
 * is the place where RDF will be stored and where you can execute Queries or upload RDF-files.
 * @author Dilek R.
 *
 */

public class connect_fuseki {
	
	// This is the path of the config file which is located in the fuseki-api directory
	private String path_to_config_file;
	// Path of directory "./fuseki-api/pages".
	private String path_to_pages_dir;
	
	/**
	 * This method builds the connection to the Fuseki-Server.
	 * @param configPath expects the path of the file "config.ttl". Usually this file is in the directory "./fuseki_api".
	 * @param pagesPath expects the path of directory "pages". Usually found in directory "./fuseki_api/pages".
	 */
	public static void connect_to_fuseki(String configPath, String pagesPath) {
		// Start Fuseki main
		FusekiCmd.main("--config="+configPath, "--pages="+pagesPath);
		
		// Build connection to Fuseki-Server
		FusekiCmd.main("--update", "--mem", "/ds");
	}
	
	public String getPath_to_config_file() {
		return path_to_config_file;
	}

	public void setPath_to_config_file(String s) {
		this.path_to_config_file = s;
	}

	public String getPath_to_pages_dir() {
		return path_to_pages_dir;
	}

	public void setPath_to_pages_dir(String s) {
		this.path_to_pages_dir = s;
	}
}

