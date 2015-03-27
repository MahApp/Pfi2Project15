package se.mah.k3.pfi2.project.kronox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.impl.cookie.DateUtils;



public class FilterOutTime {
	ArrayList<Post> osorteradePoster= new ArrayList<Post>();
	
	static Calendar cal;
	
	static Calendar cal2;
	static Calendar cal3;
	 
	static int minuteMargin =120; // timespan that post filters out from 30min is standard
	FilterOutTime(){
		cal=Calendar.getInstance(); // get the current time		
	}
	

	static public ArrayList<Post> filter(ArrayList<Post> ofiltreradPoster){     // important filtering code
		ArrayList<Post> filtreradePoster= new ArrayList<Post>();
		filtreradePoster.clear();
		System.out.println(minuteMargin +"time ");
		//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		 Date timeBefore= new Date(),timeAfter= new Date(); // time stamp where 
		//		timeBefore=null;
		//		timeAfter= null;
		System.out.println(ofiltreradPoster.size() +" amount ");
		for (int i = 0; i < ofiltreradPoster.size(); i++)
		{
//			try {
//				//timeBefore=sdf.parse(ofiltreradPoster.get(i).getStartTid());
//				//timeAfter=sdf.parse(ofiltreradPoster.get(i).getStartTid());
//				//System.out.println(timeBefore.getHours()+" "+timeBefore.getMinutes());
//				//cal2.setTime(sdf.parse(ofiltreradPoster.get(i).getStartTid()));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			timeAfter=new Date(System.currentTimeMillis()+minuteMargin*60*1000);
			timeBefore=new Date(System.currentTimeMillis()-minuteMargin*60*1000);
			
			if(Parser.debug)System.out.println(" timeAfter"+timeAfter);
			if(Parser.debug)System.out.println(" timeBefore"+timeBefore);
			
			System.out.println(ofiltreradPoster.get(i).getStartTidCal());
			
			//float postTime = Float.parseFloat(ofiltreradPoster.get(i).getStartTid());
			if(!timeBefore.before(ofiltreradPoster.get(i).startTidCal)) {
				//filtreradePoster.add(ofiltreradPoster.get(i));
				if(Parser.debug)System.err.println(ofiltreradPoster.get(i).startTidCal+ " before");
			}else if(!timeAfter.after(ofiltreradPoster.get(i).startTidCal)){
			//filtreradePoster.add(ofiltreradPoster.get(i));
				if(Parser.debug) System.err.println(ofiltreradPoster.get(i).startTidCal+ " after");
			}else{
				filtreradePoster.add(ofiltreradPoster.get(i));
			}

	
			

		}

		//String time = cal.toString();
		//float calTime = Float.parseFloat(time);
	
		
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
		
	System.out.println("antal post: "+filtreradePoster.size() +" efter starttids filtrering");
			return filtreradePoster;
		
	}
	
}
