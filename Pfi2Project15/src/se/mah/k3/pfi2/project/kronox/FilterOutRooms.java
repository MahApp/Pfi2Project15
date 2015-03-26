package se.mah.k3.pfi2.project.kronox;

import java.util.ArrayList;

public class FilterOutRooms {

	ArrayList<Post> osorteradePoster= new ArrayList<Post>();
   
	static String startTid;
	static String slutTid;
	static String getMoment;
	static String getSalID;
	
	FilterOutRooms(){
		
		//Konstruktor
	}
	
	public static  ArrayList<Post> filter(ArrayList<Post> ofiltreradPoster){     // important filter code
		
		ArrayList<Post> filtreradePoster= new ArrayList<Post>();
		for (int i = 0; i < ofiltreradPoster.size(); i++) {
			
			// kolla om Moment = tomt
			if (ofiltreradPoster.get(i).getMoment() == null) {
				getMoment = "";
			} else {
				getMoment = ofiltreradPoster.get(i).getMoment();
			}

			// Kolla om salIDt är tomt
			if (ofiltreradPoster.get(i).getSalID() == null) {
				getSalID = "";
			} else {
				getSalID = ofiltreradPoster.get(i).getSalID();
			}
			
			// OBS! Om salID inte existerar, lägg inte till. 
			if (getSalID.isEmpty()) {
				System.out.println("no Sal \n");
			}else if(getMoment.isEmpty()){
				System.out.println("no moment \n");
			}else{
				filtreradePoster.add(ofiltreradPoster.get(i));
			}
		}
		
		System.out.println("antal post: "+ofiltreradPoster.size() +" efter rum filtrering");
		if (filtreradePoster.isEmpty()) {
			return ofiltreradPoster;
		} else {
			return filtreradePoster;
		}
	}
	
}

