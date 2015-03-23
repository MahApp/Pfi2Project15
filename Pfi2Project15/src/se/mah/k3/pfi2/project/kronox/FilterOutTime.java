package se.mah.k3.pfi2.project.kronox;

import java.util.ArrayList;
import java.util.Calendar;

public class FilterOutTime {
	ArrayList<Post> osorteradePoster= new ArrayList<Post>();
	static Calendar cal;
	
	FilterOutTime(){
		cal=Calendar.getInstance(); // get the current time
		
		
	}
	
	
	
	static public ArrayList<Post> filter(ArrayList<Post> ofiltreradPoster){     // important filtering code
		ArrayList<Post> filtreradePoster= new ArrayList<Post>();
		
		
		// for(Post p: sorteradePoster){  // for each loop search on Google if you dont know it
		//...code here for sorting
		//}
		
	System.out.println("antal post:"+ofiltreradPoster.size());
		if (filtreradePoster.isEmpty()) {
			return ofiltreradPoster;
		} else {
			return filtreradePoster;
		}
	}
	
}
