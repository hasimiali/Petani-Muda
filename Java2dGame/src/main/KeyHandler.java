package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, rightPressed, leftPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_UP) {
			if(keyCode == KeyEvent.VK_RIGHT) {
				rightPressed = true;
				upPressed = false;
			}else if(keyCode == KeyEvent.VK_RIGHT) {
				leftPressed = true;
				upPressed = false;
			}else {
				upPressed = true;
			}
			
		}
			
		if(keyCode == KeyEvent.VK_DOWN)
			downPressed = true;
		if(keyCode == KeyEvent.VK_RIGHT)
			rightPressed = true;
		if(keyCode == KeyEvent.VK_LEFT)
			leftPressed = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_UP)
			upPressed = false;
		if(keyCode == KeyEvent.VK_DOWN)
			downPressed = false;
		if(keyCode == KeyEvent.VK_RIGHT)
			rightPressed = false;
		if(keyCode == KeyEvent.VK_LEFT)
			leftPressed = false;
	}

}
