package se.mah.k3.pfi2.project.timeweather;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class WeatherParser {
	
	public static Weathers weatherParserPrognosis(){
		String temperature;
		String weather;
		boolean debugging = false;
		Weathers weathers = new Weathers();
	
		try {
			
			
			//String url = "http://api.openweathermap.org/data/2.5/forecast?q=Malm%C3%B6&mode=xml";
			String url = "http://api.openweathermap.org/data/2.5/forecast?q=Malmo,se&mode=xml";
			if(debugging){
				System.out.println(url);
			}
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//Read and parse the file and place the result in doc
			Document doc = dBuilder.parse(url);
			doc.getDocumentElement().normalize();
			if(debugging){
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			}
			NodeList nList = doc.getElementsByTagName("temperature");
			NodeList nList1 = doc.getElementsByTagName("symbol");
			NodeList nList2 = doc.getElementsByTagName("time");
			if(debugging){
				System.out.println("----------------------------");
			}
			
			ArrayList<String> timeList = new ArrayList<String>();
			for (int temp = 0; temp < 4; temp++) {
				Node nNode2 = nList2.item(temp);
				if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode2;
					System.out.println("Time from : " + eElement.getAttribute("from").substring(11, 16));
					String t = eElement.getAttribute("from").substring(11, 16);
					timeList.add(t);
				}
			}
			//String c = "";
			ArrayList<String> temperatureList = new ArrayList<String>();
			for (int temp = 0; temp < 4; temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String c = eElement.getAttribute("value");
					float a = Float.parseFloat(c);
					int b;
					b =(int)a; 
					String stringTemp = String.valueOf(b);
					//System.out.println("Temperature : " + b + "c");
					temperatureList.add(stringTemp);
					
				}
			}
			
			
			
			ArrayList<String> weatherList = new ArrayList<String>();
			for (int temp = 0; temp < 4; temp++) {
				Node nNode1 = nList1.item(temp);
				if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode1;
					//System.out.println("Weather : " + eElement.getAttribute("name"));
					String w = eElement.getAttribute("name");
					weatherList.add(w);
					
				}
			}
			
			System.out.println(temperatureList);
			System.out.println(weatherList);
			
			Weather thisWeather = new Weather();
			thisWeather.setTemperature(temperatureList);
			thisWeather.setWeather(weatherList);
			thisWeather.setTimeList(timeList);
			weathers.addWeather(thisWeather);
			
			
			
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		return weathers;
		   
		
		  }
	}


