package se.mah.k3.pfi2.project.main.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3.pfi2.project.bus.BusPanel;
import se.mah.k3.pfi2.project.dummypanel.DummyPanel;
import se.mah.k3.pfi2.project.kronox.KronoxPanel;
import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3.pfi2.project.news.NewsPanel;


import se.mah.k3.pfi2.project.social.SocialPanel;
import se.mah.k3.pfi2.project.timeweather.TimePanel;
import se.mah.k3.pfi2.project.timeweather.WeatherPanel;
import se.mah.k3.pfi2.project.timeweather.WeatherPanelBig;
import se.mah.k3.pfi2.project.traficinfo.view.TrafficInfo;



public class Fullscreen extends JFrame implements KeyEventDispatcher {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean inFullScreenMode = false;
	private int PrevX = 100 ,PrevY = 100 ,PrevWidth = 480,PrevHeight = 640;
	public static ArrayList<ModuleInterface> moduleList = new ArrayList<ModuleInterface>();
	
	
	/**
	 * Create the frame.
	 */
	public Fullscreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(249,179,0));

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager(); //Listen to keyboard
        manager.addKeyEventDispatcher(this);
        setupPanels();
	}
	
	private void setupPanels() {

//		moduleList.add(new KronoxPanel());
//		moduleList.add(new DummyPanel());
//		moduleList.add(new NewsPanel());

		moduleList.add(new TimePanel());
		moduleList.add(new WeatherPanel());
		moduleList.add(new WeatherPanelBig());
		moduleList.add(new NewsPanel());
		moduleList.add(new BusPanel());
		moduleList.add(new SocialPanel());
		moduleList.add(new BusPanel());
		moduleList.add(new TrafficInfo());
		moduleList.add(new FillEmptySpace());
		int yPlace = 0;
		for (ModuleInterface moduleInterface : moduleList) {
			GridBagConstraints cons = new GridBagConstraints();
			cons.weighty = 1.0;
			cons.weightx = 1.0;
			cons.fill = GridBagConstraints.BOTH;
			cons.insets = new Insets(0, 0, 5, 0);
			cons.gridy = yPlace;
			yPlace = yPlace +1;
			cons.gridx = 0;
			if ( !(moduleInterface instanceof FillEmptySpace)){
				cons.fill = GridBagConstraints.HORIZONTAL;
				cons.weighty = 0.0;
			}else{
				cons.weighty = 1.0;
			}
			contentPane.add((Component) moduleInterface, cons);
		}
		setFullscreen(false);
		
	}

	public void setFullscreen(boolean fullscreen) {
		 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     GraphicsDevice[] gd = ge.getScreenDevices();
    	if(fullscreen){
			PrevX = getX();
			PrevY = getY();
			PrevWidth = getWidth();
			PrevHeight = getHeight();
			dispose(); 
			//Always on last screen!
			setUndecorated(true);
			gd[gd.length-1].setFullScreenWindow(this);
			setVisible(true);
			this.inFullScreenMode = true;
		}
		else{
			setVisible(true);
			setBounds(PrevX, PrevY, PrevWidth, PrevHeight);
			dispose();
			setUndecorated(false);
			setVisible(true);
			this.inFullScreenMode = false;
		}
    }


	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		 if (e.getID() == KeyEvent.KEY_PRESSED) {
             //System.out.println("tester");
         } else if (e.getID() == KeyEvent.KEY_RELEASED) {
             //System.out.println("2test2");
         } else if (e.getID() == KeyEvent.KEY_TYPED) {
        	 if(e.getKeyChar()=='f'){     		 
              	setFullscreen(!inFullScreenMode);	
      		}
         }
         return false;
	}
}
