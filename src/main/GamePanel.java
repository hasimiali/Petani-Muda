package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Player;
import farm.Crop;
import farm.Farm;
import input.KeyHandler;
import input.MouseHandler;
import objects.SuperObject;
import subWindows.Start;
import subWindows.ToolBar;
import tileInteractive.InteractiveTile;
import tiles.TileManager;
import tools.Axe;
import tools.BagOfSeed1;
import tools.Hoe;
import tools.Tools;
import tools.Watch;
import tools.WateringCan;

public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTING
	final int ORIGINALTILESIZE = 16;
	public final int SCALE = 3;
	
	public final int TILESIZE = ORIGINALTILESIZE * SCALE;
	public final int MAXSCREENCOL = 20;
	public final int MAXSCREENROW = 15;
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
	MouseHandler mouseH = new MouseHandler(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;

	
	//COLLISION
	public CollisionChecker cChecker = new CollisionChecker(this);
	//ASSET SETTER
	public AssetSetter aSetter = new AssetSetter(this);
	//Entity dan object
	public Player player = new Player(this,keyH);
	public ArrayList<SuperObject> objects = new ArrayList<SuperObject>();
	public InteractiveTile iTile[] = new InteractiveTile[50];
	//Farm
	public Farm farm = new Farm(this);
	//Crop
	public ArrayList<Crop> crops = new ArrayList<Crop>();
	//UI
	public UI ui = new UI(this);
	public ToolBar toolBar = new ToolBar(this, keyH);
	public Start startScreen = new Start(this, keyH);
	//Tools
	public Hoe hoe = new Hoe(this, keyH, mouseH, player, aSetter);
	public WateringCan wateringCan = new WateringCan(this, keyH, mouseH, player, aSetter);
	public Axe axe = new Axe(this, keyH, mouseH, player, aSetter);
	public Tools tool = new Tools(this, mouseH, player);
	public BagOfSeed1 bagOfSeed1 = new BagOfSeed1(this, keyH, mouseH, player, farm);
	public Watch watch = new Watch(this, keyH, mouseH, player, aSetter);
	
	//GAME STATE
	public int gameState;
	public final int startState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int characterState = 3;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //buffer dari gambar akan diselesaikan sebelum dibuka (diluar layar)
		
		//handler key
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		this.setFocusable(true);
		
	}
	
	public void setupGame() {
		
		aSetter.setObject();
		aSetter.setInteractiveTile();
		gameState = startState;
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
	
	//update game
	public void update() {
		if(gameState == startState) {
			startScreen.update();
		}
		if(gameState == playState) {
			player.update();
			toolBar.update();
			
			for(int i=0; i<iTile.length; i++) {
				if(iTile[i] != null) {
					iTile[i].update();
				}
			}
			
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
		if(gameState == startState) {
			startScreen.draw(g2);
		}else if(gameState == playState){
			tileM.draw(g2);
			
			//interactive object
			for(int i=0; i<iTile.length; i++) {
				if(iTile[i] != null) {
					iTile[i].draw(g2);
				}
			}
			//object
			for(SuperObject i : objects) {
				if(i!= null) {
					i.draw(this, g2);
				}
			}
			for(Crop i : crops) {
				if(i!= null) {
						i.draw(this, g2);
				}

			}
			//player
			player.draw(g2);
			toolBar.draw(g2);
		}
		
		g2.dispose();
	}
	
}
