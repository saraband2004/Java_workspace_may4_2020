import java.io.*; 
import java.util.*; 
import java.lang.*;
class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] numbers = new double[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = nums[i];
        }
        
        Arrays.sort(numbers);
        Map<String, Boolean> memo = new HashMap<>();
        
        return helper(numbers, memo);
    }
    
    private boolean helper(double[] nums, Map<String, Boolean> memo) {
        int n = nums.length;
        if (n == 1) {
            return Math.abs((double)24 - (double)nums[0]) < 0.00001;
        }
        if (memo.containsKey(Arrays.toString(nums))) {
            return memo.get(Arrays.toString(nums));
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] temp = new double[n - 1];
                
                for (int m = 0, idx = 0; m < n; m++) {
                    if (m != i && m != j) {
                        temp[idx++] = nums[m];
                    }
                }
                
                for (double num : calculate(nums[i], nums[j])) {
                    if (Double.isInfinite(num)) {
                        continue;
                    }
                    temp[temp.length - 1] = num;
                    Arrays.sort(temp);
                    boolean res = helper(temp, memo);
                    if (res) {
                        memo.put(Arrays.toString(nums), res);
                        return true;
                    }else {
                        memo.put(Arrays.toString(temp), res);
                    }
                }
            }
        }
        memo.put(Arrays.toString(nums), false);
        return false;
    }
    
    private double[] calculate(double x, double y) {
        return new double[]{ x + y, x - y, y - x, x * y, x / y, y / x};
    }
}
 

public class Answer {
	public static void main(String[] args) {
		int[]  nums = {2,4,3,4};
		System.out.println(new Solution().judgePoint24(nums));
	}
}
