package se.mah.k3.pfi2.project.news;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class LunchGUI extends JFrame {

	public JPanel contentPane;

	public JLabel labelDagens;
	public JLabel vegetarisk;
	public JLabel kapet;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LunchGUI frame = new LunchGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LunchGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ScannerHalsaSamhall st = new ScannerHalsaSamhall();
		st.readAndWriteMonday();
		
			
			JPanel panel2 = new JPanel();
			panel2.setBounds(17, 18, 662, 241);
			panel2.setBackground(new Color(227, 230, 229));
			getContentPane().add(panel2);
			panel2.setLayout(null);
			
			JPanel Rubrik = new JPanel();
			Rubrik.setBounds(24, 0, 218, 50);
			Rubrik.setBackground(new Color(134,188,37));
			panel2.add(Rubrik);
			
					
					JLabel lblNews = new JLabel("Lunch 69:-");
					lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
					lblNews.setForeground(Color.WHITE);
					Rubrik.add(lblNews);
					
					JLabel lblNewLabel = new JLabel("New label");
					lblNewLabel.setIcon(new ImageIcon(NewsPanel.class.getResource("/Images/salad.jpg")));
					lblNewLabel.setBounds(438, 19, 202, 196);
					panel2.add(lblNewLabel);
					
					JPanel RAM = new JPanel();
					RAM.setBounds(435, 16, 208, 204);
					panel2.add(RAM);
					RAM.setBackground(new Color(134,188,37));
					
					labelDagens = new JLabel("");
					labelDagens.setBounds(24, 87, 293, 31);
					panel2.add(labelDagens);
					
					vegetarisk = new JLabel("hh");
					vegetarisk.setBounds(24, 154, 293, 31);
					panel2.add(vegetarisk);
					
					kapet = new JLabel("");
					kapet.setBounds(24, 224, 293, 31);
					panel2.add(kapet);
			//panel.setBackground(new Color(134, 188, 37));
					readAndWriteMonday();

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


		
	


