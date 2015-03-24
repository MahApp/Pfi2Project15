package se.mah.k3.pfi2.project.kronox;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FilterOutTime {
	ArrayList<Post> osorteradePoster= new ArrayList<Post>();
	static Calendar cal;
	static  Date timeBefore,timeAfter; // time stamp where 
	int minuteMargin =30; // timespan that post filters out from 30min is standard
	FilterOutTime(){
		cal=Calendar.getInstance(); // get the current time
		
		
	}
	
	
	
	static public ArrayList<Post> filter(ArrayList<Post> ofiltreradPoster){     // important filtering code
		ArrayList<Post> filtreradePoster= new ArrayList<Post>();
		
		
		// for(Post p: sorteradePoster){  // for each loop search on Google if you dont know it
		//...code here for sorting
		//}
		/*SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm"); // Date for testing hint
		Date d = null;
		try {
			 d = sdf.parse("2015-03-23 10:30");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.set(2013, 03, 23, 10, 30);
		for(int i=0; i<storedPost.size();i++){          // remove post that is old
			//if(storedPost.get(i).startTidCal.before(cal.getTime())){ //currentTime
			if(storedPost.get(i).startTidCal.before(d)){ //currentTime

			storedPost.remove(i);
			}
		}*/
		
	System.out.println("antal post:"+ofiltreradPoster.size() +"efter starttids filtrering");
		if (filtreradePoster.isEmpty()) {
			return ofiltreradPoster;
		} else {
			return filtreradePoster;
		}
	}
	
}
