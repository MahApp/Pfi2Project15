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
				String string = s.nextLine();
			//	System.out.println(string);
				String s2 = s.nextLine();
				if (s2.contains("2015-03-27")){
				//	System.out.println(s2);
					String eventOne = ("27/3	10.00-11.00 	Spikning: Allogenic stem cell transplantation 				Hälsa & Samhälle");
					String eventTwo = ("27/3 	13.00-15.00 	Girls of Hope: Film screening with director Aysegül Selenga Taskent 	Ubåtshallen 301");
					String eventThree = ("27/3 	13.15-15.00 	Disputation - Helen Hasslöf 						Orkanen D138");
					
					System.out.println(eventOne);
					System.out.println(eventTwo);
					System.out.println(eventThree);
				
				}

				}
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
