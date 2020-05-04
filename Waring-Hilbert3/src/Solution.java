import java.io.*; 
import java.util.*; 
import java.lang.*;

public class Solution {
    public static int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.offer(n);
        set.add(n);
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            level ++ ;
            while (size > 0){
                int m = q.poll();
                int root = (int)Math.cbrt(m);
                while (root > 0){
                    int temp = m - root * root * root;
                    if (temp == 0) {return level;}
                    if (!set.contains(temp)){
                        set.add(temp);
                        q.offer(temp);
                    }
                    root --;
                }
                
                size --;
            }
        }
        return -1;
        
    }
	
	
	
    public static int numCubes(int n) {
        
        return NUMCUBE(n, n);
    }
    public static int NUMCUBE(int n, int depth) {
    	if (n == 0) {return 0;}
    	if (depth <= 0) {return n;}
    	int min=n;
    	int root = (int) Math.cbrt(n);
    	while (root >=1) {
    		if (n-root*root*root>=0) {min=Math.min(min, 1+NUMCUBE(n-root*root*root, depth-1));}
    		depth=Math.min(depth, min);
    		root--;
    		
    		if (depth!=0 && root*root*root < Math.max(1,n/depth)) {break;}
    	}
    	return min;
    }

	

    public static int numCubes2(int n) {
        
        return NUMCUBE2(n, n);
    }
    public static int NUMCUBE2(int n, int depth) {
    	if (n == 0) {return 0;}
    	if (depth <= 0) {return n;}
    	int min=n;
    	int root = (int) Math.cbrt(n);
    	while (root >=1) {
    		if (n-root*root*root>=0) {min=Math.min(min, 1+NUMCUBE2(n-root*root*root, depth-1));}
    		depth=Math.min(depth, min - 1);
    		root--;
    		
    		//if (depth!=0 && root*root*root < Math.max(1,n/depth)) {break;}
    	}
    	
    	return min;
    }

    
    
	
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Solution S=new Solution();
		int max=0;
		int temp =0;
		int example = 1;
		Solution s = new Solution();
		for (int i=1; i<10000; i+= 1) {
			if ( numCubes(i)!= numCubes2(i)) {System.out.println("error");}
			//else {System.out.print(i);}
		}
		
		
		//System.out.println((int)Math.sqrt(9));
		System.out.println(example+": "+max);
		System.out.println(new Solution().numCubes(1290740));
	}

}
