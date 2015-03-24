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

import javax.swing.JLabel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import java.awt.Font;

import net.miginfocom.swing.MigLayout;

import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BusPanel extends JPanel implements ModuleInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tableTitle;
	private JTable tableDepartures;

	private String line = "1";
	private String destination = "";
	private String stop = "";
	private String departure = "";

	private int noOfUpdates = 0;
	private int updateInterval = 2000;
	private int results = 4;

	public ArrayList<Station> searchStations = new ArrayList<Station>();
	public Journeys journeys;
	private Parser parser = new Parser();

	/**
	 *Skapa JTable för titlar.
	 */
	private void titleTable() {
		tableTitle = new JTable();
		tableTitle.setForeground(Color.BLACK);
		tableTitle.setBorder(new LineBorder(Color.GRAY, 3, true));
		tableTitle.setBackground(Color.GRAY);
		tableTitle.setRowSelectionAllowed(false);
		tableTitle.setShowGrid(false);
		tableTitle.setShowHorizontalLines(false);
		tableTitle.setShowVerticalLines(false);
		tableTitle.setFont(new Font("Futura LT", Font.PLAIN, 58));
		tableTitle.setModel(new DefaultTableModel(
				new Object[][] {
						{"Linje", "Destination", "Läge", "Avgång"},
				},
				new String[] {
						"Line", "Destination", "Stop", "Departure"
				}
				));
	}

	/**
	 *Skapa JTable för avgångar.
	 */
	private void departuresTable() {
		tableDepartures = new JTable();
		tableDepartures.setFont(new Font("Futura LT", Font.PLAIN, 42));
		tableDepartures.setRowSelectionAllowed(false);
		tableDepartures.setShowGrid(false);
		tableDepartures.setShowHorizontalLines(false);
		tableDepartures.setShowVerticalLines(false);
		tableDepartures.setModel(new DefaultTableModel(
				new Object[][] {
						{line, destination, stop, departure},
						{line, destination, stop, departure},
						{line, destination, stop, departure},
						{line, destination, stop, departure},
				},
				new String[] {
						"Line", "Destination", "Stop", "Departure"
				}
				));
	}

	/**
	 *Bestäm radhöjd på JTables.
	 */
	private void setRowHeights()
	{
		try
		{
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();;

			for (int row = 0; row < tableDepartures.getRowCount(); row++)
			{
				int rowHeight = tableDepartures.getRowHeight();

				for (int column = 0; column < tableDepartures.getColumnCount(); column++)
				{
					centerRenderer.setHorizontalAlignment( JLabel.CENTER );
					tableTitle.getColumnModel().getColumn(column).setCellRenderer( centerRenderer );
					tableDepartures.getColumnModel().getColumn(column).setCellRenderer( centerRenderer );
					rowHeight = 80;
				}
				tableTitle.setRowHeight(row, rowHeight);
				tableDepartures.setRowHeight(row, rowHeight);
			}
		}
		catch(ClassCastException e) {}
	}

	/**
	 *Hämta och skriv ut avgångar.
	 */
	public void Departures() {
		String searchURL = Constants.getURL("80046", "80000", results);
		Journeys journeys = Parser.getJourneys(searchURL);

		for (Journey journey : journeys.getJourneys()) {
			int HJ = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
			int MJ = journey.getDepDateTime().get(Calendar.MINUTE);
			String time = (String.format("%02d", HJ) + ":" + (String.format("%02d", MJ)));
			String depTime = journey.getTimeToDeparture() + journey.getDepTimeDeviation();

			line = (journey.getLineOnFirstJourney());
			destination = (journey.getTowards());
			stop = (journey.getStopPoint());

			if (Integer.valueOf(depTime) > 10 && Integer.valueOf(depTime) > 0) {
				departure = (time);
			} else {
				departure = (journey.getTimeToDeparture() + journey.getDepTimeDeviation() + " min");
			}
		}
		titleTable();
		departuresTable();
		setRowHeights();
	}



	/**
	 * Create the panel.
	 */
	public BusPanel() {
		setBorder(new LineBorder(Color.GRAY, 5, true));
		setBackground(Color.WHITE);
		setLayout(new MigLayout("insets 0", "[1%:n][grow][::1%,grow]", "[grow][grow]"));

		//BYTA FÄRG PÅ VARANNAN RAD
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(240, 240, 240));

		//SKRIV UT AVGÅNGAR EN GÅNG, RITA JTABLES OCH STARTA TRÅD
		Thread lineThread = new BusPanel.LineThread(parser);
		Departures();
		add(tableDepartures, "cell 0 1 3 1,grow");
		add(tableTitle, "cell 1 0,grow");
		System.out.println("START\n" + "UPPDATERINGSINTERVALL: " + updateInterval/1000 + "s\n");
		lineThread.start();
	}

	/**
	 * Uppdatera avgångar.
	 */
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