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
		String hours;
		
		if(minuteIn<10){
			minute = "0" + String.valueOf(minuteIn);
		}else{
			minute = String.valueOf(minuteIn);
		}
		
		if(hoursIn<10){
			hours = "0" + String.valueOf(hoursIn);
		}else{
			hours = String.valueOf(hoursIn);
		}
		
		currentTime = hours + ":" + minute;
		
		timePanel.showTime(currentTime);

	}

}
