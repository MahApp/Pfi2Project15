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
			URL mah = new URL("http://www.mah.se/Nyheter/Kalender/");
			Scanner s = new Scanner(mah.openStream());
			while (s.hasNext()){
				String string = s.nextLine();
				System.out.println(string);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
