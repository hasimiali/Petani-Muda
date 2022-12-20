package tools;


import entity.Player;
import farm.Farm;
import farm.Seed1;
import main.GamePanel;
import input.KeyHandler;
import input.MouseHandler;


public class BagOfSeed1 {
	GamePanel gp;
	KeyHandler keyH;
	MouseHandler mouseH;
	Player player;
	Farm farm;
	Seed1 seed1;
	
	public BagOfSeed1(GamePanel gp, KeyHandler keyH, MouseHandler mouseH, Player player, Farm farm) {
		this.gp = gp;
		this.keyH = keyH;
		this.player = player;
		this.farm = farm;
		this.mouseH = mouseH;
	}
	
	public void update() {
		
		if(mouseH.leftClick == true) {
			seed1 = new Seed1();
			int areaPlayerX = player.screenX;
			int areaPlayerY = player.screenY;
			int tileX = ((player.worldX + (gp.TILESIZE/2)) / gp.TILESIZE);
			int tileY = (player.worldY + gp.TILESIZE + gp.TILESIZE) / gp.TILESIZE;
			
			System.out.println(areaPlayerX + " " + areaPlayerY + " " + mouseH.mouseX + " " + mouseH.mouseY);
			
			//System.out.println("Left Click" + " " + areaPlayerX + " " + areaPlayerY);
			if(player.direction=="up" && (mouseH.mouseX >= areaPlayerX && mouseH.mouseX <= areaPlayerX+gp.TILESIZE) &&
			  (mouseH.mouseY >= areaPlayerY-gp.TILESIZE && mouseH.mouseY <= areaPlayerY)) {
				farm.draw(seed1, tileX, tileY-2);
			}else if(player.direction=="down" && (mouseH.mouseX >= areaPlayerX && mouseH.mouseX <= areaPlayerX+gp.TILESIZE) &&
					(mouseH.mouseY >= areaPlayerY+gp.TILESIZE && mouseH.mouseY <= areaPlayerY+2*gp.TILESIZE)) {
				farm.draw(seed1, tileX, tileY-1);
			}else if(player.direction=="left" && (mouseH.mouseX >= areaPlayerX-gp.TILESIZE && mouseH.mouseX <= areaPlayerX) &&
					(mouseH.mouseY >= areaPlayerY && mouseH.mouseY <= areaPlayerY+gp.TILESIZE)) {
				farm.draw(seed1, tileX-1, tileY-1);
			}else if(player.direction=="right" && (mouseH.mouseX >= areaPlayerX+gp.TILESIZE && mouseH.mouseX <= areaPlayerX+2*gp.TILESIZE) &&
					(mouseH.mouseY >= areaPlayerY && mouseH.mouseY <= areaPlayerY+gp.TILESIZE)) {
				farm.draw(seed1, tileX+1, tileY-1);
			}
		}
		
		
	}
	
	public void cobaMouse() {
//		if(mouseH.leftClick == true) {
//			hoeedSoil = new HoeedSoil();
//			int areaPlayerX = player.screenX;
//			int areaPlayerY = player.screenY;
//			int tileX = ((player.worldX + (gp.TILESIZE/2)) / gp.TILESIZE);
//			int tileY = (player.worldY + gp.TILESIZE + gp.TILESIZE) / gp.TILESIZE;
//			
//			System.out.println(areaPlayerX + " " + areaPlayerY + " " + mouseH.mouseX + " " + mouseH.mouseY);
//			
//			//System.out.println("Left Click" + " " + areaPlayerX + " " + areaPlayerY);
//			if(player.direction=="up" && (mouseH.mouseX >= areaPlayerX && mouseH.mouseX <= areaPlayerX+gp.TILESIZE) &&
//			  (mouseH.mouseY >= areaPlayerY-gp.TILESIZE && mouseH.mouseY <= areaPlayerY)) {
//				assetSetter.draw(hoeedSoil, tileX, tileY-2);
//			}else if(player.direction=="down" && (mouseH.mouseX >= areaPlayerX && mouseH.mouseX <= areaPlayerX+gp.TILESIZE) &&
//					(mouseH.mouseY >= areaPlayerY+gp.TILESIZE && mouseH.mouseY <= areaPlayerY+2*gp.TILESIZE)) {
//				assetSetter.draw(hoeedSoil, tileX, tileY-1);
//			}else if(player.direction=="left" && (mouseH.mouseX >= areaPlayerX-gp.TILESIZE && mouseH.mouseX <= areaPlayerX) &&
//					(mouseH.mouseY >= areaPlayerY && mouseH.mouseY <= areaPlayerY+gp.TILESIZE)) {
//				assetSetter.draw(hoeedSoil, tileX, tileY-1);
//			}else if(player.direction=="right" && (mouseH.mouseX >= areaPlayerX+gp.TILESIZE && mouseH.mouseX <= areaPlayerX+2*gp.TILESIZE) &&
//					(mouseH.mouseY >= areaPlayerY && mouseH.mouseY <= areaPlayerY+gp.TILESIZE)) {
//				assetSetter.draw(hoeedSoil, tileX+1, tileY-1);
//			}
//		}
	}
}


