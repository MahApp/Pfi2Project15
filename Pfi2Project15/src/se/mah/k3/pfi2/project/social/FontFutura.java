package se.mah.k3.pfi2.project.social;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public final class FontFutura {


	public static final Font FuturaLT = initFont("FuturaLT.tff");

	private static volatile Font defaultFont = null;

	static java.awt.Font initFont(String fntName){


		try {
			java.awt.Font customFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,  FontFutura.class.getResourceAsStream("fonts/"+fntName)).deriveFont(10f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
		return new JPanel().getFont();
	}



	public static Font getDefaultFont() {
		return defaultFont;
	}
}