package tools;

import entity.Player;
import main.GamePanel;
import input.MouseHandler;

public class Tools {
	GamePanel gp;
	Player player;
	MouseHandler mouseH;
	
	public Tools(GamePanel gp, MouseHandler mouseH, Player player) {
		this.gp = gp;
		this.player = player;
		this.mouseH = mouseH;
	}
	
	public void hitDetection() {
		
	}
}
