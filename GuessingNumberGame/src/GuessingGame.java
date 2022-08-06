/*
 * Author: Dawon Jun
 * Date: August 05, 2022
 * Description: This program set number randomly and
 * asks the user to guess number. If the number that user 
 * guess matches with the number that program set, the loop ends.
 * If not, program will ask the number until fuelAvailable
 * becomes less than 0.
 */

/*
 * This class contains the main method.
 */
public class GuessingGame {
	
	/*
	 * This main method executes the loop statement
	 * depending on whether the String input 
	 * by the user is Y or N.
	 */
	public static void main(String[] args) {
		
		User user = new User();
		HighLowGame game = new HighLowGame();
		
		String CONTINUE_GAME = "Y";
		String EXIT_GAME = "N";
		String shouldContinue = EXIT_GAME;
		
		do {
			if (shouldContinue.equalsIgnoreCase(CONTINUE_GAME)) 
				game.reset();
			game.run(); 
			shouldContinue = user.inputString("Would you like to play again? (Y/N)"); 
			
			
		} while (shouldContinue.equalsIgnoreCase(CONTINUE_GAME));
		
		System.out.println("Program by Dawon Jun");
		
	}
}
