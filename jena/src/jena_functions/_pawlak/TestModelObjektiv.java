package jena_functions._pawlak;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;

/** Das Objektiv Beispiel in Java Programmiert **/



public class TestModelObjektiv {
	
	
	public static void main(String[] args)
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
				objectiv.createResource(doerr + SonyHomepage));
		
		objectiv.createResource(concatStrings(doerr, Sony)).addProperty(
				objectiv.createProperty(doerr + concatStrings(hat, "Bezeichnung")), 
				objectiv.createResource(doerr + Sony));
		//allgemeineAusstattung###################################################################
		objectiv.write( System.out , "TURTLE");
	}//end main
	
	private static String concatStrings(String s1, String s2){
		return s1 + s2;
	}//end concatStrings

}//end class TestModelObjektiv
