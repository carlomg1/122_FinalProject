package logic;

import java.util.ArrayList;
import javax.swing.*;

public class CheckersLogic implements GameLogic {
	
	private int turn;
	
	public boolean checkValidMove (JButton button){
		return false;
		
	}
	
	public <T> ArrayList<?> findValidMove(int row, int col, CheckersGameState gameState){
		ArrayList<T> validMoves = new ArrayList<T>();
		for(int[] move: gameState.checkerBoard[row][col].move) {
			if(gameState.checkerBoard[row+move[0]][col+move[1]].player != gameState.checkerBoard[row][col].player) {
				if(gameState.checkerBoard[row+ 2*move[0]][col+ 2*move[1]] == null) {
					int[] newMove = new int[2];
					newMove[0] = row+ 2*move[0];
					newMove[1] = col+ 2*move[1];
					validMoves.add((T) newMove);
				}
			}else if(gameState.checkerBoard[row+move[0]][col+move[1]] == null) {
				int[] newMove = new int[2];
				newMove[0] = row+ 2*move[0];
				newMove[1] = col+ 2*move[1];
				validMoves.add((T) newMove);
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