package se.mah.k3.pfi2.project.bus;

import java.util.ArrayList;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class Test {

	public static void main(String[] args) {
		Lines lines = Parser.getStationResults(new Station("80046"));
		for (Line l : lines.getLines()) {
			System.out.println("Line " + l.getLine() + " "+ l.getTowards() +" departs: "+l.getDepTime().get(Calendar.HOUR_OF_DAY)+":"+l.getDepTime().get(Calendar.MINUTE)+
					 " Läge: "+l.getStopPoint()+" and is "+l.getDepTimeDeviation()+" minutes late ");
		}
		// TODO Auto-generated method stub

	}

}
