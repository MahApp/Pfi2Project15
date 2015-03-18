package se.mah.k3.pfi2.project.social;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConsoleTest {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("se.mah.k3.pfi2.project.social.Token");
			
			final String instaURL = "https://api.instagram.com/v1/users/1752918302/media/recent/?access_token=" + Token.token + "&count=1";
			
			
			final JSonParser json = new JSonParser();
			String data = json.fetchData(instaURL);
			json.parseJSon(data);
			
		}
		catch(ClassNotFoundException  e){
			//e.printStackTrace();
			JFrame jf2 = new JFrame();
			jf2.setSize(401, 401);
			jf2.setDefaultCloseOperation(jf2.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(jf2, "Token.java not found. Contact developers.", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			System.out.println("Token.java not found. Contact developers.");
			
		}

		
	}

}
