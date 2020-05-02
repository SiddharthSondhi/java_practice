public class Company_Runner
{
	
	public static void main(String[] args)
	{
		Manager owner = new Manager("Owner");
		
		// 1. Set yourself as the owner, make your salary 200,000  
		
		owner.setSalary(200000);
		
		// 2. The owner decided he needed to hire 5 employees each for annual salary of $80k. All hires are the owner's subordinates.
		
		for (int i = 0; i < 5; i++ ) 
		{
			owner.addEmployee();
			owner.getSubordinates().get(i).setSalary(80000);
		}
		
		// 3. They all compete for one managerial position that manages the other 4 employees. (Make whoever you want the manager)
	
		Manager m1 = owner.makeManager(owner.getSubordinates().get(0), 50000);
		int size = owner.getSubordinates().size() - 1;
		for(int i = 0; i < size; i++) 
		{
			m1.addEmployee(owner.getSubordinates().get(0));
			owner.getSubordinates().remove(0);
		}
		
		// 4. The owner says that he wants to hire 5 new employees and wants 1 more manager from the 4 subordinates of the first manager.
		
		Manager m2 = m1.makeManager(m1.getSubordinates().get(0), 40000);
		for (int i = 0; i < 5; i++ ) 
		{
			m2.addEmployee();
			m2.getSubordinates().get(i).setSalary(80000);
		}

	}

}
