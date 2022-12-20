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
			gp.player.interactTile();
			}
		}
		

}
