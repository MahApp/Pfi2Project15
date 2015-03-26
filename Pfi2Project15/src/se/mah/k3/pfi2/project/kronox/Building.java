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

public class Building extends JFrame {
	
	
	public JPanel contentPane;
	//static Parser parser1 = new Parser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args0) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Building frame = new Building();
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
//				ParserUpdateThread pt= new ParserUpdateThread();
//				pt.start();
				
//				CanvasInJframe frame = new CanvasInJframe();
//				CanvasInJframe awtControlDemo = new CanvasInJframe();
//				try{
//					frame.setVisible(false);
//					awtControlDemo.showCanvasDemo();
//					awtControlDemo.setVisible(true);
					//awtControlDemo.setTitle("loading..."); window
					
					//Building.this.setVisible(false);
				//	System.exit(0);
					
//				} catch (Exception er) {
//					er.printStackTrace();
//				}
				//awtControlDemo.loadData(Parser.getPost());
			}
			
		});
		btnRun.setFont(new Font("Futura LT", Font.PLAIN, 15));
		btnRun.setBounds(310, 107, 117, 22);
		contentPane.add(btnRun);



		
		//awtControlDemo.repaint();
	}
}
