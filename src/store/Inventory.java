package store;

public class Inventory
{
	private Computer[] computers;
	private int maxCapacity;

	public Inventory(int inventoryCapacity)
	{
		computers = new Computer[inventoryCapacity];
		maxCapacity = inventoryCapacity;
		System.out.println("Inventory created max capacity set to " + inventoryCapacity);
	}// End of constructor Inventory

	public void getNumberOfComputers()
	{
		int counter = 0;
		for (int i = 0; i < maxCapacity; i++)
		{
			if (computers[i] != null)
			{
				counter++;
			}
		}
		System.out.println("Computers in store: " + counter);
	}// End of method getNumberOfComputers

	public void addComputer(String brand, String model, long sn, double price)
	{
		Computer comp = new Computer(brand, model, sn, price);
		// verified if there is space to add a new computer

		if (computers[(maxCapacity - 1)] == null)
		{
			for (int i = 0; i < maxCapacity; i++)
			{
				if (computers[i] == null)
				{
					computers[i] = comp;
					System.out.println("Computer added");
					break;
				}
			}
		}
		else
		{
			System.out.println("Inventory full");
		}

	}// End of method addComputer

	public Computer search(int id)
	{

		return computers[id];
	}

	public void search(String value, String criteria)
	{
		int counter = 0;
		switch (criteria)
		{
		case "brand":
			for (int i = 0; i < maxCapacity; i++)
			{
				if (computers[i] != null && computers[i].getBrand().equals(value))
				{
					counter++;
					System.out.println(computers[i].toString());
				}
			}
			break;
		case "model":
			for (int i = 0; i < maxCapacity; i++)
			{
				if (computers[i] != null && computers[i].getModel().equals(value))
				{
					counter++;
					System.out.println(computers[i].toString());
				}
			}
			break;
		}
		if (counter < 1)
		{
			System.out.println("No item found");
		}
	}// End of search by brand and model

	public void search(long sn)
	{
		int counter = 0;
		for (int i = 0; i < maxCapacity; i++)
		{
			if (computers[i] != null && computers[i].getSerialNumber() == sn)
			{
				counter++;
				System.out.println(computers[i].toString());
			}
		}
		if (counter < 1)
		{
			System.out.println("No item found");
		}
	}// End of method search by serial number
	
	public void search(double price) {
		int counter = 0;
		for (int i = 0; i < maxCapacity; i++)
		{
			if (computers[i] != null && computers[i].getPrice() < price)
			{
				counter++;
				System.out.println(computers[i].toString());
			}
		}
		if (counter < 1)
		{
			System.out.println("No item found");
		}
	}// End of method search by lower price
	
	public int getFreeSpace() {
		int counter = 0;
		for (int i = 0; i < maxCapacity; i++)
		{
			if (computers[i] != null)
			{
				counter++;
			}
		}
		
		
		return maxCapacity - counter;
	}
	
	

}// End of class Inventory
