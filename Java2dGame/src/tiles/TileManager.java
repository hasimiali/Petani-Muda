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
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[2600];
		mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/WorldPetaniMuda.txt");
	}
	
	public void getTileImage() {
		
		try {
			
			for(int i=0; i<2500; i++) {
				String path = "/world/MapPetaniMuda_" + i + ".png";
				
				tile[i] = new Tile();
				tile[i].image = ImageIO.read(getClass().getResourceAsStream(path));
			}
			
			//collision MAP KIRI
			tile[29].collision = true;
			tile[79].collision = true;
			tile[129].collision = true;
			tile[179].collision = true;
			tile[229].collision = true;
			tile[279].collision = true;
			tile[329].collision = true;
			tile[379].collision = true;//
			tile[428].collision = true;
			tile[427].collision = true;
			tile[426].collision = true;//
			tile[475].collision = true;
			tile[474].collision = true;
			tile[473].collision = true;
			tile[472].collision = true;
			tile[471].collision = true;
			tile[470].collision = true;
			tile[469].collision = true;//
			tile[419].collision = true;
			tile[368].collision = true;//
			tile[367].collision = true;
			tile[416].collision = true;
			tile[466].collision = true;//
			tile[465].collision = true;
			tile[464].collision = true;
			tile[463].collision = true;
			tile[462].collision = true;
			tile[461].collision = true;
			tile[410].collision = true;//
			tile[459].collision = true;//samping kiri
			tile[509].collision = true;
			tile[559].collision = true;
			tile[609].collision = true;
			tile[659].collision = true;
			tile[709].collision = true;
			tile[759].collision = true;
			tile[809].collision = true;//
			tile[808].collision = true;
			tile[807].collision = true;
			tile[856].collision = true;
			tile[906].collision = true;//
			tile[957].collision = true;
			tile[958].collision = true;
			tile[959].collision = true;
			tile[960].collision = true;
			tile[961].collision = true;//
			tile[1011].collision = true;
			tile[1061].collision = true;
			tile[1111].collision = true;//
			tile[1162].collision = true;
			tile[1163].collision = true;
			tile[1164].collision = true;
			tile[1165].collision = true;
			tile[1166].collision = true;//
			tile[1216].collision = true;
			tile[1266].collision = true;
			tile[1316].collision = true;
			tile[1366].collision = true;
			tile[1416].collision = true;
			tile[1466].collision = true;
			tile[1516].collision = true;
			tile[1566].collision = true;
			tile[1615].collision = true;
			tile[1664].collision = true;
			tile[1713].collision = true;//
			tile[1712].collision = true;
			tile[1711].collision = true;
			tile[1710].collision = true;//
			tile[1759].collision = true;
			tile[1758].collision = true;
			tile[1757].collision = true;//
			tile[1806].collision = true;
			tile[1805].collision = true;
			tile[1804].collision = true;
			tile[1853].collision = true;//
			tile[1903].collision = true;
			tile[1953].collision = true;
			tile[2003].collision = true;
			tile[2053].collision = true;//
			tile[2102].collision = true;
			tile[2152].collision = true;
			tile[2202].collision = true;
			tile[2252].collision = true;
			tile[2302].collision = true;//
			tile[2353].collision = true;
			tile[2354].collision = true;
			tile[2355].collision = true;
			tile[2356].collision = true;
			tile[2357].collision = true;
			tile[2358].collision = true;
			tile[2359].collision = true;
			tile[2360].collision = true;
			tile[2361].collision = true;
			tile[2362].collision = true;
			tile[2363].collision = true;
			tile[2364].collision = true;
			tile[2365].collision = true;
			tile[2366].collision = true;
			tile[2367].collision = true;
			tile[2368].collision = true;
			tile[2369].collision = true;
			tile[2370].collision = true;
			tile[2371].collision = true;//
			tile[2421].collision = true;
			tile[2471].collision = true;
			//collision MAP KANAN
			tile[2477].collision = true;
			tile[2427].collision = true;
			tile[2377].collision = true;//
			tile[2378].collision = true;
			tile[2379].collision = true;
			tile[2380].collision = true;
			tile[2381].collision = true;
			tile[2382].collision = true;
			tile[2383].collision = true;
			tile[2384].collision = true;
			tile[2335].collision = true;
			tile[2285].collision = true;//
			tile[2286].collision = true;
			tile[2287].collision = true;
			tile[2288].collision = true;
			tile[2289].collision = true;
			tile[2290].collision = true;
			tile[2291].collision = true;
			tile[2292].collision = true;
			tile[2293].collision = true;
			tile[2294].collision = true;
			tile[2295].collision = true;
			tile[2345].collision = true;
			tile[2396].collision = true;//
			tile[2397].collision = true;
			tile[2398].collision = true;
			tile[2399].collision = true;//
			//air bawah
			tile[1635].collision = true;
			tile[1636].collision = true;
			tile[1637].collision = true;
			tile[1638].collision = true;
			tile[1639].collision = true;
			tile[1590].collision = true;//
			tile[1591].collision = true;
			tile[1592].collision = true;
			tile[1593].collision = true;
			tile[1594].collision = true;
			tile[1595].collision = true;//
			tile[1645].collision = true;
			tile[1695].collision = true;
			tile[1745].collision = true;
			tile[1795].collision = true;
			tile[1845].collision = true;//
			tile[1844].collision = true;
			tile[1843].collision = true;
			tile[1842].collision = true;
			tile[1841].collision = true;
			tile[1840].collision = true;
			tile[1790].collision = true;
			tile[1739].collision = true;//
			tile[1738].collision = true;
			tile[1737].collision = true;
			tile[1736].collision = true;
			tile[1735].collision = true;
			tile[1685].collision = true;
			//rumah
			tile[1231].collision = true;
			tile[1281].collision = true;
			tile[1331].collision = true;
			tile[1381].collision = true;
			tile[1431].collision = true;//
			tile[1432].collision = true;
			tile[1433].collision = true;
			tile[1384].collision = true;//pintu object
			tile[1385].collision = true;
			tile[1436].collision = true;
			tile[1437].collision = true;
			tile[1438].collision = true;//
			tile[1388].collision = true;
			tile[1338].collision = true;
			tile[1288].collision = true;
			tile[1238].collision = true;
			tile[1237].collision = true;
			tile[1186].collision = true;
			tile[1135].collision = true;
			tile[1134].collision = true;
			tile[1183].collision = true;
			tile[1232].collision = true;
			//air terjun
			tile[898].collision = true;
			tile[897].collision = true;
			tile[896].collision = true;
			tile[895].collision = true;
			tile[894].collision = true;
			tile[893].collision = true;
			tile[892].collision = true;
			tile[891].collision = true;
			tile[890].collision = true;
			tile[889].collision = true;
			tile[888].collision = true;
			tile[887].collision = true;
			tile[886].collision = true;
			tile[885].collision = true;
			tile[835].collision = true;
			tile[781].collision = true;//jembatan
			tile[782].collision = true;
			tile[783].collision = true;
			tile[784].collision = true;
			tile[785].collision = true;
			tile[786].collision = true;
			tile[787].collision = true;
			tile[738].collision = true;
			tile[688].collision = true;
			tile[638].collision = true;
			tile[587].collision = true;
			tile[586].collision = true;
			tile[585].collision = true;
			tile[535].collision = true;
			tile[536].collision = true;
			tile[487].collision = true;
			tile[437].collision = true;
			tile[438].collision = true;
			tile[389].collision = true;
			tile[339].collision = true;
			tile[288].collision = true;//
			tile[287].collision = true;
			tile[236].collision = true;//
			tile[186].collision = true;
			tile[136].collision = true;
			tile[86].collision = true;
			tile[36].collision = true;//
			tile[848].collision = true;
			tile[847].collision = true;
			tile[796].collision = true;
			tile[747].collision = true;
			tile[748].collision = true;
			tile[698].collision = true;
			tile[649].collision = true;
			
			
			
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
			
			//menggambar world hanya pada saat player bergerak, tidak menggambar semua world
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
