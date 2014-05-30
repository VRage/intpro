package jena_functions;

import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.*;
import java.util.*;
import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.*;
import com.hp.hpl.jena.reasoner.*;
import com.hp.hpl.jena.sparql.engine.binding.*;

public class sparql01 {
	
	public static String query01(String queryString, Model m)
	{
		System.out.println("###############################################\n");
		System.out.println("proceeding your query:\n\""+queryString+"\"");
		
		//OntModel onto = ModelFactory.createOntologyModel(
        //       OntModelSpec.OWL_MEM, null );
		
		//Reasoner reasoner = ReasonerRegistry.getOWLMiniReasoner();
		
		//reasoner = reasoner.bindSchema (onto);
		
		//Model instances = ModelFactory.createDefaultModel();
		//Model model = ModelFactory.createDefaultModel();
		//Model model = m;
		
//		instances.read ("file:art.n3", "N3");
//		instances.read ("file:camera.owl");
		
		//InfModel model = ModelFactory.createInfModel (reasoner, instances);
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create ( queryString, m);
		
		
		
		System.out.println("\nQueryExecution qe = QueryExecutionFactory.create ( queryString, model);");
		
		ResultSet rs = qe.execSelect();
		
		//ResultSetFormatter.out(System.out, query, m);
		String output;
		//ResultSetFormatter.out(System.out, rs, query);
		output = ResultSetFormatter.asText(rs);

		return output;
		//System.out.println(ResultSetFormatter.out(rs, query).toString());
		
		/*
		System.out.println("ResultSet rs = qe.execSelect();");
		
		System.out.println("\trs.getResourceModel() = "+rs.getResourceModel());
		System.out.println("\trs.getResultVars() = "+rs.getResultVars());
		System.out.println("\t\trs.getResultVars().size() = "+rs.getResultVars().size());
		System.out.println("\trs.getRowNumber() = "+rs.getRowNumber());
		System.out.println("\trss.hasNext() = "+rs.hasNext());
		//System.out.println("\trss.next() = "+rs.next());
		//System.out.println("\trss.nextBinding() = "+rs.nextBinding());
		//System.out.println("\trss.nextSolution() = "+rs.nextSolution());
		
		int whichOne = 0;
		
		
		
		
		System.out.println("rs.hasNext() = "+rs.hasNext());		
		
		if(rs.hasNext() && whichOne == 0)
		{
			QuerySolution qs = rs.nextSolution();
			System.out.println("QuerySolution qs = rs.nextSolution();");
			
			//System.out.println("\tqs." = "+qs.);
			String string = "";
			System.out.println("\tqs.contains(\""+string+"\") = "+qs.contains(string));
			System.out.println("\tqs.get(\""+string+"\") = "+qs.get(string));
			System.out.println("\tqs.getLiteral(\""+string+"\") = "+qs.getLiteral(string));
			System.out.println("\tqs.getResource(\""+string+"\") = "+qs.getResource(string));
			System.out.println("\tqs.varNames() = "+qs.varNames());
			
			Iterator i = qs.varNames();
			while(i.hasNext()){
				System.out.println("\t\ti.next() = "+i.next());
			}
		}
		

		
		
		
		System.out.println("rs.hasNext() = "+rs.hasNext());
		
		if(rs.hasNext() && whichOne == 1)
		{
			Binding bg = rs.nextBinding();
			System.out.println("Binding bg = rs.nextBinding();");
			
			//System.out.println("\tqs." = "+qs.);
			System.out.println("\tbg.contains(Var?) = <what var?>");
			System.out.println("\tbg.get(Var?) = <what var?>");
			System.out.println("\tbg.isEmpty() = "+bg.isEmpty());
			System.out.println("\tbg.size() = "+bg.size());
			System.out.println("\tqs.vars() = "+bg.vars());
		}
		*/
		
		
		
		/*
		while(rs.hasNext())
		{
			System.out.println(rs.getResultVars().);
			rs.next();
		}
		*/
		
		
		
		/*
		for (ResultSet rs = qe.execSelect() ; rs.hasNext() ; ) {
			QuerySolution qs = rs.nextSolution();
			System.out.println("asd: " + binding.get("Adapter"));
		    System.out.println("hasnext:");
			System.out.println("binding.get(\"Adapter\") = "+qs.get("Adapter"));
			System.out.println("binding.contains(\"Adapter\") = "+qs.contains("Adapter"));
			System.out.println("binding.getLiteral(\"Adapter\") = "+qs.getLiteral("Adapter"));
			System.out.println("binding.getResource(\"Adapter\") = "+qs.getResource("Adapter"));
			System.out.println("binding.contains(\"Adapter\") = "+qs.contains("Adapter"));
		}
		*/
		
		
		
		
		
		/*
		String result = "";
		Query q = QueryFactory.create(query);
		
		switch(query)
		{
		case "help":
			result += ("Help:\n");
			result += ("The Following commands are available:\n");
			result += ("=====================================\n");
			result += ("- <no special commands usable yet>");
			break;
		case "":
			result = ("Your query is empty.");
			break;
		default:
			result = ("\nCannot proceed query\n");
			break;
		}
		
		result = q.toString();
		*/
		
		//System.out.println("\nfinished\n");
		//System.out.println("###############################################\n");
		//return null;
	}

}
