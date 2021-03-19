package sortingandsearching;

public class BubbleSort {
	public static void BubbleSortArray(int[] array) {
		//Algorithm for Bubble Sorted
		int[] newArray = array;
		for(int i = 0; i < newArray.length - 1; i++) {
			for(int j = 0; j < newArray.length - i - 1; j++) {
				if(newArray[j] > newArray[j + 1]) {
					int temp = newArray[j];
					newArray[j] = newArray[j + 1];
					newArray[j + 1] = temp;
				}
			}
		}
		//Sorted Array in Ascending Order
		System.out.println("Bubble Sorted Array Ascending Order is: ");
		for(int i = 0; i < newArray.length; i++) {
				System.out.print(newArray[i]+ " ");
			}
		System.out.println();
		//Sorted Array in Descending Order
		System.out.println("Bubble Sorted Array Descending order is: ");
		for(int i = newArray.length - 1; i >= 0; i--) {
			System.out.print(newArray[i]+ " ");
			}
	}
}



