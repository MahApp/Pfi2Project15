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
	final static float DPI = 72; // Pixel density 96 �r standard p� moderna
									// monitors, 72 �t gamla
	final static float PT = 7; // font size pt
	final static int SCREEN_WIDTH = 1080;// old, 768px f�r LG monitorn
	final static int SCREEN_HEIGHT = 1920;// old, 1024px f�r LG monitorn
	final static int MIN_MODULE_HEIGHT = 80; // minimum module height

	// Fonter
	public int fontSize = (int) Math.round(PT * screenRes / DPI);
	public Font futuraBook = new Font("Futura LT Book", Font.PLAIN, fontSize);
	public Font futuraBold = new Font("Futura LT Bold", Font.PLAIN, fontSize);
	public Font futuraMedium = new Font("Futura LT Medium", Font.PLAIN,
			fontSize);// typsnittet vi ska anv�nda
	Font fieldFont = futuraBook.deriveFont(Font.PLAIN, 19);
	Font headerFont = futuraBold.deriveFont(Font.PLAIN, 19);
	// F�rger
	Color whiteColor = Color.decode("#ffffff");
	Color headerYellowTextColor = Color.decode("#E5DA9F");
	Color headerFieldBackgroundColor = Color.decode("#3A3A39");
	Color blueFieldColor = Color.decode("#D6ECF3");
	Color redEditText = Color.decode("#C52033");

	// m�tt
	int fieldHeight = 80;
	
	public CanvasTest() {
		prepareGUI();
	}

	public static void main(String[] args) {
		CanvasTest awtControlDemo = new CanvasTest();
		awtControlDemo.showCanvasDemo();
	}

	private void prepareGUI() {

		// Mainframe �r huvudrutan
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
			
		//	g2.drawLine(10, 10, 200, 200);
			// g2.setStroke();
			g2.drawRect(0, 0, SCREEN_WIDTH - 100, SCREEN_HEIGHT - 1000);
			
			// rader

			Stroke stroke = new BasicStroke(1, BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_BEVEL, 0, new float[] { 1, 0 }, 0);
			g2.setStroke(stroke);
			
			
			//L�gger till header-f�ltet m. text osv
			g2.setFont(headerFont);
			
			Shape headField = new Rectangle2D.Float(0, 0, SCREEN_WIDTH - 100, fieldHeight);
			g2.setColor(headerFieldBackgroundColor);
			g2.fill(headField);
			g2.setColor(headerYellowTextColor);
			g2.drawString("TID", 20, 50);
			g2.drawString("KURS", 300, 50);
			g2.drawString("V/LOKAL", 750, 50);
			g2.drawString("STATUS", SCREEN_WIDTH-200, 50);
			
			//skapar en arraylist av f�lt
			ArrayList<Shape> shapeList = new ArrayList<Shape>();
			
			int antalElement = 7;
			for (int i = 1; i <= antalElement; i++) {
				
				shapeList.add(new Rectangle2D.Float(0, fieldHeight +1 + (i * fieldHeight), SCREEN_WIDTH - 100, fieldHeight));
			}

			boolean colorTurn = true;
			g2.setFont(fieldFont);
			for (int i = 0; i < antalElement; i++) {
				Shape tempShape = shapeList.get(i);
				
				if (colorTurn) {
					g2.setColor(blueFieldColor);
				}else{
					g2.setColor(whiteColor);
				}
				//fill skriver ut
				g2.fill(tempShape);
				g2.setColor(Color.black);
				g2.drawString("09.15", 10, (fieldHeight + fieldHeight/2) + (fieldHeight*i) );
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