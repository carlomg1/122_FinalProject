package logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.*;

import view.MainGUI;

public class OthelloLogic implements GameLogic {
	
	public void initializeBoard(OthelloGameState gamestate) {
		gamestate.board[3][3] = gamestate.black;
		gamestate.board[3][4] = gamestate.white;
		gamestate.board[4][3] = gamestate.white;
		gamestate.board[4][4] = gamestate.black;
	}
	
	
	public void handleMove(int x, int y, OthelloGameState gamestate) {
		ArrayList<Tuple> validMoves = (ArrayList<Tuple>) findValidMove(x,y, gamestate);
		flipTiles(validMoves, gamestate);
		calculateScores(gamestate);
	}
	
	public ArrayList<?> findValidMove(int row, int col, GameState gameState){
		OthelloGameState othelloGameState = (OthelloGameState) gameState;
		ArrayList<Tuple> validMoves = new ArrayList<Tuple>();
		ArrayList<Tuple> directions = new ArrayList<Tuple>();
		directions.add(new Tuple(-1, 0));
		directions.add(new Tuple(
				1, 0));
		directions.add(new Tuple(0, -1));
		directions.add(new Tuple(0, 1));
		directions.add(new Tuple(1, 1));
		directions.add(new Tuple(1, -1));
		directions.add(new Tuple(-1, 1));
		directions.add(new Tuple(-1, -1));
		
		for(Tuple coords : directions) {
			if(isValidMove(row + coords.x, col + coords.y, gameState) && othelloGameState.board[row][col] == othelloGameState.none) {
				validMoves.addAll(checkDirections(row, col, othelloGameState, 
						new ArrayList<Tuple>(), coords.x, coords.y));
			}
			else {
				System.out.println("NOT A VALID MOVE");
			}
		}
		return validMoves;
		
	} // new added
	
	private ArrayList<Tuple> checkDirections(int row, int col, OthelloGameState gameState, 
											ArrayList<Tuple> moves, int rowChange, int colChange){
		try {
			if(gameState.board[row + rowChange][col + colChange] == gameState.none) {
				moves.clear();
				return moves;
			}
			else if(gameState.board[row + rowChange][col + colChange] == getOppositeTurn(gameState)) {
				moves.add(new Tuple(row + rowChange, col + colChange));
				moves.add(new Tuple(row, col));
				return checkDirections(row + rowChange, col + colChange, gameState, moves, rowChange, colChange);
			}
			else if(gameState.board[row + rowChange][col + colChange] == gameState.playerTurn) {
				return moves;
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException) {
			moves.clear();
			return moves;
		}
		return moves;
	}
	
	public boolean isValidMove(int row, int col, GameState gameState){
		try {
			OthelloGameState othelloGameState = (OthelloGameState) gameState;
			return othelloGameState.board[row][col] == getOppositeTurn(othelloGameState);
		}
		catch(Exception ArrayIndexOutOfBoundsException) {
			return false;
		}
		
	} // new added

	@Override
	public boolean checkValidMove (JButton button){
		return false;

	}
	
	public boolean checkValidMove(ArrayList<?> validMoves, GameState gstate){
		return false;
	} // new added

	public boolean findWinner(){
		return false;

	}
	
	public void changeTurn(){

	}
	
	private void flipTiles(ArrayList<Tuple> validMoves, OthelloGameState gamestate) {
		for(Tuple coord : validMoves) {
			gamestate.board[coord.x][coord.y] = gamestate.playerTurn;
		}
	}

	private int getOppositeTurn(OthelloGameState gamestate) {
		if(gamestate.playerTurn == gamestate.black) {
			return gamestate.white;
		}
		else {
			return gamestate.black;
		}
	}

	public void switchTurns(OthelloGameState gamestate) {
		if(gamestate.turnString == "black") {
			gamestate.turnString = "white";
		}
		else {
			gamestate.turnString = "black";
		}
		gamestate.playerTurn = getOppositeTurn(gamestate);
	}
	
	private void calculateScores(OthelloGameState gamestate) {
		gamestate.player1Total = 0;
		gamestate.player2Total = 0;
		for(int i = 0; i < 8 ; i++) {
			for(int j = 0 ; j < 8 ; j++) {
				if(gamestate.board[i][j] == gamestate.black) {
					gamestate.player1Total += 1;
				}
				else if(gamestate.board[i][j] == gamestate.white) {
					gamestate.player2Total += 1;
				}
			}
		}
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
