package view;


import java.util.ArrayList;

import java.awt.*;  
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import logic.CheckersGameState;


public class CheckersView implements GameView {
	public String Player1;
	public String Player2;
	public Board boardGame;
	public JFrame frame;
	public JPanel panel;
<<<<<<< HEAD
=======
	public JPanel scoreboard;
	public JLabel score;
>>>>>>> master
	public JButton[][] buttons;
	public CheckersGameState GameState;
	
	public CheckersView() {
		GameState = new CheckersGameState();
		this.buttons = new JButton[8][];
		for (int i = 0; i<8; ++i){
			this.buttons[i]=new JButton[8];
			for(int j = 0; j<8; ++j){
				buttons[i][j] = null;
			}
		}
		//this.startGame();
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		this.populateStartGrid();
		/*ArrayList<int[]> testmove= new ArrayList<int[]>();
		int[] move1 = new int[]{3,2};
		testmove.add(move1);
		
		this.drawValidMove(testmove);*/ 
		//test for draw valid move
		
	}

	@Override
	public void layoutGrid() {
		// TODO Auto-generated method stub
		this.frame = new JFrame ("Checkers");
<<<<<<< HEAD
		this.frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

=======
		this.frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		
>>>>>>> master
		this.panel = new JPanel(); //creating a panel with a box like a checker board
		this.panel.setLayout(new GridLayout(8, 8));
		this.panel.setBorder (BorderFactory.createLineBorder (Color.red, 8));
		this.panel.setBackground (Color.white);
		
<<<<<<< HEAD
		this.frame.getContentPane().add(panel);
		this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setSize(500, 500);
=======
		this.scoreboard = new JPanel();
		this.scoreboard.setLayout(new FlowLayout());
		this.scoreboard.setBorder(BorderFactory.createLineBorder (Color.black, 4));
		this.scoreboard.setBackground (Color.white);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(100);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(this.scoreboard);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(this.panel);
		
		this.score =new JLabel();
		
		this.frame.getContentPane().add(splitPane);
		//this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setSize(500, 625);
>>>>>>> master
		
	}

	@Override
	public void populateStartGrid() {
		// TODO Auto-generated method stub
		
		this.layoutGrid();
		this.updateBoard();
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
<<<<<<< HEAD
=======
		this.scoreboard.removeAll();
		this.scoreboard.revalidate();
		this.scoreboard.repaint();
		
		String currentPlayer = (this.GameState.getPlayerTurn()==-1)?"Player One":"Player Two";
		this.score.setText("Black (Player One): " + Integer.toString(this.GameState.playerOneCount) + 
			"    Red (Player Two): " + Integer.toString(this.GameState.playerTwoCount) + 
			"    Turn: " + currentPlayer);
		this.scoreboard.add(score);

		this.panel.removeAll();
		this.panel.revalidate();
		this.panel.repaint();
		
>>>>>>> master
		boolean black;
		for(int i=0; i<8; i++){ //placing the player 1 checkers
			if ( i % 2 == 0){
				black = false;
			}else{
				black = true;
			}
			for (int j =0; j<8; ++j){ 
				if (GameState.checkerBoard[i][j] != null && GameState.returnPlayer(GameState.checkerBoard[i][j])==-1){
<<<<<<< HEAD
					final JButton button = new JButton(new CircleIconBlack());
=======
					final JButton button;
					if (GameState.isKing(GameState.checkerBoard[i][j])){
						button = new JButton(new CheckerIcon(Color.blue));
					}else {
						button = new JButton(new CheckerIcon(Color.black));
					}
>>>>>>> master
					button.setBackground(Color.gray);
					button.setForeground(Color.gray);
					button.setOpaque(true);
					button.setBorder(BorderFactory.createLineBorder(Color.gray));
<<<<<<< HEAD
					button.addActionListener(new ButtonAction(this.buttons));
=======
					button.addActionListener(new ButtonAction(this));
>>>>>>> master
					buttons[i][j] = button;
					this.panel.add(button);
					black = false;
				}else if (GameState.checkerBoard[i][j] != null && GameState.returnPlayer(GameState.checkerBoard[i][j])==1){
<<<<<<< HEAD
					final JButton button = new JButton(new CircleIconRed());
=======
					final JButton button;
					if (GameState.isKing(GameState.checkerBoard[i][j])){
						button = new JButton(new CheckerIcon(Color.orange));
					}else {
						button = new JButton(new CheckerIcon(Color.red));
					}
>>>>>>> master
					button.setBackground(Color.gray);
					button.setForeground(Color.gray);
					button.setOpaque(true);
					button.setBorder(BorderFactory.createLineBorder(Color.gray));
<<<<<<< HEAD
					button.addActionListener(new ButtonAction(this.buttons));
=======
					button.addActionListener(new ButtonAction(this));
>>>>>>> master
					buttons[i][j] = button;
					this.panel.add(button);
					black = false;
				}
				else
				{
					if (black){
						final JButton button = new JButton();
						button.setBackground(Color.gray);
						button.setForeground(Color.gray);
						button.setOpaque(true);
						button.setBorder(BorderFactory.createLineBorder(Color.gray));
<<<<<<< HEAD
						button.addActionListener(new ButtonAction(this.buttons));
=======
						button.addActionListener(new ButtonAction(this));
>>>>>>> master
						buttons[i][j] = button;
						this.panel.add(button);
						black = false;
					}else{
						final JLabel label = new JLabel();
						label.setBackground(Color.white);
						label.setForeground(Color.white);
						label.setOpaque(true);
						label.setBorder(BorderFactory.createLineBorder(Color.gray));
						this.panel.add(label);
						black = true;
					}
				}
			}
		}
<<<<<<< HEAD
	}
	
	public void drawValidMove(ArrayList<int[]> validMoves){
		
		for (int[] move : validMoves){
			if (move.length == 2){
				final JButton button = new JButton( new ValidMoveIcon());
				button.setBackground(Color.darkGray);
				button.setForeground(Color.darkGray);
				button.setOpaque(true);
				button.setBorder(BorderFactory.createLineBorder(Color.darkGray));
				button.addActionListener(new ButtonAction(this.buttons));
				buttons[move[0]][move[1]] = button;
			}
		}
		this.panel.removeAll();
		this.panel.revalidate();
		this.panel.repaint();
		
		for(int i=0; i<8; i++){ 
			for (int j =0; j<8; ++j){
				if (buttons[i][j]!=null){
					this.panel.add(buttons[i][j]);
				}else{
					final JLabel label = new JLabel();
					label.setBackground(Color.white);
					label.setForeground(Color.white);
					label.setOpaque(true);
					label.setBorder(BorderFactory.createLineBorder(Color.gray));
					this.panel.add(label);
				}
			}
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
		    
=======
	}
	
	public void drawValidMove(ArrayList<int[]> validMoves){
		
		for (int[] move : validMoves){
			if (move.length == 2){
				final JButton button = new JButton( new CheckerIcon(Color.white));
				button.setBackground(Color.darkGray);
				button.setForeground(Color.darkGray);
				button.setOpaque(true);
				button.setBorder(BorderFactory.createLineBorder(Color.darkGray));
				button.addActionListener(new ButtonAction(this));
				buttons[move[0]][move[1]] = button;
			}
		}
		this.panel.removeAll();
		this.panel.revalidate();
		this.panel.repaint();
		
		for(int i=0; i<8; i++){ 
			for (int j =0; j<8; ++j){
				if (buttons[i][j]!=null){
					this.panel.add(buttons[i][j]);
				}else{
					final JLabel label = new JLabel();
					label.setBackground(Color.white);
					label.setForeground(Color.white);
					label.setOpaque(true);
					label.setBorder(BorderFactory.createLineBorder(Color.gray));
					this.panel.add(label);
				}
			}
		}
	}
	
	class CheckerIcon implements Icon {
		
		Color iconColor;
		CheckerIcon(Color cc){
			this.iconColor = cc;
		}
		  @Override
		  public void paintIcon(Component c, Graphics g, int x, int y) {
		    //g.drawOval(10, 10, 20, 20);
		    Graphics2D g2 = (Graphics2D) g.create();
		    //Draw the icon at the specified x, y location:
		    g2.drawOval(1, 1, c.getWidth()-3, c.getHeight()-3);
		    g2.setColor(this.iconColor);
>>>>>>> master
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
	
<<<<<<< HEAD
	class CircleIconRed implements Icon {
		  @Override
		  public void paintIcon(Component c, Graphics g, int x, int y) {
		    //g.drawOval(10, 10, 20, 20);
		    Graphics2D g2 = (Graphics2D) g.create();
		    //Draw the icon at the specified x, y location:
		    //g2.drawOval(1, 1, c.getWidth()-3, c.getHeight()-3);
		    g2.setColor(Color.red);
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
	
	class ValidMoveIcon implements Icon {
		  @Override
		  public void paintIcon(Component c, Graphics g, int x, int y) {
		    //g.drawOval(10, 10, 20, 20);
		    Graphics2D g2 = (Graphics2D) g.create();
		    //Draw the icon at the specified x, y location:
		    g2.drawOval(1, 1, c.getWidth()-3, c.getHeight()-3);
		    g2.setColor(Color.white);
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
	
	class ButtonAction implements ActionListener{
		
		JButton[][] buttons;
		
		public ButtonAction(JButton[][] buttons){
			this.buttons = buttons;
		}
		@Override
		public void actionPerformed(ActionEvent e)
        {
			JButton button = (JButton) e.getSource();
			for(int i = 0;i< 8; i++){
	            for(int j = 0;j < 8;j++){
	                if(button == this.buttons[i][j]){
	                    //JButton clicked == this.buttons[i][j];
	                	System.out.println(i+","+j);
	                    // do something with this 
	                }
	            }
	        }
        }
=======
	class ButtonAction implements ActionListener{
		
		CheckersView checkerView;
		
		int[] position;
		
		public ButtonAction(CheckersView checkerView){
			this.checkerView = checkerView;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
        {
			this.position = this.checkerPosition(e);
			
			if (this.position!=null && this.checkerView.GameState.checkerBoard[this.position[0]][this.position[1]]!=null){
				this.checkerView.updateBoard();
				this.checkerView.GameState.gameLoop(this.position[0], this.position[1]);
				if (this.checkerView.GameState.validMoves!=null && this.checkerView.GameState.currentChecker!=null){
					this.checkerView.drawValidMove(this.checkerView.GameState.validMoves);
				}
			} else if (this.position!=null && this.checkerView.GameState.checkerBoard[this.position[0]][this.position[1]]==null){
				int winnerState = this.checkerView.GameState.gameLoop(this.position[0], this.position[1]);
				this.checkerView.updateBoard();
				this.determineWinner(winnerState);
				
				
			}
			
        }
		
		private void determineWinner( int winnerState) {
			if(winnerState != 0) {
				String winPlayer = (winnerState==-1)?"Player Two":"Player One";
				int answer=JOptionPane.showConfirmDialog(null, winPlayer 
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
			this.checkerView.GameState = new CheckersGameState();
			this.checkerView.startGame();
		}
		
		public int[] checkerPosition(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int[] result = new int[2];
			
			for(int i = 0;i< 8; i++){
	            for(int j = 0;j < 8;j++){
	                if(button == this.checkerView.buttons[i][j]){
	                    //JButton clicked == this.buttons[i][j];
	         
	                	result[0] = i;
	                	result[1] = j; 
	                	
	                	
		                return result;
	                }
	            }
	        }
		return null;
		}
>>>>>>> master
	}
}
