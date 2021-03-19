package sortingandsearching;

public class BinarySearch {
	
	public static void BinarySearchArray(int[] array, int number) {
		//Sorting the array using Bubble Sort before Binary Search
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = 0; j < array.length - i - 1; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		//Binary Search algorithm
		int first = 0;
		int last = array.length - 1;
		int flag = 0;
		while(first <= last) {
			int middle = (first + last)/2;
			if(array[middle] > number) {
				last = middle - 1;
			}
			else if(array[middle] < number) {
				first = middle + 1;
			}
			else if(array[middle] == number) {
				flag = 1;
			}
		}
		if(flag == 1)
			System.out.println(number + " is found using Binary Search");
		else
			System.out.println(number + " is not found using Binary Search");
	}

}
