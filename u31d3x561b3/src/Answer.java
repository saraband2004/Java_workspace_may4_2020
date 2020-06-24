import java.io.*; 
import java.util.*; 
import java.lang.*;


class Singleton{
	private Singleton() {
		System.out.println("constructed");
	}
	public static final Singleton instance = new Singleton();
}

enum Color{
	RED, BLUE, GREEN;
	public int value;
	public int getValue() {
		return value; 
	}	
}

public class Answer {
	public static void main(String[] args) {
		Singleton st = Singleton.instance;
		Color r1 = Color.RED;
		Color r2 = Color.RED;
		r1.value = 333;
		System.out.println(r2.getValue());
		
		int x = -240;
		System.out.println(x>>>3);
	}
}
