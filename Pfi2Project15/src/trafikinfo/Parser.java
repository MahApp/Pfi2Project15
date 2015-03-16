package trafikinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class Parser {
	  /**
  	 * Calls Skånetrafiken API and searches for stations containing a String
  	 * Use this Url to test from a browser:
  	 * More information
  	 * @param serachStart string to search for
  	 * @return list of stations that fulfills the search criteria. 
  	 * Always returns a number of central stations like Malmö Copenhagen etc
  	 * Ok testar
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
  	 * Calls Skånetrafiken API and serches for departures from a certain station
  	 * Use this Url to test from a browser:
  	 * 
  	 * More information
  	 * @param serachURL string to search for
  	 * @return list of juoreys leaving the specified station. 
  	 * Always returns a number of central stations like Malmö Copenhagen etc
  	 * */
	public static Journeys getJourneys(String searchURL){
    	Journeys journeys = new Journeys();
        XMLParser parser = new XMLParser();
        Station toStation;
        Station fromStation;
        String line;
        Calendar depTime;
        Calendar arrTime;
        int depTimeDeviation;
 
        
        
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
}
