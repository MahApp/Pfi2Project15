package se.mah.k3.pfi2.project.bus;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import net.miginfocom.swing.MigLayout;

import java.awt.Font;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;

public class BusPanel extends JPanel implements ModuleInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Station> searchStations = new ArrayList<Station>();
	public Journeys journeys;
	private Parser parser = new Parser();
	public JTextArea Stop;
	public JTextArea Departure;
	public JTextArea Destination;
	private int noOfUpdates = 0;
	private int updateInterval = 60000;
	private int results = 1;
	public int priority = getExpectedPriority();
	private int busCount = 0;
	private JTextField textField;
	public JTextArea Line;
	
	

	/**
	 * Create the panel.
	 */
	public BusPanel() {
		Thread lineThread = new BusPanel.LineThread(parser);

		setBackground(Color.LIGHT_GRAY);
		setLayout(new MigLayout("", "[grow][80px,grow][][grow][grow][80px][80px,grow][80px,grow][80px,grow]", "[][grow]"));

		JLabel lblLinje = new JLabel("Linje");
		//test ändring font size från 24 till 26
		lblLinje.setFont(new Font("Futura LT", Font.BOLD, 42));
		lblLinje.setForeground(new Color(0, 0, 0));
		lblLinje.setVerticalAlignment(SwingConstants.TOP);
		add(lblLinje, "cell 1 0,alignx center,aligny top");

		JLabel lblNewLabel = new JLabel("L�ge");
		lblNewLabel.setFont(new Font("Futura LT", Font.BOLD, 42));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		add(lblNewLabel, "cell 7 0,alignx center,aligny top");

		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Futura LT", Font.BOLD, 42));
		lblDestination.setForeground(new Color(0, 0, 0));
		lblDestination.setVerticalAlignment(SwingConstants.TOP);
		add(lblDestination, "cell 5 0 2 1,alignx center,aligny top");
		lblDestination.setBounds(92, 56, 236, 50);

		JLabel lblAvgr = new JLabel("Avg�ng");
		lblAvgr.setFont(new Font("Futura LT", Font.BOLD, 42));
		lblAvgr.setForeground(new Color(0, 0, 0));
		lblAvgr.setVerticalAlignment(SwingConstants.TOP);
		add(lblAvgr, "cell 8 0,alignx center,aligny top");
		
		JLayeredPane layeredPane = new JLayeredPane();
		add(layeredPane, "cell 1 1,grow");
		
		Line = new JTextArea();
		Line.setFont(new Font("Dialog", Font.BOLD, 32));
		Line.setDisabledTextColor(Color.BLACK);
		Line.setBounds(0, 0, 99, 217);
		layeredPane.add(Line);
		Line.setBackground(new Color(0,0,0,0));
		Line.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 39, 99, 46);
		layeredPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 124, 99, 46);
		layeredPane.add(panel_1);

		Destination = new JTextArea();
		Destination.setForeground(Color.BLACK);
		Destination.setEditable(false);
		Destination.setBackground(Color.LIGHT_GRAY);
		Destination.setFont(new Font("Futura LT", Font.BOLD, 32));
		Destination.setRows(2);
		Destination.setAutoscrolls(false);
		add(Destination, "cell 5 1 2 4,alignx center,growy");

		Stop = new JTextArea();
		Stop.setForeground(Color.BLACK);
		Stop.setEditable(false);
		Stop.setBackground(Color.LIGHT_GRAY);
		Stop.setFont(new Font("Futura LT", Font.BOLD, 32));
		Stop.setRows(2);
		Stop.setAutoscrolls(false);
		add(Stop, "cell 7 1 1 4,alignx center,growy");

		Departure = new JTextArea();
		Departure.setForeground(Color.BLACK);
		Departure.setEditable(false);
		Departure.setBackground(Color.LIGHT_GRAY);
		Departure.setFont(new Font("Futura LT", Font.BOLD, 32));
		Departure.setRows(2);
		Departure.setAutoscrolls(false);
		add(Departure, "cell 8 1 1 4,alignx center,growy");

		if (priority == 1){
			results = 4;
		}

		String searchURL = Constants.getURL("80046", "80000", results);
		System.out.println("START \nPRIORITET " + priority + "\nUPPDATERINGSINTERVALL: " + updateInterval/1000 + "s\n");
		Journeys journeys = Parser.getJourneys(searchURL);
		Destination.setText("");
		Stop.setText("");
		Departure.setText("");

		for (Journey journey : journeys.getJourneys()) {
			int HJ = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
			int MJ = journey.getDepDateTime().get(Calendar.MINUTE);
			String time = (String.format("%02d", HJ) + ":" + (String.format("%02d", MJ)));
			String depTime = journey.getTimeToDeparture() + journey.getDepTimeDeviation();

			Line.append("     " + journey.getLineOnFirstJourney() + "\n");
			Destination.append(journey.getTowards() + "\n");
			Stop.append(journey.getStopPoint() + "\n");

			try {
				if (Integer.valueOf(depTime) > 10 && Integer.valueOf(depTime) > 0) {
					Departure.append(time + "\n");
				} else {
					Departure.append(journey.getTimeToDeparture() + journey.getDepTimeDeviation() + " min \n");
				}
			} catch (NumberFormatException ex) {

			}
		}

		lineThread.start();
	}

	public class LineThread extends Thread {
		private Parser parser;

		public LineThread(Parser parser) {
			this.parser = parser;
		}

		public void run() {			
			try {
				while (true) {
					String searchURL = Constants.getURL("80046", "80000", results);
					Journeys journeys = Parser.getJourneys(searchURL);

					Thread.sleep(updateInterval);
					noOfUpdates++;
					System.out.println("UPPDATERING " + noOfUpdates + "\n");

					Line.setText("");
					Destination.setText("");
					Stop.setText("");
					Departure.setText("");

					for (Journey journey : journeys.getJourneys()) {
						int HJ = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
						int MJ = journey.getDepDateTime().get(Calendar.MINUTE);
						String time = (String.format("%02d", HJ) + ":" + (String.format("%02d", MJ)));
						String depTime = journey.getTimeToDeparture() + journey.getDepTimeDeviation();

						busCount++;

						Line.append("     " + journey.getLineOnFirstJourney() + "\n");
						Destination.append(journey.getTowards() + "\n");
						Stop.append(journey.getStopPoint() + "\n");
						System.out.println("Buss " + busCount + " avg�r om " + depTime + " min");

						if (Integer.valueOf(depTime) > 10 && Integer.valueOf(depTime) > 0) {
							Departure.append(time + "\n");
						} else {
							Departure.append(journey.getTimeToDeparture() + journey.getDepTimeDeviation() + " min \n");
						}
					}
				}
			} catch (Exception ex) {
			}
			start();
		}
	}

	@Override
	public int getExpectedPriority() {
		return 1;
	}

	@Override
	public int getPreferdNumberOfRows() {
		return 4;
	}

	@Override
	public int getMinNumberOfRows() {
		return 1;
	}

	@Override
	public boolean showNumberOfRows(int start, int end) {
		return false;
	}

	@Override
	public void repaintPanel() {
	}
}
