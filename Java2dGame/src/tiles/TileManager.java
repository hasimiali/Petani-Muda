package tiles;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	Tile[] tile;
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		
		getTileImage();
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int col = 0, row = 0, x = 0, y = 0;
		
		while(col < gp.MAXSCREENCOL && row < gp.MAXSCREENROW) {
			
			g2.drawImage(tile[0].image, x, y, gp.TILESIZE, gp.TILESIZE, null);
			col++;
			x += gp.TILESIZE;
			
			if(col == gp.MAXSCREENCOL) {
				col = 0;
				x = 0;
				row++;
				y += gp.TILESIZE;
			}
		}
		
	}
}
