package logic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.TicTacToeView;

public abstract class TicTacToLogic implements GameLogic {

	static TicTacToGameState tictactoGameState= new TicTacToGameState();
	public static TicTacToeView tictacview=new TicTacToeView();

	static int numberButtons=9;
	public static String turn;
	static int counterSwitchPlayer=0;
	public static int scorePlayer1=0;
	public static int scorePlayer2=0;




	public static class buttonListener extends JButton implements ActionListener
	    {

		 public buttonListener() {

			 addActionListener(this);// allows button to be clickable and start performing the actions on it
		 	}

	        public void actionPerformed(ActionEvent action)
	        {

	            changeTurn(action);
	            findWinner(action);
	        }


	    	public String findWinner(ActionEvent action){
	    		System.out.println("INSIDE FIND WINNER");
	    		if(checkDiagonalWin()  == true || checkVerticalWin()==true || checkHorizontalWin()==true)
	            {
	    				if (turn =="Player 1") {
	    					scorePlayer1++;
	    				}
	    				else {
	    					scorePlayer2++;
	    				}
	    				
					int answer=JOptionPane.showConfirmDialog(null, turn + " wins the game!  Do you want to play again?","",JOptionPane.YES_NO_OPTION);
	                if(answer==JOptionPane.NO_OPTION){
	    				System.exit(0);
	    				}

	                if(answer==JOptionPane.YES_OPTION) { // if the user want to play again clear all the button and start over
	                	resetButtons();

				}
	                //resetButtons(); do i need to reset after here?
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
	        		turn="Player 1";
	        		counterSwitchPlayer++;
	        	}

	        	else if(counterSwitchPlayer %2==1 && getText().equals("")) {
	        		buttonClicked.setText("O");
	        		turn="Player 2";
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
        for(int i = 0; i <= numberButtons-1; i++)// i will be row times columns minus 1
        {
        	tictacview.buttons[i].setText("");
        }
        counterSwitchPlayer=0;

    }




	
	public static <T> ArrayList<?> findValidMove(int row, int col, TicTacToGameState gameState){
		TicTacToGameState tictacgame=(TicTacToGameState) gameState;
		//ArrayList<T> validMoves=new ArrayList<T>();
		
		if (tictacview.buttons[row].getText().equals(tictacview.buttons[col].getText()) 
				&& !tictacview.buttons[row].getText().equals("")) {
			int[] newMove=new int[2];
			tictacgame.validMoves.add((int[]) newMove);
		}
		System.out.println("VALID MOVES NEW "+ tictacgame.validMoves);
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
		buttonListener here=new buttonListener();

		return false;
	} // can take out later
//
//	@Override
//	public boolean isValidMove(int row, int col, GameState gameState) {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	@Override
//	public String getButtonClicked() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
