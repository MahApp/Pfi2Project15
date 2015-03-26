package se.mah.k3.pfi2.project.kronox;

import javax.swing.JPanel;

public class ParserUpdateThread extends Thread {

		/**
		 * 
		 * 
		 *   
		 * 
		 * 
		 * 
		 * */
	KronoxPanel kronoxPanel;
	final int parserRefreshInterval=40;
	int refreshRate = parserRefreshInterval * 1000;
	private volatile boolean running = true;

	public ParserUpdateThread() {
		super();
		System.out.println("parserThread constructed");
	}
	public ParserUpdateThread(KronoxPanel kronoxPanel) {
		super();
		this.kronoxPanel= kronoxPanel;
		System.out.println("parserThread constructed");
	}

	public void run() {
		System.out.println("parserThread is running");
		while (running) {
			try {
				Parser.storedPosts.clear();
				Parser.storedPost.clear();
				 kronoxPanel.setAntalElement(Parser.getPost().size());
				 kronoxPanel.loadData();
				 kronoxPanel.repaintPanel();
				 Thread.sleep(refreshRate);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
