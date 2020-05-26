package pong.states;

import java.awt.Color;
import java.awt.Graphics;

import pong.Pong;
import pong.components.Ball;
import pong.components.HumanPaddle;

public class GameState extends State{
	
	HumanPaddle paddle1;
	HumanPaddle paddle2;
	Ball ball;

	public GameState(Pong game) {
		super(game);
		
		paddle1 = new HumanPaddle(game, 0);
		paddle2 = new HumanPaddle(game, 1);
		ball = new Ball(game, this);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,game.getWidth(), game.getHeight());
		
		paddle1.render(g);
		paddle2.render(g);
		ball.render(g);
	}

	@Override
	public void tick() {
		paddle1.tick();
		paddle2.tick();
		ball.tick();
		
		if (paddle1.getScore() == 5) {
			paddle1.setScore(0);
			paddle2.setScore(0);
			game.getEndsState().setWinner("left");
			State.setCurrentState(game.getEndsState());
		}
		else if (paddle2.getScore() == 5) {
			paddle1.setScore(0);
			paddle2.setScore(0);
			game.getEndsState().setWinner("right");
			State.setCurrentState(game.getEndsState());
		}
	}
	
	public HumanPaddle getPaddle1() {
		return paddle1;
	}
	
	public HumanPaddle getPaddle2() {
		return paddle2;
	}
	
}
