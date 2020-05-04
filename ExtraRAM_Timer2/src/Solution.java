import java.io.*; 
import java.util.*; 
import java.lang.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3423);
		LinkedList<Integer> linkedlist = new LinkedList<>();
		ArrayList<Integer> arraylist = new ArrayList<>();
		Random RNG = new Random();
		
		for (int i=0; i<1<<6; i++) {
			linkedlist.add(RNG.nextInt());
			arraylist.add(RNG.nextInt());
		}
		long startTime = System.nanoTime();
		
		linkedlist.remove(3);
		
		
		long endTime = System.nanoTime();
		System.out.println("Took "+((double)(endTime - startTime)/1000/1000/1000) + "s");
		startTime = System.nanoTime();
		
		arraylist.remove(3);
		
		endTime = System.nanoTime();
		System.out.println("Took "+((double)(endTime - startTime)/1000/1000/1000) + "s");
		
		
		
		
		
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = new int[1<<29];
		Random rng = new Random();
		for (int i = 0; i<arr.length ; i ++ ) {
			arr[i] = rng.nextInt(1<<28);
		}
		startTime = System.nanoTime();
		
		pq.poll();
		
		endTime = System.nanoTime();
		System.out.println("Took "+((double)(endTime - startTime)/1000/1000/1000) + "s");
		
		startTime = System.nanoTime();
		pq.remove(1<<28-10);
		
		endTime = System.nanoTime();
		System.out.println("Took "+((double)(endTime - startTime)/1000/1000/1000) + "s");
		
		
		
		
		

	}

}
