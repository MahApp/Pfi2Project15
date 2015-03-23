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

public class NewsGUI extends JFrame {
	public JTextArea Meny = new JTextArea();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsGUI frame = new NewsGUI();
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
	public NewsGUI() {
		setBounds(100, 100, 1080, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
			
			JPanel panel2 = new JPanel();
			panel2.setBounds(17, 18, 662, 241);
			panel2.setBackground(new Color(238,238,238));
			getContentPane().add(panel2);
			panel2.setLayout(null);
					
					JPanel panel = new JPanel();
					panel.setLayout(null);
					panel.setBackground(new Color(227, 230, 229));
					panel.setBounds(10, 11, 1034, 329);
					panel2.add(panel);
					
					JPanel Rubrik = new JPanel();
					Rubrik.setBounds(423, 11, 218, 50);
					panel.add(Rubrik);
					Rubrik.setBackground(new Color(0, 158, 212));
					
							
							JLabel lblNews = new JLabel("Kalendarium");
							lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
							lblNews.setForeground(Color.WHITE);
							Rubrik.add(lblNews);
							Meny.setBounds(242, 98, 782, 163);
							panel.add(Meny);
							
							
							Meny.setFont(new Font("Dialog", Font.PLAIN, 18));
							Meny.setText("kalendarie hej schema");
							Meny.setBackground(new Color(227, 230, 229));
							Meny.setForeground(new Color(97, 101, 109));
							
							JLabel lblNewLabel = new JLabel("New label");
							lblNewLabel.setBounds(19, 85, 202, 193);
							panel.add(lblNewLabel);
							lblNewLabel.setIcon(new ImageIcon(NewsGUI.class.getResource("/Images/11063394_10152837690193282_601781019_n.jpg")));
							
							JPanel RAM = new JPanel();
							RAM.setBounds(10, 84, 222, 195);
							panel.add(RAM);
							RAM.setBackground(new Color(0,158,212));
			//panel.setBackground(new Color(134, 188, 37));
					
					readAndWriteEvents();
		}

		
	public void readAndWriteEvents(){
		try {
			URL mahKalender = new URL("http://www.mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");
			Scanner s = new Scanner(mahKalender.openStream());
			while (s.hasNext()) {
				String string = s.nextLine();
			//	System.out.println(string);
				String s2 = s.nextLine();
				if (s2.contains("2015-03-27")){
				//	System.out.println(s2);
					String eventOne = ("27/3	10.00-11.00 	Spikning: Allogenic stem cell transplantation 				Hälsa & Samhälle");
					String eventTwo = ("27/3 	13.00-15.00 	Girls of Hope: Film screening with director Aysegül Selenga Taskent 	Ubåtshallen 301");
					String eventThree = ("27/3 	13.15-15.00 	Disputation - Helen Hasslöf 						Orkanen D138");
					
					System.out.println(eventOne);
					System.out.println(eventTwo);
					System.out.println(eventThree);
					Meny.setText(eventOne + "\n" + eventTwo + "\n" + eventThree + "\n");
				}

				}
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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
}


		
	


