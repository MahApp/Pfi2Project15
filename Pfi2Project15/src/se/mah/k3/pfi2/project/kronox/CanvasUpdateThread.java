package se.mah.k3.pfi2.project.kronox;

import java.awt.Canvas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class CanvasUpdateThread extends Thread {
	/**
		 * 
		 * 
		 *   
		 * 
		 * 
		
		 * */
	Parser parserClass = new Parser();
	CanvasInJframe canvasClass = new CanvasInJframe();
	
	ArrayList<Post> canvasPost = new ArrayList<Post>();
	public CanvasInJframe demo = new CanvasInJframe();
	private int refreshRate = 100;
	private boolean running = true;

	public CanvasUpdateThread(CanvasInJframe demo) {
		super();
		this.demo = demo;
		//System.out.println("hej");
		addToList();
		canvasPost = parserClass.getPost();
		demo.loadData(canvasPost);

	}

	public void run() {
		System.out.println("hej");
		while (running) {
			System.out.println("hej");
			//demo.updatePost();
			demo.repaint();
			try {
				Thread.sleep(1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	private void addToList(){
	
	}



}
