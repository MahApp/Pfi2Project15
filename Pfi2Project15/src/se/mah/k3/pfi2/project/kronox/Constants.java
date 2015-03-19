package se.mah.k3.pfi2.project.kronox;

import java.util.ArrayList;

public class Constants {
	
	public static final String baseURL = "http://schema.mah.se/setup/jsp/SchemaXML.jsp?startDatum=idag&intervallTyp=d&intervallAntal=1";
	public static final String cts = "&orgenheterUTB=CTS";
	public static final String odontologiska = "&orgenheterUTB=OD";
	public static final String idv = "&orgenheterUTB=IDV";
	public static final String lut = "&orgenheterUTB=LUT";
	public static final String od = "&orgenheterUTB=OD";
	public static final String ts = "&orgenheterUTB=TS";
	public static final String us = "&orgenheterUTB=US";
	
	static ArrayList<String> array = new ArrayList<String>();
	
	public static ArrayList<String> getURL(String building, String program){
		
		if(building.equals("ubåtshallen")){
		array.add(baseURL + cts);
		array.add(baseURL + ts);
		array.add(baseURL + us);
		
		}
		
		else if (building.equals("orkanen")){
			array.add(baseURL + idv);
			array.add(baseURL + lut);
			array.add(baseURL + us);
			array.add(baseURL + ts);
			
		}
		
		else if (building.equals("odontologiska")){
			array.add(baseURL + od);
			
		}
		
		else if (building.equals("kranen")){
			array.add(baseURL + ts);
			array.add(baseURL + cts);
			array.add(baseURL + us);
		}
		
		else if (building.equals("gäddan")){
			array.add(baseURL + ts);
			array.add(baseURL + us);
			
		}
		return array;
	}
	
}
