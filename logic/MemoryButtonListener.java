package logic;
import view.MemoryView;
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

public class MemoryButtonListener extends JButton implements ActionListener
{
	 private int value;			//The hidden value this Button contains 
	 private int row;			//Row index its located in
	 private int column;		//Col index its located in
	 public boolean revealed;	//Whether this space has been revealed or not
 
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
	    				
	    			}
	    			
	    			//Wrong choice, hide both spaces now
	    			else {
	    				//Need to implement waiting a bit before hiding the buttons again
	    				
	    				
	    				
	    				MemoryView.HideOrRevealSpace(MemoryLogic.previousButton.row, MemoryLogic.previousButton.column, false);
	    				MemoryView.HideOrRevealSpace(row, column, false);
	    			}
	    			MemoryLogic.previousButton = null;
	    		}
	    		
	    		//Check if the game is over
	    		
	    		
	    	}
	    		
	    	
	    }
	    
    public int GetValue() {
    	return value;
    }
    
}
