package trafikinfo;


public class gThread extends Thread {
	private TrafikinfoGUI gui;
	private boolean running = true;
	private String effect;
	private String details;
	private String text;
	
	private int count = 0;
	
	public gThread(TrafikinfoGUI g){
		this.gui = g;
	}
	

	public void run(){
		while(running == true){
			
			String searchURL = Constants.getURL("14096","61079", 20);

			Journeys journeys = Parser.getJourneys(searchURL);
			for (Journey journey : journeys.getJourneys()) {
				effect = journey.getDepDeviationAffect();
				details = journey.getDetails();
				text = journey.getText();

				 ScrollText st = new ScrollText(effect+", "+text+", "+details);
				 gui.add(st);
			}

			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			count++;
			System.out.println("Update nr: "+count+".");
		}		
	}
	

}
