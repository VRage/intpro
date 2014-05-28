package jena_functions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.http.conn.HttpHostConnectException;

import com.hp.hpl.jena.query.DatasetAccessor;
import com.hp.hpl.jena.rdf.model.Model;

/**
 * This Class writes RDF-Models from fuseki into files 
 * or print it on the console.
 * @author Jakob Nisin
 *
 */

public class ExportFromFuseki {

	DatasetAccessor accessor;
	String filepath;

	public DatasetAccessor getAccessor() {
		return accessor;
	}

	public void setAccessor(DatasetAccessor accessor) {
		this.accessor = accessor;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Constructor need an DatasetAccessor
	 * default filepath is the root-folder of this project
	 * @param accessor
	 */
	public ExportFromFuseki(DatasetAccessor accessor) {
		this.accessor = accessor;
		this.filepath = "";
	}

	/**
	 * Constructor with a changeable filepath
	 * @param accessor
	 * @param filepath
	 */
	public ExportFromFuseki(DatasetAccessor accessor, String filepath) {
		this.accessor = accessor;
		this.filepath = filepath;
	}

	/**
	 * Gets an RDF-Model from Fuseki
	 * 
	 * @return Model
	 * @throws HttpHostConnectException
	 */
	public Model getRDFModel() throws HttpHostConnectException {
		if (accessor != null)
			return accessor.getModel();
		else
			return null;
	}
//
	/**
	 * Write method, creates files in a desired folder
	 * Method can format the Models in TURTLE, XML/RDF or N-TRIPLES
	 * @param filename
	 * @param lang (TURTLE, XML/RDF, N-TRIPLES)
	 * @throws FileNotFoundException
	 * @throws HttpHostConnectException
	 */
	public void writeTo(String filename, String lang) throws FileNotFoundException, HttpHostConnectException{
		
		switch(lang.toUpperCase()){
			case "TURTLE":
				getRDFModel().write(new FileOutputStream(filepath  + filename + ".ttl"), lang);
				break;
			case "XML":				
			case "RDF":
				getRDFModel().write(new FileOutputStream(filepath  + filename + ".rdf"), lang);
				break;
			case "N-TRIPLES":
				getRDFModel().write(new FileOutputStream(filepath  + filename + ".rdf"), lang);
				break;
			default:
				System.out.println("language not supported");
				break;
		}
	}
	/**
	 * Write method displays formated Models on the console
	 * Languages supported: TURTLE, XML/RDF, N-TRIPLES
	 * @param lang
	 * @throws HttpHostConnectException
	 */
	public void writeTo(String lang) throws HttpHostConnectException
	{
		switch(lang.toUpperCase()){
		case "TURTLE":
			getRDFModel().write(System.out, lang);
			break;
		case "XML":				
		case "RDF":
			getRDFModel().write(System.out, lang);
			break;
		case "N-TRIPLES":
			getRDFModel().write(System.out, lang);
			break;
		default:
			System.out.println("language not supported");
			break;
		}
	}
}
