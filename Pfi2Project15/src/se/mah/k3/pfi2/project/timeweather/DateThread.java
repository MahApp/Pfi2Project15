package se.mah.k3.pfi2.project.timeweather;

import java.util.Calendar;

public class DateThread extends Thread implements DateInterface {
	
	private DateInterface dateInterface;
	
	public DateThread(DateInterface di){
		this.dateInterface = di;
	}

	@Override
	public void update(int monthIn, int dayIn) {
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
			   dateInterface.update(Calendar.getInstance().get(Calendar.MONTH), 
					   Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		   }
		  
	   }
}