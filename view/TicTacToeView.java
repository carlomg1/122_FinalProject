package view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import logic.TicTacToLogic;
import java.awt.GridLayout;

import javax.swing.*;

public class TicTacToeView implements GameView {
	public String Player1;
	public String Player2;
	public Board boardGame;
	public JFrame jframe=new JFrame();
	
	
	
	public TicTacToeView() {
		JPanel panel=new JPanel();
		jframe.getContentPane().add(panel);
		jframe.setLayout(null);
		
		jframe.setTitle("TicTacToe");
		jframe.setSize(500, 500);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		
	}

	@Override
	public void startGame() {
		TicTacToLogic games=new TicTacToLogic();
		games.initializeBoard();
		
		//jframe.setVisible(true);

//		boardGame.coordX=3;
//		boardGame.coordY=3;
//	    boardGame.setLayout(new GridLayout(3,3));
	   

	}

	@Override
	public void layoutGrid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateStartGrid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}

}
