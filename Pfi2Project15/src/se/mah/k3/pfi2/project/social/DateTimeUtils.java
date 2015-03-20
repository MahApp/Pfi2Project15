package se.mah.k3.pfi2.project.social;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtils {

	private boolean debug = false;
	
	/*
	 * Den här klassen hjälper oss att översätta unix tiden från Instagram API:et, samt tiden från systemet programmet körs på. 
	 * Resultatet är förfluten tid i dagar eller veckor, så som Instagram gör det.
	 */
	
	//(5) Här kommer postTime (format: unixTime) in som Long.
	public String calcTimeDifference(long l) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		
		//Convert postTime from unixTime format to normal human time format
		Date date = new java.util.Date(l*1000); // *1000 is to convert seconds to milliseconds
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss"); // the format of your date
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+1")); // give a timezone reference for formating (see comment at the bottom
		String formattedDate = sdf.format(date);
		
		//Convert System.Time from unixTime format to normal human time format
		Date date2 = new Date(Long.parseLong(String.valueOf(System.currentTimeMillis()))); // *1000 is to convert seconds to milliseconds
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/M/yyyy hh:mm:ss"); // the format of your date
		String formattedDate2 = sdf2.format(date2);
		
		//Förbered en String som ska innehålla 'idag', '#d' eller '#v'
		String returnTime = "";
		
		//Här konverterar vi tiden till Date formatet
		try {

			Date timePosted = simpleDateFormat.parse(formattedDate); //Post time
			Date systemTime = simpleDateFormat.parse(formattedDate2); //Current time
			
			//(6) Skapar en String efter Instagrams datumlayout
			returnTime = generateDateString(timePosted, systemTime);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//(7) Här returneras postTime i formatet 'idag', '#d' eller '#v'
		return returnTime;

	}

	// Skapar en String efter Instagrams datumlayout ('idag', '#d' eller '#v')
	public String generateDateString(Date startDate, Date endDate){
		
		//milliseconds
		long different = endDate.getTime() - startDate.getTime();

		if (debug){
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : "+ endDate);
		System.out.println("different : " + different);
		}

		//1 minute = 60 seconds
		//1 hour = 60 x 60 = 3600
		//1 day = 3600 x 24 = 86400
		//1 week = 86400 x 7 = 604800
		
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long weeksInMilli = daysInMilli * 7;
		
		long elapsedWeeks = different / weeksInMilli;
		different = different % weeksInMilli;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		long elapsedSeconds = different / secondsInMilli;

		if (debug){
		System.out.printf(
				"%d weeks, %d days, %d hours, %d minutes, %d seconds%n", 
				elapsedWeeks,
				elapsedDays,
				elapsedHours, elapsedMinutes, elapsedSeconds);
		}
		
		String returnTime = "Unknown date";
		
		if (elapsedWeeks > 0){
			returnTime =  String.valueOf(elapsedWeeks) + "v";
		}
		else if (elapsedDays > 0){
			returnTime = String.valueOf(elapsedDays) + "d";
		}
		else if (elapsedDays == 0 && elapsedWeeks == 0) {
			returnTime = "idag";
		}
		return returnTime;
	}

}