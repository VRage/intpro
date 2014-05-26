package jena_functions;

import com.hp.hpl.jena.query.DatasetAccessor;
import com.hp.hpl.jena.rdf.model.Model;

/**
 * Let you import a rdf-file into a Fuseki Server
 * 
 * @author Jakob Nisin
 *
 */

public class ImportToFuseki {
	
	private DatasetAccessor accessor;
	private Model rdfdata;
	
	/**
	 * This let you handle DatasetAccessor and a Model gained from other Classes
	 * 
	 * @param accesor
	 * @param rdfdata
	 */
	
	public ImportToFuseki(DatasetAccessor accesor, Model rdfdata) {
		this.accessor = accesor;
		this.rdfdata = rdfdata;
	}

	//getter- and setter Methods 
	public DatasetAccessor getAccesor() {
		return accessor;
	}

	public void setAccesor(DatasetAccessor accesor) {
		this.accessor = accesor;
	}

	public Model getRdfdata() {
		return rdfdata;
	}

	public void setRdfdata(Model rdfdata) {
		this.rdfdata = rdfdata;
	}
	
	
	/**
	 * Add a rdfdata model into your fuseki server
	 */
	public void storeToFuseki() 
	{
		if(accessor != null && rdfdata != null)
			accessor.add(rdfdata);
		else
			System.out.println("No model or serveraccessor added");
	}

}
