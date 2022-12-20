package farm;

import main.GamePanel;
import objects.SuperObject;


public class Farm {
	
	GamePanel gp;
	
	public Farm(GamePanel gp) {
		this.gp = gp;
	}
	
	
	public void draw(Crop object, int tileX, int tileY) {
		String Name = new String();
		for(SuperObject i : gp.objects) {
			if(i.worldX/48 == tileX && i.worldY/48 == tileY) {
				Name = i.name; 
			}
		}
		for(Crop i : gp.crops) {
			if(i.worldX/48 == tileX && i.worldY/48 == tileY) {
				Name = i.name;
			}
		}

		if(Name == "Wet_Hoeed_soil") {
			gp.crops.add(object);
			gp.crops.get(gp.objects.size()-1).worldX = tileX * gp.TILESIZE;
			gp.crops.get(gp.objects.size()-1).worldY = tileY * gp.TILESIZE;
		}


	}
	

}

