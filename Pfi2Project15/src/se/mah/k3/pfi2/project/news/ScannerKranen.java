package se.mah.k3.pfi2.project.news;

import java.net.URL;
import java.util.Scanner;

public class ScannerKranen {

	public static void main(String[] args) {
		ScannerKranen st = new ScannerKranen();  //Skapa instans av mig själv :) för att inte köra i statisk kontext
	//	st.readAndWriteMonday();
	//	st.readAndWriteTuesday();
	//	st.readAndWriteWednesday();
	//	st.readAndWriteThursday();
	//	st.readAndWriteFriday();
		System.out.println("***Dagens***");
		st.readAndWriteDagens();
		System.out.println("***VeckoVeg***");
		st.readAndWriteVeg();
		System.out.println("***Kapet***");
		st.readAndWriteKapet();
	}
	
	public void readAndWriteMonday(){	
		try {
			URL hamnaratt = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner s = new Scanner(hamnaratt.openStream());
			while (s.hasNext()){
				String string = s.nextLine();
//				System.out.println(s.findInLine("Kalendern")); // Kanske kan användas
				if (string.contains("Veckans Lunch v")){
					int i = string.indexOf("Veckans");
					int i2 = string.indexOf("</h1>");
					String resultat = string.substring(i, i2);
					System.out.println(resultat);
				}
				
//				String monday = s.nextLine();
//				if (monday.contains("dag")){
//					System.out.println("Måndag");
//				}
				
				String dagens = s.nextLine();
				if (dagens.contains("Husman")){
					int d = dagens.indexOf("Husman");
					int d2 = dagens.indexOf("stomp");
					String dagensResultat = dagens.substring(d, d2);
					System.out.println(dagensResultat);
				}
				
				String veg = s.nextLine();
				if (veg.contains("VeckoVeg")){ // kommentar
					int v = veg.indexOf("VeckoVeg");
					int v2 = veg.indexOf("</strong>");
					String vegResultat = veg.substring(v,  v2);
					System.out.println(vegResultat);
				}
				
				String kapet = s.nextLine();
				if (kapet.contains("Kapet")){
					int k = kapet.indexOf("Kapet");
					int k2 = kapet.indexOf("</strong>");
					String kapetResultat = kapet.substring(k,  k2);
					System.out.println(kapetResultat);
				}
				
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readAndWriteTuesday(){
		try {
			URL hamnaratt = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner s = new Scanner(hamnaratt.openStream());
			while (s.hasNext()){
				String tuesday = s.nextLine();
				if(tuesday.contains("Tisdag")){
					System.out.println("Tisdag");
				}
				
				String dagens = s.nextLine();
				if (dagens.contains("Husman")){
				//	System.out.println(dagens);
					int d = dagens.indexOf("Husman");
					int d2 = dagens.indexOf("</strong>");
					String dagensResultat = dagens.substring(d,  d2);
					System.out.println(dagensResultat);
				}
				
				String kapet = s.nextLine();
				if (kapet.contains("Kapet")){
					int k = kapet.indexOf("Kapet");
					int k2 = kapet.indexOf("</strong>");
					String kapetResultat = kapet.substring(k,  k2);
					System.out.println(kapetResultat);
				}
				
			}
			s.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void readAndWriteWednesday(){
		try {
			URL hamnaratt = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner s = new Scanner(hamnaratt.openStream());
			while (s.hasNext()){
				String string = s.nextLine();
				if (string.contains("Onsdag")){
					int i = string.indexOf("Onsdag");
					int i2 = string.indexOf("</span>");
					String resultat = string.substring(i, i2);
					System.out.println(resultat);
				}
				
				String s2 = s.nextLine();
				if (s2.contains("Husman")){
					int d = s2.indexOf("Husman");
					int d2 = s2.indexOf("</strong>");
					String s2Resultat = s2.substring(d,  d2);
					System.out.print(s2Resultat);
				}
			}
			s.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void readAndWriteThursday(){
		try {
			URL hamnaratt = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner s = new Scanner(hamnaratt.openStream());
			while (s.hasNext()){
				
			}
			s.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void readAndWriteFriday(){
		try {
			URL hamnaratt = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner s = new Scanner(hamnaratt.openStream());
			while (s.hasNext()){
				
			}
			s.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void readAndWriteDagens(){
		try {
			URL hamnaratt = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner t = new Scanner(hamnaratt.openStream());
			while (t.hasNext()){
				String string = t.nextLine();
				if (string.contains("Husman")){
			//		System.out.println(string);
					int i = string.indexOf("Husman");
					int i2 = string.indexOf("</strong>");
					String resultat = string.substring(i,  i2);
					System.out.println(resultat);
				}
			}
			t.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void readAndWriteVeg(){
		try {
			URL hamnaratt = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner t = new Scanner(hamnaratt.openStream());
			while (t.hasNext()){
				String string = t.nextLine();
				if (string.contains("VeckoVeg")){
				//	System.out.println(string);
					int i = string.indexOf("VeckoVeg");
					int i2 = string.indexOf("</strong>");
					String resultat = string.substring(i,  i2);
					System.out.println(resultat);
				}
			}
			t.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void readAndWriteKapet(){
		try {
			URL hamnaratt = new URL("http://www.hamnaratt.com/veckans-lunch");
			Scanner t = new Scanner(hamnaratt.openStream());
			while (t.hasNext()){
				String string = t.nextLine();
				if (string.contains("Kapet")){
				//	System.out.println(string);
					int i = string.indexOf("Kapet");
					int i2 = string.indexOf("</strong>");
					String resultat = string.substring(i,  i2);
					System.out.println(resultat);
				}
			}
			t.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
