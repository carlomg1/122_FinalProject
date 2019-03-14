package view;


import java.util.ArrayList;

import java.awt.*;  
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import logic.CheckersGameState;


public class CheckersView implements GameView {
	public String Player1;
	public String Player2;
	public Board boardGame;
	public JFrame frame;
	public JPanel panel;
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
		this.layoutGrid();
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
		this.frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		this.panel = new JPanel(); //creating a panel with a box like a checker board
		this.panel.setLayout(new GridLayout(8, 8));
		this.panel.setBorder (BorderFactory.createLineBorder (Color.red, 8));
		this.panel.setBackground (Color.white);
		
		this.updateBoard();
		this.frame.getContentPane().add(panel);
		this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setSize(500, 500);
		
	}

	@Override
	public void populateStartGrid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
		boolean black;
		for(int i=0; i<8; i++){ //placing the player 1 checkers
			if ( i % 2 == 0){
				black = false;
			}else{
				black = true;
			}
			for (int j =0; j<8; ++j){ 
				if (GameState.playerOneCurrentState[i][j]==1){
					final JButton button = new JButton(new CircleIconBlack());
					button.setBackground(Color.gray);
					button.setForeground(Color.gray);
					button.setOpaque(true);
					button.setBorder(BorderFactory.createLineBorder(Color.gray));
					buttons[i][j] = button;
					this.panel.add(button);
					black = false;
				}
				else if (GameState.playerTwoCurrentState[i][j]==1){
					final JButton button = new JButton(new CircleIconRed());
					button.setBackground(Color.gray);
					button.setForeground(Color.gray);
					button.setOpaque(true);
					button.setBorder(BorderFactory.createLineBorder(Color.gray));
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
	}
	
	public void drawValidMove(ArrayList<int[]> validMoves){
		
		for (int[] move : validMoves){
			if (move.length == 2){
				final JButton button = new JButton( new ValidMoveIcon());
				button.setBackground(Color.darkGray);
				button.setForeground(Color.darkGray);
				button.setOpaque(true);
				button.setBorder(BorderFactory.createLineBorder(Color.darkGray));
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
}
