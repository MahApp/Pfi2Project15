package se.mah.k3.pfi2.project.kronox;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class CanvasTest {
	int height = 0;
	private Frame mainFrame;
	private Panel controlPanel;

	// diverse bra variabler att ha
	static int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
	final static float DPI = 72; // Pixel density 96 är standard på moderna
									// monitors, 72 ät gamla
	final static float PT = 7; // font size pt
	final static int SCREEN_WIDTH = 1080;// old, 768px för LG monitorn
	final static int SCREEN_HEIGHT = 1920;// old, 1024px för LG monitorn
	final static int MIN_MODULE_HEIGHT = 80; // minimum module height

	// Fonter
	public int fontSize = (int) Math.round(PT * screenRes / DPI);
	public Font futuraBook = new Font("Futura LT Book", Font.PLAIN, fontSize);
	public Font futuraBold = new Font("Futura LT Bold", Font.PLAIN, fontSize);
	public Font futuraMedium = new Font("Futura LT Medium", Font.PLAIN,
			fontSize);// typsnittet vi ska använda
	Font fieldFont = futuraBook.deriveFont(Font.PLAIN, 19);
	Font headerFont = futuraBold.deriveFont(Font.PLAIN, 19);
	// Färger
	Color whiteColor = Color.decode("#ffffff");
	Color headerYellowTextColor = Color.decode("#E5DA9F");
	Color headerFieldBackgroundColor = Color.decode("#3A3A39");
	Color blueFieldColor = Color.decode("#D6ECF3");
	Color redEditText = Color.decode("#C52033");

	// mått
	int fieldHeight = 80;
	
	public CanvasTest() {
		prepareGUI();
	}

	public static void main(String[] args) {
		CanvasTest awtControlDemo = new CanvasTest();
		awtControlDemo.showCanvasDemo();
	}

	private void prepareGUI() {

		// Mainframe är huvudrutan
		mainFrame = new Frame("Java AWT Examples");
		// SetSize
		mainFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

		mainFrame.setLayout(new GridLayout(1, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		controlPanel = new Panel();
		controlPanel.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		mainFrame.add(controlPanel);
		controlPanel.setLayout(null);

		mainFrame.setVisible(true);

	}

	private void showCanvasDemo() {
		controlPanel.add(new MyCanvas());
		mainFrame.setVisible(true);
	}

	class MyCanvas extends Canvas {

		public MyCanvas() {
			setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
			setBackground(Color.white);

		}

		public void paint(Graphics g) {
			Graphics2D g2;
			g2 = (Graphics2D) g;
			RenderingHints rh = new RenderingHints(
		            RenderingHints.KEY_TEXT_ANTIALIASING,
		            RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		    g2.setRenderingHints(rh);
			
		//	g2.drawLine(10, 10, 200, 200);
			// g2.setStroke();
			g2.drawRect(0, 0, SCREEN_WIDTH - 100, SCREEN_HEIGHT - 1000);
			
			// rader

			Stroke stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_BEVEL, 0, new float[] { 1, 0 }, 0);
			g2.setStroke(stroke);
			
			
			//Lägger till header-fältet m. text osv
			g2.setFont(headerFont);
			
			Shape headField = new Rectangle2D.Float(0, 0, SCREEN_WIDTH - 100, fieldHeight);
			g2.setColor(headerFieldBackgroundColor);
			g2.fill(headField);
			g2.setColor(headerYellowTextColor);
			g2.drawString("TID", 20, 50);
			g2.drawString("KURS", 200, 50);
			g2.drawString("V/LOKAL", 750, 50);
			g2.drawString("STATUS", SCREEN_WIDTH-200, 50);
			
			//skapar en arraylist av fält
			ArrayList<Shape> shapeList = new ArrayList<Shape>();
			
			int antalElement = 10;
			for (int i = 0; i < antalElement; i++) {
				
				shapeList.add(new Rectangle2D.Float(0, fieldHeight + (i * fieldHeight), SCREEN_WIDTH - 100, fieldHeight));
			}

			boolean colorTurn = false;
			g2.setFont(fieldFont);
			
			//Strängar i en array som lagras i en lista, som sen ska skrivas ut i respektive fält
			//alla relevanta värden läggs till i en lista
			String[] fieldValues = {"09.15", "Interaktionsdesign A", "C310" };
			//listan sparas sedan i en lista
			ArrayList<String[]> valueList = new ArrayList<String[]>();
			
			for(int i = 0; i <antalElement; i++){
				valueList.add(fieldValues);
			
			}
			String tidString = "08.15";
			String kursString = "Interaktionsdesign A";
			String salString = "C310";
			
			
			for (int i = 0; i < antalElement; i++) {
				Shape tempShape = shapeList.get(i);
				String[] tempValues = (String[]) valueList.get(i);
				if (colorTurn) {
					g2.setColor(blueFieldColor);
				}else{
					g2.setColor(whiteColor);
				}
				//fill skriver ut
				g2.fill(tempShape);
				g2.setColor(Color.black);
				g2.drawString(tempValues[0], 10, (fieldHeight + fieldHeight/2 +10) + (fieldHeight*i) );
				g2.drawString(tempValues[1], 200, (fieldHeight + fieldHeight/2+10) + (fieldHeight*i) );
				g2.drawString(tempValues[2], 750, (fieldHeight + fieldHeight/2+10) + (fieldHeight*i) );
				colorTurn = !colorTurn;
			}
			//Color.decode("rgb(0,0,0,1)");
			// g2.drawre

		}

		private void BasicStroke(int i) {
			// TODO Auto-generated method stub

		}
	}
}