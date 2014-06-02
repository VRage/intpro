package application;

import java.io.FileNotFoundException;
import java.util.Observable;

import org.apache.http.conn.HttpHostConnectException;

import jena_functions.ExportFromFuseki;
import jena_functions.ImportToFuseki;
import jena_functions.fuseki_connector;
import jena_functions.rdf_file_reader;
import jena_functions.sparql01;

import com.hp.hpl.jena.query.DatasetAccessor;
import com.hp.hpl.jena.rdf.model.Model;

import exceptions.RDFFileExceptions.RDFFileNotFoundException;
import exceptions.RDFFileExceptions.RDFFileNotValidException;
import exceptions.fuseki_exceptions.NoDatasetAccessorException;
import exceptions.fuseki_exceptions.NoDatasetGraphException;
import exceptions.fuseki_exceptions.NoPagesDirException;
import exceptions.fuseki_exceptions.NoServerConfigException;

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
	
	private Model RDFModel;
	private fuseki_connector server;
	private ImportToFuseki imp;
	private ExportFromFuseki exp;
	
	public demo_Model(){
		try {
			server = new fuseki_connector("/ds", "./fuseki_api/pages", "./fuseki_api/log4j.properties");
		} catch (NoPagesDirException e) {
			/***********************************
			 * HIER MUSS NOCH NE FEHLERBEHANLDUNG REIN!
			 ************************************/
			e.printStackTrace();
		}//end try/catch
		
		imp = new ImportToFuseki(getAccessor(), RDFModel);
		exp = new ExportFromFuseki(getAccessor());
		
		
	}//end constructor
	
	
	/*********************************************************************
	 * startServer()
	 * starts the demo fuseki server
	 **********************************************************************/
	public void startServer(){
		try {
			server.start();
		} catch (NoDatasetGraphException e) {
			/***********************************
			 * HIER MUSS NOCH NE FEHLERBEHANLDUNG REIN!
			 ************************************/
			e.printStackTrace();
		} catch (NoServerConfigException e) {
			/***********************************
			 * HIER MUSS NOCH NE FEHLERBEHANLDUNG REIN!
			 ************************************/
			e.printStackTrace();
		}
	}//end startServer()
	
	
	
	
	/*********************************************************************
	 * readRDFFile(filename, path)
	 * calls the read_file function of the class rdf_file_reader and stores the return value
	 * in the RDFModel + imports the file to the connected server
	 * @param filepath >the path to the rdf file
	 * 				   > relative paths must be in the same root directory 
	 *                   as the rdf_file_reader class. the representative shortcut 
	 *                   for the root-directory is "./" followed by subfolders
	 *                   "./subfolderexample/subsubfolderexample/"
	 **********************************************************************/
	public void readRDFFile(String filepath) throws RDFFileNotFoundException, RDFFileNotValidException{
		RDFModel = rdf_file_reader.read_file(filepath);
		imp.setRdfdata(RDFModel);
		imp.setAccesor(getAccessor());
		try {
			imp.storeToFuseki();
		} catch (HttpHostConnectException e) {
			/***********************************
			 * HIER MUSS NOCH NE FEHLERBEHANLDUNG REIN!
			 ************************************/
			e.printStackTrace();
		}
		
	}//end readRDFFile(filename, path)
	
	
	/*********************************************************************
	 * getQuery(query)
	 * @param filepath >the path to the rdf file
	 * 				   > relative paths must be in the same root directory 
	 *                   as the rdf_file_reader class. the representative shortcut 
	 *                   for the root-directory is "./" followed by subfolders
	 *                   "./subfolderexample/subsubfolderexample/"
	 * @throws HttpHostConnectException 
	 * @throws NoDatasetAccessorException 
	 **********************************************************************/
	public String getQuery(String query) throws HttpHostConnectException, NoDatasetAccessorException{
		return sparql01.query01(query, server.getAccessor().getModel());
	}//end getQuery
	
	/*********************************************************************
	 * safeRDFFile(filePath, filename, filetype)
	 * safes the current rdf model from the fuseki server into a given file with
	 * a given scheme (turtle, owl etc.)
	 * @param filePath > the folder where the file shall be safed
	 * @param filename > the filename of the new to be created file
	 * @param filytype > the name of the ontologie of the outputfile
	 **********************************************************************/
	public void safeRDFFile(String filePath, String filename, String filetype){
//		exp.setFilepath(filePath);
		try {
			exp.writeTo(filename, filetype);
		} catch (HttpHostConnectException e) {
			/***********************************
			 * HIER MUSS NOCH NE FEHLERBEHANLDUNG REIN!
			 ************************************/
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			/***********************************
			 * HIER MUSS NOCH NE FEHLERBEHANLDUNG REIN!
			 ************************************/
			e.printStackTrace();
		}
	}//end safeRDFFile(savePath)
	
	/*********************************************************************
	 * closeServer()
	 * shut down the demo server
	 **********************************************************************/
	public void closeServer(){
		server.stop();
	}
	
	
	//######################################################################
	//getter and setter methods
	public Model getRDFModel(){
		return this.RDFModel;
	}//end getRDFModel
	//######################################################################
	private DatasetAccessor getAccessor(){
		try {
			return server.getAccessor();
		} catch (NoDatasetAccessorException e) {
			/***********************************
			 * HIER MUSS NOCH NE FEHLERBEHANLDUNG REIN!
			 ************************************/
			e.printStackTrace();
		}
		return null;
	}
	
}//end class
