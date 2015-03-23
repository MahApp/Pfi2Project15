package se.mah.k3.pfi2.project.kronox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Parser {
	public static boolean debug;
	private String startTid,slutTid;
	public static ArrayList <Posts> storedPosts= new ArrayList <Posts>(); // unsorted raw array of Post 
	public static ArrayList <Post> storedPost= new ArrayList <Post>(); // sorted raw Post
	public static ArrayList <Post> sortedPost= new ArrayList <Post>(); // sorted raw Post
	
	static CanvasInJframe frame;
	static CanvasInJframe awtControlDemo ;
	static Calendar cal;
	public static String biulding="orkanen"; // change this to search for other bulding
	public static void main(String[] args) {
		try{
			frame = new CanvasInJframe();
			frame.setVisible(false);
			awtControlDemo = new CanvasInJframe();
			awtControlDemo.showCanvasDemo();
			awtControlDemo.setVisible(true);
			awtControlDemo.setTitle("loading...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("start program");
		//storedPosts= Parser.getPostsfrom("http://schema.mah.se/setup/jsp/SchemaXML.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=false&sprak=SV&resurser=p.TGIND14h%2C");
		
		ArrayList<String> Urls = Constants.getURL(biulding, null); // can get multiple URLs
		for(int i=0; i< Urls.size();i++){
			String schema=Urls.get(i);
			System.out.println("got xml url from: "+schema);
			storedPost.addAll(Parser.getPostsfrom(schema).getPostArray());
		}
		System.out.println(storedPost.size());
		System.out.println("-----------------------------------------");
		for(int i=0; i<storedPosts.size();i++){
			System.out.println("XML index: "+i +" have : "+storedPosts.get(i).getPostArray().size()+" posts");
		}
		System.out.println("total post in all parsed XML: "+storedPost.size()+" stored in ArrayList:\"storedPost\"");
		
		// format startTid & slutTid
		for(int i=0; i<storedPost.size();i++){
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // paring format
				try {
					storedPost.get(i).setStartTidCal(sdf.parse(storedPost.get(i).getStartTid()));
				} catch (ParseException e) {
			} // Date
			
			storedPost.get(i).setStartTid(storedPost.get(i).getStartTid().substring(11, 16));  // set start time in HH:mm format
			storedPost.get(i).setSlutTid(storedPost.get(i).getSlutTid().substring(11, 16)); // set end time in HH:mm format
			// format minute and hours
			String digits[] =storedPost.get(i).getStartTid().split(":");
			int hour =Integer.parseInt(digits[0]);
			int minute= Integer.parseInt(digits[1]);
			//System.out.println(hour+" "+minute);
		}

		// sorting arraylist by startTid
		Collections.sort(storedPost);
		if(debug){
			for (Post schema : storedPost) {
				System.out.println(schema.getStartTid());
			}
		}
		cal=Calendar.getInstance(); // get the current time
		
	/*SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm"); // Date for testing
		Date d = null;
		try {
			 d = sdf.parse("2015-03-23 10:30");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.set(2013, 03, 23, 10, 30);
		for(int i=0; i<storedPost.size();i++){          // remove post that is old
			//if(storedPost.get(i).startTidCal.before(cal.getTime())){ //currentTime
			if(storedPost.get(i).startTidCal.before(d)){ //currentTime

			storedPost.remove(i);
			}
		}*/
		
		awtControlDemo.loadData(storedPost);
		awtControlDemo.repaint();
		System.out.println(Urls);
	}
	
	public static Posts getPostsfrom(String searchURL){
		
		System.out.println("startpostparse");
		XmlDomParser parser = new XmlDomParser();
		String xml = XmlDomParser.getXmlFromUrl(searchURL); // getting XML
		ArrayList<Post> tempPost=new ArrayList<Post>();
		System.out.println("xml fixing");
		System.out.println("convert the xml:"+ xml);
		if (xml != null) {
			System.out.println("-found Xml");
			Document doc = XmlDomParser.getDomElement(xml); // getting DOM elementschemaPost

			NodeList schemaPost = doc.getElementsByTagName("schemaPost");// looping through all item nodes <item>
			for (int i = 0; i < schemaPost.getLength(); i++) { // loop av fšrsta gen "schemaPost"
				Post tempSchemaPost=new Post(); // TEMPPOST FOR STORING IN POSTS
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
							tempSchemaPost.setStartTid(bokadeDatumE.getAttribute("startDatumTid"));
							if(debug)System.out.println("			startDatumTid sparad");
							System.out.println(" class end: "+bokadeDatumE.getAttribute("slutDatumTid")); // get attribut'
							tempSchemaPost.setSlutTid(bokadeDatumE.getAttribute("slutDatumTid"));
							if(debug)System.out.println("			slutDatumTid sparad");
						}
					}
					System.out.println("Updated: "+parser.getValue(schemaPostE, "senastAndradDatum")); // fšrsta
					tempSchemaPost.setEditedSince(parser.getValue(schemaPostE, "senastAndradDatum"));
					if(debug)System.out.println("			senastAndradDatum sparad");
					System.out.println("Edited by: "+parser.getValue(schemaPostE, "senastAndradAv"));// fšrsta
					tempSchemaPost.setEditedBy(parser.getValue(schemaPostE, "senastAndradAv"));
					if(debug)System.out.println("			senastAndradAv sparad");
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
													if(resursNodE.getAttribute("resursTypId").equals("UTB_KURSINSTANS_GRUPPER")){
														tempSchemaPost.setKursId(resursIdE.getTextContent());
														if(debug)System.out.println("			UTB_KURSINSTANS_GRUPPER sparad");
													}
													if(resursNodE.getAttribute("resursTypId").equals("UTB_PROGRAMINSTANS_KLASSER")){
														tempSchemaPost.setProgramId(resursIdE.getTextContent());
														if(debug)System.out.println("			UTB_PROGRAMINSTANS_KLASSER sparad");
													}
													if(resursNodE.getAttribute("resursTypId").equals("RESURSER_LOKALER")){
														tempSchemaPost.setSalID(resursIdE.getTextContent());
														if(debug)System.out.println("			RESURSER_LOKALER sparad");
													}
													if(resursNodE.getAttribute("resursTypId").equals("RESURSER_SIGNATURER")){
														tempSchemaPost.setResursSignatur(resursIdE.getTextContent());
														if(debug)System.out.println("			UTB_KURSINSTANS_GRUPPE sparad");
													}
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
							tempSchemaPost.setMoment(momentE.getTextContent());
							if(debug)System.out.println("			moment sparad");
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
								  if(arRaderad.getNodeName().equals("arRaderad")){
									  tempSchemaPost.setRaderad(Boolean.parseBoolean(theAttribute.getNodeValue()));
									  if(debug)System.out.println("			arRaderad sparad");
								  }
								if(arRaderad.getNodeName().equals("arPreliminar")){	
									  tempSchemaPost.setTemp(Boolean.parseBoolean(theAttribute.getNodeValue()));
									  if(debug)System.out.println("			arPreliminar sparad");
								}
								if(arRaderad.getNodeName().equals("arDubbelbokad"))	{
									  tempSchemaPost.setDubbelBokad(Boolean.parseBoolean(theAttribute.getNodeValue()));
									  if(debug)System.out.println("			arDubbelbokad sparad");
								}
								 if(arRaderad.getNodeName().equals("arExtern")){
									  tempSchemaPost.setExtern(Boolean.parseBoolean(theAttribute.getNodeValue()));
									  if(debug)System.out.println("			arExtern sparad");
								 }
								if(arRaderad.getNodeName().equals("arOnskemal")){
									  tempSchemaPost.setOnskad(Boolean.parseBoolean(theAttribute.getNodeValue()));
									  if(debug)System.out.println("			arOnskemal sparad");
								}
								 
								}
							}
					}
		
				}
	
				if(debug)System.out.println("savingPost "+tempPost.size()+" from XML to Posts");
				tempPost.add(tempSchemaPost);
			}
		}
		if(debug){
		for (int i = 0; i < tempPost.size(); i++) {
		     System.out.println(tempPost.get(i).getMoment());
		}}
		if(debug)System.out.println("total of: "+tempPost.size() +" Post in this Posts");
		return new Posts(tempPost);
		
		
	}
	
	public static ArrayList<Post> getPost(){
	

	ArrayList<String> Urls = Constants.getURL(biulding, null); // can get multiple URLs
	for(int i=0; i< Urls.size();i++){
		String schema=Urls.get(i);
	//	System.out.println("got xml url from: "+schema);
		storedPost.addAll(Parser.getPostsfrom(schema).getPostArray());
	}
//	System.out.println(storedPost.size());
//	System.out.println("-----------------------------------------");
	for(int i=0; i<storedPosts.size();i++){
		System.out.println("XML index: "+i +" have : "+storedPosts.get(i).getPostArray().size()+" posts");
	}
	//System.out.println("total post in all parsed XML: "+storedPost.size()+" stored in ArrayList:\"storedPost\"");
	

	for(int i=0; i<storedPost.size();i++){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // paring format
			try {
				storedPost.get(i).setStartTidCal(sdf.parse(storedPost.get(i).getStartTid()));
			} catch (ParseException e) {
		} 
		
		storedPost.get(i).setStartTid(storedPost.get(i).getStartTid().substring(11, 16));  // set start time in HH:mm format
		storedPost.get(i).setSlutTid(storedPost.get(i).getSlutTid().substring(11, 16)); // set end time in HH:mm format

		String digits[] =storedPost.get(i).getStartTid().split(":");
		int hour =Integer.parseInt(digits[0]);
		int minute= Integer.parseInt(digits[1]);
		
	}

	Collections.sort(storedPost);
	if(debug){
		for (Post schema : storedPost) {
			System.out.println(schema.getStartTid());
		}
	}
	cal=Calendar.getInstance(); // get the current time
	
	return storedPost;
	}

}
