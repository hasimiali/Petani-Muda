package main;

import java.util.concurrent.ThreadLocalRandom;

import objects.Chest;
import objects.EntranceHouse;
import objects.Tree1;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
//		gp.objects[0] = new Chest();
//		gp.objects[0].worldX = 28 * gp.TILESIZE;
//		gp.objects[0].worldY = 26 * gp.TILESIZE;
//		
		gp.objects[0] = new EntranceHouse();
		gp.objects[0].worldX = 34 * gp.TILESIZE;
		gp.objects[0].worldY = 25 * gp.TILESIZE;
		
		for(int i=1; i<7; i++) {
			gp.objects[i] = new Tree1();
			gp.objects[i].worldX = randInt(4, 34) * gp.TILESIZE;
			gp.objects[i].worldY = randInt(37, 40) * gp.TILESIZE;
		}
		
	}
	
	private int randInt(int min, int max) {
		int randNum = ThreadLocalRandom.current().nextInt(min,max+1);
		return randNum;
	}
}
