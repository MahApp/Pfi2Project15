package trafikinfo;
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
	private JPanel contentPane;
    private JWindow window = new JWindow();
    private JLabel label = new JLabel("Slide Text Swing, Slide Text Swing, ..........");
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
        
        final int desiredWidth = label.getWidth() + 250;
        
        
        jf.getContentPane().setLayout(null);
        jf.setSize(label.getWidth() + 20, label.getHeight() + 50);
        jf.setVisible(true);
        Timer timer = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int newWidth = Math.min(label.getWidth() + 1, desiredWidth);
                label.setSize(newWidth, label.getHeight());
                windowContents.setLocation(newWidth - desiredWidth, 0);
//                if (newWidth >= desiredWidth) {
//                    ((Timer) e.getSource()).stop();
//                    label.setForeground(Color.red);
//                    mainKill();
//                }
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
					//SlideTextSwing windowTest = new SlideTextSwing();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }
}