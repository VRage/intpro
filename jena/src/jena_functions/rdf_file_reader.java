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

import exceptions.RDFFileExceptions.RDFFileNotFoundException;
import exceptions.RDFFileExceptions.RDFFileNotValidException;

public class rdf_file_reader{
	
	/*********************************************************************
	 * read_file(filename, path)
	 * opens an existing RDF-file and reads the content into a rdf-model object + returning this model to caller
	 * @param filepath > the filepath to the file
	 * 				   > relative paths must be in the same root directory 
	 *                   as the rdf_file_reader class. the representative shortcut 
	 *                   for the root-directory is "./" followed by subfolders
	 *                   "./subfolderexample/subsubfolderexample/"
	 **********************************************************************/
	public static Model read_file(String filepath) 
			throws RDFFileNotFoundException, RDFFileNotValidException {
		
		//creating Inputstream to valid file existence
		InputStream in  = FileManager.get().open(filepath);
		
		if(in == null){
			throw new RDFFileNotFoundException("File not found in: " + filepath);
		}//end if(in == null)
		
		//creating and returning the model to the caller
		try{
			return ModelFactory.createDefaultModel().read(filepath);
		}
		catch (RiotException e){
			throw new RDFFileNotValidException();
		}
		
		
	}//end method open_file(filename, path)
}//end class
