package logic;

import javax.swing.*;

public class MemoryLogic implements GameLogic {
	private static final int MEMORY_BOARD_ROWS = 4;
	private static final int MEMORY_BOARD_COLS = 4;
	private static int completeCount;
	
	
	@Override
	public String getButtonClicked(){
		return null;
		
	}
	
	
	@Override
	public boolean checkValidMove (JButton button){
		return false;
		
	}
	
	
	public boolean checkMove(int[][] numbers, int turnRow1, int turnCol1, 
								int turnRow2, int turnCol2) {
		return numbers[turnRow1][turnCol1] == numbers[turnRow2][turnCol2];
	}
	
	public boolean checkFinish(boolean[][] revealed){
		for(int x = 0; x < MEMORY_BOARD_ROWS; x++) {
			for(int y = 0; y < MEMORY_BOARD_COLS; y++) {
				if(!revealed[x][y]) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public boolean onRonudCheck(){
		return false;
		
	}

}
