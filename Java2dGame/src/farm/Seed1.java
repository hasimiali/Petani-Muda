package farm;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Seed1 extends Crop{
	BufferedImage image, state1, state2, state3, state4;
	public Seed1() {
		name = "Seed1";
		
		try {
			state1 = ImageIO.read(getClass().getResourceAsStream("/crops/seed_1.png"));
			state2 = ImageIO.read(getClass().getResourceAsStream("/crops/seed_2.png"));
			state3 = ImageIO.read(getClass().getResourceAsStream("/crops/seed_3.png"));
			state4 = ImageIO.read(getClass().getResourceAsStream("/crops/seed_4.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(GamePanel gp, Graphics2D g2) {
		final int TILE = 1;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		switch (growState){
			case 1: {
				image = state1;
				break;
			}
			case 2: {
				image = state2;
				break;
			}
			case 3: {
				image = state3;
				break;
			}
			case 4: {
				image = state4;
				break;
			}
		}

		//stoping camera
		if(gp.player.screenX > gp.player.worldX) {
			screenX = worldX;
		}
		if(gp.player.screenY > gp.player.worldY) {
			screenY = worldY;
		}
		int rightOffset = gp.SCREENWIDTH - gp.player.screenX;
		if(rightOffset > gp.worldWidth - gp.player.worldX) {
			screenX = gp.SCREENWIDTH - (gp.worldWidth - worldX);
		}
		int bottomOffset = gp.SCREENHEIGHT - gp.player.screenY;
		if(bottomOffset > gp.worldHeight - gp.player.worldY) {
			screenY = gp.SCREENHEIGHT - (gp.worldHeight - worldY);
		}		
		
		//menggambar object hanya pada saat player bergerak, tidak menggambar semua world
		if(worldX + gp.TILESIZE > gp.player.worldX - gp.player.screenX - (TILE * gp.TILESIZE)&&
				worldX - gp.TILESIZE < gp.player.worldX + gp.player.screenX + (TILE * gp.TILESIZE) &&
				worldY + gp.TILESIZE > gp.player.worldY - gp.player.screenY - (TILE * gp.TILESIZE) &&
				worldY - gp.TILESIZE < gp.player.worldY + gp.player.screenY + (TILE * gp.TILESIZE)) {
			
			g2.drawImage(image, screenX, screenY, gp.TILESIZE * TILE, gp.TILESIZE * TILE, null);
		}else if(gp.player.screenX > gp.player.worldX || gp.player.screenY > gp.player.worldY
				|| rightOffset > gp.worldWidth - gp.player.worldX 
				|| bottomOffset > gp.worldHeight - gp.player.worldY) {
			g2.drawImage(image, screenX, screenY, gp.TILESIZE * TILE, gp.TILESIZE * TILE, null);
		}
	}

	
}
