package jena_functions._pawlak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.RDFS;

/** Das Objektiv Beispiel in Java Programmiert **/



public class TestModelObjektiv {
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		//############################################################
		/** benötigte Strings **/
		String Sony28_75 = "Sony_28-75mm_2,8_SAM_SAL-2875";
		String Sony      = "Sony";
		String SonyHomepage  = "http://www.sony.de/electronics/objektive/t/kameraobjektive";
		
		String allgemeineDaten = "AllgemeineDaten";
		String technischeDaten = "TechnischeDaten";
		String ausstattung     = "Ausstattung";
		
		 String hat = "hat";
		//############################################################
		//############################################################
		/** Prefixe **/
		  String doerr = "http://doerrfoto.de/rdf/";
		//############################################################
		//############################################################
		/** Instanziierungen **/
		 Model objectiv = ModelFactory.createDefaultModel();
		//############################################################
		/** Beispiel für Benutzereingabe **/
		objectiv.createResource("Subject").addProperty(
				objectiv.createProperty("praedikat"), 
				objectiv.createResource("Object"));
		
		//SONY####################################################################################
		/** Sony hat allgemeineDaten **/
		objectiv.createResource(concatStrings(doerr, Sony28_75)).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, allgemeineDaten)), 
				objectiv.createResource(doerr + concatStrings(allgemeineDaten, Sony28_75)));
		
		/** sony hat technische Daten **/
		objectiv.createResource(concatStrings(doerr, Sony28_75)).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, technischeDaten)), 
				objectiv.createResource(doerr + concatStrings(technischeDaten, Sony28_75)));
		
		/** sony hat ausstattung **/
		objectiv.createResource(concatStrings(doerr, Sony28_75)).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, ausstattung)), 
				objectiv.createResource(doerr + concatStrings(ausstattung, Sony28_75)));
		//SONY####################################################################################
		//allgemeineAusstattung###################################################################
		objectiv.createResource(concatStrings(doerr, concatStrings(allgemeineDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Hersteller")), 
				objectiv.createResource(doerr + Sony));
		
		objectiv.createResource(concatStrings(doerr, Sony)).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Homepage")), 
				SonyHomepage,
				XSDDatatype.XSDstring);
		
		objectiv.createResource(concatStrings(doerr, Sony)).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Bezeichnung")), 
				Sony,
				XSDDatatype.XSDstring);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(allgemeineDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Modellbezeichnung")), 
				"28-75 mm 2,8 SAM SAL-2875",
				XSDDatatype.XSDstring);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(allgemeineDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Gewicht")), 
				"565",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(allgemeineDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Aussendurchmesser")), 
				"77",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(allgemeineDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Laenge")), 
				"94",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(allgemeineDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Bayonettanschluss")), 
				objectiv.createResource(doerr + "SonyAF"));
		//allgemeineAusstattung###################################################################
		//technischeAusstattung###################################################################
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Filtergroesse")), 
				"67",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "BrennweiteMin")), 
				"28",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "BrennweiteMax")), 
				"75",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Lichtstaerke")), 
				"2.8",
				XSDDatatype.XSDdouble);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Naheinstellgrenze")), 
				"380",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "MaxAbbildungmassstab")), 
				"1:4,55",
				XSDDatatype.XSDstring);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "AnzahlBlendlamellen")), 
				"7",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "AnzahlLinsen")), 
				"16",
				XSDDatatype.XSDint);
		
		objectiv.createResource(concatStrings(doerr, concatStrings(technischeDaten, Sony28_75))).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "AnzahlGruppen")), 
				"14",
				XSDDatatype.XSDint);
		//technischeAusstattung###################################################################
		//Ausstattung###################################################################
		objectiv.createResource(doerr + ausstattung).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "AsphaerischeLinsen")), 
				"false",
				XSDDatatype.XSDboolean);
		
		objectiv.createResource(doerr + ausstattung).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "AutoFokus")), 
				"true",
				XSDDatatype.XSDboolean);
		
		objectiv.createResource(doerr + ausstattung).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Bildstabilisator")), 
				"false",
				XSDDatatype.XSDboolean);
		
		objectiv.createResource(doerr + ausstattung).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "EDLinsen")), 
				"false",
				XSDDatatype.XSDboolean);
		
		objectiv.createResource(doerr + ausstattung).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Innenfokusierung")), 
				"false",
				XSDDatatype.XSDboolean);
		
		objectiv.createResource(doerr + ausstattung).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Ultraschallmotor")), 
				"true",
				XSDDatatype.XSDboolean);
		//Ausstattung###################################################################
		//Subclasses###################################################################
		objectiv.createProperty(doerr + "Fotokameraobjektiv");
		objectiv.createProperty(doerr + "Zoomobjektiv");
		objectiv.createProperty("Weitwinkelobjektiv");
		
		objectiv.createResource(doerr + Sony28_75).addProperty(
				RDFS.subClassOf, 
				objectiv.createProperty(doerr + "Zoomobjektiv"));
		objectiv.createResource(doerr + Sony28_75).addProperty(
				RDFS.subClassOf, 
				objectiv.createProperty(doerr + "Weitwinkelobjektiv"));
		
		objectiv.createResource("Zoomobjektiv").addProperty(
				RDFS.subClassOf, 
				objectiv.createProperty(doerr + "Fotokameraobjektiv"));
		
		objectiv.createResource("Weitwinkelobjektiv").addProperty(
				RDFS.subClassOf, 
				objectiv.createProperty(doerr + "Fotokameraobjektiv"));
		//Subclasses###################################################################
		objectiv.write( System.out , "TURTLE");
		
		
		/** Hier kommt noch eine Speicherfunktion hin **/
		OutputStream file_turtle = new FileOutputStream("./jena/" + "beispielontologie.ttl");
		objectiv.write(file_turtle, "TURTLE");
	}//end main
	
	private static String concatStrings(String s1, String s2){
		return s1 + s2;
	}//end concatStrings

}//end class TestModelObjektiv
