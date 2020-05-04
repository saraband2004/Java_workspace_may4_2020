import java.io.*; 
import java.util.*; 
import java.lang.*;


class Node{
	public int id;
	public LinkedList<Integer> next= new LinkedList<>();
	public Node (int id) {	this.id = id;	}
}

class Solution{
	Node[] node;
	int time = 0;
	List<List<Integer>> result = new LinkedList<>();		
	int[] score;
	int[] disc;
	public List<List<Integer>> criticalConnections(int N, List<List<Integer>> connections){
		node = new Node[N];
		for (int i=0; i<N; i++) {
			node[i] = new Node(i);
		}
		score = new int[N];
		disc = new int[N];
		Arrays.fill(score, -1);
		Arrays.fill(disc, -1);

		for (List<Integer> edge: connections) {
			node[edge.get(0)].next.add(edge.get(1));
			node[edge.get(1)].next.add(edge.get(0));
		}
		dfs(0, -1);
		return result;
	}
	public int dfs(int v, int from) {
		int min = time;
		score[v]= time ;
		disc [v]= time ++; 
		for (int next: node[v].next) {
            if (next == from ) continue;
            if (score[next]!=-1) {
            	min = Math.min(min, disc[next]);
            }
            else {
            	int d = dfs(next, v);
            	if (d > disc[v]) {
            		List<Integer> list = new LinkedList<>();
            		list.add(v);
            		list.add(next);
            		result.add(list);
            	}
            	min = Math.min(min, d);
            }
 		}
		if (min < score[v]) score[v] = min;
		
		if (min == disc[v]) {
			System.out.print("*");
			DFS(v);
			System.out.print("*");
		}
		
		return min;
	}
	
	HashSet<Integer> set = new HashSet<>();
	public void DFS(int v) {
		if (set.contains(v)) return;
		
		set.add(v);
		System.out.print(v+",");
		for (int next: node[v].next) {
			if (disc[next] < disc[v]) continue;
			DFS(next);
		}
	}
	
}

public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] edgess= {{0,1},{1,2},{2,3},{3,4},{4,2},{2,5},{5,1},{3,6},{6,7}};
		int numNodes= 8;
		System.out.println("xx");
		List<List<Integer>> edges = new LinkedList<List<Integer>>();
		for (int[] e: edgess) {
			List<Integer> t = new LinkedList<>();
			t.add(e[0]);
			t.add(e[1]);
			edges.add(t);
		}
 
		System.out.println( s.criticalConnections(numNodes, edges));
		
 
	}
}
