package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class ScannerHalsaSamhall {

	public static void main(String[] args) {
		ScannerHalsaSamhall st = new ScannerHalsaSamhall();
		st.readAndWriteMonday();
	}

	public void readAndWriteMonday(){
		try {
			URL freda49 = new URL("http://www.freda49.se/lunch-malmo.html");
			Scanner s = new Scanner(freda49.openStream());
			while (s.hasNext()) {
				String string = s.nextLine();
				System.out.println(string);
			}
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
