package trafikinfo;


public class TestClassForCode {
	public static void main(String[] args) {
		// getURL searches 2 test-stations in order to print out the value of "details".
		String searchURL = Constants.getURL("14096","61079", 20);
		int x = 1;
		int r = 0;
		System.out.println(searchURL);
		System.out.println("Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			System.out.print(x+". ");
			
			String effect = journey.getDepDeviationAffect();
			
			switch (effect) {
            case "NONE":  

                break;
            case "PASSED":  

            	break;
            case "NON_CRITICAL":  

            	break;
            case "CRITICAL":  
            	if(r==0){
            		new animation().display(effect);
            		r++;
            	}
    			System.out.print(effect);
            	break;
			}
			
	// Details print out details about specific stations.		
			String details = journey.getDetails();
			
			if(r==0){
				new animation().display(details);
				r++;
			}
			System.out.println(details);
			System.out.print(effect);

						
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
