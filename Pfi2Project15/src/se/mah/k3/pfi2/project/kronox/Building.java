package se.mah.k3.pfi2.project.kronox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class Building extends JFrame {
	
	
	public JPanel contentPane;
	private JTextField timeSpan;
	FilterOutTime filter= new FilterOutTime();
	//static Parser parser1 = new Parser();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args0) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Building frame = new Building();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Building() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox buildings = new JComboBox();
		buildings.setFont(new Font("Futura LT", Font.PLAIN, 15));
		buildings.setBounds(16, 107, 265, 22);
		buildings.setModel(new DefaultComboBoxModel(new String[] {"Kranen","Ubåtshallen", "Orkanen", "Odontologkiska", "Gäddan"}));
		contentPane.add(buildings);
		
		JButton btnRun = new JButton("Set building");
		btnRun.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String currentBuilding = (String) buildings.getSelectedItem();
//			if(currentBuilding.equals("Kranen")){
//				currentBuilding = "kranen";
//			}else if(currentBuilding.equals("Ubåtshallen")){
//					currentBuilding = "ubåtshallen";
//			}else if (currentBuilding.equals("Orkanen")) {
//				currentBuilding = "orkanen";
//			}else if (currentBuilding.equals("Odontologiska")) {
//				currentBuilding = "odontologiska";
//			}else if (currentBuilding.equals("Gäddan")) {
//				currentBuilding = "gäddan";
//			}
			switch(currentBuilding){
			case "Kranen": currentBuilding = "kranen";break;
			case "Ubåtshallen": currentBuilding = "ubåtshallen";break;
			case "Orkanen": currentBuilding = "orkanen";break;
			case "Gäddan": 	currentBuilding = "gäddan";break;
			case "Odontologiska": currentBuilding = "odontologiska";break;
			default:
			}
			
			System.out.println("Setting current building to " + currentBuilding);
				//Parser.setbuilding(currentBuilding);
				Parser.biulding=currentBuilding;

			}
			
		});
		btnRun.setFont(new Font("Futura LT", Font.PLAIN, 15));
		btnRun.setBounds(293, 107, 134, 22);
		contentPane.add(btnRun);
		
		timeSpan = new JTextField("30");
		timeSpan.setBounds(26, 142, 57, 22);
		contentPane.add(timeSpan);
		timeSpan.setColumns(10);
		
		JButton btnSetUpdateinterval = new JButton("set timeScope");
		btnSetUpdateinterval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FilterOutTime.minuteMargin=Integer.parseInt(timeSpan.getText());
			}
		});
		btnSetUpdateinterval.setFont(new Font("Futura LT", Font.PLAIN, 15));
		btnSetUpdateinterval.setBounds(164, 140, 256, 25);
		contentPane.add(btnSetUpdateinterval);
		
		JLabel lblMinutes = new JLabel("minutes");
		lblMinutes.setForeground(Color.WHITE);
		lblMinutes.setFont(new Font("Futura LT", Font.PLAIN, 13));
		lblMinutes.setBounds(96, 146, 56, 16);
		contentPane.add(lblMinutes);



		
		//awtControlDemo.repaint();
	}
}
