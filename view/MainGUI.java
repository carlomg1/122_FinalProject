package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainGUI extends JFrame {
	
	static UserJSON userJson = new UserJSON();
	LeaderBoardView leaderBoardView = new LeaderBoardView();
	
	public MainGUI() {
		
		//Set JPanel
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//Create buttons for each game
		JButton checkersButton = addGameButton("Checkers", 70, new CheckersView());
		JButton memoryButton = addGameButton("Memory", 150, new MemoryView("1", "2"));
		JButton othelloButton = addGameButton("Othello", 230, new OthelloView());
		JButton tictactoeButton = addGameButton("TicTacToe", 310, new TicTacToeView());
		JButton leaderBoardButton = addLeaderButton("Leader Board View", 390);
			
		//Add buttons to panel
		panel.add(checkersButton);
		panel.add(memoryButton);
		panel.add(othelloButton);
		panel.add(tictactoeButton);
		panel.add(leaderBoardButton);

		//Initialize environment
		setTitle("Game Environment");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	private JButton addLeaderButton(String name, int y) {
		JButton leaderBoardButton = new JButton(name);
		leaderBoardButton.setBounds(100, y, 300, 70);
		leaderBoardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				leaderBoardView.populateStartGrid();
				//System.exit(0);
			}
       });
       return leaderBoardButton;
	}
	
	private JButton addGameButton(String game, int y, GameView gameview) {
		JButton gameButton = new JButton(game);
			gameButton.setBounds(100, y, 300, 70);
			gameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectGame(gameview);
				//System.exit(0);
			}
	       });
	       return gameButton;
	}
	
	public void selectGame(GameView gameView){
		gameView.startGame();
	}
 
	/**
	 * Creates a new instance of MainGUI and runs it.
	 * Was not sure if the main should actually be in a login
	 * page, UML doesn't specify it.
	 * @param args
	 */
	public static void main (String[] args) {
		buttonListener12 mainGui = new buttonListener12();
		method();
	}
	
	public static class buttonListener12 extends JButton implements ActionListener{
		static JLabel player1; 
		static JLabel player2;
		static JTextField userName1; 
		static JTextField userName2;
		  
		// JFrame 
		static JFrame playerFrame; 
		  
		// JButton 
		static JButton submitButton; 
		  
		buttonListener12(){}

		@Override
		public void actionPerformed(ActionEvent e) {
			 String s = e.getActionCommand(); 
		        if (s.equals("submit")) {
		        	userJson.checkFile(userName1.getText(), userName2.getText());
		        	MainGUI main = new MainGUI();
		    		main.setVisible(true);
		        }
			}
	}

	public static void method() {

		buttonListener12.playerFrame = new JFrame("Text");
		buttonListener12.player1 = new JLabel("Player 1 Username:");
		buttonListener12.player2 = new JLabel("Player 2 Username:");
		buttonListener12.submitButton = new JButton("submit");
		buttonListener12 here = new buttonListener12();
		buttonListener12.submitButton.addActionListener(here);
		buttonListener12.userName1 = new JTextField(16);
		buttonListener12.userName2 = new JTextField(16);
		
		JPanel loginPanel = new JPanel();
		
		loginPanel.add(buttonListener12.player1);
		loginPanel.add(buttonListener12.userName1);
		loginPanel.add(buttonListener12.player2);
		loginPanel.add(buttonListener12.userName2);
		loginPanel.add(buttonListener12.submitButton);

		buttonListener12.playerFrame.add(loginPanel);
		buttonListener12.playerFrame.setSize(400, 400);
		buttonListener12.playerFrame.show();
	}

}

