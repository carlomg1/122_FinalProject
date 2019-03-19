package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Font;

public class LeaderBoardView {
	
	public JFrame jframe;
	UserJSON jsonInfo;
	ArrayList<ArrayList<String>> dataArray;

	public void populateStartGrid() {
		// TODO Auto-generated method stub
		// call the load grid methods and populate start grid
		
		// take this out eventually for real data
		dataArray = UserJSON.jsonToArray();
		String[][] dataList = arrayToList();
		this.layoutStatsGrid(dataList);
	}

	public void layoutStatsGrid(String[][] data){
		this.jframe = new JFrame("Leaderboard");
		this.jframe.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		this.jframe.setLocationRelativeTo(null);
		String[] category = {"Player", "Memory Wins", "Othello Wins", "Checkers Wins", "TicTacToe Wins"};
		
		JTable jt = new JTable(data, category);
		
		JScrollPane scp = new JScrollPane(jt);
		jt.setFont(new Font("Calibri", Font.PLAIN, 22));
		jt.setGridColor(Color.black);
		jt.setShowGrid(true);
		jt.setRowHeight(22);
		jframe.add(scp);
		jframe.setSize(500,300);
		jframe.setVisible(true);
	}
	
	public String[][] arrayToList(){
		String outer[][] = new String[dataArray.size()][5];
		int countouter = 0;
		for(ArrayList<String> in: dataArray) {
			int countinner = 0;
			String inner[] = new String[in.size()];
			for(String thing: in) {
				inner[countinner] = thing;
				countinner++;
			}
			outer[countouter] = inner;
			countouter++;
		}
		return outer;
	}
	
	public void displayStats(String[][] data){
		String[] category = {"Player", "Memory Wins", "Othello Wins", "Checkers Wins", "TicTacToe Wins"};
		
		System.out.println("DATA BITCH: " + data);
		
		JTable jt = new JTable(data, category);
		
		JScrollPane scp = new JScrollPane(jt);
		jt.setFont(new Font("Calibri", Font.PLAIN, 22));
		jt.setGridColor(Color.black);
		jt.setShowGrid(true);
		jt.setRowHeight(22);
		jframe.add(scp);
		jframe.setSize(500,300);
		jframe.setVisible(true);
	}
	
}
