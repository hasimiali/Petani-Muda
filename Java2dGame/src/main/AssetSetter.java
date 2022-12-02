package main;

import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;
import java.util.jar.Attributes.Name;

import objects.Chest;
import objects.EntranceHouse;
import objects.HoeedSoil;
import objects.SuperObject;
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
		gp.objects.add(new EntranceHouse());
		gp.objects.get(0).worldX = 34 * gp.TILESIZE;
		gp.objects.get(0).worldY = 25 * gp.TILESIZE;
		
		for(int i=1; i<7; i++) {
			gp.objects.add(new Tree1());
			gp.objects.get(i).worldX = randInt(4, 34) * gp.TILESIZE;
			gp.objects.get(i).worldY = randInt(37, 40) * gp.TILESIZE;
		}
		
//		gp.objects.add(new HoeedSoil());
//		gp.objects.get(7).worldX = 23 * gp.TILESIZE;
//		gp.objects.get(7).worldY = 22 * gp.TILESIZE;
		
		
	}
	
	private int randInt(int min, int max) {
		int randNum = ThreadLocalRandom.current().nextInt(min,max+1);
		return randNum;
	}
	
	public void draw(SuperObject object, int tileX, int tileY) {
		int counter = 0;
		String Name = new String();
		for(SuperObject i : gp.objects) {
			System.out.println("posisi : "+i.name + "x = "+ i.worldY/48 + " y = " + i.worldY/48);
			if(i.worldX/48 == tileX && i.worldY/48 == tileY) {
				Name = i.name; 
				System.out.println("ada object di tile itu");

				counter++;
				break;
			}
		}
		if(counter==0&&object.name=="Hoeed_soil") {
			gp.objects.add(object);
			gp.objects.get(gp.objects.size()-1).worldX = tileX * gp.TILESIZE;
			gp.objects.get(gp.objects.size()-1).worldY = tileY * gp.TILESIZE;
		}
		else if(counter==1&&Name=="Hoeed_soil"&&object.name=="Wet_Hoeed_soil") {
			System.out.println("ada 1 object");
			gp.objects.add(object);
			gp.objects.get(gp.objects.size()-1).worldX = tileX * gp.TILESIZE;
			gp.objects.get(gp.objects.size()-1).worldY = tileY * gp.TILESIZE;
		}
	}
	
//	public void update(Graphics2D g2) {
//		for(int i = 7; i<gp.objects.size(); i++) {
//			gp.objects.get(i).draw(gp, g2);
//		}
//	}
}
