package se.mah.k3.pfi2.project.timeweather;

import se.mah.k3.pfi2.project.kronox.KronoxPanel;

public class DateLogic implements DateInterface {
private TimePanel timePanel;
	
	public DateLogic(TimePanel tp){
		this.timePanel = tp;
		Thread t = new DateThread(this);
		t.setName("DateThread");
		t.start();
	}

	@Override
	public void update(int monthIn, int dayIn) {
		String currentDate;
		
		String monthString;
		String[] monthNames = {"Januari", "Februari", "Mars", "April", "Maj", "Juni", "Juli", "Augusti", "September", "Oktober", "November", "December"};
		monthString = monthNames[monthIn];
		
		currentDate = String.valueOf(dayIn) + " " + monthString;
		
		timePanel.showDate(currentDate);

	}
	
}
