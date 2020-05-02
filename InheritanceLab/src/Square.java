
public class Square extends Rectangle
{
	private double side;
	
	Square()
	{
		System.out.println("I am entering the Square's normal Constructor");
		setWidth(1);
		side = 1;
		System.out.println("I am exiting the  Square's normal Constructor");
	}
	
	Square(double side)
	{
		super(side, side);
		System.out.println("I am entering the Square's overloaded Constructor");
		this.side = side;
		System.out.println("I am exiting the  Square's overloaded Constructor");
	}

	public double getSide()
	{
		return side;
	}

	public void setSide(double side)
	{
		this.side = side;
		setWidth(side);
		setLength(side);
		getArea();
		getPerimeter();
	}
	
	public String toString() 
	{
		return ("I am a " + this.getClass() + " with a side of " + side);
	}
	
	public void setLength(double length) 
	{
		side = length;
		super.setLength(length);
		super.setWidth(length);
	}
	
	public void setWidth(double width) 
	{
		side = width;
		super.setLength(width);
		super.setWidth(width);
	}
}
