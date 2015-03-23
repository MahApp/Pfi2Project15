package se.mah.k3.pfi2.project.traficinfo.view;

import java.util.ArrayList;

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

	private String info = null;
	private String newInfo;
	private String searchURL;

	
	private int count = 0;
	
	public gThread(TrafficInfo g){
		this.gui = g;
	}
	

	public void run(){
		while(running == true){
			
			String searchURL1 = Constants.getURL("14096","61079", 20);
			String searchURL2 = Constants.getURL("45006","95006", 20); //KPH Airport -> GTB C
			String searchURL3 = Constants.getURL("45006","10007", 20); //KPH Airport -> Karlskrona C
			String searchURL4 = Constants.getURL("80000","86239", 20); //Malmö -> Ystad 

			for(int i = 1; i<5; i++){
				
				 switch (i) {
		            case 1:  searchURL = searchURL1;
		                     break;
		            case 2:  searchURL = searchURL2;
                    		 break;
		            case 3:  searchURL = searchURL3;
                    		 break;
		            case 4:  searchURL = searchURL4;
                    		 break;
				 }
				
				Journeys journeys = Parser.getJourneys(searchURL);
					for (Journey journey : journeys.getJourneys()) {
				effect = journey.getDepDeviationAffect();
				detail = journey.getDetails();
				text = journey.getText();

				
				if(effect == "CRITICAL"){
					effects.add(effect);
					details.add(detail);
					texts.add(text);
					
				}


				}

			}
			
			if(effects != null){
			ScrollText st = new ScrollText(effects+", "+details+", "+texts);
			st.setBounds(100, 13, 1080, 80);
			gui.add(st);
			}

				
			
				
	
			

			
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			count++;
			System.out.println("Update nr: "+count+".");
		}		
	}
	

}
