package tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	private GamePanel gp;
	private Tile[] tile;
	private int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map_ex2.txt");
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Dirt.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/stone wall.jpg"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_corner.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt_cliff.png"));
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_grass.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0, row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
			}
			
			br.close();
		} catch (Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int worldCol = 0, worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.TILESIZE;
			int worldY = worldRow * gp.TILESIZE;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.TILESIZE > gp.player.worldX - gp.player.screenX &&
					worldX - gp.TILESIZE < gp.player.worldX + gp.player.screenX &&
					worldY + gp.TILESIZE > gp.player.worldY - gp.player.screenY &&
					worldY - gp.TILESIZE < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.TILESIZE, gp.TILESIZE, null);
			}
			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
		
	}
}
