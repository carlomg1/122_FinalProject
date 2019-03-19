package logic;

import java.util.ArrayList;

public class OthelloGameState implements GameState{
	
	public int playerTurn;
	public int winner;
	public int player1Total;
	public int player2Total;
	public int firstTurn;
	public int none;
	public int black;
	public int white;
	public String turnString;
	public String winnerString = "None";
	public int[][] board;
	OthelloLogic othelloLogic;
	
	public OthelloGameState() {
		winner = 0;
		player1Total = 2;
		player2Total = 2;
		none = 0;
		black = 1;
		white = 2;
		turnString = "black";
		board = new int[8][8];
		playerTurn = black;
		othelloLogic = new OthelloLogic();
		othelloLogic.initializeBoard(this);
	}
	
	public void update(){
		
	}//from interface
	
	public void update(int x, int y){
		if(!othelloLogic.findValidMove(x,y,this).isEmpty()) {
			othelloLogic.handleMove(x,y, this);
			othelloLogic.switchTurns(this);
			if(!othelloLogic.searchAllValidMoves(this)) {
				//continue
			}
			else {
				othelloLogic.switchTurns(this);
				if(othelloLogic.searchAllValidMoves(this)) {
					System.out.println("GAME OVER");
					othelloLogic.findWinner(this);
					System.out.println(winnerString);
					//find winner
					//game over
				}
				else {
					//continue
				}
			}
		}
	}//from interface
	public void changeTurn(){
		
	}
	public void gameLoop(){}
}