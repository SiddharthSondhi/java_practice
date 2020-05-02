import javax.swing.*;
import java.awt.*;

public class FrameWithPanel
{
	public static void main(String[] args) 
	{
		Frame f = new Frame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

class Frame extends JFrame
{
	public Frame() 
	{
		setTitle("TITLE!!!");
		setSize(433, 544);
		setLocation(253, 352);
		
		Panel panel = new Panel();
		Container cp = getContentPane();
		cp.add(panel);
	}
}

class Panel extends JPanel
{
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawString("Hi", 75, 100);
	}
	
}