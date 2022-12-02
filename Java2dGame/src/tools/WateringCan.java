package tools;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.naming.TimeLimitExceededException;

import entity.Player;
import main.AssetSetter;
import main.GamePanel;
import main.KeyHandler;
import objects.HoeedSoil;
import objects.WetHoeedSoil;

public class WateringCan {
	GamePanel gp;
	KeyHandler keyH;
	Player player;
	AssetSetter assetSetter;
	WetHoeedSoil wetHoeedSoil = new WetHoeedSoil();
	
	public WateringCan(GamePanel gp, KeyHandler keyH, Player player, AssetSetter assetSetter) {
		this.gp = gp;
		this.keyH = keyH;
		this.player = player;
		this.assetSetter = assetSetter;
	}
	
	
	public void update() {
		if(keyH.jPressed == true) {
			wetHoeedSoil = new WetHoeedSoil();
			int tileX = ((player.worldX + (gp.TILESIZE/2))/48);
//			int tileY = ((player.worldY+(8+13)*gp.SCALE)/48);
			int tileY = (player.worldY+gp.TILESIZE+(gp.TILESIZE/2))/48;
			System.out.println("Posisi player x : " + tileX + " posisi player y : " + tileY);
			if(player.direction=="up") {
				assetSetter.draw(wetHoeedSoil, tileX, tileY-2);
				System.out.println(tileY-2);
			}else if(player.direction=="down") {
				assetSetter.draw(wetHoeedSoil, tileX, tileY);
				System.out.println(tileY);
			}else if(player.direction=="left") {
				assetSetter.draw(wetHoeedSoil, tileX-1, tileY-1);
			}else if(player.direction=="right")
				assetSetter.draw(wetHoeedSoil, tileX+1, tileY-1);
		}
	}
	
	
}
