//Program to store employee details in a linked list
//and have features to addElement and removeElement
//Employee details include Name, SNo, phone number, salary
//------useful imports---------
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//------Employee class - used to create the different employee 
//node elements--------
class Employee{
	String name;
	int sNo;
	int phNo;
	int salary;
}

//------Structure of the node-------
class Node{
	Employee e;
	Node next;
}

//-------LinkedList class with various member methods like 
//addElement, removeElement and displayElement-------
class LinkedList{
	Node head;
	
	//------to addElement at first or last position------
	public void addElement(Employee e, String position) {
		Node node = new Node();
		node.e = e;
		node.next = null;
		if(position == "First") {
			if(head == null)
				head = node;
			else {
				node.next = head;
				head = node;
				
			}
		}
		else {
			if(head == null)
				head = node;
			else
			{
				Node temp = head;
				while(temp.next != null) {
					temp = temp.next;
				}
				temp.next = node;
			}
		}
	}
	
	//------to display element------
	public void displayElement() {
		Node node = head;
		while(node.next != null) {
			System.out.println("sNo: " + node.e.sNo);
			System.out.println("Name: " + node.e.name);
			System.out.println("phNo: " + node.e.phNo);
			System.out.println("Salary: " + node.e.salary);
			System.out.println();
			node = node.next;
		}
		System.out.println("sNo: " + node.e.sNo);
		System.out.println("Name: " + node.e.name);
		System.out.println("phNo: " + node.e.phNo);
		System.out.println("Salary: " + node.e.salary);
		System.out.println();
		
	}
	
	//------to remove element at a position-------
	public void removeElement(int position) {
		int x = 1;
		Node temp = head;
		while(x < position - 1) {
			temp = temp.next;
			x++;
		}
		Node cur = temp.next;
		temp.next = cur.next;
		cur.next = null;
		System.out.println("Employee at position " +position+" removed");
	}
}

public class Question1 {
	
	//------main method--------
	
	public static void main (String[] args) throws NumberFormatException, IOException {
		
		//---------Creating initial data elements---------
		Employee o = new Employee();
		Employee p = new Employee();
		Employee r = new Employee();
		Employee s = new Employee();
		o.name = "Aditya";
		o.sNo = 1;
		o.phNo = 345;
		o.salary = 123;
		r.name = "Mandal";
		r.sNo = 2;
		r.phNo = 678;
		r.salary = 1234;
		p.name = "Avinash";
		p.sNo = 3;
		p.phNo = 34563;
		p.salary = 12343;
		s.name = "Shashi";
		s.sNo = 4;
		s.phNo = 2092;
		s.salary = 12339;
		LinkedList list = new LinkedList();
		list.addElement(o, "First");
		list.addElement(r, "Last");
		list.addElement(p, "First");
		list.addElement(s, "Last");
		
		//-------Creating a newElement for our task-------
		Employee newElement = new Employee();
		
		//-------Taking user input using buffered reader and input stream reader---------
		System.out.println("What do you want to do?\n1. Add an employee\n2. Remove an employee\n3. Display all employees");
		InputStreamReader r1 =  new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r1);
		int input = Integer.parseInt(br.readLine());
		
		//---------various cases from the input by the user--------
		switch(input) {
			case 1:
				System.out.println("Enter details of the employee:\nEnter name: "); 
				newElement.name = br.readLine();
				System.out.println("Enter SNo: ");
				newElement.sNo = Integer.parseInt(br.readLine());
				System.out.println("Enter Ph.No: ");
				newElement.phNo = Integer.parseInt(br.readLine());
				System.out.println("Enter Salary: ");
				newElement.salary = Integer.parseInt(br.readLine());
				System.out.println("Enter where do you want to add\n1. First 2. Last");
				int pos = Integer.parseInt(br.readLine());
				if(pos == 1) {
					list.addElement(newElement, "First");
				}
				else {
					list.addElement(newElement, "Last");
				}
				list.displayElement();
				break;
			case 2:
				System.out.println("Enter the position at which you want to remove the employee");
				pos = Integer.parseInt(br.readLine());
				list.removeElement(pos);
				list.displayElement();
				break;
			case 3:
				list.displayElement();
				break;
		}
	}
}
