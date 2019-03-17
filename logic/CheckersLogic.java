package logic;

import java.util.ArrayList;
import javax.swing.*;

public class CheckersLogic implements GameLogic {
	
	private int turn;
	
	public boolean checkValidMove (JButton button){
		return false;
		
	}
	
	public <T> ArrayList<?> findValidMove(int row, int col, GameState gameState){
//		System.out.print(row+col);
		
		CheckersGameState checkerState = (CheckersGameState) gameState;
		
//		System.out.print(checkerState.checkerBoard);
		
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
		CheckersGameState checkerState = (CheckersGameState) gameState;
		int[] move = new int[2];
		move[0] = row;
		move[1] = col;
		
		if(checkerState.validMoves.contains(move)) {
			return true;
		}
		return false;	
	}
	public <T> ArrayList<?> removePieces(int[] dest, GameState gameState) {
		CheckersGameState checkerState = (CheckersGameState) gameState;
		ArrayList<T> flipPieces = new ArrayList<T>();
		for(int[] move: checkerState.checkerBoard[checkerState.currentChecker[0]][checkerState.currentChecker[1]].move) {
			try {
				if(checkerState.checkerBoard[checkerState.currentChecker[0]+move[0]][checkerState.currentChecker[1]+move[1]].player != checkerState.checkerBoard[checkerState.currentChecker[0]][checkerState.currentChecker[1]].player) {
					if(checkerState.checkerBoard[checkerState.currentChecker[0]+ 2*move[0]][checkerState.currentChecker[1]+ 2*move[1]] == null) {
						int[] flipMe = new int[2];
						flipMe[0] = checkerState.currentChecker[0]+ 2*move[0];
						flipMe[1] = checkerState.currentChecker[1]+ 2*move[1];
						flipPieces.add((T) flipMe);
					}
				}
			}
			catch(Exception e) {
				
			}
		}
		return flipPieces;
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