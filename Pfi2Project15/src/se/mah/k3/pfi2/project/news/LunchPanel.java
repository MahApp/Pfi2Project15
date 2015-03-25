package se.mah.k3.pfi2.project.news;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import javax.swing.border.LineBorder;

import org.apache.commons.lang3.StringEscapeUtils;

public class LunchPanel extends JPanel implements ModuleInterface{
	
	public JLabel dagensLabel;
	public JLabel kapet;
	public JLabel veg;
	
	/**
	 * Create the panel.
	 */
	public LunchPanel() {

		
			setPreferredSize(new Dimension(1080,240));
			setMinimumSize(new Dimension(1080,240));
			setForeground(UIManager.getColor("scrollbar"));
			setBorder(null);
			setBackground(Color.WHITE);
			setLayout(null);
			
			JPanel panel2 = new JPanel();
			panel2.setBorder(new LineBorder(new Color(134, 188, 37), 3, true));
			panel2.setBounds(10, 11, 1060, 218);
			panel2.setBackground(Color.WHITE);
			add(panel2);
			panel2.setLayout(null);
			
			JPanel Rubrik = new JPanel();
			Rubrik.setBorder(new LineBorder(new Color(134, 188, 37), 1, true));
			Rubrik.setBounds(353, 0, 371, 50);
			Rubrik.setBackground(new Color(134,188,37));
			panel2.add(Rubrik);
					Rubrik.setLayout(null);
			
					
					JLabel lblNews = new JLabel("Dagens lunch");
					lblNews.setBounds(100, 9, 295, 39);
					lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
					lblNews.setForeground(Color.WHITE);
					Rubrik.add(lblNews);
					
					dagensLabel = new JLabel("");
					dagensLabel.setFont(new Font("Futura", Font.PLAIN, 20));
					dagensLabel.setBounds(65, 75, 536, 29);
					panel2.add(dagensLabel);
					
					kapet = new JLabel("");
					kapet.setFont(new Font("Futura", Font.PLAIN, 20));
					kapet.setBounds(65, 116, 535, 33);
					panel2.add(kapet);
					
					veg = new JLabel("");
					veg.setFont(new Font("Futura", Font.PLAIN, 20));
					veg.setBounds(65, 157, 529, 38);
					panel2.add(veg);
					
					JLabel lblNewLabel = new JLabel("New label");
					lblNewLabel.setIcon(new ImageIcon(LunchPanel.class.getResource("/Images/salad.jpg")));
					lblNewLabel.setBounds(814, 20, 183, 175);
					panel2.add(lblNewLabel);
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
					
//					int menuStart = fullText.indexOf("LUNCHMENY");   //fr�n "lunchmeny"
//					int menuEnd = fullText.indexOf("L=inneh");       //till "L=inneh�ller laktos"
//					String fullMenu = fullText.substring(menuStart, menuEnd);
//					
//					int mondayStart = fullMenu.indexOf("ndag:");
//					int mondayEnd = fullMenu.indexOf("TISDAG");
//					String monday = fullMenu.substring(mondayStart, mondayEnd);
					
					String dagens = fullText;
					if (dagens.contains("Husman")){	
						int dagensStartRead = dagens.indexOf("Husman");
						int dagensEndRead = dagens.indexOf("lsa:");
						String dagensResultat = dagens.substring(dagensStartRead, dagensEndRead);
						
						int cleanStart = dagensResultat.indexOf("Husman:");
						int cleanEnd = dagensResultat.indexOf("</span>");
						String cleanResultat = dagensResultat.substring(cleanStart, cleanEnd);
						
						String removeHtml = StringEscapeUtils.unescapeHtml4(cleanResultat);
						System.out.println(removeHtml);
						
						System.out.println(cleanResultat);
						
						dagensLabel.setText(removeHtml);
					}
					
					String halsa = fullText;
					if (halsa.contains("lsa:")){
						int halsaStartRead = halsa.indexOf("lsa:");
						int halsaEndRead = halsa.indexOf("Vegetarisk");
						String halsaResultat = halsa.substring(halsaStartRead,  halsaEndRead);
						
						int cleanStart = halsaResultat.indexOf("lsa:");
						int cleanEnd = halsaResultat.indexOf("</span>");
						String cleanResultat = halsaResultat.substring(cleanStart, cleanEnd);
								
								
						String removeHtml = StringEscapeUtils.unescapeHtml4(cleanResultat);
						System.out.println("Hä" + removeHtml);
						System.out.println("Hä" + cleanResultat);
						
						veg.setText("Hä" + removeHtml);
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
						String removeHtml = StringEscapeUtils.unescapeHtml4(cleanResultat);
						System.out.println(removeHtml);
						
						System.out.println(cleanResultat);   //skriver ut vegResultat utan HTML-taggar
						
						kapet.setText(removeHtml);
					}
					
				}
				sc.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
}
