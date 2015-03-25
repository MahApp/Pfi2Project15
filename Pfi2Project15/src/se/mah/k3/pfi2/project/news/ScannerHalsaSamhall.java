package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

import org.apache.commons.lang3.*;

public class ScannerHalsaSamhall {

	public static void main(String[] args) {
		ScannerHalsaSamhall st = new ScannerHalsaSamhall();
		st.readAndWriteMonday();
	}
	
	public void readAndWriteTuesday(){
		
	}
	
	public void readAndWriteWednesday(){
		
	}
	
	public void readAndWriteThursday(){
		
	}
	
	public void readAndWriteFriday(){
		
	}

	public void readAndWriteMonday(){
		try {
			URL freda49 = new URL("http://www.freda49.se/lunch-malmo.html");
			Scanner sc = new Scanner(freda49.openStream());
			while (sc.hasNext()) {
				String fullText = sc.nextLine();
				
//				int menuStart = fullText.indexOf("LUNCHMENY");   //fr�n "lunchmeny"
//				int menuEnd = fullText.indexOf("L=inneh");       //till "L=inneh�ller laktos"
//				String fullMenu = fullText.substring(menuStart, menuEnd);
//				
//				int mondayStart = fullMenu.indexOf("ndag:");
//				int mondayEnd = fullMenu.indexOf("TISDAG");
//				String monday = fullMenu.substring(mondayStart, mondayEnd);
				
				String dagens = fullText;
				if (dagens.contains("Husman")){	
					int dagensStartRead = dagens.indexOf("Husman");
					int dagensEndRead = dagens.indexOf("lsa:");
					String dagensResultat = dagens.substring(dagensStartRead, dagensEndRead);
					
					int cleanStart = dagensResultat.indexOf("Husman:");
					int cleanEnd = dagensResultat.indexOf("</span>");
					String cleanResultat = dagensResultat.substring(cleanStart, cleanEnd);
					
					String removeHtml = StringEscapeUtils.unescapeHtml4(cleanResultat);
					System.out.println(removeHtml);
					
					System.out.println(cleanResultat);
					
				}
				
				String halsa = fullText;
				if (halsa.contains("lsa:")){
					int halsaStartRead = halsa.indexOf("lsa:");
					int halsaEndRead = halsa.indexOf("Vegetarisk");
					String halsaResultat = halsa.substring(halsaStartRead,  halsaEndRead);
					
					int cleanStart = halsaResultat.indexOf("lsa:");
					int cleanEnd = halsaResultat.indexOf("</span>");
					String cleanResultat = halsaResultat.substring(cleanStart, cleanEnd);
							
							
					String removeHtml = StringEscapeUtils.unescapeHtml4(cleanResultat);
					System.out.println("Hä" + removeHtml);
					System.out.println("Hä" + cleanResultat);
				}
				
				String veg = fullText;
				if (veg.contains("Vegetarisk:")){ 
					int vegStartRead = veg.indexOf("Vegetarisk");    
					int vegEndRead = veg.indexOf(">TISDAG<");
					String vegResultat = veg.substring(vegStartRead,  vegEndRead); //tar in all text inom taggarna "Vegetarisk" och 
																				   //">TISDAG<"
					
					int cleanStart = vegResultat.indexOf("Vegetarisk");
					int cleanEnd = vegResultat.indexOf("</span>");
					String cleanResultat = vegResultat.substring(cleanStart, cleanEnd); //tar in all text fr�n b�rjan av vegResultat och 
																					    // </span> inom vegresultat
					String removeHtml = StringEscapeUtils.unescapeHtml4(cleanResultat);
					System.out.println(removeHtml);
					
					System.out.println(cleanResultat);   //skriver ut vegResultat utan HTML-taggar
				}
				// kommenterar här för skojs skull
			}
			sc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
