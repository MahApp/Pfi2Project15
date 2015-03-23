package se.mah.k3.pfi2.project.kronox;

import java.util.ArrayList;

public class FilterOutBiulding {

	ArrayList<Post> osorteradePoster = new ArrayList<Post>();
	FilterOutBiulding() {
	}

	static public ArrayList<Post> filter(ArrayList<Post> ofiltreradPoster) { // important filter code
		ArrayList<Post> filtreradePoster = new ArrayList<Post>();

		// for(Post p: sorteradePoster){ // for each loop search on Google if
		// you dont know it
		// ...code here for sorting
		// }
		
		System.out.println("antal post:"+ofiltreradPoster.size());
		if (filtreradePoster.isEmpty()) {
			return ofiltreradPoster;
		} else {
			return filtreradePoster;
		}
	}
}
