package se.mah.k3.pfi2.project.kronox;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3.pfi2.project.timeweather.DateLogic;
//import se.mah.k3.pfi2.project.timeweather.TimeLogic;


import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Dimension;
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
		setMinimumSize(new Dimension(1080, 160));
		setPreferredSize(new Dimension(1080, 160));
		setMaximumSize(new Dimension(1080, 160));
		
		ParserUpdateThread pt= new ParserUpdateThread();
		pt.start();
		
		System.out.println("start program");
		CanvasInJframe frame = new CanvasInJframe();
		CanvasInJframe awtControlDemo = new CanvasInJframe();
		try{
			frame.setVisible(false);
			awtControlDemo.showCanvasDemo();
			awtControlDemo.setVisible(true);
			awtControlDemo.setTitle("loading...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		awtControlDemo.loadData(Parser.getPost());
	}


	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

//	public void setPreferdNumberOfRows(int input) {
//		=input;
//		// TODO Auto-generated method stub
//	
//	}
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
