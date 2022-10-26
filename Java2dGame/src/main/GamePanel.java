package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tiles.TileManager;

public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTING
	final int ORIGINALTILESIZE = 16;
	final int SCALE = 3;
	
	public final int TILESIZE = ORIGINALTILESIZE * SCALE;
	public final int MAXSCREENCOL = 16;
	public final int MAXSCREENROW = 12;
	public final int SCREENWIDTH = TILESIZE * MAXSCREENCOL;
	public final int SCREENHEIGHT = TILESIZE * MAXSCREENROW;
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	
	Player player = new Player(this,keyH);
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //buffer dari gambar akan diselesaikan sebelum dibuka (diluar layar)
		
		//handler key
		this.addKeyListener(keyH);
		this.setFocusable(true);
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
		player.update();
	}
	
	//status karakter di display
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}
	
}
