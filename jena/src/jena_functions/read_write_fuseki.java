package jena_functions;

/**************************************************************
 * accessFuseki.java
 *
 * Project "Semantic Web"
 * This class has two function
 * 1. Function gets the RDF-Model which is stored in Fuseki
 * 2. Function stores a RDF-Model into the Fuseki
 * Professor:	xxxxxxxxxxxxxx
 *
 *  Created on: 21.05.2014
 *      Author: Dilek Resit
**************************************************************/

/**************************************************************
 * Imports
**************************************************************/
import java.io.InputStream;

import org.apache.http.conn.HttpHostConnectException;
import com.hp.hpl.jena.query.DatasetAccessor;
import com.hp.hpl.jena.query.DatasetAccessorFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

public class read_write_fuseki {
	
	/**************************************************************
	 * Model get_RDF_from_Fuseki()
	 * accesses the Fuseki and gets the current RDF-Model stored in it
	 * RDF-Model can then be edited, extended etc. (Needs further implementation for this)
	 * @return current RDF-Model from Fuseki
	 * @throws HttpHostConnectException 
	**************************************************************/
	public Model get_RDF_from_Fuseki() throws HttpHostConnectException {
		
		// create accessor for the Fuseki
		DatasetAccessor d = DatasetAccessorFactory.createHTTP("http://localhost:3030/ds/data");
	
		// store RDF-data into RDF-model
		Model m = d.getModel();
		
//		// Test print RDF-model to console, can also be saved into a File with the Read-/Write-method --> Needs further implementation for this
//		m.write(System.out, "TURTLE");

		// return RDF-model
		return m;
	}
	
	/**************************************************************
	 * static void store_RDF_to_Fuseki(Model m)
	 * stores a RDF-Model into the Fuseki
	 * @param expects a RDF-Model
	 * @throws HttpHostConnectException 
	**************************************************************/
	public static void store_RDF_to_Fuseki(Model m) throws HttpHostConnectException{
		// create an accessor for the Fuseki
		DatasetAccessor d = DatasetAccessorFactory.createHTTP("http://localhost:3030/ds/data");
		
		// add RDF-mpdel to Fuseki
		d.add(m);
	}
	
	public static void main(String[] args) {
		read_write_fuseki a = new read_write_fuseki();
		
//		// Test to get RDF-model from Fuseki
//		try {
//			a.get_RDF_from_Fuseki();
//		} catch (HttpHostConnectException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// Test to store RDF-model to Fuseki
		try {
			// Open a RDF-data and store the content to Fuseki (Test)
			String filename = "C://Users//rasheed//Desktop//eclipse//workspace//jena//camera.owl";
			Model m = ModelFactory.createDefaultModel();
			InputStream in = FileManager.get().open(filename);
			m.read(in, "");
			
			read_write_fuseki.store_RDF_to_Fuseki(m);
		} catch (HttpHostConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

