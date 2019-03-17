package logic;

import java.util.ArrayList;
import javax.swing.*;

public class CheckersLogic implements GameLogic {
	
	private int turn;
	
	public boolean checkValidMove (JButton button){
		return false;
		
	}
	
	public ArrayList<?> findValidMove(int row, int col, GameState gameState){
		return null;
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