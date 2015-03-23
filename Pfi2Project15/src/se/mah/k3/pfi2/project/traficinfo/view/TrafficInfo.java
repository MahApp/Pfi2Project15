package se.mah.k3.pfi2.project.traficinfo.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import javax.swing.JTextArea;

import java.awt.Font;

public class TrafficInfo extends JFrame implements ModuleInterface{

	private JPanel contentPane;
	TrafficInfo g = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrafficInfo frame = new TrafficInfo();
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
	public TrafficInfo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(193,0,43));
		
		
		/* ********************IF WE USE A SCROLLING STRING****************************** */
		// Placement on screen to be edited depending on what we decide in priority discussions
		JPanel panelString = new JPanel();
		panelString.setBackground(new Color(193,0,43));
		panelString.setBounds(0, 160, 1080, 80);
		contentPane.add(panelString);
		panelString.setLayout(null);
		
		/*JLabel lblNewLabel = new JLabel("TRAFIKST\u00D6RNING:");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setDisplayedMnemonicIndex(0);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Futura Std Heavy", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, -5, 290, 46);
		add(lblNewLabel); */
		
		/*JLabel left310 = new JLabel("New label");
		left310.setIcon(new ImageIcon(TrafficInfo.class.getResource("/resources/left_part_310x80.PNG")));
		left310.setBounds(-300, 0, 310, 80);
		add(left310);*/
		
		/*JLabel middle580 = new JLabel("New label");
		middle580.setIcon(new ImageIcon(TrafficInfo.class.getResource("/resources/middle_part_580x80.PNG")));
		middle580.setBounds(310, 0, 580, 80);
		add(middle580); */
		
		JLabel right190 = new JLabel("New label");
		right190.setInheritsPopupMenu(false);
		right190.setIcon(new ImageIcon(TrafficInfo.class.getResource("/resources/warningsign.png")));
		right190.setBounds(0, 0, 1080, 160);
		add(right190);
		
		
		
		Thread tx = new gThread(g);
		tx.start();	
	}
	
	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 2;
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
