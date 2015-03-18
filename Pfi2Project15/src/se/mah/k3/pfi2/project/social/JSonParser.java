package se.mah.k3.pfi2.project.social;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.json.*;

public class JSonParser {

	public String file;

	public void parseJSon(String json) {
		JSONObject obj;
		try {
			obj = new JSONObject(json);

			// String pageName =
			// obj.getJSONObject("pageInfo").getString("pageName");

			// Bild (640x640)
			JSONArray data = obj.getJSONArray("data");
			JSONObject object = data.getJSONObject(0);
			JSONObject images = object.getJSONObject("images");
			JSONObject standard_resolution = images
					.getJSONObject("standard_resolution");
			System.out.println(standard_resolution.getString("url"));

			// Avs�ndare
			JSONObject caption = object.getJSONObject("caption");
			JSONObject from = caption.getJSONObject("from");
			System.out.println(from.getString("username"));

			// Bildtext
			System.out.println(caption.getString("text"));

			// Post-tid
			String postTime = caption.getString("created_time");// (1) L�ser in
																// tiden som
																// String fr�n
																// Json, format:
																// unixTime
			Long longTime = 0L;

			// (2) Konvertera unixTime String till Long
			try {
				longTime = Long.parseLong(postTime);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			System.out.println("****** Slutgiltigt Tidsformat ********");
			System.out.println(getPostTime(longTime));// (3) Skickar Long
														// unixTime till metoden
														// this.getPostTime().
														// Och tar emot
														// postTime,
														// f�rdigformaterad
			System.out.println("****** /Slutgiltigt Tidsformat ********");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// (4) H�r skapas en instans av DateTimeUtils
	private String getPostTime(long l) {

		DateTimeUtils dateConverter = new DateTimeUtils();
		return dateConverter.calcTimeDifference(l);// H�r kommer datumString
													// tillbaka,
													// f�rdigformaterad
	}

	public String fetchData(String https_url) {

		URL url;
		try {

			url = new URL(https_url);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			// dumpl all cert info
			// print_https_cert(con);

			// dump all the content
			file = print_content(con);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.file;

	}

	private void print_https_cert(HttpsURLConnection con) {

		if (con != null) {

			try {

				System.out.println("Response Code : " + con.getResponseCode());
				System.out.println("Cipher Suite : " + con.getCipherSuite());
				System.out.println("\n");

				Certificate[] certs = con.getServerCertificates();
				for (Certificate cert : certs) {
					System.out.println("Cert Type : " + cert.getType());
					System.out.println("Cert Hash Code : " + cert.hashCode());
					System.out.println("Cert Public Key Algorithm : "
							+ cert.getPublicKey().getAlgorithm());
					System.out.println("Cert Public Key Format : "
							+ cert.getPublicKey().getFormat());
					System.out.println("\n");
				}

			} catch (SSLPeerUnverifiedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@SuppressWarnings("unused")
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
				if (file == null){
					System.out.println("No data recieved, please check your connection to Instagram API!");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return file;

	}
}