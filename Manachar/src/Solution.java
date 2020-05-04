import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
    public int countSubstrings(String s) {
    	char[]c = new char[s.length()*2+1];
    	char[]cc= s.toCharArray();
    	int i = 0;
    	int ii= 0;
    	while (i < c.length) {
    		if (i%2 == 0) { c[i] = '#'; }
    		else {
    			c[i] = cc[ii];
    			ii++;
    		}
    		i++;
    	}
    	return Manachar(c);
    	
    	
    }
	public int Manachar(char[]c) {
		int max = 0;
		int [] radius = new int [c.length];
		int furthest  = 0;
		int furcenter = 0;
		int startradius=0;
		int mirrorcenter=0;
		int maxcenter = 0;
	//	String res = new String();
		for (int center = 0; center < c.length; center++) {
			
			if (furthest > center) {
				mirrorcenter = 2* furcenter - center;
				if (radius[mirrorcenter] < furthest - center) {
					radius[center] = radius[mirrorcenter];
				}
				else {
					startradius = furthest - center;
					int r = startradius;
					while (center + r < c.length && center - r >= 0) {
						if (c[center + r] == c[center - r]) {
							furthest = center+r;
							furcenter = center;
							r++;
						}
						else {break;}
					}
					
					radius[center] = r-1;
				}
			}
			else {
				int r = 0;
				while (center + r < c.length && center - r >= 0) {
					if (c[center + r] == c[center - r]) {
						furthest = center+r;
						furcenter = center;
						r++;
					}
					else {break;}
				}
				
				radius[center] = r-1;

			}
			if (radius[center] > max) {maxcenter = center;}
	//		System.out.println(radius[center]);
			
			
			max += (radius[center]+1)/2;
			
			
		}
//		for (int i = maxcenter - max; i <= maxcenter+max; i++) {
//			if (c[i]!='#') {
//				res = res+c[i];
//			}
//		}
		
		
		
		return max;
		
	}
	
	
	public static void main(String[] args) {
		String str = "aaa";
		char[] c= str.toCharArray();
		System.out.println(new Solution().countSubstrings(str));
 	}   
 

}
