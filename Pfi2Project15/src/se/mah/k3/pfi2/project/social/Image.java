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

public class Image {
	//Display image
	
	private String imgUrl;
	private int desiredImgSizeX;
	private int desiredImgSizeY;
	private ImageIcon processedImage;
	private boolean rounded;
	private boolean debug = false;
	
	public Image(String imgUrl, int desiredImgSizeX, int desiredImgSizeY, boolean rounded) {
		this.imgUrl = imgUrl;
		this.desiredImgSizeX = desiredImgSizeX;
		this.desiredImgSizeY = desiredImgSizeY;
		this.rounded = rounded;
		
		resizeImage();
	}
	
	public ImageIcon getImage(){
		return processedImage;
	}

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
	public static BufferedImage resize(BufferedImage image, int width, int height) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(image, 0, 0, width, height, null);
		g2d.dispose();
		return bi;
	}
	
	//Circular goodness
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
