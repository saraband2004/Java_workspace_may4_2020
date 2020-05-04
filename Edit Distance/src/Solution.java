import java.io.*; 
import java.util.*; 
import java.lang.*;


public class Solution {
    public boolean connect(String s, String t) {
    	return true;
    }
	
	public static int minDistance2(String word1, String word2) {
        int level = 0;
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(word1);
        set.add(word1);
        //List<String> list;
        int size;
        String temp;
        while (!queue.isEmpty()) {
        	size = queue.size();
        	while (size > 0) {
        		temp= queue.poll();
        		if (temp.compareTo(word2) == 0) {return level;}
        		for (String str: strlist(temp)) {
        			if (!set.contains(str)) {
        				queue.offer(str);
        				set.add(str);
        			}
        		}
        		size--;
        	}
        	level++;
        }
        
        return Integer.MAX_VALUE;
        
    }
	public static List<String> strlist(String ss){
		StringBuilder word=new StringBuilder(ss);
		ArrayList<String> list =new ArrayList<>();
		StringBuilder temp;
		for (int i=0; i < word.length(); i++) {
			temp=new StringBuilder(word);
			temp.deleteCharAt(i);
			list.add(temp.toString());
		}
		for (int i=0; i < word.length(); i++) {
			for (char a='a'; a<='z'; a++) {
				temp=new StringBuilder(word);
				temp.setCharAt(i, a);
				list.add(temp.toString());
			}
		}
		for (int i=0; i <= word.length(); i++) {
			for (char a='a'; a<='z'; a++) {
				temp=new StringBuilder(word);
				temp.insert(i, a);
				list.add(temp.toString());
			}
		}
		return list;
	}
	
	public static int minDistance(String word1, String word2) {
		HashSet<String> route = new HashSet<>();
		
		return DFS(word1, word2, route, Math.max(word1.length(),word2.length()));
	}
	
	
	public static int DFS(String word1, String word2, HashSet<String> route, int depth) {
		if (word1.compareTo(word2) == 0) {return 0;}
		if (depth <= 0) {
			if (word1.compareTo(word2) == 0) {return 0;}
			else {
				return word1.length() + word2.length();
			}
		}
		
		int min=Math.max(word1.length(), word2.length());
		
		List<String> list = strlist(word1);
		for (String word: list) {
			if (!route.contains(word)) {
				route.add(word);
				min=Math.min(min, 1+DFS(word, word2, route, depth-1));
				route.remove(word);
				depth=Math.min(min-1, depth);
			}
			
		}
		return min;
	}
	
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(minDistance("intention","execution"));
		
		
	}	

}
