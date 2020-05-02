package pong.components;

import pong.Pong;

public class HumanPaddle extends Paddle {
	
	public HumanPaddle(Pong game, int pos) {
		super(game, pos);
	}
	
	@Override
	public void tick() {
		if (pos == 0) {
			if(game.getKeyManager().keyW == true && game.getKeyManager().keyS == false && yVel > -5) 
				yVel -= 2;
			if (game.getKeyManager().keyS == true && game.getKeyManager().keyW == false && yVel < 5)
				yVel += 2;
			else
				yVel *= .9;
		}
		else {
			if(game.getKeyManager().keyUp == true && game.getKeyManager().keyDown == false && yVel > -5) 
				yVel -= 2;
			if (game.getKeyManager().keyDown == true && game.getKeyManager().keyUp== false && yVel < 5)
				yVel += 2;
			else
				yVel *= .9;
		}
		y += yVel;
		
		if(y < 5) 
			y = 5;
		if(y > game.getHeight() - PADDLE_HEIGHT - 5)
			y = game.getHeight() - PADDLE_HEIGHT - 5;	
	}
}
