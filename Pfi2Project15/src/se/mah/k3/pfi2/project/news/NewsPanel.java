package se.mah.k3.pfi2.project.news;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;
import javax.swing.JLabel;

public class NewsPanel extends JPanel implements ModuleInterface{

	/**
	 * Create the panel.
	 */
	public NewsPanel() {
		setBackground(Color.BLUE);
		
		JLabel lblNews = new JLabel("News");
		add(lblNews);

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

	@Override
	public void sendMessage(String s) {
		// TODO Auto-generated method stub
		
	}

}
