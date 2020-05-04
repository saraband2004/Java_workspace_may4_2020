import java.io.*; 
import java.util.*; 
import java.lang.*;

class Node{
	public int id;
	public List<Integer> next = new LinkedList<>();
	public Node (int id) {
		this.id = id;
	}
}



class Solution{
	int[] distance;
	int[] lowDist;
	Node[] nodes;
	int time = 0;
	int root = 0;
	public List<Integer> criticalRouters(int numNodes, int[][] edges) {
		nodes = new Node[numNodes];
		for (int i = 0; i < numNodes; i++ ) {
			nodes[i] = new Node (i);			
		}
		for (int[] edge: edges) {
			nodes[edge[0]].next.add(edge[1]);
			nodes[edge[1]].next.add(edge[0]);
		}
		distance = new int[numNodes];
		lowDist = new int[numNodes];
		
		List<Integer> result = new LinkedList<>();
		Arrays.fill(distance, -1);
		Arrays.fill(lowDist, -1);
		
		dfs(root, result, -1);
		System.out.println(Arrays.toString(distance));
		System.out.println(Arrays.toString(lowDist));
		
		return result;
	}
	public int dfs(int i, List<Integer> result, int parent) {

		distance[i] = time ++;
		
		lowDist[i] = distance[i];
		int min = time; 
		int max = -1;
		int count = 0;
		
		for (int j : nodes[i].next) {
			if (j == parent) continue;
			
			if (distance[j] == -1) count++;
			if (distance[j] != -1) {
				min = Math.min(min, distance[j]);
				continue;
			}
			int t = dfs(j, result, i);
						
			min = Math.min(t, min);
			max = Math.max(t, max);
		}
		lowDist[i] = Math.min(min, lowDist[i]);
		
		if (max >= distance[i] && i!= root) result.add(i);
		else if (i ==  root) {
			//if (max > 0 && nodes[root].next.size() != 1) result.add(i);
			if (count > 1) result.add(i);
		}
		return lowDist[i];
	}
}


public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//int[][] edges=  {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
		//int[][] edges= {{0,1},{1,2},{2,3},{3,4},{4,2},{2,5},{5,1}};
		
		int [][]edges = {{0, 1}, {0, 4}, {1, 4}, {1, 2}, {1, 3}, {2, 3}};

		int numNodes= 5;
		System.out.println( s.criticalRouters(numNodes, edges)  );
 
	}
}
