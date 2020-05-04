import java.io.*; 
import java.util.*; 
import java.lang.*;

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k, int t) {
    	
    	int[] sums = new int[nums.length - k + 1];
    	int sum = 0;
    	for (int i = 0; i < k ; i ++ ) {
    		sum += nums[i];
    	}
    	sums[0] = sum;
    	for (int i = 1; i < sums.length ; i ++ ) {
    		sum -= nums[i - 1];
    		sum += nums[i + k - 1];
    		sums[i] = sum;
    	}
    }
}

public class Answer {
	public static void main(String[] args) {
		System.out.println("print");
	}
}
