import java.io.*; 
import java.util.*; 
import java.lang.*;

 

public class Solution {
	
	int[] nums;
	HashMap<Integer, Integer> reachable = new HashMap<>();
	HashMap<Integer, Integer> unreachable = new HashMap<>();
	
	public int jump(int [] nums) {
		this.nums = nums;
		return dfs(0, nums.length - 1);
	}
	public int dfs(int index, int depth) {
		
		//System.out.println(index + " " + depth);
		if (index >= nums.length - 1) {
			return 0;
		}
		if (depth <= 0) {
			return -1;
		}
		if (reachable.containsKey(index)) {
			return reachable.get(index);
		}
		if (unreachable.containsKey(index)) {
			if (unreachable.get(index) >= depth) {
				return -1;
			}			
		}		
		int min = Integer.MAX_VALUE;		
		
		for (int i=nums[index]; i>= 1; i--) {
			//min = 1 + Math.min(min, DFS(index + i, depth - 1));
			int prev_res = dfs(index + i , depth - 1);
			if (prev_res == - 1) continue;
			min = Math.min(min, 1 + prev_res);
			depth = Math.min(min - 1, depth);
		}
		if (min == Integer.MAX_VALUE) {
			unreachable.put(index, depth);
			return -1;
		}
		reachable.put(index, min);
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = //{2,3,1,1,4}; 
				{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
				//{5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0};
		System.out.print(" answer: " + new Solution().jump(nums));		
	}
}
