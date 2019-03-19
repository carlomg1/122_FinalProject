package view;
<<<<<<< HEAD
=======
import logic.MemoryButtonListener;
>>>>>>> master
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
<<<<<<< HEAD
import javax.swing.JOptionPane;
import javax.swing.JPanel;
=======
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
>>>>>>> master
import javax.swing.Timer;



public class MemoryView implements GameView {
	private static final int BOARD_ROWS = 4;
	private static final int BOARD_COLS = 4;
<<<<<<< HEAD
	private static MemoryButtonListener buttons[][] = new MemoryButtonListener[BOARD_ROWS][BOARD_COLS];
	private String player1;
	private String player2;
	MemoryGameState currentState;
=======
	public static MemoryButtonListener buttons[][] = new MemoryButtonListener[BOARD_ROWS][BOARD_COLS];
	private static String player1;
	private static String player2;
	public static MemoryGameState currentState;
	public static JFrame frame;
	public static JPanel panel;
	public static JPanel scorePanel;
	public static JSplitPane splitPane;
	public static JLabel score;
>>>>>>> master

	
	
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
<<<<<<< HEAD
		JFrame frame = new JFrame("Memory Match");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
=======
		splitPane = new JSplitPane();
		frame = new JFrame("Memory Match");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
>>>>>>> master
		panel.setLayout(new GridLayout(BOARD_ROWS, BOARD_COLS ));
		for(int x = 0; x < BOARD_ROWS; x++) {
			for(int y = 0; y < BOARD_COLS; y++) {
				buttons[x][y] = new MemoryButtonListener(x, y, currentState.GetValue(x, y));
				panel.add(buttons[x][y]);
			}
		}
<<<<<<< HEAD

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1280, 720);
		
		//CREATE A TIMER SO THAT ALL NUMS ARE SET TO BE HIDDEN AFTER SOME TIME AFTER STARTUP
		Timer timer = new Timer(5000, new ActionListener() {
=======
		scorePanel = new JPanel();
		//Configure JSplitPlane and add the panels to it
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(100);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(scorePanel);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(panel);
		frame.getContentPane().add(splitPane);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1280, 720);
		
		ChangeButtonBorders(true);
		
		//Scoreboard
		score = new JLabel();
		score.setFont(score.getFont ().deriveFont (35.0f));
		score.setText("MEMORY");
		scorePanel.add(score);
		UpdateScore();
		
		//CREATE A TIMER SO THAT ALL NUMS ARE SET TO BE HIDDEN AFTER SOME TIME AFTER STARTUP
		Timer timer = new Timer(3000, new ActionListener() {
>>>>>>> master
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
	
	public static void Reset() {
		MemoryLogic.player1Score = 0;
		MemoryLogic.player2Score = 0;
		MemoryLogic.isPlayer1Turn = true;
		
		currentState = new MemoryGameState(player1, player2);
		for(int x = 0; x < BOARD_ROWS; x++) {
			for(int y = 0; y < BOARD_COLS; y++) {
				buttons[x][y].ChangeValue(currentState.GetValue(x, y));
				buttons[x][y].setText(Integer.toString(buttons[x][y].GetValue()));	
				buttons[x][y].setEnabled(false);
				buttons[x][y].revealed = false;
			}
		}
		UpdateScore();
		ChangeButtonBorders(MemoryLogic.isPlayer1Turn);
		Timer timer = new Timer(3000, new ActionListener() {
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
	
	public static void UpdateScore() {
		score.setText(player1 + ": " + Integer.toString(MemoryLogic.player1Score) + "                     " + 
						player2 + ": " + Integer.toString(MemoryLogic.player2Score));
		scorePanel.add(score);
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