package logic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.TicTacToeView;

public class TicTacToLogic implements GameLogic {

	TicTacToGameState tictactoGameState= new TicTacToGameState();
	public static TicTacToeView tictacview=new TicTacToeView();

	static int numberButtons=9;
	public static String turn;
	static int counterSwitchPlayer=0;

	private static int[][] winCombinations = new int[][] {
		{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
		{0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
		{0, 4, 8}, {2, 4, 6}			 //diagonal wins
};




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
	        	if (findWinner(0,4) && findWinner(4,8) || findWinner(2,4) && findWinner(4,6))
	                return true;
	            else {
	                return false;
	        }
	        }

	        public boolean checkVerticalWin(){
	        	if (findWinner(0,3) && findWinner(3,6)
	        			|| findWinner(1,4) && findWinner(4,7)
	        			|| findWinner(2,5) && findWinner(5,8)) {
	        		 return true;
	        	}

	        	else
	        		return false;

	        }


	        public boolean checkHorizontalWin() {
	        	if (findWinner(0,1) && findWinner(1,2)
	        			|| findWinner(3,4) && findWinner(4,5)
	        			|| findWinner(6,7) && findWinner(7,8)) {
	        		 return true;
	        	}
	        	else {
	        return false;
	        }
	        }


	        public boolean findWinner(int row,int column)
	        {
	            if (tictacview.buttons[row].getText().equals(tictacview.buttons[column].getText()) && !tictacview.buttons[row].getText().equals("")) {
	                return true;
	            }
	            else
	                return false;
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




	@Override
	public boolean checkValidMove(JButton button) {
		buttonListener here=new buttonListener();

		return false;
	}


	@Override
	public String getButtonClicked() {
		// TODO Auto-generated method stub
		return null;
	}

}
