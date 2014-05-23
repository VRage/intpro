package jena_functions;

/**************************************************************
 * rdf_file_reader.java
 *
 * Project "Semantic Web"
 *  * Professor:	xxxxxxxxxxxxxx
 *  
 * this class has two functions:
 * > it reads an existing rdf-file from a given path
 * > it returns a rdf-model object based in the rdf-file 
 *   for further actions
 *
 * this class doesn't manipulate the reloaded informations
 * 
 * Exceptions that can occure in this class: 
 * > IllegalArgumentException - when the given path or filename doesn't exist
 * > RiotException            - when the given file isn't a vaild rdf-file
 * 
 * 
 *  Created on: 23.05.2014
 *      Author: Arkadius Pawlak
**************************************************************/

/**************************************************************
 * Imports
**************************************************************/
import java.io.InputStream;

import org.apache.jena.riot.RiotException;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

public class rdf_file_reader{
	
	
	
	//file-path related strings
	private String path;
	private String filename;
	private final String ROOT_PATH;
	
	//attributes
	private Model model;
	private InputStream in;
	
	//default-constructor
	public rdf_file_reader(){
		this.ROOT_PATH = "./";
		this.model     = ModelFactory.createDefaultModel();
	}//end constructor rdf_file_reader()
	
	/*********************************************************************
	 * read_file(filename, path)
	 * opens an existing RDF-file and reads the content into a rdf-model object
	 * @param filename > string with the name of the rdf-file to open
	 * @param path     > string with the absolute or relative path of the rdf-file
	 * 				   > relative paths must be in the same root directory 
	 *                   as the rdf_file_reader class. the representative shortcut 
	 *                   for the root-directory is "./" followed by subfolders
	 *                   "./subfolderexample/subsubfolderexample/"
	 **********************************************************************/
	public void read_file(String filename, String path) throws IllegalArgumentException, RiotException {
		this.path     = path;
		this.filename = filename;
		String filepath = path + filename;
		this.in       = FileManager.get().open(filepath);
		
		if(in == null){
			throw new IllegalArgumentException("File not found in:\n" 
												+"Path " + path + "\n"  
												+"Filename: " + filename);
		}//end if(in == null)
		
		model.read((this.path + this.filename) , null);
	}//end method open_file(filename, path)
	
	
	/*********************************************************************
	 * read_file(filename)
	 * opens an existing RDF-file which is placed in the root-folder
	 * and reads the content into a rdf-model object
	 * @param filename > string with the name of the rdf-file to open
	 **********************************************************************/
	public void read_file(String filename) throws IllegalArgumentException, RiotException{
		read_file(filename, ROOT_PATH);
	}//end method open_file(filename)
	
	
	public Model get_RDFModel(){
		return this.model;
	}//end method getRDFModel()
	
}
