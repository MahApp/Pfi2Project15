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
		contentPane.setLayout(null);
		
		//Testinladdning av en bild
		
		
		//Panel start
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 540, 540);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel profileName = new JLabel(json.userName);
		profileName.setForeground(Color.WHITE);
		profileName.setFont(new Font("Calibri", Font.PLAIN, 23));
		profileName.setBounds(107, 451, 346, 29);
		panel.add(profileName);
		
		JTextArea imageText = new JTextArea();
		imageText.setWrapStyleWord(true);
		imageText.setLineWrap(true);
		imageText.setEditable(false);
		imageText.setForeground(Color.WHITE);
		imageText.setFont(new Font("Calibri", Font.PLAIN, 18));
		String textLimited = json.imgText;
		if(textLimited.length() > 80) textLimited = textLimited.substring(0,80) + "...";
		imageText.setText(textLimited);
		imageText.setBounds(107, 479, 346, 50);
		imageText.setBackground(new Color(255,255,255,0));
		Font futura= new Font("Calibri", Font.PLAIN, 18);
		panel.add(imageText);
		
		JLabel time = new JLabel(json.timePosted);
		time.setForeground(Color.WHITE);
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setFont(new Font("Calibri", Font.PLAIN, 23));
		time.setBounds(447, 451, 83, 29);
		panel.add(time);
		
		JLabel profilePicBorder = new JLabel("");
		profilePicBorder.setIcon(new ImageIcon(TestGUI.class.getResource("/se/mah/k3/pfi2/project/social/graphics/InstagramProfilePicBorder.png"))); //Profile pic border
		profilePicBorder.setBounds(5, 444, 92, 92);
		panel.add(profilePicBorder);
		
		JLabel profilePic = new JLabel("");
		profilePic.setIcon(new Image(json.imgUserUrl, 91, 91, true).getImage()); //Profile pic - Fixa BildURL länken!!!!!
		profilePic.setBounds(5, 444, 91, 91);
		panel.add(profilePic);
		
		JLabel gradientOverlay = new JLabel("");
		gradientOverlay.setIcon(new ImageIcon(TestGUI.class.getResource("/se/mah/k3/pfi2/project/social/graphics/InstagramGradientOverlay.png"))); //Gradient overlay
		gradientOverlay.setBounds(0, 440, 540, 100);
		panel.add(gradientOverlay);
		
		JLabel image = new JLabel("");
		image.setIcon(new Image(json.imgUrl, 540, 540, false).getImage()); //Image
		image.setBounds(0, 0, 540, 540);
		panel.add(image);
	}

}
