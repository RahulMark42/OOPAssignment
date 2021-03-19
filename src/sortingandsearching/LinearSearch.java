package sortingandsearching;

public class LinearSearch {
	public static void LinearSearchArray(int[] array, int number) {
		int flag = 0;
		//Linear Search Algorithm
		for(int i = 0; i < array.length; i++) {
			if(array[i] == number) {
				flag = 1;
			}
		}
		if(flag == 1)
			System.out.println(number + " is found using Linear Search");
		else
			System.out.println(number + " is not found using Linear Search");
	}
}
	