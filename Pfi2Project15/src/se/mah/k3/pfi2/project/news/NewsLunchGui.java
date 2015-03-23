package se.mah.k3.pfi2.project.news;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NewsLunchGui extends JPanel {

	public JLabel labelDagens;
	public JLabel vegetarisk;
	public JLabel kapet;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsLunchGui frame = new NewsLunchGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the panel.
	 */
	
	
	public NewsLunchGui() {
		setBounds(100, 100, 688, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
			
			JPanel panel2 = new JPanel();
			panel2.setBounds(17, 18, 662, 241);
			panel2.setBackground(new Color(227, 230, 229));
			getContentPane().add(panel2);
			panel2.setLayout(null);
			
			JPanel Rubrik = new JPanel();
			Rubrik.setBounds(433, -1, 218, 50);
			Rubrik.setBackground(new Color(134, 188, 37 ));
			panel2.add(Rubrik);
			
					
					JLabel lblNews = new JLabel("Lunch 69:-");
					lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
					lblNews.setForeground(Color.WHITE);
					Rubrik.add(lblNews);
					
					
				
					
					JPanel panel = new JPanel();
					panel.setBackground(new Color(0, 158, 212));
					panel.setBounds(16, -1, 218, 50);
					panel2.add(panel);
					
					JLabel label = new JLabel("Kalendarium");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Futura", Font.PLAIN, 28));
					panel.add(label);
			//panel.setBackground(new Color(134, 188, 37));

					JLabel lblNews1 = new JLabel("Lunch 69:-");
					lblNews1.setFont(new Font("Futura", Font.PLAIN, 28));
					lblNews1.setForeground(Color.WHITE);
					Rubrik.add(lblNews);
					
				
					
					labelDagens = new JLabel("dagens");
					labelDagens.setBounds(358, 87, 293, 31);
					panel2.add(labelDagens);
					
					vegetarisk = new JLabel("vegetarisk");
					vegetarisk.setBounds(358, 156, 293, 31);
					panel2.add(vegetarisk);
					
					kapet = new JLabel("kapet");
					kapet.setBounds(358, 119, 293, 31);
					panel2.add(kapet);
			//panel.setBackground(new Color(134, 188, 37));
					readAndWriteMonday();

		}


		
	
		private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}




		private void setContentPane(JPanel contentPane) {
		// TODO Auto-generated method stub
		
	}




		public int getExpectedPriority() {
			// TODO Auto-generated method stub
			return 0;
		}


		public int getPreferdNumberOfRows() {
			// TODO Auto-generated method stub
			return 0;
		}


		public int getMinNumberOfRows() {
			// TODO Auto-generated method stub
			return 0;
		}


		public boolean showNumberOfRows(int start, int end) {
			// TODO Auto-generated method stub
			return false;
		}

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
						
						
						System.out.println(cleanResultat);
						labelDagens.setText(cleanResultat);
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
						vegetarisk.setText("Ha" + cleanResultat);
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
						kapet.setText(cleanResultat);
					}
					
				}
				sc.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}


	
		
	}
}
