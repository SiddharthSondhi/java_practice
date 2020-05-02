package pong.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pong.Pong;

public class EndState extends State{
	
	private String winner;

	public EndState(Pong game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,game.getWidth(), game.getHeight());
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		g.drawString("Game Over : Player on the " + winner + " Won.", 140, 200);
		g.drawString("To play again press ENTER", 200, 230);
	}

	@Override
	public void tick() {
		if(game.getKeyManager().keyEnter == true) {
			State.setCurrentState(game.getGameState());
		}
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}

}
