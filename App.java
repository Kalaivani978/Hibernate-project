package JavaFSD.JavaFSDMaven1;
import java.util.Scanner;
/*
 * This is the main class method. Here the program starts at first.
 */

public class App 

{
	private static Scanner scan = new Scanner(System.in);	
	
	public static void main( String[] args )
	{
		System.out.println("Enter the user name");
		String username = scan.next();
		System.out.println("Enter the password");
		String password = scan.next();
		SwiggyBlueprint.toCheckLogin(username, password);

	}



}
