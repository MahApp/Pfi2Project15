package timeweather;

import se.mah.k3.pfi2.project.kronox.KronoxPanel;

public class TimeLogic implements TimeInterface {
	private TimePanel timePanel;
	
	public TimeLogic(TimePanel tp){
		this.timePanel = tp;
		Thread t = new TimeThread(this);
		t.setName("TimeThread");
		t.start();
	}
	
	

	@Override
	public void update(int hoursIn, int minuteIn) {
		String currentTime;
		String minute;
		
		if(minuteIn<10){
			minute = "0" + String.valueOf(minuteIn);
		}else{
			minute = String.valueOf(minuteIn);
		}
		
		currentTime = String.valueOf(hoursIn) + ":" + minute;
		
		timePanel.showTime(currentTime);

	}

}
