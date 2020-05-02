import java.util.ArrayList;

public class Manager extends Employee
{
	private ArrayList<Employee> subordinates = new ArrayList<Employee>();
	
	public Manager() 
	{
	}
	
	public Manager(String name) 
	{
		super(name);
	}
	
	public Manager(String name, int ID, double salary) 
	{
		super(name, ID, salary);
	}
	
	public void addEmployee() 
	{
		subordinates.add(new Employee());
	}
	
	public void addEmployee(Employee e) 
	{
		subordinates.add(e);
	}
	
	public Employee findEmployee(int ID) 
	{
		for(Employee e : subordinates) 
		{
			if(e.getID() == ID) 
			return e;
		}
		return null;
	}
	
	public void setSalary(Employee e, double salary) 
	{
		e.setSalary(salary);
	}
	
	public Manager makeManager(Employee e, double bonus) 
	{
		Manager m = new Manager(e.getName(), e.getID(), e.getSalary());
		subordinates.remove(e);
		subordinates.add(m);
		return m;
	}
	
	public ArrayList<Employee> getSubordinates()
	{
		return subordinates;
	}
	
}
