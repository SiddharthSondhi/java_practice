package snake.components;

import java.awt.Color;
import java.util.Random;

public class GradualColorRandomizer {
	private float r, g, b;
	private int rSign , gSign, bSign;
	Color color;
	
	public GradualColorRandomizer() {
		r = (float)(Math.random());
		g = (float)(Math.random());
		b = (float)(Math.random());
		
		rSign = (new Random().nextBoolean() ? 1 : -1);
		gSign = (new Random().nextBoolean() ? 1 : -1);
		bSign = (new Random().nextBoolean() ? 1 : -1);
		
		
		color = new Color(r, g, b);
	}
	
	public Color getColor() {
		r += rSign * .02;
		g += gSign * .02;
		b += bSign * .02;
		
		if (r >= 1 || r <= 0) {
			rSign *= -1; 
			r += rSign * .02;
		}
		if (g >= 1 || g <= 0) {
			gSign *= -1; 
			g += gSign * .02;
		}
		if (b >= 1 || b <= 0) {
			bSign *= -1; 
			b += bSign * .02;
		}
		
		color = new Color(r, g, b);
		return color;
	}
	
	
}
