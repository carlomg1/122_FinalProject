package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainGUI extends JFrame {
	
	public MainGUI() {
		//Set JPanel
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//Create buttons for each game
		JButton checkersButton = addGameButton("Checkers", 70, new CheckersView());
		JButton memoryButton = addGameButton("Memory", 150, new MemoryView());
		JButton othelloButton = addGameButton("Othello", 230, new OthelloView());
		JButton tictactoeButton = addGameButton("TicTacToe", 310, new TicTacToeView());
		
		//Add buttons to panel
		panel.add(checkersButton);
		panel.add(memoryButton);
		panel.add(othelloButton);
		panel.add(tictactoeButton);
		
		
		//Initialize environment
		setTitle("Game Environment");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates a new instance of MainGUI and runs it.
	 * Was not sure if the main should actually be in a login
	 * page, UML doesn't specify it.
	 * @param args
	 */
	public static void main (String[] args) {
		//Start the MainGUI
		MainGUI main = new MainGUI();
		main.setVisible(true);
	}
	
	/**
	 * 
	 * @param gameView
	 */
	public void selectGame(GameView gameView){
		gameView.startGame();
	}
	
	/**
	 * Creates a button and attaches an event listener. The 
	 * event listener should fire the game, but for now, only
	 * quits.
	 * @param game specifies the game text the button should have
	 * @param y specifies the y pos of the button
	 * @return a new JButton created
	 */
	private JButton addGameButton(String game, int y, GameView gameview) {
		JButton checkersButton = new JButton(game);
	       checkersButton.setBounds(100, y, 300, 70);
	       checkersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectGame(gameview);
				System.exit(0);
			}
	       });
	       return checkersButton;
	}
}
