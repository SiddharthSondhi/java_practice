
public class Cube extends Square
{
	public Cube() 
	{
		System.out.println("I am entering the Cube's normal Constructor");
		System.out.println("I am exiting the  Cube's normal Constructor");
	}
	
	public Cube(double side) 
	{
		super(side);
		System.out.println("I am entering the Cube's overloaded Constructor");
		System.out.println("I am entering the Cube's overloaded Constructor");
	}
	
	public double getSurfaceArea() 
	{
		return getArea() * 6;
	}
	
	public double getVolume() 
	{
		return getArea() * getSide();
	}
	
}
