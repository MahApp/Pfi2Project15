package se.mah.k3.pfi2.project.kronox;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {
	private String startTid,slutTid;
	public static Posts storedPosts;
	public static void main(String[] args) {
		System.out.println("start program");
		storedPosts= Parser.getPostsfrom("http://schema.mah.se/setup/jsp/SchemaXML.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=false&sprak=SV&resurser=p.TGIND14h%2C");

	}
	
	public static Posts getPostsfrom(String searchURL){
		System.out.println("startpostparse");
		XmlDomParser parser = new XmlDomParser();
		String xml = XmlDomParser.getXmlFromUrl(searchURL); // getting XML
		ArrayList<Post> tempPost=new ArrayList<Post>();
		System.out.println("xml fixing");
		if (xml != null) {
			Document doc = XmlDomParser.getDomElement(xml); // getting DOM elementschemaPost

			NodeList schemaPost = doc.getElementsByTagName("schemaPost");// looping through all item nodes <item>
			for (int i = 0; i < schemaPost.getLength(); i++) { // loop av fšrsta gen "schemaPost"
				System.out.println("___[Index number "+i+ "  ] ______________________________________________");
				Node schemaPostN = schemaPost.item(i);
				if (schemaPostN.getNodeType() == Node.ELEMENT_NODE) {
					Element schemaPostE = (Element) schemaPost.item(i);
					System.out.println(schemaPostN.getNodeName()+"...#"+i+": ");
					System.out.println(parser.getValue(schemaPostE, "bokningsId")); // fšrsta
					NodeList bokadeDatum  = schemaPostE.getElementsByTagName("bokadeDatum");
					for (int j = 0; j < bokadeDatum.getLength(); j++) {  // loop av andra gen "-bokadeDatum"
						Node bokadeDatumN = bokadeDatum.item(j);
						System.out.print("-" + bokadeDatumN.getNodeName()+ "...#" + j+": ");
						if (bokadeDatumN.getNodeType() == Node.ELEMENT_NODE) {
							Element bokadeDatumE = (Element) bokadeDatum.item(j);
							System.out.print(" class start: "+bokadeDatumE.getAttribute("startDatumTid")); // get attribut'
							System.out.println(" class end: "+bokadeDatumE.getAttribute("slutDatumTid")); // get attribut'
						}
					}
					System.out.println("Updated: "+parser.getValue(schemaPostE, "senastAndradDatum")); // fšrsta
					System.out.println("Edited by: "+parser.getValue(schemaPostE, "senastAndradAv"));// fšrsta
					NodeList resursTrad = schemaPostE.getElementsByTagName("resursTrad");
					for (int j = 0; j < resursTrad.getLength(); j++) {  // loop av andra gen "-resursTrad"
						Node resursTradN = resursTrad.item(j);
						System.out.println("-" + resursTradN.getNodeName()+ "...#" + j+": ");
						if (resursTradN.getNodeType() == Node.ELEMENT_NODE) {
							Element resursTradE = (Element) resursTrad.item(j);
							try{
							NodeList resursNod = resursTradE.getElementsByTagName("resursNod");//NodeList resursNod = resursTradE.getChildNodes();
								for (int k = 0; k < resursNod.getLength(); k++) { // loop av tredje gen "--resursNod"
									Node resursNodN = resursNod.item(k);
									Element resursNodE = (Element) resursNod.item(k);
									System.out.print("--"+ resursNodE.getTagName() + "...#" + k+": ");
									System.out.println(resursNodE.getAttribute("resursTypId")); // get attribut'
									if (resursNodE.getNodeType() == Node.ELEMENT_NODE) {
										NodeList resursId = resursNodE.getElementsByTagName("resursId");
								
										for (int l = 0; l < resursId.getLength(); l++) { // loop av fjärde gen "---resursId"
											Node resursIdN = resursId.item(l);
												if (resursIdN.getNodeType() == Node.ELEMENT_NODE) {
												Element resursIdE = (Element) resursId.item(l);
												System.out.print("---"+ resursIdE.getTagName() + "...#" + l+": ");
												System.out.println(resursIdE.getTextContent()); // fšrsta
												//System.out.println(parser.getValue(resursIdE, "resursId"));// fšrsta
												}
										}
									}
								}
								}catch(Exception E){
								System.err.println("nope");
							}
						}
					}
					//System.out.println(schemaPostE.getElementsByTagName("moment")); // fšrsta
					NodeList moment = schemaPostE.getElementsByTagName("moment");
					for (int j = 0; j < moment.getLength(); j++) { // loop av fjärde gen "---resursId"
						Node momentN = moment.item(j);
							if (momentN.getNodeType() == Node.ELEMENT_NODE) {
							Element momentE = (Element) moment.item(j);
							System.out.print("-"+ momentE.getTagName() + "...#" + j+": ");
							System.out.println(momentE.getTextContent()); // fšrsta
							//System.out.println(parser.getValue(resursIdE, "resursId"));// fšrsta
							}
					}
					NodeList status = schemaPostE.getElementsByTagName("status");
					for (int j = 0; j < status.getLength(); j++) { // loop av fjärde gen "---resursId"
						Node statusN = status.item(j);
							if (statusN.getNodeType() == Node.ELEMENT_NODE) {
							Element statusE = (Element) status.item(j);
							System.out.println("-"+ statusE.getTagName() + "...#" + j+": ");
							NodeList statusC = statusE.getChildNodes();//NodeList resursNod = resursTradE.getChildNodes();
								for(int k = 0; k < statusC.getLength(); k++){
									Node arRaderad=statusC.item(k);
									Element arRaderadE=(Element) arRaderad;
								  NamedNodeMap attributes = arRaderad.getAttributes();
								  Node theAttribute = attributes.item(0);
								  System.out.print("--"+arRaderad.getNodeName()+":");
								  System.out.println(theAttribute.getNodeValue());
								}
							}
					}
		
				}
	
				System.out.println();
			}
		}
	
		return new Posts(tempPost);
		
		
	}
	
	
	
	
}
