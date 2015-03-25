package se.mah.k3.pfi2.project.traficinfo;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JWindow;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import java.awt.Window.Type;
import java.awt.Rectangle;
import java.awt.FlowLayout;
public class newAnimation extends JFrame {

	JFrame jf = new JFrame();
	private String s;
	private JPanel contentPane;
    private JWindow window = new JWindow();
    private JLabel label = new JLabel("Slide Text Swing, Slide Text Swing, ..........................................");
    private JPanel windowContents = new JPanel();

    public newAnimation() {
        windowContents.setBounds(0, 0, 255, 24);
        windowContents.setBackground(Color.RED);
        windowContents.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        windowContents.add(label);
        jf.getContentPane().add(windowContents);
        jf.getContentPane().setBackground(Color.DARK_GRAY);
        jf.setBounds(new Rectangle(0, 0, 500, 50));
        jf.setAlwaysOnTop(true);
        jf.setBackground(Color.BLACK);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setSize(500, 50);
        
        final int desiredWidth = label.getWidth()*3 + 50;

        
        jf.getContentPane().setLayout(null);
        jf.setSize(label.getWidth() + 20, label.getHeight() + 50);
        jf.setVisible(true);
        
        

        
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		int newWidth = Math.min(label.getWidth() + 1, desiredWidth);
            		label.setSize(newWidth, label.getHeight());
            		int theWidth = label.getWidth()*2;
            		windowContents.setLocation(desiredWidth - theWidth, 0);
            }
        });
        

        timer.start();
        
    }

    public void mainKill() {
        Timer timer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        timer.start();
    }

    public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newAnimation frame = new newAnimation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }
}