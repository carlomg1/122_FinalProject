package logic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class MemoryLogic implements GameLogic {
	private static final int MEMORY_BOARD_ROWS = 4;
	private static final int MEMORY_BOARD_COLS = 4;
	private static int completeCount;
	public static MemoryButtonListener previousButton = null;
	
	
	
	@Override
	public boolean checkValidMove (JButton button){
		MemoryButtonListener temp = (MemoryButtonListener)button;
		return !temp.revealed;
		
	}
	
	
	public boolean checkMove(int[][] numbers, int turnRow1, int turnCol1, 
								int turnRow2, int turnCol2) {
		return numbers[turnRow1][turnCol1] == numbers[turnRow2][turnCol2];
	}
	
	public boolean checkFinish(MemoryButtonListener[][] buttons){
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
	
	public static boolean isMatch(MemoryButtonListener button) {
		return previousButton.GetValue() == button.GetValue();
	}

}