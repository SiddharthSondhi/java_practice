
public class Rectangle
{
	private double length;
	private double width;
	private double perimeter;
	private double area;
	
	public Rectangle() 
	{
		System.out.println("I am entering the Rectangle's normal Constructor");
		length = 1;
		width = 2;
		getArea();
		getPerimeter();
		System.out.println("I am exiting the Rectangle's normal Constructor");
		
	}
	
	public Rectangle(double length, double width) 
	{
		System.out.println("I am entering the Rectangle's overloaded Constructor");
		this.length = length;
		this.width = width;
		getArea();
		getPerimeter();
		System.out.println("I am exiting the Rectangle's overloaded Constructor");
	}

	public double getLength()
	{
		return length;
	}
	
	public void setLength(double length) 
	{
		this.length = length;
		getArea();
		getPerimeter();
	}
	

	public double getWidth()
	{
		return width;
	}
	
	public void setWidth(double width) 
	{
		this.width = width;
		getArea();
		getPerimeter();
	}
	
	public double getArea() 
	{
		area = length * width;
		return area;
	}
	
	public double getPerimeter() 
	{
		perimeter = (length * 2 ) + (width * 2);
		return perimeter;
	}
	
	public String toString() 
	{
		return ("I am a " + this.getClass() + " with a width of " + width + " and a length of " + length);
	}
}
