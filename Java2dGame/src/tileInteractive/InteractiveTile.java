package tileInteractive;

import java.awt.Graphics2D;

import entity.Entity;
import main.GamePanel;

abstract public class InteractiveTile extends Entity{
	GamePanel gp;
	public boolean destructible = false;
	
	public InteractiveTile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
	}
	
	public void update() {
		
	}
	
	public abstract void draw(Graphics2D g2);
}
