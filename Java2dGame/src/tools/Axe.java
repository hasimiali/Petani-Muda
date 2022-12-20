package tools;

import entity.Player;
import main.AssetSetter;
import main.GamePanel;
import input.KeyHandler;
import input.MouseHandler;
import objects.HoeedSoil;

public class Axe {
	GamePanel gp;
	KeyHandler keyH;
	MouseHandler mouseH;
	Player player;
	AssetSetter assetSetter;
	HoeedSoil hoeedSoil;
	
	public Axe(GamePanel gp, KeyHandler keyH, MouseHandler mouseH, Player player, AssetSetter assetSetter) {
		this.gp = gp;
		this.keyH = keyH;
		this.player = player;
		this.assetSetter = assetSetter;
		this.mouseH = mouseH;
	}
	
	public void update() {
		
		if(mouseH.leftClick == true) {
			hoeedSoil = new HoeedSoil();
			int areaPlayerX = player.screenX;
			int areaPlayerY = player.screenY;
			int tileX = ((player.worldX + (gp.TILESIZE/2)) / gp.TILESIZE);
			int tileY = (player.worldY + gp.TILESIZE + gp.TILESIZE) / gp.TILESIZE;
			
			System.out.println(areaPlayerX + " " + areaPlayerY + " " + mouseH.mouseX + " " + mouseH.mouseY);
			
			//System.out.println("Left Click" + " " + areaPlayerX + " " + areaPlayerY);
			if(player.direction=="up" && (mouseH.mouseX >= areaPlayerX && mouseH.mouseX <= areaPlayerX+gp.TILESIZE) &&
			  (mouseH.mouseY >= areaPlayerY-gp.TILESIZE && mouseH.mouseY <= areaPlayerY)) {
				assetSetter.draw(hoeedSoil, tileX, tileY-2);
			}else if(player.direction=="down" && (mouseH.mouseX >= areaPlayerX && mouseH.mouseX <= areaPlayerX+gp.TILESIZE) &&
					(mouseH.mouseY >= areaPlayerY+gp.TILESIZE && mouseH.mouseY <= areaPlayerY+2*gp.TILESIZE)) {
				assetSetter.draw(hoeedSoil, tileX, tileY-1);
			}else if(player.direction=="left" && (mouseH.mouseX >= areaPlayerX-gp.TILESIZE && mouseH.mouseX <= areaPlayerX) &&
					(mouseH.mouseY >= areaPlayerY && mouseH.mouseY <= areaPlayerY+gp.TILESIZE)) {
				assetSetter.draw(hoeedSoil, tileX-1, tileY-1);
			}else if(player.direction=="right" && (mouseH.mouseX >= areaPlayerX+gp.TILESIZE && mouseH.mouseX <= areaPlayerX+2*gp.TILESIZE) &&
					(mouseH.mouseY >= areaPlayerY && mouseH.mouseY <= areaPlayerY+gp.TILESIZE)) {
				assetSetter.draw(hoeedSoil, tileX+1, tileY-1);
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
