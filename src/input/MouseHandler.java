package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import main.GamePanel;

public class MouseHandler implements MouseListener, MouseMotionListener {
	GamePanel gp;
	public boolean leftClick;
	public int mouseX, mouseY;
	
	public MouseHandler(GamePanel gp){
		this.gp = gp;
		gp.addMouseListener(null);
		gp.addMouseMotionListener(null);
		gp.setFocusable(true);
	}
	
	
	public void mouseClicked(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			leftClick = true;
		}
		mouseX = e.getX();
		mouseY = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			leftClick = false;
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	
}
