package se.mah.k3.pfi2.project.social;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.*;

public class JSonParser {

	public String file;

	public void parseJSon(String json) {
		JSONObject obj;
		try {
			obj = new JSONObject(json);

			// Bild (640x640)
			JSONArray data = obj.getJSONArray("data");
			JSONObject object = data.getJSONObject(0);
			JSONObject images = object.getJSONObject("images");
			JSONObject standard_resolution = images
					.getJSONObject("standard_resolution");
			System.out.println(standard_resolution.getString("url"));

			// Avsändare
			JSONObject caption = object.getJSONObject("caption");
			JSONObject from = caption.getJSONObject("from");
			System.out.println(from.getString("username"));

			// Bildtext
			System.out.println(caption.getString("text"));

			// Post-tid
			String postTime = caption.getString("created_time");// (1) Läser in
																// tiden som
																// String från
																// Json, format:
																// unixTime
			Long longTime = 0L;

			// (2) Konvertera unixTime String till Long
			try {
				longTime = Long.parseLong(postTime);
			} catch (NumberFormatException e) {
				//e.printStackTrace();
			}

			System.out.println("****** Slutgiltigt Tidsformat ********");
			System.out.println(getPostTime(longTime));// (3) Skickar Long
														// unixTime till metoden
														// this.getPostTime().
														// Och tar emot
														// postTime,
														// färdigformaterad
			System.out.println("****** /Slutgiltigt Tidsformat ********");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	// (4) Här skapas en instans av DateTimeUtils
	private String getPostTime(long l) {

		DateTimeUtils dateConverter = new DateTimeUtils();
		return dateConverter.calcTimeDifference(l);// Här kommer datumString
													// tillbaka,
													// färdigformaterad
	}

	public String fetchData(String https_url) {

		URL url;
		
		try {
			url = new URL(https_url);
			HttpsURLConnection con;
			con = (HttpsURLConnection) url.openConnection();
			
			
			file = print_content(con);
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("MalformedURLException");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("IOException");
		}
		
		
		return this.file;

	}

	private String print_content(HttpsURLConnection con) {
		String file = "";
		if (con != null) {

			try {

				BufferedReader br = new BufferedReader(new InputStreamReader(
						con.getInputStream()));

				String input;

				while ((input = br.readLine()) != null) {
					file = file + input + "\n";
				}
				br.close();
				
				
				//System.out.println(file);
				if (file == ""){
					System.out.println("No data recieved, please check your connection to Instagram API!");
				}

			} catch (IOException e) {
				//e.printStackTrace();
			}

		}
		return file;

	}
}