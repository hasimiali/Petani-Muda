package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	public int worldX, worldY;
	private int speed;
	private BufferedImage up1, up2, up3, down1, down2, down3, right1, right2, right3, left1, left2, left3;
	private String direction;
	private int spriteCounter = 0;
	private int spriteNum = 1;
	
	public final int screenX, screenY;
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX  = gp.SCREENWIDTH/2 - (gp.TILESIZE/2);
		screenY = gp.SCREENHEIGHT/2 - (gp.TILESIZE/2);
		
		setDefaultValues();
		getPlayerImage();
	}
	
	//set player position
	public void setDefaultValues() {
		
		worldX = gp.TILESIZE * 15;
		worldY = gp.TILESIZE * 21;
		speed = 4;
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

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		//merubah posisi karakter sesuai arrow
		if(keyH.upPressed == true) {
			direction = "up";
			worldY -= speed;
			spriteCounter++;
		}else if(keyH.downPressed == true) {
			direction = "down";
			worldY += speed;
			spriteCounter++;
		}else if(keyH.rightPressed == true) {
			direction = "right";
			worldX += speed;
			spriteCounter++;
		}else if(keyH.leftPressed == true) {
			direction = "left";
			worldX -= speed;
			spriteCounter++;
		}else {
			//kondisi karakter berhenti (melepas arrow)
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
	}
}
