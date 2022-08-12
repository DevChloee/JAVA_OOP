import java.util.Random;

public class Board {
	
	private int width;
	private int height;
	private int[][]board;
	private int totalOnes;
	
	public Board(int w, int h, int howMany) {
		width = w;
		height = h;
		board = new int[h][w];
		addOnes(howMany);
	}
	
	//prints the board
	public void print() {
		System.out.println();
		for (int i = 0; i < board.length; i ++) {
			System.out.println();
			for (int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j]+" ");
		}
		System.out.println("\n");
	}
	
	//increases howMany random locations 
	//on the board by 1
	//also tracks how many times this happens
	public void addOnes(int howMany) {
		Random r = new Random();
		for (int i = 0; i < howMany; i++) {
			board[r.nextInt(height)][r.nextInt(width)]++;
			totalOnes++;
		}
	}
	
	//returns true if there are no ones left
	public boolean gameOver() {
		if (totalOnes < 1)return true;
		return false;
	}
	
	public int[][]getBoard(){
		return board;
	}
	
	public void decrementTotalOnes() {
		totalOnes--;
	}
}
