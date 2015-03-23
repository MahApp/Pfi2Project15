package timeweather;

import java.util.Calendar;

import javax.swing.ImageIcon;




	public class WeatherThread extends Thread {
		
		private WeatherPanel gui;
		//private Weather thisWeather;

		public WeatherThread(WeatherPanel gui) {
			this.gui = gui;
			// TODO Auto-generated constructor stub
		}

		public void run(){
			
			Weathers weathers = WeatherParser.weatherParserPrognosis();
			
			for (Weather weather : weathers.getWeathers()) {
				//nu
				gui.lblTemperature.setText(weather.getTemperature().get(0) + "°");
				gui.lblWeatherConditions.setText(weather.getWeather().get(0));
				//om tre timmar
				gui.lblTime2.setText(weather.getTimeList().get(1));
				gui.lblTemperature2.setText(weather.getTemperature().get(1)+ "°");
				gui.lblWeatherConditions2.setText(weather.getWeather().get(1));
				//om sex timmar
				gui.lblTime3.setText(weather.getTimeList().get(2));
				gui.lblTemperature3.setText(weather.getTemperature().get(2)+ "°");
				gui.lblWeatherConditions3.setText(weather.getWeather().get(2));
				
				weather.setWeatherIcon(weather.getWeather().get(0));
				gui.lblWeatherIcon1.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
				
				weather.setWeatherIcon(weather.getWeather().get(1));
				gui.lblWeatherIcon2.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
				
				weather.setWeatherIcon(weather.getWeather().get(2));
				gui.lblWeatherIcon3.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
				
				//if(weather.getWeather().get(0).equals("broken clouds")){
					//gui.lblWeatherIcon1.setIcon(new ImageIcon(WeatherPanel.class.getResource("/timeweather/images/weatherIconTest.png")));
			
				
				
			}
			//Weather thisWeather = new Weather();
			//gui.lblWeatherIcon1.setIcon(new ImageIcon(WeatherPanel.class.getResource(thisWeather.getIconPathway())));
		}
	}