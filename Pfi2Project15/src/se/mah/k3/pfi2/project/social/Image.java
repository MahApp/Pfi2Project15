package se.mah.k3.pfi2.project.social;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Omvandlar bilder fr�n Instagram, s� att de blir r�tt storlek och passar i modulen.
 */
public class Image {
	//Display image
	
	private String imgUrl;
	private int desiredImgSizeX;
	private int desiredImgSizeY;
	private ImageIcon processedImage;
	private boolean rounded;
	private boolean debug = false;
	
	/**
	 * Konstruktor f�r Image
	 * @param imgUrl url f�r bilden
	 * @param desiredImgSizeX Xstorleken som bilden ska f�
	 * @param desiredImgSizeY Ystorleken som bilden ska f�
	 * @param rounded Om bilden ska f� rundade kanter
	 */
	public Image(String imgUrl, int desiredImgSizeX, int desiredImgSizeY, boolean rounded) {
		this.imgUrl = imgUrl;
		this.desiredImgSizeX = desiredImgSizeX;
		this.desiredImgSizeY = desiredImgSizeY;
		this.rounded = rounded;
		
		resizeImage();
	}
	
	/**
	 * Returnerar en f�rdig bild
	 * @return Den f�rdiga bilden
	 */
	public ImageIcon getImage(){
		return processedImage;
	}

	/**
	 * Formar om bilden enligt parametrarna fr�n konstruktorn
	 */
	private void resizeImage(){
		URL url;
		
		try {
			url = new URL(imgUrl);
			BufferedImage bImage;
			bImage = ImageIO.read(url);

			if(debug)System.out.println("Target size: " + desiredImgSizeX + " x " + desiredImgSizeY);{}

			int imageWidth = bImage.getWidth();
			int imageHeight = bImage.getHeight();
			if(debug)System.out.println("Original size: " + imageWidth + " x " + imageHeight);{}

			int newImageWidth;
			int newImageHeight;

			if (imageHeight >= imageWidth) {
				newImageHeight = desiredImgSizeY;
				newImageWidth = Math.round(desiredImgSizeY * ((float)imageWidth/imageHeight));
			} else {
				newImageWidth = desiredImgSizeX;
				newImageHeight = Math.round(desiredImgSizeX * ((float)imageHeight/imageWidth));
			}

			if(debug)System.out.println("New image: " + newImageWidth + " x " + newImageHeight);{}

			BufferedImage resizedImage=resize(bImage, newImageWidth, newImageHeight);//Send image for resizing
			if(rounded)	resizedImage = makeRoundedCorner(resizedImage, newImageWidth);
			processedImage = new ImageIcon(resizedImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Resize image
	/**
	 * �ndrar storleken p� bilden
	 * @param image bilden som ska �ndras
	 * @param width bredd
	 * @param height h�jd
	 * @return returnerar bilden
	 */
	public static BufferedImage resize(BufferedImage image, int width, int height) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(image, 0, 0, width, height, null);
		g2d.dispose();
		return bi;
	}
	
	//Circular goodness
	/**
	 * G�r rundade kanter p� bilden, om konstruktorn f�tt en true f�r detta.
	 * @param image bilden som ska f� rundade kanter
	 * @param cornerRadius Hur l�ngt fr�n h�rnet sj�lva avrundningen b�rjar, i pixlar. (Vi �r inte helt s�kra p� denna, kan beh�va f�rtydligas?)
	 * @return returnerar f�rdig bild
	 */
	public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
	    int w = image.getWidth();
	    int h = image.getHeight();
	    BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2 = output.createGraphics();

	    // This is what we want, but it only does hard-clipping, i.e. aliasing
	    // g2.setClip(new RoundRectangle2D ...)

	    // so instead fake soft-clipping by first drawing the desired clip shape
	    // in fully opaque white with antialiasing enabled...
	    g2.setComposite(AlphaComposite.Src);
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setColor(Color.WHITE);
	    g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));

	    // ... then compositing the image on top,
	    // using the white shape from above as alpha source
	    g2.setComposite(AlphaComposite.SrcAtop);
	    g2.drawImage(image, 0, 0, null);

	    g2.dispose();

	    return output;
	}
}
