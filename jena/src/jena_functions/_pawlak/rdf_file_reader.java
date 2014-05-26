package jena_functions._pawlak;

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
import com.hp.hpl.jena.rdf.model.ModelFactoryBase;
import com.hp.hpl.jena.util.FileManager;

public class rdf_file_reader{
	
	
	
	//file-path related strings
	private static String ROOT_PATH = "./";
	
	/*********************************************************************
	 * read_file(filename, path)
	 * opens an existing RDF-file and reads the content into a rdf-model object + returning this model to caller
	 * @param filename > string with the name of the rdf-file to open
	 * @param path     > string with the absolute or relative path of the rdf-file
	 * 				   > relative paths must be in the same root directory 
	 *                   as the rdf_file_reader class. the representative shortcut 
	 *                   for the root-directory is "./" followed by subfolders
	 *                   "./subfolderexample/subsubfolderexample/"
	 **********************************************************************/
	public static Model read_file(String filename, String path) throws IllegalArgumentException, RiotException {
		//creating file path with filename string
		String filepath = path + filename;
		
		//creating Inputstream to valid file existence
		InputStream in  = FileManager.get().open(filepath);
		
		if(in == null){
			throw new IllegalArgumentException("File not found in:\n" 
												+"Path " + path + "\n"  
												+"Filename: " + filename);
		}//end if(in == null)
		
		//creating and returning the model to the caller
		return ModelFactory.createDefaultModel().read((filepath) , null);
	}//end method open_file(filename, path)
	
	
	/*********************************************************************
	 * read_file(filename)
	 * opens an existing RDF-file which is placed in the root-folder or an default-safe-path
	 * and reads the content into a rdf-model object
	 * @param filename > string with the name of the rdf-file to open
	 **********************************************************************/
	public static Model read_file(String filename) throws IllegalArgumentException, RiotException{
		return read_file(filename, ROOT_PATH);
	}//end method open_file(filename)
	
	/*********************************************************************
	 * set_ROOT_PATH(path)
	 * sets the ROOT_PATH attribute to the given path
	 * for example to set a default read and safe directory for the RDF Files
	 * the default ROOT_PATH is the project root-directory "./"
	 * @param path - the new default path to the rdf files.
	 *********************************************************************/
	public static void set_ROOT_PATH(String path){
		ROOT_PATH = path;
	}//end set_ROOT_PATH(path)
}//end class
