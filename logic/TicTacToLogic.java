package logic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.MainGUI;
import view.TicTacToeView;
import view.UserJSON;

public abstract class TicTacToLogic implements GameLogic {

	static TicTacToGameState tictactoGameState= new TicTacToGameState();
	public static TicTacToeView tictacview=new TicTacToeView();
	public static HashMap<Integer, String> userMap = new HashMap<Integer, String>();
	
//	private static String GAME = "ttt";
	
	
	TicTacToLogic(){

	}	

	static int numberButtons=9;
	public static int turn;
	public static int turnPlayer1;
	public static int turnPlayer2=1;
	public static String turnString;
	static int counterSwitchPlayer=0;
	public static int scorePlayer1=0;
	public static int scorePlayer2=0;


public static class TicTacToButton extends JButton implements ActionListener
	    {

		 public TicTacToButton() {

			 addActionListener(this);
		 	}

	        public void actionPerformed(ActionEvent action)
	        {
	        		usersMap();

	            changeTurn(action);
	            findWinner(action);
	        }


	    	public int findWinner(ActionEvent action){
	    		if(checkDiagonalWin()  == true || checkVerticalWin()==true || checkHorizontalWin()==true)
	            {
	    				if (turn ==0) {
	    					scorePlayer1++;
	    					UserJSON.incrementScore(userMap.get(0), "ttt");
	    					player1Score();
	    				}
	    				else {
	    					scorePlayer2++;
	    					UserJSON.incrementScore(userMap.get(1), "ttt");
	    					player2Score();
	    				}
	    				
	    				if (turn==0) {
	    					turnPlayer1=turn;
	    					turnString=MainGUI.username1;

	    					

	    					
	    				}
	    				else {
	    					turnPlayer2=turn;
	    					turnString=MainGUI.username2;




	    				}
	    				
					int answer=JOptionPane.showConfirmDialog(null, turnString + " wins the game!  Do you want to play again?","",JOptionPane.YES_NO_OPTION);
	                if(answer==JOptionPane.NO_OPTION){
	                	
	               // 	tictacview.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    				System.exit(0);
	    				}

	                if(answer==JOptionPane.YES_OPTION) { 
	                	resetButtons();

				}
	            }
	    		else if (counterSwitchPlayer==9 && (checkDiagonalWin()  == false || checkVerticalWin()==false || checkHorizontalWin()==false )) {
					int answer1=JOptionPane.showConfirmDialog(null, "It is a tie!  Do you want to play again?","",JOptionPane.YES_NO_OPTION);
			        if(answer1==JOptionPane.NO_OPTION){
	    				System.exit(0);
	    				}

	                if(answer1==JOptionPane.YES_OPTION) { // if the user want to play again clear all the button and start over
	                	resetButtons();

				}

	    		}
	            return turn;
	    	}



	        public void changeTurn(ActionEvent buttonPress) {
	        	JButton buttonClicked=(JButton)buttonPress.getSource();
	        	if (counterSwitchPlayer %2==0  && getText().equals("")) {
	        		buttonClicked.setText("X");
	        		turn=0;
	        		counterSwitchPlayer++;
	        	}

	        	else if(counterSwitchPlayer %2==1 && getText().equals("")) {
	        		buttonClicked.setText("O");
	        		turn=1;
	        		counterSwitchPlayer++;
	        		}
	        }


	        public boolean checkDiagonalWin() {
	        	if (TicTacToLogic.isValidMove(0,4,tictactoGameState) && TicTacToLogic.isValidMove(4,8,tictactoGameState) || TicTacToLogic.isValidMove(2,4,tictactoGameState) && TicTacToLogic.isValidMove(4,6,tictactoGameState))
	                return true;
	            else {
	                return false;
	        }
	        }

	        public boolean checkVerticalWin(){
	        	if (TicTacToLogic.isValidMove(0,3,tictactoGameState) && TicTacToLogic.isValidMove(3,6,tictactoGameState)
	        			|| TicTacToLogic.isValidMove(1,4,tictactoGameState) && TicTacToLogic.isValidMove(4,7,tictactoGameState)
	        			|| TicTacToLogic.isValidMove(2,5,tictactoGameState) && TicTacToLogic.isValidMove(5,8,tictactoGameState)) {
	        		 return true;
	        	}

	        	else
	        		return false;

	        }


	        public boolean checkHorizontalWin() {
	        	if (TicTacToLogic.isValidMove(0,1,tictactoGameState) && TicTacToLogic.isValidMove(1,2,tictactoGameState)
	        			|| TicTacToLogic.isValidMove(3,4,tictactoGameState) && TicTacToLogic.isValidMove(4,5,tictactoGameState)
	        			|| TicTacToLogic.isValidMove(6,7,tictactoGameState) && TicTacToLogic.isValidMove(7,8,tictactoGameState)) {
	        		 return true;
	        	}
	        	else {
	        return false;
	        }
	        }

	        
	    }


    public static void resetButtons()
    {
        for(int i = 0; i <= numberButtons-1; i++)
        {
        	tictacview.buttons[i].setText("");
        }
        counterSwitchPlayer=0;

    }

    public static HashMap usersMap() {
    	System.out.println(MainGUI.username1);
		userMap.put(turnPlayer1, MainGUI.username1);
		userMap.put(turnPlayer2, MainGUI.username2);
		return userMap;
    	
    }

    
    public static int player1Score() {
    	return scorePlayer1;
    	
    }
    
    public static int player2Score() {
    	return scorePlayer2;
    }
	
	public static <T> ArrayList<?> findValidMove(int row, int col, TicTacToGameState gameState){
		TicTacToGameState tictacgame=(TicTacToGameState) gameState;
		if (tictacview.buttons[row].getText().equals(tictacview.buttons[col].getText()) 
				&& !tictacview.buttons[row].getText().equals("")) {
			int[] newMove=new int[2];
			tictacgame.validMoves.add((int[]) newMove);
		}
		return tictacgame.validMoves;
		

	} 
	
	public static boolean isValidMove(int row, int col, TicTacToGameState gameState){
		if (tictacview.buttons[row].getText().equals(tictacview.buttons[col].getText()) && !tictacview.buttons[row].getText().equals("")) {
            findValidMove(row,col,gameState);
			return true;
        }
        else
            return false;
	}
	
	
	public boolean checkValidMove(ArrayList<?> validMoves,TicTacToGameState gameState){
		
		return false;
	} // new added


	@Override
	public boolean checkValidMove(JButton button) {
		TicTacToButton here=new TicTacToButton();

		return false;
	} // can take out later

}