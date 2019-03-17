package logic;

import java.util.ArrayList;

public class CheckersGameState implements GameState{
	
	private int playerTurn;
	private int score;
	public int[] currentChecker;
	public ArrayList<int[]> validMoves;
	public ArrayList<int[]> flipPieces;
	public Checker[][] checkerBoard;
	public int playerOneCount;
	public int playerTwoCount;
	
	public CheckersLogic checkerLogic;
	
	public CheckersGameState(){
		this.score = 0;
		this.playerTurn = -1;
		
		this.validMoves =new ArrayList<int[]>();
		this.currentChecker = null;
		
		this.checkerLogic = new CheckersLogic();
		
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
		
		// not using
		
	}
	
	public void update(int x, int y){
		// to update the checkBoard based on the logic, this take the coordinates of the clicked button
		if (this.checkerBoard[x][y]!=null && this.checkerBoard[x][y].player==this.playerTurn){
			this.validMoves = (ArrayList<int[]>) this.checkerLogic.findValidMove(x, y, this);
			for ( int[] i : this.validMoves){System.out.println(i[0]+i[1]);}
		
			this.currentChecker = new int[]{x,y};
		}
		
		if (Math.abs(x)==1 && Math.abs(y)==1){
			
		}
	}
	
	public void changeTurn(){
		this.playerTurn = this.playerTurn==1? -1: 1;
	}
	
	public void gameLoop(){}
	
	public int getPlayerTurn()
	{
		return playerTurn;
	}

	public void setPlayerTurn(int playerTurn)
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