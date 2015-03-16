package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class CopyOfReadAndWriteScanner {

	public static void main(String[] args) {
		CopyOfReadAndWriteScanner st = new CopyOfReadAndWriteScanner();  //Skapa instans av mig själv :) för att inte köra i statisk kontext
		st.readAndWriteExample();
	}

	public void readAndWriteExample(){	
	System.out.println("********************Read from the net********************");
		try {
			URL mah = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner s = new Scanner(mah.openStream());
			while (s.hasNext()){  //H�r testar vi om det finns fler rader att l�sa
				String string = s.nextLine(); //H�r l�ser vi n�sta rad
				//System.out.println(string);  //Detta �r vad vi har l�st
				//System.out.println(s.findInLine("Kalendern")); S� h�r kan man kanske g�ra 
				//System.out.println(s.nextLine()); Denna �r obra eftersom den l�ser en ny rad
				//s.close(); Inte heller bra f�r den st�nger l�sningen
				
				
				
				//OM jag letar efter n�r veckans lunch serveras s� vet jag att det �r tv� rader efter den rad d�r orden Veckans lunch st�r.....
				//Detta �r inte rocket science mer ett testande samt att anv�nda en massa String-metoder.
				//Det bygger p� att sidorna ser exakt lika dana ut varje dag.
				//Det f�r man testa men man kan ofta kompensera f�r det.
				if (string.contains("Veckans Lunch v")){
					System.out.println(string);  //HA HA vi hittade den
					String  s2 = s.nextLine();  //L�s n�sta rad d�r finns bara en <h2>tagg skippa denna
					s2 = s.nextLine();  //Men h�r �r det intresssanta
					System.out.println(s2);  //OK men det �r skr�pigt l�t oss st�da det...
					int i = s2.indexOf("Serveras");   ///H�r blir i lika med startplatsen 
					int i2 = s2.indexOf("</span>");  //H�r �r texten slut
					String resultat = s2.substring(i, i2);  //Klipp ut den biten jag hittat......
					System.out.println("S� h�r �r det: "+resultat);
				}
				
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
