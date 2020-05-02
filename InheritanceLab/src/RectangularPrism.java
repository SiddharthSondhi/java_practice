
public class RectangularPrism extends Rectangle
{
	private double height;
	
	public RectangularPrism() 
	{
		System.out.println("I am entering the Rectanglular Prism's normal Constructor");
		height = 3;
		System.out.println("I am exiting the Rectanglular Prisms's normal Constructor");
	}
	
	public RectangularPrism(double height) 
	{
		super();
		System.out.println("I am entering the Rectanglular Prisms's overloaded Constructor of one argument");
		this.height = height;
		System.out.println("I am exiting the Rectanglular Prisms's overloaded Constructor of one argument");
	}
	
	public RectangularPrism(double length, double width, double height) 
	{
		super(length, width);
		System.out.println("I am entering the Rectanglular Prisms's overloaded Constructor of three arguments");
		this.height = height;
		System.out.println("I am exiting the Rectanglular Prisms's overloaded Constructor of three arguments");
	}
	
	public double getVolume() 
	{
		return getWidth() * getLength() * height;
	}
	
	public double getSurfaceArea() 
	{
		return (getWidth() * getLength() * 2) + (getWidth() * height * 2) + (getLength() * height * 2);
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public String toString() 
	{
		return ("I am a " + this.getClass() + " with a width of " + getWidth() + ", a length of " + getLength() + ", and a height of " + height );
	}
}
