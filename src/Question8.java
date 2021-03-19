import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//------------creating a board class---------//
class Board{
	String[][] boardArray = new String[3][3];
	Board() {
		int c = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				boardArray[i][j] = String.valueOf(c);
				c++;
			}
		}
	}
}

//----------creating a class that extends from board to carry out actions on the board---------//
class ActionsOnBoard extends Board{
	
	//----------Method to display the board-----------//
	void DisplayBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(boardArray[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	//---------Method to update the board-----------//
	void UpdateBoard(String position, String c) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(boardArray[i][j].equals(position)){
					boardArray[i][j] = c;
				}
			}
		}
	}
	
	//-----------Method to Check the board for win or draw----------//
	int CheckBoard() {
		int flag = 0;
		if(
				((boardArray[0][0].equals("x") && boardArray[0][1].equals("x") && boardArray[0][2].equals("x"))||
				(boardArray[1][0].equals("x") && boardArray[1][1].equals("x") && boardArray[1][2].equals("x"))||
				(boardArray[2][0].equals("x") && boardArray[2][1].equals("x") && boardArray[2][2].equals("x"))||
				(boardArray[0][0].equals("x") && boardArray[1][0].equals("x") && boardArray[2][0].equals("x"))||
				(boardArray[0][1].equals("x") && boardArray[1][1].equals("x") && boardArray[2][1].equals("x"))||
				(boardArray[0][2].equals("x") && boardArray[1][2].equals("x") && boardArray[2][2].equals("x"))||
				(boardArray[0][0].equals("x") && boardArray[1][1].equals("x") && boardArray[2][2].equals("x"))||
				(boardArray[0][2].equals("x") && boardArray[1][1].equals("x") && boardArray[2][0].equals("x"))) || 
				((boardArray[0][0].equals("o") && boardArray[0][1].equals("o") && boardArray[0][2].equals("o"))||
						(boardArray[1][0].equals("o") && boardArray[1][1].equals("o") && boardArray[1][2].equals("o"))||
						(boardArray[2][0].equals("o") && boardArray[2][1].equals("o") && boardArray[2][2].equals("o"))||
						(boardArray[0][0].equals("o") && boardArray[1][0].equals("o") && boardArray[2][0].equals("o"))||
						(boardArray[0][1].equals("o") && boardArray[1][1].equals("o") && boardArray[2][1].equals("o"))||
						(boardArray[0][2].equals("o") && boardArray[1][2].equals("o") && boardArray[2][2].equals("o"))||
						(boardArray[0][0].equals("o") && boardArray[1][1].equals("o") && boardArray[2][2].equals("o"))||
						(boardArray[0][2].equals("o") && boardArray[1][1].equals("o") && boardArray[2][0].equals("o")))
				) {
			flag = 1;
		}
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				try {
					int number = Integer.parseInt(boardArray[i][j]);
				}
				catch(NumberFormatException e){
					count++;
				}		
			}
			if(count == 9)
				flag = -1;
		}
		return flag;
	}
}


class Question8{
	
	//--------------Main Method---------------//
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("TIC - TAC - TOE GAME");
		//Displaying the initial board
		ActionsOnBoard board = new ActionsOnBoard();
		board.DisplayBoard();
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		//Entering the Players
		System.out.println("Choose characters from x and o");
		System.out.println("Choose Player 1 character");
		String player1 = br.readLine();
		
		System.out.println("Choose Player 2 character");
		String player2 = br.readLine();
		
		System.out.println("Player 1 is " + player1 + "\nPlayer 2 is " + player2);
		
		//Updating the positions
		int k = 1;

		System.out.println("Player " + k + "'s turn");
		String position = br.readLine();
		board.UpdateBoard(position, player1);
		board.DisplayBoard();
		k = 2;
		
		//Checking the board
		while(true) {
			if(board.CheckBoard() == 0) {
				System.out.println("Player " + k + "'s turn");
				position = br.readLine();
				if(k == 2) {
					board.UpdateBoard(position, player2);
					board.DisplayBoard();
					k = 1;
					continue;
				}
				else {
					board.UpdateBoard(position, player1);
					board.DisplayBoard();
					k+=1;
					continue;
				}
			}
			else if (board.CheckBoard() == -1) {
				System.out.println("Game Drawn");
				break;
			}
			else
				if(k == 1)
					System.out.println("Game Over, Player 2 wins");
				else if(k == 2)
					System.out.println("Game Over, Player 1 wins");
				break;
		}
		
		
	}
}
