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
	public static final String n3000 = "&orgenheterUTB=3000";
	public static final String n3020 = "&orgenheterUTB=3020";
	public static final String n3030 = "&orgenheterUTB=3030";
	public static final String n3040 = "&orgenheterUTB=3040";
	public static final String n3050 = "&orgenheterUTB=3050";
	public static final String n3060 = "&orgenheterUTB=3060";
	public static final String n3070 = "&orgenheterUTB=3070";
	public static final String n3080 = "&orgenheterUTB=3080";
	public static final String n5020 = "&orgenheterUTB=5020"; // vi
	public static final String n5030 = "&orgenheterUTB=5030";
	public static final String n5040 = "&orgenheterUTB=5040";
	public static final String n5060 = "&orgenheterUTB=5060";
	public static final String n6030 = "&orgenheterUTB=60300";
	static ArrayList<String> array = new ArrayList<String>();
	
	public static ArrayList<String> getURL(String building, String program){
		
		if(building.equals("ub�tshallen")){
		array.add(baseURL + cts);
		array.add(baseURL + ts);
		array.add(baseURL + us);
		
		}
		
		else if (building.equals("orkanen")){
			array.add(baseURL + idv);
			array.add(baseURL + lut);
			array.add(baseURL + us);
			array.add(baseURL + ts);
			array.add(baseURL + n3000);
			array.add(baseURL + n3020);
			array.add(baseURL + n3030);
			array.add(baseURL + n3040);
			array.add(baseURL + n3050);
			array.add(baseURL + n3060);
			array.add(baseURL + n3070);
			array.add(baseURL + n3080);
		}
		
		else if (building.equals("odontologiska")){
			array.add(baseURL + od);
			
		}
		
		else if (building.equals("kranen")){
			array.add(baseURL + ts);
			array.add(baseURL + cts);
			array.add(baseURL + us);
			array.add(baseURL + n5020);
			array.add(baseURL + n5030);
			array.add(baseURL + n6030);
		}
		
		else if (building.equals("g�ddan")){
			array.add(baseURL + ts);
			array.add(baseURL + us);
			array.add(baseURL + n3000);
			array.add(baseURL + n3020);
			array.add(baseURL + n3030);
			array.add(baseURL + n3040);
			array.add(baseURL + n3050);
			array.add(baseURL + n3060);
			array.add(baseURL + n5040);
			array.add(baseURL + n5060);
		}
		return array;
	}
	
	public static String fixUTF8( String _input){
		_input=_input.replace("&#246;", "�");
		_input=_input.replace("&#228;", "�");
		_input=_input.replace("&#229;", "�");
		_input=_input.replace("&#246;", "�");
		_input=_input.replace("&#196;", "�");
		_input=_input.replace("&#197;", "�");
		_input=_input.replace("&#214;", "�");
		return _input;
	}

	public static String fixHTML(String _input) {
		    return _input.replaceAll("\\<[^>]*>","");
	}
	
}
