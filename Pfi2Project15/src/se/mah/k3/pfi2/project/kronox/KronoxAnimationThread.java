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
	private KronoxPanel kronoxPanel;
	//final int parserRefreshInterval=500;
	private int refreshRate= 40;
//	ArrayList<Post> canvasPost = new ArrayList<Post>();
//	ArrayList<Post> filteredPosts = new ArrayList<Post>();
	private volatile boolean running = true;
	public boolean animate=false;
	
	public KronoxAnimationThread( ) {
		super();
		System.out.println("animator");

	}
	public KronoxAnimationThread( KronoxPanel kronoxPanel) {
		super();
		this.kronoxPanel=kronoxPanel;
		System.out.println("animator");

	}

	public void run() {
	//	System.out.println("begin animate!!!");
		while (running && animate) {
			//System.out.println("animating ^_^");
			try {
				update(); // postpos
				kronoxPanel.repaint();
				System.out.println("repaint");
				Thread.sleep(refreshRate);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	

	public void update(){
		for(int i=0; i<Parser.storedPost.size() ;i++){
			//p.x+=p.vx;
			Parser.storedPost.get(i).y+=Parser.storedPost.get(i).vy;
			Parser.storedPost.get(i).vy+=Parser.storedPost.get(i).ay;
			Parser.storedPost.get(i).ay*=1.2;
			if(Parser.storedPost.get(i).y<Parser.storedPost.get(i).dexty){
				Parser.storedPost.get(i).y=Parser.storedPost.get(i).dexty;
			
				set();
				animate=false;
			}
		}
	}
	
	public void set(){
		for(int i=0; i<Parser.storedPost.size() ;i++){
			Parser.storedPost.get(i).dexty=Parser.storedPost.get(i).y-100;
			Parser.storedPost.get(i).vy=0;
			Parser.storedPost.get(i).ay=(float)1.1;
		}
	}

}
