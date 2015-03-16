package trafikinfo;

import java.util.Calendar;


public class TestClassForCode {
	public static void main(String[] args) {
		// getURL searches 2 test-stations in order to print out the value of "details".
		String searchURL = Constants.getURL("14096","61079", 20);
		int x = 1;
		System.out.println(searchURL);
		System.out.println("// Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			System.out.print(x+". ");
			String effect = journey.getDepDeviationAffect();
			System.out.print(effect);
			
	// Details print out details about specific stations.		
			String details = journey.getDetails();
			System.out.print(details);
			
			String text = journey.getText();
			if(text != null){
				System.out.print(text + "\n");
			} else{
				System.out.print("\n");
			}
			
			x++;
		} 
		
	}
}
