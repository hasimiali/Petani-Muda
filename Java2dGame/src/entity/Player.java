package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	public final int screenX, screenY;
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
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
		
		setDefaultValues();
		getPlayerImage();
	}
	
	//set player position di bagian map
	public void setDefaultValues() {
		
		worldX = gp.TILESIZE * 23;
		worldY = gp.TILESIZE * 21;
		speed = 7;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/guyup1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/guyup3.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/guyup2.png"));

			
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/guydown1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/guydown3.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/guydown2.png"));

			
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/guyright1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/guyright3.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/guyright2.png"));

			
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/guyleft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/guyleft3.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/guyleft2.png"));

			toolBar = ImageIO.read(getClass().getResourceAsStream("/windows/toolbar.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		//merubah posisi karakter sesuai arrow + cek collision
		
		collisionOn = false;
		if(keyH.upPressed == true) {
			gp.cChecker.checkTile(this);
			direction = "up";
			if(collisionOn == false) {
				worldY -= speed;
				spriteCounter++;
			}else{
				spriteNum = 0;
			}
		}else if(keyH.downPressed == true) {
			gp.cChecker.checkTile(this);
			direction = "down";
			if(collisionOn == false) {
				worldY += speed;
				spriteCounter++;
			}else{
				spriteNum = 0;
			}
			
		}else if(keyH.rightPressed == true) {
			gp.cChecker.checkTile(this);
			direction = "right";
			if(collisionOn == false) {
				worldX += speed;
				spriteCounter++;				
			}else{
				spriteNum = 0;
			}
			
		}else if(keyH.leftPressed == true) {
			gp.cChecker.checkTile(this);
			direction = "left";
			if(collisionOn == false) {
				worldX -= speed;
				spriteCounter++;
			}else{
				spriteNum = 0;
			}
		}else {
			collisionOn = false;
			spriteNum = 0;
		}
		
		
		
		//merubah gerakan karakter perframe (ex : kaki kanan - kaki kiri)
		
		if(spriteCounter > 15) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
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
//		g2.drawImage(toolBar, gp.TILESIZE*5, gp.TILESIZE*12, 171*4, 18*4, null);
	}
}
