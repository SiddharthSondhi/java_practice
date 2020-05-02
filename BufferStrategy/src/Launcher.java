import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Launcher
{
	
	public static void main(String[] args) 
	{
		Window window = new Window(500, 300, "TITLE!!!!");
		window.getCanvas().createBufferStrategy(3);
		BufferStrategy bs = window.getCanvas().getBufferStrategy();
		int x = 1;
		
		while (true) 
		{
			render(window, x, bs);
			x++;
		}
	}

	
	public static void render(Window window, int x, BufferStrategy bs) 
	{

		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, 500, 300);

		g.setColor(Color.red);
		g.fillRect(x , 10, 10, 10);

		bs.show();
		g.dispose();
	}
	
	/*
	public static void main(String[] args) 
	{
		Window window = new Window(500, 300, "TITLE!!!!");
		window.getCanvas().createBufferStrategy(3);

		render(window);
	}

	
	public static void render(Window window) 
	{
		BufferStrategy bs = window.getCanvas().getBufferStrategy();

		Graphics g = bs.getDrawGraphics();
		//g.clearRect(0, 0, 500, 300);

		g.setColor(Color.red);
		g.fillRect(10, 10, 10, 10);

		bs.show();
		g.dispose();
	}
	*/
}
