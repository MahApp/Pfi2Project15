package se.mah.k3.pfi2.project.bus;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
//import se.mah.k3lara.skaneAPI.view.TestClassGUI;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

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
	public JTextArea Departure;
	 

	/**
	 * Create the panel.
	 */
	public BusPanel() {
		Thread lineThread = new BusPanel.LineThread(parser);
lineThread.start();
		
		setBackground(Color.LIGHT_GRAY);
				setLayout(new GridLayout(0, 4, 0, 0));
				
				JLabel lblLinje = new JLabel("Linje");
				lblLinje.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblLinje.setForeground(Color.BLACK);
				lblLinje.setVerticalAlignment(SwingConstants.TOP);
				add(lblLinje);
				
				JLabel lblDestination = new JLabel("Destination");
				lblDestination.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblDestination.setForeground(Color.BLACK);
				lblDestination.setVerticalAlignment(SwingConstants.TOP);
				add(lblDestination);
				
				JLabel lblNewLabel = new JLabel("L\u00E4ge");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel.setForeground(Color.BLACK);
				lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
				add(lblNewLabel);
				
				JLabel lblAvgr = new JLabel("Avg\u00E5r");
				lblAvgr.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblAvgr.setForeground(Color.BLACK);
				lblAvgr.setVerticalAlignment(SwingConstants.TOP);
				add(lblAvgr);
	
				
				Line = new JTextArea();
				Line.setEditable(false);
				Line.setRows(5);
				add(Line);
				
				Destination = new JTextArea();
				Destination.setEditable(false);
				Destination.setRows(5);
				add(Destination);
				
				Departure = new JTextArea();
				Departure.setEditable(false);
				Departure.setRows(5);
				add(Departure);

				
				Stop = new JTextArea();
				Stop.setEditable(false);
				Stop.setRows(5);
				add(Stop);
	

	}
	
	

	public class LineThread extends Thread{
		private Parser parser;
		private ArrayList<Station> searchStations = new ArrayList<Station>();

		public LineThread(Parser parser) {
			this.parser = parser;
		}

		public void run() {
			Lines lines = Parser.getStationResults(new Station("80046"));
		
			// �r det inte b�ttre att anv�nda String.format %02d ist? 
			for (Line l : lines.getLines()) {
				Line.append("        " +l.getLine() + "\n");
				Destination.append("    " +  l.getTowards()+"\n");
				
				
				Calendar cal = Calendar.getInstance();
				
					
					int H1 = cal.get(Calendar.HOUR);
					int M1 = cal.get(Calendar.MINUTE);
					int H = l.getDepTime().get(Calendar.HOUR_OF_DAY );
					int M = l.getDepTime().get(Calendar.MINUTE );
					
					long difference = H - H1;	
					long difference1 = M - M1;
					
					System.out.println(difference + "jajajajajajaj");
					
					Departure.append(String.format("%02d", difference) +":" + String.format("%02d", difference1) + "\n");
					Stop.append(l.getStopPoint() + "\n");
			}}}

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
		return 5;
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