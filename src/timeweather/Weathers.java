package timeweather;

import java.util.ArrayList;

public class Weathers {
	private ArrayList<Weather> weathers;
	
	//Creates a list of weather conditions
	public Weathers() {
		// TODO Auto-generated constructor stub
		weathers = new ArrayList<Weather>();
	}
	
	public void addWeather(Weather weather) {
		this.weathers.add(weather);
	}
	
	public ArrayList<Weather> getWeathers() {
		return weathers;
	}
}