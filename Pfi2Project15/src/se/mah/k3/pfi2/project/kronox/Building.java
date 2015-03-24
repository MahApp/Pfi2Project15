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

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Futura LT", Font.PLAIN, 18));
		comboBox.setBounds(16, 80, 265, 83);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kranen / Ubåtshallen", "Orkanen", "Odontologkiska", "Gäddan", "Hälsa och samhälle"}));
		contentPane.add(comboBox);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRun.setFont(new Font("Futura LT", Font.PLAIN, 15));
		btnRun.setBounds(281, 107, 117, 29);
		contentPane.add(btnRun);
	}
}
