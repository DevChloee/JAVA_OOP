/*
 * Author: Dawon Jun
 * Date: August 05, 2022
 * Description: This method affects the do-while
 * conditional statement of the main method by changing 
 * the boolean value of isWon according to the condition.
 */
import java.util.Random;

/*
 * This class has 1 constructor and 8 methods.
 * Using random class in java library, it create random instance.
 * And randam instance use nextInt method built in random class.
 */
public class HighLowGame {
	private User user = new User(); // internal only, no get/set
	private Random random = new Random(); // internal only, no get/set ..... random.nextInt(11)
	private int fuelAvailable;
	private int numberToGuess;
	private static final int MIN = 1; // internal only, no get/set
	private static final int MAX = 10; // internal only, no get/set

	/*
	 * No argument constructor, calls method reset to initialize the game
	 */
	public HighLowGame() {
		reset();
	}

	/*
	 * Accessor for fuelAvailable
	 */
	public int getFuelAvailable() {
		return fuelAvailable;
	}

	/*
	 * Mutator for fuelAvailable
	 */
	public void setFuelAvailable(int fuelAvailable) {
		this.fuelAvailable = fuelAvailable;
	}

	/*
	 * Access for numberToGuess
	 */
	public int getNumberToGuess() {
		return numberToGuess;
	}

	/*
	 * Mutator for numberToGuess
	 */
	public void setNumberToGuess(int numberToGuess) {
		this.numberToGuess = numberToGuess;
	}

	/*
	 * This method stores a number in numberToGuess
	 * randomly using the nextInt method built into the
	 * random object.
	 */
	public void reset() {
		int sum = 0;
		numberToGuess = random.nextInt(10)+1;
		
		for (int num = MIN; num <= MAX; num++) {
			sum += num;
		}
		fuelAvailable = sum/2;
	}

	/*
	 * This method use a loop and stores the number of times
	 * the user inputs in guessCount. Also, if fuelAvailable
	 * is less than 0, set it to 0 by using an if statement. 
	 */
	public void run() {
		CheckGuessResult checkGuessResult = null;
		String message;
		boolean isWon = false;
		int guessCount = 0;
		int userNumber;
		
		System.out.println("Guess the number from " + MIN + " to " + MAX);
		System.out.println("You have "+ fuelAvailable+" guess-fuel remaining.");
		
		while(fuelAvailable>0 && isWon==false){
			guessCount = guessCount + 1;
			userNumber = user.inputInteger("guess: ");
			
			fuelAvailable = fuelAvailable - userNumber;
			if (fuelAvailable < 0)
				fuelAvailable = 0;
			
			checkGuessResult = checkGuess(userNumber);
			isWon = checkGuessResult.isWin();
			
			message = checkGuessResult.getMessage();
			System.out.println(message);
		}
		
		message = reportGameResult(isWon, guessCount);
		System.out.println(message);
		
	}

	/*
	 * This method examines the guess to see if it matches the numberToGuess
	 * value. To report win or no-win, with a message as well a CheckGuessResult
	 * instance is created with these results, and the reference to the
	 * CheckGuessResult object is returned.
	 */
	private CheckGuessResult checkGuess(int guess) {
		boolean isWin = false;
		String message;

		if (guess == numberToGuess) {
			message = "You guessed the number";
			isWin = true;
		}
		else {
			if(guess < numberToGuess) {
				message = "too low, ";
			}
			else {
				message = "too high, ";
			}
			message = message + String.format(
					"%d guess-fuel remaining", fuelAvailable);
		}
		CheckGuessResult checkGuessResult = new CheckGuessResult(message, isWin);
		return checkGuessResult;
	}
	
	/*
	 * This method writes out a final result of the game (win or lose) as well
	 * as the number of guesses used by the player (i.e. the user).
	 */
	private String reportGameResult(boolean isWon, int guessCount) {
		String message;
		if(isWon) {
			message = "You win! It took you ";
		}
		else {
			message = "You did not win, you used ";
		}
		message = String.format(message + "%d guesses", guessCount);
		return message;
	}
}
