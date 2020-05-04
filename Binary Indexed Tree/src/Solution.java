import java.io.*; 
import java.util.*; 
import java.lang.*;


class NumArray {
	public int lowid(int n) {
		//return n&(~(n-1));
		return n&(-n);
	}
	public int [] num;
    public NumArray(int[] nums) {
        num = new int [nums.length + 1];
        for (int i = 0; i<nums.length; i++) {
        	num[i+1] += nums[i];
        	if (i+1 + lowid(i+1) <= nums.length) {
        		num[i+1+ lowid(i+1)] += num[i+1];
        	}
        }
    }
    
    public void update(int i, int val) {
        
        
        int diff = val - sumRange(i,i);
        i++;
        
        while(i < num.length) {
        	num[i] += diff;
        	i += lowid(i);
        }
    }
    public int prefixsum(int j) {
    	j++;
    	int sum =0;
    	while (j!=0) {
    		sum += num[j];
    		j -= lowid(j);
    	}
    	return sum;
    }
    public int sumRange(int i, int j) {
        return prefixsum(j) - prefixsum(i-1);
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

public class Solution {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,3,5};
		
		NumArray sol = new NumArray(nums);
		sol.update(1, 2);
		System.out.println(sol.sumRange(2, 2));
	}   
	
 

}
