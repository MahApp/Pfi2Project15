//Skapad av Mattias & Victor
//2015-03-18
//
//Detta är en klass som visar posterna i schemat, till denna klass ska det tilldelas animationer och logik för att få in korrekta värden
//
//
package se.mah.k3.pfi2.project.kronox;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.EventQueue;
//for images
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CanvasInJframe extends JFrame {
	private JPanel contentPane;
	private Panel controlPanel;
	// diverse bra variabler att ha
	static int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
	final static float DPI = 72; // Pixel density 96 är standard på moderna
	public int antalElement=12;
	// monitors, 72 ät gamla
	final static float PT = 7; // font size pt
	final static int SCREEN_WIDTH = 1080;// old, 768px för LG monitorn
	final static int SCREEN_HEIGHT = 1920;// old, 1024px för LG monitorn
	final static int MIN_MODULE_HEIGHT = 80; // minimum module height
	final static int fieldHeight = 80; // field height
	private Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/se/mah/k3/pfi2/project/kronox/graphics/cancelIcon.png"));
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	public int fontSize = (int) Math.round(PT * screenRes / DPI);
	public Font futuraBook = new Font("Futura LT Regular", Font.PLAIN, fontSize);
	public Font futuraBold = new Font("Futura LT Heavy", Font.PLAIN, fontSize);
	public Font futuraMedium = new Font("Futura LT Medium", Font.PLAIN,fontSize);// typsnittet vi ska använda
	
	private Font fieldFont = futuraBook.deriveFont(Font.PLAIN, 25);
	private Font headerFont = futuraBold.deriveFont(Font.PLAIN, 30);
	// Färger
	private Color whiteColor = Color.decode("#ffffff");
	private Color headerYellowTextColor = Color.decode("#E5DA9F");
	private Color headerFieldBackgroundColor = Color.decode("#3A3A39");
	private Color blueFieldColor = Color.decode("#D6ECF3");
	private Color redEditText = Color.decode("#C52033");
	private ArrayList<Post> displayPost= new ArrayList<Post>();
	private String[] fieldValues = { "09.15", "Interaktionsdesign A", "C310" };
	private ArrayList<String[]> valueList = new ArrayList<String[]>();
	private  MyCanvas demo= new MyCanvas();
	// mått
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CanvasInJframe frame = new CanvasInJframe();
					frame.setVisible(false);
					CanvasInJframe awtControlDemo = new CanvasInJframe();
					
					awtControlDemo.showCanvasDemo();
					awtControlDemo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CanvasInJframe() {
		System.out.println("construct");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		for (int i = 0; i < antalElement; i++) {
			valueList.add(fieldValues);
		}
		for (int i = 0; i < antalElement; i++) {
			shapeList.add(new Rectangle2D.Float(0, fieldHeight+(i * fieldHeight), SCREEN_WIDTH, fieldHeight));
		}
		prepareGUI();
	}
	
	public void loadData(ArrayList<Post> storedPost){
		System.out.println("loaded into canvas");
			valueList.clear();
			for(int i = valueList.size(); i>0;i--){
				valueList.remove(i);
			}
			System.out.println(valueList.size());
		for (int i = 0; i < antalElement; i++) {
			System.out.println(i +"index");
			valueList.add(new String[]{storedPost.get(i).getStartTid(),storedPost.get(i).getMoment(),(storedPost.get(i).getSalID()!=null)?storedPost.get(i).getSalID():""});
		}
		
			demo.repaint(); // this
	}
	
	private void prepareGUI() {
		
		// contentPane är huvudrutan
		contentPane.setBackground(Color.WHITE);
		// SetSize
		contentPane.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		contentPane.setLayout(new GridLayout(1, 1));
		controlPanel = new Panel();
		controlPanel.setBackground(Color.GRAY);
		controlPanel.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		contentPane.add(controlPanel);
		controlPanel.setLayout(null);
		contentPane.setVisible(true);
	}

	void showCanvasDemo() {
		controlPanel.add(demo);
		contentPane.setVisible(true);
	}

	class MyCanvas extends Canvas {
		public MyCanvas() {
			setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
			setBackground(Color.white);
		}

		public void paint(Graphics g) {
			System.out.println("paint!!!!");
			Graphics2D g2;
			g2 = (Graphics2D) g;
			//mjuka upp texten
			RenderingHints rh = new RenderingHints(
					RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
			g2.setRenderingHints(rh);
			// g2.drawLine(10, 10, 200, 200);
			// g2.setStroke();
			g2.drawRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT - 1000);
			// rader
			Stroke stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_BEVEL, 0, new float[] { 1, 0 }, 0);
			g2.setStroke(stroke);
			// Lägger till header-fältet m. text osv
			g2.setFont(headerFont);
			Shape headField = new Rectangle2D.Float(0, 0, SCREEN_WIDTH,
					fieldHeight);
			g2.setColor(headerFieldBackgroundColor);
			g2.fill(headField);
			g2.setColor(headerYellowTextColor);
			g2.drawString("TID", 20, 50);
			g2.drawString("KURS", 200, 50);
			g2.drawString("V/LOKAL", 680, 50);
			g2.drawString("STATUS", SCREEN_WIDTH - 175, 50);
			// skapar en arraylist av fält

		//	boolean colorTurn = false;
			g2.setFont(fieldFont);
			// Strängar i en array som lagras i en lista, som sen ska skrivas ut
			// i respektive fält
			// alla relevanta värden läggs till i en lista
			
			// listan sparas sedan i en lista
			
			for (int i = 0; i < antalElement; i++) {
				Shape tempShape = shapeList.get(i);
				String[] tempValues = (String[]) valueList.get(i);
//				if (colorTurn) {
//					g2.setColor(blueFieldColor);
//				} else {
//					g2.setColor(whiteColor);
//				}
				if(i%2==1){
					g2.setColor(blueFieldColor);							
				}else{
					g2.setColor(whiteColor);
				}
				// fill skriver ut
				g2.fill(tempShape);
				g2.setColor(Color.black);// write out time
				g2.drawString(tempValues[0], 10,(fieldHeight + fieldHeight / 2 + 10)+ (fieldHeight * i));// write out course
				g2.drawString(tempValues[1], 200, (fieldHeight + fieldHeight/ 2 + 10)+ (fieldHeight * i));// write out classroom
				g2.drawString(tempValues[2], 710, (fieldHeight + fieldHeight/ 2 + 10)+ (fieldHeight * i));
				g2.drawImage(img, 940, 90, this);
				g2.drawLine(710, 120, 775, 120);
		//		colorTurn = !colorTurn;
			}
			// Color.decode("rgb(0,0,0,1)");
			// g2.drawre
			// g2.drawImage(img, 100, 100, null);
		}

		private void BasicStroke(int i) {
			// TODO Auto-generated method stub
		}
	}
}
