package se.mah.k3lara.skaneAPI.xmlparser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.control.Helpers;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;


public class Parser {
	  /**
  	 * Calls Sk�netrafiken API and searches for stations containing a String
  	 * Use this Url to test from a browser:
  	 * http://www.labs.skanetrafiken.se/v2.2/querystation.asp?inpPointfr=malm�
  	 * More information
  	 * @param serachStart string to search for
  	 * @return list of stations that fulfils the search criteria. 
  	 * Always returns a number of central stations like Malm� Copenhagen etc
  	 * */
	public static List<Station> getStationsFromURL(String searchStart){
		List<Station> foundStations = new ArrayList<Station>();
		String name;
		String x;
		String y;
		String id;
		 XMLParser parser = new XMLParser();
	     String xml = parser.getXmlFromUrl(Constants.baseURL+Constants.getStationURL+searchStart);
	     if (xml!=null){
				Document doc = parser.getDomElement(xml); // getting DOM element
				NodeList nl = doc.getElementsByTagName("Point");
				for (int i = 0; i < nl.getLength(); i++) {
					Element e = (Element) nl.item(i);
					name  = parser.getValue(e,"Name");
					id = parser.getValue(e,"Id");
					x = parser.getValue(e, "X");
					y = parser.getValue(e, "Y");
					foundStations.add(new Station(name,id,x,y));
				}
	     }
		return foundStations;
	}
	
	 /**
  	 * Calls Sk�netrafiken API and searches for departures from a certain station to another station
  	 * Use this URL to test from a browser:
  	 * http://www.labs.skanetrafiken.se/v2.2/resultspage.asp?cmdaction=next&selPointFr=malm�%20C|80000|0&selPointTo=landskrona|82000|0&LastStart=2015-02-24 16:38
  	 * More information
  	 * @param serachURL string to search for
  	 * @return a Jourenys object that contains information on journeys from a station to another specified station. 
  	 * */
	public static Journeys getJourneys(String searchURL){
    	Journeys journeys = new Journeys();
        XMLParser parser = new XMLParser();
        Station toStation;
        Station fromStation;
        String line;
        Calendar depTime;
        Calendar arrTime;
		String xml = parser.getXmlFromUrl(searchURL); // getting XML
		if (xml!=null){
			Document doc = parser.getDomElement(xml); // getting DOM element
			//Get departure and arrival time
			NodeList nl = doc.getElementsByTagName("Journey");
			// looping through all item nodes <item>
			for (int i = 0; i < nl.getLength(); i++) {
				Element e = (Element) nl.item(i);
				
				//Get the first station
				NodeList fromNode = e.getElementsByTagName("From");
				String fromStationName ="";
				String fromStationID ="";
				for (int j =0;j < fromNode.getLength();j++){
					Element e2 = (Element) fromNode.item(j);
						fromStationName = parser.getValue(e2, "Name");
						fromStationID =parser.getValue(e2, "Id");
				}
				fromStation = new Station(fromStationName, fromStationID);	
				
				//Get the last station on the journey
				NodeList toNode = e.getElementsByTagName("To");
				String toStationName ="";
				String toStationID ="";
				for (int j =0;j < toNode.getLength();j++){
					Element e2 = (Element) toNode.item(j);
					if (j==(toNode.getLength()-1)){	//get the last stop
						toStationName = parser.getValue(e2, "Name");  
						toStationID = parser.getValue(e2, "Id");
					}else{
						
						//Here is the place to get the intermediate stops
					}
				}
				toStation = new Station(toStationName, toStationID);
				//Get the line for the first journey
				NodeList lineNode = e.getElementsByTagName("Line");
				line = "";
				for (int j =0;j < lineNode.getLength();j++){
					Element e2 = (Element) lineNode.item(j);
					if (j==0){
						line = parser.getValue(e2, "Name");
					}else{
						//Here is the place to get Line for other stations along the journey between startStation and endStation
					}	
				}
				
				String depTimeString = parser.getValue(e, "DepDateTime");
			    String arrTimeString = parser.getValue(e, "ArrDateTime");
			    String travelMinutes = Helpers.getTravelTimeinMinutes(depTimeString, arrTimeString);
			    depTime = Helpers.parseCalendarString(depTimeString);
			    arrTime = Helpers.parseCalendarString(arrTimeString);
			    Journey thisJourney = new Journey(fromStation,toStation);
			    thisJourney.setLineOnFirstJourney(line);
			    thisJourney.setDepDateTime(depTime);
			    thisJourney.setArrDateTime(arrTime);
			    thisJourney.setNoOfChanges(parser.getValue(e, "NoOfChanges"));
			    thisJourney.setTravelTime(travelMinutes);
			    thisJourney.setTimeToDeparture(Helpers.timeToDeparture(depTimeString));
			    thisJourney.setNoOfZones(parser.getValue(e, "NoOfZones"));
			    thisJourney.setLineTypeName(parser.getValue(e, "TransportModeName"));
			    thisJourney.setArrTimeDeviation( parser.getValue(e, "ArrTimeDeviation"));
			    thisJourney.setDepTimeDeviation( parser.getValue(e, "DepTimeDeviation"));
			    journeys.addJourney(thisJourney);
			}
		}
    	return journeys;
    }
	
	 /**
  	 * Calls Sk�netrafiken API and searches for nest departures from a certain station returns all lines leaving that station
  	 * Use this Url to test from a browser from ub�tshallen:
  	 * http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=80046 
  	 * More information
  	 * @param Station departure station
  	 * @return a Lines object containing information on lines leaving the specified station. 
  	 * */
	public static Lines getStationResults(Station station){
		boolean debug = true;
		String searchURL = Constants.getStationResultURL(station);
		XMLParser parser = new XMLParser();
		String lineNo;
		Calendar depTime;
		String depTimeDeviation;
		String destination;
		String stopPoint;
		
		Lines lines = new Lines(station);
		String xml = parser.getXmlFromUrl(searchURL); // getting XML
		if (xml!=null){
			Document doc = parser.getDomElement(xml); // getting DOM element
			//Get departure and arrival time
			NodeList nl = doc.getElementsByTagName("Line"); //Get all nodes of type Line
			for (int i = 0; i < nl.getLength(); i++) { //Iterate all Line elements
				Element e = (Element) nl.item(i);  //Get the XML element Line;
				//Get the value for that tag "No"
				lineNo = parser.getValue(e, "No"); 
				if(debug){System.out.println("LineNo: "+ lineNo);} //For debugging.....
				//Get the value for the tag "JourneyDateTime" //That is departuretime and date as String
				String journeyDateTime = parser.getValue(e, "JourneyDateTime"); 
				if(debug){System.out.println("JourneyDateTime: "+ journeyDateTime);}
				//Convert the String to a Calendar object with a helper method written for this in the Helpers class
				depTime = Helpers.parseCalendarString(journeyDateTime);
				
				destination= parser.getValue(e, "Towards");
				if(debug){System.out.println("Towards: "+ destination);}
				//Get the value for that tag "JourneyDateTime"
				depTimeDeviation = parser.getValue(e, "DepTimeDeviation"); 
				if(debug){System.out.println("DepTimeDeviation: "+ depTimeDeviation);}
				
				
				//Continue with all other elements in the Line node.......
				//....
				
				stopPoint = parser.getValue(e, "StopPoint"); 
				if(debug){System.out.println("StopPoint: "+ stopPoint);}
				//Then we got one Line lets create a line object and add it to Lines
				Line l = new Line();
				l.setDestination(destination);
				l.setDepTime(depTime);
				l.setLine(lineNo);
				l.setDepTimeDeviation(depTimeDeviation);
				l.setStopPoint(stopPoint);
				lines.addLine(l);
			
				//Ok next Line element
			}		
		}
		return lines;
	}
}
