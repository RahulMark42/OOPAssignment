package sortingandsearching;

public class InsertionSort {
	public static void InsertionSortArray(int[] array) {
		//Algorithm for Insertion Sort
		for(int i = 1; i < array.length; i++) {
			int pointer = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > pointer) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = pointer;			
		}
		
		//Sorted Array in Descending Order
		System.out.println("Insertion Sorted Array Descending order is: ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] +  " ");
		}
	}
}


