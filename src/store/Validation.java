package store;

public class Validation {

	public static boolean verifyPwd(String pwd, String password) 
	{
		if(pwd.equals(password)) 
		{
			return  true;
		}
		else 
		{

			return false;
		}
	}
	
}
