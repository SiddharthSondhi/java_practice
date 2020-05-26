package pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import pong.display.Window;
import pong.input.KeyManager;
import pong.states.EndState;
import pong.states.GameState;
import pong.states.StartState;
import pong.states.State;

public class Pong implements Runnable{
	//Fields
	private int width, height;
	private String title;
	private boolean running = false;
	private Window window;
	private KeyManager keyManager;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private GameState gameState;
	private StartState startState;
	private EndState endState;
	
	
	//Constructor
	public Pong(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	//Initialize - called when game/thread is started before the game loop.
	private void init(){
		window = new Window(title, width, height);
		window.getCanvas().createBufferStrategy(3);
		
		keyManager = new KeyManager();
		window.getFrame().addKeyListener(keyManager);
		
		gameState = new GameState(this);
		startState = new StartState(this);
		endState = new EndState(this);
		
		State.setCurrentState(startState);
		
	}
	
	//Updates all values - done 60 times a second.
	private void tick() {
		keyManager.tick();
		State.getCurrentState().tick();
		
	}
	
	
	//Draws the graphics using a buffer strategy - done as fast as the computer can.
	private void render() {
		bs = window.getCanvas().getBufferStrategy();
		
		Graphics g = bs.getDrawGraphics(); 
		
		//////////////////////////////////////////// draw graphics
		
		State.getCurrentState().render(g);
		
		////////////////////////////////////////////
		
		bs.show();
		g.dispose();
	}
	
	//Called by in the start method internally when thread.start() is called.
	public void run() {
		init();
		
		//game loop
		int ticksPerSecond = 120;
		//1000000000(1 billion) nanoseconds = 1 second
		double timePerTick = 1000000000 / ticksPerSecond;
		double tickTime = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long renderTime = 0;
		int fps = 0;
		double delta = 0;
		
		while(running) 
		{
			now = System.nanoTime();
			delta = now - lastTime; 
			tickTime += delta / timePerTick;
			
			lastTime = now;
			if (tickTime >= 1) 
			{
				tick();
				render();
				//System.out.println("tick");
				tickTime--;
			}
			
			
			
			renderTime += delta;
			fps++;
			
			//FPS display
			if (renderTime >= 1000000000) 
			{
				//System.out.println("FPS: " + fps);
				fps = 0;
				renderTime = 0;
			}
		}	
		stop();
	}

	//starts thread when game is started
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	//stops thread - called when the game loop is broken out of.
	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {}
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameState getGameState() {
		return gameState;
	}
	
	public EndState getEndsState() {
		return endState;
	}
	
}
