package se.mah.k3.pfi2.project.timeweather;

import java.util.Calendar;

import javax.swing.ImageIcon;




public class WeatherThreadBig extends Thread {
	
	private WeatherPanelBig gui;
	private boolean running = true;
	

	public WeatherThreadBig(WeatherPanelBig gui) {
		this.gui = gui;
		// TODO Auto-generated constructor stub
	}

	public void run(){
		while (running == true){
			try{
				weatherUpdate();
				Thread.sleep(10*60*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			
		}
		
	}
private void weatherUpdate(){
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
		
		gui.lblTime4.setText(weather.getTimeList().get(3));
		gui.lblTemperature4.setText(weather.getTemperature().get(3)+ "°");
		gui.lblWeatherConditions4.setText(weather.getWeather().get(3));
		
		weather.setWeatherIcon(weather.getWeather().get(0));
		gui.lblWeatherPic1.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
		
		weather.setWeatherIcon(weather.getWeather().get(1));
		gui.lblWeatherPic2.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
		
		weather.setWeatherIcon(weather.getWeather().get(2));
		gui.lblWeatherPic3.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
	}
		
}
}