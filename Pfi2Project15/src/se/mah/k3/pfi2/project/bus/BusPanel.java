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
		setBackground(Color.PINK);
		setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Bus");
		add(lblNewLabel, BorderLayout.NORTH);

		
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
