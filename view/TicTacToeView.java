
package view;

import java.awt.GridLayout;

import logic.TicTacToGameState;
import logic.TicTacToLogic;
import logic.TicTacToLogic.buttonListener;

import java.awt.GridLayout;

import javax.swing.*;

public class TicTacToeView implements GameView {
	public static String Player1;
	public String Player2;
	public Board boardGame;
	public JFrame frame;
	public JPanel panel;
	public TicTacToGameState GameState;
	public TicTacToLogic tictactologic;
	static int numberButtons=9;
	public static JButton buttons[] = new JButton[numberButtons];


// goes from startGame is the main, then it will first call layoutGrid and then updateBoard


	@Override
	public void startGame() {
		this.layoutGrid();
	}

	@Override
	public void layoutGrid() {
		this.frame = new JFrame ("Tic Tac Toe");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.updateBoard();
	}
	@Override
	public void updateBoard() {
		this.panel=new JPanel();
		this.panel.setLayout(new GridLayout(3,3));
		for(int i=0; i<=numberButtons-1; i++){ //placing the button onto the board
			buttons[i] = new buttonListener();
			System.out.println("HERE"+buttons[i]);
			this.panel.add(buttons[i]);
		}
		this.frame.getContentPane().add (this.panel);
		this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setSize(500, 500);

	@Override
	public void populateStartGrid() {

		// TODO Auto-generated method stub
		//maybe dont need thisp
	}


}
