package se.mah.k3.pfi2.project.kronox;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
<<<<<<< HEAD

import java.awt.Color;
import javax.swing.JLabel;

public class KronoxPanel extends JPanel implements ModuleInterface{

	/**
	 * Create the panel.
	 */
	public KronoxPanel() {
		setBackground(Color.GREEN);
		
		JLabel lblKronox = new JLabel("Kronox");
		add(lblKronox);

	}
=======
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
	
	/**
	 * Create the panel.
	 */
	public KronoxPanel() {
		
	}
	
>>>>>>> refs/heads/GruppManne

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
