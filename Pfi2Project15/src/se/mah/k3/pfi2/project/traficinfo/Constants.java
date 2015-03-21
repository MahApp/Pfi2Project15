package se.mah.k3.pfi2.project.traficinfo;



public class Constants {
	public static final String testURL = "http://www.labs.skanetrafiken.se/v2.2/resultspage.asp?cmdaction=next&selPointFr=%7C81116%7C0&selPointTo=%7C65008%7C0&LastStart=2012-10-14%2008:00";
	public static final String baseURL = "http://www.labs.skanetrafiken.se/v2.2/";
	public static final String queryURL = "resultspage.asp?cmdaction=next&selPointFr=";
	public static final String getStationURL = "querystation.asp?inpPointfr=";
	public static final String stationResultURL = "stationresults.asp?selPointFrKey=";
	public static final String pipe = "%7C";
	public static final String space = "%20";
	public static final String midPartURL = "0&selPointTo=";
	public static final String lastPartURL = "0&LastStart=";
	public static final String noOfResults = "&NoOf=";
	public static int nbrResultsToGet = 25;


	/**
	 * Build the Querystringz
	 * @param startStationNumber from sk�netrafiken
	 * @param endStationNumber from sk�netrafiken
	 * @param date for first start from in form yyyy-mm-dd
	 * @param time in format hh:mm 24 H
	 * @param nbrResults max 20
	 * */
	public static String getURL(String startStationNumber, String endStationNumber  , String date, String time, int nbrResults){
		String nbrRes = String.valueOf(nbrResults);
		String url = baseURL + queryURL + pipe+startStationNumber + pipe + midPartURL +pipe + endStationNumber + pipe + lastPartURL + date + space + time+noOfResults+nbrRes;
		return url;
	}
	
	/**
	 * Build the Querystringz
	 * @param startStationNumber from sk�netrafiken
	 * @param endStationNumber from sk�netrafiken
	 * @param nbrResults max 20 from now
	 * */
	public static String getURL(String startStationNumber, String endStationNumber, int nbrResults){
		String nbrRes = String.valueOf(nbrResults);
		String url = baseURL + queryURL + pipe+startStationNumber + pipe + midPartURL +pipe + endStationNumber + pipe + "0"+ noOfResults+nbrRes;
		return url;
	}
	
	/**
	 * Build the StationresultURL
	 * @param startStationNumber from sk�netrafiken
	 * */
	public static String getStationResultURL(Station station){
		String url = baseURL + stationResultURL +station.getStationNbr();
		return url;
	}
	
}
