package se.mah.k3.pfi2.project.idle;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;

public class IdlePanel extends JPanel implements ModuleInterface{

	/**
	 * Create the panel.
	 */
	public IdlePanel() {
		setBackground(Color.PINK);
		
	}

	@Override
	public int getPreferedPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferdHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
