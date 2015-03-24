package se.mah.k3.pfi2.project.kronox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class FilterOutTime {
	ArrayList<Post> osorteradePoster= new ArrayList<Post>();
	static Calendar cal;
	static Calendar cal2;
	static Calendar cal3;
	
	FilterOutTime(){
		cal=Calendar.getInstance(); // get the current time
		
	
		
	}
	

	static public ArrayList<Post> filter(ArrayList<Post> ofiltreradPoster){     // important filtering code
		ArrayList<Post> filtreradePoster= new ArrayList<Post>();
		SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm:ss");
		//String time = cal.toString();
		//float calTime = Float.parseFloat(time);
		
		
		for (int i = 0; i < ofiltreradPoster.size(); i++)
		{
			try {
				cal2.setTime(sdf.parse(ofiltreradPoster.get(i).getStartTid()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				cal3.setTime(sdf.parse(ofiltreradPoster.get(i).getSlutTid()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//float postTime = Float.parseFloat(ofiltreradPoster.get(i).getStartTid());
			if(cal.after(cal2) && cal.before(cal3)){
				
				
			}
			
			
		}
		
		// for(Post p: sorteradePoster){  // for each loop search on Google if you dont know it
		//...code here for sorting
		//}
		
	System.out.println("antal post:"+ofiltreradPoster.size() +"efter starttids filtrering");
		if (filtreradePoster.isEmpty()) {
			return ofiltreradPoster;
		} else {
			return filtreradePoster;
		}
	}
	
}
