//Implement a program with help of given two linked lists, insert nodes of first list in to
//second list at even positions of second list. For example: first list is 5 7 17 13 11 and second
//list is 12 10 12 4 6. Output must be 5 12 7 10 17 12 13 4 11 6.


//defining a node
import java.io.*;

class NewNode{
	int number;
	NewNode next;
}

//Defining a new Linked List Class
class NewLinkedList{
	NewNode head;
	
	//Method to Add Element into the List.
	void AddElement(int number) {
		NewNode newNode = new NewNode();
		newNode.number = number;
		newNode.next = null;
		if(head == null) {	
			head = newNode;
		}
		else {
			NewNode temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	//Method to Display the Elements of the list
	void DisplayElement() {
		NewNode temp = head;
		while(temp.next != null) {
			System.out.print(temp.number + " ");
			temp = temp.next;
		}
		System.out.print(temp.number + " ");
	}
	
	//Method to merge the two Linked Lists as given in the question
	void MergeLinkedLists(NewLinkedList list1, NewLinkedList list2) {
		NewNode pointing1 = list1.head;
		NewNode adding1 = list2.head;
		NewNode adding2 = null;
		NewNode pointing2;
		while(pointing1 != null && adding1 != null) {
			pointing2 = pointing1.next;
			adding2 = adding1.next;
			
			adding1.next = pointing2;
			pointing1.next = adding1;
			
			pointing1 = pointing2;
			adding1 = adding2;
		}
		list2.head = adding1;	
	}
}

public class Question13 {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		NewLinkedList list1 = new NewLinkedList();
		NewLinkedList list2 = new NewLinkedList();
		
		//Taking the data from the user
		System.out.println("Enter number of elements in the first Linked List");
		int length1 = Integer.parseInt(br.readLine());
		System.out.println("Enter number of elements in the second Linked List");
		int length2 = Integer.parseInt(br.readLine());
		System.out.println("Enter " + length1 + " elements to add to the first Linked List");
		int c = 0;
		while(c < length1) {
			int number = Integer.parseInt(br.readLine());
			list1.AddElement(number);
			c++;
		}
		System.out.println("Enter " + length2 + " elements to add to the second Linked List");
		c = 0;
		while(c < length2) {
			int number = Integer.parseInt(br.readLine());
			list2.AddElement(number);
			c++;
		}
		
		//Merging the List
		System.out.println("First Linked List: ");
		list1.DisplayElement();
		System.out.println();
		System.out.println("Second Linked List");
		list2.DisplayElement();
		NewLinkedList newMergedList = new NewLinkedList();
		System.out.println();
		System.out.println("Merged Lists are");
		newMergedList.MergeLinkedLists(list1, list2);
		list1.DisplayElement();	
	}

}
