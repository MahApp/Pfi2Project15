package se.mah.k3.pfi2.project.traficinfo.view;

// Ready for merge.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

public class TrafficInfo extends JPanel implements ModuleInterface{

	
	TrafficInfo g = this;

	// Made everything add gui-effects in a module instead.
	
	/**
	 * Create the panel.
	 */
	public TrafficInfo() {
		
		setPreferredSize(new Dimension(1080,160));
		setMinimumSize(new Dimension(1080,160));
		setBackground(new Color(193,0,43));
		setLayout(null);
		

		JLabel right190 = new JLabel("New label");
		right190.setBounds(0, 0, 1080, 160);
		right190.setInheritsPopupMenu(false);
		right190.setIcon(new ImageIcon(TrafficInfo.class.getResource("/resources/warningsign.png")));
		add(right190);
		
		Thread tx = new gThread(g);
		tx.start();	
		
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
