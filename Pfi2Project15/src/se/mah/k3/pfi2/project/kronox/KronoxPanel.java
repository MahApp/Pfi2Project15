package se.mah.k3.pfi2.project.kronox;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

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
