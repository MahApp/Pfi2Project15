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
import javax.swing.border.LineBorder;

public class BusPanel extends JPanel implements ModuleInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextArea line = new JTextArea();
	public static JTextArea stop = new JTextArea();
	public static JTextArea departure = new JTextArea();
	public static JTextArea destination = new JTextArea();
	
	public ArrayList<Station> searchStations = new ArrayList<Station>();
	public Journeys journeys;
	private Parser p = new Parser();
	Thread t = new LineThread(p, this);
	

	private int noOfUpdates = 0;
	private int updateInterval = 60000;
	private int results = 1;
	public int priority = getExpectedPriority();
	private int busCount = 0;
	private JTextField textField = new JTextField();

	/**
	 * Create the panel.
	 */
	public BusPanel() {
		setBorder(new LineBorder(Color.DARK_GRAY, 4, true));
		Thread lineThread = new LineThread(p);

		setBackground(new Color( 136, 142, 149));
		setLayout(new MigLayout("", "[][112px][112px][112px,grow][112px,grow][112px,grow]"));

		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setFont(new Font("FuturaLT", Font.BOLD, 50));
		lblLinje.setForeground(new Color(255, 204, 0));
		lblLinje.setVerticalAlignment(SwingConstants.TOP);
		add(lblLinje, "cell 1 0,alignx center,aligny top");

		JLabel lblNewLabel = new JLabel("Läge");
		lblNewLabel.setFont(new Font("FuturaLT", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		add(lblNewLabel, "cell 4 0,alignx center,aligny top");

		JLabel lbldestination = new JLabel("Destination");
		lbldestination.setFont(new Font("FuturaLT", Font.BOLD, 50));
		lbldestination.setForeground(new Color(255, 204, 0));
		lbldestination.setVerticalAlignment(SwingConstants.TOP);
		add(lbldestination, "cell 2 0 2 1,alignx center,aligny top");
		lbldestination.setBounds(92, 56, 236, 50);

		JLabel lblAvgr = new JLabel("Avgång");
		lblAvgr.setFont(new Font("FuturaLT", Font.BOLD, 50));
		lblAvgr.setForeground(new Color(255, 204, 0));
		lblAvgr.setVerticalAlignment(SwingConstants.TOP);
		add(lblAvgr, "cell 5 0,alignx center,aligny top");

		line.setEditable(false);
		line.setForeground(Color.BLACK);
		line.setRows(2);
		line.setBackground(new Color( 136, 142, 149));
		line.setAutoscrolls(false);
		line.setFont(new Font("FuturaLT", Font.PLAIN, 40));
		add(line, "cell 1 1 1 4,alignx center,growy");

		destination = new JTextArea();
		destination.setForeground(Color.BLACK);
		destination.setEditable(false);
		destination.setBackground(new Color( 136, 142, 149));
		destination.setFont(new Font("FuturaLT", Font.PLAIN, 40));
		destination.setRows(2);
		destination.setAutoscrolls(false);
		add(destination, "cell 2 1 2 4,alignx center,growy");

		stop.setForeground(Color.BLACK);
		stop.setEditable(false);
		stop.setBackground(new Color( 136, 142, 149));
		stop.setFont(new Font("FuturaLT", Font.PLAIN, 40));
		stop.setRows(2);
		stop.setAutoscrolls(false);
		add(stop, "cell 4 1 1 4,alignx center,growy");

		departure = new JTextArea();
		departure.setForeground(Color.BLACK);
		departure.setEditable(false);
		departure.setBackground(new Color( 136, 142, 149));
		departure.setFont(new Font("FuturaLT", Font.PLAIN, 40));
		departure.setRows(2);
		departure.setAutoscrolls(false);
		add(departure, "cell 5 1 1 4,alignx center,growy");

		if (priority == 1){
			results = 4;
		}

		String searchURL = Constants.getURL("80046", "80000", results);
		System.out.println("START \nPRIORITET " + priority + "\nUPPDATERINGSINTERVALL: " + updateInterval/1000 + "s\n");
		Journeys journeys = Parser.getJourneys(searchURL);

		line.setText("");
		destination.setText("");
		stop.setText("");
	departure.setText("");

		for (Journey journey : journeys.getJourneys()) { 
			
			int H = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
			int M = journey.getDepDateTime().get(Calendar.MINUTE);
			
			String depTime = (String.format("%02d", H) + ":" + (String.format("%02d", M)));
			String timeToDep = journey.getTimeToDeparture() + journey.getDepTimeDeviation();

			line.append(journey.getLineOnFirstJourney() + "\n");
			destination.append(journey.getTowards() + "\n");
			stop.append(journey.getStopPoint() + "\n");
			
//			try {
//				if (Integer.valueOf(timeToDep) < 3) {
//					Line.append("*" + journey.getLineOnFirstJourney() + "\n");
//				}
//			} catch (NumberFormatException ex) {
//			}
			
			try {
				if (Integer.valueOf(timeToDep) > 10 && Integer.valueOf(timeToDep) > 0) {
					departure.append(depTime + "\n");
				} else {
					departure.append(journey.getTimeToDeparture() + journey.getDepTimeDeviation() + " min \n");
				}
			
					
				
			} catch (NumberFormatException ex) {

			}
		}
		Thread t = new LineThread(p, this);
		lineThread.start();
	}

//	public class LineThread extends Thread {
//		private Parser parser;
//
//		public LineThread(Parser parser) {
//			this.parser = parser;
//		}
//
//		public void run() {			
//			try {
//				while (true) {
//					String searchURL = Constants.getURL("80046", "80000", results);
//					Journeys journeys = Parser.getJourneys(searchURL);
//
//					Thread.sleep(updateInterval);
//					noOfUpdates++;
//					System.out.println("UPPDATERING " + noOfUpdates + "\n");
//
//					Line.setText("");
//					destination.setText("");
//					Stop.setText("");
//					Departure.setText("");
//
//					for (Journey journey : journeys.getJourneys()) {
//						int HJ = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
//						int MJ = journey.getDepDateTime().get(Calendar.MINUTE);
//						String time = (String.format("%02d", HJ) + ":" + (String.format("%02d", MJ)));
//						String depTime = journey.getTimeToDeparture() + journey.getDepTimeDeviation();
//
//						busCount++;
//
//						Line.append(journey.getLineOnFirstJourney() + "\n");
//						destination.append(journey.getTowards() + "\n");
//						Stop.append(journey.getStopPoint() + "\n");
//						System.out.println("Buss " + busCount + " avg�r om " + depTime + " min");
//
//						if (Integer.valueOf(depTime) > 10 && Integer.valueOf(depTime) > 0) {
//							Departure.append(time + "\n");
//						} else {
//							Departure.append(journey.getTimeToDeparture() + journey.getDepTimeDeviation() + " min \n");
//						}
//					}
//				}
//			} catch (Exception ex) {
//			}
//		}
//	}

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
