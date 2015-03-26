package se.mah.k3.pfi2.project.timeweather;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TimePanel extends JPanel implements ModuleInterface{
	private JLabel lblTime;
	private JLabel lblDate;
	private JLabel lblBuilding;
	//private TimeLogic timeLogic = new TimeLogic(this);
	private DateLogic dateLogic = new DateLogic(this);
	private JLabel lblMahLogo;
	
	/**
	 * Create the panel.
	 */
	public TimePanel() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 4, 0, 0));
		
		lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTime);
		lblTime.setForeground(Color.BLACK);
		lblTime.setFont(new Font("Futura LT Medium", Font.PLAIN, 28));
		
		lblDate = new JLabel("Date");
		add(lblDate);
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Futura LT Medium", Font.PLAIN, 20));
		
		lblBuilding = new JLabel("Kranen");
		lblBuilding.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuilding.setForeground(Color.BLACK);
		lblBuilding.setFont(new Font("Futura LT Medium", Font.PLAIN, 20));
		add(lblBuilding);
		
		lblMahLogo = new JLabel("");
		lblMahLogo.setHorizontalAlignment(SwingConstants.CENTER);
		//lblMahLogo.setIcon(new ImageIcon(TimePanel.class.getResource("/Bilder/mah60.png")));
		//Lars changed to correct path
		lblMahLogo.setIcon(new ImageIcon(TimePanel.class.getResource("/se/mah/k3/pfi2/project/Bilder/mah60.png")));
		add(lblMahLogo);

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
		return 1;
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
