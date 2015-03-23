package timeweather;


import java.util.ArrayList;
import java.util.Calendar;
/**

 */
public class Weather {
	private ArrayList<String> temperatureList;
	private ArrayList<String> weatherList;
	private ArrayList<String> timeList;
	private String iconPathway;
	
	
	public Weather() {
		
	}


	public ArrayList<String> getTemperature() {
		return temperatureList;
	}


	public void setTemperature(ArrayList<String> temperatureList) {
		this.temperatureList = temperatureList;
	}


	public ArrayList<String> getWeather() {
		return weatherList;
	}


	public void setWeather(ArrayList<String> weatherList) {
		this.weatherList = weatherList;
	}


	public ArrayList<String> getTimeList() {
		return timeList;
	}


	public void setTimeList(ArrayList<String> timeList) {
		this.timeList = timeList;
	}
	
	//Axel - här är metoden där man kopplar vädertypen med en vädericon. Lägg till else if påstående för varje vädertyp och sen setIconPathway med rätt bild. 
	//Den anropas i WeatherThread. Hör av dig till mig om du har frågor /Lars
	
	public void setWeatherIcon(String weatherCondition){
		if(weatherCondition.equals("broken clouds")){
			setIconPathway("/timeweather/images/weatherIconTest2.png");
			}
		else if(weatherCondition.equals("sky is clear")){
			setIconPathway("/timeweather/images/weatherIconTest.png");
		}else{
			setIconPathway("/timeweather/images/weatherIconError.png");
		}
		
	}
	


	public String getIconPathway() {
		return iconPathway;
	}


	public void setIconPathway(String iconPathway) {
		this.iconPathway = iconPathway;
	}

	
}
