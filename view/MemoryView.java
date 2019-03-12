package view;
import logic.MemoryGameState;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MemoryView implements GameView {
	private static final int BOARD_ROWS = 4;
	private static final int BOARD_COLS = 4;
	private static JButton buttons[][] = new JButton[BOARD_ROWS][BOARD_COLS];
	private String player1;
	private String player2;
	private Board boardGame;
	MemoryGameState currentState;
	
	 private class ButtonListener extends JButton implements ActionListener
	    {
		 
		 public ButtonListener() {
			 addActionListener(this);// allows button to be clickable and start performing the actions on it
		 	}
		 
	        public void actionPerformed(ActionEvent action) 
	        {
	        	System.out.println("Button pressed");
	        }
	        
	        
}
	
	
	
	public MemoryView(String p1, String p2) {
		player1 = p1;
		player2 = p2;
		currentState = new MemoryGameState(p1, p2);
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Memory Match");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(BOARD_ROWS, BOARD_COLS ));
		for(int x = 0; x < BOARD_ROWS; x++) {
			for(int y = 0; y < BOARD_COLS; y++) {
				buttons[x][y] = new ButtonListener();
				panel.add(buttons[x][y]);
			}
		}

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800, 800);
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
