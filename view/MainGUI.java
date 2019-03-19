package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainGUI extends JFrame {
	
	public static String username1;
	public static String username2;
	
	static UserJSON userJson = new UserJSON();
	LeaderBoardView leaderBoardView = new LeaderBoardView();
	
	public MainGUI() {
		
		//Set JPanel
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//Create buttons for each game
		JButton checkersButton = addGameButton("Checkers", 70, new CheckersView());
		JButton memoryButton = addGameButton("Memory", 150, new MemoryView(username1, username2));
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
		setSize(500,600);
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
//<<<<<<< HEAD
		loginButtonListener mainGui = new loginButtonListener();
		method();
//=======
//		buttonListener12 again=new buttonListener12();
//		again.method();
//		//method();
//		//Start the MainGUI
//		MainGUI main = new MainGUI();
//		main.setVisible(true);
//>>>>>>> master
	}
	
	public static class loginButtonListener extends JButton implements ActionListener{
		static JLabel player1; 
		static JLabel player2;
		static JTextField userName1; 
		static JTextField userName2;
		  
		// JFrame 
		static JFrame playerFrame; 
		  
		// JButton 
		static JButton submitButton; 
		  
		loginButtonListener(){}

		@Override
		public void actionPerformed(ActionEvent e) {

			String s = e.getActionCommand(); 
	        if (s.equals("submit")) {
	        	userJson.checkFile(userName1.getText(), userName2.getText());
	        	userJson.jsonToArray();
	        	username1 = loginButtonListener.userName1.getText();
	    		username2 = loginButtonListener.userName2.getText();
	        	MainGUI main = new MainGUI();
	    		main.setVisible(true);
	        }
		}
	}

	public static void method() {

		loginButtonListener.playerFrame = new JFrame("Text");
		loginButtonListener.player1 = new JLabel("Player 1 Username:");
		loginButtonListener.player2 = new JLabel("Player 2 Username:");
		loginButtonListener.submitButton = new JButton("submit");
		loginButtonListener here = new loginButtonListener();
		loginButtonListener.submitButton.addActionListener(here);
		loginButtonListener.userName1 = new JTextField(16);
		loginButtonListener.userName2 = new JTextField(16);
		
		JPanel loginPanel = new JPanel();
		
		loginPanel.add(loginButtonListener.player1);
		loginPanel.add(loginButtonListener.userName1);
		loginPanel.add(loginButtonListener.player2);
		loginPanel.add(loginButtonListener.userName2);
		loginPanel.add(loginButtonListener.submitButton);

		loginButtonListener.playerFrame.add(loginPanel);
		loginButtonListener.playerFrame.setSize(400, 400);
		loginButtonListener.playerFrame.show();
	}

}

