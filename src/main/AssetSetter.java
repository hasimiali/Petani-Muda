package main;

import java.util.concurrent.ThreadLocalRandom;
import objects.EntranceHouse;
import objects.SuperObject;
import tileInteractive.It_Tree1;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.objects.add(new EntranceHouse());
		gp.objects.get(0).worldX = 34 * gp.TILESIZE;
		gp.objects.get(0).worldY = 25 * gp.TILESIZE;
		
	}
	
	private int randInt(int min, int max) {
		int randNum = ThreadLocalRandom.current().nextInt(min,max+1);
		return randNum;
	}
	
	public void draw(SuperObject object, int tileX, int tileY) {
		int counter = 0;
		String Name = new String();
		for(SuperObject i : gp.objects) {
			if(i.worldX/48 == tileX && i.worldY/48 == tileY) {
				Name = i.name; 

				counter++;
			}
		}
		if(counter == 0 && object.name == "Hoeed_soil") {
			gp.objects.add(object);
			gp.objects.get(gp.objects.size()-1).worldX = tileX * gp.TILESIZE;
			gp.objects.get(gp.objects.size()-1).worldY = tileY * gp.TILESIZE;
		}
		else if(counter==1 && Name=="Hoeed_soil" && object.name == "Wet_Hoeed_soil") {
			gp.objects.add(object);
			gp.objects.get(gp.objects.size()-1).worldX = tileX * gp.TILESIZE;
			gp.objects.get(gp.objects.size()-1).worldY = tileY * gp.TILESIZE;
		}
	}
	
	public void setInteractiveTile() {
		for(int i = 0; i < 10; i++) {
			gp.iTile[i] = new It_Tree1(gp, randInt(4, 39), randInt(37, 40));
		}
	}
}
