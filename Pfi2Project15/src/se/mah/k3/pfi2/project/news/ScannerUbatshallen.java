package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class ScannerUbatshallen {

	public static void main(String[] args) {
		ScannerUbatshallen st = new ScannerUbatshallen();
		st.readAndWriteMonday();
	}

	public void readAndWriteMonday(){
		try {
			URL whiteShark = new URL("http://www.whiteshark.gastrogate.com/page/3");
			Scanner s = new Scanner(whiteShark.openStream());
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
