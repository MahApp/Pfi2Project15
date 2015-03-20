package se.mah.k3lara.skaneAPI.model;

import java.util.ArrayList;
/**
 * Journeys class can hold a number o singular journeys. For example all transports from one stations to another
 * @author K3LARA
 *
 */
public class Journeys {
	private ArrayList<Journey> journeys;
	
	//Creates a list of journeys
	public Journeys() {
		// TODO Auto-generated constructor stub
		journeys = new ArrayList<Journey>();
	}
	
	public void addJourney(Journey journey) {
		this.journeys.add(journey);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Journey> getJourneys() {
		return journeys;
	}
	
	public void clearJourneys() {
		this.journeys.clear();
	}
}
