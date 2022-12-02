package objects;

import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.GamePanel;

public class HoeedSoil extends SuperObject{
	
	public HoeedSoil() {
		name = "Hoeed_soil";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/farm/hoeed_soil.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(GamePanel gp, Graphics2D g2) {
		final int TILE = 1;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		
		//menggambar object hanya pada saat player bergerak, tidak menggambar semua world
		if(worldX + gp.TILESIZE > gp.player.worldX - gp.player.screenX - (TILE * gp.TILESIZE)&&
				worldX - gp.TILESIZE < gp.player.worldX + gp.player.screenX + (TILE * gp.TILESIZE) &&
				worldY + gp.TILESIZE > gp.player.worldY - gp.player.screenY - (TILE * gp.TILESIZE) &&
				worldY - gp.TILESIZE < gp.player.worldY + gp.player.screenY + (TILE * gp.TILESIZE)) {
			
			g2.drawImage(image, screenX, screenY, gp.TILESIZE * TILE, gp.TILESIZE * TILE, null);
			//System.out.println("lagi ngedraw hoeed soil");
		}
	}

	
}
