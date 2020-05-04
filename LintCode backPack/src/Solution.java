import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
	int [] bag;
	int [][] matrix;
    public int backPack(int m, int[] A) {
        // write your code here
    	Arrays.sort(A);
    	bag = A;
    	
    	matrix = new int[m + 1][A.length];
    	for (int i=0; i < m + 1 ; i ++) {
    		for (int j=A.length-1; j>=0; j--) {
    			if (j == A.length-1) {
    				matrix[i][j] = bag[j] <= i? bag[j]: 0;
    				continue;
    			}
    			
    			if (bag[j] > i) {
    				matrix[i][j] = 0;
    				continue;
    			}
    			
    			if (bag[j] == i) {
    				matrix[i][j] = i;
    				continue;
    			}
    			
    			matrix[i][j] = bag[j] + matrix[i - bag[j]][j+1];
    			matrix[i][j] = Math.max(matrix[i][j], matrix[i][j+1]);
    			
    		}
    		
    	}
    	return matrix[m][0];
    		
    }
    
    
    
    public int DFS(int m, int index) {
    	if (matrix[m][index] != -1) {
    		return matrix[m][index];
    	}
    	
    	if (index >= bag.length || m == 0) {return 0;}
    	if (bag[index] > m) {return 0;}
    	if (bag[index] == m) {return m;}
    	
    	int res = 0;
    	res = bag[index] + DFS(m - bag[index], index+1);
    	res = Math.max(res, DFS(m, index+1));
    	matrix[m][index] = res;
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		System.out.println("Hello Java");
	}

}
