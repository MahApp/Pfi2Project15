package se.mah.k3.pfi2.project.kronox;
import java.awt.*;
import java.awt.event.*;

public class CanvasTest {
int height = 0;
   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;

   public CanvasTest(){
      prepareGUI();
   }

   public static void main(String[] args){
	  CanvasTest  awtControlDemo = new CanvasTest();
      awtControlDemo.showCanvasDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Java AWT Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showCanvasDemo(){
      headerLabel.setText("Control in action: Canvas"); 

      controlPanel.add(new MyCanvas());
      mainFrame.setVisible(true);  
   } 

   class MyCanvas extends Canvas {

      public MyCanvas () {
         setBackground (Color.GRAY);
         setSize(300, 300);
      }

      public void paint (Graphics g) {
         Graphics2D g2;
         g2 = (Graphics2D) g;
         g2.drawLine(10, 10, 200, 200);
         g2.drawString ("It is a custom canvas area", 70, 70);
	
      }
   }
}