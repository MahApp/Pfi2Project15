package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class CopyOfReadAndWriteScanner {

	public static void main(String[] args) {
		CopyOfReadAndWriteScanner st = new CopyOfReadAndWriteScanner();  //Skapa instans av mig sjÃ¤lv :) fÃ¶r att inte kÃ¶ra i statisk kontext
		st.readAndWriteExample();
	}

	public void readAndWriteExample(){	
	System.out.println("********************Read from the net********************");
		try {
			URL mah = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner s = new Scanner(mah.openStream());
			while (s.hasNext()){  //Här testar vi om det finns fler rader att läsa
				String string = s.nextLine(); //Här läser vi nästa rad
				//System.out.println(string);  //Detta är vad vi har läst
				//System.out.println(s.findInLine("Kalendern")); Så här kan man kanske göra 
				//System.out.println(s.nextLine()); Denna är obra eftersom den läser en ny rad
				//s.close(); Inte heller bra för den stänger läsningen
				
				
				
				//OM jag letar efter när veckans lunch serveras så vet jag att det är två rader efter den rad där orden Veckans lunch står.....
				//Detta är inte rocket science mer ett testande samt att använda en massa String-metoder.
				//Det bygger på att sidorna ser exakt lika dana ut varje dag.
				//Det får man testa men man kan ofta kompensera för det.
				if (string.contains("Veckans Lunch v")){
					System.out.println(string);  //HA HA vi hittade den
					String  s2 = s.nextLine();  //Läs nästa rad där finns bara en <h2>tagg skippa denna
					s2 = s.nextLine();  //Men här är det intresssanta
					System.out.println(s2);  //OK men det är skräpigt lät oss städa det...
					int i = s2.indexOf("Serveras");   ///Här blir i lika med startplatsen 
					int i2 = s2.indexOf("</span>");  //Här är texten slut
					String resultat = s2.substring(i, i2);  //Klipp ut den biten jag hittat......
					System.out.println("Så här är det: "+resultat);
				}
				
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
