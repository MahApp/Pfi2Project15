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
	
		int refreshRate=15*1000;
		boolean  running=true;
		
		
		
	public ParserUpdateThread(){
		super();
		System.out.println("parserThread constructed");
		
	}
	
	public void run(){
		System.out.println("parserThread is running");
		
		while(running){
		
		try {
			Thread.sleep(refreshRate);
			Parser.getPost();
			System.out.println(Parser.storedPost.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	

	
}
