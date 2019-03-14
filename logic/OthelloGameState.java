package logic;

import java.util.ArrayList;

public class OthelloGameState{
	
	public int playerTurn;
	public int winner = 0;
	public int player1Total;
	public int player2Total;
	public int firstTurn;
	public int none = 0;
	public int black = 1;
	public int white = 2;
	public int[][] board = new int[8][8];
			
	public void update(){}
	public void changeTurn(){}
	public void gameLoop(){}
}