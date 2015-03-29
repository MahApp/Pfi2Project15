package se.mah.k3.pfi2.project.kronox;

import javax.swing.JPanel;

import se.mah.k3.pfi2.project.kronox.CanvasInJframe.MyCanvas;
import se.mah.k3.pfi2.project.main.controller.ModuleInterface;
import se.mah.k3.pfi2.project.timeweather.DateLogic;
//import se.mah.k3.pfi2.project.timeweather.TimeLogic;






import java.awt.Color;

import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class KronoxPanel extends JPanel implements ModuleInterface{
	// diverse bra variabler att ha
	static int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
	final static float DPI = 72; // Pixel density 96 ï¿½r standard pï¿½ moderna
	
	//går att ändra, men starta på 10
	public  int antalElement = 10;
	public Post minPost = new Post();

	// Variables for measurements
	final static int borderSize = 10;
	final static int borderHeight = 5;
	final static float PT = 7; // font size pt
	final static int SCREEN_WIDTH = 1080;// 1080 old, 768px för LG monitorn
	static int SCREEN_HEIGHT = 1920;// old, 1024px för LG monitorn
	final static int fieldHeight = 80; // field height
	static int ROWS=10;
	// variables for Images
	private Image cancelImg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/se/mah/k3/pfi2/project/kronox/graphics/modifiedIcon.png"));
	private Image modifiedImg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/se/mah/k3/pfi2/project/kronox/graphics/cancelIcon.png"));

	// Variables for font-related stuff
	public static int fontSize = (int) Math.round(PT * screenRes / DPI);
    public static Font futuraBook = new Font("Futura LT Regular", Font.PLAIN, fontSize);
	public static Font futuraBold = new Font("Futura LT Heavy", Font.PLAIN, fontSize);
	public static Font futuraMedium = new Font("Futura LT Regular", Font.PLAIN,fontSize);// typsnittet vi ska använda
	
	//the fonts we've initilized. the numbers furthest to the right determines the font-size
	private Font fieldFont = futuraBook.deriveFont(Font.PLAIN, 30);
	private Font headerFont = futuraBold.deriveFont(Font.PLAIN, 40);

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
	static Building biuldingOption = new Building();
	static boolean loaded = false;
	

	// variabler att hämta info i
	String startTid;
	String slutTid;
	String getMoment;
	String getSalID;
	/**
	 * Create the panel.
	 */
	public KronoxPanel() {
		//Building biuldingOption = new Building();
	
		biuldingOption.setVisible(false);
		antalElement = 8;
		ParserUpdateThread pt= new ParserUpdateThread(this); // thread
		pt.start();

		System.out.println("construct KronoxPanel");
		
		setAntalElement(Parser.storedPost.size());

		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		for (int i = 0; i < antalElement; i++) {
			valueList.add(fieldValues);
		}
		for (int i = 0; i < antalElement; i++) {
			shapeList.add(new Rectangle2D.Float(borderSize, fieldHeight + (i * fieldHeight), SCREEN_WIDTH-borderSize*10, fieldHeight));
		}
		System.out.println(antalElement+"  posts!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}
	
	public void setAntalElement(int antal){
		antalElement = Parser.storedPost.size();
		ROWS=antalElement+1;
		//sendContentPane = fieldHeight + (antalElement * fieldHeight);
		setMinimumSize(new Dimension(1080, 80*ROWS));
		setPreferredSize(new Dimension(1080, 80*ROWS));
		setMaximumSize(new Dimension(1080, 80*ROWS));
		this.setSize(SCREEN_WIDTH, fieldHeight + (antalElement * fieldHeight)+borderSize+5);
	}
	public  void paint(Graphics g) {
		//initierar metodvariabler
		setAntalElement(Parser.storedPost.size());
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(fieldFont);

		// Gör texten smoothare
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		g2.setRenderingHints(rh);
		
		//tar bort borders på smårutorna
		
		Stroke stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL, 0, new float[] { 1, 0 }, 0);
		g2.setStroke(stroke);
		
		// Lägger till header-fältet m. text osv
		g2.setFont(headerFont);
		Shape headField1 = new RoundRectangle2D.Float(borderSize, 0, SCREEN_WIDTH- borderSize*3,fieldHeight, 35 ,35);
		Shape headField2 = new Rectangle2D.Float(borderSize, fieldHeight/2, borderSize, fieldHeight-borderSize);
		g2.setColor(headerFieldBackgroundColor);
		g2.fill(headField2);
		g2.fill(headField1);
		g2.setColor(headerYellowTextColor);
		g2.drawRoundRect(0, 0, SCREEN_WIDTH , fieldHeight, 10, 10); // round rect
		g2.drawString("Tid", 80, 50);
		g2.drawString("Kurs", 380, 50);
		g2.drawString("Lokal", 715, 50);
		g2.drawString("Status", SCREEN_WIDTH - 175, 50);
		//Header koden-avslutad
		
		g2.setFont(fieldFont);
		//Denna skriver ut Posterna + Rektanglarna
		for (int i = 0; i < antalElement; i++) {
			//en temporär rektangel skapas utifrån informationen i Shape-listan
			
			try{
			Shape tempShape = shapeList.get(i);
		
			//en temporär lista sparar alla relevanta värden
			String[] tempValues = (String[]) valueList.get(i);
			
			
			//lägsta vågiga mötet
			if(i == antalElement-1){
				g2.setColor(headerFieldBackgroundColor);
				g2.setStroke(new BasicStroke(5));
				g2.drawRoundRect(borderSize+2, (antalElement * fieldHeight)+borderHeight+4, SCREEN_WIDTH-borderSize-24,  fieldHeight, 10, 35);
				g2.setStroke(new BasicStroke(0)); 
				
			}
			
			//varannan blå, varannan vit
			if (i % 2 == 1) {
				g2.setColor(blueFieldColor);
			} else {
				g2.setColor(whiteColor);
			}
			
	
			
			g2.fill(tempShape);
			// fill skriver ut den understa hörnbildning
			

			
			//Sets the color to black before printin' it out
			g2.setColor(Color.black);// write out time
			if(i==0)  {
			//	g2.setColor(Color.red);
			//	int offset= 15;
				//g2.fillRect(SCREEN_WIDTH/2+170, fieldHeight*2+offset, SCREEN_WIDTH-offset*3-905, fieldHeight -offset*2);
			//	g2.setColor(Color.WHITE);
				//g2.setFont(fieldFont);
			}
			g2.drawString(tempValues[0], borderSize + 10,(fieldHeight + fieldHeight / 2 + 10)+ (fieldHeight * i));// write out time
			g2.drawString(tempValues[1], borderSize +200, (fieldHeight + fieldHeight/ 2 + 10)+ (fieldHeight * i));// class and moment
			if(i==1)  {
				g2.setColor(Color.red);
				int offset= 15;
				g2.fillRect(SCREEN_WIDTH/2+170, fieldHeight*2+offset, SCREEN_WIDTH-offset*3-905, fieldHeight -offset*2);
				g2.setColor(Color.WHITE);
			}
			g2.drawString(tempValues[2], borderSize +710, (fieldHeight + fieldHeight/ 2 + 10)+ (fieldHeight * i));//lokal
			if(i==0)  {
	
					//g2.setFont(fieldFont);
				}
			//These images are just drawn in randomly at the moment
			g2.drawImage(modifiedImg, 940, 90, this);
			g2.drawImage(cancelImg, 940, 90 + fieldHeight, this);
			//This line works as crossing over a canceled class maybe?
			//g2.drawLine(710, 120, 775, 120);
				}catch(IndexOutOfBoundsException e){
				
			}
		

			
		}
		
		// animerade object 
		//g2.fillRect((int)Parser.storedPost.get(5).x+borderSize, (int)Parser.storedPost.get(5).y+5*fieldHeight, SCREEN_WIDTH-borderSize, fieldHeight);

		
		
		//lägg till border på ramen
		g2.setColor(headerFieldBackgroundColor);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(borderSize + 2 , fieldHeight-10, borderSize +2 , fieldHeight + antalElement*fieldHeight);
		g2.drawLine(SCREEN_WIDTH - borderSize*3+5+2 , fieldHeight-10, SCREEN_WIDTH - borderSize*3+7, fieldHeight +  antalElement*fieldHeight);

		
		
	}
	public void loadData( ) {
		System.out.println("loaded into canvas");
		valueList.clear();
		shapeList.clear();
		System.out.println(Parser.storedPost.size());
		setAntalElement(Parser.storedPost.size());// xml
		
		for (int i = 0; i < Parser.storedPost.size(); i++) {
			startTid = Parser.storedPost.get(i).getStartTid();
			slutTid = Parser.storedPost.get(i).getSlutTid();
			getMoment = Parser.storedPost.get(i).getMoment();
			getSalID = Parser.storedPost.get(i).getSalID();
			
			String fittedString=Parser.storedPost.get(i).getKursId()+"  "+getMoment;
			int fitWidth=500,j=0;
			float textWidth=Constants.GetWidthOfString(this,fieldFont,fittedString); //get width
			if(fitWidth>textWidth){}else{
			while(fitWidth<textWidth){
				j++;
				textWidth=Constants.GetWidthOfString(this,fieldFont,fittedString.substring(0, fittedString.length()-j));	
				fittedString=fittedString.substring(0, fittedString.length()-j);
				//System.out.println(fittedString);
			}
			j=0;
			fittedString=fittedString+"...";
			}
			
			valueList.add(new String[] { startTid + "-" + slutTid, fittedString , getSalID });
		}
		for (int i = 0; i < Parser.storedPost.size(); i++) {
			shapeList.add(new Rectangle2D.Float(minPost.getX()+borderSize, fieldHeight + (i * fieldHeight), SCREEN_WIDTH-borderSize, fieldHeight));
		}

		//KronoxAnimationThread at = new KronoxAnimationThread(this); 
		//at.start();
		//at.animate=true;
		

		
		repaint(); // this
		//CanvasInJframe.this.setTitle("Loaded");// window
	}
	
	
	@Override
	public int getExpectedPriority() {
		// TODO Auto-generated method stub
		return 1;
	}

//	public void setPreferdNumberOfRows(int input) {
//		=input;
//		// TODO Auto-generated method stub
//	
//	}
	
	@Override
	public int getPreferdNumberOfRows() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getMinNumberOfRows() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public boolean showNumberOfRows(int start, int end) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void repaintPanel() {
		// TODO Auto-generated method stub
		
	}

}
