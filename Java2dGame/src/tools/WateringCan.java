package tools;


import entity.Player;
import main.AssetSetter;
import main.GamePanel;
import input.KeyHandler;
import input.MouseHandler;
import objects.WetHoeedSoil;

public class WateringCan {
	GamePanel gp;
	KeyHandler keyH;
	MouseHandler mouseH;
	Player player;
	AssetSetter assetSetter;
	WetHoeedSoil wetHoeedSoil = new WetHoeedSoil();
	
	public WateringCan(GamePanel gp, KeyHandler keyH, MouseHandler mouseH, Player player, AssetSetter assetSetter) {
		this.gp = gp;
		this.keyH = keyH;
		this.player = player;
		this.assetSetter = assetSetter;
		this.mouseH = mouseH;
	}
	
	
	public void update() {
		
		if(mouseH.leftClick == true) {
			wetHoeedSoil = new WetHoeedSoil();
			int areaPlayerX = player.screenX;
			int areaPlayerY = player.screenY;
			int tileX = ((player.worldX + (gp.TILESIZE/2)) / gp.TILESIZE);
			int tileY = (player.worldY + gp.TILESIZE + gp.TILESIZE) / gp.TILESIZE;
			
			
			if(player.direction=="up" && (mouseH.mouseX >= areaPlayerX && mouseH.mouseX <= areaPlayerX+gp.TILESIZE) &&
			  (mouseH.mouseY >= areaPlayerY-gp.TILESIZE && mouseH.mouseY <= areaPlayerY)) {
				assetSetter.draw(wetHoeedSoil, tileX, tileY-2);
			}else if(player.direction=="down" && (mouseH.mouseX >= areaPlayerX && mouseH.mouseX <= areaPlayerX+gp.TILESIZE) &&
					(mouseH.mouseY >= areaPlayerY+gp.TILESIZE && mouseH.mouseY <= areaPlayerY+2*gp.TILESIZE)) {
				assetSetter.draw(wetHoeedSoil, tileX, tileY-1);
			}else if(player.direction=="left" && (mouseH.mouseX >= areaPlayerX-gp.TILESIZE && mouseH.mouseX <= areaPlayerX) &&
					(mouseH.mouseY >= areaPlayerY && mouseH.mouseY <= areaPlayerY+gp.TILESIZE)) {
				assetSetter.draw(wetHoeedSoil, tileX-1, tileY-1);
			}else if(player.direction=="right" && (mouseH.mouseX >= areaPlayerX+gp.TILESIZE && mouseH.mouseX <= areaPlayerX+2*gp.TILESIZE) &&
					(mouseH.mouseY >= areaPlayerY && mouseH.mouseY <= areaPlayerY+gp.TILESIZE)) {
				assetSetter.draw(wetHoeedSoil, tileX+1, tileY-1);
			}
		}
	}
	
	
}
