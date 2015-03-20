package se.mah.k3.pfi2.project.social;
import java.util.Calendar;
import java.util.Date;


public class Helpers {
	/**
	 * Converts Unix time to Calendar instance.
	 */
	public static Calendar unixToCalendar(long unixTime){
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTimeInMillis(unixTime);
	    return calendar;
	}
	
	/**
  	 *Returns now
  	 * @return Calendar object
  	 * */
    public static Calendar getTimeNow(){
    	Calendar now = Calendar.getInstance();
    	now.setTime(new Date());
    	return now;
    }
    
    /**
  	 * Is a dateTime today
  	 * @param dateTimeString in format 2012-10-15T08:17:00
  	 * @return true if today
  	 * */
    /*
    public static boolean isToday(String depDateTime) {
    	boolean isToday = false;
		Calendar depDate = parseCalendarString(depDateTime);
		int depDay = depDate.get(Calendar.DAY_OF_MONTH);
		Calendar now = getTimeNow();
		int nowDay = now.get(Calendar.DAY_OF_MONTH);
		if (depDay==nowDay){
			isToday = true;
		}
		return isToday;
	}
	*/
}
