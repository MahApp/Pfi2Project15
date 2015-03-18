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
			URL mahKalender = new URL("http://www.mah.se/Nyheter/Kalender");
			Scanner s = new Scanner(mahKalender.openStream());
			while (s.hasNext()) {
				String string = s.nextLine();
				if (string.contains("mars")){
				//	System.out.println(string);
					int i = string.indexOf("mars");
					int i2 = string.indexOf("</h2>");
					String resultat = string.substring(i,  i2);
					System.out.println(resultat);
				}
			}
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
