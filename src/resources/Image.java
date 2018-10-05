package resources;

import java.awt.Dimension;
import java.awt.Graphics;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Image extends JPanel {

	private static final long serialVersionUID = -5565366612220978314L;
	
	private java.awt.Image img;
	
	
	public Image(String url) {
		 try {
			img = ImageIO.read( new File(url ) );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void paintImage(Graphics g) {
		
		Dimension tamanio = getSize();
		
		g.drawImage(img, 0, 0, tamanio.width, tamanio.height, null);
		super.paintComponent(g);
		
	}

	
	
	
}
