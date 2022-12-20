package gameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.EmptyStackException;
import java.util.Stack;

public class GameStateManager {

private Stack<GameState> states;
	
	public GameStateManager() {
		
		this.states = new Stack<>();
	}
	
	public void addState(GameState state) {
		
		this.states.add(state);
	}
	
	public void backToPreviousState() {
		
		this.states.pop();
	}
	
	public void clearState() {
		
		this.states.clear();
	}

	public void tick() {
		
		try {
			
			this.states.peek().tick();
			
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void render(Graphics2D g2d) {
		
		try {
			
			this.states.peek().render(g2d);
			
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}
	
	public void renderPreviousState(Graphics2D g2d) {
		
		try {
			
			this.states.get(states.size()-2).render(g2d);
			
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		} catch(IndexOutOfBoundsException e) {
			System.err.println("[GameStateManager]: Error! GameState stack containts only 1 state!");
			System.exit(-1);
		}
	}
	
	public void keyTyped(KeyEvent ke) {
		try {
			this.states.peek().keyTyped(ke);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void keyPressed(KeyEvent ke) {
		try {
			this.states.peek().keyPressed(ke);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void keyReleased(KeyEvent ke) {
		try {
			this.states.peek().keyReleased(ke);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}
	
	public void mouseClicked(MouseEvent me) {
		try {
			this.states.peek().mouseClicked(me);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void mousePressed(MouseEvent me) {
		try {
			this.states.peek().mousePressed(me);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void mouseReleased(MouseEvent me) {
		try {
			this.states.peek().mouseReleased(me);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void mouseEntered(MouseEvent me) {
		try {
			this.states.peek().mouseEntered(me);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void mouseExited(MouseEvent me) {
		try {
			this.states.peek().mouseExited(me);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}
	
	public void mouseWheelMoved(MouseWheelEvent me) {
		try {
			this.states.peek().mouseWheelMoved(me);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void mouseDragged(MouseEvent me) {
		try {
			this.states.peek().mouseDragged(me);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}

	public void mouseMoved(MouseEvent me) {
		try {
			this.states.peek().mouseMoved(me);
		} catch(EmptyStackException e) {
			System.err.println("[GameStateManager]: Error! GameState stack is empty!");
			System.exit(-1);
		}
	}
}

