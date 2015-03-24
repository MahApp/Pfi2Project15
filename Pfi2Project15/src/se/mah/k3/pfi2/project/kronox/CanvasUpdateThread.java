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
	FilterOutRooms filteredStrings = new FilterOutRooms();
	
	ArrayList<Post> canvasPost = new ArrayList<Post>();
	ArrayList<Post> filteredPosts = new ArrayList<Post>();
	
	public CanvasInJframe demo = new CanvasInJframe();
	
	
	private int refreshRate = 100;
	private boolean running = true;

	public CanvasUpdateThread(CanvasInJframe demo) {
		super();
		this.demo = demo;
		//System.out.println("hej");
		addToList();
		
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
		//addera ofiltrerade till en variabel
		canvasPost = parserClass.getPost();
		//filtrera dem i FilterOutRooms
		filteredPosts = filteredStrings.filter(canvasPost);
		
		//Ladda in Antal Element på skärmen
		setElementIGUI();
		//Ladda in dem i GUIn
		demo.loadData(filteredPosts);

	}
	private void setElementIGUI(){
		
		//Här ändrar vi från tid till tid då.
		
		//demo.setAntalElement(filteredPosts.size());
		demo.setAntalElement(filteredPosts.size());
	}

}
