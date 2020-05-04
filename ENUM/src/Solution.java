import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	public static int global;
	
	
	
	
	public static void function1() {
		global=3;
	}
	
	public static void function2() {
		
		System.out.println(global);
		
	}
	
	
	
	
	
	
	
	enum Color 
	{ 
	     RED, GREEN, BLUE; 
	} 
	public static void function(Color x) {
		
		if (x==Color.BLUE) {System.out.println("blUe!");}
		if (x==Color.RED) {System.out.println("rEd!");}
		if (x==Color.GREEN) {System.out.println("gReen!");}
		
	}
	public static Color funny(int x) {
		
		if (x==0) {return Color.BLUE;}
		
		return Color.RED;
		
	}
	public static void SWISS(int x) {
		switch (x) {
		case 1: System.out.println("one");x++; break;
		
		case 2: System.out.println("two");x++;x++;x++;x++;x++;x++;x++;x++;x++;x++;
		case 3: System.out.println("three");x++;
		default: System.out.println("IDK"+" "+x);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		
		SWISS(2);
		
		String s="aaaaaaaaaa";
		StringBuilder str=new StringBuilder(s);
		str.append("abdc"); 
		str.setCharAt(5, 'x');
		System.out.println(str);
		
		
		
		Color c1 = Color.RED;
		c1=Color.GREEN;
		System.out.println(c1);
		
		c1=Color.valueOf("RED");
		function(c1);
		
		c1=funny(1);
		
		System.out.println(c1);
		
		function1();
		function2();
		global=5;
		function2();
			int [ ] nums = new int[1<<30];
			int [ ] nums2 = new int[1<<30];
		
	}

}
