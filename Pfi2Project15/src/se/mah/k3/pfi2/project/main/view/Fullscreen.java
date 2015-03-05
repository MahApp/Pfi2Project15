package se.mah.k3.pfi2.project.main.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
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

public class Fullscreen extends JFrame implements KeyEventDispatcher {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean inFullScreenMode = false;
	private int PrevX,PrevY,PrevWidth,PrevHeight;
	public static ArrayList<ModuleInterface> moduleList = new ArrayList<ModuleInterface>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fullscreen frame = new Fullscreen();
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
	private Fullscreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
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
		moduleList.add(new KronoxPanel());
		moduleList.add(new BusPanel());
		moduleList.add(new DummyPanel());
		moduleList.add(new NewsPanel());
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
			contentPane.add((Component) moduleInterface, cons);
		}

		
	}

	public void setFullscreen(boolean fullscreen) {
    	if(fullscreen){
			PrevX = getX();
			PrevY = getY();
			PrevWidth = getWidth();
			PrevHeight = getHeight();
			dispose(); //Destroys the whole JFrame but keeps organized every Component                               
			//Needed if you want to use Undecorated JFrame
			//dispose() is the reason that this trick doesn't work with videos
			setUndecorated(true);
			setBounds(0,0,getToolkit().getScreenSize().width,getToolkit().getScreenSize().height);
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
