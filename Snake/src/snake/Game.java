package snake;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import snake.display.Display;
import snake.states.GameState;
import snake.states.State;

public class Game {

	private String title;
	private int width, height;
	private boolean running;
	
	private Display display;
	private BufferStrategy bs;
	private Handler handler;
	private GameState gameState;
	
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	public void init() {
		display = new Display(title, width, height);
		display.getCanvas().createBufferStrategy(3);
		
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		State.setCurrentState(gameState);
		
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		
		
		/////////////////RENDER/////////////////
		
		
		State.getCurrentState().render(g);
		
		
		////////////////////////////////////////
		
		
		g.dispose();
		
	}
	
	public void tick() {
		State.getCurrentState().tick();
	}
	
	public void start() {
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
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
}
