package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import input.KeyHandler;
import input.MouseHandler;

public class Player extends Entity {
	
	public final int screenX, screenY;
	
	KeyHandler keyH;
	MouseHandler mouseH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		this.keyH = keyH;
		
		//menempatkan posisi player ke tengah screen/panel
		screenX  = gp.SCREENWIDTH/2 - (gp.TILESIZE/2);
		screenY = gp.SCREENHEIGHT/2 - (gp.TILESIZE/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		attackArea.width = 36;
		attackArea.height = 36;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	//set player position di bagian map
	public void setDefaultValues() {
		
		worldX = gp.TILESIZE * 23;
		worldY = gp.TILESIZE * 22;
		speed = 5;
		direction = "down";
	}
	
	public void getPlayerImage() {
		up1 = setup("/player/guyup1", gp.TILESIZE, gp.TILESIZE);
		up2 = setup("/player/guyup3", gp.TILESIZE, gp.TILESIZE);
		up3 = setup("/player/guyup2", gp.TILESIZE, gp.TILESIZE);
		
		down1 = setup("/player/guydown1", gp.TILESIZE, gp.TILESIZE);
		down2 = setup("/player/guydown3", gp.TILESIZE, gp.TILESIZE);
		down3 = setup("/player/guydown2", gp.TILESIZE, gp.TILESIZE);
		
		right1 = setup("/player/guyright1", gp.TILESIZE, gp.TILESIZE);
		right2 = setup("/player/guyright3", gp.TILESIZE, gp.TILESIZE);
		right3 = setup("/player/guyright2", gp.TILESIZE, gp.TILESIZE);
		
		left1 = setup("/player/guyleft1", gp.TILESIZE, gp.TILESIZE);
		left2 = setup("/player/guyleft3", gp.TILESIZE, gp.TILESIZE);
		left3 = setup("/player/guyleft2", gp.TILESIZE, gp.TILESIZE);
	}
	
	public void update() {
		if(attack == true) {
			attacking();
		}else if(keyH.upPressed == true || keyH.downPressed == true || 
				 keyH.rightPressed == true || keyH.leftPressed == true || keyH.jPressed == true) {
			
			if(keyH.upPressed == true) {
				direction = "up";
			}else if(keyH.downPressed == true) {
				direction = "down";
			}else if(keyH.rightPressed == true) {
				direction = "right";
			}else if(keyH.leftPressed == true) {
				direction = "left";
			}
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			gp.cChecker.checkEntity(this, gp.iTile);
			
			
			if(collisionOn == false && keyH.jPressed == false) {
				switch (direction) {
					case "up"	: worldY -= speed; break;
					case "down"	: worldY += speed; break;
					case "right": worldX += speed; break;
					case "left"	: worldX -= speed; break;
				}
			}else if(collisionOn == true) {
				spriteNum = 0;
			}
			keyH.jPressed = false;
			
			spriteCounter++;
			if(spriteCounter > 15) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			
		}else{
			spriteNum = 0;
		}
	}
	
	public void interactTile() {
			attack = true;
	}
	
	public void attacking() {
		int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
		damageInteractiveTile(iTileIndex);
		attack = false;

	}
	
	public void damageInteractiveTile(int i) {
		if(i != 999 && gp.iTile[i].destructible == true) {
			gp.iTile[i] = null;
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		switch(direction){
		case "up":
			
			if(spriteNum == 1) image = up1;
			if(spriteNum == 2) image = up2;
			if(spriteNum == 0 && keyH.jPressed == false) {
				image = up3;
				spriteNum = 1;
			}
			break;
		case "down":
			
			if(spriteNum == 1) image = down1;
			if(spriteNum == 2) image = down2;
			if(spriteNum == 0 && keyH.jPressed == false) {
				image = down3;
				spriteNum = 1;
			}
			break;
		case "right":
			if(spriteNum == 1) image = right1;
			if(spriteNum == 2) image = right2;
			if(spriteNum == 0 && keyH.jPressed == false) {
				image = right3;
				spriteNum = 1;
			}
			break;
		case "left":
			if(spriteNum == 1) image = left1;
			if(spriteNum == 2) image = left2;
			if(spriteNum == 0 && keyH.jPressed == false) {
				image = left3;
				spriteNum = 1;
			}
			break;
		}
		
		//tidak draw map jika map habis/ diujung map
		int x = screenX;
		int y = screenY;
		
		if(screenX > worldX) {
			x = worldX;
		}
		if(screenY > worldY) {
			y = worldY;
		}
		int rightOffset = gp.SCREENWIDTH - screenX;
		if(rightOffset > gp.worldWidth - worldX) {
			x = gp.SCREENWIDTH - (gp.worldWidth - worldX);
		}
		int bottomOffset = gp.SCREENHEIGHT - screenY;
		if(bottomOffset > gp.worldHeight - worldY) {
			y = gp.SCREENHEIGHT - (gp.worldHeight - worldY);
		}
		
		g2.drawImage(image, x, y, null);
	}
}
