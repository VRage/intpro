package jena_functions;

/**************************************************************
 * test1_readRDF.java
 *
 * MProjekt "Semantic Web"
 * Read-Method for RDF-Files (.owl, .ttl, .rdf, .nt)
 * Professor:	xxxxxxxxxxxxxx
 *
 *  Created on: 19.05.2014
 *      Author: Dilek Resit
**************************************************************/

/**************************************************************
 * Imports
**************************************************************/
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

public class read_rdf {
	
	/**************************************************************
	 * static void read_from_file(String filename)
	 * reads a RDF-File and prints the contents to console in
	 * different Format (Turtle, RDF/XML, N-Triples)
	 * @param expects the file name
	**************************************************************/
	public static void read_from_file(String filename) {
		// create RDF-Model
		Model m = ModelFactory.createDefaultModel();
		// provide a inputstream
		InputStream in = FileManager.get().open(filename);

		// file does not exist --> exception
		if(in == null) {
			throw new IllegalArgumentException("File: " + filename + "not found"); 
		}
		
		// file exists --> save content in RDF-Model
		m.read(in, "");
		
//		// 1. Print Model to console, either in XML-, N-Triple- oder TURTLE-Format, SELECT ONLY 1 OPTION
//		m.write(System.out, "RDF/XML");
//		m.write(System.out, "N-TRIPLES");
//		m.write(System.out, "TURTLE");
		
		// 2. Save RDF-Model directly to a file, select file format(Turtle, RDF/XML etc.), CHANGE DESTINATION
		String file_dest = "./jena/";
		try {
			OutputStream file_turtle = new FileOutputStream(file_dest + "file_turtle.ttl");
			OutputStream file_xml = new FileOutputStream(file_dest + "file_xml.rdf");
			OutputStream file_ntriples = new FileOutputStream(file_dest + "file_ntriples.nt");
			m.write(file_turtle, "TURTLE");
			m.write(file_xml, "RDF/XML");
			m.write(file_ntriples, "N-TRIPLES");
			m.write(System.out, "TURTLE");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		
		// absolute path of the file
		// example: "C://Users/YOURNAME//Desktop//jena_tests//camera.owl
		String file = "./camera.owl";
		read_from_file(file);
	}

}

