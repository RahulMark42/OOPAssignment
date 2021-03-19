import java.io.*;

abstract class DataStructure{
	int[] array;
}

class Stack extends DataStructure{
	int top = 0;
	void CreateStack() {
		array = new int[1];
	}
	void DisplayStack() {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	void DisplayRecentElement(){
		System.out.println("The Recently inserted element is : " + array[array.length - 1]);
	}
	void AddElementToStack(int number) {
		if(top >= array.length - 1) {
			int[] temp = new int[2*array.length];
			for(int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		array[top] = number;
		top++;
	}
	
	void RemoveElementFromStack(){
		int[] temp = new int[array.length - 1];
		for(int i = 0; i < array.length - 1; i++) {
			temp[i] = array[i];
		}
		array = temp;
		top--;
	}
	
}

class Queue extends DataStructure{
	int top = 0;
	void CreateQueue() {
		array = new int[1];
	}
	void DisplayQueue() {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	void DisplayRecentElement(){
		System.out.println("The Recently inserted element is : " + array[array.length - 1]);
	}
	void AddElementToQueue(int number) {
		if(top >= array.length - 1) {
			int[] temp = new int[2*array.length];
			for(int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		array[top] = number;
		top++;
	}
	
	void RemoveElementFromQueue(){
		int[] temp = new int[array.length - 1];
		int c = 0;
		for(int i = 1; i < array.length; i++) {
			temp[c] = array[i];
			c++;
		}
		array = temp;
	}
}


public class Question15 {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		System.out.println("Select your data structure\n1. Stack\n2. Queue");
		int response = Integer.parseInt(br.readLine());
		switch(response) {
			case 1:
				System.out.println("You have selected a stack data structure.");
				Stack stack = new Stack();
				stack.CreateStack();
				boolean next = true;
				while(next == true) {
					System.out.println("What do you want to do?\n1. Add an element to the Stack.\n2. Remove Element from Stack\n"
							+ "3. Display the Stack\n"
							+ "4. Display recently inserted element into the Stack\n5. Exit.");
					int entry = Integer.parseInt(br.readLine());
					switch(entry) {
						case 1:
							System.out.println("Enter a number to add ");
							int number = Integer.parseInt(br.readLine());
							stack.AddElementToStack(number);
							break;
						case 2:
							stack.RemoveElementFromStack();
							break;
						case 3:
							stack.DisplayStack();
							break;
						case 4:
							stack.DisplayRecentElement();
							break;
						case 5:
							next = false;
							break;
					}
				}
				break;
			case 2: 
				System.out.println("You have selected a Queue data structure.");
				Queue queue = new Queue();
				queue.CreateQueue();
				boolean next2 = true;
				while(next2 == true) {
					System.out.println("What do you want to do?\n1. Add an element to the Queue.\n2. Remove Element from Queue\n"
							+ "3. Display the Queue\n"
							+ "4. Display recently inserted element into the Queue\n5. Exit.");
					int entry = Integer.parseInt(br.readLine());
					switch(entry) {
						case 1:
							System.out.println("Enter a number to add ");
							int number = Integer.parseInt(br.readLine());
							queue.AddElementToQueue(number);
							break;
						case 2:
							queue.RemoveElementFromQueue();
							break;
						case 3:
							queue.DisplayQueue();
							break;
						case 4:
							queue.DisplayRecentElement();
							break;
						case 5:
							next = false;
							break;
					}
			}
		}
	}
}