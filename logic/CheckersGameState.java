package logic;

import java.util.ArrayList;

public class CheckersGameState{
	
	private String playerTurn;
	private int score;
	private ArrayList<int[]> validMoves;
	public Checker[][] checkerBoard;
	public int playerOneCount;
	public int playerTwoCount;
	
	public CheckersGameState(){
		this.score = 0;
		this.playerTurn = "1";
		this.validMoves =new ArrayList<int[]>();
		
		this.playerOneCount = 12;
				
		this.playerTwoCount = 12;
		
		this.checkerBoard = new Checker[][]{
			 { null, new Checker(1), null, new Checker(1), null, new Checker(1), null, new Checker(1) },
			 { new Checker(1), null, new Checker(1), null, new Checker(1), null, new Checker(1), null },
			 { null, new Checker(1), null, new Checker(1), null, new Checker(1), null, new Checker(1) },
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null },
			 { new Checker(-1), null, new Checker(-1), null, new Checker(-1), null, new Checker(-1), null },
			 { null, new Checker(-1), null, new Checker(-1), null, new Checker(-1), null, new Checker(-1) },
			 { new Checker(-1), null, new Checker(-1), null, new Checker(-1), null, new Checker(-1), null }
		};
	}
			
	public void update(){
		// to update the checkBoard based on the logic
		
	}
	
	public void changeTurn(){
		this.playerTurn = this.playerTurn.equals("1")? "-1":"1";
	}
	
	public void gameLoop(){}
	
	public String getPlayerTurn()
	{
		return playerTurn;
	}

	public void setPlayerTurn(String playerTurn)
	{
		this.playerTurn = playerTurn;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public ArrayList<int[]> getValidMoves()
	{
		return validMoves;
	}

	public void setValidMoves(ArrayList<int[]> validMoves)
	{
		this.validMoves = validMoves;
	}

	public int returnPlayer( Checker checker){
		return checker.player;
	}
	
	class Checker{
		
		public int[][] move;
		
		public boolean isKing;
		
		public int player;
		
		public Checker( int player ){
			this.isKing = false;
			this.player=player;
			this.move = new int[][]{
				  { 1*this.player, -1*this.player },
				  { 1*this.player, 1*this.player }
				};
		}
		
		public void turnKing(){
			this.isKing = true;
			this.move = new int[][]{
				  { -1*this.player, 1*this.player },
				  { 1*this.player, 1*this.player },
				  { -1*this.player, -1*this.player},
				  { 1*this.player, -1*this.player }
				};
		}
	}
}