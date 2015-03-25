package se.mah.k3.pfi2.project.social;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SocialPanel extends JPanel implements ModuleInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5619243716297221701L;

	
	private int updateInterval = 15000;
	public JPanel panelContent;
	public JPanel panelBorder;

	/**
	 * Create the panel.
	 */
	public SocialPanel() {
		
		setBorder(new EmptyBorder(10, 0, 10, 0));
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));
		setLayout(null);
		
//		panelBorder = new JPanel();
//		panelBorder.setBounds(0, 0, 1080, 560);
//		panelBorder.setOpaque(false);
//		//add(panelBorder);
//		panelBorder.setLayout(new BorderLayout(0, 0));
//		
//		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(new Color(255, 255, 255), 10, true));
//		panel.setBackground( new Color(0, 0, 0, 0) );
//		panelBorder.add(panel, BorderLayout.CENTER);
		
		
		panelContent = new JPanel();
		panelContent.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelContent.setBounds(0, 0, 1080, 560);
		add(panelContent);
		panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.X_AXIS));
		
		Thread thread = new InstagramThread(this, updateInterval);
		thread.setName("Get Instagram data");
		thread.start();

	}
	
	public void addBorder(){
		panelBorder = new JPanel();
		panelBorder.setBounds(0, 0, 1080, 560);
		panelBorder.setOpaque(false);
		add(panelBorder);
		panelBorder.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 10, true));
		panel.setBackground( new Color(0, 0, 0, 0) );
		panelBorder.add(panel, BorderLayout.CENTER);
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
