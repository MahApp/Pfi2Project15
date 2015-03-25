package se.mah.k3.pfi2.project.timeweather;

import java.util.Calendar;

import javax.swing.ImageIcon;




	public class WeatherThread extends Thread {
		
		private WeatherPanel gui;
		private boolean running = true;
		

		public WeatherThread(WeatherPanel gui) {
			this.gui = gui;
			// TODO Auto-generated constructor stub
		}

		public void run(){
			while (running == true){
				try{
					weatherUpdate();
					//update every ten minutes
					Thread.sleep(10*60*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
				
			}
			
		}
		
		//method that updates all the labels in WeatherPanel
	private void weatherUpdate(){
		Weathers weathers = WeatherParser.weatherParserPrognosis();
		
		for (Weather weather : weathers.getWeathers()) {
			//nu
			gui.lblTemperature.setText(weather.getTemperature().get(0) + "°");
			
			//just for tests
			//gui.lblWeatherConditions.setText(weather.getWeather().get(0));
			
			//in three hours
			gui.lblTime2.setText(weather.getTimeList().get(1));
			gui.lblTemperature2.setText(weather.getTemperature().get(1)+ "°");
			
			//gui.lblWeatherConditions2.setText(weather.getWeather().get(1));
			
			//in six hours
			gui.lblTime3.setText(weather.getTimeList().get(2));
			gui.lblTemperature3.setText(weather.getTemperature().get(2)+ "°");
			
			//gui.lblWeatherConditions3.setText(weather.getWeather().get(2));
			
			//sets the correct weather picture for each prognosis
			//now
			weather.setWeatherIcon(weather.getWeather().get(0));
			gui.lblWeatherIcon1.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
			//in three hours
			weather.setWeatherIcon(weather.getWeather().get(1));
			gui.lblWeatherIcon2.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
			//in six hours
			weather.setWeatherIcon(weather.getWeather().get(2));
			gui.lblWeatherIcon3.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
		}
			
	}
	}