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
		
		//System.out.println("Tombol mouse diklik pada posisi X: " + (e.getX() / gp.TILESIZE) + " Y: " + e.getY());
	}
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			leftClick = true;
		}
		mouseX = e.getX();
		mouseY = e.getY();
		//System.out.println("Tombol mouse ditekan pada posisi X: " + (e.getX() / gp.TILESIZE) + " Y: " + e.getY());
	}
	public void mouseReleased(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			leftClick = false;
		}
		
		System.out.println("Tombol mouse dilepas pada posisi X: " + (e.getX() / gp.TILESIZE) + " Y: " + e.getY());
	}
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Mouse memasuki area MousePanel");
	}
	public void mouseExited(MouseEvent e) {
		//System.out.println("Mouse meninggalkan area MousePanel");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.println("Position X= " + e.getX() + "Y= " + e.getY() + " dragged");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println("Position X= " + e.getX() + "Y= " + e.getY() + " undragged");
	}

	
}
