package se.mah.k3.pfi2.project.traficinfo.view;

import java.util.ArrayList;
import java.util.Iterator;

import se.mah.k3.pfi2.project.traficinfo.control.Constants;
import se.mah.k3.pfi2.project.traficinfo.model.Journey;
import se.mah.k3.pfi2.project.traficinfo.model.Journeys;
import se.mah.k3.pfi2.project.traficinfo.xmlparser.Parser;


public class gThread extends Thread {
	private TrafficInfo gui;
	private boolean running = true;
	private String effect;
	private ArrayList<String> effects = new ArrayList<String>();
	private String detail;
	private ArrayList<String> details = new ArrayList<String>();
	private String text;
	private ArrayList<String> texts = new ArrayList<String>();

	private String searchURL;
	private boolean timeToRun = false;
	
	private int count = 0;
		
	public gThread(TrafficInfo g){
		this.gui = g;
	}
	
	public boolean getTimeToRun(){
		return timeToRun;
	}
	

	public void run(){
		
		while(running == true){
			for(int i = 1; i<4; i++){
				
				//Filtered journeys
				 switch (i) {
		            case 1:  searchURL = Constants.getURL("45006","95006", 20); //KPH Airport -> GTB C
		            System.out.println("URL1 Searching...");
		                     break;
		            case 2:  searchURL = Constants.getURL("45006","10007", 20); //KPH Airport -> Karlskrona C
		            System.out.println("URL2 Searching...");
                    		 break;
		            case 3:  searchURL = Constants.getURL("80000","86239", 20); //Malm� -> Ystad 
		            System.out.println("URL3 Searching...");
                    		 break;
				 }
				
				Journeys journeys = Parser.getJourneys(searchURL);
					for (Journey journey : journeys.getJourneys()) {
				effect = journey.getDepDeviationAffect();
				detail = journey.getDetails();
				text = journey.getText();
				
				//Adding FAKE information to test
				
				effects.add("Inställda tåg");
				details.add("Tågen mellan Malmö C och Lund C är försenade med 15 minuter");
				texts.add("");

					if(effect == "CRITICAL"){
						effects.add(effect);
						details.add(detail);
						texts.add(text);
					System.out.println("CRITICAL TRIGGERED, RUNNING");
					timeToRun = true;
					}
				}	
			}
			
			//Checks if there is any details added by the if statement above.   NOT DONE
			if(details.size() >= 1){
				for(String temp: details){
			 						
			      }	
				
				ScrollText st = new ScrollText(effects+", "+details+", "+texts);
				st.setBounds(100, 3, 1080, 160);
				gui.add(st);
			}
			
			
			
			

			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			count++;
			System.out.println("-----------------------------");
			System.out.println("--- Update nr: "+count+". ---");
			System.out.println("-----------------------------");
		}		
	}
}
