package se.mah.k3.pfi2.project.timeweather;

import java.util.Calendar;

import javax.swing.ImageIcon;




public class WeatherThreadBig extends Thread {
	
	private WeatherPanelBig gui;
	private boolean running = true;
	

	/**
	 * @wbp.parser.entryPoint
	 */
	public WeatherThreadBig(WeatherPanelBig gui) {
		this.gui = gui;
		// TODO Auto-generated constructor stub
	}

	public void run(){
		while (running == true){
			try{
				weatherUpdate();
				//updates every ten minutes
				Thread.sleep(10*60*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			
		}
		
	}
/**
 * @wbp.parser.entryPoint
 */
	//method that updates labels in WeatherPanelBig
private void weatherUpdate(){
	//stores results from XML parsing in ArrayLists
	Weathers weathers = WeatherParser.weatherParserPrognosis();
	
	for (Weather weather : weathers.getWeathers()) {
		
		//now
		gui.lblTemperature.setText(weather.getTemperature().get(0) + "°");
		
		//just for test:
		//gui.lblWeatherConditions.setText(weather.getWeather().get(0));
		
		
		//in three hours
		gui.lblTime2.setText(weather.getTimeList().get(1));
		gui.lblTemperature2.setText(weather.getTemperature().get(1)+ "°");
		//gui.lblWeatherConditions2.setText(weather.getWeather().get(1));
		
		
		//in six hours
		gui.lblTime3.setText(weather.getTimeList().get(2));
		gui.lblTemperature3.setText(weather.getTemperature().get(2)+ "°");
		//gui.lblWeatherConditions3.setText(weather.getWeather().get(2));
		
		//in nine hours
		gui.lblTime4.setText(weather.getTimeList().get(3));
		gui.lblTemperature4.setText(weather.getTemperature().get(3)+ "°");
		//gui.lblWeatherConditions4.setText(weather.getWeather().get(3));
		
		//set big picture with big weather build
		weather.setWeatherPic(weather.getWeather().get(0));
		gui.lblWeatherPic1.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
		
		//set the smaller pics with the prognosis panels
		weather.setWeatherIcon(weather.getWeather().get(1));
		gui.lblWeatherPic2.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
		
		weather.setWeatherIcon(weather.getWeather().get(2));
		gui.lblWeatherPic3.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
		
		weather.setWeatherIcon(weather.getWeather().get(3));
		gui.lblWeatherPic4.setIcon(new ImageIcon(WeatherPanel.class.getResource(weather.getIconPathway())));
	}
		
}
}