package pong.components;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import pong.Pong;
import pong.gfx.GradualColorRandomizer;
import pong.states.GameState;

public class Ball {
	double x, y, yVel, xVel, xMinVel, xMaxVel, yMinVel, yMaxVel;
	final int DIAMETER = 16;
	Pong game;
	GradualColorRandomizer color;
	GameState state;

	public Ball(Pong game, GameState state) {
		x = 350;
		y = 250;
		xMaxVel = 5;
		xMinVel = 3.5;
		yMinVel = 2.5;
		yMaxVel = 5;
		this.game = game;
		this.state = state;
		
		color = new GradualColorRandomizer();

		xVel = 1.5 * (new Random().nextBoolean() ? 1 : -1);
		//chooses velocity with a random sign from 1.5 to 3
		yVel = Math.random() * (3 - 1.5) + 1.5 * (new Random().nextBoolean() ? 1 : -1);
	}

	public void tick() {
		x += xVel;
		y += yVel;

		//if at either top or bottom bound, yVel is negated.
		if(y <= 5 + DIAMETER/2 || y >= game.getHeight() - 5 - DIAMETER/2) {
			yVel *= -1;
		}

		//if at left bound, check collision with paddle 1 and if at right then with paddle 2.
		if(x <= Paddle.PADDLE_WIDTH * 2 + DIAMETER / 2) {
			if(checkCollide(state.getPaddle1())) {
				//flip direction of x velocity and randomize between xMinVel and xMaxVel
				xVel = ((Math.random() * (xMaxVel - xMinVel)) + xMinVel);
				//chose random y velocity between yMinVel and yMaxVel
				yVel =  Math.random() * (yMaxVel - yMinVel) + yMinVel * (new Random().nextBoolean() ? 1 : -1);
			} 
			else {
				state.getPaddle2().setScore(state.getPaddle2().getScore() + 1);
				resetBall();
				}
		}
		else if(x >= game.getWidth() - Paddle.PADDLE_WIDTH * 2 - DIAMETER / 2) {
			if(checkCollide(state.getPaddle2())) {
				//flip direction of x velocity and randomize between 2 and xMaxVel
				xVel = -1 * ((Math.random() * (xMaxVel - xMinVel)) + xMinVel);
				//chose random y velocity between yMinVel and yMaxVel
				yVel =  Math.random() * (yMaxVel - yMinVel) + yMinVel * (new Random().nextBoolean() ? 1 : -1);
			} 
			else {
				state.getPaddle1().setScore(state.getPaddle1().getScore() + 1);
				resetBall();
				}
		}
	}  

	public boolean checkCollide(Paddle paddle) {
		if (paddle.getY() <= y - DIAMETER / 2 && paddle.getY() + Paddle.PADDLE_HEIGHT >= y - DIAMETER / 2) {
			return true;
		}
		else if (paddle.getY() <= y + DIAMETER / 2 && paddle.getY() + Paddle.PADDLE_HEIGHT >= y + DIAMETER / 2) {
			return true;
		}
		return false;		
	}
	
	public void resetBall() {
		y = 250;
		x = 350;
		//chooses velocity with a random sign from 1.5 to 3
		yVel = Math.random() * (3 - 1.5) + 1.5 * (new Random().nextBoolean() ? 1 : -1);
		xVel = 1.5 * (new Random().nextBoolean() ? 1 : -1);
	}

	public void render(Graphics g) {
		g.setColor(color.getColor());
		g.fillOval((int)(x - DIAMETER / 2), (int)(y - DIAMETER / 2), DIAMETER, DIAMETER);
		
		g.setColor(Color.BLACK);
		g.drawOval((int)(x - DIAMETER / 2), (int)(y - DIAMETER / 2), DIAMETER, DIAMETER);
	}
}
