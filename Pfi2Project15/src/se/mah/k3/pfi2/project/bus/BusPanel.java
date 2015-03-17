package se.mah.k3.pfi2.project.bus;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BusPanel extends JPanel implements ModuleInterface{
	private JTextField textField;

	private JFrame frmSknetrafiken;
	public JTextArea Linje;
	public ArrayList<Station> searchStations = new ArrayList<Station>();
	public JTextArea Sökresultat_1;
	public JTextField Från;
	public JTextField Till;
	public String results = "";
	public Journeys journeys;
	private Parser parser = new Parser();
	private JTextArea Destination;
	private JTextArea Avgår;
	private JTextArea Sen;

	/**
	 * Create the panel.
	 */
	public BusPanel() {
		setBackground(Color.DARK_GRAY);
				setLayout(new GridLayout(0, 3, 0, 0));
				
				JLabel lblLinje = new JLabel("Linje");
				lblLinje.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblLinje.setForeground(Color.ORANGE);
				lblLinje.setVerticalAlignment(SwingConstants.TOP);
				add(lblLinje);
				
				JLabel lblDestination = new JLabel("Destination");
				lblDestination.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblDestination.setForeground(Color.ORANGE);
				lblDestination.setVerticalAlignment(SwingConstants.TOP);
				add(lblDestination);
				
				JLabel lblAvgr = new JLabel("Avg\u00E5r");
				lblAvgr.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblAvgr.setForeground(Color.ORANGE);
				lblAvgr.setVerticalAlignment(SwingConstants.TOP);
				add(lblAvgr);
				
				JLabel lblNewLabel = new JLabel("5");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel.setForeground(Color.ORANGE);
				lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
				add(lblNewLabel);
				
				JLabel lblStenkllanViaCentralen = new JLabel("Stenk\u00E4llan via Centralen");
				lblStenkllanViaCentralen.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblStenkllanViaCentralen.setForeground(Color.ORANGE);
				lblStenkllanViaCentralen.setVerticalAlignment(SwingConstants.TOP);
				lblStenkllanViaCentralen.setHorizontalAlignment(SwingConstants.LEFT);
				add(lblStenkllanViaCentralen);
				
				JLabel lblNewLabel_1 = new JLabel("2 min");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_1.setForeground(Color.ORANGE);
				lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
				add(lblNewLabel_1);
		
		
		
		
	}

	@Override
	public int getExpectedPriority() {
		// Prioritet 1 f�r testsyfte
		return 1;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 1;
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
