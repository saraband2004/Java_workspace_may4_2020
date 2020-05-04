import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		int N = 30;
		int[] nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = new Random().nextInt(7);
		}
		System.out.println(Arrays.toString(nums));
		
			String s = "";
			Scanner sc = new Scanner(System.in);

			while (1 == 1) {
				s = sc.nextLine();
				char[]c = s.toCharArray();
				for (int i=0;i<c.length;i++) {
					if(c[i]=='[') {c[i]='{';}
					if(c[i]==']') {c[i]='}';}
				}
				System.out.println(new String(c));
			}
	}

}
