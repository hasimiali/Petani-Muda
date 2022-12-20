package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
	GamePanel gp;
	public int worldX, worldY;
	public int speed;
	public BufferedImage toolBar, up1, up2, up3, down1, down2, down3, right1, right2, right3, left1, left2, left3;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public int solidAreaDefaultX, solidAreaDefaultY; 
	public boolean collisionOn = false;
	public boolean attack = false;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public void update() {
		collisionOn = false;
		gp.cChecker.checkTile(this);
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		//menggambar object hanya pada saat player bergerak, tidak menggambar semua object
		if(worldX + gp.TILESIZE > gp.player.worldX - gp.player.screenX &&
				worldX - gp.TILESIZE < gp.player.worldX + gp.player.screenX &&
				worldY + gp.TILESIZE > gp.player.worldY - gp.player.screenY &&
				worldY - gp.TILESIZE < gp.player.worldY + gp.player.screenY ) {
			
			switch(direction){
			case "up":
				if(spriteNum == 1) {
					image = up1;
				}
				if(spriteNum == 2) {
					image = up2;
				}
				if(spriteNum == 0) {
					image = up3;
					spriteNum = 1;
				}
				break;
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
			case "right":
				if(spriteNum == 1) {
					image = right1;
				}
				if(spriteNum == 2) {
					image = right2;
				}
				if(spriteNum == 0) {
					image = right3;
					spriteNum = 1;
				}
				break;
			case "left":
				if(spriteNum == 1) {
					image = left1;
				}
				if(spriteNum == 2) {
					image = left2;
				}
				if(spriteNum == 0) {
					image = left3;
					spriteNum = 1;
				}
				break;
			}
			
			g2.drawImage(image, screenX, screenY, gp.TILESIZE, gp.TILESIZE, null);
		}
	}
	
	public BufferedImage setup(String imagePath, int width, int height) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, gp.TILESIZE, gp.TILESIZE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
