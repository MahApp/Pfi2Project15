package trafikinfo;


public class gThread extends Thread {
	private TrafikinfoGUI gui;
	private boolean running = true;
	
	private int count = 0;
	
	public gThread(TrafikinfoGUI g){
		this.gui = g;
	}
	

	public void run(){
		while(running == true){
			
			String searchURL = Constants.getURL("14096","61079", 20);

			Journeys journeys = Parser.getJourneys(searchURL);
			for (Journey journey : journeys.getJourneys()) {
				String effect = journey.getDepDeviationAffect();
				String details = journey.getDetails();
				String text = journey.getText();

        		new animation().display(effect+", "+text+", "+details);
			}

			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			count++;
			System.out.println("Update nr: "+count+".");
		}		
	}
	

}
