package tools;

import entity.Player;
import farm.Crop;
import main.AssetSetter;
import main.GamePanel;
import input.KeyHandler;
import input.MouseHandler;
import objects.HoeedSoil;

public class Watch {
	GamePanel gp;
	KeyHandler keyH;
	MouseHandler mouseH;
	Player player;
	AssetSetter assetSetter;
	HoeedSoil hoeedSoil;
	int inputState=0;
	
	public Watch(GamePanel gp, KeyHandler keyH, MouseHandler mouseH, Player player, AssetSetter assetSetter) {
		this.gp = gp;
		this.keyH = keyH;
		this.player = player;
		this.assetSetter = assetSetter;
		this.mouseH = mouseH;
	}
	
	public void update() {
			if(inputState==0 && mouseH.leftClick == true) {
				inputState=1;
					for(Crop i : gp.crops) {
						if(i!= null&&i.growState<4) {
								i.growState++;
						}
					}
				}

			else if(inputState==1&&mouseH.leftClick==false) {
				if(keyH.jPressed == false ) {
					inputState=0;
				}
			}


		}
		

}

