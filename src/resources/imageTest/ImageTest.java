package resources.imageTest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImageTest extends JPanel {

	private static final long serialVersionUID = -5565366612220978314L;
	
	private Image img;
	
	
	public ImageTest(String url) {
		 try {
			img = ImageIO.read( new File( url ) );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		Dimension tamanio = getSize();
		
		super.paintComponent(g);
		g.drawImage(img, 0, 0, tamanio.width, tamanio.height, null);
		
		
	}

	
	
	
}
