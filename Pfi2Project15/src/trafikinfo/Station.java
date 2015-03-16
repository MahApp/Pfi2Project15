package trafikinfo;

/**
 * Contains all information for an individual station 
 * @author K3LARA
 *
 */
public class Station implements Comparable<Station>{
	private String stationNbr;
	private String stationName;
	private double latitude; //X coordinate, RT90
	private double longitude; //Y coordinate, RT90
	
	public Station(String stationName,String stationNbr) {
		this.stationName = stationName;
		this.stationNbr=stationNbr;
	}
	public Station(String stationName,String stationNbr, String latitude, String longitude) {
		this.stationName = stationName;
		this.stationNbr=stationNbr;
		try {
			this.latitude = Double.parseDouble(latitude);
			this.longitude = Double.parseDouble(longitude);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getStationNbr() {
		return stationNbr;
	}
	public String getStationName() {
		return stationName;
	}
	@Override
	public String toString() {
		return stationName;
	}
	
	 @Override
	public boolean equals(Object o) {
		 boolean b = false;
		 Station s = (Station)o;
		 if (this.stationNbr.equals(s.stationNbr)){
			 b = true;
		 }
		 return b;
	}
	 
	 
	 @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.stationNbr.hashCode();
	}
	 
	public int compareTo(Station another) {
		int res = 0;
		if(this.stationName != null && another.stationName != null){
			   res = this.stationName.compareToIgnoreCase(another.stationName);
	    }
		return res;
	}
}