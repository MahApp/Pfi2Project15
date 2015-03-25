package se.mah.k3.pfi2.project.social;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class SocialPanel extends JPanel implements ModuleInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5619243716297221701L;

	
	private int updateInterval = 60000;

	/**
	 * Create the panel.
	 */
	public SocialPanel() {

		setBorder(new EmptyBorder(10, 0, 10, 0));
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		Thread thread = new InstagramThread(this, updateInterval);
		thread.setName("Get Instagram data");
		thread.start();

	}

	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 7;
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
