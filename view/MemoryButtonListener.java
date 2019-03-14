package view;
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
	    		System.out.println("HERE!");
	    		revealed = true;
	    	}

	    	
	    }
	    
    
}
