//Program to print a matrix in a Spiral order 

import java.io.*;
public class Question19 {
	static void PrintSpiralArray(int[][] array, int m, int n) {
		int starti = 0;
		int startj = 0;
		int count = 0;
		int row = m;
		int col = n;
		while(count < m*n) {
			int presenti = starti;
			int presentj = startj;
			for(int j = presentj; j < col; j++) {
				System.out.print(array[presenti][j] + " ");
				count++;
				presentj++;
			}
			presentj--; presenti++;
			
			for(int i = presenti; i < row; i++) {
				System.out.print(array[i][presentj] + " ");
				count++;
				presenti++;
			}
			presenti--; presentj--;
			
			for(int j = presentj; j >= startj; j--) {
				System.out.print(array[presenti][j] + " ");
				count++;
				presentj--;
			}
			presentj++; presenti--;
			
			for(int i = presenti; i > starti; i--) {
				System.out.print(array[i][startj] + " ");
				count++;
			}
			presenti--; presentj--;
			starti++; startj++;
			row--; col--;	
		}
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		System.out.println("Enter the dimensions of your matrix");
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter " + m*n + " elements");
		int[][] array = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(br.readLine());
			}
		}
		System.out.println("The entered array is: ");
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("The Array in a spiral order is: ");
		PrintSpiralArray(array, m, n);
	}
	
}
