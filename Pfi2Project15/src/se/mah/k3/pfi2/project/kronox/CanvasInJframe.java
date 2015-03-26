//Skapad av Mattias & Victor
//2015-03-18
//
//Detta ï¿½r en klass som visar posterna i schemat, till denna klass ska det tilldelas animationer och logik fï¿½r att fï¿½ in korrekta vï¿½rden
//
//
package se.mah.k3.pfi2.project.kronox;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
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

	final static float DPI = 72; // Pixel density 96 ï¿½r standard pï¿½ moderna
	
	//går att ändra, men starta på 10
	public static int antalElement = 10;
	public Post minPost = new Post();

	// Variables for measurements
	final static float PT = 7; // font size pt
	final static int SCREEN_WIDTH = 1080;// 1080 old, 768px för LG monitorn
	static int SCREEN_HEIGHT = 1920;// old, 1024px för LG monitorn
	final static int fieldHeight = 80; // field height
	// variables for Images
	private Image cancelImg = Toolkit
			.getDefaultToolkit()
			.getImage(
					getClass()
							.getResource(
									"/se/mah/k3/pfi2/project/kronox/graphics/modifiedIcon.png"));
	private Image modifiedImg = Toolkit.getDefaultToolkit().getImage(
			getClass().getResource(
					"/se/mah/k3/pfi2/project/kronox/graphics/cancelIcon.png"));

	// Variables for font-related stuff
	public int fontSize = (int) Math.round(PT * screenRes / DPI);
	public Font futuraBook = new Font("Futura LT", Font.PLAIN, fontSize);
	public Font futuraBold = new Font("Futura LT Heavy", Font.PLAIN, fontSize);
	public Font futuraMedium = new Font("Futura LT Regular", Font.PLAIN,
			fontSize);// typsnittet vi ska använda
	

	//the fonts we've initilized. the numbers furthest to the right determines the font-size
	private Font fieldFont = futuraBook.deriveFont(Font.PLAIN, 30);
	private Font headerFont = futuraBold.deriveFont(Font.PLAIN, 33);

	// Variables for colors

	private Color whiteColor = Color.decode("#ffffff");
	private Color headerYellowTextColor = Color.decode("#ffffff");//E5DA9F
	private Color headerFieldBackgroundColor = Color.decode("#0087b5");   // 3A3A39
	private Color blueFieldColor = Color.decode("#D6ECF3"); 
	private Color redEditText = Color.decode("#C52033");

	// Variables for functionality
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	private ArrayList<Post> displayPost = new ArrayList<Post>();
	private String[] fieldValues = { "- -:- - - -:- -", "LOADING...", "Sal..." };
	private ArrayList<String[]> valueList = new ArrayList<String[]>();
	private MyCanvas demo = new MyCanvas();
	static boolean loaded = false;
	
	// variabler att hämta info i
	String startTid;
	String slutTid;
	String getMoment;
	String getSalID;

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
					CanvasUpdateThread t = new CanvasUpdateThread(
							awtControlDemo);
					System.out.println("main thread");
					t.start();		
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
		setUndecorated(true); // hide buttons
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 10, 5, 10)); //White inner border that creates margin around the schema
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		for (int i = 0; i < antalElement; i++) {
			valueList.add(fieldValues);
		}
		for (int i = 0; i < antalElement; i++) {
			shapeList.add(new Rectangle2D.Float(0, fieldHeight
					+ (i * fieldHeight), SCREEN_WIDTH, fieldHeight));
		}
		prepareGUI();
	}

	// Loading the post-information
	public void loadData(ArrayList<Post> storedPost) {
		System.out.println("loaded into canvas");
		valueList.clear();
		shapeList.clear();
		for (int i = valueList.size(); i > 0; i--) {
			valueList.remove(i);
		}
		System.out.println(storedPost.size());

		setAntalElement(storedPost.size());
											// xml
		for (int i = 0; i < storedPost.size(); i++) {

			startTid = storedPost.get(i).getStartTid();
			slutTid = storedPost.get(i).getSlutTid();
			getMoment = storedPost.get(i).getMoment();
			getSalID = storedPost.get(i).getSalID();
			valueList.add(new String[] { startTid + "-" + slutTid, storedPost.get(i).getKursId()+"  "+getMoment , getSalID });
		}
		for (int i = 0; i < storedPost.size(); i++) {
			shapeList.add(new Rectangle2D.Float(minPost.getX(), fieldHeight + (i * fieldHeight), SCREEN_WIDTH, fieldHeight));
		}
		demo.repaint(); // this
		CanvasInJframe.this.setTitle("Loaded");
	}

	private void prepareGUI() {
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

		//skit i denna metod 4 now
//		public Graphics drawBackground() {
//			// initiate one-time graphics
//			Graphics2D g3 = null;
//			// g3 = (Graphics2D) g;
//
//			// mjuka upp texten
//			RenderingHints rh = new RenderingHints(
//					RenderingHints.KEY_TEXT_ANTIALIASING,
//					RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
//			g3.setRenderingHints(rh);;
//			g3.drawRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT - 1000);
//			// rader
//			Stroke stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE,
//					BasicStroke.JOIN_BEVEL, 0, new float[] { 1, 0 }, 0);
//			g3.setStroke(stroke);
//			// Lägger till header-fältet m. text osv
//			g3.setFont(headerFont);
//			Shape headField = new Rectangle2D.Float(0, 0, SCREEN_WIDTH,
//					fieldHeight);
//			g3.setColor(headerFieldBackgroundColor);
//			g3.fill(headField);
//			g3.setColor(headerYellowTextColor);
//			g3.drawString("TID", 20, 50);
//			g3.drawString("KURS", 200, 50);
//			g3.drawString("LOKAL", 680, 50);
//			g3.drawString("STATUS", SCREEN_WIDTH - 175, 50);
//			return g3;
//
//		}

		public void paint(Graphics g) {
			//initierar metodvariabler
			Graphics2D g2;
			g2 = (Graphics2D) g;
			
			g2.setFont(fieldFont);

			// Gör texten smoothare
			RenderingHints rh = new RenderingHints(
					RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
			g2.setRenderingHints(rh);
		
			
			//tar bort borders
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
			g2.drawString("LOKAL", 680, 50);
			g2.drawString("STATUS", SCREEN_WIDTH - 175, 50);
			//Header koden-avslutad
			
			g2.setFont(fieldFont);
			//Denna skriver ut Posterna + Rektanglarna
			for (int i = 0; i < antalElement; i++) {
				//en temporär rektangel skapas utifrån informationen i Shape-listan
				Shape tempShape = shapeList.get(i);
				//en temporär lista sparar alla relevanta värden
				String[] tempValues = (String[]) valueList.get(i);
				
				//varannan blå, varannan vit
				if (i % 2 == 1) {
					g2.setColor(blueFieldColor);
				} else {
					g2.setColor(whiteColor);
				}
				
				// fill skriver ut
				g2.fill(tempShape);
				
				//Sets the color to black before printin' it out
				g2.setColor(Color.black);// write out time
				g2.drawString(tempValues[0], 10,(fieldHeight + fieldHeight / 2 + 10)+ (fieldHeight * i));// write out time
				g2.drawString(tempValues[1], 200, (fieldHeight + fieldHeight/ 2 + 10)+ (fieldHeight * i));// class and moment
				g2.drawString(tempValues[2], 710, (fieldHeight + fieldHeight/ 2 + 10)+ (fieldHeight * i));//lokal
				
				//These images are just drawn in randomly at the moment
				g2.drawImage(cancelImg, 940, 90, this);
				g2.drawImage(modifiedImg, 940, 90 + fieldHeight, this);
				
				//This line works as crossing over a canceled class maybe?
				//g2.drawLine(710, 120, 775, 120);

			}
		}

	}

	// här under kommer animeringen att äga rum
	public void updatePost() {

		minPost.setX(minPost.getX() + 10);
		Point2D point1 = new Point((int) minPost.getX(), 160); // denna crazy
																// shit
		Rectangle2D rect = (Rectangle2D) shapeList.get(1); // tänk på att det en
															// adress
		rect.setFrame(point1,
				new Dimension((int) rect.getWidth(), (int) rect.getHeight())); // denna
																				// tillhör
																				// fortfarande
																				// shape.get(1)

		// shapeList.get(1).getBounds().setLocation(new Point(300,10));
		// shapeList.get(1).getBounds().setLocation(100,10);
		// Rectangle2D hej=shapeList.get(1).getBounds2D();
		// hej.setRect(100, 10, 500, 50);
		// shapeList.get(1).getBounds().setLocation(new Point(300,160));
		minPost.setY(200);

		System.out.println("kör!!" + shapeList.get(1).getBounds());
		demo.repaint(); //
		// demo.repaint(arg0, arg1, arg2, arg3);
	}
	
	public void setAntalElement(int antal){
		antalElement = antal;
//		sendContentPane = fieldHeight + (antalElement * fieldHeight);
		
		demo.setSize(SCREEN_WIDTH, fieldHeight + (antalElement * fieldHeight));
	}
}
