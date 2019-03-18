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
	public int numberButtons;
	public JButton buttons[][];
	public OthelloGameState othelloGameState;
	
	public OthelloView() {
		//Set JPanel
		panel = new JPanel();
		scoreboard = new JPanel();
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(100);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(scoreboard);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(panel);
		panel.setBorder (BorderFactory.createLineBorder (Color.black, 8));
		panel.setBackground (Color.GREEN);
		scoreboard.setBorder (BorderFactory.createLineBorder (Color.black, 8));
		scoreboard.setBackground (Color.GREEN);
		jframe.getContentPane().add(splitPane);
		
		//Initialize environment
		jframe.setTitle("Othello");
		jframe.setSize(500,500);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		
		//Initialize Button Array
		numberButtons=64;
		buttons = new JButton[8][8]; 
		
		othelloGameState = new OthelloGameState();
		
		//Scoreboard
		score = new JLabel();
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
	}

	@Override
	public void populateStartGrid() {
		// TODO Auto-generated method stub
				
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		for(int i = 0 ; i < 8 ; i++){
			for(int j = 0 ; j < 8 ; j++) {
				System.out.print(othelloGameState.board[i][j]);
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
		score.setText("Black (Player 1): " + Integer.toString(othelloGameState.player1Total) + 
				"    White (Player 2): " + Integer.toString(othelloGameState.player2Total) + "    Turn: " + othelloGameState.turnString);
		scoreboard.add(score);
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
			updateBoard();
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

