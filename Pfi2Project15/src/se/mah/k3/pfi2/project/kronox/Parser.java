package se.mah.k3.pfi2.project.kronox;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		XmlDomParser parser = new XmlDomParser();
		String xml = parser.getXmlFromUrl("notImplement"); // getting XML
		
		if (xml!=null){
			Document doc = parser.getDomElement(xml); // getting DOM element
			//schemaPost
			NodeList nl = doc.getElementsByTagName("schemaPost");
			// looping through all item nodes <item>
			for (int i = 0; i < nl.getLength(); i++) { //loop av fšrsta generation
				System.out.println("---ny post---");
				Node data =nl.item(i);
				if(data.getNodeType()==Node.ELEMENT_NODE){
				Element e = (Element) nl.item(i);
				System.out.println(parser.getValue(e, "bokningsId")); // fšrsta generation
				System.out.println(parser.getValue(e, "senastAndradDatum")); // fšrsta generation
				System.out.println(parser.getValue(e, "senastAndradAv"));// fšrsta generation
		
				}else{
			
					}
				// System.out.println(parser.getValue(e, "bokadeDatum")); // andra generation
			//	<bokningsId>BokningsId_20150304_000000205</bokningsId>
				
			}
		}
	}

}
