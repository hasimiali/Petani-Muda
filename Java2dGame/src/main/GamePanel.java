package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;

import entity.Player;
import objects.SuperObject;
import subWindows.ToolBar;
import tiles.TileManager;
import tools.Hoe;

public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTING
	final int ORIGINALTILESIZE = 16;
	public final int SCALE = 3;
	
	public final int TILESIZE = ORIGINALTILESIZE * SCALE;
	public final int MAXSCREENCOL = 24;
	public final int MAXSCREENROW = 18;
	public final int SCREENWIDTH = TILESIZE * MAXSCREENCOL;
	public final int SCREENHEIGHT = TILESIZE * MAXSCREENROW;
	
	//WORLD SETTING
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 49;
	public final int worldWidth = TILESIZE * maxWorldCol;
	public final int worldHeight = TILESIZE * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;
	
	//COLLISION
	public CollisionChecker cChecker = new CollisionChecker(this);
	//ASSET SETTER
	public AssetSetter aSetter = new AssetSetter(this);
	//PLAYER
	public Player player = new Player(this,keyH);
	//OBJECT
	public ArrayList<SuperObject> objects = new ArrayList<SuperObject>();
	//UI
	public UI ui = new UI(this);
	//ToolBar
	public ToolBar toolBar = new ToolBar(this, keyH);
	//test hoe
	public Hoe hoe = new Hoe(this, keyH, player, aSetter);
	
	//GAME STATE
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int characterState = 3;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //buffer dari gambar akan diselesaikan sebelum dibuka (diluar layar)
		
		//handler key
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void setupGame() {
		
		aSetter.setObject();
		
		gameState = playState;
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//Game Loop delta
	@Override
	public void run() {
		
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		double lastTime = System.nanoTime();
		double currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
		
	}
	
	//menggerakkan karakter
	public void update() {
		if(gameState == playState) {
			player.update();
			toolBar.update();
			hoe.update();
		}
		if(gameState == pauseState) {
			//NOTHING
		}
		if(gameState == characterState) {
			//NOTHING
		}
				
	}
	
	//status karakter di display
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//tile
		tileM.draw(g2);
		//object
		for(SuperObject i : objects) {
			if(i!= null) {
				i.draw(this, g2);
			}
		}
		
		
		//player
		player.draw(g2);
		toolBar.draw(g2);
		ui.draw(g2);
		
		g2.dispose();
	}
	
}
