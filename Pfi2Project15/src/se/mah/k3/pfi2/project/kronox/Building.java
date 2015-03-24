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

public class Building extends JFrame {
	
	
	public JPanel contentPane;
	static Parser parser1 = new Parser();

	/**
	 * Launch the application.
	 */
	public static void main(Runnable runnable) {
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox buildings = new JComboBox();
		buildings.setFont(new Font("Futura LT", Font.PLAIN, 18));
		buildings.setBounds(16, 107, 265, 22);
		buildings.setModel(new DefaultComboBoxModel(new String[] {"Kranen / Ubåtshallen", "Orkanen", "Odontologkiska", "Gäddan"}));
		contentPane.add(buildings);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String currentBuilding = (String) buildings.getSelectedItem();
			if(currentBuilding.equals("Kranen / Ubåtshallen")){
				
				currentBuilding = "kranen";
						
			}else if (currentBuilding.equals("Orkanen")) {
				currentBuilding = "orkanen";
			}else if (currentBuilding.equals("Odontologiska")) {
				currentBuilding = "odontologiska";
			}else if (currentBuilding.equals("Gäddan")) {
				currentBuilding = "gäddan";
			}
			System.out.println("Setting current building to " + currentBuilding);
				parser1.setbuilding(currentBuilding);
			}
			
		});
		btnRun.setFont(new Font("Futura LT", Font.PLAIN, 15));
		btnRun.setBounds(281, 107, 117, 22);
		contentPane.add(btnRun);
	}
}
