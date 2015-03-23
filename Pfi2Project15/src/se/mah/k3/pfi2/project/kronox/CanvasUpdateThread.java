package se.mah.k3.pfi2.project.kronox;

public class CanvasUpdateThread extends Thread {
		/**
		 * 
		 * 
		 *   
		 * 
		 * 
		 * 
		 * */
	
		int refreshRate=10;
		boolean  running=true;
		
		
		
	CanvasUpdateThread(){
		
		
	
		
	}
	
	private void Run(){
		
		while(running){
		
		
		try {
			Thread.sleep(refreshRate);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	

	
}
