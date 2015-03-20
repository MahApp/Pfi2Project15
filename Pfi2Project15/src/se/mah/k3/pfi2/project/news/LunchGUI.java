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

public class LunchGUI extends JFrame {
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
	public LunchGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			Rubrik.setBounds(24, 0, 218, 50);
			Rubrik.setBackground(new Color(134,188,37));
			panel2.add(Rubrik);
			
					
					JLabel lblNews = new JLabel("Lunch 69:-");
					lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
					lblNews.setForeground(Color.WHITE);
					Rubrik.add(lblNews);
					
					
					Meny.setFont(new Font("Futura", Font.PLAIN, 20));
					Meny.setText("Här kommer menyn stå!");
					Meny.setBounds(24, 57, 381, 163);
					Meny.setBackground(new Color(227, 230, 229));
					Meny.setForeground(new Color(97, 101, 109));
					panel2.add(Meny);
					
					JLabel lblNewLabel = new JLabel("New label");
					lblNewLabel.setIcon(new ImageIcon(NewsPanel.class.getResource("/Images/salad.jpg")));
					lblNewLabel.setBounds(438, 19, 202, 196);
					panel2.add(lblNewLabel);
					
					JPanel RAM = new JPanel();
					RAM.setBounds(435, 16, 208, 204);
					panel2.add(RAM);
					RAM.setBackground(new Color(134,188,37));
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


		
	


