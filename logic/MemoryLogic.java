package logic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.ArrayList;
import java.util.Random;


import java.util.ArrayList;
import javax.swing.*;
import view.MemoryButtonListener;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class MemoryLogic implements GameLogic {
	private static final int MEMORY_BOARD_ROWS = 4;
	private static final int MEMORY_BOARD_COLS = 4;
	private static int completeCount;
	public static boolean isPlayer1Turn = true;
	public static int player1Score = 0;
	public static int player2Score = 0;
	public static MemoryButtonListener previousButton = null;
	public static JLabel score;
	
	
	@Override
	public boolean checkValidMove (JButton button){
		MemoryButtonListener temp = (MemoryButtonListener)button;
		return !temp.revealed;
		
	}
	

	//Not needed for Memory Game
	public ArrayList<?> findValidMove(int row, int col, GameState gameState){		
		return null;
	} // new added

	
	public boolean isValidMove(int row, int col, GameState gameState){
		return false;
	} // new added
	
	
	public boolean checkValidMove(ArrayList<?> validMoves, GameState gstate){
		return false;
	} // new added
	
	
	
	public boolean checkMove(int[][] numbers, int turnRow1, int turnCol1, 
								int turnRow2, int turnCol2) {
		return numbers[turnRow1][turnCol1] == numbers[turnRow2][turnCol2];
	}
	
	public static boolean checkFinish(MemoryButtonListener[][] buttons){
		for(int x = 0; x < MEMORY_BOARD_ROWS; x++) {
			for(int y = 0; y < MEMORY_BOARD_COLS; y++) {
				if(!buttons[x][y].revealed) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public boolean onRoundCheck(){
		return false;
		
	}
	
	public static int[][] InitializeHiddenNums() {
		int[][] hiddenNumbers = new int[MEMORY_BOARD_ROWS][MEMORY_BOARD_COLS];
		
		Map<Integer, Integer> possibleNums = new HashMap<Integer,Integer>();
		possibleNums = InitializePossibleNums();
		Random rand = new Random();
		for(int x = 0; x < MEMORY_BOARD_ROWS; x++) {
			for(int y = 0; y < MEMORY_BOARD_COLS; y++) {
				int numberToPlace;
				while(true) {
					numberToPlace = rand.nextInt(GetUpperBound()) + 1;
					if(AbleToInitializeNum(possibleNums, numberToPlace)) {
						hiddenNumbers[x][y] = numberToPlace;
						int numCount = possibleNums.get(numberToPlace) + 1;
						possibleNums.put(numberToPlace, numCount);
						break;
					}
				}
			}
		}
		return hiddenNumbers;
	}
	
	private static Map<Integer,Integer> InitializePossibleNums() {
		Map<Integer, Integer> possibleNums = new HashMap<Integer, Integer>();
		int upperBound = GetUpperBound();
		for(int i = 1; i <= upperBound; i++) {
			possibleNums.put(i, 0);
		}
		return possibleNums;
	}
	
	//EX: (4 * 4 / 2) + 1 = 9
	//The board will have 16 spaces with each space containing a number between 1-8
	//There will exist a pair for each number from 1-8
	private static int GetUpperBound() {
		return (MEMORY_BOARD_ROWS * MEMORY_BOARD_COLS) / 2;
	}
	
	
	private static boolean AbleToInitializeNum(Map<Integer,Integer> possibleNums, int num) {
		return possibleNums.get(num) < 2;
	}
	
	public static boolean isMatch(MemoryButtonListener button) {
		return previousButton.GetValue() == button.GetValue();
	}
	
	public static boolean isMatch(MemoryButtonListener button) {
		return previousButton.GetValue() == button.GetValue();
	}

	public static void changeTurn() {
		isPlayer1Turn = isPlayer1Turn ? false : true;
	}
	
}