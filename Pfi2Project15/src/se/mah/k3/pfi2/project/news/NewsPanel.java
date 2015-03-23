package se.mah.k3.pfi2.project.news;

import javax.swing.JComponent;
import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class NewsPanel extends JPanel implements ModuleInterface{

	public JTextArea Meny = new JTextArea();
	
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

	}


	
	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
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
}
