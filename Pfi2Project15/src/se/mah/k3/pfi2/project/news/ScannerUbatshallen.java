package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class ScannerUbatshallen {

	public static void main(String[] args) {
		ScannerUbatshallen st = new ScannerUbatshallen();
		st.readAndWriteMonday();
		System.out.println("blablabla");
	}

	public void readAndWriteMonday(){
		try {
			URL whiteShark = new URL("http://www.whiteshark.gastrogate.com/page/3");
			Scanner s = new Scanner(whiteShark.openStream());
			
			while (s.hasNext()) {
				String string = s.nextLine();
				
				System.out.println(string);
				String mon = string;
				if (mon.contains("lunch_menu")){ 
					int monStartRead = mon.indexOf("Lunchen");
					int monEndRead = mon.indexOf("serverat i");
					String monResult = mon.substring(monStartRead, monEndRead);
					System.out.println(monResult);
					
					
					//String monResultat = mon.substring(monStartRead,  monEndRead);
					String monResultat = mon;
					
//					int removeChars = vegResultat.length() - 120;
//					String cleanResultat = vegResultat.char - removeChars;
					
					int removeStart = monResultat.indexOf("Pasta");
					int removeEnd = monResultat.indexOf("</tr>");
					//String cleanResultat = monResultat.substring(removeStart, removeEnd);
					String cleanResultat = monResultat;
					
					System.out.println(cleanResultat);
				
					
			/*	String Måndag = s.nextLine();
				if(string.contains("Måndag")){
					//System.out.println(string);
					String s3 = s.nextLine();
					s2 = s.nextLine();
					System.out.println(s3);
					int m = s3.indexOf("Måndag");
					int m2 = s3.indexOf("</td>");
					String resultat1 = s3.substring(m, m2);
					System.out.println("Så här är det" + resultat1);	
					
				}
				
				String Pasta = s.nextLine();
				if(string.contains("Pasta")){
				 // System.out.println(string);
				  String s4 = s.nextLine();
				  System.out.println(s4);
				  int o = s4.indexOf("Pasta");
				  int o2 = s4.indexOf("</td>");
				  String resultat2 = s4.substring(o, o2);
				  System.out.println("Så här är det" + resultat2);
				  
				}
				
					*/
				
				}
					
				//System.out.println(string);
			}
			s.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/*public void readAndWriteTuesday(){
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
	
	
	public void readAndWriteWedesday(){
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
	
	public void readAndWriteThursday(){
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
	
	public void readAndWriteFriday(){
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




*/














}
