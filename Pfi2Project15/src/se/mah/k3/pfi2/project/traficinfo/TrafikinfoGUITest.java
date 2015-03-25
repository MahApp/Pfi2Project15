package se.mah.k3.pfi2.project.traficinfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class TrafikinfoGUITest extends JFrame {
	// Skapar en ny JFrame f�r sidoscrolls-texten.
	 JPanel contentPane;
	
	
	// H�r skapas sidoscrollande text. Minimera f�r att jobba ost�rt med GUI.


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrafikinfoGUITest frame = new TrafikinfoGUITest();
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
	
	public TrafikinfoGUITest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
// Mer info f�r sidoscroll, minimera f�r att jobba ost�rt med GUI.
	
	

}
