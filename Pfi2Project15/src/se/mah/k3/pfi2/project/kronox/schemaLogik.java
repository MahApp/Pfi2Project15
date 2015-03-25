package se.mah.k3.pfi2.project.kronox;

import java.io.IOException;

import se.mah.k3.pfi2.project.test.KronoxAJAXGetFriendlyNames;
//här vill jag samla all logik till testschemat
public class schemaLogik {
	KronoxAJAXGetFriendlyNames kronoxNames = new KronoxAJAXGetFriendlyNames();
	String courseString;
	public schemaLogik() {
		try {

			this.courseString = kronoxNames.getCourseName("KD322B");
			System.out.println("JSON to parse for courseName: "+ courseString);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public String getCourseName(){
		
		return courseString;
	}
}
