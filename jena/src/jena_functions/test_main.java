package jena_functions;

import java.io.FileNotFoundException;
import org.apache.http.conn.HttpHostConnectException;
import com.hp.hpl.jena.rdf.model.Model;
import exceptions.RDFFileExceptions.RDFFileNotFoundException;
import exceptions.RDFFileExceptions.RDFFileNotValidException;
import exceptions.fuseki_exceptions.NoDatasetAccessorException;
import exceptions.fuseki_exceptions.NoDatasetGraphException;
import exceptions.fuseki_exceptions.NoPagesDirException;
import exceptions.fuseki_exceptions.NoServerConfigException;

/**
 * Main-Method to test the fuseki-server.
 * @author rasheed
 *
 */
public class test_main {
	
	public static void main(String[] args) {
		try {
			// Create an object of type fuseki_connector.
			fuseki_connector c = new fuseki_connector("/ds", "./fuseki_api/pages", "./fuseki_api/log4j.properties");
			// start the server
			c.start();
			
			// read a RDF-file and store the content into the fuseki-server.
			Model m = rdf_file_reader.read_file("./camera.owl");
			//Model m = rdf_file_reader.read_file("./books.ttl");
			ImportToFuseki i = new ImportToFuseki(c.getAccessor(), m);
			i.storeToFuseki();
			
			// Export the content of fuseki-server into a file.
			ExportFromFuseki e = new ExportFromFuseki(c.getAccessor(), "./fuseki_api/");
			e.writeTo("test", "TURTLE");
			
			// Sending a sparql query with the class "sparql01"
			sparql01 sparql01 = new sparql01();
			String query;
			
			//query = "PREFIX asd:<http://www.semanticweb.org/rasheed/ontologies/2014/4/untitled-ontology-26#> SELECT ?y WHERE { asd:Adapter ?y ?x }";
			//query = "PREFIX asd:<http://www.semanticweb.org/rasheed/ontologies/2014/4/untitled-ontology-26#> SELECT ?asd:Adapter WHERE { ?asd:Adapter ?y ?x }";
			query = "PREFIX asd:<http://www.semanticweb.org/rasheed/ontologies/2014/4/untitled-ontology-26#> SELECT ?y ?z WHERE {asd:Adapter ?y ?z}";
			//query = "SELECT * WHERE { ?x ?y ?z }";
			//query = "test";
			
			System.out.println(sparql01.query01(query, m));
			
		} catch (NoPagesDirException | NoDatasetGraphException | NoServerConfigException | RDFFileNotFoundException | RDFFileNotValidException | NoDatasetAccessorException | HttpHostConnectException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
