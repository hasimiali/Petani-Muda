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
		
		switch(keyCode) {
			case KeyEvent.VK_UP:
				upPressed = true;
			case KeyEvent.VK_DOWN:
				downPressed = true;
			case KeyEvent.VK_RIGHT:
				rightPressed = true;
			case KeyEvent.VK_LEFT:
				leftPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int keyCode = e.getKeyCode();
		
		switch(keyCode) {
			case KeyEvent.VK_UP:
				upPressed = false;
			case KeyEvent.VK_DOWN:
				downPressed = false;
			case KeyEvent.VK_RIGHT:
				rightPressed = false;
			case KeyEvent.VK_LEFT:
				leftPressed = false;
		}
	}

}
