package se.mah.k3.pfi2.project.social;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class SocialPanelBanner extends JPanel implements ModuleInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3423872452110760623L;
	private long updateInterval = 5000; //Tidsintervall mellan banner-bild-byte, i millisekunder.
	private ImageIcon hashtagBannerImg = new ImageIcon(SocialPanelBanner.class.getResource("/se/mah/k3/pfi2/project/social/graphics/LowPriorityHashtagBanner.png"));
	private ImageIcon atBannerImg = new ImageIcon(SocialPanelBanner.class.getResource("/se/mah/k3/pfi2/project/social/graphics/LowPriorityAtBanner.png"));
	private ImageIcon currentImage;
	private JLabel imageLabel;
	/**
	 * Create the panel.
	 */
	public SocialPanelBanner() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(1080,160));
		setMinimumSize(new Dimension(1080,160));
		
		currentImage = hashtagBannerImg; //Sätter den ena bilden som default startbild
		
		imageLabel = new JLabel();
		imageLabel.setIcon(currentImage);
		add(imageLabel, BorderLayout.CENTER);
		
		Thread thread = new SocialPanelBanner.BannerThread();
		thread.setName("SocialPanelBanner");
		thread.start();

	}

	public class BannerThread extends Thread {
		Boolean state = false;
		public void run() {			
			try {
				while (true) {
					Thread.sleep(updateInterval);
					if(state){ 
						imageLabel.setIcon(hashtagBannerImg);
						System.out.println("BannerThread: Tick");
					}
					else{
						imageLabel.setIcon(atBannerImg);
						System.out.println("BannerThread: Tock");
					}
					imageLabel.repaint();
					state = !state;
					
				}
			} catch (Exception ex) {}
			start();
		}
	}

	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 0;
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
