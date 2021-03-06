package store;
//--------------------------------------------------

// Assignment 2
// Andres Ardila
// Written by: Andres Ardila sid:1931557
//--------------------------------------------------

public class Computer
{

	private String brand;
	private String model;
	private long SN;
	private double price;
	private static int stock = 0;

	public Computer(String brand, String model, long SN, double price)
	{
		// Attributes or Properties
		this.brand = brand;
		this.model = model;
		this.SN = SN;
		this.price = price;
		stock++;
	}

	// Accessors or Getters
	public String getBrand()
	{
		return brand;
	}

	public String getModel()
	{
		return model;
	}

	public long getSerialNumber()
	{
		return SN;
	}

	public double getPrice()
	{
		return price;
	}

	// Mutators or Setters
	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public void setSerialNumber(long SN)
	{
		this.SN = SN;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	// Override the toString() method to display all the attributes of the object at
	// once

	@Override
	public String toString()
	{
		return "Brand: " + brand + "\nModel: " + model + "\nSN: " + SN + "\nPrice: " + price;
	}

	static int findNumberOfCreatedComputers()
	{
		return stock;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{ // in case the object is the same, if the NEW word was not used to instantiated
			// the object
			// the value is going to be compared instead of the memory address.
			return true;
		}
		else
		{ // compare the two objects to make sure both are the same type
			if (o == null || this.getClass() != o.getClass())
			{
				return false;
			}
			else
			{ // the object needs to be cast in order to access the properties at this point
				// we are sure both objects are the same type
				// which means the cast would not have any problem
				Computer comp = (Computer) o;
				// all properties are compare, there is need to call the getters because the
				// method is inside the class
				return (brand.equals(comp.brand) && model.equals(comp.model) && price == comp.price && SN == comp.SN);
			}
		}
	}
}
