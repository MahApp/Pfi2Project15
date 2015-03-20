package se.mah.k3.pfi2.project.kronox;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import timeweather.DateLogic;
import timeweather.TimeLogic;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;


public class KronoxPanel extends JPanel implements ModuleInterface{
	private JLabel lblTime;
	private JLabel lblDate;
	private JLabel lblBuilding;
	//private TimeLogic timeLogic = new TimeLogic(this);
	//private DateLogic dateLogic = new DateLogic(this);
	private JLabel label;
	/**
	 * Create the panel.
	 */
	public KronoxPanel() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 4, 0, 0));
		
		lblTime = new JLabel("Time");
		lblTime.setVerticalAlignment(SwingConstants.BOTTOM);
		add(lblTime);
		lblTime.setForeground(new Color(193, 0, 43));
		lblTime.setFont(new Font("Futura", Font.PLAIN, 20));
		
		lblDate = new JLabel("Date");
		lblDate.setVerticalAlignment(SwingConstants.BOTTOM);
		add(lblDate);
		lblDate.setForeground(new Color(193, 0, 43));
		lblDate.setFont(new Font("Futura", Font.PLAIN, 13));
		
		lblBuilding = new JLabel("Kranen");
		lblBuilding.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuilding.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBuilding.setForeground(new Color(193, 0, 43));
		lblBuilding.setFont(new Font("Futura", Font.PLAIN, 20));
		add(lblBuilding);
		
		label = new JLabel("");
		add(label);

	}
	
	public void showTime(String timeIn) {
		lblTime.setText(timeIn + "   ");
	}
	public void showDate(String dateIn) {
		lblDate.setText(dateIn + "   ");
	}
	public void showBuildingName(String buildingIn){
		lblBuilding.setText(buildingIn);
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
