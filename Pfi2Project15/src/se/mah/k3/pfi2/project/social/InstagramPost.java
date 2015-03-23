package se.mah.k3.pfi2.project.social;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class InstagramPost {
	
	private JPanel panel;
	private String userName;
	private String imgUserUrl;
	private String imgUrl;
	private String imgText;
	private String timePosted;
	
	
	public InstagramPost(String userName, String imgUserUrl, String imgUrl, String imgText, String timePosted) {
		
		this.userName = userName;
		this.imgUserUrl = imgUserUrl;
		this.imgUrl = imgUrl;
		this.imgText = imgText;
		this.timePosted = timePosted;
		
		//Panel start
		
		panel = new JPanel();
		panel.setBounds(5, 5, 540, 540);
		//contentPane.add(panel); Detta görs i "controllern". Returnera panel i en getPanel-metod 
		panel.setLayout(null);
		
		JLabel profileName = new JLabel(userName);
		profileName.setForeground(Color.WHITE);
		profileName.setFont(new Font("Calibri", Font.PLAIN, 23)); //TODO: Byt font
		profileName.setBounds(107, 451, 346, 29);
		panel.add(profileName);
		
		JTextArea imageText = new JTextArea();
		imageText.setWrapStyleWord(true);
		imageText.setLineWrap(true);
		imageText.setEditable(false);
		imageText.setForeground(Color.WHITE);
		imageText.setFont(new Font("Calibri", Font.PLAIN, 18));
		String textLimited = imgText;
		if(textLimited.length() > 80) textLimited = textLimited.substring(0,80) + "...";
		imageText.setText(textLimited);
		imageText.setBounds(107, 479, 346, 50);
		imageText.setBackground(new Color(255,255,255,0));
		Font futura= new Font("Calibri", Font.PLAIN, 18);
		panel.add(imageText);
		
		JLabel time = new JLabel(timePosted);
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
		profilePic.setIcon(new Image(imgUserUrl, 91, 91, true).getImage()); //Profile pic - Fixa BildURL länken!!!!!
		profilePic.setBounds(5, 444, 91, 91);
		panel.add(profilePic);
		
		JLabel gradientOverlay = new JLabel("");
		gradientOverlay.setIcon(new ImageIcon(TestGUI.class.getResource("/se/mah/k3/pfi2/project/social/graphics/InstagramGradientOverlay.png"))); //Gradient overlay
		gradientOverlay.setBounds(0, 440, 540, 100);
		panel.add(gradientOverlay);
		
		JLabel image = new JLabel("");
		image.setIcon(new Image(imgUrl, 540, 540, false).getImage()); //Image
		image.setBounds(0, 0, 540, 540);
		panel.add(image);
		
		//Panel end
	}
	
	public JPanel getPanel(){
		return panel;
	}
}
