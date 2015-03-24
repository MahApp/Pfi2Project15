package se.mah.k3.pfi2.project.bus;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;



public class LineThread extends Thread {
	private Parser parser;
	private int noOfUpdates = 0;
	private int updateInterval = 60000;
	private int results = 4; //fixa
	private int busCount = 0;
	
	public LineThread(Parser parser) {
		this.parser = parser;
	}

	private Parser Par;
	private BusPanel myBusPanel;
	public boolean running = true;

	public LineThread(Parser p, BusPanel g) {

		this.Par = p;
		this.myBusPanel = g;
	}

	public void run() {			
		try {
			while (true) {
				String searchURL = Constants.getURL("80046", "80000", results);
				Journeys journeys = Parser.getJourneys(searchURL);

				Thread.sleep(updateInterval);
				noOfUpdates++;
				System.out.println("UPPDATERING " + noOfUpdates + "\n");

				BusPanel.line.setText("");
				BusPanel.destination.setText("");
				BusPanel.stop.setText("");
				BusPanel.departure.setText("");
				
			
				for (Journey journey : journeys.getJourneys()) {
					int HJ = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
					int MJ = journey.getDepDateTime().get(Calendar.MINUTE);
					String time = (String.format("%02d", HJ) + ":" + (String.format("%02d", MJ)));
					String depTime = journey.getTimeToDeparture() + journey.getDepTimeDeviation();

					busCount++;

					BusPanel.line.append(journey.getLineOnFirstJourney() + "\n");
					BusPanel.destination.append(journey.getTowards() + "\n");
					BusPanel.stop.append(journey.getStopPoint() + "\n");
					System.out.println("Buss " + busCount + " avg�r om " + depTime + " min");

					if (Integer.valueOf(depTime) > 10 && Integer.valueOf(depTime) > 0) {
						BusPanel.departure.append(time + "\n");
					} else {
						BusPanel.departure.append(journey.getTimeToDeparture() + journey.getDepTimeDeviation() + " min \n");
					}
				}
			}
		} catch (Exception ex) {
		}
	}
}
