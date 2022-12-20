package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityTool {
	public BufferedImage scaleImage(BufferedImage original, int width, int heigt) {
		BufferedImage scaledImage = new BufferedImage(width, heigt, original.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.drawImage(original, 0, 0, width, heigt, null);
		g2.dispose();
		
		return scaledImage;
	}
}
