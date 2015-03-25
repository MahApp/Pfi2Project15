package se.mah.k3.pfi2.project.kronox;

public class ParserUpdateThread extends Thread {
		/**
		 * 
		 * 
		 *   
		 * 
		 * 
		 * 
		 * */
	
		int refreshRate=600000;
		boolean  running=true;
		
		
		
	ParserUpdateThread(){
		
		
	
		
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
