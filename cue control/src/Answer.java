import java.io.*; 
import java.util.*; 
import java.lang.*;

class Solution{
	public String[] convert(String[] str) {
		int[][] num = new int[str.length][];
		for (int i = 0; i < num.length ; i ++ ) {
			num[i] = strToInt(str[i]);
			if (i == 0) continue;
			add(num[i-1], num[i]);
		}
		String[] res = new String[num.length];
		for (int i = 0; i < num.length; i ++ ) {
			res[i] = Integer.valueOf(num[i][0]) + ":" + Integer.valueOf(num[i][1]);
		}
		return res;
	}
	public void add(int[] a, int[] b) {
		b[0] += a[0];
		b[1] += a[1];
		if (b[1] >= 60) {
			b[0] ++;
			b[1] -= 60;
		}		
	}
	
	
	public int[] strToInt(String s) {
		String[] str= s.split(":");
		int x = Integer.valueOf(str[0]);
		int y = Integer.valueOf(str[1]);
		return new int[] {x, y};
	}
} 

public class Answer {
	public static void main(String[] args) {
		System.out.println("print");
		String[] str= {"12:33", "11:45", "05:18", "03:34", "09:02", "09:57", "03:40", "05:02", "07:45"};
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.convert(str)));
		
		
		String strs = "dsfadsf00:23asdfdas11:23";
		
		String[] sp = strs.split("^(\\d\\d\\:\\d\\d)");
		System.out.println(Arrays.toString(sp));
	}
}
