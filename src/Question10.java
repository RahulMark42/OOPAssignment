import java.io.*;
import sortingandsearching.*; // this is to import the package, which have the methods we require.

public class Question10 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
	
		System.out.println("Enter the size of the array: ");//Taking an input array from the user.
		int length = Integer.parseInt(br.readLine());
		int[] array = new int[length];
		System.out.println("Enter the array of integers: ");
		for(int i = 0; i < length; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		//All the operations the user can perform, in a menu.
		System.out.println();
		System.out.println("Enter your operation\n1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort\n4. Linear Search\n5. Binary Search");
		int option = Integer.parseInt(br.readLine());
		
		switch(option) {
			case 1:
				BubbleSort.BubbleSortArray(array);
				break;
			case 2:
				SelectionSort.SelectionSortArray(array);
				break;
			case 3:
				InsertionSort.InsertionSortArray(array);
				break;
			case 4:
				System.out.println("Enter the number you want to search for");
				int number = Integer.parseInt(br.readLine());
				LinearSearch.LinearSearchArray(array, number);
				break;
			case 5:
				System.out.println("Enter the number you want to search for");
				number = Integer.parseInt(br.readLine());
				BinarySearch.BinarySearchArray(array, number);
				break;
		}
	}
}
