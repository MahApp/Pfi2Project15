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
	TrafikinfoGUI g = this;

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
		setBounds(100, 100, 1080, 80);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/* ********************IF WE USE A SCROLLING STRING****************************** */
		// Placement on screen to be edited depending on what we decide in priority discussions
		JPanel panelString = new JPanel();
		panelString.setBackground(new Color(193,0,43));
		panelString.setBounds(0, 80, 1080, 80);
		contentPane.add(panelString);
		panelString.setLayout(null);
		
		JTextArea txtrString = new JTextArea();
		txtrString.setForeground(Color.WHITE);
		txtrString.setText("Discuss font size with group");
		txtrString.setFont(new Font("Futura Std Medium", Font.PLAIN, 30));
		txtrString.setBackground(null);
		txtrString.setBounds(0, 20, 1080, 40);
		panelString.add(txtrString);
		/* ********************IF WE USE A SCROLLING STRING****************************** */
		
		Thread tx = new gThread(g);
		tx.start();
		
		/* ********************IF WE USE A BLOCK***************************************** */
		// Placement on screen to be edited depending on what we decide in priority discussions
		JPanel panelBlock = new JPanel();
		panelBlock.setBounds(0, 733, 1080, 320);
		contentPane.add(panelBlock);
		panelBlock.setBackground(new Color(193,0,43));
		panelBlock.setLayout(null);
		
		JTextArea textAreaBlock = new JTextArea();
		textAreaBlock.setText("Text for a block of information.");
		textAreaBlock.setForeground(Color.WHITE);
		textAreaBlock.setFont(new Font("Futura Std Medium", Font.PLAIN, 30));
		textAreaBlock.setBackground(null);
		textAreaBlock.setBounds(20, 20, 1040, 280);
		panelBlock.add(textAreaBlock);
		/* ********************IF WE USE A BLOCK***************************************** */

		
		
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
