package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

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
//				if (fullText.contains("Vecka")){
//					int startRead = fullText.indexOf("NDAG");
//					int endRead = fullText.indexOf(">TISDAG<");
//					String resultat = fullText.substring(startRead,  endRead);
//					System.out.println("READING HALSA SAMHALL-------" + '\n' + resultat);
//				}
				
//				String dagens = sc.nextLine();
//				if (dagens.contains("Husman")){
////					System.out.println(dagens);
//					int dagStartRead = dagens.indexOf("NDAG");
//					int dagEndRead = dagens.indexOf("</p>");
//					String dagensResultat = dagens.substring(dagStartRead, dagEndRead);
//					System.out.println("Husman : " + dagensResultat);
//				}
//				
//				String halsa = sc.nextLine();
//				if (halsa.contains("lsa:")){
//					int halsaStartRead = halsa.indexOf("lsa:");
//					int halsaEndRead = halsa.indexOf("</p>");
//					String halsaResultat = halsa.substring(halsaStartRead,  halsaEndRead);
//					System.out.println("Halsa : " + halsaResultat);
//				}
				
				String veg = fullText;
				if (veg.contains("Vegetarisk:")){ 
					int vegStartRead = veg.indexOf("Vegetarisk");
					int vegEndRead = veg.indexOf(">TISDAG<");
					
					String vegResultat = veg.substring(vegStartRead,  vegEndRead);
//					int removeChars = vegResultat.length() - 120;
//					String cleanResultat = vegResultat.char - removeChars;
					
					int removeStart = vegResultat.indexOf("Vegetarisk");
					int removeEnd = vegResultat.indexOf("</span>");
					String cleanResultat = vegResultat.substring(removeStart, removeEnd);
					
					System.out.println(cleanResultat);
				}
				
				
//				String string = s.nextLine();
//				System.out.println(string);
			}
			sc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
