import java.io.*; 
import java.util.*; 
import java.lang.*;

class Solution {
    
    int[] parent;
    int[] rank ;
    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rank[x] > rank[y]) {
            parent[y] = x;
            return;
        }
        if (rank[x] < rank[y]) {
            parent[x] = y;
            return;
        }
        parent[x] = y;
        rank[y] ++;
    }
    int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    int findAncestor(int x) {
    	if (parent[x] == x) return 0;
    	return findAncestor(parent[x])+1;
    }
    
    public int play(int N) {
    //    cities = new int[N+1];
        parent = new int[N+1];
        for (int i=1; i<= N; i++) parent[i] = i;
        rank = new int[N+1];
        
        Random rng = new Random();
        for (int i = 0; i <= N * 2 ; i++) {
        	union(rng.nextInt(N+1), rng.nextInt(N+1));
        }
        
        int max = 0;
        int maxRank = 0;
        for (int i = 0; i <= N; i++) {
        	
        	max = Math.max(max, findAncestor(i));
        	maxRank = Math.max(maxRank, rank[i]);
        }
        System.out.println(max + " " + maxRank);
        
        
        return -1;
    }
}
public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.play(200000000);

	}
}
