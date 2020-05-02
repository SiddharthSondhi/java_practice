import java.util.ArrayList;

public class Employee
{
	private static int employeeCount = 0;
	private String name;
	private int ID;
	private double salary;
	
	public Employee() 
	{
		employeeCount++;
		name = "Placeholder Name";
		ID = employeeCount;
		setSalary(70000);
	}
	
	public Employee(String name) 
	{
		this();
		this.name = name;
	}
	
	public Employee(String name, int ID, double salary) 
	{
		this.name = name;
		this.ID = ID;
		this.setSalary(salary);
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public ArrayList<Employee> getSubordinates()
	{
		return null;
	}

	public int getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}
	
	
}
