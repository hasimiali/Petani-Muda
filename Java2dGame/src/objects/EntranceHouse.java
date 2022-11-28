package objects;

import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.GamePanel;

public class EntranceHouse extends SuperObject{
	
	public EntranceHouse() {
		name = "EntranceHouse";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(GamePanel gp, Graphics2D g2) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		final int TILEDOOR = 2;
		
		//menggambar object hanya pada saat player bergerak, tidak menggambar semua object
		if(worldX + gp.TILESIZE > gp.player.worldX - gp.player.screenX - (TILEDOOR * gp.TILESIZE)&&
				worldX - gp.TILESIZE < gp.player.worldX + gp.player.screenX + (TILEDOOR * gp.TILESIZE) &&
				worldY + gp.TILESIZE > gp.player.worldY - gp.player.screenY - (TILEDOOR * gp.TILESIZE) &&
				worldY - gp.TILESIZE < gp.player.worldY + gp.player.screenY + (TILEDOOR * gp.TILESIZE)) {
			
			g2.drawImage(image, screenX, screenY, gp.TILESIZE * TILEDOOR, gp.TILESIZE * TILEDOOR, null);
		}
	}
}
