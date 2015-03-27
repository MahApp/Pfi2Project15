package se.mah.k3.pfi2.project.kronox;

import java.awt.Canvas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class KronoxAnimationThread extends Thread {
	    /**
		 * 
		 * 
		 *   
		 * 
		 * 
		 **/
	KronoxPanel kronoxPanel;
	final int parserRefreshInterval=40;
	private int refreshRate= parserRefreshInterval * 1000;
	ArrayList<Post> canvasPost = new ArrayList<Post>();
	ArrayList<Post> filteredPosts = new ArrayList<Post>();

	private volatile boolean running = true;
	boolean animate;
	
	public KronoxAnimationThread(KronoxPanel KronoxPanel) {
		super();
		this.kronoxPanel=kronoxPanel;
		System.out.println("animator");

	}

	public void run() {
		System.out.println("begin animate!!!");
		while (running && animate) {
			System.out.println("animating ^_^");

			try {
				update();
				Thread.sleep(refreshRate);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	

	public void update(){
		for(Post p:Parser.storedPost){
		
		
		}
	}

}
