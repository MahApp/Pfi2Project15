package timeweather;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
	 
	public class XMLParser { 
	  public static void main(String argv[]) {
	 
	    try {
	 
		String url = "http://api.openweathermap.org/data/2.5/forecast?q=Malm%C3%B6&mode=xml";
		System.out.println(url);
		//Prepare
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		//Read and parse the file and place the result in doc
		Document doc = dBuilder.parse(url);
		doc.getDocumentElement().normalize(); //Fixa till lite med xml.....
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("temperature");
		NodeList nList1 = doc.getElementsByTagName("symbol");
		System.out.println("----------------------------");
		for (int temp = 0; temp < 4; temp++) {  //Iterate throuh all nodes
			Node nNode = nList.item(temp);
			//System.out.println("\nCurrent Element :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				//System.out.println("clouds : " + eElement.getAttribute("symbol")); //This is the name in the nodes...
				System.out.println("Temperature : " + eElement.getAttribute("value"));
				//System.out.println("Weather : " + eElement.getAttribute("name"));
//				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//				System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
			}
		}
		
		for (int temp = 0; temp < 4; temp++) {  //Iterate throuh all nodes
			Node nNode1 = nList1.item(temp);
			//System.out.println("\nCurrent Element :" + nNode.getNodeName());
			if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode1;
				//System.out.println("clouds : " + eElement.getAttribute("symbol")); //This is the name in the nodes...
				//System.out.println("Temperature : " + eElement.getAttribute("value"));
				System.out.println("Weather : " + eElement.getAttribute("name"));
//				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//				System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
			}
		}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	  }
	 
}
