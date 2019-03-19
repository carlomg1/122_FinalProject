package view;

import javax.swing.JPanel;

import logic.OthelloGameState;
import logic.OthelloLogic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OthelloView implements GameView {
	public String Player1;
	public String Player2;
	
	public Board boardGame;
	
	public JFrame jframe = new JFrame();
	public JPanel panel;
	public JPanel scoreboard;
	public JLabel score;
	public JButton buttons[][];
	
	public int numberButtons;
	
	public OthelloGameState othelloGameState;
	
	public OthelloView() {
		//Set JSplitPane
		JSplitPane splitPane = new JSplitPane();
		
		//Set JPanel
		panel = new JPanel();
		scoreboard = new JPanel();
		
		//Configure JSplitPlane and add the panels to it
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(100);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(scoreboard);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(panel);
        
        //Configure game panel and scoreboard panel
		panel.setBorder (BorderFactory.createLineBorder (Color.black, 8));
		panel.setBackground (Color.GREEN);
		scoreboard.setBorder (BorderFactory.createLineBorder (Color.black, 8));
		scoreboard.setBackground (Color.GREEN);
		
		//Add the split pane to the frame
		jframe.getContentPane().add(splitPane);
		
		//Initialize environment
		jframe.setTitle("Othello");
		jframe.setSize(1000,1000);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(jframe.DISPOSE_ON_CLOSE);
		
		//Initialize Button Array
		numberButtons=64;
		buttons = new JButton[8][8]; 
		
		othelloGameState = new OthelloGameState();
		
		//Scoreboard
		score = new JLabel();
		score.setFont(score.getFont ().deriveFont (30.0f));
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		layoutGrid();
		populateStartGrid();
		jframe.setVisible(true);
		
	}

	@Override
	public void layoutGrid() {
		panel.setLayout (new GridLayout (8, 8));
		scoreboard.setLayout(new FlowLayout());
		updateBoard();
		updateScoreboard();
	}

	@Override
	public void populateStartGrid() {
		// TODO Auto-generated method stub
				
		
	}

	@Override
	public void updateBoard() {
		//Populate the board accordingly
		for(int i = 0 ; i < 8 ; i++){
			for(int j = 0 ; j < 8 ; j++) {
				if(othelloGameState.board[i][j] == 1) {
					JButton button = new JButton(new CircleIconBlack());
					buttons[i][j] = button;
					button.setBackground(Color.green);
					button.setForeground(Color.black);
					button.setOpaque(true);
					button.setBorder(BorderFactory.createLineBorder(Color.black));
					panel.add(button);
					button.addActionListener(new ButtonListener(i, j));
				}
				else if (othelloGameState.board[i][j] == 2){
					JButton button = new JButton(new CircleIconWhite());
					buttons[i][j] = button;
					button.setBackground(Color.green);
					button.setForeground(Color.black);
					button.setOpaque(true);
					button.setBorder(BorderFactory.createLineBorder(Color.black));
					panel.add(button);
					button.addActionListener(new ButtonListener(i, j));
				}
				else {
					JButton button = new JButton();
					buttons[i][j] = button;
					button.setBackground(Color.green);
					button.setForeground(Color.black);
					button.setOpaque(true);
					button.setBorder(BorderFactory.createLineBorder(Color.black));
					panel.add(button);
					button.addActionListener(new ButtonListener(i, j));
				}
			}
		}
	}
	
	private void refreshBoard() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
	
	private void updateScoreboard() {
		score.setText(MainGUI.username1 + " (Black): " + Integer.toString(othelloGameState.player1Total) + 
		"    " + MainGUI.username2 + "(White): " + Integer.toString(othelloGameState.player2Total) +
		"    Turn: " + othelloGameState.turnString);
		scoreboard.add(score);
	}
	
	private void determineWinner() {
		if(othelloGameState.winner != 0) {
			int answer=JOptionPane.showConfirmDialog(null, othelloGameState.winnerString 
			+ " wins the game!  Do you want to play again?","",JOptionPane.YES_NO_OPTION);
			
            if(answer==JOptionPane.NO_OPTION){
				System.exit(0);
				}

            if(answer==JOptionPane.YES_OPTION) { // if the user want to play again clear all the button and start over
            	resetGame();
            }
		}
	}
	
	private void resetGame() {
		othelloGameState = new OthelloGameState();
		refreshBoard();
    	layoutGrid();
	}
	
	private class ButtonListener extends JButton implements ActionListener
    {
		private int x;
		private int y;
	 public ButtonListener(int x, int y) {
		 this.x = x;
		 this.y = y;
		 addActionListener(this);
	 	}

		@Override
		public void actionPerformed(ActionEvent e) {
			othelloGameState.update(x, y);
			buttons = new JButton[8][8];
			refreshBoard();
			updateBoard();
			updateScoreboard();
			determineWinner();
		}
        
    }
	
	class CircleIconBlack implements Icon {
		  @Override
		  public void paintIcon(Component c, Graphics g, int x, int y) {
			  
		    Graphics2D g2 = (Graphics2D) g.create();
		    //Draw the icon at the specified x, y location:
		    g2.drawOval(8, 8, c.getWidth()-16, c.getHeight()-16);
		    
		    g2.setColor(Color.black);
		    g2.setBackground(Color.gray);
		    
		    g2.fillOval(8, 8, c.getWidth()-16, c.getHeight()-16);
		    g2.dispose();
		  }


		  @Override
		  public int getIconWidth() {
		    return 30;
		  }
		  @Override
		  public int getIconHeight() {
		    return 30;
		  }
		}
	
	class CircleIconWhite implements Icon {
		  @Override
		  public void paintIcon(Component c, Graphics g, int x, int y) {
		    //g.drawOval(10, 10, 20, 20);
		    Graphics2D g2 = (Graphics2D) g.create();
		    //Draw the icon at the specified x, y location:
		    //g2.drawOval(1, 1, c.getWidth()-3, c.getHeight()-3);
		    g2.setColor(Color.white);
		    g2.fillOval(8, 8, c.getWidth()-16, c.getHeight()-16);
		    //or
		    //g2.translate(x, y);
		    //g2.drawOval(0, 0, getIconWidth() - 1, getIconHeight() - 1);
		    g2.dispose();
		  }

		  @Override
		  public int getIconWidth() {
		    return 30;
		  }
		  @Override
		  public int getIconHeight() {
		    return 30;
		  }
		}
}

