package jena_functions;

/**************************************************************
 * FusekiConnect.java
 *
 * Project "Semantic Web"
 *  * Professor:	xxxxxxxxxxxxxx
 *  
 * This class has only one function
 * The purpose of the function is to build a connection to
 * the Fuseki-Server
 *
 *  Created on: 22.05.2014
 *      Author: Dilek Resit
**************************************************************/

/**************************************************************
 * Imports
**************************************************************/
import org.apache.jena.fuseki.FusekiCmd;

public class connect_fuseki {
	
	/**************************************************************
	 * static void connect_to_fuseki(String configPath, String pagesPath)
	 * builds a connection to the Fuseki-Server
	 * @param1 expects absolute path of "\fuseki_api\config.ttl"
	 * @param2 expects absolute path of directory "\fuseki_api\pages"
	**************************************************************/
	public static void connect_to_fuseki(String configPath, String pagesPath) {
		// Start Fuseki main
		FusekiCmd.main("--config="+configPath, "--pages="+pagesPath);
		
		// Build connection to Fuseki-Server, URL is localhost:3030, dont'forget to change Dataset to "/ds"
		FusekiCmd.main("--update", "--mem", "/ds");
	}
	
	public static void main(String[] args) {
		connect_fuseki f = new connect_fuseki();
		
		// First parameter is the absolute path of "\fuseki_ap\config.ttl", second parameter is absolute path of directory "\fuseki_api\pages"
		connect_fuseki.connect_to_fuseki("C://Users//rasheed//Desktop//fuseki_api//config.ttl", "C://Users//rasheed//Desktop//fuseki_api//pages");
	}

}

