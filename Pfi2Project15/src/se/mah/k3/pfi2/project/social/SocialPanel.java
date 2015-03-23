package se.mah.k3.pfi2.project.social;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.apache.commons.codec.binary.Base64;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class SocialPanel extends JPanel implements ModuleInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5619243716297221701L;
	
	JSonParser json;
	
	/**
	 * Create the panel.
	 */
	public SocialPanel() {
		setBorder(new EmptyBorder(10, 0, 10, 0));
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		//Tråda!
		try{
			// Superotydliga variabelnamn med vilje.
			String fooIn = "aHR0cHM6Ly9hcGkuaW5zdGFncmFtLmNvbS92MS91c2Vycy8xNzUyOTE4MzAyL21lZGlhL3JlY2VudC8/YWNjZXNzX3Rva2VuPTE3NTI5MTgzMDIuMTU0MWZjNi5mNjY2MzY4MjRhNzM0NDRiYTY1ODBiNTVjZTZmOTJjNw==";
			
			byte[] fooOut = Base64.decodeBase64( fooIn );
			
			String fooFinal = new String(fooOut); //, "UTF-8"
			
			final String instaURL = fooFinal + "&count=1";
			
			
			json = new JSonParser();
			String data = json.fetchData(instaURL);
			
			
			String fooErrorCode = " \"code\":400";
			if(data == ""){
				System.out.println("No Instagram data :(");
			}else if(data.toLowerCase().contains(fooErrorCode.toLowerCase())){
				System.out.println("Couldn't fetch the right data. Error: \n" + fooErrorCode);
			}else{
				json.parseJSon(data);
			}
		}
		catch(Exception  e){
			//e.printStackTrace();
		}
		
		//Skapar ett objekt av en instagram post med hög prioritet
		InstagramPost post = new InstagramPost(json.getUserName(), json.getImgUserUrl(), json.getImgUrl(), json.getImgText(), json.getTimePosted());
		InstagramPost post2 = new InstagramPost(json.getUserName(), json.getImgUserUrl(), json.getImgUrl(), json.getImgText(), json.getTimePosted());
		
		
		add(post2.getPanel());
		add(post.getPanel());
		
	}

	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public boolean showNumberOfRows(int start, int end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void repaintPanel() {
		// TODO Auto-generated method stub
		
	}
}
