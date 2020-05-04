import java.io.*; 
import java.util.*; 
import java.lang.*;

class Solution {
    int[] dp;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
         dp = new int[1<<nums.length];
        //Arrays.fill(dp, -1);
        int bag = sum/k;
        //HashMap<Integer, Boolean> memo = new HashMap<>();
        Arrays.sort(nums);
        return dfs(null, nums, 0, 0, bag, bag);
    }
    public boolean dfs(HashMap<Integer, Boolean> memo, int[] nums, int status, int index, int remain, int bag){
        if (index == nums.length){
            if (remain != 0) return false;
            if (remain == 0) {
                if (status != (1<<nums.length)-1) {
                    return dfs(memo, nums, status, 0, bag, bag);
                }
                else return true;
            }
        }
        
        if (dp[status]!= 0) {
            return dp[status] == 1;
        }
        
        boolean ans = false;
        if (((1<<index)&status) != 0) {
            ans = dfs(memo, nums, status, index + 1, remain, bag);
        }
        else if (nums[index] <= remain){
            ans |= dfs(memo, nums, status, index + 1, remain, bag);
            ans |= dfs(memo, nums, status|(1<<index), index + 1, remain - nums[index], bag);
        }
        if (ans) {
            dp[status] = 1;
        }
        else {
            dp[status] = -1;
        }
        return ans;
    }
}

public class Answer {
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,
				      1,1,1,1,1,
				      1,1,1,1,1,
				      1,1,1,1,1,
				      1,1,1,1,1,
				      1,1,1,1,
				      31 
				      };
		
		System.out.println(new Solution().canPartitionKSubsets(nums, 30));
	}
}
