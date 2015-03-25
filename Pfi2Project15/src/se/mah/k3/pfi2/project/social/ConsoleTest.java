package se.mah.k3.pfi2.project.social;

import org.apache.commons.codec.binary.Base64;

public class ConsoleTest {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try{
			// Superotydliga variabelnamn med vilje.
			String fooIn = "aHR0cHM6Ly9hcGkuaW5zdGFncmFtLmNvbS92MS91c2Vycy8xNzUyOTE4MzAyL21lZGlhL3JlY2VudC8/YWNjZXNzX3Rva2VuPTE3NTI5MTgzMDIuMTU0MWZjNi5mNjY2MzY4MjRhNzM0NDRiYTY1ODBiNTVjZTZmOTJjNw==";
			
			byte[] fooOut = Base64.decodeBase64( fooIn );
			
			String fooFinal = new String(fooOut); //, "UTF-8"
			
			final String instaURL = fooFinal + "&count=1";
			
			
			final JSonParser json = new JSonParser();
			String data = json.fetchData(instaURL, 2);
			
			
			String fooErrorCode = " \"code\":400";
			if(data == ""){
				System.out.println("No Instagram data :(");
			}else if(data.toLowerCase().contains(fooErrorCode.toLowerCase())){
				System.out.println("Couldn't fetch the right data. Error: \n" + fooErrorCode);
			}else{
				json.parseJSon(data, 2);
			}
		}
		catch(Exception  e){
			//e.printStackTrace();
		}

		
	}

}
