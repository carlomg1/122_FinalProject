package logic;

import java.util.ArrayList;
import javax.swing.*;

public class CheckersLogic implements GameLogic {
	
	private int turn;
	
	public boolean checkValidMove (JButton button){
		return false;
		
	}
	
	public <T> ArrayList<?> findValidMove(int row, int col, GameState gameState){
		System.out.print(row+col);
		
		CheckersGameState checkerState = (CheckersGameState) gameState;
		
		System.out.print(checkerState.checkerBoard);
		
		ArrayList<T> validMoves = new ArrayList<T>();
		for(int[] move: checkerState.checkerBoard[row][col].move) {
			try {
				if(checkerState.checkerBoard[row+move[0]][col+move[1]] == null) {
					int[] newMove = new int[2];
					newMove[0] = row+ move[0];
					newMove[1] = col+ move[1];
					validMoves.add((T) newMove);
				}
				else if(checkerState.checkerBoard[row+move[0]][col+move[1]].player != checkerState.checkerBoard[row][col].player) {
					if(checkerState.checkerBoard[row+ 2*move[0]][col+ 2*move[1]] == null) {
						int[] newMove = new int[2];
						newMove[0] = row+ 2*move[0];
						newMove[1] = col+ 2*move[1];
						validMoves.add((T) newMove);
					}
				}
			}catch(Exception e){
				continue;
			}
		}
		return validMoves;
	}

	public boolean isValidMove(int row, int col, GameState gameState){
		return false;
	}
	
	
	public boolean checkValidMove(ArrayList<?> validMoves, GameState gstate){
		return false;
	}
	
	
	public boolean findWinner(){
		return false;
		
	}
	public void changeTurn(){
		
	}


}