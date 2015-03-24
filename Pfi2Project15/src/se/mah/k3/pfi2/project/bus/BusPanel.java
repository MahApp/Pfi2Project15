package se.mah.k3.pfi2.project.bus;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import java.awt.Font;

import net.miginfocom.swing.MigLayout;

import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BusPanel extends JPanel implements ModuleInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JTextArea line;
	public JTextArea destination;
	public JTextArea stop;
	public JTextArea departure;
	
	public ArrayList<Station> searchStations = new ArrayList<Station>();
	public Journeys journeys;
	private Parser parser = new Parser();
	
	private int noOfUpdates = 0;
	private int updateInterval = 2000;
	private int results = 4;
	private JTable table;
	//public int priority = getExpectedPriority();
	
	public void Departures() {
		String searchURL = Constants.getURL("80046", "80000", results);
		Journeys journeys = Parser.getJourneys(searchURL);

//		line.setText("");
//		destination.setText("");
//		stop.setText("");
//		departure.setText("");

		for (Journey journey : journeys.getJourneys()) {
			int HJ = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
			int MJ = journey.getDepDateTime().get(Calendar.MINUTE);
			String time = (String.format("%02d", HJ) + ":" + (String.format("%02d", MJ)));
			String depTime = journey.getTimeToDeparture() + journey.getDepTimeDeviation();

//			line.append(journey.getLineOnFirstJourney() + "\n");
//			destination.append(journey.getTowards() + "\n");
//			stop.append(journey.getStopPoint() + "\n");
//
//			if (Integer.valueOf(depTime) > 10 && Integer.valueOf(depTime) > 0) {
//				departure.append(time + "\n");
//			} else {
//				departure.append(journey.getTimeToDeparture() + journey.getDepTimeDeviation() + " min \n");
//			}
		}
	}

	private void updateRowHeights()
	{
	    try
	    {
	        for (int row = 0; row < table.getRowCount(); row++)
	        {
	            int rowHeight = table.getRowHeight();

	            for (int column = 0; column < table.getColumnCount(); column++)
	            {
	                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
	                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
	            }

	            table.setRowHeight(row, rowHeight);
	        }
	    }
	    catch(ClassCastException e) {}
	}
	
	/**
	 * Create the panel.
	 */
	public BusPanel() {
		setBorder(new LineBorder(new Color(128, 128, 128), 5, true));
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JTable table = new JTable(){

		};
		
		table = new JTable();
		
		//BYTA FÄRG TILL GRÅ PÅ VARANNAN RAD
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
		    defaults.put("Table.alternateRowColor", new Color(240, 240, 240));
		table.setFont(new Font("Futura LT", Font.PLAIN, 32));
		table.setModel(new DefaultTableModel(
				
			new Object[][] {
				{"5", "Stenk\u00E4llan via Centralen", "B", "2 min"},
				{"5", "Stenk\u00E4llan via Centralen", "B", "23:00"},
				{"5", "Stenk\u00E4llan via Centralen", "B", "23:12"},
				{"5", "Stenk\u00E4llan via Centralen", "B", "23:22"},
			},
			new String[] {
				"Line", "Destination", "Stop", "Departure"
			}
		));
		add(table, "cell 0 0,grow");

//		JLabel lblLinje = new JLabel("Linje");
//		lblLinje.setFont(new Font("Futura LT", Font.PLAIN, 42));
//		lblLinje.setForeground(Color.BLACK);
//		lblLinje.setVerticalAlignment(SwingConstants.TOP);
//		add(lblLinje, "cell 1 0,alignx center,aligny top");
//
//		JLabel lblNewLabel = new JLabel("Läge");
//		lblNewLabel.setFont(new Font("Futura LT", Font.PLAIN, 42));
//		lblNewLabel.setForeground(Color.BLACK);
//		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
//		add(lblNewLabel, "cell 4 0,alignx center,aligny top");
//
//		JLabel lblDestination = new JLabel("Destination");
//		lblDestination.setFont(new Font("Futura LT", Font.PLAIN, 42));
//		lblDestination.setForeground(Color.BLACK);
//		lblDestination.setVerticalAlignment(SwingConstants.TOP);
//		add(lblDestination, "cell 2 0 2 1,alignx center,aligny top");
//		lblDestination.setBounds(92, 56, 236, 50);
//
//		JLabel lblAvgr = new JLabel("Avgång");
//		lblAvgr.setFont(new Font("Futura LT", Font.PLAIN, 42));
//		lblAvgr.setForeground(Color.BLACK);
//		lblAvgr.setVerticalAlignment(SwingConstants.TOP);
//		add(lblAvgr, "cell 5 0,alignx center,aligny top");
//
//		line = new JTextArea();
//		line.setEditable(false);
//		line.setForeground(Color.BLACK);
//		line.setRows(2);
//		line.setBackground(Color.LIGHT_GRAY);
//		line.setAutoscrolls(false);
//		line.setFont(new Font("Futura LT", Font.PLAIN, 32));
//		add(line, "cell 1 1 1 4,alignx center,growy");
//
//		destination = new JTextArea();
//		destination.setForeground(Color.BLACK);
//		destination.setEditable(false);
//		destination.setBackground(Color.LIGHT_GRAY);
//		destination.setFont(new Font("Futura LT", Font.PLAIN, 32));
//		destination.setRows(2);
//		destination.setAutoscrolls(false);
//		add(destination, "cell 2 1 2 4,alignx center,growy");
//
//		stop = new JTextArea();
//		stop.setForeground(Color.BLACK);
//		stop.setEditable(false);
//		stop.setBackground(Color.LIGHT_GRAY);
//		stop.setFont(new Font("Futura LT", Font.PLAIN, 32));
//		stop.setRows(2);
//		stop.setAutoscrolls(false);
//		add(stop, "cell 4 1 1 4,alignx center,growy");
//
//		departure = new JTextArea();
//		departure.setForeground(Color.BLACK);
//		departure.setEditable(false);
//		departure.setBackground(Color.LIGHT_GRAY);
//		departure.setFont(new Font("Futura LT", Font.PLAIN, 32));
//		departure.setRows(2);
//		departure.setAutoscrolls(false);
//		add(departure, "cell 5 1 1 4,alignx center,growy");

//		if (priority == 1){
//			results = 4;
//		}

		Thread lineThread = new BusPanel.LineThread(parser);
		Departures();
		System.out.println("START\n" + "UPPDATERINGSINTERVALL: " + updateInterval/1000 + "s\n");
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
					Departures();
					noOfUpdates++;
					System.out.println("UPPDATERING " + noOfUpdates + "\n");
					Thread.sleep(updateInterval);
				}
			} catch (Exception ex) {
			}
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