import java.io.*; 
import java.util.*; 
import java.lang.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
    	HashMap<String, Integer> memo = new HashMap<>();
    	//int [][][][] dp = new int [text1.length()] [text1.length()] [text2.length()] [text2.length()];
    	char[] t1 = text1.toCharArray();
    	char[] t2 = text2.toCharArray();
    	return help(t1, 0, t1.length - 1, t2, 0, t2.length - 1, memo);
    }
    public int help(char[] t1, int i1, int j1, char[] t2, int i2, int j2, HashMap<String, Integer> memo) {
    	int[] array = new int[] {i1, j1, i2, j2};
    	String s = Arrays.toString(array);
    	if (memo.containsKey(s)) {
    		return memo.get(s);
    	}
    	if (i1 == j1 && i2 == j2) {
    		if (t1[i1] == t2[i2]) {
    			memo.put(s, 1);
    			return 1;
    		}
    		memo.put(s, 0);
    		return 0;
    	}
    	if (i1 > j1 || i2 > j2) {
    		memo.put(s, 0);
    		return 0;
    	}
    	if (t1[i1] == t2[i2]) {
    		memo.put(s,  1 + help(t1, i1 + 1, j1, t2, i2 + 1, j2, memo));
    		return memo.get(s);
    	}
    	memo.put(s, Math.max(help(t1, i1 + 1, j1, t2, i2, j2, memo), help(t1, i1, j1, t2, i2 + 1, j2, memo)));
    	return memo.get(s);
    }
    
}


public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().longestCommonSubsequence("xxxxxxxxxxxxtxxxtxxxxxxxxxtxxxxxxxxtxxxxxxxxtxxxxxxxxxxxxxxx", 
				"aaaaaaaaaaaaaaaaaaaataaaaaaaaaataaaaaaaaaaatattataaaaaaaaaa"));
	}

}
