package se.mah.k3.pfi2.project.main.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import se.mah.k3.pfi2.project.bus.BusPanel;
import se.mah.k3.pfi2.project.dummypanel.DummyPanel;
import se.mah.k3.pfi2.project.kronox.KronoxPanel;
import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3.pfi2.project.main.controller.Setup;
import se.mah.k3.pfi2.project.news.LunchPanel;
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
	private boolean debug=true;
	
	
	/**
	 * Create the frame.
	 * @param mode 
	 */
	public Fullscreen(String mode) {
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
        //Apply a font
        InputStream is = null;
		Font font = null;
		is = Setup.class.getResourceAsStream("FuturaLT.ttf");
		//is = Setup.class.getResourceAsStream("Lobster-Regular.ttf");
		 try {
			 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			if (font==null){font = Font.createFont(Font.TRUETYPE_FONT, is);}
			ge.registerFont(font);
			setUIFont(new FontUIResource(font.deriveFont(Font.TRUETYPE_FONT, 12)));
		   } catch (Exception e) {
			   System.out.println("Couldn't load or register font");
		   }
		 if (debug){
			 System.out.println("All installed fontnames");
			 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			 Font[] f = ge.getAllFonts();
			 for (Font font2 : f) {
				System.out.println(font2.getFontName());
			}
			 Font f3 = new Font("Futura LT Medium", Font.PLAIN, 20);
				System.out.println("NAME: "+f3.getName());
				System.out.println("NAME: "+f3.getFontName());
				
				System.out.println("NAME: -1 is ok "+f3.canDisplayUpTo("Abcdˆ‰Â≈ƒ÷"));
			 System.out.println("========================");
		 }
        setupPanels(mode);
		
	}
	public static void setUIFont(FontUIResource f) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }
	
	private void setupPanels(String mode) {
		//Comment and uncomment here to show your panel
		//Add the panels not yet merged
		//Add more modes if needed to show your module so it shows best
		//Also add a setupfile to match in main.controller
		//Show as many modules as possible in a setup to avoid restarting many times
		if (mode.equals("basic")){
			moduleList.add(new TimePanel());
			moduleList.add(new KronoxPanel());
			moduleList.add(new FillEmptySpace());
		}else if (mode.equals("klockKronoxWeatherandSocial")){
			moduleList.add(new TimePanel());
			moduleList.add(new KronoxPanel());
			moduleList.add(new WeatherPanel());
			moduleList.add(new SocialPanel());
			moduleList.add(new FillEmptySpace());
		}else{
			moduleList.add(new TimePanel());
			moduleList.add(new KronoxPanel());
			moduleList.add(new WeatherPanel());
	//		moduleList.add(new WeatherPanelBig());
			moduleList.add(new NewsPanel());
			moduleList.add(new BusPanel());
			moduleList.add(new SocialPanel());
			moduleList.add(new TrafficInfo());
			moduleList.add(new FillEmptySpace());
			//moduleList.add(new KronoxPanel());
			moduleList.add(new NewsPanel());
			moduleList.add(new LunchPanel());
			moduleList.add(new FillEmptySpace());
		}
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
