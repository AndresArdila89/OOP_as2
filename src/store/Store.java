package store;

import java.util.Scanner;

public class Store
{
	private String welcomeMessage = "Welcome to the Computer Store\n\n";
	private static String mainMenuText = "What do you want to do? \n \n"
			+ "\t1. Enter new computers. (password required)\n"
			+ "\t2. Change information of a computer. (password required)\n"
			+ "\t3. Display all computers by a specific brand.\n"
			+ "\t4. Display all computers under a certain price.\n" + "\t5. Quit\n\n";

	private Computer[] inventory;
	private static String password = "password";

	public static String getMenu()
	{
		return mainMenuText;
	}

	public static int setOption(Scanner scanner)
	{
		int option = 0;

		do
		{
			System.out.print("Enter a number from 1-5: \n");
			option = scanner.nextInt();
		} while (option < 1 || option > 5);

		return option;
	}

	// password verification
	public static boolean pwdVerification(Scanner scanner)
	{
		int counterWrongPwd = 0;
		boolean verification;
		do
		{
			counterWrongPwd++;
			if (counterWrongPwd > 3)
			{
				return false;
			}
			else
			{
				System.out.println("Enter your password:");
				String pws = scanner.next();
				verification = Validation.verifyPwd(pws, password);
			}

		} while (verification == false);
		return true;
	}

}
