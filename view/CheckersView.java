package View;

import java.awt.*;  
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;

public class CheckersView implements GameView {
	public String Player1;
	public String Player2;
	public Board boardGame;
	public JFrame frame;
	public JPanel panel;
	public Button[][] buttons;
	
	public CheckersView() {
		this.buttons = new Button[8][];
		for (int i = 0; i<8; ++i){
			this.buttons[i]=new Button[8];
		}
		this.startGame();
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		this.layoutGrid();
		
	}

	@Override
	public void layoutGrid() {
		// TODO Auto-generated method stub
		this.frame = new JFrame ("Checkers");
		this.frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		this.panel = new JPanel(); //creating a panel with a box like a checker board
		this.panel.setLayout(new GridLayout(8, 8));
		this.panel.setBorder (BorderFactory.createLineBorder (Color.red, 8));
		this.panel.setBackground (Color.white);
		
		boolean black;
		for(int i=0; i<8; i++){ //placing the button onto the board
			if ( i % 2 == 0){
				black = true;
			}else{
				black = false;
			}
			for (int j =0; j<8; ++j){
				if (black){
					final JLabel label = new JLabel();
					label.setBackground(Color.gray);
					label.setForeground(Color.gray);
					label.setOpaque(true);
					label.setBorder(BorderFactory.createLineBorder(Color.gray));
					this.panel.add(label);
					black = false;
				}else{
					final JLabel label = new JLabel();
					label.setBackground(Color.white);
					label.setForeground(Color.white);
					label.setOpaque(true);
					label.setBorder(BorderFactory.createLineBorder(Color.gray));
					this.panel.add(label);
					black = true;
				}
				//buttons[i][j] = new Button();
				//this.panel.add(buttons[i][j]);	
			}
		}
		this.frame.getContentPane().add(panel);
		this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setSize(500, 500);
		
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
