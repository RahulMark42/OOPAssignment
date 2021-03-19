abstract class Shape{
	int a;
	int b;
	abstract void Area();
}

class Rectangle extends Shape{
	void Area() {
		System.out.println("Rectange area is : " + a * b);
	}
}

class Triangle extends Shape{
	void Area() {
		System.out.println("Triangle area is: " + 0.5 * a * b);
	}
}

class Circle extends Shape{
	void Area() {
		System.out.println("Circle area is: " + 3.14 * a *a);
	}
}
public class Question16 {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		Triangle tri = new Triangle();
		Circle cir = new Circle();
		rect.a = 2;
		rect.b = 4;
		tri.a = 2;
		tri.b = 4;
		cir.a = 2;
		cir.b = 4;
		rect.Area();
		tri.Area();
		cir.Area();
	}
}
