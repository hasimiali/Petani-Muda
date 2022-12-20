package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class UI {
	GamePanel gp;
	Font arial_40;
	Graphics2D g2;
	
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 100);
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		if(gp.gameState == gp.playState) {
			// Do playstate stuff
//			drawToolBar();
		}
		if(gp.gameState == gp.pauseState) {
			g2.drawString("PAUSE", gp.TILESIZE*9, gp.TILESIZE*7);
		}
		if(gp.gameState == gp.characterState) {
			g2.drawString("CHARACTER", 50, 50);
		}
		
	}
	
	public void drawToolBar() {
		int x = gp.TILESIZE*2;
		int y = gp.TILESIZE*11;
		int width = gp.TILESIZE*20;
		int height = gp.TILESIZE*2;
		
		Color c = new Color(0, 0, 0, 200);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255, 255, 255);
		g2.setColor(c);
		
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
		
	}
}
