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
	public static boolean debug=true;
	public static ArrayList <Posts> storedPosts= new ArrayList <Posts>(); // unsorted raw array of Post 
	public static ArrayList <Post> storedPost= new ArrayList <Post>(); // sorted raw Post
	public static String biulding="ubåtshallen"; // change this to search for other bulding
	public static void main(String[] args) {
		
		
		ParserUpdateThread pt= new ParserUpdateThread();
		pt.start();
		
		System.out.println("start program");
		CanvasInJframe frame = new CanvasInJframe();
		CanvasInJframe awtControlDemo = new CanvasInJframe();
		try{
			frame.setVisible(false);
			awtControlDemo.showCanvasDemo();
			awtControlDemo.setVisible(true);
			awtControlDemo.setTitle("loading..."); //window
		} catch (Exception e) {
			e.printStackTrace();
		}
		awtControlDemo.loadData(getPost());
		awtControlDemo.repaint();

	}
	
	public static Posts getPostsfrom(String searchURL){
		
		if(debug)System.out.println("startpostparse");
		XmlDomParser parser = new XmlDomParser();
		String xml = XmlDomParser.getXmlFromUrl(searchURL); // getting XML
		ArrayList<Post> tempPost=new ArrayList<Post>();
		System.out.println("xml fixing");
		if(debug)System.out.println("convert the xml:"+ xml);
		if (xml != null) {
			if(debug)System.out.println("-found Xml");
			Document doc = XmlDomParser.getDomElement(xml); // getting DOM elementschemaPost

			NodeList schemaPost = doc.getElementsByTagName("schemaPost");// looping through all item nodes <item>
			for (int i = 0; i < schemaPost.getLength(); i++) { // loop av fšrsta gen "schemaPost"
				Post tempSchemaPost=new Post(); // TEMPPOST FOR STORING IN POSTS
				System.out.println("___[Index number "+i+ "  ] ______________________________________________");
				Node schemaPostN = schemaPost.item(i);
				if (schemaPostN.getNodeType() == Node.ELEMENT_NODE) {
					Element schemaPostE = (Element) schemaPost.item(i);
					if(debug)System.out.println(schemaPostN.getNodeName()+"...#"+i+": ");
					if(debug)System.out.println(parser.getValue(schemaPostE, "bokningsId")); // fšrsta
					NodeList bokadeDatum  = schemaPostE.getElementsByTagName("bokadeDatum");
					for (int j = 0; j < bokadeDatum.getLength(); j++) {  // loop av andra gen "-bokadeDatum"
						Node bokadeDatumN = bokadeDatum.item(j);
						if(debug)System.out.print("-" + bokadeDatumN.getNodeName()+ "...#" + j+": ");
						if (bokadeDatumN.getNodeType() == Node.ELEMENT_NODE) {
							Element bokadeDatumE = (Element) bokadeDatum.item(j);
							if(debug)System.out.print(" class start: "+bokadeDatumE.getAttribute("startDatumTid")); // get attribut'
							tempSchemaPost.setStartTid(bokadeDatumE.getAttribute("startDatumTid"));
							if(debug)System.out.println(" class end: "+bokadeDatumE.getAttribute("slutDatumTid")); // get attribut'
							tempSchemaPost.setSlutTid(bokadeDatumE.getAttribute("slutDatumTid"));
							
						}
					}
					if(debug)System.out.println("Updated: "+parser.getValue(schemaPostE, "senastAndradDatum")); // fšrsta
					tempSchemaPost.setEditedSince(parser.getValue(schemaPostE, "senastAndradDatum"));
					if(debug)System.out.println("Edited by: "+parser.getValue(schemaPostE, "senastAndradAv"));// fšrsta
					tempSchemaPost.setEditedBy(parser.getValue(schemaPostE, "senastAndradAv"));
					NodeList resursTrad = schemaPostE.getElementsByTagName("resursTrad");
					for (int j = 0; j < resursTrad.getLength(); j++) {  // loop av andra gen "-resursTrad"
						Node resursTradN = resursTrad.item(j);
						if(debug)System.out.println("-" + resursTradN.getNodeName()+ "...#" + j+": ");
						if (resursTradN.getNodeType() == Node.ELEMENT_NODE) {
							Element resursTradE = (Element) resursTrad.item(j);
							try{
							NodeList resursNod = resursTradE.getElementsByTagName("resursNod");//NodeList resursNod = resursTradE.getChildNodes();
								for (int k = 0; k < resursNod.getLength(); k++) { // loop av tredje gen "--resursNod"
									Node resursNodN = resursNod.item(k);
									Element resursNodE = (Element) resursNod.item(k);
									if(debug)System.out.print("--"+ resursNodE.getTagName() + "...#" + k+": ");
									if(debug)System.out.println(resursNodE.getAttribute("resursTypId")); // get attribut'
									
									if (resursNodE.getNodeType() == Node.ELEMENT_NODE) {
										NodeList resursId = resursNodE.getElementsByTagName("resursId");
								
										for (int l = 0; l < resursId.getLength(); l++) { // loop av fjärde gen "---resursId"
											Node resursIdN = resursId.item(l);
												if (resursIdN.getNodeType() == Node.ELEMENT_NODE) {
												Element resursIdE = (Element) resursId.item(l);
												if(debug)System.out.print("---"+ resursIdE.getTagName() + "...#" + l+": ");
												if(debug)System.out.println(resursIdE.getTextContent()); // fšrsta
													if(resursNodE.getAttribute("resursTypId").equals("UTB_KURSINSTANS_GRUPPER")){
														tempSchemaPost.setKursId(resursIdE.getTextContent());
													}
													if(resursNodE.getAttribute("resursTypId").equals("UTB_PROGRAMINSTANS_KLASSER")){
														tempSchemaPost.setProgramId(resursIdE.getTextContent());
													}
													if(resursNodE.getAttribute("resursTypId").equals("RESURSER_LOKALER")){
														tempSchemaPost.setSalID(resursIdE.getTextContent());
													}
													if(resursNodE.getAttribute("resursTypId").equals("RESURSER_SIGNATURER")){
														tempSchemaPost.setResursSignatur(resursIdE.getTextContent());
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
							if(debug)System.out.print("-"+ momentE.getTagName() + "...#" + j+": ");
							if(debug)System.out.println(momentE.getTextContent()); // fšrsta
							tempSchemaPost.setMoment(momentE.getTextContent());
							
							//System.out.println(parser.getValue(resursIdE, "resursId"));// fšrsta
							}
					}
					NodeList status = schemaPostE.getElementsByTagName("status");
					for (int j = 0; j < status.getLength(); j++) { // loop av fjärde gen "---resursId"
						Node statusN = status.item(j);
							if (statusN.getNodeType() == Node.ELEMENT_NODE) {
							Element statusE = (Element) status.item(j);
							if(debug)System.out.println("-"+ statusE.getTagName() + "...#" + j+": ");
							NodeList statusC = statusE.getChildNodes();//NodeList resursNod = resursTradE.getChildNodes();
								for(int k = 0; k < statusC.getLength(); k++){
									Node statusCN=statusC.item(k);
									Element arRaderadE=(Element) statusCN;
								  NamedNodeMap attributes = statusCN.getAttributes();
								  Node theAttribute = attributes.item(0);
								  if(debug)  System.out.print("--"+statusCN.getNodeName()+":");
								  if(debug)	  System.out.println(theAttribute.getNodeValue());	
								  if(statusCN.getNodeName().equals("arRaderad")){
									  tempSchemaPost.setRaderad(Boolean.parseBoolean(theAttribute.getNodeValue()));
								  }
								if(statusCN.getNodeName().equals("arPreliminar")){	
									  tempSchemaPost.setTemp(Boolean.parseBoolean(theAttribute.getNodeValue()));
								}
								if(statusCN.getNodeName().equals("arDubbelbokad"))	{
									  tempSchemaPost.setDubbelBokad(Boolean.parseBoolean(theAttribute.getNodeValue()));
								}
								 if(statusCN.getNodeName().equals("arExtern")){
									  tempSchemaPost.setExtern(Boolean.parseBoolean(theAttribute.getNodeValue()));
								 }
								if(statusCN.getNodeName().equals("arOnskemal")){
									  tempSchemaPost.setOnskad(Boolean.parseBoolean(theAttribute.getNodeValue()));
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
	storedPost.clear();
	storedPosts.clear();
	ArrayList<String> Urls = Constants.getURL(biulding, null); // can get multiple URLs
	System.out.println(Urls.size()+" amout of XML URL");
	try{
		for(int i=0; i< Urls.size();i++){
			String schema=Urls.get(i);
			storedPost.addAll(Parser.getPostsfrom(schema).getPostArray());
		}
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println(Urls.size()+" Error XML URLs out of bound");

	}
if(debug)	System.out.println("-----------------------------------------");
	for(int i=0; i<storedPosts.size();i++){
		System.out.println("XML index: "+i +" have : "+storedPosts.get(i).getPostArray().size()+" posts");
	}
	//System.out.println("total post in all parsed XML: "+storedPost.size()+" stored in ArrayList:\"storedPost\"");
	
	for(int i=0; i<storedPost.size();i++){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // paring format
			try {
		if(debug)System.out.println(storedPost.get(i).getStartTid());

				storedPost.get(i).setStartTidCal(sdf.parse(storedPost.get(i).getStartTid()));
			

				System.out.println(storedPost.get(i).getStartTidCal());
			} catch (ParseException e) {
		} 
		storedPost.get(i).setStartTid(Constants.formatTime(storedPost.get(i).getStartTid()));  // set start time in HH:mm format
		storedPost.get(i).setSlutTid(Constants.formatTime(storedPost.get(i).getSlutTid())); // set end time in HH:mm format

		if(storedPost.get(i).getSalID()!=null) { // format biulding
			if(storedPost.get(i).getSalID().equals("null")||storedPost.get(i).getSalID().equals("")) {
				System.out.println("post: "+i+ " is empty");
			}else{
				storedPost.get(i).setBiuldingId(storedPost.get(i).getSalID().substring(0, 2));
				storedPost.get(i).setBiulding(Constants.parseBiuldingIdToBiulding(storedPost.get(i).getBiuldingId()));
				System.out.println(storedPost.get(i).getBiuldingId());
			}
		}else{
			System.out.println("post: "+i+ " is null");
		}
		storedPost.get(i).setKursId(Constants.formatKurs(storedPost.get(i).getKursId()));
	}

	Collections.sort(storedPost); // sort by startTime
	if(debug){
		for (Post schema : storedPost) {
			System.out.println(schema.getStartTid());
		}
	}

	storedPost=FilterOutBiulding.filter(storedPost); // filter the building
	storedPost=FilterOutRooms.filter(storedPost); // filter the rooms
	//storedPost=FilterOutTime.filter(storedPost); // filter Time

	return storedPost;
	}
	
	public void setbuilding(String thisBuilding){
		this.biulding = thisBuilding;	
	}
	public String getbuilding(){
		return this.biulding;	
	}

//	
//	public static ArrayList<Post> addDummyPosts (ArrayList<Post> _post){
//		
//		ArrayList<Post> dummyfied = new ArrayList<Post>();
//		dummyfied.add(new Post()); // canceled
//		dummyfied.add(new Post()); // modified
//		dummyfied.addAll(_post);
//	}
//	
}
