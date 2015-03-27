package se.mah.k3.pfi2.project.social;

/**
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation
 * (http://www.gnu.org/licenses/gpl.txt ). This program is
 * distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * @author <a href="mailto:zudairee@mail.nih.gov">
 * Enrique Zudaire</a>, Radiation Oncology Branch, NCI, NIH
 * May, 2011
 * angiotool.nci.nih.gov
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3688811039931787777L;
	private int radius;

	public RoundedPanel (){
		//super();
	}

	public RoundedPanel(int cornerRadius) {
		radius=cornerRadius;
	}

	public void setCornerRadius (int cornerRadius){
		radius=cornerRadius;
	}

	@Override
	public void paintComponent(Graphics g) {
		Color bg = getBackground();
		g.setColor(new Color(bg.getRed(),bg.getGreen(),bg.getBlue()));

		g.fillRoundRect(0,0, getWidth()-1, getHeight()-1, radius, radius);
		g.setColor(new Color(0,0,0,70));
		g.drawRoundRect(0,0, getWidth()-1, getHeight()-1, radius, radius);
	}

}