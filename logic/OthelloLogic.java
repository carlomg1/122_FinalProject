package logic;

import java.util.ArrayList;
import javax.swing.*;

import view.MainGUI;

public class OthelloLogic implements GameLogic {
	public OthelloGameState othelloGameState = new OthelloGameState();
	private int black;
	private int white;

	public OthelloLogic() {
		black = othelloGameState.black;
		white = othelloGameState.white;
		othelloGameState.playerTurn = black;
		initializeBoard();
	}

	@Override
	public boolean checkValidMove (JButton button){
		return false;

	}
	
	public ArrayList<?> findValidMove(int row, int col, GameState gameState){
		return null;
	} // new added

	public boolean isValidMove(int row, int col, GameState gameState){
		return false;
	} // new added
	
	
	public boolean checkValidMove(ArrayList<?> validMoves, GameState gstate){
		return false;
	} // new added

	public boolean findWinner(){
		return false;

	}
	public void changeTurn(){

	}

	public void initializeBoard() {
		othelloGameState.board[3][3] = black;
		othelloGameState.board[3][4] = white;
		othelloGameState.board[4][3] = white;
		othelloGameState.board[4][4] = black;
	}

	public OthelloGameState handleMove(int x, int y) {
		if(isValidMove(x,y)) {
			switchTurns();
			return othelloGameState;
		}
		else {
			return null;
		}
	}

	private int getOppositeTurn(int currentTurn) {
		if(currentTurn == 1) {
			return 2;
		}
		else {
			return 1;
		}
	}

	private boolean checkUpper(int x, int y) {
		try {
			int oppositeTurn = getOppositeTurn(othelloGameState.playerTurn);
			if(othelloGameState.board[x - 1][y] == oppositeTurn) {
				System.out.println("Valid");
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {

		}
		return false;

	}

	private boolean checkLower(int x, int y) {
		try {
			int oppositeTurn = getOppositeTurn(othelloGameState.playerTurn);
			if(othelloGameState.board[x+1][y] == oppositeTurn) {
				System.out.println("Valid");
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {

		}
		return false;

	}

	private boolean checkLeft(int x, int y) {
		try {
			int oppositeTurn = getOppositeTurn(othelloGameState.playerTurn);
			if(othelloGameState.board[x][y-1] == oppositeTurn) {
				System.out.println("Valid");
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {

		}
		return false;

	}

	private boolean checkRight(int x, int y) {
		try {
			int oppositeTurn = getOppositeTurn(othelloGameState.playerTurn);
			if(othelloGameState.board[x][y+1] == oppositeTurn) {
				System.out.println("Valid");
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {

		}
		return false;

	}

	private boolean isValidMove(int x, int y) {
		if(othelloGameState.board[x][y] == 0 && (checkUpper(x,y)
				|| checkLower(x,y)
				|| checkRight(x,y)
				|| checkLeft(x,y))) {
			return true;
		}
		else {
			return false;
		}
	}

	private void switchTurns() {
		othelloGameState.playerTurn = getOppositeTurn(othelloGameState.playerTurn);
	}

}
