package se.mah.k3.pfi2.project.kronox;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;




public class CanvasTest {
int height = 0;
   private Frame mainFrame;
   private Panel controlPanel;
   
   //diverse bra variabler att ha
	static int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
	final static float DPI = 72; // Pixel density 96 är standard på moderna monitors, 72 ät gamla
	final static float PT = 7; // font size pt
	final static int SCREEN_WIDTH = 1080;// old, 768px för LG monitorn  
	final static int SCREEN_HEIGHT = 1920;// old, 1024px för LG monitorn 
	final static int MIN_MODULE_HEIGHT=80; // minimum module height 

   
   //Fonter
	
	
   public int fontSize = (int) Math.round(PT * screenRes / DPI);
   public Font futuraBook = new Font("Futura LT Book", Font.PLAIN, fontSize);// typsnittet vi ska använda
   public Font futuraBold = new Font("Futura LT Bold", Font.PLAIN, fontSize);// typsnittet vi ska använda
   public Font futuraMedium = new Font("Futura LT Medium", Font.PLAIN,fontSize);// typsnittet vi ska använda
   Font fieldFont = futuraBook.deriveFont(Font.PLAIN, 19);
   //Färger
   Color whiteColor = Color.decode("#ffffff");
   Color headerYellowTextColor = Color.decode("#E5DA9F");
   Color headerFieldBackgroundColor = Color.decode("#3A3A39");
   Color blueFieldColor = Color.decode("#D6ECF3");
   Color redEditText = Color.decode("#C52033");

   
   public CanvasTest(){
      prepareGUI();
   }

   public static void main(String[] args){
	  CanvasTest  awtControlDemo = new CanvasTest();
      awtControlDemo.showCanvasDemo();
   }

   private void prepareGUI(){
	   
	  //Mainframe är huvudrutan
      mainFrame = new Frame("Java AWT Examples");
      //SetSize
      mainFrame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
      
      mainFrame.setLayout(new GridLayout(1, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new Panel();
      controlPanel.setSize(2000,2000);
      mainFrame.add(controlPanel);
      controlPanel.setLayout(null);
      
      mainFrame.setVisible(true); 
      
   }

   private void showCanvasDemo(){
      controlPanel.add(new MyCanvas());
      mainFrame.setVisible(true);  
   } 

   class MyCanvas extends Canvas {

      public MyCanvas () {
    	 setSize(2000, 2000);
         setBackground (whiteColor);
         
      }

      public void paint (Graphics g) {
         Graphics2D g2;
         g2 = (Graphics2D) g;
         g2.drawLine(10, 10, 200, 200);
         g2.drawString ("It is a custom canvas area", 870, 370);
	
      }
   }
}