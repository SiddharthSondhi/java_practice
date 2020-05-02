import java.awt.Toolkit;

class Test
{
	// Threads
	/*
	public static void main (String [] args)
	{
		MyThread mt = new MyThread ();
		mt.start ();
		for (int i = 0; i < 50; i++)
			System.out.println ("i = " + i + ", i * i = " + i * i);
	}
}
class MyThread extends Thread
{
	public void run ()
	{
		for (int count = 1, row = 1; row < 20; row++, count++)
		{
			for (int i = 0; i < count; i++)
				System.out.print ('*');
			System.out.print ('\n');
		}
	}
	*/
	
	//Canvas / JFrame
	/*
	public static void main(String[] args) 
	{
		int width = 1000;
		int height = 1000;
		String title = "TITLE!!!";
		
		JFrame frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Canvas canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(canvas);
		frame.pack();
		
		canvas.createBufferStrategy(3);
		
		while(true) 
		{
			BufferStrategy bs = canvas.getBufferStrategy();
			
			Graphics g = bs.getDrawGraphics();
			
			g.clearRect(0, 0, width, height);
			
			g.fillRect(10, 10, 100, 100);
		
			bs.show();
			g.dispose();
		}
	}
	
	public static int tricky(int n) 
	{
		if(n == 1 || n == 2) 
			return 2 * n;
		else
			return tricky(n -1) - tricky(n - 2);
	}
	public static void main(String[] args) 
	{
	//	System.out.println(tricky(-4));
		double x = 1 / 2;
		
		System.out.println(	x);
	}
	
	
	private int one;
	public Test(int newOne) 
	{
		one = newOne;
	}
	public int getOne() 
	{
		return one;
	}
	public boolean isGreater(Test other) 
	{
		return one > other.one;
	}
	*/
	
	public static void main(String[] args) 
	{
	
//		for(int i = 0; i < 100; i ++) {
//			System.out.println(-1 * ((Math.random() * (2.8 - 1.5)) + 1.5));
//		}
		
	}
}

