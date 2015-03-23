package se.mah.k3.pfi2.project.main.view;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class FillEmptySpace extends JPanel implements ModuleInterface {
	private JLabel lblNewLabel;
	public FillEmptySpace() {
		lblNewLabel = new JLabel("Info:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNewLabel);
		setInfo();
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
	public void repaint() {
		super.repaint();
		try {
			setInfo();
		} catch (Exception e) {
		}
	}
	public void setInfo() {
		String s;
		int screenWidth = getToolkit().getScreenSize().width;
		int screenHeight = getToolkit().getScreenSize().height;
		s = "ScreenWidth: "+screenWidth +" ScreenHeight: = "+ screenHeight;
		
		int height = lblNewLabel.getHeight();
		//this.setSize(screenWidth, height);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		s = s+ " Screens connected: ";
		for(GraphicsDevice curGs : gs)
		{
		      GraphicsConfiguration[] gc = curGs.getConfigurations();  
		      for(GraphicsConfiguration curGc : gc)
		      {
		            Rectangle bounds = curGc.getBounds();
		            s = s+ "Height: "+  bounds.getWidth() + "Height: " + bounds.getHeight();
		      }
		 }
		lblNewLabel.setText(s);
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
