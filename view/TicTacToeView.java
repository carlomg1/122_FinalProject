package view;

import java.awt.Color;
import java.awt.FlowLayout;
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
	public JPanel scoreboard;
	public TicTacToGameState GameState;
	public TicTacToLogic tictactologic;
	static int numberButtons=9;
	public static JButton buttons[] = new JButton[numberButtons];
	public JLabel score;


// goes from startGame is the main, then it will first call layoutGrid and then updateBoard


	@Override
	public void startGame() {
		this.populateStartGrid();
	}

	@Override
	public void layoutGrid() {
		this.frame = new JFrame ("Tic Tac Toe");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.updateBoard();
	}
	@Override
	public void updateBoard() {
		this.panel=new JPanel();
		this.panel.setLayout(new GridLayout(3,3));
		this.panel.setBorder(BorderFactory.createLineBorder (Color.black, 8));
		this.panel.setBackground(Color.white);
		
		this.scoreboard=new JPanel();
		this.scoreboard.setLayout(new FlowLayout());
		this.scoreboard.setBorder(BorderFactory.createLineBorder (Color.black, 8));
		this.scoreboard.setBackground(Color.white);
		
		JSplitPane splitPane=new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(100);
		splitPane.setTopComponent(this.scoreboard);
		splitPane.setBottomComponent(this.panel);
		this.score=new JLabel();
		this.score.setText("Player 1:" + MainGUI.username1   +"  Player 2: " + MainGUI.username2 );
		this.scoreboard.add(score);
		
		this.frame.getContentPane().add(splitPane);		
		
		
		for(int i=0; i<=numberButtons-1; i++){ //placing the button onto the board
			buttons[i] = new buttonListener();
			this.panel.add(buttons[i]);
		}
		//this.frame.getContentPane().add (this.panel);
		//this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setSize(500, 500);
	}
  
	@Override
	public void populateStartGrid() {
		this.layoutGrid();
		this.updateBoard();

		// TODO Auto-generated method stub
		//maybe dont need thisp
	}


}
