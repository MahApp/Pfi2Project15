package se.mah.k3.pfi2.project.social;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class InstagramPost {

	private JPanel panel;
	private String userName;
	private String imgUserUrl;
	private String imgUrl;
	private String imgText;
	private String timePosted;

	public InstagramPost(String userName_in, String imgUserUrl_in, String imgUrl_in, String imgText_in, String timePosted_in) {

		this.userName = userName_in;
		this.imgUserUrl = imgUserUrl_in;
		this.imgUrl = imgUrl_in;
		this.imgText = imgText_in;
		this.timePosted = timePosted_in;

		FontFutura futura = new FontFutura();



		////////
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

//		String fontNames[] = graphicsEnvironment.getAvailableFontFamilyNames();
//		for(int i=0; i < fontNames.length; i++){
//			//print font names
//			System.out.println(fontNames[i]);
//		}
		/////////

		//Panel start

		panel = new JPanel();
		panel.setFont(FontFutura.FuturaLT.deriveFont(14f));
		panel.setBounds(0, 0, 540, 540);
		//contentPane.add(panel); Detta görs i "controllern". Returnera panel i en getPanel-metod 
		panel.setLayout(null);

		JLabel profileName = new JLabel(userName);
		profileName.setForeground(Color.WHITE);
		profileName.setFont(new Font("Futura LT", Font.PLAIN, 24));
//		System.out.println("profileName: " + profileName.getFont().toString());
		profileName.setBounds(107, 451, 346, 29);
		panel.add(profileName);

		JTextPane imageText = new JTextPane();
		//		imageText.setWrapStyleWord(true);
		//		imageText.setLineWrap(true);
		imageText.setEditable(false);
		imageText.setForeground(Color.WHITE);
		imageText.setFont(FontFutura.FuturaLT.deriveFont(14f));
//		System.out.println("imageText: " + imageText.getFont().toString());
		String textLimited = imgText;
		if(textLimited.length() > 80) textLimited = textLimited.substring(0,80) + "...";
		imageText.setText(textLimited);
		imageText.setBounds(107, 479, 346, 50);
		imageText.setBackground(new Color(255,255,255,0));
		panel.add(imageText);

		JLabel time = new JLabel(timePosted);
		time.setForeground(Color.WHITE);
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setFont(new Font("Futura LT", Font.PLAIN, 24));
		time.setBounds(447, 451, 83, 29);
		panel.add(time);

		JLabel profilePicBorder = new JLabel("");
		profilePicBorder.setIcon(new ImageIcon(getClass().getResource("/se/mah/k3/pfi2/project/social/graphics/InstagramProfilePicBorder.png"))); //Profile pic border
		profilePicBorder.setBounds(5, 444, 92, 92);
		panel.add(profilePicBorder);

		JLabel profilePic = new JLabel("");
		profilePic.setIcon(new Image(imgUserUrl, 91, 91, true).getImage()); //Profile pic - Fixa BildURL länken!!!!!
		profilePic.setBounds(5, 444, 91, 91);
		panel.add(profilePic);

		JLabel gradientOverlay = new JLabel("");
		gradientOverlay.setIcon(new ImageIcon(getClass().getResource("/se/mah/k3/pfi2/project/social/graphics/InstagramGradientOverlay.png"))); //Gradient overlay
		gradientOverlay.setBounds(0, 440, 540, 100);
		panel.add(gradientOverlay);

		JLabel image = new JLabel("");
		image.setIcon(new Image(imgUrl, 540, 540, false).getImage()); //Image
		image.setBounds(0, 0, 540, 540);
		panel.add(image);

		//Panel end
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	public InstagramPost(String imgUrl_in) {

		this.imgUrl = imgUrl_in;

		//Panel start
		
		int size = 540;
		
		panel = new JPanel();
		panel.setBounds(0, 0, size, size);
		//contentPane.add(panel); Detta görs i "controllern". Returnera panel i en getPanel-metod 
		panel.setLayout(null);

		JLabel image = new JLabel("");
		image.setIcon(new Image(imgUrl, size, size, false).getImage()); //Image
		image.setBounds(0, 0, size, size);
		panel.add(image);

		//Panel end
	}

	public JPanel getPanel(){
		return panel;
	}
}
