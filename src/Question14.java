class Person{
	int id;
	String name;
	Person(){
		id = 7567;
		name = "Rex";
	}
}
class Employee1 extends Person{
	int salary;
	Employee1(){
		salary = 501;
	}
}



public class Question14 {
	public static void main(String[] args) {
		Person p = new Person();
		Employee1 e = new Employee1();
		System.out.println("Person ID is " + p.id);
		System.out.println("Person name is " + p.name);
		System.out.println();
		System.out.println("Employee ID is " + e.id);
		System.out.println("Employee name is " + e.name);
		System.out.println("Employee salary is " + e.salary);
	}
}

