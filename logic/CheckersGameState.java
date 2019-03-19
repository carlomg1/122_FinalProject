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
		
		this.playerOneCount = 12; // change to 12
				
		this.playerTwoCount = 12; // change to 12
		
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
			
			this.currentChecker = new int[]{x,y};
			
		} //if player want to check valid moves, do program above
		else if (this.currentChecker!=null && this.validMoves.size()!=0 && this.checkerBoard[x][y]==null){

			if (this.checkerLogic.isValidMove(x, y, this)){
				
				this.flipPieces = (ArrayList<int[]>) this.checkerLogic.removePieces(new int[]{x, y}, this);
				
				if (this.flipPieces!=null){
					this.checkerBoard[x][y]=this.checkerBoard[this.currentChecker[0]][this.currentChecker[1]];
					this.checkerBoard[this.currentChecker[0]][this.currentChecker[1]]=null;
					for (int[] move : this.flipPieces){
						this.checkerBoard[move[0]][move[1]]=null;
						if (this.playerTurn==-1) this.playerTwoCount-=1;
						else this.playerOneCount-=1;
					}
				}else{
					this.checkerBoard[x][y]=this.checkerBoard[this.currentChecker[0]][this.currentChecker[1]];
					this.checkerBoard[this.currentChecker[0]][this.currentChecker[1]]=null;
				}
				
				if (x==7 && this.checkerBoard[x][y].player==1){
					this.checkerBoard[x][y].turnKing();
				}
				else if (x==0 && this.checkerBoard[x][y].player==-1){
					this.checkerBoard[x][y].turnKing();
				}
				
				this.currentChecker = null;
				this.validMoves = new ArrayList<int[]>();
				this.flipPieces = null;
				this.changeTurn();
			}
		} // if player want to move checker after checking valid move, do program above
		
	}
	
	public void changeTurn(){
		this.playerTurn = this.playerTurn==1? -1: 1;
	}
	
	public int gameLoop(int x, int y){
		this.update( x, y);
		return this.checkerLogic.findWinner(this);
	} // what is this
	
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
	
	public boolean isKing( Checker checker){
		return checker.isKing;
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