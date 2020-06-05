import java.io.*; 
import java.util.*; 
import java.lang.*;


class Solution {
    public int trapRainWater(int[][] heightMap) {
    	TreeSet<List<Integer>> tree = new TreeSet<>(new MyCom(heightMap));
    	int sum = 0;
    	for (int[] row: heightMap) {
    		for (int h: row) {
    			sum -= h;
    		}
    	} 
    
    }
}

class MyCom implements Comparator<List<Integer>> {
	public int compare(List<Integer> a, List<Integer> b) {
		if (hm[a.get(0)][a.get(1)]!=hm[b.get(0)][b.get(1)]) {
			return hm[a.get(0)][a.get(1)] - hm[b.get(0)][b.get(1)];
		}
		if (a.get(0)!= b.get(0)) {
			return a.get(0) - b.get(0);
		}
		return a.get(1) - b.get(1);
	}
	int[][] hm;
	public MyCom (int[][] hm) {
		this.hm = hm;
	}
	
}

public class Answer {
	public static void main(String[] args) {
		int[][] heightMap = new int[][] {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}; 
		System.out.println(new Solution().trapRainWater(heightMap));
	}
}
