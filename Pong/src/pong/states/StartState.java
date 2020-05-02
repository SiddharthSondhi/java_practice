package pong.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pong.Pong;

public class StartState extends State{

	public StartState(Pong game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,game.getWidth(), game.getHeight());
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		g.drawString("To start press ENTER", 200, 230);
		g.drawString("First to 5 points wins", 210, 260);
		
	}

	@Override
	public void tick() {
		if(game.getKeyManager().keyEnter == true) {
			State.setCurrentState(game.getGameState());
		}
	}

}
