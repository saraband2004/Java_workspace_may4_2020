
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3423);
		
		long startTime = System.nanoTime();
		
		
		
		long [ ] nums = new long[Integer.MAX_VALUE >>5];
		for (int i=0; i<nums.length; i++) {
			nums[i] = System.nanoTime();
		}
		for (int i=0; i<nums.length; i++) {
		    System.out.println(	nums[i] );
		} 
		
		
		long endTime = System.nanoTime();
		System.out.println("Took "+((double)(endTime - startTime)/1000/1000/1000) + "s");
		startTime = System.nanoTime();
		
		
		int [ ] nums2 = new int[Integer.MAX_VALUE >> 5];
	//	for (int x: nums2) {System.out.println(x);}
		
		
		endTime = System.nanoTime();
		System.out.println("Took "+((double)(endTime - startTime)/1000/1000/1000) + "s");
		
		

	}

}
