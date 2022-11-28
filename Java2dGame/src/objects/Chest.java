package objects;

import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Chest extends SuperObject{
	
	public Chest() {
		name = "Chest";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(GamePanel gp, Graphics2D g2) {
		final int TILECHEST = 1;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		
		//menggambar object hanya pada saat player bergerak, tidak menggambar semua world
		if(worldX + gp.TILESIZE > gp.player.worldX - gp.player.screenX - (TILECHEST * gp.TILESIZE)&&
				worldX - gp.TILESIZE < gp.player.worldX + gp.player.screenX + (TILECHEST * gp.TILESIZE) &&
				worldY + gp.TILESIZE > gp.player.worldY - gp.player.screenY - (TILECHEST * gp.TILESIZE) &&
				worldY - gp.TILESIZE < gp.player.worldY + gp.player.screenY + (TILECHEST * gp.TILESIZE)) {
			
			g2.drawImage(image, screenX, screenY, gp.TILESIZE * TILECHEST, gp.TILESIZE * TILECHEST, null);
		}
	}

	
}
