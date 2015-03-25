package se.mah.k3.pfi2.project.traficinfo.model;

import java.util.ArrayList;

public class Lines {
		private ArrayList<Line> lines;
		private Station station;
		//Perhaps more variables and methods?
		/**Creates a list of departing lines from a station*/
		public Lines(Station station) {
			this.station = station;
			lines = new ArrayList<Line>();
		}
		
		public void addLine(Line line) {
			this.lines.add(line);
		}
		
		@SuppressWarnings("unchecked")
		public ArrayList<Line> getLines() {
			return lines;
		}
		
		public void clearJourneys() {
			this.lines.clear();
		}
}
