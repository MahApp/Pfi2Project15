package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class ScannerKalender {

	public static void main(String[] args) {
		ScannerKalender st = new ScannerKalender();
		st.readAndWriteEvents();
	}

	public void readAndWriteEvents(){
		try {
			URL mahKalender = new URL("http://www.mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");
			Scanner s = new Scanner(mahKalender.openStream());
			while (s.hasNext()) {
			//	String string = s.nextLine();
			//	System.out.println(string);
				String s2 = s.nextLine();
				if (s2.contains("2015-03-25")){
				//	System.out.println(s2);
					int i = s2.indexOf("</strong>");
					int i2 = s2.indexOf(":00 - ");
					String datumStart = s2.substring(i,  i2);
					
					int cleanStart = datumStart.indexOf("2015");
					int cleanEnd = datumStart.indexOf(":15");
					String cleanResult = datumStart.substring(cleanStart, cleanEnd);
//					int i3 = s2.indexOf(" - ");
//					int i4 = s2.indexOf(":00<br />");
//					String datumSlut = s2.substring(i3, i4);
//					int k = s2.indexOf("ts:</strong>");
//					int k2 = s2.indexOf("<br /><strong>MÃ¥l");
//					String plats = s2.substring(k, k2);
//					int b = s2.indexOf("<p>");
//					int b2 = s2.indexOf("</p>");
//					String beskrivning = s2.substring(b, b2);
					System.out.println(cleanResult);
					if (s2.contains("2015-03-27")){
				//		System.out.println(s2);
						
						String eventOne = ("10.00 	Hälsa & Samhälle	Spikning: Allogenic stem cell transplantation");
						String eventTwo = ("13.00 	UbÃ¥tshallen 301 	Girls of Hope: Film screening");
						String eventThree = ("13.15	Orkanen D138 		Disputation - Helen Hasslöf");
						
						System.out.println(eventOne);
						System.out.println(eventTwo);
						System.out.println(eventThree);
					
					}
				}
				}
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
