package se.mah.k3.pfi2.project.kronox;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
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
	public static final String bit = "&orgenheterUTB=BIT";
	public static final String n3000 = "&orgenheterUTB=3000";
	public static final String n3020 = "&orgenheterUTB=3020";
	public static final String n3030 = "&orgenheterUTB=3030";
	public static final String n3040 = "&orgenheterUTB=3040";
	public static final String n3050 = "&orgenheterUTB=3050";
	public static final String n3060 = "&orgenheterUTB=3060";
	public static final String n3070 = "&orgenheterUTB=3070";
	public static final String n3080 = "&orgenheterUTB=3080";
	public static final String n4000 = "&orgenheterUTB=4000";
	public static final String n4010 = "&orgenheterUTB=4010";
	public static final String n4055 = "&orgenheterUTB=4055";
	public static final String n4060 = "&orgenheterUTB=4060";
	public static final String n4065 = "&orgenheterUTB=4065";
	public static final String n4070 = "&orgenheterUTB=4070";
	public static final String n4071 = "&orgenheterUTB=4071";
	public static final String n4075 = "&orgenheterUTB=4075";
	public static final String n4080 = "&orgenheterUTB=4080";
	public static final String n4081 = "&orgenheterUTB=4081";
	public static final String n4082 = "&orgenheterUTB=4082";
	public static final String n4083 = "&orgenheterUTB=4083";
	public static final String n5000 = "&orgenheterUTB=5000";
	public static final String n5020 = "&orgenheterUTB=5020"; // vi
	public static final String n5030 = "&orgenheterUTB=5030";
	public static final String n5040 = "&orgenheterUTB=5040";
	public static final String n5060 = "&orgenheterUTB=5060";
	public static final String n6030 = "&orgenheterUTB=6030";
	public static final String n6040 = "&orgenheterUTB=6040";
	public static final String n7021 = "&orgenheterUTB=7021";
	//	static ArrayList<String>  array = new ArrayList<String>();
	
	public static ArrayList<String> getURL(String building, String program){
		ArrayList<String>  array = new ArrayList<String>();
		if(building.equals("ub�tshallen")){
		array.add(baseURL + cts);
		array.add(baseURL + ts);
		array.add(baseURL + us);
		array.add(baseURL + n5020);
		array.add(baseURL + n5030);
		array.add(baseURL + n5040);
		array.add(baseURL + n6030);
		array.add(baseURL + n6040);
		
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
			array.add(baseURL + n4065);
			array.add(baseURL + n4070);
			array.add(baseURL + n4071);
			array.add(baseURL + n4081);
			array.add(baseURL + n4083);
			array.add(baseURL + n5020);
			array.add(baseURL + n5040);

		}
		
		else if (building.equals("odontologiska")){
			array.add(baseURL + od);
			array.add(baseURL + bit);
			
		}
		
		else if (building.equals("kranen")){
			array.add(baseURL + ts);
			array.add(baseURL + cts);
			array.add(baseURL + us);
			array.add(baseURL + n5020);
			array.add(baseURL + n5030);
			array.add(baseURL + n5040);
			array.add(baseURL + n6030);
			array.add(baseURL + n6040);

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
			array.add(baseURL + n4070);
			array.add(baseURL + n4082);
			array.add(baseURL + n5000);
			array.add(baseURL + n5020);
			array.add(baseURL + n5030);
			array.add(baseURL + n5040);
			array.add(baseURL + n5060);
		}
	//	System.out.println(array);
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
	
	public static String parseBiuldingIdToBiulding(String _2letters){
		String biuldingString="";
		
//		if(_2letters.equals("K8"))biuldingString="ub�tshallen";
//		if (_2letters.equals("G8"))biuldingString="g�ddan";
//		if (_2letters.equals("KL"))biuldingString="odontologiska";
//		if (_2letters.equals("OR"))biuldingString="orkanen";
//		if (_2letters.equals("K2"))biuldingString="kranen";
	     switch (_2letters) {
         case "K8":biuldingString="ub�tshallen";break;
         case "G8":biuldingString="g�ddan";break;
         case "KL":biuldingString="odontologiska"; break;
         case "OR":biuldingString="orkanen";break;
         case "K2":biuldingString="kranen";break;
         default:
        	 System.err.println(_2letters+"unknown biulding!!!");
	     }
	     if(Parser.debug)System.out.println(biuldingString);
		return biuldingString;
	}
	
	public static String formatTime(String timeString){ // format the start time into HH:mm format
		try{
		timeString=timeString.substring(11, 16);
		}catch(NullPointerException e){
			System.err.println(timeString +" ERROR no String format timeString!!!");
		}catch(StringIndexOutOfBoundsException e){
			System.err.println(timeString +" ERROR wrong index format timeString!!!");
		}
		return timeString;
	}
	
	public static String formatKurs(String kursID){
		
		String[] test = (kursID.split("-"));
		
		kursID = test[0];
		
		System.out.println(kursID+"//////");
		
		return kursID;
	}

	public static float GetWidthOfString(KronoxPanel kronox,Font font,String string){
		//FontMetrics metrics = kronox.getGraphics().getFontMetrics(kronox.futuraBold);
		FontMetrics metrics =kronox.getGraphics().getFontMetrics(font);
		// get the height of a line of text in this
		// font and render context
		int height = metrics.getHeight();
		// get the advance of my text in this font
		// and render context
		int adv = metrics.stringWidth(string);
		System.out.println(adv+" String pixel width for \""+string+"\"");
		return adv;
	}
}

