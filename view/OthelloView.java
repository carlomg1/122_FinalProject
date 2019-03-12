package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OthelloView implements GameView {
	public String Player1;
	public String Player2;
	public Board boardGame;
	public JFrame jframe = new JFrame();
	public JPanel panel;
	public int numberButtons;
	public JButton buttons[][];
	
	public OthelloView() {
		//Set JPanel
		panel = new JPanel();
		panel.setBorder (BorderFactory.createLineBorder (Color.black, 8));
		panel.setBackground (Color.GREEN);
		jframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Initialize environment
		jframe.setTitle("Othello");
		jframe.setSize(500,500);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		
		//Initialize Button Array
		numberButtons=64;
		buttons = new JButton[8][8]; 
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		layoutGrid();
		populateStartGrid();
		jframe.setVisible(true);
		
	}

	@Override
	public void layoutGrid() {
		panel.setLayout (new GridLayout (8, 8));	
		for(int i = 0 ; i < 8 ; i++){
			for(int j = 0 ; j < 8 ; j++) {
				JButton button = new JButton();
				buttons[i][j] = button;
				button.setBackground(Color.green);
				button.setForeground(Color.black);
				button.setOpaque(true);
				button.setBorder(BorderFactory.createLineBorder(Color.black));
				panel.add(button);
			}
		}
	}

	@Override
	public void populateStartGrid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}
	
	private class buttonListener extends JButton implements ActionListener
    {
	 
	 public buttonListener() {
		 addActionListener(this);// allows button to be clickable and start performing the actions on it
	 	}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
        
    }

}
