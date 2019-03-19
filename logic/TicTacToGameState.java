package logic;

import java.util.ArrayList;

import javax.swing.JButton;

public class TicTacToGameState implements GameState{


	
	static int numberButtons=9;
	private static JButton buttons[] = new JButton[numberButtons]; 
	public String turn;
	int counterSwitchPlayer=0;
	public static int rows=3;
	public static int columns =3;
	public ArrayList<int[]> validMoves;
	public int[][] winCombinations = new int[][] {
		{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
		{0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
		{0, 4, 8}, {2, 4, 6}			 //diagonal wins
};
	
	public TicTacToGameState(){
		//this.score = 0;
		this.counterSwitchPlayer = 0;
		this.validMoves =new ArrayList<int[]>();
	}

	public ArrayList<int[]> getValidMoves()
	{
		return validMoves;
	}
	

			
	public void update(){
		
	}//from interface
	
	public void update(int x, int y){
		
	}//from interface
	public void changeTurn(){}
	public void gameLoop(){}
}