package se.mah.k3.pfi2.project.timeweather;

import se.mah.k3.pfi2.project.kronox.KronoxPanel;

public class DateLogic implements DateInterface {
private TimePanel timePanel;
	
	public DateLogic(TimePanel tp){
		this.timePanel = tp;
		Thread t = new DateThread(this,tp);
		t.setName("DateThread");
		t.start();
	}

	@Override
	public void update(int hoursIn, int minuteIn,int monthIn, int dayIn) {
		String currentDate;
		String currentTime;
		String minute;
		String hours;
		
		String monthString;
		String[] monthNames = {"Januari", "Februari", "Mars", "April", "Maj", "Juni", "Juli", "Augusti", "September", "Oktober", "November", "December"};
		monthString = monthNames[monthIn];
		
		currentDate = String.valueOf(dayIn) + " " + monthString;
		
		timePanel.showDate(currentDate);
		
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
