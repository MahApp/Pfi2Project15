package se.mah.k3.pfi2.project.kronox;

import java.util.ArrayList;

public class FilterOutBiulding {
//	static Parser parser1 = new  Parser(); parser �r statisk ..den beh�ver inte instancieras
	ArrayList<Post> osorteradePoster = new ArrayList<Post>();
	static String currentBuilding = "";
	
	static String getBuilding;
	
	FilterOutBiulding() {
	}

	static public ArrayList<Post> filter(ArrayList<Post> ofiltreradPoster) { // important filter code
		ArrayList<Post> filtreradePoster = new ArrayList<Post>();

		// for(Post p: sorteradePoster){ // for each loop search on Google if you dont know it
		// ...code here for sorting
		// }
		
	//	currentBuilding = parser1.getbuilding(); parser �r statisk
		currentBuilding= Parser.biulding;
		for (int i = 0; i < ofiltreradPoster.size(); i++) {
			getBuilding = ofiltreradPoster.get(i).getBiulding();
			
			if (getBuilding != currentBuilding) {
				System.out.println("wrong building ");
			}else{
				filtreradePoster.add(ofiltreradPoster.get(i));
			}
		}
		
		
		System.out.println("DENNA BYGGNAD: \n " + currentBuilding + "\n\n_______________");
		System.out.println("antal post:"+ofiltreradPoster.size() +"efter byggnads filtrering");
		if (filtreradePoster.isEmpty()) {
			return ofiltreradPoster;
		} else {
			return filtreradePoster;
		}
	}
}
