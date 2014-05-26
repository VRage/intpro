package demo_jena_functions;

import java.util.Observable;

import jena_functions.rdf_file_reader;

import com.hp.hpl.jena.rdf.model.Model;

import exceptions.RDFFileExceptions.RDFFileNotFoundException;
import exceptions.RDFFileExceptions.RDFFileNotValidException;

/**************************************************************
 * demo_Model
 *
 * Project "Semantic Web"
 *  * Professor:	xxxxxxxxxxxxxx
 *  
 * This is the model (MVC-scheme) for our 1st java-demo
 * 
 *  Created on: 26.05.2014
 *      Author: Arkadius Pawlak
**************************************************************/
public class demo_Model extends Observable{
	
	Model RDFModel;
	
	
	/*********************************************************************
	 * readRDFFile(filename, path)
	 * calls the read_file function of the class rdf_file_reader and stores the return value
	 * in the RDFModel
	 * @param filepath >the path to the rdf file
	 * 				   > relative paths must be in the same root directory 
	 *                   as the rdf_file_reader class. the representative shortcut 
	 *                   for the root-directory is "./" followed by subfolders
	 *                   "./subfolderexample/subsubfolderexample/"
	 **********************************************************************/
	public void readRDFFile(String filepath) throws RDFFileNotFoundException, RDFFileNotValidException{
		RDFModel = rdf_file_reader.read_file(filepath);
	}//end readRDFFile(filename, path)
	
	
	//######################################################################
	//getter and setter methods
	public Model getRDFModel(){
		return this.RDFModel;
	}//end getRDFModel
	//######################################################################
	
}//end class
