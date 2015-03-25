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

	public JLabel event1;
	public JLabel event2;
	public JLabel event3;
	
	/**
	 * Create the panel.
	 */
	

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
				Rubrik.setLayout(null);
		
				
				JLabel lblNews = new JLabel("Event & händelser idag");
				lblNews.setBounds(38, 9, 295, 39);
				lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
				lblNews.setForeground(Color.WHITE);
				Rubrik.add(lblNews);
				
				event1 = new JLabel("");
				event1.setFont(new Font("Futura", Font.PLAIN, 20));
				event1.setBounds(284, 75, 956, 37);
				panel2.add(event1);
				
				event2 = new JLabel("");
				event2.setFont(new Font("Futura", Font.PLAIN, 20));
				event2.setBounds(284, 116, 956, 37);
				panel2.add(event2);
				
				event3 = new JLabel("");
				event3.setFont(new Font("Futura", Font.PLAIN, 20));
				event3.setBounds(284, 157, 956, 37);
				panel2.add(event3);
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon(NewsPanel.class.getResource("/Images/Forelasning.png")));
				lblNewLabel.setBounds(65, 20, 183, 175);
				panel2.add(lblNewLabel);
				
				
				
				readAndWriteEvents();

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

	public void readAndWriteEvents(){
		try {
			URL mahKalender = new URL("http://www.mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");
			Scanner s = new Scanner(mahKalender.openStream());
			while (s.hasNext()) {
			//	String string = s.nextLine();
			//	System.out.println(string);
				String s2 = s.nextLine();
				if (s2.contains("2015-03-27")){
			//		System.out.println(s2);
					
					String eventOne = ("10.00 	Hälsa & Samhälle	Spikning: Allogenic stem cell transplantation");
					String eventTwo = ("13.00 	Ubåtshallen 301 	Girls of Hope: Film screening");
					String eventThree = ("13.15 	Orkanen D138 	Disputation - Helen Hasslöf");
					
					System.out.println(eventOne);
					System.out.println(eventTwo);
					System.out.println(eventThree);
				
					event1.setText(eventOne);
					event2.setText(eventTwo);
					event3.setText(eventThree);
				}

				}
			s.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
