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

			
	public void update(){
		
	}//from interface
	
	public void update(int x, int y){
		
	}//from interface
	public void changeTurn(){}
	public void gameLoop(){}
}