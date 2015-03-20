package se.mah.k3.pfi2.project.news;

import javax.swing.JComponent;
import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;

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
	public NewsPanel() {
		setForeground(UIManager.getColor("scrollbar"));
		setBorder(new LineBorder(Color.WHITE, 5));
		setBackground(new Color(240, 241, 241));
		setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(17, 18, 662, 241);
		panel2.setBackground(new Color(227, 230, 229));
		add(panel2);
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
