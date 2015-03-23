package se.mah.k3.pfi2.project.timeweather;

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

	/*tror jag fick rätt på det hela.
	Vi har ingen ikon för "few clouds" som är stor, använder istället samma som för "clouds" dvs. clouds_big.png om vi verkligen vill kan vi fixa detta.
	En ram måste också läggas till som ska ligga över alla väderbilderna, jag har skapat ramen och laddat upp här i projektet(ligger i timeweather.images. /Axel
	*/

	public void setWeatherIcon(String weatherCondition) {
		if (weatherCondition.equals("broken clouds")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/clouds_small.png");
		} else if (weatherCondition.equals("sky is clear")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/clear_sky_small.png");
		} else if (weatherCondition.equals("scattered clouds")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/clouds_small.png");
		} else if (weatherCondition.equals("few clouds")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/few_clouds_small.png");
		} else if (weatherCondition.equals("mist")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/mist_small.png");
		} else if (weatherCondition.equals("rain")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/rain_small.png");
		} else if (weatherCondition.equals("light rain")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/rain_small.png");
		} else if (weatherCondition.equals("snow")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/snow_small.png");
		} else if (weatherCondition.equals("thunderstorm")) {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/thunderstorm_small.png");
		} else {
			setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/weatherIconError.png");
		}

	}

	public void setWeatherPic(String weatherCondition) {
		if (true) {
			if (weatherCondition.equals("broken clouds")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/broken_clouds_big.png");
			} else if (weatherCondition.equals("sky is clear")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/clear_sky_big.png");
			} else if (weatherCondition.equals("scattered clouds")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/scattered_clouds_big.png");
			} else if (weatherCondition.equals("few clouds")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/clouds_big.png");
			} else if (weatherCondition.equals("mist")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/mist_big.png");
			} else if (weatherCondition.equals("rain")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/rain_big.png");
			} else if (weatherCondition.equals("light rain")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/shower_rain_big.png");
			} else if (weatherCondition.equals("snow")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/snow_big.png");
			} else if (weatherCondition.equals("thunderstorm")) {
				setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/thunderstorm_big.png");

				// setIconPathway("/se/mah/k3/pfi2/project/timeweather/images/testWide.png");
			}
		}
	}

	public String getIconPathway() {
		return iconPathway;
	}

	public void setIconPathway(String iconPathway) {
		this.iconPathway = iconPathway;
	}

}
