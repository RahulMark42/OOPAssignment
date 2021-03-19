package sortingandsearching;

public class SelectionSort {
	public static void SelectionSortArray(int[] array) {
		//Algorithm for Selection Sort
		for(int i = 0; i < array.length; i++){
			int min = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		
		//Sorted Array in Ascending Order 
		System.out.println();
		System.out.println("Selection Sorted Array Ascending Order is: ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}


