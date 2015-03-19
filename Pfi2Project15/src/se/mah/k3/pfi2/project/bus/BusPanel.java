package se.mah.k3.pfi2.project.bus;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;

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
		setLayout(new MigLayout("", "[112px][112px][112px,grow][112px,grow][112px,grow]", "[150px][150px,grow]"));
		
		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLinje.setForeground(new Color(0, 0, 0));
		lblLinje.setVerticalAlignment(SwingConstants.TOP);
		add(lblLinje, "flowx,cell 0 0,alignx center,aligny top");

		JLabel lblNewLabel = new JLabel("L\u00E4ge");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		add(lblNewLabel, "cell 3 0,alignx center,growy");

		JLabel lblAvgr = new JLabel("Avg\u00E5ng");
		lblAvgr.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAvgr.setForeground(new Color(0, 0, 0));
		lblAvgr.setVerticalAlignment(SwingConstants.TOP);
		add(lblAvgr, "cell 4 0,grow");

		Line = new JTextArea();
		Line.setRows(2);
		Line.setBackground(Color.LIGHT_GRAY);
		Line.setAutoscrolls(false);
		Line.setFont(new Font("Tahoma", Font.BOLD, 14));
		Line.setEditable(false);
		add(Line, "flowx,cell 0 1,alignx center,growy");

		Destination = new JTextArea();
		Destination.setEditable(false);
		Destination.setBackground(Color.LIGHT_GRAY);
		Destination.setFont(new Font("Tahoma", Font.BOLD, 14));
		Destination.setRows(2);
		Destination.setAutoscrolls(false);
		add(Destination, "cell 1 1 2 1,grow");

		Stop = new JTextArea();
		Stop.setEditable(false);
		Stop.setBackground(Color.LIGHT_GRAY);
		Stop.setFont(new Font("Tahoma", Font.BOLD, 14));
		Stop.setRows(2);
		Stop.setAutoscrolls(false);
		add(Stop, "cell 3 1,alignx center,growy");

		Departure = new JTextArea();
		Departure.setEditable(false);
		Departure.setBackground(Color.LIGHT_GRAY);
		Departure.setFont(new Font("Tahoma", Font.BOLD, 14));
		Departure.setRows(2);
		Departure.setForeground(new Color(0, 0, 0));
		Departure.setAutoscrolls(false);
		add(Departure, "cell 4 1,alignx center,growy");

		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDestination.setForeground(new Color(0, 0, 0));
		lblDestination.setVerticalAlignment(SwingConstants.TOP);
		add(lblDestination, "cell 1 0 2 1,grow");
	}

	public class LineThread extends Thread{
		private Parser parser;
		private ArrayList<Station> searchStations = new ArrayList<Station>();

		public LineThread(Parser parser) {
			this.parser = parser;
		}

		public void run() {
			Lines lines = Parser.getStationResults(new Station("80046"));
			int results = 0;
			// �r det inte b�ttre att anv�nda String.format %02d ist? 
			for (Line l : lines.getLines()) {
				results++;
				
				Calendar cal = Calendar.getInstance();

				int H1 = cal.get(Calendar.HOUR);
				int M1 = cal.get(Calendar.MINUTE);
				int H = l.getDepTime().get(Calendar.HOUR_OF_DAY );
				int M = l.getDepTime().get(Calendar.MINUTE );

				long difference = H - H1;	
				long difference1 = M - M1;

				if (difference1 < 0) {
					difference1 =  M1;
				}

				if (difference <= 0) {
					System.out.println("Den h�r bussen gick f�r " + (-difference-difference) + " minuter sedan");
				} else {
					Line.append(l.getLine() + "\n");
					Destination.append(l.getTowards()+"\n");
					Stop.append(l.getStopPoint() + "\n");
					Departure.append(String.format("%02d", difference) +":" + String.format("%02d", difference1) + "\n");
					System.out.println("En buss kommer om " + difference + " minuter");
				}
				if (results == 4) {
					break;
				}
			}
		}
	}

	////				String minutes = "";
	////				
	////				if (String.valueOf(l.getDepTime().get(Calendar.MINUTE)).length() == 1) {
	////					minutes = "0" + String.valueOf(l.getDepTime().get(Calendar.MINUTE));
	////				} else {
	////					minutes = String.valueOf(l.getDepTime().get(Calendar.MINUTE));
	////				}
	//				
	//				Line.append(l.getLine() + "\n");
	//				Destination.setText(l.getTowards() + "\n");
	////				if (Parser.hours == false) {
	////				Departure.append(l.getTimeToDeparture() + " min \n");
	////				} else {
	//					Departure.setText(String.valueOf(l.getDepTime().get(Calendar.HOUR_OF_DAY)+":"+l.getDepTime().get(Calendar.MINUTE)));
	//					Departure.setText("\n");
	////				}
	//			}		
	//		}
	//	}

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