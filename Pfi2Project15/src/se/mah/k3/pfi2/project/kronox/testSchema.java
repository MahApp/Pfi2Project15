package se.mah.k3.pfi2.project.kronox;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;

import se.mah.k3.pfi2.project.test.KronoxAJAXGetFriendlyNames;


//import java.awt.Font[family=Arial,name=Arial,style=plain,size=1];
//java.awt.Font[family=Futura LT,name=Futura LT Bold,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Bold Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Book,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Book Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Condensed Bold,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Condensed Bold Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Condensed Extra Bold,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Condensed Extra Bold Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Condensed Light,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Condensed Light Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Condensed Medium,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Condensed Medium Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Extra Bold,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Extra Bold Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Heavy,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Heavy Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Light,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Light Oblique,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Medium,style=plain,size=1]
//java.awt.Font[family=Futura LT,name=Futura LT Medium Oblique,style=plain,size=1]
/**
 * Test f�r att kolla grafisk profil
 * 
 * Alrik He
 * 2015-03-15
 * 
 * 
 * */
public class testSchema extends JFrame {

	private JPanel contentPane;
	private static JPanel canvas = new JPanel();
	// public static Graphics2D g2;
	private static BasicStroke stroke = new BasicStroke(10);
	private JTable table;
	static int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
	final static float DPI = 72; // Pixel density 96 �r standard p� moderna monitors, 72 �t gamla
	final static float PT = 7; // font size pt
	final static int SCREEN_WIDTH = 1080;// old, 768px f�r LG monitorn  
	final static int SCREEN_HEIGHT = 1920;// old, 1024px f�r LG monitorn 
	final static int MIN_MODULE_HEIGHT=80; // minimum module height 
	int fontSize = (int) Math.round(PT * screenRes / DPI);
	public Font futuraLight = new Font("Futura LT Light", Font.PLAIN,fontSize); // typsnittet vi kanske ska anv�nda
	public Font futuraBook = new Font("Futura LT Book", Font.PLAIN, fontSize);// typsnittet vi ska anv�nda
	public Font futuraBold = new Font("Futura LT Bold", Font.PLAIN, fontSize);// typsnittet vi ska anv�nda
	public Font futuraMedium = new Font("Futura LT Medium", Font.PLAIN,fontSize);// typsnittet vi ska anv�nda

	Canvas canvas2 = new Canvas();
	//implementera schemalogik-klassen
	schemaLogik kronoxNames = new schemaLogik();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					testSchema frame = new testSchema();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); // st�ng appen n�r du trycker p� kryss
					frame.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
					System.out.println("Screen Resolution: "
							+ String.valueOf(screenRes));
					System.out.println("Font size: " + String.valueOf(PT)
							+ "pt");
					System.out.println("Screen DPI: "
							+ String.valueOf(screenRes));
					paintCanvas(); // en funktion som paintar canvasen ,finns l�ngst nere i koden
					//BTW fungerar inte!!!!
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testSchema() {
		GraphicsEnvironment env = GraphicsEnvironment  
				.getLocalGraphicsEnvironment();
		// Get all font family name in a String[]   
		// String[] fontNames = env.getAvailableFontFamilyNames(); //intierar alla fonten.
		// for (String fontName : fontNames) {
		// System.out.println(fontName);
		// }
		// Construct all Font instance (with font size of 1)
		Font[] fonts = env.getAllFonts();
		for (Font font : fonts) {      // printar dem f�r att testa
			System.out.println(font);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

		contentPane = new JPanel();
		contentPane.setFont(futuraBook);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		canvas.setBackground(Color.RED);
		canvas.setBounds(0, 80, SCREEN_WIDTH, MIN_MODULE_HEIGHT);
		contentPane.add(canvas);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);

		table.setBounds(0, 0, SCREEN_WIDTH, MIN_MODULE_HEIGHT);
		table.setRowHeight(0, 40);
		table.setFont(futuraBook);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "08:00-10:00", "Grafisk Design", "K2", null,
						"123", "Width: "+SCREEN_WIDTH+"   Height: 40"}, }, new String[] {
						"TID", "KURS", "HUS", "V", "LOKAL", "STATUS" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class,
					Object.class, Object.class, Object.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		table.setRowHeight(0, 80);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); // custom renderrer f�r centrering av text
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		centerRenderer.setToolTipText("cell");
		centerRenderer.setBackground(Color.LIGHT_GRAY);
		table.setDefaultRenderer(String.class, centerRenderer);
		for (int i = 0; i < 6; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Futura Book"); // labels
		lblNewLabel.setBounds(34, 200, 200, 80);
		lblNewLabel.setFont(futuraBook.deriveFont(Font.PLAIN, 28));
		contentPane.add(lblNewLabel);

		JLabel lblFuturaBold = new JLabel("Futura Bold");// labels
		lblFuturaBold.setBounds(34, 280, 200, 80);
		lblFuturaBold.setFont(futuraBold.deriveFont(Font.PLAIN, 28));
		contentPane.add(lblFuturaBold);

		JLabel lblFuturaMedium = new JLabel("Futura Medium");// labels
		lblFuturaMedium.setBounds(34, 241, 200, 80);
		lblFuturaMedium.setFont(futuraMedium.deriveFont(Font.PLAIN, 28));
		contentPane.add(lblFuturaMedium);
		
		JLabel lblFuturaLight = new JLabel("Futura Light");// labels
		lblFuturaLight.setBounds(34, 160, 200, 80);
		lblFuturaLight.setFont(futuraLight.deriveFont(Font.PLAIN, 28));
		contentPane.add(lblFuturaLight);
		
		JPanel panel = new JPanel();
		
		//Med color.decode kan du s�tta custom f�rger p� dina element
		panel.setBackground(Color.decode("#ffffff"));
		panel.setBounds(0, 423, 1064, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//Victor - en tempor�r modell av en post f�r att se om det g�r att bygga s� h�r
		//ge labelen futurafont och s�tt den
		Font fieldFont = futuraBook.deriveFont(Font.PLAIN, 19);
		//F�rg f�r rubriksf�ltet
		Color headColor = Color.decode("#E5DA9F");
		
		JLabel timeLbl = new JLabel("08:15 - 10.00");
		timeLbl.setBounds(10, 29, 133, 18);
		timeLbl.setFont(fieldFont);
		panel.add(timeLbl);
		
		
		
		JLabel courseLbl = new JLabel(kronoxNames.getCourseName());
		courseLbl.setBounds(193, 24, 141, 35);
		courseLbl.setFont(fieldFont);
		panel.add(courseLbl);

		
		JLabel roomLbl = new JLabel("C310");
		roomLbl.setBounds(669, 30, 108, 21);
		roomLbl.setFont(fieldFont);
		panel.add(roomLbl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#3A3A39"));
		panel_1.setBounds(0, 366, 1064, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel tidHeadLbl = new JLabel("TID");
		tidHeadLbl.setBounds(27, 11, 103, 39);
		panel_1.add(tidHeadLbl);
		
		JLabel kursHeadLbl = new JLabel("KURS");
		kursHeadLbl.setBounds(208, 17, 170, 26);
		panel_1.add(kursHeadLbl);
		
		JLabel lokalHeadLbl = new JLabel("V/LOKAL");
		lokalHeadLbl.setBounds(664, 11, 121, 39);
		panel_1.add(lokalHeadLbl);
		
		JLabel statusHeadLbl = new JLabel("STATUS");
		statusHeadLbl.setBounds(923, 23, 46, 14);
		panel_1.add(statusHeadLbl);

		// g2= (Graphics2D) canvas.getGraphics();
		// this.canvas.paint(g2);

	}

	public static void paintCanvas() {
		// printar canvas f�r att testa fungerar inte!!!!
		// Graphics2D g2= (Graphics2D) testSchema.canvas.getGraphics();
		Graphics g2 = testSchema.canvas.getGraphics();
		g2.drawLine(0, 0, 100, 100);
		g2.setColor(Color.black);
		// g2.setStroke(stroke);
		g2.fillOval(0, 0, 3000, 3000);
		g2.drawLine(10, 10, 768, 50);
		g2.drawOval(0, 0, 700, 50);
		// g2.setBackground(Color.BLACK);
		testSchema.canvas.paint(g2);
		testSchema.canvas.paintAll(g2);
		System.out.println("test");
	}
}
