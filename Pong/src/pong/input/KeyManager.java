package pong.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean KeyCodes[];
	public boolean keyW, keyS, keyUp, keyDown, keyEnter;
	
	public KeyManager() {
		KeyCodes = new boolean[256];
	}
	
	public void tick() {
		keyW = KeyCodes[KeyEvent.VK_W];
		keyS = KeyCodes[KeyEvent.VK_S];
		keyUp = KeyCodes[KeyEvent.VK_UP];
		keyDown = KeyCodes[KeyEvent.VK_DOWN];
		keyEnter = KeyCodes[KeyEvent.VK_ENTER];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			KeyCodes[KeyEvent.VK_W] = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			KeyCodes[KeyEvent.VK_S] = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			KeyCodes[KeyEvent.VK_UP] = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			KeyCodes[KeyEvent.VK_DOWN] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			KeyCodes[KeyEvent.VK_ENTER] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			KeyCodes[KeyEvent.VK_W] = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			KeyCodes[KeyEvent.VK_S] = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			KeyCodes[KeyEvent.VK_UP] = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			KeyCodes[KeyEvent.VK_DOWN] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			KeyCodes[KeyEvent.VK_ENTER] = false;
		}
	}

}
