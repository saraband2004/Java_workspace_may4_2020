import java.io.*; 
import java.util.*; 
import java.lang.*;
  
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true; 
        
        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;
    
        for (int i=1; i<s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) 
             && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
             && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }
}

class Solution2 {
    public boolean isScramble(String s1, String s2) {
    	char[] c1 = s1.toCharArray();
    	char[] c2 = s2.toCharArray();
    	if (c1.length!=c2.length) return false;
    	boolean[][][][] matrix = new boolean[c1.length][c2.length][c1.length][c2.length];
    	
    	for (int increment = 0; increment < c1.length; increment ++ ) {
    		for (int i = 0; i + increment < c1.length; i++ ) {
    			for (int j = 0; j + increment < c1.length; j++ ) {
    				if (increment == 0) {
        				matrix[i][i][j][j] = c1[i] == c2[j];
        				continue;
        			} 				
    				for (int k = 0; k < increment; k ++ ) {
    					
    					matrix[i][i+increment][j][j+increment] |=
    						matrix[i][i+k][j][j+k] && matrix[i+k+1][i+increment][j+k+1][j+increment];
   
    					matrix[i][i+increment][j][j+increment] |=
       						matrix[i][i+k][j+increment-k][j+increment] && matrix[i+k+1][i+increment][j][j+increment-k-1];
    					
    				}
    			}   			
    		}
    	}
    	return matrix[0][c1.length - 1][0][c1.length - 1];
    }
}



public class Answer {
	public static void main(String[] args) {
		String s1= "aaaaaaaaaaaaabaaadaaaaacaaaafgaaaaeaaaaaaa";
		String s2= "aaaaaaaaaaaagaaaaaaaaaaaaaeaaaaaabaaadaaaa";
		System.out.println(new Solution().isScramble(s1, s2));
	}
}
