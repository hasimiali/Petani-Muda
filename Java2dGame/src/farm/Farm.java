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
			//System.out.println("posisi : "+i.name + "x = "+ i.worldY/48 + " y = " + i.worldY/48);
			if(i.worldX/48 == tileX && i.worldY/48 == tileY) {
				Name = i.name; 
			}
		}
		for(Crop i : gp.crops) {
			//System.out.println("posisi : "+i.name + "x = "+ i.worldY/48 + " y = " + i.worldY/48);
			if(i.worldX/48 == tileX && i.worldY/48 == tileY) {
				System.out.println(i.name);
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

