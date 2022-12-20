package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyHandler implements KeyListener{
	GamePanel gp;
	public boolean upPressed, downPressed, rightPressed, leftPressed, pressed1, 
		pressed2, pressed3, pressed4, pressed5, pressed6, pressed7, pressed8, 
		pressed9, pressed0, jPressed, enter;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();
		
		if(gp.gameState == gp.playState) {
			if(keyCode == KeyEvent.VK_W)
				upPressed = true;
			if(keyCode == KeyEvent.VK_S)
				downPressed = true;
			if(keyCode == KeyEvent.VK_D)
				rightPressed = true;
			if(keyCode == KeyEvent.VK_A)
				leftPressed = true;
			
			//NUMBER
			if(keyCode == KeyEvent.VK_1)
				pressed1 = true;
			if(keyCode == KeyEvent.VK_2)
				pressed2 = true;
			if(keyCode == KeyEvent.VK_3)
				pressed3 = true;
			if(keyCode == KeyEvent.VK_4)
				pressed4 = true;
			if(keyCode == KeyEvent.VK_5)
				pressed5 = true;
			if(keyCode == KeyEvent.VK_6)
				pressed6 = true;
			if(keyCode == KeyEvent.VK_7)
				pressed7 = true;
			if(keyCode == KeyEvent.VK_8)
				pressed8 = true;
			if(keyCode == KeyEvent.VK_9)
				pressed9 = true;
			if(keyCode == KeyEvent.VK_0)
				pressed0 = true;
			
			//action
			if(keyCode == KeyEvent.VK_J) {
				jPressed = true;
			}
		}else if(gp.gameState == gp.pauseState) {
			//pause
		}else if(gp.gameState == gp.startState) {
			if(keyCode == KeyEvent.VK_UP)
				upPressed = true;
			if(keyCode == KeyEvent.VK_DOWN)
				downPressed = true;
			if(keyCode == KeyEvent.VK_LEFT)
				leftPressed = true;
			if(keyCode == KeyEvent.VK_RIGHT)
				rightPressed = true;
			if(keyCode == KeyEvent.VK_ENTER)
				enter = true;
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W) {
			upPressed = false;
		}
			
		if(keyCode == KeyEvent.VK_S)
			downPressed = false;
		if(keyCode == KeyEvent.VK_D)
			rightPressed = false;
		if(keyCode == KeyEvent.VK_A)
			leftPressed = false;
		if(keyCode == KeyEvent.VK_P) {
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.pauseState;
			}
			else if(gp.gameState == gp.pauseState) {
				gp.gameState = gp.playState;
			}
		}
		if(keyCode == KeyEvent.VK_I) {
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.characterState;
			}
			else if(gp.gameState == gp.characterState) {
				gp.gameState = gp.playState;
			}
		}
		
		//NUMBER
		if(keyCode == KeyEvent.VK_1)
			pressed1 = false;
		if(keyCode == KeyEvent.VK_2)
			pressed2 = false;
		if(keyCode == KeyEvent.VK_3)
			pressed3 = false;
		if(keyCode == KeyEvent.VK_4)
			pressed4 = false;
		if(keyCode == KeyEvent.VK_5)
			pressed5 = false;
		if(keyCode == KeyEvent.VK_6)
			pressed6 = false;
		if(keyCode == KeyEvent.VK_7)
			pressed7 = false;
		if(keyCode == KeyEvent.VK_8)
			pressed8 = false;
		if(keyCode == KeyEvent.VK_9)
			pressed9 = false;
		if(keyCode == KeyEvent.VK_0)
			pressed0 = false;
		
		//action
		if(keyCode == KeyEvent.VK_J) {
			jPressed = false;
		}
		
		if(keyCode == KeyEvent.VK_UP)
			upPressed = false;
		if(keyCode == KeyEvent.VK_DOWN)
			downPressed = false;
		if(keyCode == KeyEvent.VK_LEFT)
			leftPressed = false;
		if(keyCode == KeyEvent.VK_RIGHT)
			rightPressed = false;
		if(keyCode == KeyEvent.VK_ENTER)
			enter = false;
	
		
	}

}
