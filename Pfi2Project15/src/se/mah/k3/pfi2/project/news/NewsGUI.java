package se.mah.k3.pfi2.project.news;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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
	public NewsGUI() {
		setBounds(100, 100, 688, 300);
		contentPane = new JPanel();
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
			Rubrik.setBackground(new Color(0, 158, 212));
			panel2.add(Rubrik);
			
					
					JLabel lblNews = new JLabel("Kalendarium");
					lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
					lblNews.setForeground(Color.WHITE);
					Rubrik.add(lblNews);
					
					
					Meny.setFont(new Font("Futura", Font.PLAIN, 20));
					Meny.setText("Här kommer schemat för gästföreläsningar och seminarium stå!");
					Meny.setBounds(280, 58, 381, 163);
					Meny.setBackground(new Color(227, 230, 229));
					Meny.setForeground(new Color(97, 101, 109));
					panel2.add(Meny);
					
					JLabel lblNewLabel = new JLabel("New label");
					lblNewLabel.setIcon(new ImageIcon(NewsGUI.class.getResource("/Images/11063394_10152837690193282_601781019_n.jpg")));
					lblNewLabel.setBounds(11, 22, 202, 193);
					panel2.add(lblNewLabel);
					
					JPanel RAM = new JPanel();
					RAM.setBounds(8, 26, 208, 184);
					panel2.add(RAM);
					RAM.setBackground(new Color(0,158,212));
			//panel.setBackground(new Color(134, 188, 37));

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


		
	


