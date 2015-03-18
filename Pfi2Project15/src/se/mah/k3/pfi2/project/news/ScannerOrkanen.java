package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class ScannerOrkanen {

	public static void main(String[] args) {
		ScannerOrkanen st = new ScannerOrkanen();
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
			URL mhMatsalar = new URL("http://www.mhmatsalar.se"); //orkanens matsedel
			Scanner s = new Scanner(mhMatsalar.openStream());
			while (s.hasNext()) {
				String fullText = s.nextLine();
				String string = s.nextLine();
				//System.out.println(string);
				
				
			//String s2 = s.nextLine();
				//if (s2.contains("Måndag")){
					//System.out.println("Måndag");
				//}
				
				String dagens = s.nextLine();
				if (dagens.contains("morot")){
					System.out.println(dagens);
					int d = dagens.indexOf("Veget");
					int d2 = dagens.indexOf("Tisdag");
				String dagensResultat = dagens.substring(d, d2);
					System.out.println(dagensResultat);
				}
				
				
				
				
				String veg = fullText;
			if (veg.contains("fetaost")){ 
					int vegStartRead = veg.indexOf("Pasta");
					int vegEndRead = veg.indexOf("<br>");
					
					String vegResultat = veg.substring(vegStartRead,  vegEndRead);
	//				int removeChars = vegResultat.length() - 120;
//					String cleanResultat = vegResultat.char - removeChars;
				
					int removeStart = vegResultat.indexOf("Pasta");
					int removeEnd = vegResultat.indexOf("ost");
					String cleanResultat = vegResultat.substring(removeStart, removeEnd);
					
					System.out.println(cleanResultat);
				}
		
			}
			
			
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
