package se.mah.k3.pfi2.project.social;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	
	public Image(String imgUrl, int desiredImgSizeX, int desiredImgSizeY) {
		this.imgUrl = imgUrl;
		this.desiredImgSizeX = desiredImgSizeX;
		this.desiredImgSizeY = desiredImgSizeY;
		
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

			System.out.println("Target size: " + desiredImgSizeX + " x " + desiredImgSizeY);

			int imageWidth = bImage.getWidth();
			int imageHeight = bImage.getHeight();
			System.out.println("Original size: " + imageWidth + " x " + imageHeight);

			int newImageWidth;
			int newImageHeight;

			if (imageHeight >= imageWidth) {
				newImageHeight = desiredImgSizeY;
				newImageWidth = Math.round(desiredImgSizeY * ((float)imageWidth/imageHeight));
			} else {
				newImageWidth = desiredImgSizeX;
				newImageHeight = Math.round(desiredImgSizeX * ((float)imageHeight/imageWidth));
			}

			System.out.println("New image: " + newImageWidth + " x " + newImageHeight);

			BufferedImage resizedImage=resize(bImage, newImageWidth, newImageHeight);//Send image for resizing
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
}
