package trafikinfo;

import javax.swing.JPanel;

// import se.mah.k3.pfi2.project.main.controller.ModuleInterface;


import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.SwingConstants;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.Component;

public class TrafficInfo extends JPanel implements ModuleInterface  {
	JFrame jf = new JFrame();
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrafficInfo frame = new TrafficInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the panel.
	 */
	public TrafficInfo() {
		setBounds(new Rectangle(0, 0, 1080, 80));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRAFIKST\u00D6RNING:");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setDisplayedMnemonicIndex(0);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Futura Std Heavy", Font.PLAIN, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 290, 46);
		add(lblNewLabel);
		
		JLabel left310 = new JLabel("New label");
		left310.setIcon(new ImageIcon(TrafficInfo.class.getResource("/resources/left_part_310x80.PNG")));
		left310.setBounds(0, 0, 310, 80);
		add(left310);
		
		JLabel middle580 = new JLabel("New label");
		middle580.setIcon(new ImageIcon(TrafficInfo.class.getResource("/resources/middle_part_580x80.PNG")));
		middle580.setBounds(310, 0, 580, 80);
		add(middle580);
		
		JLabel right190 = new JLabel("New label");
		right190.setInheritsPopupMenu(false);
		right190.setIcon(new ImageIcon(TrafficInfo.class.getResource("/resources/right_part_190x80.PNG")));
		right190.setBounds(890, 0, 190, 80);
		add(right190);

	}

	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 1;
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
