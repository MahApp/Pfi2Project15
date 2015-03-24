package se.mah.k3.pfi2.project.kronox;

public class ParserUpdateThread extends Thread {
	 public static void main(String[] args0){
		 
		 
		 
	 }
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
			Parser.getPost();
			System.out.println(Parser.storedPost.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	

	
}
