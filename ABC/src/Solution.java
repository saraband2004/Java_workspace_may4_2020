import java.io.*; 
import java.util.*; 
import java.lang.*;

/////
public class Solution {
	
	long count ;
	
	public long abc(int k) {
		int A, B, C;
		A = B = C = 0;
		count = 0;
		
		DFS(A,B,C,k);
		
		return count;
	}
	public void DFS(int A, int B, int C, int k) {
		if (A == k && B == k && C == k) {
			count++;
			return;
		}
		if (A > k || B > k || C > k ) {return;}
		if (A < B || B < C) {return;}
		DFS(A+1, B, C, k);
		DFS(A, B+1, C, k);
		DFS(A, B, C+1, k);
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		for ( int i =1; i<18; i++)System.out.print(new Solution().abc(i) + ", ");
	}

}
