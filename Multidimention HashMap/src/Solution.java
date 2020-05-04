import java.io.*; 
import java.util.*; 
import java.lang.*;

class MyHashMap<K,C>{
	public HashMap<K, HashMap> root;
	public MyHashMap() {
		root = new HashMap<K, HashMap> ();
	}
	public void put(K[] a, C val) {
		int index = 0;
		HashMap  <K, HashMap> mapping = root;
		HashMap  <K, C> lastmap = null;
		while (index < a.length) {
			if (index == a.length - 2) {
				if (mapping.containsKey(a[index])) {
					lastmap = mapping.get(a[index]);
				}
				else {
					mapping.put(a[index], new HashMap<K, C>());
					lastmap = mapping.get(a[index]);
				}
				index ++;
				continue;
			}
			if (index == a.length - 1) {
				lastmap.put(a[index],val);
				break;
			}
						
			if (mapping.containsKey(a[index])) {
				mapping = mapping.get(a[index]);
			}
			else {
				mapping.put(a[index], new HashMap<K, HashMap>());
				mapping = mapping.get(a[index]);
			}
			
			index ++;
		}
	}
	
	
	public boolean containsKey(K[] a) {
		int index = 0;
		HashMap  <K, HashMap> mapping = root;
		HashMap  <K, C> lastmap = null;
		while (index < a.length) {
			if (index == a.length - 2) {
				if (mapping.containsKey(a[index])) {
					lastmap = mapping.get(a[index]);
				}
				else {
					return false;
				}
				index ++;
				continue;
			}
			if (index == a.length - 1) {
				if (lastmap.containsKey(a[index])) {
					return true;
				}
				return false;
			}
						
			if (mapping.containsKey(a[index])) {
				mapping = mapping.get(a[index]);
			}
			else {
				return false;
			}
			
			index ++;
		}
		return false;
	}
	
	public C get(K[] a) {
		int index = 0;
		HashMap  <K, HashMap> mapping = root;
		HashMap  <K, C> lastmap = null;
		while (index < a.length) {
			if (index == a.length - 2) {
				if (mapping.containsKey(a[index])) {
					lastmap = mapping.get(a[index]);
				}
				else {
					return null;
				}
				index ++;
				continue;
			}
			if (index == a.length - 1) {
				if (lastmap.containsKey(a[index])){
					return lastmap.get(a[index]);
				}
				else {
					return null;
				}
				
			}
						
			if (mapping.containsKey(a[index])) {
				mapping = mapping.get(a[index]);
			}
			else {
				return null;
			}
			
			index ++;
		}
		return null;
	}
	
}



public class Solution {

    public int maxCoins(int[] nums) {
    	MyHashMap <Integer, Integer> [] map = new MyHashMap[nums.length + 1];
    	for (int i = 0; i <= nums.length ; i++) {
    		map[i] = new MyHashMap<Integer, Integer>();
    	}
    	Integer[] num = new Integer[nums.length];
    	for (int i=0; i<nums.length ; i++) {
    		num[i] = nums[i];
    		
    	}
    	return DFS(num, map);
    }
    
    public int DFS(Integer[] a, MyHashMap <Integer, Integer> [] map) {
    	if (a.length ==1 ) {return a[0];}
    	
    	if (map[a.length].containsKey(a)) {
    		return map[a.length].get(a);
    	}
    	int max = 0;
    	for (int index = 0; index < a.length ; index ++) {
    		Integer[] b = new Integer[a.length - 1];
    		int prod = a[index];
    		if (index!=0) {prod *= a[index - 1];}
    		if (index!=a.length -1 ) {prod *= a[index + 1];}
    		
    		int k = 0;
    		for (int i=0; i<a.length; i++) {
    			if (i == index) continue;
    			b[k ++ ] = a[i];
    		}
    		
    		max = Math.max(max, prod + DFS(b, map));
    	}
    	map[a.length].put(a, max);
    	
    	return max;
    }
    
    
    
    

	public static void main(String args[]) {
		
	//	HashMap<Integer, HashMap> map = new HashMap<>();
		Integer [] a = {1,3,5};
		MyHashMap<Integer, String> map = new MyHashMap();
		map.put(a, "this is a string");
		System.out.println(map.get(a));
		a = new Integer[]{3,3,5};
		System.out.println(map.get(a));
		a = new Integer[]{3,1,5};
		System.out.println(map.containsKey(a));
		int[]nums = {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5,5};
		System.out.println(new Solution().maxCoins(nums));
	}

}
