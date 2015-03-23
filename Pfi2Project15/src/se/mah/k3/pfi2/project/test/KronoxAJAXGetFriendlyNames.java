package se.mah.k3.pfi2.project.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import android.text.Html;

public class KronoxAJAXGetFriendlyNames {

	private static final String TYPE_COURSE = "typ=kurs";
	@SuppressWarnings("unused")
	private static final String TYPE_PROGRAM = "typ=program";
	@SuppressWarnings("unused")
    private static final String TYPE_TEACHER_ID = "typ=signatur";
	/**
	 * Generate the URL to KronoX' AJAX with the specified search options.
	 * 
	 * @param type
	 *        One of the constants KronoxJSON.TYPE_*
	 * @param search
	 *        Search string (directly passed to KronoX)
	 * @return The URL
	 */
	private static String generateURL(String type, String search) {
		String url = "http://kronox.mah.se/ajax/ajax_autocompleteResurser.jsp?";
		url += type + "&term=" + search;
		return url;
	}
	/**
	 * Accesses KronoX' AJAX auto-complete service and returns the exact data.
	 * 
	 * @param type
	 *        One of the constants KronoxJSON.TYPE_*
	 * @param search
	 *        Search string (directly passed to KronoX)
	 * @return The AJAX response in its entirety
	 * @throws IOException
	 *         Thrown if there is any error while retrieving the file.
	 */
	private static String getData(String type, String search) throws IOException {
		URL url = new URL(generateURL(type, search));
		InputStream in = url.openStream();
		BufferedReader buf = new BufferedReader(new InputStreamReader(in));
		String s, r = "";
		while((s = buf.readLine()) != null) {
			r += s;
		}
		return r;
	}
	
	public static String getTeacherName(String search) throws IOException {
		String data = getData(TYPE_TEACHER_ID, search);
		//Here parse the JSON to extract the name
		return data;
	}
	
	public static String getCourseName(String search) throws IOException {
		String data = getData(TYPE_COURSE, search);
		//Here parse the JSON to extract the name
		return data;
	}
	
	public static String getProgramName(String search) throws IOException {
		String data = getData(TYPE_PROGRAM, search);
		//Here parse the JSON to extract the name
		return data;
	}
	
	
}
