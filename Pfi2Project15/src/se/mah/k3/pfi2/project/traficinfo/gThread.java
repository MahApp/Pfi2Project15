package se.mah.k3.pfi2.project.traficinfo;


public class gThread extends Thread {
	private TrafficInfo gui;
	private boolean running = true;
	private String effect;
	private String details;
	private String text;
	
	private int count = 0;
	
	public gThread(TrafficInfo g){
		this.gui = g;
	}
	

	public void run(){
		while(running == true){
			
			String searchURL = Constants.getURL("14096","61079", 20);
			String searchURL2 = Constants.getURL("45006","95006", 20); //KPH Airport -> GTB C

			Journeys journeys = Parser.getJourneys(searchURL);
			for (Journey journey : journeys.getJourneys()) {
				effect = journey.getDepDeviationAffect();
				details = journey.getDetails();
				text = journey.getText();

				 //ScrollText st = new ScrollText(effect+", "+text+", "+details);
				ScrollText st = new ScrollText("Buss ersätter tågen mellan Malmö C och Lund C pga ett löv på spåret.");
				st.setBounds(0, 6, 1080, 80);
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
			System.out.println(searchURL2);
		}		
	}
	

}
