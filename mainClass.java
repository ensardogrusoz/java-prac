/*
will ask user to enter radius 1 and 2, then it will compare both radius, if they are the same radii it will print out area and 
circumference. If they are different radii then it will print out area and circumference or both radii.
*/

package circle;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first radius ");
		double radius1 = scan.nextDouble();
		System.out.println("Enter second radius ");
		double radius2 = scan.nextDouble();
		scan.close();
		
		Circle circle1 = new Circle(radius1);
		Circle circle2 = new Circle(radius2);
		
		if(circle1.equals(circle2)) {
			System.out.println("Both are equal with a circumference of "+ circle1.circumference() + " and area of " + circle1.area());
		}
		else {
			System.out.println("They are not equal, circle 1 has circumference of " + circle1.circumference() + " and area of " + circle1.area());
			System.out.println("and circle 2 has circumference of " + circle2.circumference() + " and area of " + circle2.area());
		}
	}

}

class Circle {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double newRadius) {
		newRadius = radius;
	}
	
	public Circle(double radius) {
		this.radius= radius;	
	}
	
	public Circle() {
		radius = 1.0;
	}
	
	public double circumference() {
		double circumference = 2 * Math.PI * radius;
		return circumference;
	}
	public double area() {
		double area = Math.PI * (radius * radius);
		return area;
	}
	public String toString() {
		return "Circle " + radius;
	}
	public boolean equals(Circle other) {
		return (other.radius == radius);
	
				
	}
}
