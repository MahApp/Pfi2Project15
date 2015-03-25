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

	public JTextArea Meny = new JTextArea();
	
	/**
	 * Create the panel.
	 */
	

	public NewsPanel() {
		setPreferredSize(new Dimension(1080,240));
		setMinimumSize(new Dimension(1080,240));
		setForeground(UIManager.getColor("scrollbar"));
		setBorder(null);
		setBackground(new Color(240, 241, 241));
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(823, 19, 202, 196);
		add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(NewsPanel.class.getResource("/Images/salad.jpg")));
		
		JPanel RAM = new JPanel();
		RAM.setBounds(816, 15, 217, 205);
		add(RAM);
		RAM.setBackground(new Color(134,188,37));
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(17, 11, 1047, 218);
		panel2.setBackground(new Color(227, 230, 229));
		add(panel2);
		panel2.setLayout(null);
		
		JPanel Rubrik = new JPanel();
		Rubrik.setBounds(116, 11, 218, 50);
		Rubrik.setBackground(new Color(134,188,37));
		panel2.add(Rubrik);
		
				
				JLabel lblNews = new JLabel("Lunch 69:-");
				lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
				lblNews.setForeground(Color.WHITE);
				Rubrik.add(lblNews);
				
				
				Meny.setFont(new Font("Futura", Font.PLAIN, 20));
				Meny.setText("Här kommer menyn stå!");
				Meny.setBounds(98, 70, 381, 163);
				Meny.setBackground(new Color(227, 230, 229));
				Meny.setForeground(new Color(97, 101, 109));
				panel2.add(Meny);
		//panel.setBackground(new Color(134, 188, 37));
				
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
					Meny.append("\n" + cleanResultat + "\n" );
					
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
					Meny.append("Ha" + cleanResultat + "\n" );
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
					Meny.append(cleanResultat);
				}
				
			}
			sc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
