import java.util.Scanner;

/*
 * this is a game where the user has to 
 * specify keeps being asked to enter coordinates
 * to specify the locations of all the numbers
 * greater than 0 on the board
 * each correct entry reduces the number by 1
 * when there are no numbers >0 on the board
 * the game ends
 */

public class Game {

	static Scanner input = new Scanner(System.in);
	static Board board;
	
	public static void main(String[]args) {
		board = new Board(5,5,3);
		
		boolean gameOver = false;
		
		do {
			board.print();
			int[]coors = getCoordinates();
			if (makeMove(coors[0],coors[1]))
				board.decrementTotalOnes();	
			
		}while (!board.gameOver());
		
		System.out.println("Thanks for playing!");
		
	}
	
	//gets coordinates - no fail-safe for bad entries
	public static int[] getCoordinates() {
		int[]coordinates = new int[2];
		System.out.println("Please input x coordinate ");
		coordinates[0] = input.nextInt();
		System.out.println("Please input y coordinate ");
		coordinates[1] = input.nextInt();
		return coordinates;
	}
	
	//if location contains >0 number
	//decrements the number and returns true
	//otherwise returns false
	public static boolean makeMove(int x, int y) {
		int[][]brd = board.getBoard();
		if (brd[y][x] > 0) {
			brd[y][x]--;
			return true;
		}
		return false;
	}
}