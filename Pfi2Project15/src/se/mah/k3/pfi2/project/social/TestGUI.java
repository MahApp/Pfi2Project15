package se.mah.k3.pfi2.project.social;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.binary.Base64;
import java.awt.FlowLayout;


public class TestGUI extends JFrame {

	private JPanel contentPane;
	public static JSonParser json;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
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
				
				
				
				try {
					TestGUI frame = new TestGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		//Testinladdning av en bild
		
		
		//Panel start
		
		//Skapar ett objekt av en instagram post med hög prioritet
		InstagramPost post = new InstagramPost(json.getUserName(), json.getImgUserUrl(), json.getImgUrl(), json.getImgText(), json.getTimePosted());
		//InstagramPost post2 = new InstagramPost(json.getUserName(), json.getImgUserUrl(), json.getImgUrl(), json.getImgText(), json.getTimePosted());
		
		contentPane.add(post.getPanel());
		//contentPane.add(post2.getPanel());
		
		
	}

}
