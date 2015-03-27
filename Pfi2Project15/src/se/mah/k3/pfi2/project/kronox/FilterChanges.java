package se.mah.k3.pfi2.project.kronox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FilterChanges {
	
	//static int minuteMargin = 20160; // veckor
	static int minuteMargin = 1440; // dag
	
	static public ArrayList<Post> filter(ArrayList<Post> poster){     // important filtering code
		 Date timeBefore= new Date(),timeAfter= new Date(); // time stamp where 

		for (int i = 0; i < poster.size(); i++)
		{			
			timeBefore=new Date(System.currentTimeMillis()-minuteMargin*60*1000);
				if(Parser.debug)System.out.println(" senaste andrad before"+timeBefore);
			if(!timeBefore.after(poster.get(i).startTidCal)) {
				if(Parser.debug)System.err.println(poster.get(i).startTidCal+ " before");
			}else{
				//Ska denna vara en boolean? Eller använder jag fel funktion?
				poster.get(i).setChanged(true); 
				if(Parser.debug)System.out.println(i+" change is true");
			}
			System.out.println(poster.get(i).getChanged());
		}
		
		System.out.println("antal post:"+poster.size() +"efter starttids filtrering");
		return poster;
		
	}

}
