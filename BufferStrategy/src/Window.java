import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Window
{
	private int width, height;
	private String title;
	private JFrame frame;
	private Canvas canvas;
	
	public Window(int width, int height, String title) 
	{
		
		this.width = width;
		this.height = height;
		this.title = title;
		
		setUp();
	}
	
	private void setUp() {
		frame = new JFrame(title); 
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public JFrame getFrame() 
	{
		return frame;
	}
	
	public Canvas getCanvas() 
	{
		return canvas;
	}
	
}
