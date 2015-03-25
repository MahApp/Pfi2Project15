package se.mah.k3.pfi2.project.news;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import javax.swing.border.LineBorder;

public class LunchPanel extends JPanel implements ModuleInterface{

	
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
			panel2.setBounds(17, 11, 1047, 218);
			panel2.setBackground(Color.WHITE);
			add(panel2);
			panel2.setLayout(null);
			
			JPanel Rubrik = new JPanel();
			Rubrik.setBorder(new LineBorder(new Color(134, 188, 37), 1, true));
			Rubrik.setBounds(109, 2, 738, 50);
			Rubrik.setBackground(new Color(134,188,37));
			panel2.add(Rubrik);
			
					
					JLabel lblNews = new JLabel("DAGENS LUNCH");
					lblNews.setFont(new Font("Futura", Font.PLAIN, 28));
					lblNews.setForeground(Color.WHITE);
					Rubrik.add(lblNews);
					
					JLabel Dagens = new JLabel("New label");
					Dagens.setFont(new Font("Futura", Font.PLAIN, 20));
					Dagens.setBounds(17, 75, 536, 29);
					panel2.add(Dagens);
					
					JLabel Kapet = new JLabel("New label");
					Kapet.setFont(new Font("Futura", Font.PLAIN, 20));
					Kapet.setBounds(16, 116, 535, 33);
					panel2.add(Kapet);
					
					JLabel lblNewLabel_2 = new JLabel("New label");
					lblNewLabel_2.setFont(new Font("Futura", Font.PLAIN, 20));
					lblNewLabel_2.setBounds(16, 157, 529, 38);
					panel2.add(lblNewLabel_2);
			//panel.setBackground(new Color(134, 188, 37));
					
					

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
}