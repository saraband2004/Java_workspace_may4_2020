import java.io.*; 
import java.util.*; 
import java.lang.*;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class Node{
  public int index;
  public List<Integer> next = new LinkedList<>();
  public Node (int i){
    index = i;
  }
}


class Solution {
	int[] arrival ;
	int[] min ;
	int time; 
	public int[] findRedundantConnection(int[][] edges) {
		int N = edges.length;
	    Node [] nodes = new Node[N+1];
	    arrival = new int[N+1];
	    min = new int[N+1];
	    time = 3;
	    
	    for (int i = 1; i <= N; i ++ ){
	    	nodes[i] = new Node(i);
	    }
	    
	    for (int[] edge: edges){
	    	nodes[edge[0]].next.add(edge[1]);
	    	nodes[edge[1]].next.add(edge[0]);
	    }
	    HashSet<Integer> visited = new HashSet<>();
	    HashSet<Integer> loop = new HashSet<>();
	    dfs(nodes, 1, visited, loop, -1);
	    for (int i = N-1; i >=0 ; i --){
	    	if (loop.contains(edges[i][0] + edges[i][1] * nodes.length)){
	    		return edges[i];
	    	}
	    }
	    return null;
	}
	public int dfs(Node[] nodes, int index, HashSet<Integer> visited, HashSet<Integer> loop, int prev){
		if (visited.contains(index)) {
			return arrival[index];
		}
		visited.add(index);
		arrival[index] = time;
		min[index] = time;
		time ++ ;
		for (Integer n: nodes[index].next){
			if (prev == n) 	{
				continue;
			}
			int ans = dfs(nodes, n, visited, loop, index);
			min[index ] = Math.min(min[index ], ans);
			if (min[index] < arrival[index]){
				int[] arr = new int[]{n, index};
				Arrays.sort(arr);
				loop.add(arr[0] + arr[1] * nodes.length);				
			}
		}
		return arrival[index];
	}
}


public class Answer {
	public static void main(String[] args) {
		System.out.println("print");
	}
}
