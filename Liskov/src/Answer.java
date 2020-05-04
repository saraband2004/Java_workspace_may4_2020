import java.io.*; 
import java.util.*; 
import java.lang.*;
class Car{
	
}
class Sedan extends Car{
	
}
class SUV extends Car{
	
}
class Parent {
	void one(Car c) {
		System.out.println("parent one");
	}
	void two(Sedan s) {
		System.out.println("parent two");
	}
}

class Child extends Parent {
	void one(Sedan s) {
		System.out.println("child one");
	}
	<T extends Car> void two(T c) {
		System.out.println("child two");
	}
}


class Daughter {
	void one(Sedan s) {
		System.out.println("daughter one");
	}
	<T extends Car> void two(T c) {
		System.out.println("daughter two car");
	}
 
}


public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sedan sedan = new Sedan();
		Car car = new Car();
		SUV suv = new SUV();
		Parent parent = new Parent();
		Child child = new Child();
		
		parent.one(car);
		parent.one(sedan);
		//parent.two(car);
		parent.two(sedan);
		
		child.one(car);
		child.one(sedan);
		child.two(car);
		child.two(sedan);
 
 
	}

}
