package se.mah.k3.pfi2.project.kronox;

import java.awt.Canvas;

public class CanvasUpdateThread extends Thread {
		/**
		 * 
		 * 
		 *   
		 * 
		 * 
		
		 * */
		public CanvasInJframe demo= new CanvasInJframe();
		private int refreshRate=100;
		private boolean  running=true;
		
	
		public  CanvasUpdateThread(CanvasInJframe demo) {
			super();
			this.demo=demo;
			System.out.println("hej");
		}


		public void run(){
		System.out.println("hej");
		while(running){
			System.out.println("hej");
			demo.updatePost();
			demo.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

	
}
