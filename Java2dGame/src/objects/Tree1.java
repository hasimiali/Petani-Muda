package objects;

import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Tree1 extends SuperObject{
	
	public Tree1() {
		name = "Tree1";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/tree1.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		collision = true;
	}

	@Override
	public void draw(GamePanel gp, Graphics2D g2) {
		final int TILETREE1 = 5;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		
		//menggambar object hanya pada saat player bergerak, tidak menggambar semua object
		if(worldX + gp.TILESIZE > gp.player.worldX - gp.player.screenX - (TILETREE1 * gp.TILESIZE)&&
				worldX - gp.TILESIZE < gp.player.worldX + gp.player.screenX + (TILETREE1 * gp.TILESIZE) &&
				worldY + gp.TILESIZE > gp.player.worldY - gp.player.screenY - (TILETREE1 * gp.TILESIZE) &&
				worldY - gp.TILESIZE < gp.player.worldY + gp.player.screenY + (TILETREE1 * gp.TILESIZE)) {
			
			g2.drawImage(image, screenX, screenY, gp.TILESIZE * TILETREE1, gp.TILESIZE * TILETREE1, null);
		}
	}
	
	
}
