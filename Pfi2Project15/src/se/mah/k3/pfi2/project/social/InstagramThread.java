package se.mah.k3.pfi2.project.social;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;


/**
 * Skapar en tr�d av Sociala medier modulen
 */
public class InstagramThread extends Thread {
	
	private JSonParser json;
	private int postsToRetrive = 2;
	private List<PostData> postsData;
	private List<InstagramPost> posts = new ArrayList<InstagramPost>();
	
	private SocialPanelMain socialPanel;
	private int updateInterval;
	/**
	 * Konstruktor f�r InstagramThread
	 * @param panel Instans av SocialPanel
	 * @param updateInterval Hur l�ng tid som ska g� mellan varje update, i millisekunder
	 */
	public InstagramThread(SocialPanelMain panel, int updateInterval) {

		this.socialPanel = panel;
		this.updateInterval = updateInterval;
	}
	
	/**
	 * Kallar p� fetchData i JsonParser och skapar en ny array med posts
	 */
	@Override
	public void run() {
		while(true) {
			
			try{
				// Superotydliga variabelnamn med vilje.
				String fooIn = "aHR0cHM6Ly9hcGkuaW5zdGFncmFtLmNvbS92MS91c2Vycy8xNzUyOTE4MzAyL21lZGlhL3JlY2VudC8/YWNjZXNzX3Rva2VuPTE3NTI5MTgzMDIuMTU0MWZjNi5mNjY2MzY4MjRhNzM0NDRiYTY1ODBiNTVjZTZmOTJjNw==";

				byte[] fooOut = Base64.decodeBase64( fooIn );

				String fooFinal = new String(fooOut); //, "UTF-8"

				final String instaURL = fooFinal;


				json = new JSonParser();
				String data = json.fetchData(instaURL,postsToRetrive);


				String fooErrorCode = " \"code\":400";
				if(data == ""){
					System.out.println("No Instagram data :(");
				}else if(data.toLowerCase().contains(fooErrorCode.toLowerCase())){
					System.out.println("Couldn't fetch the right data. Error: \n" + fooErrorCode);
				}else{
					json.parseJSon(data, postsToRetrive);
				}
			}
			catch(Exception e){
				//e.printStackTrace();
			}
			postsData = new ArrayList<PostData>();
			posts = new ArrayList<InstagramPost>();
			postsData = json.getPostsList();
			
			for(int i = 0; i < postsData.size(); i++){
				System.out.println("H�R KOMMER DEN: " + postsData.get(i).getUserName() + postsData.get(i).getImgUserUrl() + postsData.get(i).getImgUrl() + postsData.get(i).getImgText() + postsData.get(i).getTimePosted());
				posts.add(new InstagramPost(postsData.get(i).getUserName(), postsData.get(i).getImgUserUrl(), postsData.get(i).getImgUrl(), postsData.get(i).getImgText(), postsData.get(i).getTimePosted()));
			}
			
			System.out.println("INSTAGRAMTHREAD: Yeah!");
			socialPanel.removeAll();
			socialPanel.add(posts.get(0).getPanel());
			socialPanel.add(posts.get(1).getPanel());
			socialPanel.repaint();
			
			
			//socialPanel.updateTable(lines);
			try {
				Thread.sleep(updateInterval); //Update 1 time/min
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
