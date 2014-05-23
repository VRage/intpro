package jena_functions;

import com.hp.hpl.jena.query.DatasetAccessor;
import com.hp.hpl.jena.rdf.model.Model;

public class ImportToFuseki {
	
	private DatasetAccessor accesor;
	private Model rdfdata;
	
	public ImportToFuseki(DatasetAccessor accesor, Model rdfdata) {
		this.accesor = accesor;
		this.rdfdata = rdfdata;
	}

	public DatasetAccessor getAccesor() {
		return accesor;
	}

	public void setAccesor(DatasetAccessor accesor) {
		this.accesor = accesor;
	}

	public Model getRdfdata() {
		return rdfdata;
	}

	public void setRdfdata(Model rdfdata) {
		this.rdfdata = rdfdata;
	}
	
	public void storeToFuseki() 
	{
		if(accesor != null && rdfdata != null)
			accesor.add(rdfdata);
		else
			System.out.println("No Model or serveraccessor added");
	}

}
