import java.util.ArrayList;
public class Driver {

	public static void main(String[] args)
	{
// Rectangle
		Rectangle rect1 = new Rectangle();				// See Expected Output for Constructor
        
        //System.out.println(rect1.length)                // Error
        System.out.println(rect1.getLength());          // prints out 1.0;
        //System.out.println(rect1.width)                 // Error
        System.out.println(rect1.getWidth());         	// prints out 2.0;
        
        System.out.println(rect1.getPerimeter());       // prints out 6.0;
        System.out.println(rect1.getArea());            // prints out 2.0;
        
        rect1.setWidth(0.5);
        System.out.println(rect1.getPerimeter());       // prints out 3.0
        System.out.println(rect1.getArea());            // prints out 0.5;

        rect1.setLength(0.7);
        System.out.println(rect1.getPerimeter());       // prints out 2.4
        System.out.println(rect1.getArea());            // prints out 0.35;
        
        rect1.setLength(1.5);
        rect1.setWidth(3.0);
        System.out.println(rect1.toString());			// See Expected Output
        
        Rectangle rect2 = new Rectangle(0.1,1.5);		// See Expected Output
        System.out.println(rect2.toString());			// See Expected Output

// Square
        Square s1 = new Square();						// See Expected Output
        
        //System.out.println(s1.side);					// Error
        
        System.out.println(s1.getLength());				// 1.0
        System.out.println(s1.getWidth());				// 1.0
        System.out.println(s1.getSide());				// 1.0
        
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getArea());
        
        s1.setSide(0.5);								// No output
        System.out.println(s1.getLength());				// 0.5
        System.out.println(s1.getWidth());				// 0.5
        
        System.out.println(s1.toString());

        Square s2 = new Square(1.5);					// See Expected Output
        System.out.println(s2.toString());
        
        s2.setLength(1.2);								// No Output
        System.out.println(s2.getWidth());				// 1.2
        System.out.println(s2.toString());				// Look carefully at what must change
        
        
// Cube
        Cube c1 = new Cube();
        System.out.println(c1.getWidth());				// 1.0			
        System.out.println(c1.getLength());				// 1.0
        System.out.println(c1.getSide());				// 1.0
        
        												// c1.getArea returns the area of the Base
        System.out.println(c1.getArea());				// 1.0
        System.out.println(c1.getSurfaceArea());		// 6.0
        
        c1.setSide(2);
        System.out.println(c1.getVolume());				// 8.0
        
        c1.setLength(1.1);
        System.out.println(c1.getSide());				// 1.1
        System.out.println(c1.toString());				// See Expected Output 
        
        Cube c2 = new Cube(1.2);
        												// getPerimeter is the Perimeter of the Base
        System.out.println(c2.getPerimeter());			// 4.8
        System.out.println(c2.getVolume());				// 1.728
        
        
// Rectangular Prism
        
        rect1.setLength(1.0);			// Rectangle from earlier
        rect1.setWidth(2.0);
        
        RectangularPrism RP1 = new RectangularPrism();	// See Expected Output
        
        System.out.println(RP1.getHeight());				// 3.0
        
        if (RP1.getPerimeter() == rect1.getPerimeter())
        {
        	System.out.println("You wrote both constructors correctly.");
        }

        System.out.println(RP1.getPerimeter());				// 6.0
        System.out.println(RP1.getArea());					// 2.0
        System.out.println(RP1.getVolume());				// 6.0
        System.out.println(RP1.getSurfaceArea());			// 2*(1*2) + 2*(1*3) + 2*(2*3) = 22.0
        
        RP1.setHeight(1.0);
        System.out.println(RP1.getPerimeter());				// 6.0
        System.out.println(RP1.getArea());					// 2.0
        System.out.println(RP1.getVolume());				// 2.0
        System.out.println(RP1.getSurfaceArea());			// 2*(1*2) + 2*(1*1) + 2*(2*1) = 10.0
        
        System.out.println(RP1.toString());
        
        RectangularPrism RP2 = new RectangularPrism(4.0);
        
        System.out.println(RP2.getLength());				// 1.0
        System.out.println(RP2.getWidth());					// 2.0
        System.out.println(RP2.getHeight());				// 4.0
        
        System.out.println(RP2.getPerimeter());				// 6.0
        System.out.println(RP2.getArea());					// 2.0
        System.out.println(RP2.getVolume());				// 8.0
        
        RectangularPrism RP3 = new RectangularPrism(1.1,1.2,2.0);
        
        System.out.println(RP3.getLength());				// 1.1
        System.out.println(RP3.getWidth());					// 1.2
        System.out.println(RP3.getHeight());				// 2.0
        
        System.out.println(RP3.getPerimeter());				// 4.6
        System.out.println(RP3.getArea());					// 1.32
        System.out.println(RP3.getVolume());				// 2.64
        System.out.println(RP3.getSurfaceArea());			// 18.8
        
        System.out.println(RP3.toString());					// See Expected Output

        ArrayList<Integer> aList = new ArrayList<Integer>(5);
        System.out.println(aList.size());
	}

}
