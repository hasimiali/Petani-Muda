package subWindows;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import input.KeyHandler;

public class ToolBar {
	GamePanel gp;
	KeyHandler keyH;
	int currentItem;
	
	public BufferedImage toolBar, activeToolBar, woodenHoe, watering_can, wooden_axe, bag_of_seeds, watch;
	
	public ToolBar(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		currentItem = 1;
		getPlayerImage();
	}
	
	public void getPlayerImage() {
		try {
			toolBar = ImageIO.read(getClass().getResourceAsStream("/windows/toolbar.png"));
			activeToolBar = ImageIO.read(getClass().getResourceAsStream("/windows/active_toolbar.png"));
			woodenHoe = ImageIO.read(getClass().getResourceAsStream("/tools/wooden_hoe.png"));
			watering_can = ImageIO.read(getClass().getResourceAsStream("/tools/watering_can.png"));
			wooden_axe = ImageIO.read(getClass().getResourceAsStream("/tools/wooden_axe.png"));
			bag_of_seeds = ImageIO.read(getClass().getResourceAsStream("/tools/bag_of_seeds.png"));
			watch = ImageIO.read(getClass().getResourceAsStream("/tools/watch.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		//merubah item nomor berapa yang dipegang
		if(keyH.pressed1==true) {
			currentItem = 1;
		}
		else if(keyH.pressed2==true){
			 currentItem = 2;
		}
		else if(keyH.pressed3==true){
			 currentItem = 3;
		}
		else if(keyH.pressed4==true){
			 currentItem = 4;
		}
		else if(keyH.pressed5==true){
			 currentItem = 5;
		}
		else if(keyH.pressed6==true){
			 currentItem = 6;
		}
		else if(keyH.pressed7==true){
			 currentItem = 7;
		}
		else if(keyH.pressed8==true){
			 currentItem = 8;
		}
		else if(keyH.pressed9==true){
			 currentItem = 9;
		}
		else if(keyH.pressed0==true){
			 currentItem = 0;
		}	
	}
	
public void draw(Graphics2D g2) {
		
		int currentItemX = (gp.TILESIZE*5)+1, currentItemY=(gp.TILESIZE*12)+1;
		switch(currentItem){
		case 1:
			currentItemX=(gp.TILESIZE*3)+4;
			currentItemY=(gp.TILESIZE*12)+4;
			gp.hoe.update();
			break;
		case 2:
			currentItemX=(gp.TILESIZE*3)+(16*4)+4*2;
			currentItemY=(gp.TILESIZE*12)+4;
			gp.wateringCan.update();
			break;
		case 3:
			currentItemX=(gp.TILESIZE*3)+2*(16*4)+4*3;
			currentItemY=(gp.TILESIZE*12)+4;
			gp.axe.update();
			break;
		case 4:
			currentItemX=(gp.TILESIZE*3)+3*(16*4)+4*4;
			currentItemY=(gp.TILESIZE*12)+4;
			gp.bagOfSeed1.update();
			break;
		case 5:
			currentItemX=(gp.TILESIZE*3)+4*(16*4)+4*5;
			currentItemY=(gp.TILESIZE*12)+4;
			break;
		case 6:
			currentItemX=(gp.TILESIZE*3)+5*(16*4)+4*6;
			currentItemY=(gp.TILESIZE*12)+4;
			break;
		case 7:
			currentItemX=(gp.TILESIZE*3)+6*(16*4)+4*7;
			currentItemY=(gp.TILESIZE*12)+4;
			break;
		case 8:
			currentItemX=(gp.TILESIZE*3)+7*(16*4)+4*8;
			currentItemY=(gp.TILESIZE*12)+4;
			break;
		case 9:
			currentItemX=(gp.TILESIZE*3)+8*(16*4)+4*9;
			currentItemY=(gp.TILESIZE*12)+4;
			break;
		case 0:
			currentItemX=(gp.TILESIZE*3)+9*(16*4)+4*10;
			currentItemY=(gp.TILESIZE*12)+4;
			gp.watch.update();
			break;

		}
		
		
		g2.drawImage(toolBar, gp.TILESIZE*3, gp.TILESIZE*12, 171*4, 18*4, null);
		g2.drawImage(activeToolBar, currentItemX, currentItemY, 16*4, 16*4, null);
		
		//draw item didalam toolbars
		//toolbar 1
		g2.drawImage(woodenHoe, (gp.TILESIZE*3)+4, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
		
		//toolbar 2
		g2.drawImage(watering_can, (gp.TILESIZE*3)+(16*4)+4*2, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
		
		//toolbar 3
		g2.drawImage(wooden_axe, (gp.TILESIZE*3)+2*(16*4)+4*3, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
		
		//toolbar 4
		g2.drawImage(bag_of_seeds, (gp.TILESIZE*3)+3*(16*4)+4*4, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
//		
//		//toolbar 5
//		g2.drawImage(woodenHoe, (gp.TILESIZE*5)+4*(16*4)+4*5, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
//		
//		//toolbar 6
//		g2.drawImage(woodenHoe, (gp.TILESIZE*5)+5*(16*4)+4*6, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
//		
//		//toolbar 7
//		g2.drawImage(woodenHoe, (gp.TILESIZE*5)+6*(16*4)+4*7, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
//		
//		//toolbar 8
//		g2.drawImage(woodenHoe, (gp.TILESIZE*5)+7*(16*4)+4*8, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
//		
//		//toolbar 9
//		g2.drawImage(woodenHoe, (gp.TILESIZE*5)+8*(16*4)+4*9, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
//		
		//toolbar 10
		g2.drawImage(watch, (gp.TILESIZE*3)+9*(16*4)+4*10, (gp.TILESIZE*12)+4, 16*4, 16*4, null);
	}
}
