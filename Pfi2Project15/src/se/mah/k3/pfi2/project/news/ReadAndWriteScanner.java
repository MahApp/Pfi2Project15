package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class ReadAndWriteScanner {

	public static void main(String[] args) {
		ReadAndWriteScanner st = new ReadAndWriteScanner();  //Skapa instans av mig själv :) för att inte köra i statisk kontext
		st.readAndWriteExample();
	}

	public void readAndWriteExample(){	
	System.out.println("********************Read from the net********************");
		try {
			URL mah = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner s = new Scanner(mah.openStream());
			while (s.hasNext()){
				String string = s.nextLine();
//				System.out.println(s.findInLine("Kalendern")); // Kanske kan användas
				if (string.contains("Veckans Lunch v")){
					int i = string.indexOf("Veckans");
					int i2 = string.indexOf("</h1>");
					String resultat = string.substring(i,  i2);
					System.out.println(resultat);
				}
				
				String s2 = s.nextLine();
				if (s2.contains("ndag")){
					System.out.println("Måndag");
				}
				
				String dagens = s.nextLine();
				if (dagens.contains("Husman")){
//					System.out.println(dagens);
					int d = dagens.indexOf("Husman");
					int d2 = dagens.indexOf("stomp");
					String dagensResultat = dagens.substring(d, d2);
					System.out.println(dagensResultat);
				}
				
				String veg = s.nextLine();
				if (veg.contains("VeckoVeg")){
					//System.out.println(veg);
					int v = veg.indexOf("VeckoVeg");
					int v2 = veg.indexOf("</strong>");
					String vegResultat = veg.substring(v,  v2);
					System.out.println(vegResultat);
				}
				
				String kapet = s.nextLine();
				if (kapet.contains("Kapet")){
					//System.out.println(kapet);
					int k = kapet.indexOf("Kapet");
					int k2 = kapet.indexOf("</strong>");
					String kapetResultat = kapet.substring(k,  k2);
					System.out.println(kapetResultat);
				}
				
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
