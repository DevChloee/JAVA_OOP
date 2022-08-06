/*
 * Author: Dawon Jun
 * Date: August 05, 2022
 * Description: This class is used by importing scanner.
 * The five methods perform similar functions, but each
 * have different return types and parameters.
 */

import java.util.Scanner;

/*
 * This class helps the efficient use of the scanner class
 * when the user inputs input
 * */
public class User {
	
	private Scanner keyboard = new Scanner(System.in);
	
	/*
	 * This method stores the integer entered by the user
	 * and returns the value
	 */
	public int inputInteger() {
		int value = keyboard.nextInt();
		keyboard.nextLine();
		return value;
	}
	
	/* 
	 * This method needs parameter as string variable and
	 * prints out that parameter and stores the the value 
	 * by calling inputInteger method and returns the value
	 * */
	public int inputInteger(String message) {
		System.out.println(message);
		int value = inputInteger();
		return value;
	}
	
	/*
	 * This method stores the double entered by the user
	 * and returns the value
	 */
	public double inputDouble() {
		double value = keyboard.nextDouble();
		keyboard.nextLine();
		return value;	
	}
	
	/*
	 * This method needs parameter as string variable and
	 * prints out that parameter and stores the the value 
	 * by calling inputDouble method and returns the value
	 */
	public double inputDouble(String message) {
		System.out.println(message);
		double value = inputDouble();
		return value;
	}

	public String inputString(String message) {
		System.out.println(message);
		String value = keyboard.nextLine();
		return value;
	}
}
