package logic;

import javax.swing.*;
import java.util.*;

interface GameLogic {
	
	public <T>ArrayList<?> findValidMove(int row, int col, GameState gameState);

	public boolean isValidMove(int row, int col, GameState gameState);
	
	public boolean checkValidMove(JButton button);
	
	public boolean checkValidMove(ArrayList<?> validMoves, GameState gstate);


}