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

		inventory.getNumberOfComputers();

		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");

		// Main Menu

		while (menuOption != 5)
		{

			System.out.print(Store.getMenu());

			switch (Store.setOption(scanner))
			{
			case 1:
				System.out.println("menue 1:");
				if (Store.pwdVerification(scanner))
				{ 
					System.out.println("------------------------------------------------");
					System.out.print("\tAccess granted");
					System.out.println("------------------------------------------------");
					
					System.out.println("how many computers you want to add: ");
					int addNumber = scanner.nextInt();
					int freeSpace = inventory.getFreeSpace();
					if( addNumber > freeSpace) {
						System.out.println("Only " + freeSpace + " left");
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
				System.out.print("menue 2:");
				if (Store.pwdVerification(scanner))
				{ 
					System.out.println("------------------------------------------------");
					System.out.print("\tAccess granted");
					System.out.println("------------------------------------------------");
				}
				else
				{
					System.out.println("------------------------------------------------");
					System.out.println("\tWrong Password");	
					System.out.println("------------------------------------------------");
				}
				break;
			case 3:
				System.out.print("menue 3:");
				break;
			case 4:
				System.out.print("menue 4:");
				break;
			case 5:
				System.out.print("menue 5:");
				break;
			}

		}

		scanner.close();

	}

}
