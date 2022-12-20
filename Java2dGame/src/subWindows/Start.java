package subWindows;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import input.KeyHandler;

public class Start {
	GamePanel gp;
	KeyHandler keyH;
	int currentMenu, inputState=0;
	
	public BufferedImage startScreen, newSelected, newNotSelected, loadSelected, loadNotSelected, exitSelected, exitNotSelected, new_button, load_button, exit_button;
	
	public Start(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		currentMenu = 1;
		getPlayerImage();
	}
	
	public void getPlayerImage() {
		try {
			startScreen = ImageIO.read(getClass().getResourceAsStream("/windows/startScreen.jpg"));
			newSelected = ImageIO.read(getClass().getResourceAsStream("/windows/new_selected.png"));
			newNotSelected = ImageIO.read(getClass().getResourceAsStream("/windows/new_not_selected.png"));
			loadSelected = ImageIO.read(getClass().getResourceAsStream("/windows/load_selected.png"));
			loadNotSelected = ImageIO.read(getClass().getResourceAsStream("/windows/load_not_selected.png"));
			exitSelected = ImageIO.read(getClass().getResourceAsStream("/windows/exit_selected.png"));
			exitNotSelected = ImageIO.read(getClass().getResourceAsStream("/windows/exit_not_selected.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		//perpindahan current menu
		if(inputState==0 && currentMenu<=3 && currentMenu >=1) {
			if(keyH.leftPressed==true && currentMenu>1) {
				currentMenu-=1;
				inputState=1;
				System.out.println(currentMenu);
			}
			if(keyH.rightPressed==true && currentMenu<3) {
				currentMenu+=1;
				inputState=1;
				System.out.println(currentMenu);
			}
		}
		else if(inputState==1) {
			if(keyH.upPressed == false && keyH.downPressed == false && keyH.leftPressed == false && keyH.rightPressed == false) {
				inputState=0;
			}
		}
		
		if(currentMenu==1 && keyH.enter == true) {
			gp.gameState = gp.playState;
		}

	}
	
	public void draw(Graphics2D g2) {
		new_button = newNotSelected;
		load_button = loadNotSelected;
		exit_button = exitNotSelected;

		switch(currentMenu){
		case 1:
			new_button = newSelected;
			load_button = loadNotSelected;
			exit_button = exitNotSelected;
			break;
		case 2:
			new_button = newNotSelected;
			load_button = loadSelected;
			exit_button = exitNotSelected;
			break;
		case 3:
			new_button = newNotSelected;
			load_button = loadNotSelected;
			exit_button = exitSelected;
			break;
		}
		
		
		g2.drawImage(startScreen, 0, 0, gp.SCREENWIDTH, gp.SCREENHEIGHT, null);
		g2.drawImage(new_button, 150, 450, 230, 160, null);
		g2.drawImage(load_button, 380, 450, 230, 160, null);
		g2.drawImage(exit_button, 610, 450, 230, 160, null);
	
	
	}
}


