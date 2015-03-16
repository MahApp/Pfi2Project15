package trafikinfo;

import java.util.Calendar;


public class TestClassForCode {
	public static void main(String[] args) {
		String searchURL = Constants.getURL("80000","81216",20);
		System.out.println(searchURL);
		System.out.println("// Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			String effect = journey.getDepDeviationAffect();
			System.out.print(effect+ "\n");
			
			String details = journey.getDetails();
			System.out.print(details + "\n");
		} 
		
	}
}
