package timeweather;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
	 
	public class XMLParser { 
	  public static void main(String argv[]) {
		int b;
		String weather;
		String time;
	    try {
	 
		String url = "http://api.openweathermap.org/data/2.5/forecast?q=Malm%C3%B6&mode=xml";
		System.out.println(url);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		//Read and parse the file and place the result in doc
		Document doc = dBuilder.parse(url);
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("temperature");
		NodeList nList1 = doc.getElementsByTagName("symbol");
		NodeList nList2 = doc.getElementsByTagName("time");
		System.out.println("----------------------------");
		
		for (int temp = 0; temp < 4; temp++) {
			Node nNode2 = nList2.item(temp);
			if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode2;
				time = eElement.getAttribute("from");
				System.out.println("Time from : " + eElement.getAttribute("from").substring(11, 16));
			}
		}
		//String c = "";
		for (int temp = 0; temp < 4; temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				String c = eElement.getAttribute("value");
				float a = Float.parseFloat(c);
				b =(int)a; 
				System.out.println("Temperature : " + b + "°c");
			}
		}
		
		for (int temp = 0; temp < 4; temp++) {
			Node nNode1 = nList1.item(temp);
			if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode1;
				weather = eElement.getAttribute("name");
				System.out.println("Weather : " + eElement.getAttribute("name"));
			}
		}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	  }

	 
}
