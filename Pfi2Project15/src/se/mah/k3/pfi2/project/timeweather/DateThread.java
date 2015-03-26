package se.mah.k3.pfi2.project.timeweather;

import java.util.Calendar;

public class DateThread extends Thread implements DateInterface {
	private TimePanel timePanel;
	private DateInterface dateInterface;
	
	public DateThread(DateInterface di,TimePanel timePanel){
		this.dateInterface = di;
		this.timePanel=timePanel;
	}

	@Override
	public void update(int hoursIn, int minuteIn, int monthIn, int dayIn) {
		// TODO Auto-generated method stub

	}

	@Override
	   public void run() {
		   while (true) {
			   try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			   dateInterface.update(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), 
					   Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.MONTH), 
					   Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
			   timePanel.repaintPanel();
			  
		   }
		  
	   }
}