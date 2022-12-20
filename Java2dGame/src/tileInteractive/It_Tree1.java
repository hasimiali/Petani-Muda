package tileInteractive;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class It_Tree1 extends InteractiveTile{
	GamePanel gp;
	final int objWidth = 3;
	final int objHeight = 4;
	
	public It_Tree1(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		//System.out.println("Tree terbentuk");
		
		this.worldX = gp.TILESIZE*col;
		this.worldY = gp.TILESIZE*row;
		//solid area object untuk collision
		solidArea.x = worldX + solidArea.x + gp.TILESIZE + gp.TILESIZE/5;
		solidArea.y = worldY + solidArea.y + 3*gp.TILESIZE + gp.TILESIZE/2;
		solidArea.width = gp.TILESIZE/2;
		solidArea.height = gp.TILESIZE/2;
		
		down1 = setup("/tile_interactive/tree1", gp.TILESIZE*objWidth, gp.TILESIZE*objHeight);
		destructible = true;
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		direction = "down";
		
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
		
		//menggambar object hanya pada saat player bergerak, tidak menggambar semua object
		if(worldX + gp.TILESIZE > gp.player.worldX - gp.player.screenX - (objWidth * gp.TILESIZE)&&
				worldX - gp.TILESIZE < gp.player.worldX + gp.player.screenX + (objWidth * gp.TILESIZE) &&
				worldY + gp.TILESIZE > gp.player.worldY - gp.player.screenY - (objHeight * gp.TILESIZE) &&
				worldY - gp.TILESIZE < gp.player.worldY + gp.player.screenY + (objHeight * gp.TILESIZE)) {
			
			switch(direction){
			case "down":
				if(spriteNum == 1) {
					image = down1;
				}
				if(spriteNum == 2) {
					image = down2;
				}
				if(spriteNum == 0) {
					image = down3;
					spriteNum = 1;
				}
				break;
			}
			g2.drawImage(image, screenX, screenY, gp.TILESIZE*3, gp.TILESIZE*4, null);
		}else if(gp.player.screenX > gp.player.worldX || gp.player.screenY > gp.player.worldY
				|| rightOffset > gp.worldWidth - gp.player.worldX 
				|| bottomOffset > gp.worldHeight - gp.player.worldY) {
			g2.drawImage(image, screenX, screenY, gp.TILESIZE * objWidth, gp.TILESIZE * objWidth, null);
		}
	}
}
