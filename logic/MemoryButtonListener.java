package logic;
import view.MemoryView;
import view.UserJSON;

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
import view.UserJSON;

public class MemoryButtonListener extends JButton implements ActionListener
{
	 private int value;			//The hidden value this Button contains 
	 private int row;			//Row index its located in
	 private int column;		//Col index its located in
	 public boolean revealed;	//Whether this space has been revealed or not
	 
	 private static String GAME = "memory";
 
	 public MemoryButtonListener(int x, int y, int numValue) {
		 addActionListener(this); // allows button to be clickable and start performing the actions on it
		 row = x;
		 column = y;
		 value = numValue;
		 revealed = false;
		 this.setFont(new Font("Helvetica", Font.BOLD, 55));
		 this.setText(Integer.toString(value));
		 this.setEnabled(false);
	 	}
	 
	 
	public void ChangeValue(int v) {
		value = v;
	}
	 
	public void actionPerformed(ActionEvent action) 
	    {
	    	MemoryLogic rules = new MemoryLogic();
	    	// Valid move, user clicked on a button that has not been revealed yet
	    	if(rules.checkValidMove(this)) {	    		
	    		
	    		//One button pressed, reveal it
	    		if(MemoryLogic.previousButton == null) {
	    			MemoryView.HideOrRevealSpace(row, column, true);
	    			MemoryLogic.previousButton = this;
	    			
	    			
	    		}
	    		//2nd button pressed, check if its a match
	    		else {
	    			MemoryView.HideOrRevealSpace(row, column, true);
	    			
	    			//Matched correctly, update score
	    			if(MemoryLogic.isMatch(this)) {
	    				//UPDATES SCORE
	    				if(MemoryLogic.isPlayer1Turn) {
	    					MemoryLogic.player1Score++;
	    				}
	    				else {
	    					MemoryLogic.player2Score++;
	    				}
	    				
	    				//User finished clicked a pair now, set previous button back to null
	    				MemoryLogic.previousButton = null;
	    			}
	    			
	    			//Wrong choice, hide both spaces now
	    			else {	    				
	    				//Prevent User from clicking anymore
	    				MemoryView.EnableOrDisableButtons(false);
	    				
	    				//Wait a second before hiding the pair again and letting the user click again
	    				Timer timer = new Timer(1000, new ActionListener() {
	    					public void actionPerformed(ActionEvent event) {
	    	    				MemoryView.HideOrRevealSpace(MemoryLogic.previousButton.row, MemoryLogic.previousButton.column, false);
	    	    				MemoryView.HideOrRevealSpace(row, column, false);
	    	    				MemoryView.EnableOrDisableButtons(true);
	    	    				MemoryLogic.previousButton = null;
	    	    				
	    	    				MemoryLogic.changeTurn();
	    	    				MemoryView.ChangeButtonBorders(MemoryLogic.isPlayer1Turn);
	    					}
	    				});
	    				timer.setRepeats(false);
	    				timer.start();
	    			}
	    		}
	    		
	    		
	    		//Check if the game is over here
	    		if(MemoryLogic.checkFinish(MemoryView.buttons)) {
	    			MemoryView.UpdateScore();
	    			System.out.println("GAME OVER!");
	    			System.out.println("Player 1 got " + MemoryLogic.player1Score + " pairs!");
	    			System.out.println("Player 2 got " + MemoryLogic.player2Score + " pairs!");
	    			
	    			boolean isTie = false;
	    			if(MemoryLogic.player1Score == MemoryLogic.player2Score) {
	    				isTie = true;
	    			}
	    			
	    			int answer;
	    			if(isTie) {
	    				answer=JOptionPane.showConfirmDialog(null, "This game is a tie!\nDo you want to play again?","",JOptionPane.YES_NO_OPTION);

	    			}
	    			else {
	    				String winner = MemoryLogic.player1Score > MemoryLogic.player2Score ? "Player 1" : "Player 2";
	    				answer=JOptionPane.showConfirmDialog(null, winner + " wins the game!  Do you want to play again?","",JOptionPane.YES_NO_OPTION);
	    				if(winner == "Player 1") {
	    					UserJSON.incrementScore(MemoryView.player1, GAME);
	    				}else {
	    					UserJSON.incrementScore(MemoryView.player2, GAME);
	    				}
	    			}
	    			
	                //Exit here, user doesn't want to play again
	    			if(answer==JOptionPane.NO_OPTION){
	    				System.exit(0);
    				}

	                if(answer==JOptionPane.YES_OPTION) { // if the user want to play again clear all the button and start over
	                	//Start over
	                	MemoryLogic.previousButton = null;
	                	MemoryView.Reset();
}
	    		}
	    		
	    		
	    	}
	    	MemoryView.UpdateScore();
	    		
	    	
	    }
	    
    public int GetValue() {
    	return value;
    }
    
}
