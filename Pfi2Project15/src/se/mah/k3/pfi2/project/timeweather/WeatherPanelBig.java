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
import javax.swing.border.LineBorder;

public class WeatherPanelBig extends JPanel implements ModuleInterface{
	private JPanel contentPane;
	public JLabel lblWeatherConditions;
	public JLabel lblTemperature;
	
	public JLabel lblTime2;
	public JLabel lblTemperature2;
	public JLabel lblWeatherConditions2;
	public JLabel lblWeatherConditions3;
	public JLabel lblTemperature3;
	public JLabel lblTime3;
	public JLabel lblWeatherIcon1;
	public JLabel lblWeatherIcon2;
	public JLabel lblWeatherIcon3;
	
	public WeatherPanelBig(){
		WeatherThreadBig weatherThread = new WeatherThreadBig(WeatherPanelBig.this);
		weatherThread.start();
		
		setMinimumSize(new Dimension(1080, 160));
		
		
		setPreferredSize(new Dimension(1080, 160));
		setMaximumSize(new Dimension(1080, 160));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(0, 0, 360, 160);
		add(panel);
		panel.setLayout(null);
		
		lblTemperature = new JLabel("Temperature");
		lblTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature.setFont(new Font("Futura", Font.PLAIN, 48));
		lblTemperature.setBounds(127, 42, 80, 80);
		panel.add(lblTemperature);
		
		lblWeatherConditions = new JLabel("WeatherConditions");
		lblWeatherConditions.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions.setFont(new Font("Futura", Font.PLAIN, 24));
		lblWeatherConditions.setBounds(6, 132, 348, 27);
		panel.add(lblWeatherConditions);
		
		JLabel lblNu = new JLabel("Nu");
		lblNu.setFont(new Font("Futura", Font.PLAIN, 30));
		lblNu.setBounds(6, 6, 130, 40);
		panel.add(lblNu);
		
		lblWeatherIcon1 = new JLabel("weather icon");
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
		lblTemperature2.setBounds(127, 42, 80, 80);
		panel_1.add(lblTemperature2);
		
		lblWeatherConditions2 = new JLabel("WeatherConditions");
		lblWeatherConditions2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions2.setFont(new Font("Futura", Font.PLAIN, 24));
		lblWeatherConditions2.setBounds(6, 132, 348, 27);
		panel_1.add(lblWeatherConditions2);
		
		lblWeatherIcon2 = new JLabel("weather icon");
		lblWeatherIcon2.setBounds(0, 0, 360, 160);
		panel_1.add(lblWeatherIcon2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBounds(720, 0, 360, 160);
		add(panel_2);
		panel_2.setLayout(null);
		
		lblWeatherConditions3 = new JLabel("WeatherConditions");
		lblWeatherConditions3.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeatherConditions3.setFont(new Font("Futura", Font.PLAIN, 24));
		lblWeatherConditions3.setBounds(6, 132, 348, 27);
		panel_2.add(lblWeatherConditions3);
		
		lblTemperature3 = new JLabel("Temperature");
		lblTemperature3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperature3.setFont(new Font("Futura", Font.PLAIN, 48));
		lblTemperature3.setBounds(143, 43, 80, 80);
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
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

