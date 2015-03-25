package se.mah.k3.pfi2.project.social;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;
import org.json.*;

public class JSonParser {

	public String file;
	private final String fooPt1 = "aHR0cHM6Ly9hcGkuaW5zdGFncmFtLmNvbS92MS91c2Vycy9zZWFyY2g/cT0=";
	private final String fooPt2 = "JmFjY2Vzc190b2tlbj0xNzUyOTE4MzAyLjE1NDFmYzYuZjY2NjM2ODI0YTczNDQ0YmE2NTgwYjU1Y2U2ZjkyYzcmY291bnQ9MQ==";

	public String imgUrl;
	public String userName;
	public String imgText;
	public String imgUserUrl;
	public String timePosted;

	public void parseJSon(String json) {
		JSONObject obj;
		try {
			obj = new JSONObject(json);

			// Bild (640x640)
			JSONArray data = obj.getJSONArray("data");
			JSONObject object = data.getJSONObject(0);
			JSONObject images = object.getJSONObject("images");
			JSONObject standard_resolution = images.getJSONObject("standard_resolution");
			imgUrl = standard_resolution.getString("url");
			System.out.println(imgUrl);

			// Avsändare
			JSONObject caption = object.getJSONObject("caption");
			JSONObject from = caption.getJSONObject("from");
			userName = from.getString("username");
			System.out.println(userName);
			
			imgUserUrl = from.getString("profile_picture");
			System.out.println(imgUserUrl);

			// Bildtext
			imgText = caption.getString("text");

			System.out.println(imgText);

			String[] imgTextSplit = imgText.split(" ");
			System.out.println(imgTextSplit[0]);
			System.out.println(imgTextSplit[1]);
			
			if(imgTextSplit[0].equals("#Repost")){
				System.out.println("It's a repost");
				imgUserUrl = fetchRepostUserImage(imgTextSplit[1]);
				userName = imgTextSplit[1];
			}




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
			timePosted = getPostTime(longTime);
			System.out.println(timePosted);// (3) Skickar Long
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

	private String fetchRepostUserImage(String username){
		URL url;
		String json = "";
		JSONObject obj;
		String userAvatarImg = "";
		try {
			
			
			byte[] fooPt1Out = Base64.decodeBase64( fooPt1 );
			String fooPt1Final = new String(fooPt1Out);
			
			byte[] fooPt2Out = Base64.decodeBase64( fooPt2 );
			String fooPt2Final = new String(fooPt2Out);
			
			
			
			System.out.println("RepostUrl: " + fooPt1Final + username + fooPt2Final);
			url = new URL(fooPt1Final + username + fooPt2Final);
			System.out.println("O_o");
			HttpsURLConnection con;
			con = (HttpsURLConnection) url.openConnection();

			json = print_content(con);

			obj = new JSONObject(json);

			// Användarbild vid repost (150 x 150)
			JSONArray data = obj.getJSONArray("data");
			JSONObject object = data.getJSONObject(0);
			userAvatarImg = object.getString("profile_picture");
			System.out.println("Repost Avatar Url: " + userAvatarImg);

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("MalformedURLException");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("IOException");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("JSONException");
		}


		return userAvatarImg;
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