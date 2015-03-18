package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class ScannerOrkanen {

	public static void main(String[] args) {
		ScannerOrkanen st = new ScannerOrkanen();
		st.readAndWriteMonday();
	}

	public void readAndWriteMonday(){
		try {
			URL mhMatsalar = new URL("http://www.mhmatsalar.se");
			Scanner s = new Scanner(mhMatsalar.openStream());
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
