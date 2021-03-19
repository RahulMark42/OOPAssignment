class ChessBoard {  
	void PrintSolution(String board[][]) 
	{ 
		for (int i = 0; i < 8; i++) { 
			for (int j = 0; j < 8; j++) { 
				System.out.print(" " + board[i][j] 
								+ " "); 
			}
			System.out.println(); 
		} 
	} 
	boolean CheckSafePos(String board[][], int row, int col) 
	{ 
		int i, j; 
		for (i = 0; i < col; i++) 
			if (board[row][i] == "Q") 
				return false; 
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
			if (board[i][j] == "Q") 
				return false; 
		for (i = row, j = col; j >= 0 && i < 8; i++, j--) 
			if (board[i][j] == "Q") 
				return false; 

		return true; 
	} 
	boolean RecursiveFn(String board[][], int col) 
	{
		if (col >= 8) 
			return true; 
		for (int i = 0; i < 8; i++) { 
			if (CheckSafePos(board, i, col)) { 
				board[i][col] = "Q"; 
				if (RecursiveFn(board, col + 1) == true) 
					return true; 
				board[i][col] = "x"; 
			} 
		} 
		return false; 
	} 
	boolean SolveBoard() 
	{ 
		String board[][] = new String[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j] = "x";
			}
		}

		if (RecursiveFn(board, 0) == false) { 
			System.out.print("Solution does not exist"); 
			return false; 
		} 

		PrintSolution(board); 
		return true; 
	} 
} 

public class Question12{
	public static void main(String args[]) { 
		ChessBoard Queen = new ChessBoard();
		System.out.println("x represents the Chess squares and Q "
				+ "repersents a Queen\nThe Solution to the 8 - Queen Problem is:\n");
		Queen.SolveBoard(); 
	} 
}
