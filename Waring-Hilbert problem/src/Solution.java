import java.io.*; 
import java.util.*; 
import java.lang.*;

public class Solution {
	public static int numSquares1(int n) {  // BFS
		int level = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		HashSet<Integer> set = new HashSet<>();
		set.add(n);
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			while (size > 0) {
				int p = queue.poll();
				if (p == 0) return level;
				for (int i = (int)Math.sqrt(p); (i>0) && i*i > p/4 - 1  ; i -- ) {
					if (!set.contains(p - i*i)) {
						queue.offer(p - i*i);
						set.add(p - i*i);
					}
				}
				size -- ;
			}
			level ++ ;
		}
		return level;
	}
	public static int numSquares2(int n) {  // BFS
		int level = 0;
		
		HashSet<Integer> queue = new HashSet<>();
		HashSet<Integer> temp = new HashSet<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			
			for (int p : queue) {
				if (p == n) return level;				
				for (int i = 1; i * i + p <= n; i ++ ) {
					temp.add(i * i + p);
				}
			}
			queue.clear();
			HashSet<Integer> _temp = temp;
			temp = queue;
			queue = _temp;
			
			level ++ ;
		}
		return level;
	}
	
    public static int numSquares3(int n) {
        int i = 1;
        int m;
        ArrayList <Integer> list = new ArrayList<>();
        ArrayList <Integer> list2 = new ArrayList<>();
        while ( (m=i*i) <= n ) {
            list.add( m );
            i++;
        }
        i = list.size()-1;
        
        while (i >= 0) {
        	list2.add(list.get(i));
        	i--;
        }
        list=list2;
        return NUMSQ(n, list, n);
    }
    
    public static int NUMSQ(int n, ArrayList<Integer> list, int depth) {
    	
    	if (n == 0) {return 0;}
    	if (depth <= 0) {return n;}
    	int min=n;
    	
    	for (int m: list) {
    		if (n-m>=0) {min=Math.min(min, 1+NUMSQ(n-m, list, depth-1));}
    		depth=Math.min(depth, min - 1);
    	}
    	
    	return min;
    }
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <   10000; i ++ ) {
			if (numSquares3(i)!= numSquares1(i))
				System.out.println("error");
		}
	}
}
