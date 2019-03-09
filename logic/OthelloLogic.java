package logic;

import javax.swing.*;

import view.MainGUI;

public class OthelloLogic implements GameLogic {
	OthelloGameState othelloGameState = new OthelloGameState();
	
	@Override
	public boolean checkValidMove (JButton button){
		return false;
		
	}
	
	public boolean findWinner(){
		return false;
		
	}
	public void changeTurn(){
		
	}
	
	public void initializeBoard() {
		othelloGameState.board[3][3] = othelloGameState.black;
		othelloGameState.board[3][4] = othelloGameState.white;
		othelloGameState.board[4][3] = othelloGameState.white;
		othelloGameState.board[4][4] = othelloGameState.black;
		
		for(int row = 0 ; row < othelloGameState.board.length ; row++) {
			System.out.println();
			for(int j = 0 ; j < othelloGameState.board.length ; j++) {
				System.out.print(othelloGameState.board[row][j]);
			}
		}
	}
	
	public static void main (String[] args) {
		OthelloLogic othelloLogic = new OthelloLogic();
		othelloLogic.initializeBoard();
	}

}