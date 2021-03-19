package GameOf15;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Building implements ActionListener{
	int[][]  board;
	int[] array;
	JLabel[][] label;
	JButton[][] button;
	JPanel panel1;
	JFrame fr;
	int cols;
	int rows ;
	
	public Building() {
		rows = 4;
		cols = 4;
		board = new int[rows][cols];
		GenerateRandom();
		initGUI();
		
	}
	
	public void initGUI() {
		fr = new JFrame();
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,4));
		button = new JButton[rows][cols];
		label = new JLabel[rows][cols];
		int count = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				button[i][j] = new JButton();
				label[i][j] = new JLabel();
				button[i][j].setText(i + "," + j);
				label[i][j].setText(String.valueOf(array[count]));
				count++;
				button[i][j].add(label[i][j]);
				button[i][j].setForeground(Color.white);
				button[i][j].setBackground(Color.white);
				label[i][j].setAlignmentX(JLabel.CENTER_ALIGNMENT);
				label[i][j].setAlignmentY(JLabel.CENTER_ALIGNMENT);
				label[i][j].setFont(new Font("Sherif", Font.PLAIN , 30));
				button[i][j].setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
				button[i][j].addActionListener(this);
				panel1.add(button[i][j]);
			}
		}
	
		fr.add(panel1);
		fr.setVisible(true);
		fr.setSize(500, 500);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void GenerateRandom() {
		Random rand = new Random();
		array = new int[16];
		for(int i = 0; i < 16; i ++) {
			array[i] = i + 1;
		}
		array[15] = 0;
		for(int i = 0; i < 16; i ++) {
			int index = rand.nextInt(16);
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		int count = 0;
		for(int i = 0; i < rows; i ++) {
			for(int j = 0; j < cols; j++){
				board[i][j] = array[count];
				count++;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Boolean flag = checkBoard();
		
		
		if(flag == false) {
			String s = e.getActionCommand().toString();
			int r = Integer.parseInt(s.split(",")[0]);
			int c = Integer.parseInt(s.split(",")[1]);
			
			if(board[r][c] != 0) {
				if(r + 1 < rows && board[r + 1][c] == 0) {
					int temp = board[r][c];
					board[r][c] = board[r + 1][c];
					board[r + 1][c] = temp;
					label[r][c].setText(String.valueOf(board[r][c]));
					label[r + 1][c].setText(String.valueOf(board[r + 1][c]));
				}
				else if(r - 1 >= 0 && board[r - 1][c] == 0) {
					int temp = board[r][c];
					board[r][c] = board[r - 1][c];
					board[r - 1][c] = temp;
					label[r][c].setText(String.valueOf(board[r][c]));
					label[r - 1][c].setText(String.valueOf(board[r - 1][c]));
					
				}
				else if(c + 1 < cols && board[r][c + 1] == 0) {
					int temp = board[r][c];
					board[r][c] = board[r][c + 1];
					board[r][c + 1] = temp;
					label[r][c].setText(String.valueOf(board[r][c]));
					label[r][c + 1].setText(String.valueOf(board[r][c + 1]));
					
				}
				else if(c - 1 >= 0 && board[r][c - 1] == 0){
					int temp = board[r][c];
					board[r][c] = board[r][c - 1];
					board[r][c - 1] = temp;
					label[r][c].setText(String.valueOf(board[r][c]));
					label[r][c - 1].setText(String.valueOf(board[r][c - 1]));
				}
			}
			flag = checkBoard();
			if(flag == true) {
				DisplayMsg();
			}
		}
		
		
	}
	void DisplayMsg() {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Completed", SwingConstants.CENTER);
		frame.add(label);
		frame.setLayout(new GridLayout(1,1));
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	boolean checkBoard() {
		int count = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(board[i][j] != count && board[i][j] != 0) {
					return false;
				}
				count++;
			}
			
		}
		return true;
		
	}
	

}
