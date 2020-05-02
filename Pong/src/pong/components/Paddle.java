package pong.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pong.Pong;
import pong.gfx.GradualColorRandomizer;

public abstract class Paddle {
	public static final int PADDLE_WIDTH = 15, PADDLE_HEIGHT = 80;
	protected double x, y, yVel;
	protected Pong game;
	protected int pos, score;
	GradualColorRandomizer color;

	
	public Paddle(Pong game, int pos) {
		this.pos = pos;
		score = 0;
		if(pos == 0)
			x = 15;
		else 
			x = game.getWidth() - PADDLE_WIDTH * 2;
		
		y = 210;
		yVel = 0;
		
		this.game = game;
		color = new GradualColorRandomizer();
		
	}

	public abstract void tick();
	public void render(Graphics g) {

		g.setColor(color.getColor());
		g.fillRect((int)x, (int)y, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int )y,  PADDLE_WIDTH, PADDLE_HEIGHT);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	
		if(pos == 0) {
			g.drawString("" + score, 170, 20);;
		}
		else {
			g.drawString("" + score, 545, 20);;
		}
	}
	
	public double getY() {
		return y;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}
