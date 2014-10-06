package _BASIC_MODEL;

import java.util.Observable;

import org.apache.jena.atlas.lib.FileOps;
import org.apache.jena.fuseki.server.FusekiConfig;
import org.apache.jena.fuseki.server.SPARQLServer;
import org.apache.jena.fuseki.server.ServerConfig;
import org.apache.log4j.PropertyConfigurator;

import _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS.NoDatasetAccessorException;
import _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS.NoDatasetGraphException;
import _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS.NoPagesDirException;
import _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS.NoServerConfigException;

import _GLOBAL.*;

import com.hp.hpl.jena.query.DatasetAccessor;
import com.hp.hpl.jena.query.DatasetAccessorFactory;
import com.hp.hpl.jena.sparql.core.DatasetGraph;
import com.hp.hpl.jena.sparql.core.DatasetGraphFactory;


/**
 * This class builds a connection to the Fuseki-Server. The default URL to the main-page of the Fuseki-Server is 
 * "localhost:3030". Open a browser, type in the URL and go to "Control Panel" and select your dataset to access RDF-Files and RDF-models. 
 * This is the place where RDF will be stored and where you can execute Queries or upload RDF-files.
 * @author Dilek R.
 * @modified Arkadius Pawlak
 */

public class BASIC_FUSEKI_CONNECT extends Observable{
	
	// DatasetAccessor - used to access RDF-files
	private DatasetAccessor ds_accessor;
	// Server configuration file
	private ServerConfig server_conf;
	// Default dataset graph
	private DatasetGraph ds_graph;
	private SPARQLServer sparql_server;
	// log file - logs errors, warns, history of fuseki.
	private String log_property_path;
	//private PropertyConfigurator prop_conf; probably used later
	
	/**
	 * This is a constructor to access the fuseki-server. 
	 * @param dataset This is a temporary path of the location where you will find datasets. Set it to "/ds" if you don't know what to add here.
	 * @param page_dir_path This is the path of the directory "pages" which is located in your fuseki-api.
	 * @param log_property_path The path of the log4j.properties which is located in your fuseki_api.
	 * @throws NoPagesDirException Throw an exception in case of wrong pages directory.
	 */
	public BASIC_FUSEKI_CONNECT(String dataset, String page_dir_path, String log_property_path) throws NoPagesDirException {
		this.log_property_path = log_property_path;
		PropertyConfigurator.configureAndWatch(this.log_property_path);
		
		ds_graph = DatasetGraphFactory.createMem();
		ds_accessor = DatasetAccessorFactory.create(this.ds_graph);
		server_conf = FusekiConfig.defaultConfiguration(dataset, ds_graph, true, true);
		server_conf.pages = page_dir_path;
		
		if(! FileOps.exists(server_conf.pages))
			throw new NoPagesDirException("No pages directory path set.");
	}
	
	/**
	 * This method returns an Accessor for your RDF-files.
	 * @return ds_accessor Accessor for your RDF-files or RDF-models
	 * @throws NoDatasetAccessorException Throws an Exception if no data-accessor found.
	 */
	public DatasetAccessor getAccessor() throws NoDatasetAccessorException {
		if(this.ds_accessor == null)
			throw new NoDatasetAccessorException("No DatasetAccessor created.");
		return ds_accessor;
	}
	
	/**
	 * This method will give you the current configurations of the fuseki-server.
	 * @return server_conf Configuration file of fuseki-server.
	 */
	public ServerConfig getServerConf() {
		return server_conf;
	}
	
	/**
	 * This method returns the DatasetGraph of the fuseki-server (location of your RDF-files etc.)
	 * @return ds_graph Default dataset-graph.
	 */
	public DatasetGraph getDatasetGraph() {
		return ds_graph;
	}

	/**
	 * This method starts the fuseki-server until it is being stopped.
	 * @throws NoDatasetGraphException throws an exception if no dataset-graph found.
	 * @throws NoServerConfigException throws an exception if no server-configuration file found.
	 */
	public void start() throws NoDatasetGraphException, NoServerConfigException {
		if(getDatasetGraph() == null)
			throw new NoDatasetGraphException("No default DatasetGraph created.");
		if(getServerConf() == null)
			throw new NoServerConfigException("No server configuration file.");
		this.sparql_server = new SPARQLServer(server_conf);
		sparql_server.start();
		notifyObservers(MVC_PARAM.FUSEKI_START);
	}
	
	public void stop() {
		sparql_server.stop();
		notifyObservers(MVC_PARAM.FUSEKI_STOP);
	}
}

