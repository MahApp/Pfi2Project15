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

public class WeatherPanel extends JPanel implements ModuleInterface{
	private JPanel contentPane;
	
	//label that shows the temperature in degrees Celsius
	public JLabel lblTemperature;
	public JLabel lblTemperature2;
	public JLabel lblTemperature3;
	
	//label that prints the weather condition, just for tests
	public JLabel lblWeatherConditions;
	public JLabel lblWeatherConditions2;
	public JLabel lblWeatherConditions3;
	
	//label that prints the time period for the prognosis
	public JLabel lblTime2;
	public JLabel lblTime3;
	
	//label that shows the right weather picture that corresponds to the weather condition
	public JLabel lblWeatherIcon1;
	public JLabel lblWeatherIcon2;
	public JLabel lblWeatherIcon3;
	
	//shows a black border around each element
	private JLabel lblBorderSmall;
	
	
	/*builds a weatherpanel with the current weather and prognosis three and six hours ahead
	 * width 1080, height 160
	 * smaller, lower priority panel
	 */
	public WeatherPanel(){
		WeatherThread weatherThread = new WeatherThread(WeatherPanel.this);
		weatherThread.setName("WeatherThread");
		weatherThread.start();
		
		setMinimumSize(new Dimension(1080, 160));
		
		
		setPreferredSize(new Dimension(1080, 160));
		setMaximumSize(new Dimension(1080, 160));
		setLayout(null);
		
		lblBorderSmall = new JLabel("border");
		lblBorderSmall.setIcon(new ImageIcon(WeatherPanel.class.getResource("/se/mah/k3/pfi2/project/timeweather/images/ramLiten.png")));
		lblBorderSmall.setBounds(0, 0, 1080, 160);
		add(lblBorderSmall);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(0, 0, 360, 160);
		add(panel);
		panel.setLayout(null);
		
		lblTemperature = new JLabel("Temperature");
		lblTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature.setFont(new Font("Futura", Font.PLAIN, 48));
		lblTemperature.setBounds(144, 43, 100, 80);
		panel.add(lblTemperature);
		
		/*
		 * commented out, just for tests
		lblWeatherConditions = new JLabel("WeatherConditions");
		lblWeatherConditions.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions.setFont(new Font("Futura", Font.PLAIN, 24));
		lblWeatherConditions.setBounds(6, 132, 348, 27);
		panel.add(lblWeatherConditions);
		*/
		
		JLabel lblNu = new JLabel("Nu");
		lblNu.setFont(new Font("Futura", Font.PLAIN, 30));
		lblNu.setBounds(26, 16, 110, 30);
		panel.add(lblNu);
		
		lblWeatherIcon1 = new JLabel("weather icon");
		lblWeatherIcon1.setIcon(new ImageIcon(WeatherPanel.class.getResource("/se/mah/k3/pfi2/project/timeweather/images/weatherIconTest2.png")));
		lblWeatherIcon1.setBounds(0, 0, 360, 160);
		panel.add(lblWeatherIcon1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(360, 0, 360, 160);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblTime2 = new JLabel("Time");
		lblTime2.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime2.setBounds(6, 6, 130, 40);
		panel_1.add(lblTime2);
		
		lblTemperature2 = new JLabel("Temperature");
		lblTemperature2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature2.setFont(new Font("Futura", Font.PLAIN, 48));
		lblTemperature2.setBounds(145, 42, 100, 80);
		panel_1.add(lblTemperature2);
		
		/*
		lblWeatherConditions2 = new JLabel("WeatherConditions");
		lblWeatherConditions2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions2.setFont(new Font("Futura", Font.PLAIN, 24));
		lblWeatherConditions2.setBounds(6, 132, 348, 27);
		panel_1.add(lblWeatherConditions2);
		*/
		
		lblWeatherIcon2 = new JLabel("weather icon");
		lblWeatherIcon2.setBounds(0, 0, 360, 160);
		panel_1.add(lblWeatherIcon2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBounds(720, 0, 360, 160);
		add(panel_2);
		panel_2.setLayout(null);
		
		/*
		lblWeatherConditions3 = new JLabel("WeatherConditions");
		lblWeatherConditions3.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions3.setFont(new Font("Futura", Font.PLAIN, 24));
		lblWeatherConditions3.setBounds(6, 132, 348, 27);
		panel_2.add(lblWeatherConditions3);
		*/
		
		lblTemperature3 = new JLabel("Temperature");
		lblTemperature3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature3.setFont(new Font("Futura", Font.PLAIN, 48));
		lblTemperature3.setBounds(148, 44, 100, 80);
		panel_2.add(lblTemperature3);
		
		lblTime3 = new JLabel("Time");
		lblTime3.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime3.setBounds(6, 6, 130, 40);
		panel_2.add(lblTime3);
		
		lblWeatherIcon3 = new JLabel("weather icon");
		lblWeatherIcon3.setBounds(0, 0, 360, 160);
		panel_2.add(lblWeatherIcon3);
		
		
		
	}

	@Override
	public int getExpectedPriority() {
		int priority;
		int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hours < 15){
			priority = 5;
		}
		else{
			priority = 0;
		}
		// TODO Auto-generated method stub
		return priority;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 2;
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

