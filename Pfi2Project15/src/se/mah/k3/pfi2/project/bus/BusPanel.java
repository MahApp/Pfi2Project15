package se.mah.k3.pfi2.project.bus;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class BusPanel extends JPanel implements ModuleInterface{
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public BusPanel() {
		setBackground(Color.PINK);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Bus");
		add(lblNewLabel, BorderLayout.NORTH);
		
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
