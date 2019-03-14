package logic;

import java.util.ArrayList;

public class CheckersGameState{
	
	private String playerTurn;
	private int score;
	private ArrayList<int[]> validMoves;
	public Checker[][] playerOneCurrentState;
	public Checker[][] playerTwoCurrentState;
	
	public CheckersGameState(){
		this.score = 0;
		this.playerTurn = "1";
		this.validMoves =new ArrayList<int[]>();
		this.playerOneCurrentState = new Checker[][]{
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null },
			 { new Checker(), null, new Checker(), null, new Checker(), null, new Checker(), null },
			 { null, new Checker(), null, new Checker(), null, new Checker(), null, new Checker() },
			 { new Checker(), null, new Checker(), null, new Checker(), null, new Checker(), null }
		};
		this.playerTwoCurrentState = new Checker[][]{
			 { null, new Checker(), null, new Checker(), null, new Checker(), null, new Checker() },
			 { new Checker(), null, new Checker(), null, new Checker(), null, new Checker(), null },
			 { null, new Checker(), null, new Checker(), null, new Checker(), null, new Checker() },
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null },
			 { null, null, null, null, null, null, null, null }
		};
	}
			
	public void update(){}
	
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

	
	class Checker{
		public final int[][] KingMove = new int[][]{
			  { -1, 1 },
			  { 1, 1 },
			  { -1, -1},
			  { 1, -1 }
			};
			
		public final int[][] NormalMove = new int[][]{
			  { -1, 1 },
			  { 1, 1 }
			};
		
		public int[][] move;
		
		public boolean isKing;
		
		public Checker(){
			this.move = NormalMove;
			this.isKing = false;
		}
		
		public void turnKing(){
			this.isKing = true;
			this.move = KingMove;
		}
	}
}