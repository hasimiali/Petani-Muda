package main;

import entity.Entity;

public class CollisionChecker {
	
	private GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity player) {
		
		int entityLeftWorldX = player.worldX + player.solidArea.x;
		int entityRightWorldX = player.worldX + player.solidArea.x + player.solidArea.width;
		int entityTopWorldY = player.worldY + player.solidArea.y;
		int entityBottomWorldY = player.worldY + player.solidArea.y + player.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX / gp.TILESIZE;
		int entityRightCol = entityRightWorldX / gp.TILESIZE;
		int entityTopRow = entityTopWorldY / gp.TILESIZE;
		int entityBottomRow = entityBottomWorldY / gp.TILESIZE;
		
		int tileNum1, tileNum2;
		
		switch(player.direction) {
		case "up" :
			entityTopRow = (entityTopWorldY - player.speed) / gp.TILESIZE;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				player.collisionOn = true;
			}
			break;
		case "down" :
			entityBottomRow = (entityBottomWorldY + player.speed) / gp.TILESIZE;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				player.collisionOn = true;
			}
			break;
		case "right" :
			entityRightCol = (entityRightWorldX + player.speed) / gp.TILESIZE;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				player.collisionOn = true;
			}
			break;
		case "left" :
			entityLeftCol = (entityLeftWorldX - player.speed) / gp.TILESIZE;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				player.collisionOn = true;
			}
			break;
		}
	}
	
	public int checkObject(Entity entity, boolean player) {
		int index = 999;
		
		for(int i=0; i<gp.objects.size(); i++) {
			if(gp.objects != null) {
				//solid area player position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				//solid area object position
				gp.objects.get(i).solidArea.x = gp.objects.get(i).worldX + gp.objects.get(i).solidArea.x;
				gp.objects.get(i).solidArea.y = gp.objects.get(i).worldY + gp.objects.get(i).solidArea.y;
				
				switch (entity.direction) {
					case "up":
						entity.solidArea.y -= entity.speed;
						if(entity.solidArea.intersects(gp.objects.get(i).solidArea)) {
							if(gp.objects.get(i).collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}
						break;
					case "down":
						entity.solidArea.y += entity.speed;
						if(entity.solidArea.intersects(gp.objects.get(i).solidArea)) {
							if(gp.objects.get(i).collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}
						break;
					case "right":
						entity.solidArea.x += entity.speed;
						if(entity.solidArea.intersects(gp.objects.get(i).solidArea)) {
							if(gp.objects.get(i).collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						}
						break;
					case "left":
						entity.solidArea.x -= entity.speed;
						if(entity.solidArea.intersects(gp.objects.get(i).solidArea)) {
							if(gp.objects.get(i).collision == true) {
								entity.collisionOn = true;
							}
							if(player == true) {
								index = i;
							}
						break;
						}
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.objects.get(i).solidArea.x = gp.objects.get(i).solidAreaDefaultX;
				gp.objects.get(i).solidArea.y = gp.objects.get(i).solidAreaDefaultY;
			}
		}
		return index;
	}
	
	//Interactive tile collision
	public int checkEntity(Entity entity, Entity[] target) {
		int index = 999;
		
		for(int i=0; i<target.length ; i++) {
			if(target[i] != null) {
				//solid area player position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				switch (entity.direction) {
					case "up":
						entity.solidArea.y -= entity.speed;
						if(entity.solidArea.intersects(target[i].solidArea)) {
							entity.collisionOn = true;
							index = i;
							//System.out.println(index);
						}
						break;
					case "down":
						entity.solidArea.y += entity.speed;
						if(entity.solidArea.intersects(target[i].solidArea)) {
							entity.collisionOn = true;
							index = i;
						}
						break;
					case "right":
						entity.solidArea.x += entity.speed;
						if(entity.solidArea.intersects(target[i].solidArea)) {
							entity.collisionOn = true;
							index = i;
						}
						break;
					case "left":
						entity.solidArea.x -= entity.speed;
						if(entity.solidArea.intersects(target[i].solidArea)) {
							entity.collisionOn = true;
							index = i;
						}
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
//				target[i].solidArea.x = target[i].solidAreaDefaultX;
//				target[i].solidArea.y = target[i].solidAreaDefaultY;
			}
		}
		//System.out.println(index);
		return index;
	}
}
