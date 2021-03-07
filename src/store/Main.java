//--------------------------------------------------
// Assignment 2
// Andres Ardila
// Written by: Andres Ardila sid:1931557
// 
//--------------------------------------------------
/***
 * Inventory class contains the methods below
 * 	-getNumberOfComputers()
 * 	-addComputer(String brand, String model, long serialNumber, double price)
 * 	-search(int index) overload 1
 * 	-search(String value,String criteria) overload 2
 * 		-->value is the name of the brand or the model
 * 		-->criteria can have two values 'brand' or 'model'
 * 	-search(long serialNumber)
 * 	-search(double price) displays all computers with the price lower than the input value 
 */
package store;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int menuOption = 0;
		System.out.println("------------------------------------------------");
		System.out.println("\tWelcome to the Computer Store");
		System.out.println("------------------------------------------------");

		System.out.print("Type the maximun size of the inventory:");

		int maxComputers = scanner.nextInt();

		Inventory inventory = new Inventory(maxComputers);

		inventory.addComputer("HP", "Altitud", 123456, 500.50);
		inventory.addComputer("HP", "Altitud", 123456, 400.50);
		inventory.addComputer("APPLE", "iMac", 654321, 100.50);
		inventory.addComputer("ASUS", "ROG", 123456, 300.50);
		inventory.addComputer("HP", "Pavilion", 123456, 200.50);
		System.out.println("Computers in store: " + inventory.getNumberOfComputers());
		System.out.println("------------------------------------------------");

		// Main Menu

		while (menuOption != 5)
		{

			System.out.print(Store.getMenu());
			menuOption = Store.setOption(scanner);
			switch (menuOption)
			{
			case 1:
				System.out.println("menue 1:");
				if (Store.pwdVerification(scanner))
				{
					System.out.println("------------------------------------------------");
					System.out.println("\tAccess granted");
					System.out.println("------------------------------------------------");

					int addNumber = 0;
					int freeSpace = inventory.getFreeSpace();

					do
					{
						System.out.println("how many computers you want to add: ");
						addNumber = scanner.nextInt();

						if (addNumber > freeSpace)
						{
							System.out.println("Only " + freeSpace + " left");
						}

					} while (addNumber > freeSpace);

					while (addNumber > 0)
					{
						addNumber--;
						scanner.nextLine();
						System.out.println("------------- Adding New Computer --------------");
						System.out.println("Brand:");
						String brand = scanner.nextLine();
						System.out.println("Model:");
						String model = scanner.nextLine();
						System.out.println("Serial Number:");
						long sn = scanner.nextLong();
						System.out.println("Price:");
						double price = scanner.nextDouble();

						inventory.addComputer(brand, model, sn, price);

					}
				}
				else
				{
					System.out.println("------------------------------------------------");
					System.out.println("\tWrong Password");
					System.out.println("------------------------------------------------");
				}
				break;
			case 2:
				System.out.println("menue 2:");
				if (Store.pwdVerification(scanner))
				{ // search by index and update the object
					// if there is no object prompt the user to add a new item
					// else cancel the operation
					System.out.println("------------------------------------------------");
					System.out.println("\tAccess granted");
					System.out.println("------------------------------------------------");
					int index = 0;
					do
					{
						System.out.println("Which computer whould you like to Update:");
						index = scanner.nextInt();
					} while (index < 1 || index >= inventory.getMaxCapacity());

					if (inventory.search(index) == null)
					{
						System.out.println("The computer is not on the inventory");
						System.out.println("Whould you like to add a new computer (y/n)");
						scanner.nextLine();
						String answer = scanner.nextLine();
						if (answer.equals("y"))
						{
							System.out.println("------------- Adding New Computer --------------");
							System.out.println("Brand:");
							String brand = scanner.nextLine();
							System.out.println("Model:");
							String model = scanner.nextLine();
							System.out.println("Serial Number:");
							long sn = scanner.nextLong();
							System.out.println("Price:");
							double price = scanner.nextDouble();

							inventory.addComputer(brand, model, sn, price);
						}
						else
						{
							break;
						}

					}
					else
					{

						Computer updatedComputer = inventory.search(index);
						int option = 0;
						while (option != 5)
						{

							System.out.println(updatedComputer.toString());
							System.out.println("What information would you like to change?");
							System.out.println("\t1. Brand \n\t2. Model \n\t3. SN \n\t4. price \n\t5. Quit");
							option = scanner.nextInt();
							scanner.nextLine();
							switch (option)
							{
							case 1:
								System.out.println("Update Brand: ");
								updatedComputer.setBrand(scanner.nextLine());
								System.out.println("Product Updated ...");

								break;
							case 2:
								System.out.println("Update Model: ");
								updatedComputer.setModel(scanner.nextLine());
								System.out.println("Product Updated ...");

								break;
							case 3:
								System.out.println("Update SN: ");
								updatedComputer.setSerialNumber(scanner.nextLong());
								System.out.println("Product Updated ...");

								break;
							case 4:
								System.out.println("Update Price: ");
								updatedComputer.setPrice(scanner.nextDouble());
								System.out.println("Product Updated ...");

								break;
							case 5:
								break;
							default:
								System.out.print("select and option between 1-5");
							}
						}
					}
				}
				else
				{
					System.out.println("------------------------------------------------");
					System.out.println("\tWrong Password");
					System.out.println("------------------------------------------------");
				}
				break;
			case 3:
				System.out.println("menue 3:");
				System.out.println("Enter a brand:");
				scanner.nextLine();
				String brand = scanner.nextLine();
				inventory.search(brand, "brand");
				break;
			case 4:
				System.out.println("menue 4:");
				System.out.println("Enter a price:");
				double price = scanner.nextDouble();
				inventory.search(price);
				break;
			case 5:
				
				System.out.println("------------------------------------------------");
				System.out.println("\t\tThank you!!!!");
				System.out.println("------------------------------------------------");
				break;
				
			}

		}

		scanner.close();

	}

}
