package logic;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import view.MainGUI;

public class OthelloLogic implements GameLogic {
	public OthelloGameState othelloGameState = new OthelloGameState();
	private int black;
	private int white;
	private ArrayList<Tuple> tilesToFlip = new ArrayList<Tuple>();

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
	
	private boolean checkValidMove(int x, int y) {
		return checkUpper(x,y) || checkLower(x,y) || checkLeft(x,y) || checkRight(x,y);
	}

	public void initializeBoard() {
		othelloGameState.board[3][3] = black;
		othelloGameState.board[3][4] = white;
		othelloGameState.board[4][3] = white;
		othelloGameState.board[4][4] = black;
	}
	

	public OthelloGameState handleMove(int x, int y) {
		if(checkValidMove(x,y)) {
			flipTiles();
			switchTurns();
			tilesToFlip.clear();
			return othelloGameState;
		}
		else {
			return null;
		}
	}
	
	private void flipTiles() {
		for(Tuple coord : tilesToFlip) {
			System.out.println("X: " + coord.x + ", Y: " + coord.y);
			othelloGameState.board[coord.x][coord.y] = othelloGameState.playerTurn;
		}
	}

	private int getOppositeTurn(int currentTurn) {
		if(currentTurn == black) {
			return white;
		}
		else {
			return black;
		}
	}

	private boolean checkUpper(int x, int y) {
		try {
			int oppositeTurn = getOppositeTurn(othelloGameState.playerTurn);
			if(othelloGameState.board[x - 1][y] == oppositeTurn) {
				tilesToFlip.add(new Tuple(x - 1, y));
				tilesToFlip.add(new Tuple(x, y));
				return checkUpper(x - 1, y);
			}
			else if (othelloGameState.board[x - 1][y] == othelloGameState.playerTurn) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {
			return true;
		}

	}

	private boolean checkLower(int x, int y) {
		try {
			int oppositeTurn = getOppositeTurn(othelloGameState.playerTurn);
			if(othelloGameState.board[x+1][y] == oppositeTurn) {
				tilesToFlip.add(new Tuple(x + 1, y));
				tilesToFlip.add(new Tuple(x, y));
				return checkLower(x+1,y);
			}
			else if(othelloGameState.board[x+1][y] == othelloGameState.playerTurn) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {
			return true;

		}

	}

	private boolean checkLeft(int x, int y) {
		try {
			int oppositeTurn = getOppositeTurn(othelloGameState.playerTurn);
			if(othelloGameState.board[x][y-1] == oppositeTurn) {
				tilesToFlip.add(new Tuple(x, y-1));
				tilesToFlip.add(new Tuple(x, y));
				return checkLeft(x, y-1);
			}
			else if(othelloGameState.board[x][y-1] == othelloGameState.playerTurn) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {
			return true;
		}

	}

	private boolean checkRight(int x, int y) {
		try {
			int oppositeTurn = getOppositeTurn(othelloGameState.playerTurn);
			if(othelloGameState.board[x][y+1] == oppositeTurn) {
				tilesToFlip.add(new Tuple(x, y+1));
				tilesToFlip.add(new Tuple(x, y));
				return checkRight(x, y+1);
			}
			else if(othelloGameState.board[x][y+1] == othelloGameState.playerTurn) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {
			return true;
		}

	}

	private void switchTurns() {
		othelloGameState.playerTurn = getOppositeTurn(othelloGameState.playerTurn);
	}
	
	//Taken from stackoverflow
	public class Tuple { 
		  public final int x; 
		  public final int y; 
		  public Tuple(int x, int y) { 
		    this.x = x; 
		    this.y = y; 
		  } 
		} 

}
