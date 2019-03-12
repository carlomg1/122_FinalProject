package logic;

import javax.swing.*;

public class TicTacToLogic implements GameLogic {
	
	private String turn;
	
	@Override
	public String getButtonClicked(){
		return turn;
		
	}
	
	
	@Override
	public boolean checkValidMove (JButton button){
		return false;
		
	}
	
	public boolean findWinner(){
		return false;
		
	}
	public void changeTurn(){
		
	}

}