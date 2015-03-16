package trafikinfo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import javax.swing.JTextArea;
import java.awt.Font;

public class TrafikinfoGUI extends JFrame implements ModuleInterface{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrafikinfoGUI frame = new TrafikinfoGUI();
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
	public TrafikinfoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 1920);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/* ********************IF WE USE A SCROLLING STRING****************************** */
		// Placement on screen to be edited depending on what we decide in priority discussions
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193,0,43));
		panel.setBounds(0, 80, 1080, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrThisIsGoing = new JTextArea();
		txtrThisIsGoing.setForeground(Color.WHITE);
		txtrThisIsGoing.setText("Discuss font size with group");
		txtrThisIsGoing.setFont(new Font("Futura Std Medium", Font.PLAIN, 30));
		txtrThisIsGoing.setBackground(null);
		txtrThisIsGoing.setBounds(0, 20, 1080, 40);
		panel.add(txtrThisIsGoing);
		/* ********************IF WE USE A SCROLLING STRING****************************** */
		
		
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
