package view;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.*;

public class OthelloView implements GameView {
	public String Player1;
	public String Player2;
	public Board boardGame;
	public JFrame jframe = new JFrame();
	
	public OthelloView() {
		//Set JPanel
		JPanel panel = new JPanel();
		jframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Initialize environment
		jframe.setTitle("Othello");
		jframe.setSize(500,500);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		jframe.setVisible(true);
		
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
