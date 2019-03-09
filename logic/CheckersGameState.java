package Logic;

import java.util.ArrayList;

public class CheckersGameState{
	
	private String playerTurn;
	private int score;
	private int[][] playerOneCurrentState;
	private int[][] playerTwoCurrentState;
	
	public CheckersGameState(){
		this.score = 0;
		this.playerTurn = "1";
		this.playerOneCurrentState = new int[][]{
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 1, 0, 1, 0, 1, 0, 1, 0 },
			 { 0, 1, 0, 1, 0, 1, 0, 1 },
			 { 1, 0, 1, 0, 1, 0, 1, 0 }
		};
		this.playerTwoCurrentState = new int[][]{
			 { 0, 1, 0, 1, 0, 1, 0, 1 },
			 { 1, 0, 1, 0, 1, 0, 1, 0 },
			 { 0, 1, 0, 1, 0, 1, 0, 1 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0 }
		};
	}
			
	public void update(){}
	
	public void changeTurn(){
		this.playerTurn = this.playerTurn.equals("1")? "-1":"1";
	}
	
	public void gameLoop(){}
	
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