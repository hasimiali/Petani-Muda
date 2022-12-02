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

public class Hoe {
	GamePanel gp;
	KeyHandler keyH;
	Player player;
	AssetSetter assetSetter;
	HoeedSoil hoeedSoil;
	public Hoe(GamePanel gp, KeyHandler keyH, Player player, AssetSetter assetSetter) {
		this.gp = gp;
		this.keyH = keyH;
		this.player = player;
		this.assetSetter = assetSetter;
	}
	
	
	public void update() {
		if(keyH.jPressed == true) {
			hoeedSoil = new HoeedSoil();
			int tileX = ((player.worldX+8*gp.SCALE)/48);
			int tileY = ((player.worldY+(8+13)*gp.SCALE)/48);
			System.out.println("Posisi player x : " + tileX + " posisi player y : " + tileY);
			if(player.direction=="up") {
				assetSetter.draw(hoeedSoil, tileX, tileY-1);
				System.out.println(tileY-1);
			}else if(player.direction=="down") {
				assetSetter.draw(hoeedSoil, tileX, tileY+1);
				System.out.println(tileY+1);
			}
				
			else if(player.direction=="left")
				assetSetter.draw(hoeedSoil, tileX-1, tileY);
			else if(player.direction=="right")
				assetSetter.draw(hoeedSoil, tileX+1, tileY);
		}
	}
	
	
}
