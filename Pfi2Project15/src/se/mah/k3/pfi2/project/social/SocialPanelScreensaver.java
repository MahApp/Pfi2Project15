package se.mah.k3.pfi2.project.social;

import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.commons.codec.binary.Base64;

import se.mah.k3.pfi2.project.main.controller.ModuleInterface;

import java.awt.GridLayout;

import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;

public class SocialPanelScreensaver extends JPanel implements ModuleInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7084506145715732021L;
	private long updateInterval = 60000; //Tidsintervall mellan banner-bild-byte, i millisekunder.
	JPanel[][] panelHolder;
	List<InstagramPost> posts = new ArrayList<InstagramPost>();
	JLabel lblTest;
	private JPanel panel00;
	private JPanel panel01;
	private JPanel panel10;
	private JPanel panel11;
	private JPanel panel20;
	private JPanel panel21;
	private JLabel bannerLabel;

	/**
	 * Create the panel.
	 */
	public SocialPanelScreensaver() {
		setPreferredSize(new Dimension(1080,1920));
		setMinimumSize(new Dimension(1080,1920));
		setLayout(new MigLayout("insets 0, gap 0", "[::540px,grow][grow]", "[grow][][grow][grow]"));
		
		panel00 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel00.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		add(panel00, "cell 0 0,grow");
		
		panel01 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel01.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		add(panel01, "cell 1 0,grow");
		
		bannerLabel = new JLabel("");
		bannerLabel.setIcon(new ImageIcon(SocialPanelScreensaver.class.getResource("/se/mah/k3/pfi2/project/social/graphics/ScreensaverBanner.png")));
		add(bannerLabel, "cell 0 1,growx");
		
		panel10 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel10.getLayout();
		flowLayout_2.setHgap(0);
		flowLayout_2.setVgap(0);
		add(panel10, "cell 0 2,grow");
		
		panel11 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel11.getLayout();
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		add(panel11, "cell 1 2,grow");
		
		panel20 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel20.getLayout();
		flowLayout_4.setVgap(0);
		flowLayout_4.setHgap(0);
		add(panel20, "cell 0 3,grow");
		
		panel21 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel21.getLayout();
		flowLayout_5.setVgap(0);
		flowLayout_5.setHgap(0);
		add(panel21, "cell 1 3,grow");

//		int i = 3; //Rad
//		int j = 2; //Column
//		panelHolder = new JPanel[i][j];    
//		setLayout(new GridLayout(i,j));
//
//		for(int m = 0; m < i; m++) {
//			for(int n = 0; n < j; n++) {
//				panelHolder[m][n] = new JPanel();
//				add(panelHolder[m][n]);
//			}
//		}

		Thread thread = new SocialPanelScreensaver.ScreensaverThread();
		thread.setName("SocialPanelScreensaver");
		thread.start();
	}

	public class ScreensaverThread extends Thread {
		int postsToRetrive = 6;
		JSonParser json;
		List<PostData> postsData;

		public void run() {			
			try {
				while (true) {
					/////////////////////////////////////////////////////////////////////////////////////////////////////

						//<Get json>
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
						//</Get json>

						//<Create InstagramPost objects>
						postsData = new ArrayList<PostData>();
						posts = new ArrayList<InstagramPost>();
						postsData = json.getPostsList();

						for(int i = 0; i < postsData.size(); i++){
							System.out.println("HÄR KOMMER DEN: " + postsData.get(i).getImgUrl());
							posts.add(new InstagramPost(postsData.get(i).getImgUrl()));
						}
						//</Create InstagramPost objects>
						
					//<Add images>
//					panelHolder[0][0].add(posts.get(0).getPanel());
//					panelHolder[0][1].add(posts.get(1).getPanel());
//					panelHolder[1][0].add(posts.get(2).getPanel());
//					panelHolder[1][1].add(posts.get(3).getPanel());
//					panelHolder[2][0].add(posts.get(4).getPanel());
//					panelHolder[2][1].add(posts.get(5).getPanel());
						
					panel00.add(posts.get(0).getPanel());
					panel01.add(posts.get(1).getPanel());
					panel10.add(posts.get(2).getPanel());
					panel11.add(posts.get(3).getPanel());
					panel20.add(posts.get(4).getPanel());
					panel21.add(posts.get(5).getPanel());
					
					repaint();
					//</Add images>

					/////////////////////////////////////////////////////////////////////////////////////////////////////
					Thread.sleep(updateInterval);
				}
			} catch (Exception ex) {}
			start();
		}
	}


	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 0;
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
