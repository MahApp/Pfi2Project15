package se.mah.k3.pfi2.project.news;

import javax.swing.JComponent;
import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

import java.awt.Font;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class NewsPanel extends JPanel implements ModuleInterface{

	/**
	 * Create the panel.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsPanel frame = new NewsPanel();
					frame.setVisible(true);
				//Thread T = new ThreadLine (p);
					//T.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public NewsPanel() {
		setPreferredSize(new Dimension(1080,240));
		setMinimumSize(new Dimension(1080,240));
		setForeground(UIManager.getColor("scrollbar"));
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder (new Color(0,158,212), 3, true));
		panel2.setBounds(10, 11, 1060, 218);
		panel2.setBackground(Color.WHITE);
		add(panel2);
		panel2.setLayout(null);
		
		JPanel Rubrik = new JPanel();
		Rubrik.setBorder(new LineBorder(new Color(0, 158, 212), 4, true));
		Rubrik.setBounds(353, 0, 371, 50);
		Rubrik.setBackground(new Color(0,158,212));
		panel2.add(Rubrik);
		
				
				JLabel lblNews = new JLabel("Events & H\u00E4ndelser idag");
				lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
				lblNews.setForeground(Color.WHITE);
				Rubrik.add(lblNews);
				
				JLabel Event1 = new JLabel("Event 1");
				Event1.setFont(new Font("Tahoma", Font.PLAIN, 19));
				Event1.setBounds(50, 74, 956, 37);
				panel2.add(Event1);
				
				JLabel Event2 = new JLabel("Event 2");
				Event2.setFont(new Font("Tahoma", Font.PLAIN, 19));
				Event2.setBounds(50, 122, 956, 37);
				panel2.add(Event2);
				
				JLabel Event3 = new JLabel("Event 3");
				Event3.setFont(new Font("Tahoma", Font.PLAIN, 19));
				Event3.setBounds(50, 170, 956, 37);
				panel2.add(Event3);
				
				
				
				readAndWriteMonday();

	}


	
	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean showNumberOfRows(int start, int end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void repaintPanel() {
		// TODO Auto-generated method stub
		
	}
	public void readAndWriteMonday(){
		try {
			URL freda49 = new URL("http://www.freda49.se/lunch-malmo.html");
			Scanner sc = new Scanner(freda49.openStream());
			while (sc.hasNext()) {
				String fullText = sc.nextLine();
				
//				int menuStart = fullText.indexOf("LUNCHMENY");   //fr�n "lunchmeny"
//				int menuEnd = fullText.indexOf("L=inneh");       //till "L=inneh�ller laktos"
//				String fullMenu = fullText.substring(menuStart, menuEnd);
//				
//				int mondayStart = fullMenu.indexOf("ndag:");
//				int mondayEnd = fullMenu.indexOf("TISDAG");
//				String monday = fullMenu.substring(mondayStart, mondayEnd);
				
				String dagens = fullText;
				if (dagens.contains("Husman")){	
					int dagensStartRead = dagens.indexOf("Husman");
					int dagensEndRead = dagens.indexOf("lsa:");
					String dagensResultat = dagens.substring(dagensStartRead, dagensEndRead);
					
					int cleanStart = dagensResultat.indexOf("Husman:");
					int cleanEnd = dagensResultat.indexOf("</span>");
					String cleanResultat = dagensResultat.substring(cleanStart, cleanEnd);
					
					
					System.out.println(cleanResultat);
					Events.append("\n" + cleanResultat + "\n" );
					
				}
				
				String halsa = fullText;
				if (halsa.contains("lsa:")){
					int halsaStartRead = halsa.indexOf("lsa:");
					int halsaEndRead = halsa.indexOf("Vegetarisk");
					String halsaResultat = halsa.substring(halsaStartRead,  halsaEndRead);
					
					int cleanStart = halsaResultat.indexOf("lsa:");
					int cleanEnd = halsaResultat.indexOf("</span>");
					String cleanResultat = halsaResultat.substring(cleanStart, cleanEnd);
							
							
					System.out.println("Ha" + cleanResultat);
					Events.append("Ha" + cleanResultat + "\n" );
				}
				
				String veg = fullText;
				if (veg.contains("Vegetarisk:")){ 
					int vegStartRead = veg.indexOf("Vegetarisk");    
					int vegEndRead = veg.indexOf(">TISDAG<");
					String vegResultat = veg.substring(vegStartRead,  vegEndRead); //tar in all text inom taggarna "Vegetarisk" och 
																				   //">TISDAG<"
					
					int cleanStart = vegResultat.indexOf("Vegetarisk");
					int cleanEnd = vegResultat.indexOf("</span>");
					String cleanResultat = vegResultat.substring(cleanStart, cleanEnd); //tar in all text fr�n b�rjan av vegResultat och 
																					    // </span> inom vegresultat
					
					System.out.println(cleanResultat);   //skriver ut vegResultat utan HTML-taggar
					Events.append(cleanResultat);
				}
				
			}
			sc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
