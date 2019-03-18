package view;
import logic.MemoryButtonListener;
import logic.MemoryGameState;
import logic.MemoryLogic;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class MemoryView implements GameView {
	private static final int BOARD_ROWS = 4;
	private static final int BOARD_COLS = 4;
	private static MemoryButtonListener buttons[][] = new MemoryButtonListener[BOARD_ROWS][BOARD_COLS];
	private String player1;
	private String player2;
	MemoryGameState currentState;

	
	
	public MemoryView(String p1, String p2) {
		player1 = p1;
		player2 = p2;
		currentState = new MemoryGameState(p1, p2);
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		this.layoutGrid();
	}

	public static void HideOrRevealSpace(int row, int col, boolean reveal) {
		buttons[row][col].revealed = reveal;
		if(reveal) {
			buttons[row][col].setText(Integer.toString(buttons[row][col].GetValue()));	
		}
		else {
			buttons[row][col].setText("");
		}
		
	}
	
	@Override
	public void layoutGrid() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Memory Match");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(BOARD_ROWS, BOARD_COLS ));
		for(int x = 0; x < BOARD_ROWS; x++) {
			for(int y = 0; y < BOARD_COLS; y++) {
				buttons[x][y] = new MemoryButtonListener(x, y, currentState.GetValue(x, y));
				panel.add(buttons[x][y]);
			}
		}

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1280, 720);
		
		ChangeButtonBorders(true);
		
		//CREATE A TIMER SO THAT ALL NUMS ARE SET TO BE HIDDEN AFTER SOME TIME AFTER STARTUP
		Timer timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				for(int x = 0; x < BOARD_ROWS; x++) {
					for(int y = 0; y < BOARD_COLS; y++) {
						buttons[x][y].setText("");
						buttons[x][y].setEnabled(true);
					}
				}
			}
		});
		timer.setRepeats(false);
		timer.start();
		
	}
	
	public static void EnableOrDisableButtons(boolean enableOrDisable) {
		for(int x = 0; x < BOARD_ROWS; x++) {
			for(int y = 0; y < BOARD_COLS; y++) {
				buttons[x][y].setEnabled(enableOrDisable);
			}
		}		
	}

	//Changes the button borders depending on whose turn it is
	//Player 1 is Blue
	//Player 2 is Red
	public static void ChangeButtonBorders(boolean isPlayer1Turn) {
		for(int x = 0; x < BOARD_ROWS; x++) {
			for(int y = 0; y < BOARD_COLS; y++) {
				if(isPlayer1Turn) {
					buttons[x][y].setBorder(BorderFactory.createLineBorder(Color.blue));	
				}
				else {
					buttons[x][y].setBorder(BorderFactory.createLineBorder(Color.red));
				}	
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

}