package timeweather;

import java.util.Calendar;

public class TimeThread extends Thread implements TimeInterface {
	
	private TimeInterface timeInterface;
	
	public TimeThread(TimeInterface ti){
		this.timeInterface = ti;
	}

	@Override
	public void update(int hoursIn, int minuteIn) {
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
			   timeInterface.update(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), 
					   Calendar.getInstance().get(Calendar.MINUTE));
		   }
		  
	   }
}