import java.io.*; 
import java.util.*; 
import java.lang.*;


class MyCom implements Comparator<Integer>{
	HashMap<Integer, Integer> map;
	public MyCom (HashMap<Integer, Integer> map) {
		this.map = map;
	}
	public int compare(Integer list1 , Integer list2) {
		if  ((map.get(list1) + Solution.estimate(list1))
			-(map.get(list2) + Solution.estimate(list2))!= 0) {
			return (map.get(list1) + Solution.estimate(list1))
					-(map.get(list2) + Solution.estimate(list2)); 
		}
		if (list1 > list2) return 1;		
		if (list1 < list2) return -1;
		return 0;
	}
	
	
}
class Solution {
    
	public int pair(int x, int y){
    	x = (x << 16)^(y);   	
    	return x;
    }
    
    public static int[] decompose(int u) {
    	int y = u;
    	y = y << 16;
    	y = y >> 16;
    	int x = y ^ u;
    	
    	return new int[] { x >> 16, y};
    }
	
	int[][] dirs = {{1,2},{-1,-2},{-1,2},{1,-2},{2,1},{-2,-1},{2,-1},{-2,1}};
    
    public static int estimate(int x, int y) {
    
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        int sum = x + y;
        
        return Math.max( (Math.max(x, y)+1)/2,  (sum+2)/3 );       
        
    }
    
    public static int estimate(int x) {
        return estimate(decompose(x));
    }
    
    public static int estimate(int[] arr) {
        return estimate(arr[0], arr[1]);
    }
    
    public int minKnightMoves(int x, int y) {
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        HashMap<Integer, Integer> map = new HashMap<>();
    	TreeSet<Integer> pq = new TreeSet<>(new MyCom(map));
        
    	map.put(pair(x,y), 0);
        pq.add(pair(x,y));
        
        while (!pq.isEmpty()) {
        	int crdn = pq.pollFirst();
        	
        	int steps = map.get(crdn);
        	int[] cdn = decompose(crdn);
        	
        	if (cdn[0] == 0 && cdn[1] == 0) {
        		return steps;
        	}
        	
        	for (int[] dir: dirs) {
        		Integer crdnext = pair(cdn[0] + dir[0], cdn[1] + dir[1]);
        		if (map.containsKey(crdnext)) {
        			if (map.get(crdnext) > steps + 1) {
        				
        				pq.remove(crdnext);
        				map.put(crdnext, steps + 1);
        				pq.add(crdnext);
        			}
        			continue;
        		}
        		else {
        			map.put(crdnext, steps + 1);
            		pq.add(crdnext);
        		}
        	}
        }
        return -1;
    }    
} 

public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.minKnightMoves(1, 1));
		System.out.println(s.minKnightMoves(4000, 8000));
		System.out.println(s.minKnightMoves(8000, 4000));
		System.out.println(s.minKnightMoves(3000, 3000));
		System.out.println(s.minKnightMoves(3242, 3112));
		
	}
}
