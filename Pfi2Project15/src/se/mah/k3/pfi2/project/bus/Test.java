package se.mah.k3.pfi2.project.bus;

import java.util.ArrayList;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class Test {

	public static void main(String[] args) {
		Lines lines = Parser.getStationResults(new Station("80046"));
		for (Line l : lines.getLines()) {
			
			Calendar cal = Calendar.getInstance();
			
			int H1 = cal.get(Calendar.HOUR);
			int M1 = cal.get(Calendar.MINUTE);
			int H = l.getDepTime().get(Calendar.HOUR_OF_DAY );
			int M = l.getDepTime().get(Calendar.MINUTE );
			
			long difference = H - H1;	
			long difference1 = M1 - M;
			System.out.println("Line " + l.getLine() + " "+ l.getTowards() +" departs: "+ difference/1000 + difference1  +"min");
			
			
		}
		//Testar från ubåtshallen till centralen för att enbart visa läge B, minuter före avgång och antal avgångar
				//Ubåtshallen = 80046,	 Malmö C = 80000,	Orkanen = 80003
				String searchURL = Constants.getURL("80046","80000",4); //Ubåtshallen - Malmö C, begränsar antalet avgångar med 4 
				System.out.println(searchURL);							
				Journeys journeys = Parser.getJourneys(searchURL); 
				for (Journey journey : journeys.getJourneys()) {
					
					int HJ= journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
					int MJ = journey.getDepDateTime().get(Calendar.MINUTE);
					String time=(String.format("%02d",HJ)+":"+(String.format("%02d",MJ)));
					
					String D = journey.getTimeToDeparture()+journey.getDepTimeDeviation(); //adderar försenade minuter
					
					System.out.print("Line "+journey.getLineOnFirstJourney()+" "+
									journey.getTowards()+
									" Läge:"+journey.getStopPoint()+
									" Departs: "+D+" min\n");
				} 
	}

}
