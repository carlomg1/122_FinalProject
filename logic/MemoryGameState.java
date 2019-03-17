package logic;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class MemoryGameState implements GameState{
	private static final int BOARD_ROWS = 4;
	private static final int BOARD_COLS = 4;
	
	private String player1;
	private String player2;
	private int playerTurn;
	private int p1Score;
	private int p2Score;
	private Map<Integer, Integer> possibleNums;

//	private int[][] playerOneCurrentState;
//	private int[][] playerTwoCurrentState;
//	
	//Shows if the space the user has clicked on is revealed or not
	//Switches to True if user clicks the space or if the user guesses a correct pair
	//Switches back to False if user clicks one and then clicks the wrong one next
	private boolean[][] revealedSpace;
	
	//Stores pairs of random numbers within these spaces
	private int[][] hiddenNumbers;
	
	public MemoryGameState(String p1, String p2) {
		possibleNums = new HashMap<Integer, Integer>();
		player1 = p1;
		player2 = p2;
		playerTurn = 1;
		revealedSpace = new boolean[BOARD_ROWS][BOARD_COLS];
		for(int x = 0; x < BOARD_ROWS; x++) {
			for(int y = 0; y < BOARD_COLS; y++) {
				revealedSpace[x][y] = false;
			}
		}
		InitializePossibleNums();
		hiddenNumbers = new int[BOARD_ROWS][BOARD_COLS];
		InitializeHiddenNums();
		
	}
	
	public int GetValue(int x, int y) {
		return hiddenNumbers[x][y];
	}
	
	public void update(){} // from interface
	
	public void changeTurn(){
		playerTurn = playerTurn == 1 ? 2 : 1;
	}
	
	
	public void gameLoop(){}
	
	
	private void InitializePossibleNums() {
		int upperBound = GetUpperBound();
		for(int i = 1; i <= upperBound; i++) {
			possibleNums.put(i, 0);
		}
	}
	
	private void InitializeHiddenNums() {
		Random rand = new Random();
		for(int x = 0; x < BOARD_ROWS; x++) {
			for(int y = 0; y < BOARD_COLS; y++) {
				int numberToPlace;
				while(true) {
					numberToPlace = rand.nextInt(GetUpperBound()) + 1;
					if(AbleToInitializeNum(numberToPlace)) {
						hiddenNumbers[x][y] = numberToPlace;
						int numCount = possibleNums.get(numberToPlace) + 1;
						possibleNums.put(numberToPlace, numCount);
						break;
					}
				}
			}
		}
	}

	private boolean AbleToInitializeNum(int num) {
		return possibleNums.get(num) < 2;
	}
	
	
	//EX: (4 * 4 / 2) + 1 = 9
	//The board will have 16 spaces with each space containing a number between 1-8
	//There will exist a pair for each number from 1-8
	private int GetUpperBound() {
		return (BOARD_ROWS * BOARD_COLS) / 2;
	}
	
	public void update(int x, int y){
		
	} // from interface
}