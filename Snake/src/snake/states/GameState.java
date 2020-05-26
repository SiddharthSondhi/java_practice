package snake.states;

import java.awt.Color;
import java.awt.Graphics;

import snake.Handler;

public class GameState extends State{

	public GameState(Handler handler) {
		super(handler);
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, handler.getGameWidth(), handler.getGameHeight());
	}

	@Override
	public void tick() {
		
	}

}
