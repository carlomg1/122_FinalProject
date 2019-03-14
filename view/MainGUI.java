
package view;
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
		JButton memoryButton = addGameButton("Memory", 150, new MemoryView("1", "2"));
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
	private JButton addGameButton(String game, int y, GameView gameview) {
		JButton checkersButton = new JButton(game);
	       checkersButton.setBounds(100, y, 300, 70);
	       checkersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectGame(gameview);
				//System.exit(0);
			}
	       });
	       return checkersButton;
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
		buttonListener12 again=new buttonListener12();
		again.method();
		//method();
		//Start the MainGUI
//		MainGUI main = new MainGUI();
//		main.setVisible(true);
	}
	
	
	
	public static class buttonListener12 extends JButton implements ActionListener{
		  static JLabel l; 
		  static JLabel l1;
		  static JTextField t; 
		  static JTextField t1;
		  
		    // JFrame 
		    static JFrame f; 
		  
		    // JButton 
		    static JButton b; 
		  
		buttonListener12(){
			

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			 String s = e.getActionCommand(); 
		        if (s.equals("submit")) { 
		        	MainGUI main = new MainGUI();
		    		main.setVisible(true);
		    		
//		            // set the text of the label to the text of the field 
//		            l.setText( buttonListener12.t.getText()); 
//		  
//		            // set the text of field to blank 
//		            buttonListener12.t.setText("  "); 
//			// TODO Auto-generated method stub
//	
	}

	public static void method() {

		buttonListener12.f=new JFrame("Text");
		buttonListener12.l=new JLabel("Player 1 Username:");
		buttonListener12.l1=new JLabel("Player 2 Username:");
		//JLabel label1=new JLabel("Player 2 Username:");
		buttonListener12.b=new JButton("submit");
		buttonListener12 here =new buttonListener12();
		buttonListener12.b.addActionListener(here);
		buttonListener12.t=new JTextField(16);
		buttonListener12.t1=new JTextField(16);
		//JTextField text1=new JTextField(16);
		JPanel p=new JPanel();
		p.add(buttonListener12.l);
		p.add(buttonListener12.t);
		p.add(buttonListener12.l1);
		p.add(buttonListener12.t1);
		p.add(buttonListener12.b);
		//p.add(label1);
		//p.add(buttonListener12.l);
		//p.add();

		buttonListener12.f.add(p);
		buttonListener12.f.setSize(400, 400);

		buttonListener12.f.show();

       // return text.getText();
	}

	/**
	 *
	 * @param gameView
	 */


	/**
	 * Creates a button and attaches an event listener. The
	 * event listener should fire the game, but for now, only
	 * quits.
	 * @param game specifies the game text the button should have
	 * @param y specifies the y pos of the button
	 * @return a new JButton created
	 */

	}
}

