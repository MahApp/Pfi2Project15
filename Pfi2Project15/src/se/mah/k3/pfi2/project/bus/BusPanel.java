package se.mah.k3.pfi2.project.bus;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

import net.miginfocom.swing.MigLayout;

public class BusPanel extends JPanel implements ModuleInterface{
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public JTextArea Line;
	public ArrayList<Station> searchStations = new ArrayList<Station>();
	public Journeys journeys;
	private Parser parser = new Parser();
	public JTextArea Destination;
	public JTextArea Stop;
	private JTextArea Departure;

	/**
	 * Create the panel.
	 */
	public BusPanel() {
		Thread lineThread = new BusPanel.LineThread(parser);
		lineThread.start();

		setBackground(Color.LIGHT_GRAY);
		setLayout(new MigLayout("", "[][112px][112px][112px,grow][112px,grow][112px,grow]", "[150px][150px,grow][150px,grow][150px,grow][150px,grow]"));

		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLinje.setForeground(new Color(0, 0, 0));
		lblLinje.setVerticalAlignment(SwingConstants.TOP);
		add(lblLinje, "flowx,cell 1 0,alignx center,aligny top");

		JLabel lblNewLabel = new JLabel("L\u00E4ge");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		add(lblNewLabel, "cell 4 0,alignx center,growy");

		JLabel lblAvgr = new JLabel("Avg\u00E5ng");
		lblAvgr.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAvgr.setForeground(new Color(0, 0, 0));
		lblAvgr.setVerticalAlignment(SwingConstants.TOP);
		add(lblAvgr, "cell 5 0,grow");

		Line = new JTextArea();
		Line.setRows(2);
		Line.setBackground(Color.LIGHT_GRAY);
		Line.setAutoscrolls(false);
		Line.setFont(new Font("Tahoma", Font.BOLD, 14));
		Line.setEditable(false);
		add(Line, "flowx,cell 1 1 1 4,alignx center,growy");

		Destination = new JTextArea();
		Destination.setEditable(false);
		Destination.setBackground(Color.LIGHT_GRAY);
		Destination.setFont(new Font("Tahoma", Font.BOLD, 14));
		Destination.setRows(2);
		Destination.setAutoscrolls(false);
		add(Destination, "cell 2 1 2 4,grow");

		Stop = new JTextArea();
		Stop.setEditable(false);
		Stop.setBackground(Color.LIGHT_GRAY);
		Stop.setFont(new Font("Tahoma", Font.BOLD, 14));
		Stop.setRows(2);
		Stop.setAutoscrolls(false);
		add(Stop, "cell 4 1 1 4,alignx center,growy");

		Departure = new JTextArea();
		Departure.setEditable(false);
		Departure.setBackground(Color.LIGHT_GRAY);
		Departure.setFont(new Font("Tahoma", Font.BOLD, 14));
		Departure.setRows(2);
		Departure.setForeground(new Color(0, 0, 0));
		Departure.setAutoscrolls(false);
		add(Departure, "cell 5 1 1 4,alignx center,growy");

		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDestination.setForeground(new Color(0, 0, 0));
		lblDestination.setVerticalAlignment(SwingConstants.TOP);
		add(lblDestination, "cell 2 0 2 1,grow");
	}

	public class LineThread extends Thread{
		private Parser parser;
		private ArrayList<Station> searchStations = new ArrayList<Station>();

		public LineThread(Parser parser) {
			this.parser = parser;
		}

		public void run() {
			try {
				while (true) {
					String searchURL = Constants.getURL("80046","80000",4);
					System.out.println(searchURL);
					Journeys journeys = Parser.getJourneys(searchURL); 

					Thread.sleep(60000);
					Line.setText("");
					Destination.setText("");
					Stop.setText("");
					Departure.setText("");
					for (Journey journey : journeys.getJourneys()) {

						int HJ= journey.getDepDateTime().get(Calendar.HOUR_OF_DAY);
						int MJ = journey.getDepDateTime().get(Calendar.MINUTE);
						String time=(String.format("%02d",HJ)+":"+(String.format("%02d",MJ)));
						String depTime = journey.getTimeToDeparture()+journey.getDepTimeDeviation();

						Line.append(journey.getLineOnFirstJourney() + "\n");
						Destination.append(journey.getTowards()+"\n");
						Stop.append(journey.getStopPoint() + "\n");
						System.out.println(depTime);

						if(Integer.valueOf(depTime) > 10 && Integer.valueOf(depTime) > 0) {
							Departure.append(time + "\n");
						} else {
							Departure.append(journey.getTimeToDeparture()+journey.getDepTimeDeviation() + " min \n");
						}
					}
				}
			} catch (Exception ex){
			} start();
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