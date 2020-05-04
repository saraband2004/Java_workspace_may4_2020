import java.io.*; 
import java.util.*; 
import java.lang.*;


class Solution{
	
	public int[] partitionNumber(int n) {
		int[] result = new int[n+1];
		result[0] = 1;
		for (int c=1; c<=n; c++) {
			for (int i=1; i<=n; i++) {
				if (i >= c) {
					result[i] += result[i-c];					
				}
			}
		}
		return result;		
	}
	int sum;
	public int partition(int n) {
		sum = 0;
		
		dfs(n, n);
		
		return sum;
	}
	public void dfs(int n, int x) {
		if (n == 0) {
			sum += 1;
			return;
		}
		
		for (int i=1; i <= Math.min(x, n); i++) {
			dfs(n - i, x);
		}
	}
}



public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(new Solution().partitionNumber(120)));
		System.out.println(new Solution().partition(5));
	}

}
