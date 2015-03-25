package se.mah.k3.pfi2.project.timeweather;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.border.LineBorder;

public class WeatherPanelBig extends JPanel implements ModuleInterface{
	private JPanel contentPane;
	
	//Prints out temperature, current and prognosis, in degrees Celsius
	public JLabel lblTemperature = new JLabel("Temperature");
	public JLabel lblTemperature2  = new JLabel("Temperature");
	public JLabel lblTemperature3 = new JLabel("Temperature");
	public JLabel lblTemperature4 = new JLabel("Temperature");
	
	//Label that prints "Nu" for the current weather
	private JLabel lblNu = new JLabel("Nu");
	//Labels that print the time period for each prognosis
	public JLabel lblTime2 = new JLabel("Time");
	public JLabel lblTime3 = new JLabel("Time");
	public JLabel lblTime4  = new JLabel("Time");
	
	//labels that print the weather condition for each prognosis, just for tests
	public JLabel lblWeatherConditions = new JLabel("WeatherConditions");
	public JLabel lblWeatherConditions2  = new JLabel("WeatherConditions");
	public JLabel lblWeatherConditions3 = new JLabel("WeatherConditions");
	public JLabel lblWeatherConditions4 = new JLabel("WeatherConditions");
	
	//labels that show weather pictures that correspond with the weather condition
	public JLabel lblWeatherPic1  = new JLabel("weather pic");
	public JLabel lblWeatherPic2 = new JLabel("weather pic");
	public JLabel lblWeatherPic3 = new JLabel("weather pic");
	public JLabel lblWeatherPic4 = new JLabel("weather pic");
	
	 private JPanel panel_1 = new JPanel();
	 

		/*builds a weatherpanel with the current weather and three prognosis ahead
		  width 1080, height 320 (4 rows)
		  bigger, higher priority panel
		  */
	
	public WeatherPanelBig(){
		WeatherThreadBig weatherThread = new WeatherThreadBig(WeatherPanelBig.this);
		weatherThread.setName("WeatherThreadBig");
		weatherThread.start();
		
		setMinimumSize(new Dimension(1080, 320));
		
		
		setPreferredSize(new Dimension(1080, 320));
		setMaximumSize(new Dimension(1080, 320));
		setLayout(null);
		
		JLabel lblBorderBig = new JLabel("border");
		lblBorderBig.setIcon(new ImageIcon(WeatherPanelBig.class.getResource("/se/mah/k3/pfi2/project/timeweather/images/ramStor.png")));
		lblBorderBig.setBounds(0, 0, 1080, 320);
		add(lblBorderBig);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(0, 0, 1080, 160);
		add(panel);
		panel.setLayout(null);
		
		
		lblTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature.setFont(new Font("Futura", Font.PLAIN, 48));
		lblTemperature.setBounds(101, 37, 100, 100);
		panel.add(lblTemperature);
		
		
		lblNu.setFont(new Font("Futura", Font.PLAIN, 30));
		lblNu.setBounds(6, 6, 1068, 40);
		panel.add(lblNu);
		
		/*
		 * Just for tests
		lblWeatherConditions.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions.setFont(new Font("Futura", Font.PLAIN, 24));
		lblWeatherConditions.setBounds(239, 127, 348, 27);
		panel.add(lblWeatherConditions);
		*/
		
		lblWeatherPic1.setBounds(0, 0, 1080, 160);
		panel.add(lblWeatherPic1);
		
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(0, 160, 360, 160);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblTime2.setBounds(6, 6, 130, 40);
		lblTime2.setFont(new Font("Futura", Font.PLAIN, 30));
		panel_1.add(lblTime2);
		
		lblTemperature2.setBounds(148, 40, 120, 80);
		lblTemperature2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature2.setFont(new Font("Futura", Font.PLAIN, 48));
		panel_1.add(lblTemperature2);
		
		/*
		lblWeatherConditions2.setBounds(6, 132, 348, 27);
		lblWeatherConditions2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions2.setFont(new Font("Futura", Font.PLAIN, 24));
		panel_1.add(lblWeatherConditions2);
		*/
		
		lblWeatherPic2.setBounds(0, 0, 360, 160);
		panel_1.add(lblWeatherPic2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBounds(360, 160, 360, 160);
		add(panel_2);
		panel_2.setLayout(null);
		
		/*
		lblWeatherConditions3.setBounds(6, 132, 348, 27);
		lblWeatherConditions3.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions3.setFont(new Font("Futura", Font.PLAIN, 24));
		panel_2.add(lblWeatherConditions3);
		*/
		
		lblTemperature3.setBounds(148, 40, 120, 80);
		lblTemperature3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature3.setFont(new Font("Futura", Font.PLAIN, 48));
		panel_2.add(lblTemperature3);
		
		
		lblTime3.setBounds(6, 6, 130, 40);
		lblTime3.setFont(new Font("Futura", Font.PLAIN, 30));
		panel_2.add(lblTime3);
		
		 
		lblWeatherPic3.setBounds(0, 0, 360, 160);
		panel_2.add(lblWeatherPic3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_3.setBounds(720, 160, 360, 160);
		add(panel_3);
		
		/*
		lblWeatherConditions4.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions4.setFont(new Font("Futura", Font.PLAIN, 24));
		lblWeatherConditions4.setBounds(6, 132, 348, 27);
		panel_3.add(lblWeatherConditions4);
		*/
		
		lblTemperature4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature4.setFont(new Font("Futura", Font.PLAIN, 48));
		lblTemperature4.setBounds(148, 40, 120, 80);
		panel_3.add(lblTemperature4);
		
		
		lblTime4.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime4.setBounds(6, 6, 130, 40);
		panel_3.add(lblTime4);
		
		
		lblWeatherPic4.setBounds(0, 0, 360, 160);
		panel_3.add(lblWeatherPic4);
		
			
	}
	//sets priority to "if space" between 3PM - 5PM, otherwise don't show
	@Override
	public int getExpectedPriority() {
		int priority;
		int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hours >= 15 && hours <= 17){
			priority = 5;
		}else{
			priority = 0;
		}
		return priority;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public boolean showNumberOfRows(int start, int end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void repaintPanel() {
		// TODO Auto-generated method stub
		
	}
}

